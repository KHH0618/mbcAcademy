from flask import  Flask, render_template
from flask import jsonify
from flask import Response, json
import cx_Oracle

app = Flask(__name__)

dsn = cx_Oracle.makedsn('localhost', 1521, 'xe')
conn = cx_Oracle.connect(user='dlow123', password='tmvjswl', dsn=dsn)

@app.route('/')
def get_emps():
    cursor = conn.cursor()
    sql = 'SELECT * FROM EMP'
    cursor.execute(sql)
    emps = cursor.fetchall()
    cursor.close()
    return render_template('emps.html', emps=emps)

@app.route('/detail_json/<ename>')
def json_response(ename):
    cursor = conn.cursor()
    sql = 'SELECT * FROM EMP WHERE ENAME=UPPER(:ename)'
    cursor.execute(sql, {'ename':ename})
    emps = cursor.fetchall()
    keys = [desc[0] for desc in cursor.description]
    cursor.close()
    result = {}
    if emps:
        for key, data in zip(keys, emps[0]):
            result[key] = data
        print(result)
        return jsonify(result)
    else:
        response = Response(json.dumps({'result':'없는 데이터입니다'}, ensure_ascii=False), mimetype='application/json')
        return response

if __name__=='__main__':
    app.run(debug=True)