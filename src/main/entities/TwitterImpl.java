package main.entities;

import main.tads.hash.HashTableImpl;
import main.tads.linkedlist.ListaEnlazada;

public class TwitterImpl implements MyTwitterImpl{
    public HashTableImpl<Long, User> usuarios;
    public HashTableImpl<Long, Tweet> tweets;

    public TwitterImpl() {
        this.usuarios = new HashTableImpl<Long,User>();
        this.tweets = new HashTableImpl<Long, Tweet>();
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
