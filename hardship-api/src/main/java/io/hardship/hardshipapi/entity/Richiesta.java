package io.hardship.hardshipapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "richiesta")
public class Richiesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "nome_album", nullable = false, length = 30)
    private String nomeAlbum;

    @Column(name = "artista", nullable = false, length = 25)
    private String artista;

    @Column(name = "ID_Cliente")
    private Integer idCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}