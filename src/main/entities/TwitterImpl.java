package main.entities;

import main.tads.linkedlist.ListaEnlazada;

public class TwitterImpl implements MyTwitterImpl{
    ListaEnlazada<User> usuarios;

    public TwitterImpl() {
        this.usuarios = new ListaEnlazada<>();
    }

    @Override
    public void HashtagMasUsado() {

    }

    @Override
    public void TopCuentasConMasFavoritos() {

    }

    @Override
    public void cantidadHashtagsDistintos() {

    }

    @Override
    public void topUsuariosConMasTweets() {

    }

    @Override
    public void pilotosMasMencionados() {

    }

    @Override
    public void TweetsConPalabraFraseEspecifica() {

    }
}
