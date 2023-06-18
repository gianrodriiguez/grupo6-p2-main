package main;

import main.exceptions.FileNotValidException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static ReadCSV datos = new ReadCSV();
    public static void main(String[] args) throws IOException, FileNotValidException {
        datos.getUsersInfo();
//        csv.getDriversFromFile();
        menu();
    }
    private static void pilotosMasMencionados() {
//        Scanner scanner1 = new Scanner(System.in);
//        Scanner scanner2 = new Scanner(System.in);
//        System.out.println("Ingrese mes: ");
//        String mes = scanner1.nextLine();
//        System.out.println("Ingrese año: ");
//        String anio = scanner1.nextLine();
//
//        ListaEnlazada<String> pilotosMencionados = new ListaEnlazada<>();
    }
    private static void cantidadHashtagsDistintos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        int cantHashtags = datos.miTwitter.cantHashtagsDistintos(fecha);
        System.out.println("Cantidad de hashtags distintos para el día " + fecha + ": " + cantHashtags);
    }

    private static void HashtagMasUsado() {

    }

    private static void TopCuentasConMasFavoritos() {
    }


    private static void topUsuariosConMasTweets() {
    }


    private static void TweetsConPalabraFraseEspecifica() {
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Casa de Apuestas ===");
            System.out.println("1. 10 pilotos más mencionados del mes");
            System.out.println("2. 15 usuarios con más tweets");
            System.out.println("3. Cantidad de hashtags distintos para un día");
            System.out.println("4. Hashtag más usado del día");
            System.out.println("5. 7 cuentas con más favoritos");
            System.out.println("6. Cantidad de tweets con una palabra o frase específica");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    pilotosMasMencionados();
                    break;
                case 2:
                    topUsuariosConMasTweets();
                    break;
                case 3:
                    cantidadHashtagsDistintos();
                    break;
                case 4:
                    HashtagMasUsado();
                    break;
                case 5:
                    TopCuentasConMasFavoritos();
                    break;
                case 6:
                    TweetsConPalabraFraseEspecifica();
                    break;
                case 7:
                    exit = true;
                    break;
            }
            System.out.println();
        }
    }
}