# Mini proyecto 3.2 — Analizador de calificaciones

## Entorno

- IntelliJ IDEA Community
- Plugin de Scala
- Scala 2.12.21
- JDK 17
- sbt

## Descripción

Este programa es un analizador de calificaciones que recorre colecciones con estudiantes y sus notas, determinando el estado académico de cada uno, generando estadísticas del aula y comparando los resultados entre una primera y una segunda evaluación.

## Estructura

- `build.sbt`: Define los parámetros del proyecto sbt.
- `src/main/scala/Main.scala`: Lógica de análisis de las evaluaciones, comparaciones de grupo y manejo de listas.

## Funciones utilizadas

- `aprobado`: Evalúa si una nota es mayor o igual a 5 (devuelve `Boolean`).
- `estadoNota`: Llama a `aprobado` y devuelve un `String` legible ("APROBADO" / "SUSPENSO").
- `maxNota`: Compara dos notas dadas y devuelve la mayor.
- `clasificacion`: Categoriza la nota utilizando una estructura `if / else if / else`.

## Inmutabilidad de las Listas

En Scala, la estructura de datos `List` es **inmutable** por defecto. Por esta razón, cuando usamos el operador cons (`::`) en la línea `val nuevosEstudiantes = "Carlos" :: estudiantes`, no estamos modificando la lista original insertando a "Carlos", sino que estamos creando una lista completamente nueva en memoria. La lista `estudiantes` original permanece inalterada y segura frente a modificaciones accidentales.

## Ejecución

```bash
sbt compile
sbt run
