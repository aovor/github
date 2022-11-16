print("사이버보안전공 19121021 오혜승")

import random
import string

alphabet1 = string.ascii_uppercase
alphabet2 = string.ascii_lowercase

random_word = alphabet1[random.randrange(26)] + \
              alphabet2[random.randrange(26)] + \
              alphabet2[random.randrange(26)] + \
              alphabet2[random.randrange(26)] + \
              alphabet2[random.randrange(26)]

print(random_word)
