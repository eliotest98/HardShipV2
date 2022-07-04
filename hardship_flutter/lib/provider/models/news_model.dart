class NewsModel {
  final int id;
  final String contenuto;
  final String data;
  final String autore;
  final String titolo;
  final String copertina;
  final String categoria;
  final String usernameAdmin;

  NewsModel(this.id, this.contenuto, this.data, this.autore, this.titolo,
      this.copertina, this.categoria, this.usernameAdmin);

  factory NewsModel.fromJson(Map<String, dynamic> json) {
    return NewsModel(
      json['id'],
      json['contenuto'],
      json['data'],
      json['autore'],
      json['titolo'],
      json['copertina'],
      json['categoria'],
      json['usernameAdmin'],
    );
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> map = <String, dynamic>{};
    map['id'] = id;
    map['contenuto'] = contenuto;
    map['data'] = data;
    map['autore'] = autore;
    map['titolo'] = titolo;
    map['copertina'] = copertina;
    map['categoria'] = categoria;
    map['usernameAdmin'] = usernameAdmin;
    return map;
  }
}
