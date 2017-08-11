# Pseudo Código de la estructura de un map reduce

´´´´
	map(fila) :void {
		emit(k, v) // Se le llama muchas veces  -> clave, valor lleva cualquier cosa
	}

	reduce(k,, I[v]):void

´´´´

http://spark.apache.org/docs/latest/programming-guide.html
http://spark.apache.org/docs/latest/programming-guide.html#transformations

´´´´

	map(fila) {
		
		foreach(palabra: fila.split(" ")) {
			emit(fila)
		}
	}

	reduce(k,, I[v]):void {
		return sum(vs)
	}

´´´´
