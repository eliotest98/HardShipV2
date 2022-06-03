package io.hardship.hardshipapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Titolo", nullable = false, length = 25)
    private String titolo;

    @Column(name = "Testo", nullable = false, length = 1024)
    private String testo;

    @Column(name = "Data", nullable = false, length = 11)
    private String data;

    @Column(name = "ID_Album", nullable = false)
    private Integer idAlbum;

    @Column(name = "ID_Cliente", nullable = false)
    private Integer idCliente;

    public Feedback(String titolo, String testo, String data, Integer idAlbum, Integer idCliente) {
        this.titolo = titolo;
        this.testo = testo;
        this.data = data;
        this.idAlbum = idAlbum;
        this.idCliente = idCliente;
    }
}