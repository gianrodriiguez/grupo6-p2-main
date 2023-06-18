package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public interface MyTwitterImpl {
    public ListaEnlazada<String> pilotosMasMencionados(String mes, String anio);

    int cantHashtagsDistintos(String fecha); //fechaSinParse
    void HashtagMasUsado();
    void TopCuentasConMasFavoritos();
    void topUsuariosConMasTweets();
    void TweetsConPalabraFraseEspecifica();
}
