import scala.collection.mutable.MutableList
//Practice 2
// 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
val lista = List("rojo","blanco","negro")

// 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
val lista = List("rojo","blanco","negro","verde","amarillo","azul","naranja","perla")

// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
lista slice (3, 6)
// 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
Array.range(1, 1000, 5)
