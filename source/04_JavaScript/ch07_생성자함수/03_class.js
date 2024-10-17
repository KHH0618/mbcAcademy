//class : ECMA script6
//caniuse.com를 이용해서 지원 브라우저를 확인
class Person{
    constructor(name, first, second){ //생성자 함수 이름은 무조건 constructor
        console.log('constructor');
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){
        return this.first + this.second;
    }
}
var hong = new Person('홍길동', 90, 65);
console.log(hong.name, hong.first, hong.second);
console.log(hong);
console.log(hong.sum());