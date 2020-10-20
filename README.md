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
