from flask import Flask, render_template, request
app = Flask(__name__, template_folder='templates', static_folder='static')

@app.route('/', methods=['GET', 'post'])
def dansu():
    if request.method == 'GET':
        number = ''
    else:
        number = request.form['number']
    return render_template('2_quiz.html', number=number)


if __name__ == '__main__':
    app.run()