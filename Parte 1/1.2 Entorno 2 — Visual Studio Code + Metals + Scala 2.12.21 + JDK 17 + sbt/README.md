# Entorno 1.2 — Visual Studio Code + Metals + sbt + Scala 2.12.21

## Objetivo
Preparar un entorno de desarrollo basado en Visual Studio Code, utilizando la extensión Metals y sbt.

## 1. Verificación de Versiones y Java

Comencé verificando la versión actual de Visual Studio Code instalada en mi sistema operativo.

![Versión del sistema y VS Code](IMG/vscode-version-sistema.png)

Al comprobar la versión de Java en el sistema, detecté que la versión inicial por defecto era la 21, lo cual podía generar problemas de compatibilidad.

![Verificación inicial de Java 21](IMG/verificacion-java-21-inicial.png)

Utilizando Coursier, forcé la instalación y el uso de JDK 17.

![Coursier instalando JDK 17](IMG/coursier-setup-jvm-17-completado.png)

Posteriormente, verifiqué que el cambio se había aplicado correctamente y el entorno ya apuntaba a Java 17.

![Verificación de JDK 17 activo](IMG/coursier-setup-jvm-17-verificacion.png)

## 2. Instalación de la Extensión Metals

Desde la sección de extensiones de Visual Studio Code busqué la extensión oficial de Scala (Metals).

![Búsqueda de la extensión Metals](IMG/vscode-extension-metals-busqueda.png)

Procedí a instalarla para habilitar las funcionalidades de autocompletado y validación de código.

![Extensión Metals instalada](IMG/vscode-extension-metals-instalada.png)

## 3. Configuración del Proyecto y sbt

Para inicializar el entorno, definí las dependencias en el archivo `build.sbt`, marcando explícitamente el uso de Scala 2.12.21.

![Configuración del archivo build.sbt](IMG/vscode-proyecto-y-build-sbt.png)

Creé la estructura de carpetas estándar (`src/main/scala`) y añadí el archivo principal del programa.

![Estructura del proyecto](IMG/vscode-estructura-proyecto-y-codigo-main.png)

En el archivo `Main.scala`, redacté el código básico para realizar la prueba de ejecución.

![Código en Main.scala](IMG/vscode-codigo-main-scala.png)

## 4. Resolución de problemas y Ejecución

Al intentar ejecutar `sbt`, me encontré con problemas de reconocimiento de comandos. Tras revisar la configuración, corregí las variables de entorno añadiendo la ruta correcta al PATH y realicé una prueba verificando sbt.

![Configuración del PATH de sbt](IMG/verificacion-java-17-y-configuracion-path-sbt.png)
![Verificación de Java 17 y sbt](IMG/verificacion-java-jdk17-y-prueba-sbt.png)

Finalmente, ejecuté los comandos `sbt compile` y `sbt run` en la terminal integrada de VS Code, compilando y mostrando los resultados correctamente.

![Terminal ejecutando compilación y run](IMG/vscode-terminal-sbt-compile-y-run.png)
