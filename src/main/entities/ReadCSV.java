package main.entities;

import main.entities.ReadCSV;
import main.entities.User;
import java.io.FileNotFoundException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import main.exceptions.FileNotValidException;
import main.tads.linkedlist.ListaEnlazada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV<Tweets> {
    public ReadCSV() throws IOException {}
    public static void getDriversFromFile() {
        String driversFile = "/Users/gianfrancorodriguez/Downloads/obligatorio2023/drivers.txt";
        ListaEnlazada<String> conductores = new ListaEnlazada<>();
        try (BufferedReader br = new BufferedReader(new FileReader(driversFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                conductores.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        conductores.print();
    }

    public void GetUsersInfo() throws FileNotValidException {
        String csvFile = "/Users/gianfrancorodriguez/Downloads/obligatorio2023/f1_dataset_test.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
//                User user = new User(); // csvRecord es un array con tweets, le asigno a cada uno valores
//                Tweet tweet = new Tweet(); // Saco los usuarios y todo del csvRecord, csvRecord.setUserId() ...
//                Hashtag hashTag = new Hashtag();
                try {
//                    CODIGO PARA LEER EL CSV
                    String userName = csvRecord.get(0);
//                    String userLocation = csvRecord.get(1);
//                    String userDescription = csvRecord.get(2);
                    String userCreated = csvRecord.get(3);
                    int userFollowers = Integer.parseInt(csvRecord.get(4));
                    int userFriends = Integer.parseInt(csvRecord.get(5));
                    int userFavourites = Integer.parseInt(csvRecord.get(6));
                    boolean userVerified = Boolean.parseBoolean(csvRecord.get(7));
                    String date = csvRecord.get(8);
                    String text = csvRecord.get(9);
                    String[] hashtags = csvRecord.get(10).split(",");
                    String source = csvRecord.get(11);
                    boolean isRetweet = Boolean.parseBoolean(csvRecord.get(12));

                    User user = new User();     // Falta varias cosas del user
                    user.setName(userName);
//                    user.setLocation(userLocation);
//                    user.setDescription(userDescription);

                    Tweet tweet = new Tweet();
                    tweet.setContent(text);
                    tweet.setSource(source);
                    tweet.setRetweet(isRetweet);
                    tweet.setDate(date);

                    for (String hashtagText : hashtags) {
                        Hashtag hashtag = new Hashtag();
                        hashtag.setText(hashtagText);
                        tweet.getHashtags().add(hashtag);
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            throw new FileNotValidException("FILE_ERROR_FORMAT", e);
        }
    }
}

