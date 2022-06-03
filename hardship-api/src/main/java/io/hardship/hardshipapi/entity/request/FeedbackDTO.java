package io.hardship.hardshipapi.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeedbackDTO {
    private String titolo;
    private String testo;
    private int idAlbum;
    private int utente;
}
