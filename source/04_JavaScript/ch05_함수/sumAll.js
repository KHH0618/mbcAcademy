function sumAll(){
    var sum = 0;
    if(arguments.length == 0){
        return -999;
    }else if(arguments.length >= 1){
        for(let i = 0; i<arguments.length; i++){
            sum += arguments[i];
        }
        return sum;
    }
}