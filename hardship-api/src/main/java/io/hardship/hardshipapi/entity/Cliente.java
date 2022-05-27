package io.hardship.hardshipapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long Id;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Cognome", nullable = false)
    private String cognome;
    @Column(name = "Username", nullable = false)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "DataNascita", nullable = false, length = 20)
    private String dataNascita;

    @Column(name = "CodiceFiscale", nullable = false, length = 16)
    private String codiceFiscale;


    public Cliente(){}
    public Cliente(String nome, String cognome, String dataNascita, String username, String password, String codiceFiscale, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.username = username;
        this.password = password;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
}
