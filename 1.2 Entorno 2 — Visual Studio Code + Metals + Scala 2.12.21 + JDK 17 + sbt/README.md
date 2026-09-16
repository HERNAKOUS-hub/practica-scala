# Entorno 1.2 — Visual Studio Code + Metals + sbt + Scala 2.12.21

## Objetivo

Preparar un entorno de desarrollo basado en el editor **Visual Studio Code**, utilizando la extensión **Metals** para proporcionar características avanzadas de IDE para Scala, y **sbt** como herramienta de construcción del proyecto.

---

## 1. Requisitos e instalación

Para configurar este entorno se parte de una instalación base de **Visual Studio Code** en **Windows 11** y se añaden las herramientas necesarias:

- **Java (JDK 17):** Previamente configurado en el sistema como requisito base.
- **Scala (Metals):** Extensión oficial instalada desde el Marketplace de VS Code para habilitar el soporte del lenguaje, autocompletado y análisis de código.

### Evidencias de instalación

- **Versión del sistema:**

  ![Versión de Visual Studio Code](images/01-vscode-version-sistema.png)

- **Extensión Metals instalada:**

  ![Extensión Scala Metals instalada](images/03-vscode-extension-metals-instalada.png)

---

## 2. Configuración del proyecto y sbt

Se creó la estructura de directorios estándar para un proyecto de Scala y se configuró la herramienta de construcción.

En la raíz del proyecto se creó el archivo `build.sbt` para definir las propiedades básicas y asegurar el uso de la versión exacta de Scala requerida para la práctica:

```scala
name := "scala-vscode"
scalaVersion := "2.12.21"
```

---

## 3. Verificación de la versión de Scala y ejecución de código

Dentro de la ruta `src/main/scala/` se creó el archivo `Main.scala` con un objeto de prueba para validar el correcto funcionamiento del entorno.

La compilación y ejecución se realizaron directamente desde la terminal integrada de Visual Studio Code utilizando los comandos de **sbt**:

**1. Compilación del proyecto:**

```bash
sbt compile
```

**2. Ejecución del código:**

```bash
sbt run
```

- Ejecución exitosa en la terminal.

---

## Incidencias y soluciones

Durante la configuración y prueba de este entorno surgió el siguiente inconveniente, que fue resuelto exitosamente:

### Comando `sbt` no reconocido en la terminal integrada

- **Problema:**  
  Al intentar ejecutar `sbt compile` en la terminal de PowerShell dentro de VS Code, el sistema devolvió el error:  
  `"El término 'sbt' no se reconoce como nombre de un cmdlet"`.

- **Solución:**  
  La ruta de los binarios instalados por Coursier no estaba expuesta al `PATH` de esa sesión de PowerShell. Se solucionó inyectando la ruta de la carpeta `bin` de Coursier directamente en la variable de entorno de la sesión actual:

```powershell
$env:PATH += ";C:\Users\HERNAN\AppData\Local\Coursier\data\bin"
```

Tras esto, `sbt` compiló y ejecutó el proyecto sin problemas.
