package main;

import main.entities.ReadCSV;
import main.entities.TwitterImpl;
import main.entities.User;
import main.exceptions.FileNotValidException;
import main.tads.hash.HashTableImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotValidException {



        TwitterImpl twitter = new TwitterImpl(5);
        menu();
        ReadCSV csv = new ReadCSV();
        csv.GetUsersInfo();

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

    private static void HashtagMasUsado() {
    }

    private static void TopCuentasConMasFavoritos() {
    }

    private static void cantidadHashtagsDistintos() {
    }

    private static void topUsuariosConMasTweets() {
    }

    private static void pilotosMasMencionados() {
        
    }

    private static void TweetsConPalabraFraseEspecifica() {
    }
}