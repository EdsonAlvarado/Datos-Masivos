import scala.math.sqrt
import scala.io.StdIn.readLine
// Assessment 1/Practica 1
println("\n")
println("1. Desarrollar un algoritmo en scala que calcule el radio de un circulo")
val pi = 3.1416
var area = 28.27
var radio = sqrt(area/pi)
println("\n")
println("2. Desarrollar un algoritmo en scala que me diga si un numero es primo")
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
println("\n")

/*3*/ val bird = "tweet"
val greet = s"Estoy escribiendo un $bird"
/*4*/ val mensaje = "Hola Luke yo soy tu padre!"
mensaje slice (5,9)