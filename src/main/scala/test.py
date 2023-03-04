#!python3.9

import sys
sys.path.append('/Users/sultanfaisal/IdeaProjects/pipe/site-packages')

import pyffx

e = pyffx.Integer(b'secret-key', length=5)


for line in sys.stdin:
    print(e.encrypt(int(line)))
