Date.prototype.getIntervalDay = function(date){
    if(date>this){
        var intervalMilliSec = date.getTime() - this.getTime();
    }else{
        var intervalMilliSec =this.getTime() - date.getTime();
    }
    return Math.trunc(intervalMilliSec/(1000*60*60*24));
}

var today = new Date();
var thatDay = new Date(2024,9,11, 14, 0, 0);
console.log(today.getIntervalDay(thatDay));
console.log(thatDay.getIntervalDay(today));