// def isEven(num:Int): Boolean = {
//     return num%2 == 0
// }
// def isEven(num:Int): num%2 == 0
// println(isEven(6))
// println(isEven(3))


/*En el punto de esta funcion es determinar si el numero de la lista es par o impar desplegando texto para 
cada numero de la lista*/
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}

val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
listEvens(l)
listEvens(l2)

//3 7 afortunado

/*En esta funcion se utilizan los valores de la lista que son (1,7,7) agarra el primer valor que es 1
pero no cumple con la condicion entonces se aplica la operacion 0 = 0 + 1 (valor de n) prosigue con el
siguiente numero de la lista que es 7 en este caso si cumple con la condicion de n==7 entonces se aplica
la operacion pero en este caso el valor de res ahora es 1, entonces tenemos que res = 1+14 res ahora vale 15
procediendo con el ultimo valor de la lista que es 7 se repite el mismo proceso al cumplir la condicion
entonces ahora res vale 15 + 14 que da como resultado "29"*/
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}


val af= List(1,7,7)
println(afortunado(af))


/*Esta función lo que hace es que mediante un ciclo compara si los valores de las listas tienen un balance
 al sumarse entre si mismos y restarse su suma con cada uno de sus valores, si el resultado de la suma de
 los valores de una lista coincide con la resta de los valores de la lista a su suma entonces la función nos
 regresara el resultado de verdadero y terminara la comparación por ejemplo en la primera lista 
 en la primera corrida a la variable primera se le suma 3 y mantiene ese resultado, y la variable segunda
 tiene como valor inicial 6 y si se le restan los 3 de la lista (bl) nos quedan 3 y coinciden los valores de
 ambas variables entonces se clasifica como true, lo mismo pasa con la segunda lista (bl2) en su segunda 
 corrida pero nunca llega a pasar con la lista 3 (bl3)*/

def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}

val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)


/*Esta función toma una palabra y la voltea utilizando la operación reverse entonces la función evalua 3
palabras: oso, anna y juan, oso y anna nos regresan TRUE debido a que si son palindromos, en el caso de juan
nos regresa FALSE al no ser palindromo*/

def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
