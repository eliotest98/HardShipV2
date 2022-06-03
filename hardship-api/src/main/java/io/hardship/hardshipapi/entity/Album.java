package io.hardship.hardshipapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Genere", nullable = false, length = 30)
    private String genere;

    @Column(name = "Titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "Copertina", nullable = false, length = 256)
    private String copertina;

    @Column(name = "numero_brani", nullable = false)
    private Integer numeroBrani;

    @Column(name = "data", nullable = false, length = 11)
    private String data;

    @Lob
    @Column(name = "Embed")
    private String embed;

    @Column(name = "Dettagli", nullable = false, length = 256)
    private String dettagli;

    @Column(name = "username_admin", nullable = false, length = 15)
    private String usernameAdmin;

    @Column(name = "ID_etichetta", nullable = false)
    private Integer idEtichetta;

    @Column(name = "ID_artista", nullable = false)
    private Integer idArtista;

    public Album(String genere, String titolo, String copertina, Integer numeroBrani, String data, String embed, String dettagli, String usernameAdmin, Integer idEtichetta, Integer idArtista) {
        this.genere = genere;
        this.titolo = titolo;
        this.copertina = copertina;
        this.numeroBrani = numeroBrani;
        this.data = data;
        this.embed = embed;
        this.dettagli = dettagli;
        this.usernameAdmin = usernameAdmin;
        this.idEtichetta = idEtichetta;
        this.idArtista = idArtista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    public Integer getNumeroBrani() {
        return numeroBrani;
    }

    public void setNumeroBrani(Integer numeroBrani) {
        this.numeroBrani = numeroBrani;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public String getDettagli() {
        return dettagli;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public Integer getIdEtichetta() {
        return idEtichetta;
    }

    public void setIdEtichetta(Integer idEtichetta) {
        this.idEtichetta = idEtichetta;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

}