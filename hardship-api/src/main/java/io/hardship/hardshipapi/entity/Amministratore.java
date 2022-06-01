package io.hardship.hardshipapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amministratore")
public class Amministratore {
    @Id
    @Column(name = "Username", nullable = false, length = 15)
    private String username;

    @Column(name = "Password", nullable = false, length = 30)
    private String password;

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

}