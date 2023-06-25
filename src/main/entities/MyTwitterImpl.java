package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public interface MyTwitterImpl {
    public ListaEnlazada<String> pilotosMasMencionados(String mes, String anio);

    int cantHashtagsDistintos(String fecha); //fechaSinParse

    String hashtagMasUsado(String fechaSinParse);

    void TopCuentasConMasFavoritos();
    ListaEnlazada<User> topUsuariosConMasTweets();
    int TweetsConPalabraFraseEspecifica(String palabraFrase);
}
