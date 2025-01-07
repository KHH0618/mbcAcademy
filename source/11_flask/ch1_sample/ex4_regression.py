import pandas as pd
import statsmodels.api as sm
import joblib

df = pd.read_csv('../data/trade_apt_api.csv', encoding='cp949')
x = df[['건축년도','전용면적', '층']]
x = sm.add_constant(x)
y = df['거래금액']
model = sm.OLS(y, x).fit()
model.summary()
# 모델 저장
joblib.dump(model, '../model/ex1_apt_price_regression.plk')