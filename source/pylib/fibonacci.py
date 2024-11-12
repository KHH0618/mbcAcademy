"""
피보나치 수열 관련 함수 (테스트 : fibonacci.py 100)
"""
def fibo_print(n):
    'n 미만의 피보나치 수열을 print ex) 0, 1, 1, 2, 3, 5,....'
    a, b = 0,1
    while a < n:
        print(a, end=' ')
        a, b = b, a+b
    print() #개행

def fibo_return(n):
    'n미만의 피보나치 수열의 리스트를 return'
    a, b = 0,1
    L = []
    while a < n:
        L.append(a)
        a, b = b, a+b
    return L

if __name__ == '__main__' :
    import sys
    # sys.argv : 명령행 인수
    if len(sys.argv) > 1 :
        print('1. print test :', end=' ')
        fibo_print(int(sys.argv[1]))
        print('2. return list test',fibo_return(int(sys.argv[1])))
    else :
        print('1. print test :', end=' ')
        fibo_print(int(100))
        print('2. return list test',fibo_return(100))