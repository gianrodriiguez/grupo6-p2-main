package main.entities;

import main.tads.Queue.QueueConPrioridad;
import main.tads.hash.HashTable;
import main.tads.hash.HashTableImpl;
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
    public void pilotosMasMencionados(String mes, String anio) {
        QueueConPrioridad<Integer, String> pilotosMencionados = new QueueConPrioridad<>();
        HashTableImpl<String, Integer> mentionsCount = new HashTableImpl<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (mismoMes(tweet.getDate(), convertirAFecha(anio, mes))) {
                for (int j = 0; j < pilotos.size(); j++) {
                    String pilotName = pilotos.get(j);
                    String[] pilotWords = pilotName.split(" ");
                    boolean containsPilotName = true;
                    for (String word : pilotWords) {
                        if (!tweet.getTweetText().contains(word)) {
                            containsPilotName = false;
                            break;
                        }
                    }
                    if (containsPilotName) {
                        int currentCount = mentionsCount.getOrDefault(pilotName, 0);
                        mentionsCount.put(pilotName, currentCount + 1);
                    }
                }
            }
        }
        for (int i = 0; i < mentionsCount.keysToList().size(); i++) {
            String pilotName = mentionsCount.keysToList().get(i);
            int mentionCount = mentionsCount.get(pilotName);
            pilotosMencionados.enqueueConPrioridad(mentionCount, pilotName);
            if (pilotosMencionados.size() > 10) {
                pilotosMencionados.dequeue();
            }
        }
        ListaEnlazada<String> topPilotos = new ListaEnlazada<>();
        while (!pilotosMencionados.isEmpty()) {
            topPilotos.addFirst(pilotosMencionados.dequeue().getValue());
        }
        for (int i = 0; i < topPilotos.size(); i++) {
            System.out.println(topPilotos.get(i));
        }
    }

    private void insertInOrder(LinkedList<PilotMention> list, PilotMention pilotMention) {
        int index = 0;
        while (index < list.size() && pilotMention.compareTo(list.get(index)) <= 0) {
            index++;
        }
        list.add(index, pilotMention);
    }

    private static class PilotMention implements Comparable<PilotMention> {
        private String pilotName;
        private int mentionCount;

        public PilotMention(String pilotName, int mentionCount) {
            this.pilotName = pilotName;
            this.mentionCount = mentionCount;
        }

        @Override
        public int compareTo(PilotMention other) {
            return Integer.compare(this.mentionCount, other.mentionCount);
        }
    }

    private boolean mismoMes(Date date1, Date fechaSeleccionada) {
        if (date1 == null || fechaSeleccionada == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(fechaSeleccionada);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
        return year1 == year2 && month1 == month2;
    }

    private Date convertirAFecha(String year, String month) {
        try {
            int yearValue = Integer.parseInt(year);
            int monthValue = Integer.parseInt(month);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, yearValue);
            calendar.set(Calendar.MONTH, monthValue - 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return calendar.getTime();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
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
    public int TweetsConPalabraFraseEspecifica(String palabraFrase) {
        ListaEnlazada<Tweet> tweetsEncontrados = new ListaEnlazada<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            if (tweet.getTweetText().toLowerCase().contains(palabraFrase)) {
                tweetsEncontrados.add(tweet);
            }
        }
        System.out.println("Tweets que contienen la palabra o frase \"" + palabraFrase + "\":");
        if (tweetsEncontrados.size() == 0) {
            System.out.println("No se encontraron tweets con la palabra o frase especificada.");
            return 0 ;

        } else {
            return tweetsEncontrados.size();
        }
    }
}

