# Mini proyecto 3.1 — Torneo de Twenty-One

## Entorno

- Visual Studio Code
- Metals
- Scala 2.12.21
- JDK 17
- sbt

## Descripción

Este mini proyecto analiza los resultados de varias manos de un torneo de Twenty-One. Verifica si los jugadores se han pasado de 21, calcula las manos válidas y determina la mejor puntuación usando condicionales, bucles `while` y bucles funcionales `foreach`.

## Estructura

- `build.sbt`: Contiene la configuración del proyecto y la versión de Scala (2.12.21).
- `src/main/scala/Main.scala`: Archivo principal con la lógica del torneo (funciones de análisis, bucles e iteradores).

## Funciones utilizadas

- `bust`: Determina si un jugador supera los 21 puntos.
- `estadoMano`: Devuelve "VALIDA" o "BUST" dependiendo de la puntuación.
- `mejorMano`: Compara dos manos y devuelve la mejor puntuación válida.

## Bucle `while` vs `foreach`

Para la primera ronda utilizamos un bucle **while**, el cual es un enfoque imperativo. Se requiere declarar un iterador `var i = 0` para poder avanzar por el array.

Para la segunda ronda utilizamos un **foreach**. Este se aproxima más al **estilo funcional**. Aunque simplifica la sintaxis al no necesitar controlar la condición de parada del bucle explícitamente, al tener que vincular el dato con otra lista de jugadores paralela, seguimos necesitando un contador mutable externo (`var indice = 0`) para poder acceder al nombre correcto.

## Ejecución

```bash
sbt compile
sbt run
