package baseballgame;

/*
 * 스윙을 사용하여 짠 숫자 야구 게임
 */

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class baseballgame extends JFrame {
	
	int number[] = new int[4];						//랜덤 4자리 숫자 담을 배열
	int number2[] = new int[4];						//정답은? 부분에 정답을 뜨게 하기 위한 변수들 number2,3,4
	String number3[] = new String[4];
	String number4;
	int answer, chance = 0;		//answer: 정답을 맞힐 수 있는 기회(5번), chance: 정답과 질문을 다 합친 모든 기회(20번)
	int num;					//입력한 숫자 4자리를 한 자리씩 저장하기 위해 쓰이는 변수
	int inputnum;				//입력한 숫자 4자리를 저장하는 변수
	int input[] = new int[4];	//입력한 숫자 4자리를 한 자리씩 저장하는 배열
	boolean end = true;			//정답을 맞혔는지 구분하기 위한 boolean
	boolean check = false;		//정답 체크박스를 눌렀는지 안 눌렀는지
	int ball, strike = 0;		//ball과 strike 횟수를 저장하기 위한 변수
	String result;				//숫자를 입력하고 나서 결과(nBnS)를 저장하는 변수
	String chancelist[] = new String[20];	//정답 혹은 질문을 하고 얻은 결과 저장하는 배열 
	ImageIcon basicbear;
	ImageIcon changebear;
	
	JLabel title;
	JLabel bear;
	JLabel bear2;
	JLabel text1;
	JLabel gameanswer;
	JLabel resultlabel;
	List resultlist;
	JButton okbtn;
	JButton introduceBtn;
	JCheckBox resultcheck;
	JTextField inputnumber;
	
	public baseballgame() {
			setTitle("숫자 야구 게임_OHS");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			menu(); //메뉴 만들기
			setSize(600, 600);
			setVisible(true);
			
			randomnumber(); //랜덤 숫자(4자리) 만들기
			start(); //화면(UI) 구성하고 기능 만들기
			
		}
	
	private void menu() {
		JMenuBar menu = new JMenuBar();
		JMenu newgame = new JMenu("새 게임");
		JMenuItem menuitem = new JMenuItem("새 게임");
		
		newgame.add(menuitem);
		MenuActionListener listener = new MenuActionListener();
		menuitem.addActionListener(listener);
		
		menu.add(newgame);
		setJMenuBar(menu);
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//새 게임을 선택하면 정답을 맞혔든 못 맞혔든, 기회가 남았든 안 남았든 게임을 처음부터 다시 시작
			randomnumber();
			inputnumber.setText("");
			strike=0;
			ball=0;
			chance=0;
			answer=0;
			gameanswer.setText("정답은?");
			inputnumber.requestFocus();
			resultlist.removeAll();
			resultlabel.setText("0B0S");
		}
	}
	
	public void randomnumber() {
		//랜덤 4자리 숫자(중복x) 생성
		number[0]=(int)(Math.random()*10);
		while(number[0] == 0) {
			number[0]=(int)(Math.random()*10);
		}
		number[1]=(int)(Math.random()*10);
		while(number[0] == number[1]) {
			number[1]=(int)(Math.random()*10);
		}
		number[2]=(int)(Math.random()*10);
		while(number[0] == number[2] || number[1] == number[2]) {
			number[2]=(int)(Math.random()*10);
		}
		number[3]=(int)(Math.random()*10);
		while(number[0] == number[3] || number[1] == number[3] || number[2] == number[3]) {
			number[3]=(int)(Math.random()*10);
		}
		
		//나중에 정답은? 부분에 정답을 출력하기 위한 코드
		for(int i = 0; i<4; i++) {
			number2[i] = number[i];
			number3[i] = Integer.toString(number2[i]);
		}
		number4 = Arrays.toString(number3);
	}
	
	public void start() {
		Container c = getContentPane();
		c.setLayout(null);
		
		//설명 버튼
		introduceBtn = new JButton("게임 규칙");
		introduceBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "1. 게임이 시작되면 네 자리의 숫자가 랜덤으로 정해집니다.\n"
						+"2. 랜덤으로 만들어진 네 자리의 숫자 중 첫 번째 자리의 수는 0이 아니며, 각 자리의 숫자들은 중복되지 않습니다.\n"
						+"3. 기회는 질문과 정답을 다 합쳐 스무 번 주어지고, 정답은 다섯 번만 입력할 수 있습니다.\n"
						+"4. 정답을 입력하고 싶을 땐 정답 부분에 체크한 후 확인을 눌러 주세요.", "규칙 설명", JOptionPane.ERROR_MESSAGE);
			}
		});
		c.add(introduceBtn);
		introduceBtn.setBounds(20, 20, 100, 20);
				
		//title 이미지
		ImageIcon titlepic = new ImageIcon("image/title.png");
		Image titleimg = titlepic.getImage();
		Image changetitle = titleimg.getScaledInstance(250, 55, Image.SCALE_SMOOTH); //이미지 사이즈 조절
		ImageIcon titlesize = new ImageIcon(changetitle);
		title = new JLabel(titlesize);
		c.add(title);
		title.setBounds(140, 10, 360, 50);
		
		//결과가 저장되는 List
		resultlist = new List();
		resultlist.setBounds(15, 130, 160, 340);
		c.add(resultlist);
		
		//계산 결과 JLabel
		text1 = new JLabel("계산 결과");
		c.add(text1);
		text1.setBounds(65, 110, 70, 15);
		
		//숫자 입력 전 야구하는 곰 이미지
		basicbear = new ImageIcon("image/one.png");
		Image basicimg = basicbear.getImage();
		Image changebasic = basicimg.getScaledInstance(180, 340, Image.SCALE_SMOOTH); //이미지 사이즈 조절
		ImageIcon basicsize = new ImageIcon(changebasic);
		bear = new JLabel(basicsize);
		c.add(bear);
		bear.setBounds(270, 130, 380, 340);
		
		//result 변수값을 출력해 줄 JLabel
		Font font1 = new Font("맑은 고딕", Font.BOLD, 60);
		resultlabel = new JLabel("0B0S");
		resultlabel.setFont(font1);
		c.add(resultlabel);
		resultlabel.setBounds(203, 70, 380, 340);
		
		//정답을 입력하는 것인지 아닌지 구분해 줄 JCheckBox
		Font font2 = new Font("맑은 고딕", Font.PLAIN, 15);
		resultcheck = new JCheckBox("정답");
		resultcheck.setFont(font2);
		c.add(resultcheck);
		resultcheck.setBounds(75, 472, 60, 60);
		resultcheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					check = true; //정답을 체크한 경우엔 check 변수에 true 값을 주어 질문과 정답을 구분한다
				}
				else
					check = false;
			}
		});
		
		//숫자를 입력할 JTextField
		inputnumber = new JTextField();
		c.add(inputnumber);
		inputnumber.setBounds(135, 495, 300, 20);
		
		//게임 종료 후 정답을 출력할 JLabel
		gameanswer = new JLabel("정답은?");
		c.add(gameanswer);
		gameanswer.setBounds(135, 470, 500, 30);
		
		//확인 버튼
		okbtn = new JButton("확인");
		c.add(okbtn);
		okbtn.setBounds(445, 495, 60, 20);
		okbtn.addActionListener(new btnActionListener());
	}
	
	class btnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int leng = inputnumber.getText().length();
			if(leng==4) { //입력한 숫자가 4자리일 때
				try {
					inputnum = Integer.parseInt(inputnumber.getText());
					
					num = inputnum; //입력한 숫자를 한 자리씩 input 배열에 넣는다
					input[0] = num / 1000;
					num = num % 1000;
					input[1] = num / 100;
					num = num % 100;
					input[2] = num / 10;
					num = num % 10;
					input[3] = num;
					
					//입력한 숫자에 1222, 1231과 같이 중복된 숫자가 있으면 경고 메시지
					if(input[0]==input[1] || input[0]==input[2] || input[0]==input[3] || input[1]==input[2] || input[1]==input[3] || input[2]==input[3]) {
						JOptionPane.showMessageDialog(null, "중복된 숫자는 입력할 수 없습니다!", "경고", JOptionPane.ERROR_MESSAGE);
						strike=0;
						ball=0;
						resultcheck.setSelected(false);
						inputnumber.requestFocus();
						inputnumber.setText("");
						return;
					} 
				} catch(NumberFormatException eeee) { //숫자가 아닌 문자를 입력했을 때 경고 메시지
					JOptionPane.showMessageDialog(null, "숫자만 입력할 수 있습니다!", "경고", JOptionPane.ERROR_MESSAGE);
					inputnumber.setText(""); //텍스트필드에 입력되어 있는 값을 지운다
					strike=0;
					ball=0;
					resultcheck.setSelected(false); //체크박스에 체크되어 있는 것을 삭제한다
					inputnumber.requestFocus();
					inputnumber.setText("");
					return;
				}
				
				if(check == false) { //정답을 체크하지 않고 확인을 누르면 기회만 소모된다
					if(input[0] == number[0])
						strike++;
					else if(input[0] == number[1] || input[0] == number[2] || input[0] == number[3])
						ball++;
					if(input[1] == number[1])
						strike++;
					else if(input[1] == number[0] || input[1] == number[2] || input[1] == number[3])
						ball++;
					if(input[2] == number[2])
						strike++;
					else if(input[2] == number[0] || input[2] == number[1] || input[2] == number[3])
						ball++;
					if(input[3] == number[3])
						strike++;
					else if(input[3] == number[0] || input[3] == number[1] || input[3] == number[2])
						ball++;
					
					result = inputnum+", "+ball+"B"+strike+"S";
					resultlist.add(result); //리스트에 결과값을 넣는다
					resultlabel.setText(ball+"B"+strike+"S");
					chance++;
					ball = 0;
					strike = 0;
					inputnumber.setText("");
					
					if(chance == 20 || answer == 5) { //만약 기회를 전부 소진하게 된다면
						gameanswer.setText("정답은? "+number4); //정답을 알려 주고
						//게임이 끝났음을 알리고 확인 다이얼로그를 이용해 사용자에게 다시 시작할 것인지 물어보기
						int restartresult = JOptionPane.showConfirmDialog(null, "기회를 모두 소진하셨습니다. 다시 하시겠습니까?", "END", JOptionPane.YES_NO_OPTION);
						if(restartresult == JOptionPane.CLOSED_OPTION) {
							System.exit(0); //만약 사용자가 선택을 하지 않고 선택창을 끄면 게임 자체가 꺼지도록
						}
						else if(restartresult == JOptionPane.YES_OPTION) { //사용자가 yes를 누르면 게임이 새로 시작할 수 있도록 한다
							randomnumber();
							inputnumber.setText("");
							strike=0;
							ball=0;
							chance=0;
							answer=0;
							resultcheck.setSelected(false);
							gameanswer.setText("정답은?");
							inputnumber.requestFocus();
							resultlist.removeAll();
							resultlabel.setText("0B0S");
						}
					}
				}
				else if(check == true) { //만약 사용자가 정답 버튼을 누르고 확인을 누른다면 정답과 질문 기회 모두 소모하고, 사용자가 입력한 숫자가 정답인지 확인
					if(number[0] == input[0] && number[1] == input[1] && number[2] == input[2] && number[3] == input[3]) {
						//정답일 경우
						result = inputnum+", "+"정답";
						resultlist.add(result);
						ball = 0;
						strike = 0;
						chance=0;
						answer=0;
						resultcheck.setSelected(false);
						bear.setVisible(false);
						
						gameanswer.setText("정답은? "+number4);
						
						changebear = new ImageIcon("image/two.png"); //곰 사진을 바꾸어 준다
						Image changeimg = changebear.getImage();
						Image bearchange = changeimg.getScaledInstance(180, 340, Image.SCALE_SMOOTH); //이미지 사이즈 조절
						ImageIcon changesize = new ImageIcon(bearchange);
						bear2 = new JLabel(changesize);
						add(bear2);
						bear2.setBounds(270, 130, 380, 340);
						
						//정답일 경우 기회가 남았더라도 게임을 끝내고 사용자에게 다시 할 것인지 물어본다
						int restartresult = JOptionPane.showConfirmDialog(null, "게임이 끝났습니다. 다시 하시겠습니까?", "END", JOptionPane.YES_NO_OPTION);
						if(restartresult == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						}
						else if(restartresult == JOptionPane.YES_OPTION) {
							randomnumber();
							inputnumber.setText("");
							strike=0;
							ball=0;
							chance=0;
							answer=0;
							gameanswer.setText("정답은?");
							resultcheck.setSelected(false);
							inputnumber.requestFocus();
							resultlist.removeAll();
							bear2.setVisible(false); //새로 시작하게 되면 bear2를 숨기고 bear 사진을 다시 불러온다
							bear.setVisible(true);
							resultlabel.setText("0B0S");
						}
					}
					
					else {
						//오답일 경우 사용자가 입력한 값과 오답이라는 결과값을 리스트에 저장한다
						result = inputnum+", "+"오답";
						resultlist.add(result);
						chance++;
						answer++;
						inputnumber.setText("");
						resultcheck.setSelected(false);
						
						ball = 0;
						strike = 0;
					}
					
					//기회를 다 쓰면 게임 종료 후 사용자에게 다시 시작할 것인지 물어본다
					if(chance == 20 || answer == 5) {
						gameanswer.setText("정답은? "+number4);
						int restartresult = JOptionPane.showConfirmDialog(null, "기회를 모두 소진하셨습니다. 다시 하시겠습니까?", "END", JOptionPane.YES_NO_OPTION);
						if(restartresult == JOptionPane.CLOSED_OPTION) {
							System.exit(0);
						}
						else if(restartresult == JOptionPane.YES_OPTION) {
							randomnumber();
							inputnumber.setText("");
							strike=0;
							ball=0;
							chance=0;
							answer=0;
							gameanswer.setText("정답은?");
							resultcheck.setSelected(false);
							inputnumber.requestFocus();
							resultlist.removeAll();
							resultlabel.setText("0B0S");
						}
					}
				}
			}
			else { //네 자리 미만 혹은 초과되는 숫자를 입력했을 때 뜨는 경고창
				JOptionPane.showMessageDialog(null, "네 자리의 숫자를 입력해 주세요!", "경고", JOptionPane.ERROR_MESSAGE);
				strike=0;
				ball=0;
				resultcheck.setSelected(false);
				inputnumber.requestFocus();
				inputnumber.setText("");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new baseballgame();
	}

}
