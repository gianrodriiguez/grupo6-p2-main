La clase Main es la clase de inicio del programa. Permite al usuario interactuar con las opciones del programa y realizar sus consultas.

f1_dataset : Ruta del conjunto de datos CSV de Fórmula 1.

drivers: Ruta del archivo de texto que contiene los datos de los pilotos.

pilotos (ListaEnlazada<String>): Lista enlazada que almacena los pilotos.

tweets (ListaEnlazada<Tweet>): Lista enlazada que almacena los tweets - objetos Tweet.

usuarios (HashTableImpl<Long, User>): Tabla Hash que almacena los usuarios - objetos User.

mismaFecha(Date date1, Date fechaSeleccionada) : Compara mes y año de dos fechas

mismoMes(Date date1, Date fechaSeleccionada): COmpara solo mes de dos fechas

convertirAFecha(String year, String month): convierte dos strings en una fecha con ese mes y año que recibe

getDriversFromFile(): Carga los datos de los pilotos desde el archivo de texto.

getUsersInfo(): Carga los datos de los tweets desde el conjunto de datos CSV.

cantidadHashtagsDistintos(): Cuenta la cantidad de hashtags diferentes en una fecha dada.

HashtagMasUsado():Obtiene el hashtag más utilizado en una fecha dada.

TopUsuariosConMasTweets(): Muestra los 15 usuarios con más tweets.

TweetsConPalabraFraseEspecifica(): Cuenta la cantidad de tweets que contienen una palabra o frase específica.
