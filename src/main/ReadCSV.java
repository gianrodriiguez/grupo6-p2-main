package main;

import main.entities.Hashtag;
import main.entities.Tweet;
import main.entities.TwitterImpl;
import main.entities.User;
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
import java.util.Hashtable;

public class ReadCSV {
    TwitterImpl miTwitter;
    public ReadCSV(TwitterImpl miTwitter) {
        this.miTwitter = miTwitter;
    }
    public void getDriversFromFile() {
        String driversFile = "src/main/resources/drivers.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(driversFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                miTwitter.pilotos.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        miTwitter.pilotos.print();
    }

    public void getUsersInfo() throws FileNotValidException {
        String csvFile = "src/main/resources/f1_dataset_test.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT)) {
            ListaEnlazada<String> usuariosProcesados = new ListaEnlazada<>();
            Hashtable<String,User> usuariosProcesados2 = new Hashtable<>();
            for (CSVRecord csvRecord : csvParser) {
                try {
                    // LECTURA CSV
                    // DATOS
                    long tweetId = Long.parseLong(csvRecord.get(0));
                    String userName = csvRecord.get(1);
                    String userDate = csvRecord.get(4);
                    double userFollowers = Double.parseDouble(csvRecord.get(5));
                    double userFriends = Double.parseDouble(csvRecord.get(6));
                    double userFavourites = Double.parseDouble(csvRecord.get(7));
                    boolean userIsVerified = Boolean.parseBoolean(csvRecord.get(8));
                    // DATE
                    String tweetDate = csvRecord.get(9);
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat inputFormat = new SimpleDateFormat(pattern);
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date tweetDateParseada;

                    // Chequea tweetDate
                    try {
                        Date parsedDate = inputFormat.parse(tweetDate);
                        String formattedDate = outputFormat.format(parsedDate);
                        tweetDateParseada = outputFormat.parse(formattedDate);
                    } catch (ParseException e) {
                        continue;
                    }

                    String tweetText = csvRecord.get(10).trim();
                    String hashtagsString = csvRecord.get(11);
                    hashtagsString = hashtagsString.replace("[", "").replace("]", "");
                    hashtagsString = hashtagsString.replace("'", "");
                    String[] hashtags = hashtagsString.split(",");
                    for (int k = 0; k < hashtags.length; k++) {
                        hashtags[k] = hashtags[k].trim();
                    }
                    String tweetSource = csvRecord.get(12).trim();
                    boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));


                    // INSERCIONES
                    Tweet tweet = new Tweet(tweetId, tweetText, tweetSource, isRetweet, tweetDateParseada);
                    for (String hashtagText : hashtags) {
                        Hashtag hashtag = new Hashtag(hashtagText.toLowerCase());
                        tweet.addHashtag(hashtag);
                        hashtag.getTweets().add(tweet);
                    }
                    // ya existe user?
                    if (usuariosProcesados2.containsKey(userName)) {
                        User usuarioExistente = usuariosProcesados2.get(userName);
                        if (usuarioExistente != null) {
                            usuarioExistente.addTweet(tweet);
                            miTwitter.tweets.add(tweet);
                        }
                        continue;
                    }

                    if (tweet != null && tweet.getUser() == null) {
                        User nuevoUser = new User(userName, userFavourites, userIsVerified);
                        nuevoUser.addTweet(tweet);
                        tweet.setUser(nuevoUser);
                        miTwitter.usuarios.put(nuevoUser.getId(), nuevoUser);
                        miTwitter.tweets.add(tweet);
                        usuariosProcesados2.put(userName,nuevoUser);
                    }
                } catch (Exception ignored) {
                }
            }
            getDriversFromFile();
        } catch (IOException e) {
            throw new FileNotValidException("FILE_ERROR_FORMAT", e);
        }
    }
}

