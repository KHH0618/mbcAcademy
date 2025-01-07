import joblib

loaded_model = joblib.load('../model/ex1_apt_price_regression.plk')
def predict_apt_price(year, square, floor):
    input_data = [[1, int(year), int(square), int(floor)]]
    pred = loaded_model.predict(input_data)[0]
    return format(round(pred*10000), ',') + '원입니다'

if __name__=='__main__':
    year = input('몇년?')
    square = input('전용면적(제곱미터)?')
    floor = input('몇층?')
    print(predict_apt_price(year, square, floor))
