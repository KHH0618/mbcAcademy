# sample_pac/cd/c.py - ab/a.py 를 참조
from ..ab import a
# .. 상위폴더
# . 현제폴더
def nice():
    print('sample_pac/cd 안의 C모듈안의 nice')
    a.hello()