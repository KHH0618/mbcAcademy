import schedule
import time

def job():
    print('작업 실행 되었습니다')
    
# job 함수는 10초마다 수행 할 꺼야
schedule.every(10).seconds.do(job)

# schedule.every().day.at('17:55').do(job)
# schedule.every().hour.do(job)
# schedule.every().minutes.do(job)

# 무한 루프를 돌며 스케쥴된 작업이 있는지 확인하고 자동화
while True:
    schedule.run_pending()
    time.sleep(1)