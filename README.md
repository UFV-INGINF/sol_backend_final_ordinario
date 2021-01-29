En este repositorio os dejo una pequeña solución para la lectura del fichero json que se daba como parámetro en el enunciado del examen práctico.

El código se encarga de leer el fichero y almacenarlo en una variable de memoria. Para confirmar que funciona, lo muestro completo por la consola.

A continuación, a partir de una dirección IP, la convierto en un long y recorro el JSON mediante un bucle while para que rompa la ejecución en el momento que encuentre la coincidencia. De esta forma, salvo que se encuentre en la última posición de la lista, nos ahorramos vueltas en el bucle.

Si encuentra una dirección en el rango, muestra por pantalla toda la información del objecto sin tratar por consola.
Si no lo encuentra, muestra un mensaje indicando que no existe.

Espero os ayude.
