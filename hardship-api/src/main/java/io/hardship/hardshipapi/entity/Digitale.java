package io.hardship.hardshipapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "digitale")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Digitale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Prezzo", nullable = false, precision = 4, scale = 2)
    private BigDecimal prezzo;

    @Column(name = "numero_Copie", nullable = false)
    private Integer numeroCopie;

    @Column(name = "ID_album")
    private Integer idAlbum;

    public Digitale(BigDecimal prezzo, Integer numeroCopie, Integer idAlbum) {
        this.prezzo = prezzo;
        this.numeroCopie = numeroCopie;
        this.idAlbum = idAlbum;
    }

}