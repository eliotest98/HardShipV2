package io.hardship.hardshipapi.entity.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RichiestaDTO {
    String artista;
    String titolo;
    String idCliente;
}
