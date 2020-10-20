# Datos-Masivos
Repositorio de la materia

## Practice 1
First we need to import the following libraries

```
import scala.math.sqrt
import scala.io.StdIn.readLine
```

### Excersice 1
> In this excersice we calculate the radius of a circle
```
val pi = 3.1416
var area = 28.27
var radio = sqrt(area/pi)
```

### Excersice 2
> In this excersice we need to determine if a number is prime
```
var contador = 2
var primo = 1
println("Ingresa un numero... ")
val numero = scala.io.StdIn.readInt()

if (numero == 1 || numero == 0) {
	println("Es un numero primo")
} else {

while(primo == 1 && (contador!=numero)){
   if (numero % contador == 0){
   		primo = 0 
   }
   contador = contador+1
}

if (primo == 1){
	println("Es un numero primo")
} else {
	println("No es un numero primo")
}

}
```

### Excersice 3
> Here we use the string interpolation to display a string variable in a sentence
```
val bird = "tweet"
val greet = s"Estoy escribiendo un $bird"
```

### Excersice 4
> Here we use slice to extract a part of a sentence
```
val mensaje = "Hola Luke yo soy tu padre!"
mensaje slice (5,9)
```

### Excersice 5
> Here we describe the diference between a variable and a value in scala

 "Value" is Fixed and a "variable" can change its value

### Excersice 6
> In this excersice we need to find the value 3.1416 in a tuple
```
val mi_tupla = (2,4,5,1,2,3,3.1416,23)
mi_tupla._7
```


## Practice 2
> First we need to import the following library

```
import scala.collection.mutable.MutableList
```

### Excersice 1
> We're creating a list with 3 elements

```
val lista = List("rojo","blanco","negro")
```

### Excersice 2
> We're creating a list with more elements

```
val lista = List("rojo","blanco","negro","verde","amarillo","azul","naranja","perla")
```

### Excersice 3
> Then we need to retrieve the elements "verde", "amarillo", "azul"

```
lista slice (3, 6)
```


### Excersice 4
> Here we're creating an array in a range of (1 to 1000) with steps of 5 

```
Array.range(1, 1000, 5)
```

### Excersice 5
> Here we need to retrieve the unique elements of a list

```
val mylist = List(1,3,3,4,6,7,3,7)  
val newset = mylist.toSet
```

### Excersice 6
> Here we are creating a mutable map with some elements

```
val mutmap = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))
```

### Excersice 6a
> Then we print the keys of the map

```
mutmap.keys
```

### Excersice 7b
> We are adding a new element to the map

```
mutmap += ("Miguel" -> 23)
```


## Practice 3

### Excersice 1
> This function determines if the numbers of a list are odd or even and the displays them using a for loop

```
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
```

### Excersice 2
> Here we have a function that evaluates the numbers of a list using the for loop, if the number is 7 then an operation is executed, else another operation is executed and the results are being stored in a variable

```
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
```


### Excersice 3
> Here we have a function that evaluates if the numbers in 3 lists are balanced

```
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
```

### Excersice 4
> This function evaluates if a string is a palidrome

```
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
```
