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
println("3. Dada la variable bird = tweet, utiliza interpolacion de string para imprimir Estoy escribiendo un tweet")
val tw = "tweet"
println(s"Estoy escribiendo un $tw\n")
println("4. Dada la variable mensaje = Hola Luke yo soy tu padre utiliza slilce para extraer la secuencia Luke")
val oracion = "Hola Luke yo soy tu padre!"
oracion slice (5, 9)
println("\n")
println("5. Cual es la diferencia entre value y una variable en scala?")
println("El valor de value es fijo y el de var si puede cambiar.")
println("\n")
println("6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416") 
val mi_tupla = (2,4,5,1,2,3,3.1416,23)
mi_tupla._7