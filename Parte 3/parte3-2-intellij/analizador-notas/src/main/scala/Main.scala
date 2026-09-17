object Main extends App {
  // 3.2.3 Datos iniciales
  val estudiantes = List("Ana", "Luis", "Marta", "Pedro", "Sofia")
  val notas = Array(8, 4, 10, 6, 3)

  // 3.2.7 Función aprobado
  def aprobado(nota: Int): Boolean = {
    if (nota >= 5) true else false
  }

  // 3.2.8 Función estadoNota
  def estadoNota(nota: Int): String = {
    if (aprobado(nota)) "APROBADO" else "SUSPENSO"
  }

  // 3.2.9 Función maxNota
  def maxNota(a: Int, b: Int): Int = {
    if (a > b) a else b
  }

  // 3.2.10 y 3.2.11 Listado de estudiantes y estadísticas
  println("--- Listado de notas ---")
  var i = 0
  var aprobados1 = 0
  var suspensos1 = 0
  var mejor1 = 0

  while (i < notas.length) {
    val n = notas(i)
    println(estudiantes(i) + " -> " + n + " -> " + estadoNota(n))

    if (estadoNota(n) == "APROBADO") aprobados1 += 1
    else suspensos1 += 1

    mejor1 = maxNota(mejor1, n)
    i += 1
  }

  println("\n--- Resumen del grupo ---")
  println("Estudiantes: " + estudiantes.length)
  println("Aprobados: " + aprobados1)
  println("Suspensos: " + suspensos1)
  println("Mejor nota: " + mejor1)

  // 3.2.12 Clasificación adicional
  def clasificacion(nota: Int): String = {
    if (nota >= 9) "EXCELENTE"
    else if (nota >= 7) "NOTABLE"
    else if (nota >= 5) "APROBADO"
    else "SUSPENSO"
  }

  println("\n--- Clasificación Detallada ---")
  var j = 0
  while (j < notas.length) {
    println(estudiantes(j) + " -> " + notas(j) + " -> " + clasificacion(notas(j)))
    j += 1
  }

  // 3.2.13 y 3.2.14 Segunda evaluación
  println("\n--- Segunda Evaluación ---")
  val notasSegundaEvaluacion = Array(9, 5, 8, 7, 6)

  var k = 0
  var aprobados2 = 0
  var mejor2 = 0

  while (k < notasSegundaEvaluacion.length) {
    val n = notasSegundaEvaluacion(k)
    if (estadoNota(n) == "APROBADO") aprobados2 += 1
    mejor2 = maxNota(mejor2, n)
    k += 1
  }

  println("\n--- Comparación de evaluaciones ---")
  println("Mejor nota de la primera evaluación: " + mejor1)
  println("Mejor nota de la segunda evaluación: " + mejor2)
  println("Número de aprobados de la primera: " + aprobados1)
  println("Número de aprobados de la segunda: " + aprobados2)

  if (aprobados2 > aprobados1) {
    println("El grupo ha mejorado.")
  } else if (aprobados2 < aprobados1) {
    println("El grupo ha empeorado.")
  } else {
    println("El grupo se ha mantenido igual.")
  }

  // 3.2.15 Uso de listas
  println("\n--- Uso de listas y :: ---")
  val nuevosEstudiantes = "Carlos" :: estudiantes
  println("Lista original: " + estudiantes)
  println("Lista nueva: " + nuevosEstudiantes)
}