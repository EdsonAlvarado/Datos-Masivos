//1
def fib(n:Int): Int={

        if(n<2){
           return n
        }else{
            return fib(n-1)+fib(n-2)
        }
  
}
fib(5)
fib(7)
fib(8)

import scala.math.sqrt
//2
def fib2(n:Double):Double={
    
    if(n<2){
    return n}
    var i: Double = ((1 + Math.sqrt(5)) / 2)
    var j: Double = 0
     j = ((Math.pow(i, n) - Math.pow((1 - i), n)) / Math.sqrt(5))
        return j   
    }   
{ 

//3
var a: Int = 0
var b: Int = 1
var c: Int = 0

def fib3(n: Int): Int = {
  
    for (k <- Range(0, n)){
        c = b + a
        a = b
        b = c 
    }

    return a
}