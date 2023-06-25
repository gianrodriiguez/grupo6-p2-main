package main.entities;

import main.tads.hash.HashTableImpl;
import main.tads.linkedlist.ListaEnlazada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class TwitterImpl implements MyTwitterImpl {
    public HashTableImpl<Long, User> usuarios;
    public ListaEnlazada<Tweet> tweets;
    public ListaEnlazada<String> pilotos;

    public TwitterImpl() {
        this.usuarios = new HashTableImpl<>();
        this.tweets = new ListaEnlazada<>();
        this.pilotos = new ListaEnlazada<>();
    }

    public void addUser(long userhash, User user) {
        usuarios.put(userhash, user);
    }

    public boolean contains(long id) {
        boolean yaExiste = usuarios.contains(id);
        return yaExiste;
    }

    public HashTableImpl<Long, User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashTableImpl<Long, User> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public ListaEnlazada<String> pilotosMasMencionados(String mes, String anio) {
        return null;
    }

    @Override
    public int cantHashtagsDistintos(String fechaSinParse) {
        Date fechaSeleccionada = parsearFecha(fechaSinParse);
        int contador = 0;
        ListaEnlazada<String> hashtagsDistintos = new ListaEnlazada<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (mismaFecha(tweet.getDate(), fechaSeleccionada)) {
                for (int j = 0; j < tweet.getHashtags().size(); j++) {
                    Hashtag hashtag = tweet.getHashtags().get(j);
                    String textoHashtag = hashtag.getText().toLowerCase();
                    hashtagsDistintos.add(textoHashtag);
                }
            }
        }
        contador = hashtagsDistintos.size();
        return contador;
    }


    private boolean mismaFecha(Date date1, Date fechaSeleccionada) {
        if (date1 == null || fechaSeleccionada == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(fechaSeleccionada);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
        int day2 = cal2.get(Calendar.DAY_OF_MONTH);
        return year1 == year2 && month1 == month2 && day1 == day2;
    }

    private Date parsearFecha(String dateString) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String hashtagMasUsado(String fechaSinParse) {
        Date fechaSeleccionada = parsearFecha(fechaSinParse);
        Hashtable<String, Integer> hashtagCount = new Hashtable<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (mismaFecha(tweet.getDate(), fechaSeleccionada)) {
                for (int j = 0; j < tweet.getHashtags().size(); j++) {
                    Hashtag hashtag = tweet.getHashtags().get(j);
                    String textoHashtag = hashtag.getText().toLowerCase();
                    if (!textoHashtag.trim().equalsIgnoreCase("f1")) {
                        if (hashtagCount.containsKey(textoHashtag)) {
                            int count = hashtagCount.get(textoHashtag);
                            hashtagCount.put(textoHashtag, count + 1);
                        } else {
                            hashtagCount.put(textoHashtag, 1);
                        }
                    }
                }
            }
        }
        String mostUsedHashtag = null;
        int maxCount = 0;
        for (String hashtag : hashtagCount.keySet()) {
            int count = hashtagCount.get(hashtag);
            if (count > maxCount) {
                maxCount = count;
                mostUsedHashtag = hashtag;
            }
        }
        return mostUsedHashtag;
    }


    @Override
    public void TopCuentasConMasFavoritos() {

    }

    @Override
    public void topUsuariosConMasTweets() {
    }

    @Override
    public int TweetsConPalabraFraseEspecifica(String pabalbraFrase) {

        ListaEnlazada<Tweet> tweetsEncontrados = new ListaEnlazada<>();

        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (tweet.getTweetText().toLowerCase().contains(pabalbraFrase)) {
                tweetsEncontrados.add(tweet);
            }
        }

        System.out.println("Tweets que contienen la palabra o frase \"" + pabalbraFrase + "\":");
        if (tweetsEncontrados.size() == 0) {
            System.out.println("No se encontraron tweets con la palabra o frase especificada.");
            return 0 ;

        } else {
            return tweetsEncontrados.size();
        }

    }
}