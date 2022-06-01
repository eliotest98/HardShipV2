package io.hardship.hardshipapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "brano")
public class Brano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Titolo", nullable = false, length = 256)
    private String titolo;

    @Column(name = "Anno", nullable = false, length = 11)
    private String anno;

    @Column(name = "Durata", nullable = false, length = 6)
    private String durata;

    @Column(name = "ID_album")
    private Integer idAlbum;

    @Column(name = "ID_artista")
    private Integer idArtista;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

}