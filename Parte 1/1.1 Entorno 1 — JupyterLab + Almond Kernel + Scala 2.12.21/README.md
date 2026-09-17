# Entorno 1.1 — JupyterLab + Almond Kernel + Scala 2.12.21

## Objetivo
Preparar un entorno interactivo basado en JupyterLab que permita crear notebooks y ejecutar código utilizando Scala 2.12.21 mediante el Almond Kernel.

## 1. Requisitos e Instalación

Para habilitar el soporte de Scala, primero verifiqué las rutas de entorno y procedí a instalar Coursier como gestor de dependencias de Scala.

![Configuración inicial de Coursier](IMG/oursier-setup-y-configuracion.png)

A continuación, realicé la configuración del path y la verificación de que el entorno reconocía correctamente las herramientas instaladas.

![Verificación del PATH de Coursier](IMG/coursier-setup-path-y-verificacion.png)

## 2. Instalación de Jupyter y Almond Kernel

Descargué e instalé Jupyter en el sistema para poder utilizar la interfaz interactiva.

![Descarga de Jupyter](IMG/Jupyter%20download.png)
![Interfaz Web de Jupyter](IMG/Jupyter%20web.png)

Tras instalar JupyterLab, procedí a leer las instrucciones oficiales y ejecuté el comando necesario para instalar el kernel de Almond vinculado a Scala 2.12.21.

![Instrucciones de instalación de Almond](IMG/instrucciones-instalacion-almond.png)

El proceso finalizó correctamente, registrando el kernel de Scala en el entorno local de Jupyter.

![Instalación exitosa del kernel de Almond](IMG/instalacion-exitosa-kernel-almond-scala.png)

## 3. Verificación del Entorno

Al iniciar JupyterLab de forma predeterminada (antes de la correcta integración), el Launcher no mostraba opciones de Scala.

![Launcher inicial sin Scala](IMG/jupyterlab-launcher-inicial.png)

Una vez completada la instalación de Almond y reiniciado el entorno, el Launcher detectó y mostró correctamente la opción para crear Notebooks de Scala.

![Launcher de JupyterLab con Scala disponible](IMG/jupyterlab-launcher-con-scala.png)

## 4. Ejecución de Código

Para finalizar, creé un Notebook utilizando el kernel de Scala 2.12.21 y ejecuté bloques de código con declaraciones de variables, operaciones numéricas e impresión por pantalla para verificar su funcionamiento.

![Notebook ejecutando código Scala](IMG/jupyterlab-notebook-scala-ejecutado.png)
