package baseballgame;

/*
 * ������ ����Ͽ� § ���� �߱� ����
 */

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class baseballgame extends JFrame {
	
	int number[] = new int[4];						//���� 4�ڸ� ���� ���� �迭
	int number2[] = new int[4];						//������? �κп� ������ �߰� �ϱ� ���� ������ number2,3,4
	String number3[] = new String[4];
	String number4;
	int answer, chance = 0;		//answer: ������ ���� �� �ִ� ��ȸ(5��), chance: ����� ������ �� ��ģ ��� ��ȸ(20��)
	int num;					//�Է��� ���� 4�ڸ��� �� �ڸ��� �����ϱ� ���� ���̴� ����
	int inputnum;				//�Է��� ���� 4�ڸ��� �����ϴ� ����
	int input[] = new int[4];	//�Է��� ���� 4�ڸ��� �� �ڸ��� �����ϴ� �迭
	boolean end = true;			//������ �������� �����ϱ� ���� boolean
	boolean check = false;		//���� üũ�ڽ��� �������� �� ��������
	int ball, strike = 0;		//ball�� strike Ƚ���� �����ϱ� ���� ����
	String result;				//���ڸ� �Է��ϰ� ���� ���(nBnS)�� �����ϴ� ����
	String chancelist[] = new String[20];	//���� Ȥ�� ������ �ϰ� ���� ��� �����ϴ� �迭 
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
			setTitle("���� �߱� ����_OHS");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			menu(); //�޴� �����
			setSize(600, 600);
			setVisible(true);
			
			randomnumber(); //���� ����(4�ڸ�) �����
			start(); //ȭ��(UI) �����ϰ� ��� �����
			
		}
	
	private void menu() {
		JMenuBar menu = new JMenuBar();
		JMenu newgame = new JMenu("�� ����");
		JMenuItem menuitem = new JMenuItem("�� ����");
		
		newgame.add(menuitem);
		MenuActionListener listener = new MenuActionListener();
		menuitem.addActionListener(listener);
		
		menu.add(newgame);
		setJMenuBar(menu);
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//�� ������ �����ϸ� ������ ������ �� ������, ��ȸ�� ���ҵ� �� ���ҵ� ������ ó������ �ٽ� ����
			randomnumber();
			inputnumber.setText("");
			strike=0;
			ball=0;
			chance=0;
			answer=0;
			gameanswer.setText("������?");
			inputnumber.requestFocus();
			resultlist.removeAll();
			resultlabel.setText("0B0S");
		}
	}
	
	public void randomnumber() {
		//���� 4�ڸ� ����(�ߺ�x) ����
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
		
		//���߿� ������? �κп� ������ ����ϱ� ���� �ڵ�
		for(int i = 0; i<4; i++) {
			number2[i] = number[i];
			number3[i] = Integer.toString(number2[i]);
		}
		number4 = Arrays.toString(number3);
	}
	
	public void start() {
		Container c = getContentPane();
		c.setLayout(null);
		
		//���� ��ư
		introduceBtn = new JButton("���� ��Ģ");
		introduceBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "1. ������ ���۵Ǹ� �� �ڸ��� ���ڰ� �������� �������ϴ�.\n"
						+"2. �������� ������� �� �ڸ��� ���� �� ù ��° �ڸ��� ���� 0�� �ƴϸ�, �� �ڸ��� ���ڵ��� �ߺ����� �ʽ��ϴ�.\n"
						+"3. ��ȸ�� ������ ������ �� ���� ���� �� �־�����, ������ �ټ� ���� �Է��� �� �ֽ��ϴ�.\n"
						+"4. ������ �Է��ϰ� ���� �� ���� �κп� üũ�� �� Ȯ���� ���� �ּ���.", "��Ģ ����", JOptionPane.ERROR_MESSAGE);
			}
		});
		c.add(introduceBtn);
		introduceBtn.setBounds(20, 20, 100, 20);
				
		//title �̹���
		ImageIcon titlepic = new ImageIcon("image/title.png");
		Image titleimg = titlepic.getImage();
		Image changetitle = titleimg.getScaledInstance(250, 55, Image.SCALE_SMOOTH); //�̹��� ������ ����
		ImageIcon titlesize = new ImageIcon(changetitle);
		title = new JLabel(titlesize);
		c.add(title);
		title.setBounds(140, 10, 360, 50);
		
		//����� ����Ǵ� List
		resultlist = new List();
		resultlist.setBounds(15, 130, 160, 340);
		c.add(resultlist);
		
		//��� ��� JLabel
		text1 = new JLabel("��� ���");
		c.add(text1);
		text1.setBounds(65, 110, 70, 15);
		
		//���� �Է� �� �߱��ϴ� �� �̹���
		basicbear = new ImageIcon("image/one.png");
		Image basicimg = basicbear.getImage();
		Image changebasic = basicimg.getScaledInstance(180, 340, Image.SCALE_SMOOTH); //�̹��� ������ ����
		ImageIcon basicsize = new ImageIcon(changebasic);
		bear = new JLabel(basicsize);
		c.add(bear);
		bear.setBounds(270, 130, 380, 340);
		
		//result �������� ����� �� JLabel
		Font font1 = new Font("���� ���", Font.BOLD, 60);
		resultlabel = new JLabel("0B0S");
		resultlabel.setFont(font1);
		c.add(resultlabel);
		resultlabel.setBounds(203, 70, 380, 340);
		
		//������ �Է��ϴ� ������ �ƴ��� ������ �� JCheckBox
		Font font2 = new Font("���� ���", Font.PLAIN, 15);
		resultcheck = new JCheckBox("����");
		resultcheck.setFont(font2);
		c.add(resultcheck);
		resultcheck.setBounds(75, 472, 60, 60);
		resultcheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					check = true; //������ üũ�� ��쿣 check ������ true ���� �־� ������ ������ �����Ѵ�
				}
				else
					check = false;
			}
		});
		
		//���ڸ� �Է��� JTextField
		inputnumber = new JTextField();
		c.add(inputnumber);
		inputnumber.setBounds(135, 495, 300, 20);
		
		//���� ���� �� ������ ����� JLabel
		gameanswer = new JLabel("������?");
		c.add(gameanswer);
		gameanswer.setBounds(135, 470, 500, 30);
		
		//Ȯ�� ��ư
		okbtn = new JButton("Ȯ��");
		c.add(okbtn);
		okbtn.setBounds(445, 495, 60, 20);
		okbtn.addActionListener(new btnActionListener());
	}
	
	class btnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int leng = inputnumber.getText().length();
			if(leng==4) { //�Է��� ���ڰ� 4�ڸ��� ��
				try {
					inputnum = Integer.parseInt(inputnumber.getText());
					
					num = inputnum; //�Է��� ���ڸ� �� �ڸ��� input �迭�� �ִ´�
					input[0] = num / 1000;
					num = num % 1000;
					input[1] = num / 100;
					num = num % 100;
					input[2] = num / 10;
					num = num % 10;
					input[3] = num;
					
					//�Է��� ���ڿ� 1222, 1231�� ���� �ߺ��� ���ڰ� ������ ��� �޽���
					if(input[0]==input[1] || input[0]==input[2] || input[0]==input[3] || input[1]==input[2] || input[1]==input[3] || input[2]==input[3]) {
						JOptionPane.showMessageDialog(null, "�ߺ��� ���ڴ� �Է��� �� �����ϴ�!", "���", JOptionPane.ERROR_MESSAGE);
						strike=0;
						ball=0;
						resultcheck.setSelected(false);
						inputnumber.requestFocus();
						inputnumber.setText("");
						return;
					} 
				} catch(NumberFormatException eeee) { //���ڰ� �ƴ� ���ڸ� �Է����� �� ��� �޽���
					JOptionPane.showMessageDialog(null, "���ڸ� �Է��� �� �ֽ��ϴ�!", "���", JOptionPane.ERROR_MESSAGE);
					inputnumber.setText(""); //�ؽ�Ʈ�ʵ忡 �ԷµǾ� �ִ� ���� �����
					strike=0;
					ball=0;
					resultcheck.setSelected(false); //üũ�ڽ��� üũ�Ǿ� �ִ� ���� �����Ѵ�
					inputnumber.requestFocus();
					inputnumber.setText("");
					return;
				}
				
				if(check == false) { //������ üũ���� �ʰ� Ȯ���� ������ ��ȸ�� �Ҹ�ȴ�
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
					resultlist.add(result); //����Ʈ�� ������� �ִ´�
					resultlabel.setText(ball+"B"+strike+"S");
					chance++;
					ball = 0;
					strike = 0;
					inputnumber.setText("");
					
					if(chance == 20 || answer == 5) { //���� ��ȸ�� ���� �����ϰ� �ȴٸ�
						gameanswer.setText("������? "+number4); //������ �˷� �ְ�
						//������ �������� �˸��� Ȯ�� ���̾�α׸� �̿��� ����ڿ��� �ٽ� ������ ������ �����
						int restartresult = JOptionPane.showConfirmDialog(null, "��ȸ�� ��� �����ϼ̽��ϴ�. �ٽ� �Ͻðڽ��ϱ�?", "END", JOptionPane.YES_NO_OPTION);
						if(restartresult == JOptionPane.CLOSED_OPTION) {
							System.exit(0); //���� ����ڰ� ������ ���� �ʰ� ����â�� ���� ���� ��ü�� ��������
						}
						else if(restartresult == JOptionPane.YES_OPTION) { //����ڰ� yes�� ������ ������ ���� ������ �� �ֵ��� �Ѵ�
							randomnumber();
							inputnumber.setText("");
							strike=0;
							ball=0;
							chance=0;
							answer=0;
							resultcheck.setSelected(false);
							gameanswer.setText("������?");
							inputnumber.requestFocus();
							resultlist.removeAll();
							resultlabel.setText("0B0S");
						}
					}
				}
				else if(check == true) { //���� ����ڰ� ���� ��ư�� ������ Ȯ���� �����ٸ� ����� ���� ��ȸ ��� �Ҹ��ϰ�, ����ڰ� �Է��� ���ڰ� �������� Ȯ��
					if(number[0] == input[0] && number[1] == input[1] && number[2] == input[2] && number[3] == input[3]) {
						//������ ���
						result = inputnum+", "+"����";
						resultlist.add(result);
						ball = 0;
						strike = 0;
						chance=0;
						answer=0;
						resultcheck.setSelected(false);
						bear.setVisible(false);
						
						gameanswer.setText("������? "+number4);
						
						changebear = new ImageIcon("image/two.png"); //�� ������ �ٲپ� �ش�
						Image changeimg = changebear.getImage();
						Image bearchange = changeimg.getScaledInstance(180, 340, Image.SCALE_SMOOTH); //�̹��� ������ ����
						ImageIcon changesize = new ImageIcon(bearchange);
						bear2 = new JLabel(changesize);
						add(bear2);
						bear2.setBounds(270, 130, 380, 340);
						
						//������ ��� ��ȸ�� ���Ҵ��� ������ ������ ����ڿ��� �ٽ� �� ������ �����
						int restartresult = JOptionPane.showConfirmDialog(null, "������ �������ϴ�. �ٽ� �Ͻðڽ��ϱ�?", "END", JOptionPane.YES_NO_OPTION);
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
							gameanswer.setText("������?");
							resultcheck.setSelected(false);
							inputnumber.requestFocus();
							resultlist.removeAll();
							bear2.setVisible(false); //���� �����ϰ� �Ǹ� bear2�� ����� bear ������ �ٽ� �ҷ��´�
							bear.setVisible(true);
							resultlabel.setText("0B0S");
						}
					}
					
					else {
						//������ ��� ����ڰ� �Է��� ���� �����̶�� ������� ����Ʈ�� �����Ѵ�
						result = inputnum+", "+"����";
						resultlist.add(result);
						chance++;
						answer++;
						inputnumber.setText("");
						resultcheck.setSelected(false);
						
						ball = 0;
						strike = 0;
					}
					
					//��ȸ�� �� ���� ���� ���� �� ����ڿ��� �ٽ� ������ ������ �����
					if(chance == 20 || answer == 5) {
						gameanswer.setText("������? "+number4);
						int restartresult = JOptionPane.showConfirmDialog(null, "��ȸ�� ��� �����ϼ̽��ϴ�. �ٽ� �Ͻðڽ��ϱ�?", "END", JOptionPane.YES_NO_OPTION);
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
							gameanswer.setText("������?");
							resultcheck.setSelected(false);
							inputnumber.requestFocus();
							resultlist.removeAll();
							resultlabel.setText("0B0S");
						}
					}
				}
			}
			else { //�� �ڸ� �̸� Ȥ�� �ʰ��Ǵ� ���ڸ� �Է����� �� �ߴ� ���â
				JOptionPane.showMessageDialog(null, "�� �ڸ��� ���ڸ� �Է��� �ּ���!", "���", JOptionPane.ERROR_MESSAGE);
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
