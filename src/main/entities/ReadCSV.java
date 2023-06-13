package src.main.entities;

import java.io.FileNotFoundException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import src.main.exceptions.FileNotValidException;
import src.main.tads.linkedlist.ListaEnlazada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV<Tweets> {
    public ReadCSV() throws IOException {}
    public static void getDriversFromFile() {
        String driversFile = "src/resources/drivers.txt";
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
        String csvFile = "src/resources/f1_dataset.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                User user = new User(); // csvRecord es un array con tweets, le asigno a cada uno valores
                Tweet tweet = new Tweet(); // Saco los usuarios y todo del csvRecord, csvRecord.setUserId() ...
                Hashtag hashTag = new Hashtag();
                try {
                    //codigo pa leer el csv
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            throw new FileNotValidException("FILE_ERROR_FORMAT", e);
        }
    }

}

