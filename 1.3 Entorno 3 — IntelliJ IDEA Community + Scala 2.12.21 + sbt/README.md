# Entorno 1.3 — IntelliJ IDEA Community + sbt + Scala 2.12.21

## Objetivo

Preparar un entorno de desarrollo integrado (IDE) utilizando **IntelliJ IDEA Community Edition**, configurando el soporte para el lenguaje mediante el plugin oficial de **Scala** y utilizando **sbt** como sistema de construcción de proyectos.

---

## 1. Requisitos e instalación

Para configurar este entorno se descargó e instaló el IDE y se le añadió el soporte específico para Scala:

- **IntelliJ IDEA:** Descarga de la versión **Community Edition (2023.3.8)**.
- **Plugin de Scala:** Instalado directamente desde el Marketplace en la pantalla de bienvenida del IDE para habilitar el soporte completo del lenguaje.

---

## 2. Configuración del proyecto y JDK

Se procedió a crear un nuevo proyecto configurando las herramientas de compilación y el entorno de ejecución de Java:

1. **Creación del proyecto:** Se configuró un nuevo proyecto (`scala-intellij`) seleccionando **sbt** como sistema de construcción (Build system).
2. **Descarga del JDK:** Desde el propio asistente de IntelliJ se descargó e instaló automáticamente **Microsoft OpenJDK 17** para asegurar la compatibilidad.

---

## 3. Verificación de la versión de Scala y ejecución de código

Una vez generado el proyecto, se escribió el código de prueba en el archivo `Main.scala` y se comprobó su correcta compilación y ejecución.

La compilación y ejecución se realizaron mediante la interfaz gráfica del IDE (botón **Run**), obteniendo un resultado exitoso con exit code 0.

---

## Incidencias y soluciones

Durante las pruebas de compilación manual a través de línea de comandos en este entorno, surgió el siguiente inconveniente:

### Comandos `sbt` y `cs` no reconocidos en la terminal local de IntelliJ

- **Problema:**  
  Al intentar ejecutar `sbt compile` desde la pestaña **Terminal** (que lanza la sesión de PowerShell de Windows), el sistema arrojó errores indicando que los comandos no eran reconocidos, debido a la ausencia de rutas en el `PATH`.

- **Solución:**  
  En lugar de modificar el `PATH` general o usar la PowerShell local, se utilizó la **consola sbt interactiva** (sbt shell) proporcionada de forma nativa por IntelliJ IDEA. Desde allí, los comandos `compile` y `run` se ejecutaron directamente con éxito sobre el entorno integrado del proyecto.
