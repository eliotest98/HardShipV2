import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:hardship_flutter/ui/constants/app_strings.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Form(
            child: Container(
          height: 700,
          width: MediaQuery.of(context).size.width,
          decoration: BoxDecoration(
              color: Theme.of(context).primaryColorLight,
              boxShadow: [
                BoxShadow(
                    blurRadius: 10, color: Colors.black, offset: Offset(1, 5))
              ],
              borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(80),
                  bottomRight: Radius.circular(20))),
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              children: [
                SizedBox(
                  height: 100,
                ),
                Text(login,
                    style: GoogleFonts.pacifico(
                        fontSize: 30, color: Colors.white)),
                SizedBox(
                  height: 30,
                ),
                Align(
                  alignment: Alignment.topLeft,
                  child: Text(
                    email,
                    style: GoogleFonts.roboto(
                      fontWeight: FontWeight.bold,
                      fontSize: 30,
                      color: Colors.white,
                    ),
                  ),
                ),
                TextFormField(
                  style: TextStyle(fontSize: 30, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                ),
                Container(
                  height: 8,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                SizedBox(
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
                  style: TextStyle(fontSize: 30, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                ),
                Container(
                  height: 8,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                Padding(
                  padding: const EdgeInsets.all(40.0),
                  child: Container(
                    height: 70,
                    width: 70,
                    child: TextButton(
                        onPressed: () {},
                        child: Icon(
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
