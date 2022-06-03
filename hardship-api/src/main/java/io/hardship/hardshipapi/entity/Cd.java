package io.hardship.hardshipapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cd")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cd {
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

    public Cd(BigDecimal prezzo, Integer numeroCopie, Integer idAlbum) {
        this.prezzo = prezzo;
        this.numeroCopie = numeroCopie;
        this.idAlbum = idAlbum;
    }
}