import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:crypto/crypto.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:hardship_flutter/ui/constants/app_strings.dart';
import 'package:intl/intl.dart';
import 'package:http/http.dart' as http;
import '../../core/utils/EncryptData.dart';
import '../../provider/models/user_model.dart';

class RegistrationScreen extends StatefulWidget {
  const RegistrationScreen({Key? key}) : super(key: key);

  @override
  State<RegistrationScreen> createState() => _RegistrationScreenState();
}

class _RegistrationScreenState extends State<RegistrationScreen> {
  final _formKey = GlobalKey<FormState>();
  TextEditingController dateinput = TextEditingController();
  UserModel user = UserModel(0, "", "", "", "", "", "", "");
  String url = "http://127.0.0.1:8080/api/v1/register";

  Future save() async {
    var res = await http.post(Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({
          "nome": user.nome,
          "cognome": user.cognome,
          "username": user.username,
          "password": user.password,
          "email": user.email,
          "dataNascita": dateinput.text,
          "codiceFiscale": user.codiceFiscale
        }));
    //print(res.body);
    String jsonString = res.body;
    int statusCode = res.statusCode;
    if (jsonString != "" && statusCode == 200) {
      Navigator.pop(context);
    } else if (statusCode == 500) {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("Errore"),
            content: Text("Username già utilizzata"),
            actions: <Widget>[
              FlatButton(
                child: Text("Ok"),
                onPressed: () {
                  Navigator.of(context).pop();
                },
              ),
            ],
          );
        },
      );
    }
  }

  @override
  void initState() {
    dateinput.text = ""; //set the initial value of text field
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: true,
      ),
      body: SingleChildScrollView(
        child: Form(
            key: _formKey,
            child: Column(
              children: [
                Container(
                  height: MediaQuery.of(context).size.height * 1,
                  width: MediaQuery.of(context).size.width,
                  decoration: BoxDecoration(
                      color: Theme.of(context).primaryColorLight,
                      boxShadow: const [
                        BoxShadow(
                            blurRadius: 10,
                            color: Colors.black,
                            offset: Offset(1, 5))
                      ],
                      borderRadius: const BorderRadius.only(
                          bottomLeft: Radius.circular(80),
                          bottomRight: Radius.circular(20))),
                  child: Padding(
                    padding: const EdgeInsets.all(1.0),
                    child: Column(
                      children: [
                        /*const SizedBox(
                          height: 20,
                        ),*/
                        Text(registrati,
                            style: GoogleFonts.pacifico(
                                fontSize: 30, color: Colors.white)),
                        /*const SizedBox(
                          height: 30,
                        ),*/
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            nome,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          key: const ValueKey('nameSignUpField'),
                          controller: TextEditingController(text: user.nome),
                          onChanged: (val) {
                            user.nome = val;
                          },
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo nome obbligatorio';
                            }
                            if (value != null &&
                                value.isNotEmpty &&
                                value.length > 25) {
                              return 'Campo nome troppo lungo';
                            }
                            return null;
                          },
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 2,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        /*const SizedBox(
                          height: 30,
                        ),*/
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            cognome,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          key: const ValueKey('surnameSignUpField'),
                          controller: TextEditingController(text: user.cognome),
                          onChanged: (val) {
                            user.cognome = val;
                          },
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo cognome obbligatorio';
                            }
                            if (value != null &&
                                value.isNotEmpty &&
                                value.length > 30) {
                              return 'Campo cognome troppo lungo';
                            }
                            return null;
                          },
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 2,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        /*const SizedBox(
                          height: 30,
                        ),*/
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            datanascita,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          key: const ValueKey('dateOfBirthSignUpField'),
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo Data di nascita obbligatorio';
                            }
                            return null;
                          },
                          readOnly: true, //this is important
                          onTap:
                              _selectDate, //the method for opening data picker
                          controller:
                              dateinput, //editing controller of this TextField
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 2,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        /*const SizedBox(
                          height: 30,
                        ),*/
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            username,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          key: const ValueKey('usernameSignUpField'),
                          controller:
                              TextEditingController(text: user.username),
                          onChanged: (val) {
                            user.username = val;
                          },
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo username obbligatorio';
                            }
                            if (value != null &&
                                value.isNotEmpty &&
                                value.length > 15) {
                              return 'Campo username troppo lunga';
                            }
                            return null;
                          },
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                          keyboardType: TextInputType.emailAddress,
                        ),
                        Container(
                          height: 2,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        /*const SizedBox(
                          height: 30,
                        ),*/

                        /*
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            email,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          controller: TextEditingController(text: user.email),
                          onChanged: (val) {
                            user.email = val;
                          },
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo email obbligatorio';
                            }
                            if (!RegExp(
                                    r'^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$')
                                .hasMatch(value!)) {
                              return 'Inserisci un email valida';
                            }
                            return null;
                          },
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                          keyboardType: TextInputType.emailAddress,
                        ),
                        Container(
                          height: 4,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        const SizedBox(
                          height: 30,
                        ),*/

                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            password,
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                        TextFormField(
                          key: const ValueKey('passwordSignUpField'),
                          controller:
                              TextEditingController(text: user.password),
                          onChanged: (val) {
                            user.password = val;
                          },
                          validator: (value) {
                            if (value?.isEmpty ?? true) {
                              return 'Campo password obbligatorio';
                            }
                            if (value != null && value.length < 6) {
                              return 'Campo password troppo corta';
                            }
                            if (value != null && value.length > 30) {
                              return 'Campo password troppo lunga';
                            }
                            return null;
                          },
                          style: const TextStyle(
                              fontSize: 20, color: Colors.white),
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(
                                  borderSide: BorderSide.none)),
                          obscureText: true,
                        ),
                        Container(
                          height: 2,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(10.0),
                          child: SizedBox(
                            height: 30,
                            width: 30,
                            child: TextButton(
                                key: const ValueKey("registerButton"),
                                onPressed: () {
                                  if (_formKey.currentState!.validate()) {
                                    var encryptPw =
                                        EncryptData.encryptAES(user.password);
                                    user.password = encryptPw;
                                    save();
                                  }
                                },
                                child: const Icon(
                                  Icons.arrow_forward,
                                  size: 20,
                                )),
                          ),
                        )
                      ],
                    ),
                  ),
                ),
              ],
            )),
      ),
    );
  }

  void _selectDate() async {
    DateTime dateTime = DateTime.now();
    final DateTime? picked = await showDatePicker(
        context: context,
        initialDate: dateTime,
        initialDatePickerMode: DatePickerMode.day,
        firstDate: DateTime.now(),
        lastDate: DateTime(2101));
    if (picked != null) {
      dateTime = picked;
      String formattedDate = DateFormat('dd-MM-yyyy').format(dateTime);
      dateinput.text = formattedDate;
    }
  }
}
