import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

// Selccion de constantes fijas para el estado del prestamos
enum LoanStatus {
  ACTIVE,
  RETORNED
}

// clase del libro
class Book {
  private static int counter = 1; // contador para el ID
  private int idBook;
  private String title;
  private String author;
  private String isbn;
  private int totalCopy;
  private int availableCopys;

  public Book(String title, String author, String isbn, int totalCopy) {
    this.idBook = counter++;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.totalCopy = totalCopy;
    this.availableCopys = totalCopy;
  }

  public boolean lend() { // Metodo para prestar el libro
    if (availableCopys > 0) {
      availableCopys--;
      return true;
    }
    return false;
  }

  public void retrn() { // Metodo para regresar el libro
    if (availableCopys < totalCopy) {
      availableCopys++;
    }
  }

  public boolean available() { // Metodo para verificar la disponibilidad de copias
    return availableCopys > 0;
  }

  public int getIdBook() { // Metodo de busqueda del libro
    return idBook;
  }

  public String info() { // Metodo para expulsar la informacion del libro
    return "ID: " + idBook + " | Titulo: " + title + " | Autor: " + author + " | ISBN: " + isbn + " | Total: "
        + totalCopy + " | Disponibles: " + availableCopys;
  }
}

// Clase para el usaurio
class User {
  private static int counter = 1;
  private int idUser;
  private String name;
  private String gmail;
  private int activeLoans;

  public User(String name, String gmail) {
    this.idUser = counter++;
    this.name = name;
    this.gmail = gmail;
    this.activeLoans = 0;
  }

  public boolean canLoan() { // Metodo para verificar si puede solicitar un libro
    return activeLoans < 2;
  }

  public void incrementLoans() { // Metodo para incremetar los prestamos
    activeLoans++;
  }

  public void decreaseLoans() { // Metodo para disminuir los prestamos
    if (activeLoans > 0) {
      activeLoans--;
    }
  }

  public int getIdUser() { // Metodo de buqueda de usuario
    return idUser;
  }

  public String info() {
    return "ID: " + idUser + " | Nombre: " + name + " | Gmail: " + gmail + " | Prestamos activos: " + activeLoans;
  }
}

class Loan {
  private static int counter = 1;
  private int idLoan;
  private Book book;
  private User user;
  private Date loanDate;
  private Date loanRetorned;
  private LoanStatus status;

  public Loan(Book book, User user) {
    this.idLoan = counter++;
    this.book = book;
    this.user = user;
    this.loanDate = new Date();
    this.status = LoanStatus.ACTIVE;
  }

  public void closeLoan() { // Metodo para terminar el prestamo
    if (status == LoanStatus.ACTIVE) {
      status = LoanStatus.RETORNED;
      loanRetorned = new Date();
      book.retrn();
      user.decreaseLoans();
    }
  }

  public boolean onActive() { // Metodo para activar el prestamo
    return status == LoanStatus.ACTIVE;
  }

  public int getIdLoan() { // Metodo de busqueda de prestamo
    return idLoan;
  }

  // getters para traer el libro y el usuario
  public Book getbook() {
    return book;
  }

  public User getUser() {
    return user;
  }

  public String info() {
    return "ID: " + idLoan + " | Libro: " + book.getIdBook() + " | Usuario: " + user.getIdUser()
        + " | Fecha del prestamo: " + loanDate + " | Fecha de devolucion: " + loanRetorned + " | Estado: " + status;
  }
}

// Clase de la libreria
class Library {
  // Listas para guardar los libros, usuarios y prestamos
  private ArrayList<Book> books = new ArrayList<>();
  private ArrayList<User> users = new ArrayList<>();
  private ArrayList<Loan> loans = new ArrayList<>();

  public void registerBook(Book book) { // Metodo para agregar libros a la lista
    books.add(book);
  }

  public void registerUser(User user) { // Metodo para agregar usuarios a la lista
    users.add(user);
  }

  public boolean loanBook(int idBook, int idUser) { // Metodo para prestar libros

    Book book = findBook(idBook);
    User user = findUser(idUser);

    if (book == null || user == null) {
      System.out.println("Libro o usuario no encontrado");
      return false;
    }

    if (!book.available()) {
      System.out.println("No hay copias disponibles");
      return false;
    }

    if (!user.canLoan()) {
      System.out.println("El usuario ya tiene el maximo de prestamos permitidos");
      return false;
    }

    book.lend();
    user.incrementLoans();

    Loan newt = new Loan(book, user);
    loans.add(newt); // Metodo para agregar prestamo a la lista

    System.out.println("Prestamo realizado correctamente");
    return true;
  }

  public void returnBook(int idLoan) { // Metodo para regresar el libro
    for (Loan l : loans) {
      if (l.getIdLoan() == idLoan && l.onActive()) {
        l.closeLoan();
        System.out.println("Libro devuelto correctamente");
        return;
      }
    }
    System.out.println("Prestamo no encontrado");
  }

  public void generateReport() { // Metodo para generacion de reporte
    System.out.println("--- Libros ---");
    if (books.isEmpty()) {
      System.out.println("No hay libros registrados");
    } else {
      for (Book b : books)
        System.out.println(b.info());
    }

    System.out.println("--- Usuarios ---");
    if (users.isEmpty()) {
      System.out.println("No hay usuarios registrados");
    } else {
      for (User u : users)
        System.out.println(u.info());
    }

    System.out.println("--- Prestamos ---");
    if (loans.isEmpty()) {
      System.out.println("No hay prestamos registrados");
    } else {
      for (Loan l : loans)
        System.out.println(l.info());
    }
  }

  private Book findBook(int id) { // Metodo para encontrar el libro
    for (Book b : books)
      if (b.getIdBook() == id)
        return b;
    return null;
  }

  private User findUser(int id) { // Metodo para encontrar el usuario
    for (User u : users)
      if (u.getIdUser() == id)
        return u;
    return null;
  }
}

// Clase principal
public class finalproyect {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    int op;
    do {
      System.out.println("\n----- SISTEMA DE GESTIÓN DE BIBLIOTECA -----");
      System.out.println("1. Registrar libro");
      System.out.println("2. Registrar usuario");
      System.out.println("3. Reporte de libros y usaurios");
      System.out.println("4. Prestar libro");
      System.out.println("5. Devolver libro");
      System.out.println("0. Salir");
      System.out.print("Seleccione una opción: ");
      try {
        op = sc.nextInt();
      } catch (Exception e) {
        System.out.println("Debes ingresar un numero");
        sc.nextLine();
        op = -1;
        continue;
      }
      sc.nextLine();
      switch (op) {
        case 1:
          try {
            System.out.println("--- Registrar libro ---");
            System.out.print("Titulo: ");
            String title = sc.nextLine();
            System.out.print("Autor: ");
            String author = sc.nextLine();
            System.out.print("ISBN: ");
            String isbn = sc.nextLine();
            System.out.print("Total de copias: ");
            int total = sc.nextInt();
            if (total <= 0) {
              System.out.println("El total debe ser mayor a 0");
              break;
            }
            Book book = new Book(title, author, isbn, total);
            library.registerBook(book);
            System.out.println("Libro registrado correctamente");
          } catch (Exception e) {
            System.out.println("Error en lo ingresado");
            sc.nextLine();
          }
          break;
        case 2:
          try {
            System.out.println("--- Registrar usuario ---");
            System.out.print("Nombre: ");
            String name = sc.nextLine();
            System.out.print("Gmail: ");
            String gmail = sc.nextLine();
            User user = new User(name, gmail);
            library.registerUser(user);
            System.out.println("Usuario registrado correctamente");
          } catch (Exception e) {
            System.out.println("Error en lo ingresado");
            sc.nextLine();
          }
          break;
        case 3:
          System.out.println("--- Reporte de libros y usuarios ---");
          library.generateReport();
          break;
        case 4:
          System.out.println("--- Prestar libro ---");
          System.out.print("ID del libro: ");
          int bookLoan = sc.nextInt();
          System.out.print("ID del usuario: ");
          int userLoan = sc.nextInt();
          library.loanBook(bookLoan, userLoan);
          break;
        case 5:
          System.out.println("--- Buscar un prestamo ---");
          System.out.print("ID del prestamo: ");
          int idLoan = sc.nextInt();
          library.returnBook(idLoan);
          break;
        case 0:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción inválida");
      }

    } while (op != 0);
  }
}
