package io.hardship.hardshipapi.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AlbumDTO {
   private String autore;
   private String titolo;
   private String genere;
   private String data;
   private String dettagli;
   private String etichetta;
   private String copertina;
   private String embed;
   private String usernameAdmin;
   private int nbrani;
   private int digitale;
   private int vinile;
   private int cd;
   private BigDecimal pdigitale;
   private BigDecimal pvinile;
   private BigDecimal pcd;
   private String file;
   private ArrayList<String> brani;
   private ArrayList<String> durate;
}
