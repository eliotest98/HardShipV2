import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:hardship_flutter/ui/constants/app_strings.dart';

import '../../core/utils/EncryptData.dart';
import '../../provider/models/user_model.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  UserModel user = UserModel(0, "", "", "", "", "", "", "");
  String url = "http://127.0.0.1:8080/api/v1/login";

  Future save() async {
    var res = await http.post(Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({
          "username": user.username,
          "password": user.password,
        }));
    //print(res.body);
    String jsonString = res.body;
    int statusCode = res.statusCode;
    if (jsonString != "" && statusCode == 200) {
      //Navigator.pop(context);
    }
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
            child: Container(
              height: 700,
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
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  children: [
                    const SizedBox(
                      height: 100,
                    ),
                    Text(login,
                        style: GoogleFonts.pacifico(
                            fontSize: 30, color: Colors.white)),
                    const SizedBox(
                      height: 30,
                    ),
                    Align(
                      alignment: Alignment.topLeft,
                      child: Text(
                        username,
                        style: GoogleFonts.roboto(
                          fontWeight: FontWeight.bold,
                          fontSize: 30,
                          color: Colors.white,
                        ),
                      ),
                    ),
                    TextFormField(
                      key: const ValueKey('usernameSignUpField'),
                      controller: TextEditingController(text: user.username),
                      onChanged: (val) {
                        user.username = val;
                      },
                      validator: (value) {
                        if (value?.isEmpty ?? true) {
                          return 'Campo username obbligatorio';
                        }
                        return null;
                      },
                      style: const TextStyle(fontSize: 30, color: Colors.white),
                      decoration: const InputDecoration(
                          border:
                              OutlineInputBorder(borderSide: BorderSide.none)),
                    ),
                    Container(
                      height: 8,
                      color: const Color.fromRGBO(255, 255, 255, 0.4),
                    ),
                    const SizedBox(
                      height: 30,
                    ),
                    Align(
                      alignment: Alignment.topLeft,
                      child: Text(
                        password,
                        style: GoogleFonts.roboto(
                          fontWeight: FontWeight.bold,
                          fontSize: 30,
                          color: Colors.white,
                        ),
                      ),
                    ),
                    TextFormField(
                      key: const ValueKey('passwordSignUpField'),
                      controller: TextEditingController(text: user.password),
                      onChanged: (val) {
                        user.password = val;
                      },
                      validator: (value) {
                        if (value?.isEmpty ?? true) {
                          return 'Campo password obbligatorio';
                        }
                        return null;
                      },
                      style: const TextStyle(fontSize: 30, color: Colors.white),
                      decoration: const InputDecoration(
                          border:
                              OutlineInputBorder(borderSide: BorderSide.none)),
                      obscureText: true,
                    ),
                    Container(
                      height: 8,
                      color: const Color.fromRGBO(255, 255, 255, 0.4),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(40.0),
                      child: SizedBox(
                        height: 70,
                        width: 70,
                        child: TextButton(
                            key: const ValueKey("loginButton"),
                            onPressed: () {
                              if (_formKey.currentState!.validate()) {
                                var test = user.password;
                                var decryptPw = EncryptData.encryptAES(test);
                                user.password = decryptPw;
                                Scaffold.of(context)
                                    .showSnackBar(const SnackBar(
                                  content: Text("Login Successful"),
                                  duration: Duration(seconds: 2),
                                ));
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
            )),
      ),
    );
  }
}
