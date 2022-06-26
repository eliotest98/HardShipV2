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
    final Map<String, dynamic> data = <String, dynamic>{};
    data['id'] = id;
    data['contenuto'] = contenuto;
    data['data'] = data;
    data['autore'] = autore;
    data['titolo'] = titolo;
    data['copertina'] = copertina;
    data['categoria'] = categoria;
    data['usernameAdmin'] = usernameAdmin;
    return data;
  }
}
