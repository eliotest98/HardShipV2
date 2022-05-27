package io.hardship.hardshipapi.entity;

import javax.persistence.*;

@No
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "Contenuto", nullable = false)
    private String contenuto;

    @Column(name = "Data", nullable = false, length = 11)
    private String data;

    @Column(name = "Autore", nullable = false, length = 25)
    private String autore;

    @Column(name = "Titolo", nullable = false, length = 50)
    private String titolo;

    @Lob
    @Column(name = "Copertina", nullable = false)
    private String copertina;

    @Column(name = "Categoria", nullable = false, length = 15)
    private String categoria;

    @Column(name = "Username_admin", nullable = false, length = 15)
    private String usernameAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

}