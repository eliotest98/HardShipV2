import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:hardship_flutter/ui/constants/app_strings.dart';
import 'package:intl/intl.dart';

class RegistrationScreen extends StatefulWidget {
  const RegistrationScreen({Key? key}) : super(key: key);

  @override
  State<RegistrationScreen> createState() => _RegistrationScreenState();
}

class _RegistrationScreenState extends State<RegistrationScreen> {
  TextEditingController dateinput = TextEditingController();

  @override
  void initState() {
    dateinput.text = ""; //set the initial value of text field
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Form(
            child: Container(
          height: 950,
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
                  height: 20,
                ),
                Text(registrati,
                    style: GoogleFonts.pacifico(
                        fontSize: 30, color: Colors.white)),
                SizedBox(
                  height: 30,
                ),
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
                  style: TextStyle(fontSize: 20, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                ),
                Container(
                  height: 4,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                SizedBox(
                  height: 30,
                ),
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
                  style: TextStyle(fontSize: 20, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                ),
                Container(
                  height: 4,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                SizedBox(
                  height: 30,
                ),
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
                  readOnly: true, //this is important
                  onTap: _selectDate, //the method for opening data picker
                  controller: dateinput, //editing controller of this TextField
                  style: TextStyle(fontSize: 20, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                ),
                Container(
                  height: 4,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                SizedBox(
                  height: 30,
                ),
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
                  style: TextStyle(fontSize: 20, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                  keyboardType: TextInputType.emailAddress,
                ),
                Container(
                  height: 4,
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
                      fontSize: 20,
                      color: Colors.white,
                    ),
                  ),
                ),
                TextFormField(
                  style: TextStyle(fontSize: 20, color: Colors.white),
                  decoration: InputDecoration(
                      border: OutlineInputBorder(borderSide: BorderSide.none)),
                  obscureText: true,
                ),
                Container(
                  height: 4,
                  color: Color.fromRGBO(255, 255, 255, 0.4),
                ),
                Padding(
                  padding: const EdgeInsets.all(40.0),
                  child: Container(
                    height: 70,
                    width: 70,
                    child: TextButton(
                        onPressed: () {

                        },
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
