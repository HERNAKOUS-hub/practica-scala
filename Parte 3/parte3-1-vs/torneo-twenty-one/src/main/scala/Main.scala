object Main extends App {
  // 3.1.6 Datos iniciales
  val jugadores = List("Alex", "Chen", "Marta", "Sindhu", "Luis")
  val puntuaciones = Array(18, 24, 21, 20, 26)

  // 3.1.7 Función bust
  def bust(puntuacion: Int): Boolean = {
    puntuacion > 21
  }

  // 3.1.8 Función estadoMano
  def estadoMano(puntuacion: Int): String = {
    if (bust(puntuacion)) "BUST"
    else "VALIDA"
  }

  // 3.1.9 Función mejorMano
  def mejorMano(handA: Int, handB: Int): Int = {
    if (handA > 21 && handB > 21) 0
    else if (handA > 21) handB
    else if (handB > 21) handA
    else if (handA > handB) handA
    else handB
  }

  // 3.1.10 y 3.1.11 Procesamiento y estadísticas de la primera ronda
  println("--- Primera Ronda ---")
  var i = 0
  var validas1 = 0
  var busts1 = 0
  var mejor1 = 0

  while (i < puntuaciones.length) {
    val p = puntuaciones(i)
    val estado = estadoMano(p)
    println(jugadores(i) + " -> " + p + " -> " + estado)

    if (estado == "VALIDA") validas1 += 1 
    else busts1 += 1
    
    mejor1 = mejorMano(mejor1, p)
    i += 1
  }

  println("\n--- Resumen de la ronda ---")
  println("Jugadores: " + jugadores.length)
  println("Manos válidas: " + validas1)
  println("Bust: " + busts1)
  println("Mejor puntuación válida: " + mejor1)

  // 3.1.12 Segunda ronda (3.1.14 Uso de foreach)
  val puntuacionesRonda2 = Array(22, 19, 20, 21, 17)
  
  println("\n--- Segunda Ronda ---")
  var validas2 = 0
  var busts2 = 0
  var mejor2 = 0
  var indice = 0 // Variable mutable para seguir la posición de la lista en el foreach

  puntuacionesRonda2.foreach { p =>
    val estado = estadoMano(p)
    println(jugadores(indice) + " -> " + p + " -> " + estado)
    
    if (estado == "VALIDA") validas2 += 1 
    else busts2 += 1
    
    mejor2 = mejorMano(mejor2, p)
    indice += 1
  }

  // 3.1.13 Comparación de rondas
  println("\n--- Comparación final ---")
  println("Mejor puntuación de la primera ronda: " + mejor1)
  println("Mejor puntuación de la segunda ronda: " + mejor2)

  if (mejor1 > mejor2) {
    println("La primera ronda tuvo la mejor puntuación.")
  } else if (mejor2 > mejor1) {
    println("La segunda ronda tuvo la mejor puntuación.")
  } else {
    println("Ambas rondas tuvieron la misma mejor puntuación.")
  }
}