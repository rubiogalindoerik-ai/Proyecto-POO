# Avance del proyecto
**Instrucciones**
##Para lograr tu objetivo de desarrollar un sistema de gestión de biblioteca, debes tomar en cuenta algunos aspectos.
---
### Los requisitos funcionales del sistema son los siguientes:
-Debe permitir registrar y consultar libros, usuarios y préstamos.  
-Debe validar que los datos ingresados sean correctos y coherentes.  
-Debe controlar que no se presten más libros de los que hay disponibles ni que se exceda el límite de dos ejemplares por usuario.  
-Debe generar reportes (impresiones en pantalla) sobre el estado de la biblioteca, así como del número de libros, usuarios y préstamos.  
---
### Estos son los requisitos no funcionales del sistema:
-Debe ser fácil de usar.  
-Debe ser robusto y manejar adecuadamente los errores.  
-Debe ser eficiente.  
-Debe ser escalable y permitir agregar nuevas funcionalidades en el futuro.  
---
### Para realizar el diseño y modelado del sistema, sigue este proceso:
-Identifica las clases y los objetos que intervienen en el sistema, así como sus atributos y métodos.  
-Define las relaciones entre las clases y los objetos, como la asociación, la agregación, la composición y la herencia.  
-Elabora los diagramas UML que representen el sistema, como el diagrama de clases, el de casos de uso, el de secuencia, el de estado, etcétera.  
-Documenta el diseño y el modelado del sistema, explicando el significado y la función de cada elemento.  
-Debe permitir registrar y consultar libros, usuarios y préstamos.  
-Debe validar que los datos ingresados sean correctos y coherentes.   
-Debe controlar que no se presten más libros de los que hay disponibles ni que se exceda el límite de dos ejemplares por usuario.  
-Debe generar reportes (impresiones en pantalla) sobre el estado de la biblioteca, así como del número de libros, usuarios y préstamos.  
---
### Estos son los requisitos no funcionales del sistema:
-Debe ser fácil de usar.   
-Debe ser robusto y manejar adecuadamente los errores.   
-Debe ser eficiente.   
-Debe ser escalable y permitir agregar nuevas funcionalidades en el futuro.   
---
### Para realizar el diseño y modelado del sistema, sigue este proceso:
-Identifica las clases y los objetos que intervienen en el sistema, así como sus atributos y métodos. 
-Define las relaciones entre las clases y los objetos, como la asociación, la agregación, la composición y la herencia. 
-Elabora los diagramas UML que representen el sistema, como el diagrama de clases, el de casos de uso, el de secuencia, el de estado, etcétera.  
-Documenta el diseño y el modelado del sistema, explicando el significado y la función de cada elemento.  
---
## Clases y objetos
### Clase libro
**Atributos:**
idLibro: int
titulo: String
autor: String
isbn: String
totalEjemplares: int
ejemplaresDisponibles: int
**Métodos:**
prestar(): boolean
devolver(): void
esDisponible(): boolean
### Clase Usuario
**Atributos:**
idUsuario: int
nombre: String
email: String
prestamosActivos: int
**Métodos:**
puedePrestar(): boolean
incrementarPrestamos(): void
decrementarPrestamos(): void
### Clase Préstamo
**Atributos:**
idPrestamo: int
libro: Libro
usuario: Usuario
fechaPrestamo: Date
fechaDevolucion: Date
estado: EstadoPrestamo
**Métodos:**
cerrarPrestamo(): void
esActivo(): boolean
### Clase Biblioteca
**Atributos:**
libros: List
usuarios: List
prestamos: List
**Métodos:**
registrarLibro(Libro): void
registrarUsuario(Usuario): void
prestarLibro(idLibro, idUsuario): boolean
devolverLibro(idPrestamo): void
generarReportes(): void
### Estado de prestamo
ACTIVO
DEVUELTO
---
## Relaciones entre los objetos y las clases
Biblioteca(1) - (N)libro  
Biblioteca(1) - (N)Usuario  
Biblioteca(1) - (N)Prestamo  
Prestamo(1) - (1)Libro  
Prestamo(1) - (1)Usuario  
---
## Diagrama UML
![](DiagramaUML.png)
---
## Codigo del menu
```java
Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(); // tu clase principal

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Consultar libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Generar reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarLibro(sc, biblioteca);
                    break;
                case 2:
                    registrarUsuario(sc, biblioteca);
                    break;
                case 3:
                    biblioteca.generarReportes();
                    break;
                case 4:
                    prestarLibro(sc, biblioteca);
                    break;
                case 5:
                    devolverLibro(sc, biblioteca);
                    break;
                case 6:
                    biblioteca.generarReportes();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
```
**Explicacion:** el menu funciona con un ciclo while para que se repita hasta que el usuario introduzca 0 y dentro con prints muestro el menu y con el switch reviso que opcion selecciona aunque por ahora estan vacias las opciones 

