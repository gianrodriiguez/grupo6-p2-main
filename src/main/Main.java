package main;

import main.entities.TwitterImpl;
import main.entities.User;
import main.exceptions.FileNotValidException;
import main.tads.linkedlist.ListaEnlazada;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotValidException {
        TwitterImpl miTwitter = new TwitterImpl();
        ReadCSV datosReader = new ReadCSV(miTwitter);
//        datosReader.getDriversFromFile();
        datosReader.getUsersInfo();
        menu(miTwitter);
    }

    private static void cantidadHashtagsDistintos(TwitterImpl miTwitter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        int cantHashtags = miTwitter.cantHashtagsDistintos(fecha);
        System.out.println("Cantidad de hashtags distintos para el día " + fecha + ": " + cantHashtags);
    }
    private static void HashtagMasUsado(TwitterImpl miTwitter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        String hashtagMasUsado = miTwitter.hashtagMasUsado(fecha);
        System.out.println("Hashtag mas usado del día " + fecha + ": " + hashtagMasUsado);
    }

    private static void TopUsuariosConMasTweets(TwitterImpl miTwitter) {
        ListaEnlazada<User> usuariosConMasTweets = miTwitter.topUsuariosConMasTweets();
        int j = 15;
        for (int i = 0; i < usuariosConMasTweets.size(); i++) {
            User usuario = usuariosConMasTweets.get(i);
            System.out.println(j + ". " + usuario.getName() + "    Tweets: " + usuario.getNumberOfTweets());
            System.out.println("Verified: " + usuario.getIsVerified());
            j = j - 1;
        }
    }

    private static void menu(TwitterImpl miTwitter) {
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
                    PilotosMasMencionados(miTwitter);
                    break;
                case 2:
                    TopUsuariosConMasTweets(miTwitter);
                    break;
                case 3:
                    cantidadHashtagsDistintos(miTwitter);
                    break;
                case 4:
                    HashtagMasUsado(miTwitter);
                    break;
                case 5:
                    TopCuentasConMasFavoritos(miTwitter);
                    break;
                case 6:
                    TweetsConPalabraFraseEspecifica(miTwitter);
                    break;
                case 7:
                    exit = true;
                    break;
            }
            System.out.println();
        }
    }

    private static void PilotosMasMencionados(TwitterImpl miTwitter) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Ingresa año (ej: 2023 ): ");
        String yearString = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Ingresa mes (ej: 6 ): ");
        String monthString = scanner2.nextLine();
        miTwitter.pilotosMasMencionados(monthString, yearString);
    }


    private static void TopCuentasConMasFavoritos(TwitterImpl miTwitter) {
    }

    private static void TweetsConPalabraFraseEspecifica(TwitterImpl miTwitter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese palabra o frase del Tweet: ");
        String texto = scanner.nextLine();
        System.out.println(miTwitter.TweetsConPalabraFraseEspecifica(texto));

    }
}
