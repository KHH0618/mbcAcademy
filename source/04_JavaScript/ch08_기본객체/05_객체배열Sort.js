function Student(name, kor, mat){
    this.kor = kor;
    this.name = name;
    this.mat = mat;
};
Student.prototype.getSum = function(){
    return this.mat+this.kor;
};
Student.prototype.toString = function(){
    return this.name + '('+this.kor+','+this.mat+','+this.getSum()+')'
};

var students = [
    new Student('홍',99,99),
    new Student('박',54,44),
    new Student('윤',48,52),
    new Student('김',89,39),
];

var studentCopy = [...students];

studentCopy.sort((left, right)=>{
    return right.getSum() - left.getSum();
});
console.log('원본');
students.forEach((data, idx)=>{
    console.log(idx + ' - ' + data);
});
console.log('복사본');
studentCopy.forEach((data, idx) => {
    console.log((idx+1) + '등 : ' + data);
});