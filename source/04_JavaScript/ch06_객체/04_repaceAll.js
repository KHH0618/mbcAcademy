// var str = '안녕00방가00하이';
// console.log(str);
// var splitStr = str.split('00');
// console.log(splitStr);
// var result = splitStr.join('x');
// console.log(result);
const repaceAll = (str, oldStr, newStr) => {
    var splitStr = str.split(oldStr);
    return splitStr.join(newStr);
};