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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadCSV<Tweets> {
    public ReadCSV() throws IOException {}
    TwitterImpl miTwitter = new TwitterImpl();
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
            // csvRecord es un array con tweets, le asigno a cada uno valores
                try {
//                  LECTURA CSV
//                  DATOS
                    long tweetId = Long.parseLong(csvRecord.get(0));
                    String userName = csvRecord.get(1);
//                    String userLocation = csvRecord.get(2);
//                    String userDescription = csvRecord.get(3);
                    String userDate = csvRecord.get(4);
                    double userFollowers = Double.parseDouble(csvRecord.get(5));
                    double userFriends = Double.parseDouble(csvRecord.get(6));
                    double userFavourites = Double.parseDouble(csvRecord.get(7));
                    boolean userIsVerified = Boolean.parseBoolean(csvRecord.get(8));
//                    String tweetDate = csvRecord.get(9); // usar dateTime
//                    DATE
                    String tweetDate = csvRecord.get(9);
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    Date parsedTweetDate = dateFormat.parse(tweetDate);

                    String tweetText = csvRecord.get(10);
//                    String[] hashtags = csvRecord.get(11).split(",");
                    String hashtagsString = csvRecord.get(11);
                    hashtagsString = hashtagsString.replace("[", "").replace("]", "");
                    hashtagsString = hashtagsString.replace("'", "");
                    String[] hashtags = hashtagsString.split(",");

                    String tweetSource = csvRecord.get(12);
                    boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));

//                  INSERCIONES
                    Tweet tweet = new Tweet(tweetId,tweetText, tweetSource, isRetweet, parsedTweetDate);
                    for (String hashtagText : hashtags) {
                        Hashtag hashtag = new Hashtag(hashtagText);
                        tweet.addHashtag(hashtag);
                    }

                    User user = new User(userName, userFavourites, userIsVerified);
                    user.addTweet(tweet);
                    miTwitter.usuarios.put(user.getId(), user);
                    miTwitter.tweets.put(tweetId,tweet);

                } catch (Exception ignored) {}
            }
        } catch (IOException e) {
            throw new FileNotValidException("FILE_ERROR_FORMAT", e);
        }

    }
}

