package io.hardship.hardshipapi.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vinile")
public class Vinile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Prezzo", nullable = false, precision = 4, scale = 2)
    private BigDecimal prezzo;

    @Column(name = "numero_Copie", nullable = false)
    private Integer numeroCopie;

    @Column(name = "ID_Album")
    private Integer idAlbum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

}