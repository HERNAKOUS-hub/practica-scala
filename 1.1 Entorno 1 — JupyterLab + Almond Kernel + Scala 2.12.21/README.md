# Práctica de programación básica con Scala

Documentación técnica de la configuración y verificación de tres entornos de desarrollo independientes para trabajar con **Scala 2.12.21** en **Windows 11**.

## Autor

**Nombre y apellidos:** Hernán

---

## Objetivo

Preparar tres entornos de trabajo independientes para el desarrollo con Scala, demostrar su correcta configuración y verificar la capacidad de ejecutar código en cada uno de ellos.

---

## Tecnologías utilizadas

| Tecnología              | Versión                          | Descripción                                      |
|-------------------------|----------------------------------|--------------------------------------------------|
| Sistema operativo       | Windows 11                       | Entorno base de ejecución                        |
| Scala                   | 2.12.21                          | Lenguaje de programación                         |
| Java                    | JDK 17 (Microsoft OpenJDK / Temurin) | Runtime y compilador Java                     |
| Coursier                | `cs`                             | Gestor de dependencias y herramientas            |
| sbt                     | —                                | Herramienta de construcción y gestión de proyectos |
| Almond Kernel           | —                                | Kernel de Scala para Jupyter                     |
| JupyterLab              | —                                | Entorno de notebooks interactivos                |
| Visual Studio Code      | —                                | Editor de código con extensión Metals            |
| IntelliJ IDEA Community | 2023.3.8                         | IDE completo con plugin oficial de Scala         |

---

## Requisitos previos

- Sistema operativo **Windows 11**.
- Acceso a terminal (PowerShell o similar).
- Conexión a Internet para la descarga de herramientas y dependencias.
- Cuenta de GitHub (para el control de versiones final).

---

## Parte 1 — Entornos de trabajo

### Entorno 1.1 — JupyterLab + Almond Kernel + Scala 2.12.21

#### 1. Requisitos e instalación

Para habilitar el soporte de Scala dentro de JupyterLab se configuró el entorno de ejecución de Java y se utilizó **Coursier** como gestor.

**Configuración del entorno con JDK 17:**

```bash
cs setup --jvm 17
```

**Instalación del kernel de Almond vinculado a Scala 2.12.21:**

```bash
cs launch --fork almond --scala 2.12.21 -- --install
```

#### 2. Verificación y ejecución

Tras iniciar JupyterLab (`jupyter lab`), se comprobó que el Launcher reconocía de forma nativa el kernel de Scala. Se creó un Notebook donde se ejecutaron pruebas de validación:

- Comprobación de versión (saludo con variables).
- Operaciones numéricas.
- Creación de colecciones (`List`).

Código de prueba ejecutado:

```scala
val a = 10
val b = 20
val resultado = a + b
println(s"Resultado: $resultado")
```

---

### Entorno 1.2 — Visual Studio Code + Metals + sbt

#### 1. Requisitos e instalación

Se preparó **VS Code** como editor de código ligero con soporte avanzado para Scala:

- Instalación de la extensión **Scala (Metals)** desde el Marketplace para obtener autocompletado y validación de sintaxis.
- Uso de **sbt** como herramienta de construcción para gestionar la compilación y ejecución del proyecto.

#### 2. Verificación y ejecución

Se configuró un archivo `build.sbt` especificando la versión de Scala:

```scala
scalaVersion := "2.12.21"
```

Se creó el código fuente en `src/main/scala/Main.scala`. La compilación y ejecución se realizaron desde la terminal integrada de VS Code:

```bash
sbt compile
sbt run
```

---

### Entorno 1.3 — IntelliJ IDEA Community + sbt

#### 1. Requisitos e instalación

Se utilizó un IDE completo para el desarrollo:

- Descarga e instalación de **IntelliJ IDEA Community Edition** (versión **2023.3.8**).
- Instalación del plugin oficial de **Scala** desde la pantalla de bienvenida.
- Creación de un nuevo proyecto seleccionando **sbt** como sistema de construcción y descargando automáticamente **Microsoft OpenJDK 17**.

#### 2. Verificación y ejecución

La ejecución se verificó de dos formas:

1. Mediante la interfaz gráfica de IntelliJ (botón **Run**).
2. Mediante la consola interactiva de sbt nativa del IDE, ejecutando los comandos `compile` y `run`.

---

## Registro de incidencias y soluciones

Durante el desarrollo de la práctica y la configuración de los entornos surgieron varios problemas técnicos que fueron documentados y resueltos:

### 1. Incompatibilidad de versiones de Java (Entorno 1.1)

- **Problema:** El sistema detectaba por defecto la versión JDK 21 de Java, lo que generaba conflictos al intentar compilar e instalar el kernel de Almond para Scala 2.12.
- **Solución:** Se forzó la descarga y uso de JDK 17 a través de Coursier:

```bash
cs setup --jvm 17
```

Esto actualizó correctamente las variables de entorno.

### 2. Comando `sbt` no reconocido en terminal (Entorno 1.2)

- **Problema:** Al intentar ejecutar `sbt compile` en la terminal de PowerShell (VS Code), el sistema devolvía el error:  
  `El término 'sbt' no se reconoce como nombre de un cmdlet.`
- **Solución:** La ruta de los binarios instalados por Coursier no estaba en el `PATH` de Windows. Se añadió temporalmente en la sesión:

```powershell
$env:PATH += ";C:\Users\HERNAN\AppData\Local\Coursier\data\bin"
```

### 3. Error de terminal en IntelliJ IDEA (Entorno 1.3)

- **Problema:** La terminal local integrada en IntelliJ no reconocía ni `sbt` ni `cs` al intentar compilar manualmente.
- **Solución:** Se utilizó la consola sbt interactiva que proporciona el propio IntelliJ (marcada como `[IJ]`), la cual resolvió las dependencias y ejecutó `compile` y `run` sin problemas.

### 4. Errores de Git: Rutas largas en Windows

- **Problema:** Al intentar añadir los archivos al repositorio local, Windows y Git generaban errores por la longitud excesiva de las rutas de algunos archivos de caché (ej. en carpetas `.bloop` o `.metals`).
- **Solución:** Se habilitó el soporte para rutas largas en la configuración global de Git:

```bash
git config --global core.longpaths true
```

Adicionalmente, se configuró un archivo `.gitignore` para excluir carpetas innecesarias.

### 5. Conflictos al subir el repositorio a GitHub (Push)

**Problema 1:** Error `src refspec main does not match any`.  
La rama local se llamaba `master`, pero GitHub requería que se subiera a `main`.

- **Solución 1:**

```bash
git branch -M main
```

**Problema 2:** Error `Updates were rejected because the remote contains work that you do not have locally`.  
Existían archivos en GitHub (como el README inicial creado vía web) que no estaban en local.

- **Solución 2:** Se forzó la fusión de historiales no relacionados:

```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

---

> [!NOTE]
> Las versiones de Coursier, Almond, JupyterLab, Visual Studio Code y Metals no se especificaron en los datos de origen y por tanto no se incluyen en la tabla de tecnologías.
