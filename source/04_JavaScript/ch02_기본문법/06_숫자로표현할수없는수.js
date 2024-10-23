i = parseInt("");
console.log('i type : ' + typeof(i), ', 값 : ' + i);
a = 10/3;
console.log('a type : ' + typeof(a), ', 값 : ' + a);
a = 10/0;
console.log('a type : ' + typeof(a), ', 값 : ' + a);
console.log('i가 NaN인지 여부'+isNaN(i));
console.log('a가 NaN인지 여부'+isNaN(a));
console.log('a가 유한한 수인지 여부'+isFinite(a));
