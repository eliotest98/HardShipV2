class UserModel {
  int id;
  String nome;
  String cognome;
  String username;
  String password;
  String email;
  String dataNascita;
  String codiceFiscale;

  UserModel(this.id, this.nome, this.cognome, this.username, this.password,
      this.email, this.dataNascita, this.codiceFiscale);

  factory UserModel.fromJson(Map<String, dynamic> json) {
    return UserModel(
        json['id'],
        json['nome'],
        json['cognome'],
        json['username'],
        json['password'],
        json['email'],
        json['dataNascita'],
        json['codiceFiscale']);
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> map = <String, dynamic>{};
    map['id'] = id;
    map['nome'] = nome;
    map['cognome'] = cognome;
    map['username'] = username;
    map['password'] = password;
    map['email'] = email;
    map['dataNascita'] = dataNascita;
    map['codiceFiscale'] = codiceFiscale;
    return map;
  }
}
