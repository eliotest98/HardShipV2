package io.hardship.hardshipapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "brano")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    public Brano(String titolo, String anno, String durata, Integer idAlbum, Integer idArtista) {
        this.titolo = titolo;
        this.anno = anno;
        this.durata = durata;
        this.idAlbum = idAlbum;
        this.idArtista = idArtista;
    }
}