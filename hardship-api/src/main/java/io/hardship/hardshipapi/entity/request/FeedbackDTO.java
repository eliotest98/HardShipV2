package io.hardship.hardshipapi.entity.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FeedbackDTO {
    private String titolo;
    private String testo;
    private int idAlbum;
    private int utente;
}
