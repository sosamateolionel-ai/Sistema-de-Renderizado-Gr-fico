# Sistema de Renderizado Gráfico

## Descripción

Este proyecto implementa un sistema de renderizado gráfico simulado utilizando Java y los principios de la Programación Orientada a Objetos.

El programa permite trabajar con tres motores gráficos: OpenGL, DirectX y Vulkan. Cada motor tiene su propia lógica de inicialización y dibujo, mientras que una estructura común administra el estado del contexto gráfico y la liberación de recursos.

## Funcionamiento

El sistema realiza un ciclo gráfico para cada motor:

1. Inicializa el contexto gráfico.
2. Recorre una escena con distintas mallas.
3. Simula el dibujo de cada malla.
4. Cuenta las mallas dibujadas correctamente.
5. Libera los recursos al finalizar la sesión.

Después, ejecuta pruebas adicionales con Vulkan para comprobar las validaciones de estado, como intentar dibujar sin un contexto inicializado o inicializar un contexto que ya está activo.

## Interfaz y clases principales

### 1. `MotorGrafico`

Interfaz que define las operaciones básicas que debe ofrecer cualquier motor gráfico.

**Métodos:**

* `inicializarContexto()`: intenta inicializar el contexto y devuelve `true` si tiene éxito.
* `dibujarMalla()`: intenta dibujar una malla y devuelve `true` si la operación se realiza correctamente.
* `liberarRecursos()`: libera los recursos asociados a la sesión gráfica.

### 2. `RenderizadorBase`

Clase abstracta que implementa `MotorGrafico` y centraliza las validaciones y el control del estado.

**Atributos:**

* `api`: nombre del motor gráfico.
* `contextoInicializado`: indica si el contexto está activo.
* `mallasDibujadas`: contador de mallas dibujadas durante la sesión.

**Métodos principales:**

* `inicializarContexto()`: evita inicializar dos veces un contexto activo.
* `dibujarMalla()`: verifica que el contexto esté inicializado y que el nombre de la malla no sea nulo ni vacío.
* `liberarRecursos()`: desactiva el contexto, muestra el total de mallas dibujadas y reinicia el contador.
* `detalleInicializacion()`: método abstracto que describe la inicialización específica de cada API.
* `ejecutarDibujo()`: método abstracto que define cómo simular el dibujo de una malla.

### 3. `RenderizadorOpenGL`

Representa el motor gráfico OpenGL.

**Características:**

* Utiliza `"OpenGL"` como identificador.
* Describe la inicialización mediante una máquina de estados global y un contexto asociado a una ventana.
* Simula el dibujo con las operaciones `glBindVertexArray` y `glDrawElements`.

### 4. `RenderizadorDirectX`

Representa el motor gráfico DirectX.

**Características:**

* Utiliza `"DirectX"` como identificador.
* Describe la creación de un dispositivo D3D y una cadena de intercambio (*swap chain*).
* Simula el dibujo mediante `DrawIndexed` sobre una lista de comandos.

### 5. `RenderizadorVulkan`

Representa el motor gráfico Vulkan.

**Características:**

* Utiliza `"Vulkan"` como identificador.
* Describe la configuración explícita de una instancia, un dispositivo lógico y colas de comandos.
* Simula el dibujo mediante `vkCmdDrawIndexed` en un búfer de comandos.

### 6. `Main`

Contiene el método principal y el método auxiliar `cicloGrafico()`.

**Método `cicloGrafico()`:**

* Recibe un objeto de tipo `MotorGrafico` y una lista de nombres de mallas.
* Inicializa el contexto.
* Intenta dibujar cada malla.
* Libera los recursos al finalizar.

**Método `main()`:**

* Crea una escena con las mallas `Personaje`, `Arbol` y `Terreno`.
* Ejecuta el ciclo gráfico con OpenGL, DirectX y Vulkan.
* Realiza pruebas adicionales para verificar el control del estado del motor Vulkan.

## Ejemplo de funcionamiento

Durante la ejecución, los tres motores procesan las mismas mallas:

* Personaje
* Arbol
* Terreno

Cada uno muestra mensajes que representan sus operaciones de dibujo. Al finalizar cada ciclo, informa que se liberaron los recursos y que se dibujaron tres mallas durante esa sesión.

Las pruebas adicionales de Vulkan verifican los siguientes casos:

* Intentar dibujar sin un contexto inicializado.
* Intentar liberar recursos cuando no hay una sesión activa.
* Inicializar correctamente el contexto.
* Intentar inicializarlo nuevamente.
* Intentar dibujar una malla con nombre vacío.
* Liberar los recursos al finalizar.

## Conceptos de programación utilizados

* **Interfaces:** `MotorGrafico` define un contrato común para los motores.
* **Abstracción:** `RenderizadorBase` reúne la lógica compartida y deja los detalles específicos a las clases derivadas.
* **Herencia:** los tres renderizadores heredan de `RenderizadorBase`.
* **Polimorfismo:** el método `cicloGrafico()` trabaja con cualquier implementación de `MotorGrafico`.
* **Sobrescritura de métodos:** cada renderizador implementa sus propios métodos de inicialización y dibujo.
* **Encapsulamiento:** se utilizan atributos `protected` y métodos con distintos niveles de acceso.
* **Validación de estado:** se controla cuándo es posible inicializar, dibujar y liberar recursos.
* **Modularidad:** el ciclo gráfico está separado de las implementaciones específicas de cada motor.

## Tecnologías utilizadas

* Java
* Programación Orientada a Objetos
* IntelliJ IDEA

## Ejecución

<img width="1125" height="772" alt="image" src="https://github.com/user-attachments/assets/2b702dae-2ab5-4175-b023-2978f04f5f4c" />

## Objetivo del ejercicio

Practicar interfaces, clases abstractas, herencia y polimorfismo mediante un sistema modular que permite intercambiar motores gráficos sin modificar el ciclo general de renderizado.

**Aclaración:** el proyecto simula las operaciones de OpenGL, DirectX y Vulkan mediante mensajes en consola. No inicializa dispositivos gráficos reales ni renderiza imágenes en pantalla.
