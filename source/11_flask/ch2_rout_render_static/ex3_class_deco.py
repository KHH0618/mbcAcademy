class SmapleFlask:
    def __init__(self, arg=''):
        pass
    def check(self, func):
        def wrapper():
            print(func.__name__, '함수 전처리')
            func()
            print(func.__name__, '함수 후처리')
        return wrapper

app = SmapleFlask(__name__)

@app.check
def hello():
    print('hello')

if __name__=='__main__':
    hello()