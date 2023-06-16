package main.entities;

import main.entities.ReadCSV;
import main.entities.User;
import java.io.FileNotFoundException;

import main.tads.hash.HashTableImpl;
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
        String driversFile = "src/main/resources/drivers.txt";
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
        String csvFile = "src/main/resources/f1_dataset_test.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
//                User user = new User(); // csvRecord es un array con tweets, le asigno a cada uno valores
//                Tweet tweet = new Tweet(); // Saco los usuarios y todo del csvRecord, csvRecord.setUserId() ...
//                Hashtag hashTag = new Hashtag();
                try {
//                    CODIGO PARA LEER EL CSV



                    String userName = csvRecord.get(1);
                    String userLocation = csvRecord.get(2);
                    String userDescription = csvRecord.get(3);
                    String userDate = csvRecord.get(4);
                    int userFollowers = Integer.parseInt(csvRecord.get(5));
                    int userFriends = Integer.parseInt(csvRecord.get(6));
                    int userFavourites = Integer.parseInt(csvRecord.get(7));
                    boolean userIsVerified = Boolean.parseBoolean(csvRecord.get(8));

                    String tweetDate = csvRecord.get(9);
                    String tweetText = csvRecord.get(10);
                    String[] hashtags = csvRecord.get(11).split(",");
                    String tweetSource = csvRecord.get(12);
                    boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));

//                    if ()
                    User user = new User();     // Falta varias cosas del user
                    user.setName(userName);
                    user.setFavourites(userFavourites);
                    user.setVerified(userIsVerified);

                    Tweet tweet = new Tweet(user.getId(),tweetText, tweetSource, isRetweet, tweetDate);
                    user.addTweet(tweet);




// Store user and hash code in the hash table
//                    usuarios.put(user, userHash);

//                    user.setLocation(userLocation);
//                    user.setDescription(userDescr iption);

//                    Tweet tweet = new Tweet();
//                    tweet.settweetText(tweetText);
//                    tweet.settweetSource(tweetSource);
//                    tweet.setRetweet(isRetweet);
//                    tweet.setDate(tweetDate);

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

