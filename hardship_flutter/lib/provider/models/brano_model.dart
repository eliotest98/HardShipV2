class BranoModel {
  final int id;
  final String titolo;
  final String anno;
  final String durata;
  final int idAlbum;
  final int idArtista;

  BranoModel(this.id, this.titolo, this.anno, this.durata, this.idAlbum,
      this.idArtista);

  factory BranoModel.fromJson(Map<String, dynamic> json) {
    return BranoModel(
      json['id'],
      json['titolo'],
      json['anno'],
      json['durata'],
      json['idAlbum'],
      json['idArtista'],
    );
  }
}
