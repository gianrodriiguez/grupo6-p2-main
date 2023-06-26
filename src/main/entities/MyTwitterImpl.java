package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public interface MyTwitterImpl {
    void pilotosMasMencionados(String mes, String anio);

    int cantHashtagsDistintos(String fecha); //fechaSinParse

    String hashtagMasUsado(String fechaSinParse);

    void TopCuentasConMasFavoritos();
    ListaEnlazada<User> topUsuariosConMasTweets();
    int TweetsConPalabraFraseEspecifica(String palabraFrase);
}
