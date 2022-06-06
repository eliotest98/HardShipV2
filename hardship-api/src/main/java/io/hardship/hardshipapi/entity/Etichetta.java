package io.hardship.hardshipapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "etichetta")
public class Etichetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false, length = 25)
    private String nome;

    @Column(name = "Feed")
    private Integer feed;

    public Etichetta(String nome, int feed) {
        this.nome = nome;
        this.feed = feed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFeed() {
        return feed;
    }

    public void setFeed(Integer feed) {
        this.feed = feed;
    }

}