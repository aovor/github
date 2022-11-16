print("사이버보안전공 19121021 오혜승")

import random
import string

alphabet = string.ascii_lowercase

random_word = alphabet[random.randrange(26)] + \
            alphabet[random.randrange(26)] + \
            alphabet[random.randrange(26)] + \
            alphabet[random.randrange(26)] + \
            alphabet[random.randrange(26)]

print(random_word)

print("-----------------------------")

import random
import string

alphabet = string.ascii_lowercase

random_word = alphabet[random.randrange(len(alphabet))] + \
              alphabet[random.randrange(len(alphabet))] + \
              alphabet[random.randrange(len(alphabet))] + \
              alphabet[random.randrange(len(alphabet))] + \
              alphabet[random.randrange(len(alphabet))]

print(random_word)
