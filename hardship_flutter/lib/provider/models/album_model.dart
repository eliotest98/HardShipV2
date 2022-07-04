class AlbumModel {
  final int id;
  final String genere;
  final String titolo;
  final String copertina;
  final int numeroBrani;
  final String data;
  final String embed;
  final String dettagli;
  final String usernameAdmin;
  final int idEtichetta;
  final int idArtista;

  AlbumModel(
      this.id,
      this.genere,
      this.titolo,
      this.copertina,
      this.numeroBrani,
      this.data,
      this.embed,
      this.dettagli,
      this.usernameAdmin,
      this.idEtichetta,
      this.idArtista);

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> map = <String, dynamic>{};
    map['id'] = id;
    map['genere'] = genere;
    map['titolo'] = titolo;
    map['copertina'] = copertina;
    map['numeroBrani'] = numeroBrani;
    map['data'] = data;
    map['embed'] = embed;
    map['dettagli'] = dettagli;
    map['usernameAdmin'] = usernameAdmin;
    map['idEtichetta'] = idEtichetta;
    map['idArtista'] = idArtista;
    return map;
  }

  factory AlbumModel.fromJson(Map<String, dynamic> json) {
    return AlbumModel(
      json['id'],
      json['genere'],
      json['titolo'],
      json['copertina'],
      json['numeroBrani'],
      json['data'],
      json['embed'],
      json['dettagli'],
      json['usernameAdmin'],
      json['idEtichetta'],
      json['idArtista'],
    );
  }
}
