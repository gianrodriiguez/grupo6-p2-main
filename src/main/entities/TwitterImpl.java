package main.entities;

import main.tads.hash.HashTableImpl;
import main.tads.linkedlist.ListaEnlazada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    private boolean mismaFecha(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
        int day2 = cal2.get(Calendar.DAY_OF_MONTH);
        return year1 == year2 && month1 == month2 && day1 == day2;
    }

    private Date parsearFecha(String fecha) {
        Date fechaSeleccionada = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fechaSeleccionada = dateFormat.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");
            e.printStackTrace();
        }
        return fechaSeleccionada;
    }

    @Override
    public void HashtagMasUsado() {
        // Implementation here
    }

    @Override
    public void TopCuentasConMasFavoritos() {
        // Implementation here
    }

    @Override
    public void topUsuariosConMasTweets() {
        // Implementation here
    }

    @Override
    public void TweetsConPalabraFraseEspecifica() {
        // Implementation here
    }
}
