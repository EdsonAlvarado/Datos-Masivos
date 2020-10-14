def fib1(numero:Int): Int = {

	if (numero < 2) {
		return numero
	} else {
		return fib1(numero - 1) + fib1(numero - 2)
	}
}

fib1(7)