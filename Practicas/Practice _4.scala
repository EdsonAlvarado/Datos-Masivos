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
    return n} else{
    var i: Double = ((1 + Math.sqrt(5)) / 2)
    var j: Double = 0
     j = ((Math.pow(i, n) - Math.pow((1 - i), n)) / Math.sqrt(5))
        return j   
    }   
}

//3

def fib3(n: Int): Int = {
var a: Int = 0
var b: Int = 1
var c: Int = 0

    for (k <- Range(0, n)){
        c = b + a
        a = b
        b = c 
    }

    return a
}

//4

def fib4(n: Int): Int = {

var d: Int = 0
var e: Int = 1

  
    for (k <- Range(0, n)){
        e = e + d
        d = e - d
    }

    return d
}

//5

def fib5(numero: Int): Int = {
    if (numero < 2) {
        return numero
    } else {
         var arreglo = new Array[Int](numero + 1)
         arreglo(0) = 0
         arreglo(1) = 1
         for (k <- Range(2, numero + 1)) {
            arreglo(k) = arreglo(k - 1) + arreglo(k - 2)
         }
         return arreglo(numero)
    }
}