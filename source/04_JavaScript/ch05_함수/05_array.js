/*
array함수 : 매개변수 0 :  length가 0인 배열 리턴
            매개변수 1 :  length가 매개변수크기만큼 배열 리턴
            매개변수 2개이상 :  매개변수로 배열을 만들어 배열 리턴
*/
function array(){
    let result = [];
    // arguments(매개변수배열)라는 배열 자동 생성
    if(arguments.length == 0){
        return result;
    }else if(arguments.length == 1){
        for(let i = 0; i <= arguments[0]; i++){
            result.push(null);
        }
        return result;
    }else if(arguments.length >= 2){
        for(let i = 0; i < arguments.length; i++){
            result.push(arguments[i]);
        }
        return result;
    }
}


// console.log(array());
// console.log(array(3));
// console.log(array(3,4,5,6,1,2));
