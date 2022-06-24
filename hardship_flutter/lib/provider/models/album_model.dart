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
