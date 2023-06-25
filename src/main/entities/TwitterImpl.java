package main.entities;

import main.tads.Queue.QueueConPrioridad;
import main.tads.hash.HashTable;
import main.tads.hash.HashTableImpl;
import main.tads.heap.Heap;
import main.tads.linkedlist.ListaEnlazada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        HashTable<String, Integer> hashtagCount = new HashTableImpl<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (mismaFecha(tweet.getDate(), fechaSeleccionada)) {
                for (int j = 0; j < tweet.getHashtags().size(); j++) {
                    Hashtag hashtag = tweet.getHashtags().get(j);
                    String textoHashtag = hashtag.getText().toLowerCase();
                    if (!textoHashtag.trim().equalsIgnoreCase("f1")) {
                        int count = hashtagCount.getOrDefault(textoHashtag, 0);
                        hashtagCount.put(textoHashtag, count + 1);
                    }
                }
            }
        }
        String hashtagMasUsado = null;
        int maxCount = 0;
        for (int i = 0; i < hashtagCount.keysToList().size(); i++) {
            String hashtag = hashtagCount.keysToList().get(i);
            int count = hashtagCount.get(hashtag);
            if (count > maxCount) {
                maxCount = count;
                hashtagMasUsado = hashtag;
            }
        }
        return hashtagMasUsado;
    }

//    @Override
//    public ListaEnlazada<User> topUsuariosConMasTweets() {
//        // usuarios y numero de tweets aca
//        HashTable<User, Integer> usuarioTweetCount = new HashTableImpl<>();
//        for (int i = 0; i < tweets.size(); i++) {
//            Tweet tweet = tweets.get(i);
//            User user = tweet.getUser();
//            if (user != null) {
//                usuarioTweetCount.put(user, usuarioTweetCount.getOrDefault(user, 0) + 1);
//            }
//        }
//        // Create a priority queue (max heap) to hold users based on tweet count
//        QueueConPrioridad<User> pq = new QueueConPrioridad<>(Comparator.comparingInt(usuarioTweetCount::get).reversed());
//        // Add users to the priority queue
//        ListaEnlazada<User> keysList = usuarioTweetCount.keysToList();
//        int size = keysList.size();
//        for (int i = 0; i < size; i++) {
//            User user = keysList.get(i);
//            int tweetCount = usuarioTweetCount.get(user);
//            user.setNumberOfTweets(tweetCount);
//            pq.enqueueConPrioridad(user);
//            if (pq.size() > 15) {
//                pq.dequeue(); // Remove the user with the least tweet count
//            }
//        }
//        // Create a linked list to store the top users
//        ListaEnlazada<User> topUsuarios = new ListaEnlazada<>();
//        while (!pq.isEmpty()) {
//            topUsuarios.addFirst(pq.dequeue());
//        }
//        return topUsuarios;
//    }

    @Override
    public ListaEnlazada<User> topUsuariosConMasTweets() {
        QueueConPrioridad<Integer,User> usuarioTweetCount = new QueueConPrioridad<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            User user = tweet.getUser();
            if (user != null) {
                usuarioTweetCount.enqueueConPrioridad(user.getNumberOfTweets(),user);
                if (usuarioTweetCount.size() == 16) {
                    usuarioTweetCount.dequeueLeft();
                }
            }
        }
        ListaEnlazada<User> topUsuarios = new ListaEnlazada<>();
            while (!usuarioTweetCount.isEmpty()) {
            topUsuarios.addFirst(usuarioTweetCount.dequeue().getValue());
        }
            return topUsuarios;
    }

    @Override
    public void TopCuentasConMasFavoritos() {
    }


    @Override
    public void TweetsConPalabraFraseEspecifica() {
    }
}
