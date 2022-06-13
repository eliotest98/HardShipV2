import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/constants/color_scheme_dark.dart';
import 'package:hardship_flutter/ui/constants/color_scheme_light.dart';

class AppTheme {
  //
  AppTheme._();

  static final ThemeData lightTheme = ThemeData(
    scaffoldBackgroundColor: Colors.white,
    appBarTheme: const AppBarTheme(
      color: Colors.white,
      iconTheme: IconThemeData(
        color: Colors.black,
      ),
    ),
    colorScheme: ColorSchemeLight.lightColorScheme, // add light color
    cardTheme: const CardTheme(
      color: Colors.teal,
    ),
    iconTheme: const IconThemeData(
      color: Colors.black,
    ),
    textTheme: const TextTheme(
      headline1: TextStyle(
        color: Colors.black,
        fontSize: 20.0,
      ),
      headline2: TextStyle(
        color: Colors.black87,
        fontSize: 18.0,
      ),
    ),
  );

  static final ThemeData darkTheme = ThemeData(
    scaffoldBackgroundColor: Color.fromARGB(255, 30, 30, 30),
    appBarTheme: const AppBarTheme(
      color: Color.fromARGB(255, 30, 30, 30),
      iconTheme: IconThemeData(
        color: Colors.white,
      ),
    ),
    colorScheme: ColorSchemeDark.darkColorScheme, // add dark color
    cardTheme: const CardTheme(
      color: Colors.black,
    ),
    iconTheme: const IconThemeData(
      color: Colors.white54,
    ),
    textTheme: const TextTheme(
      headline1: TextStyle(
        color: Colors.white,
        fontSize: 20.0,
      ),
      headline2: TextStyle(
        color: Colors.white70,
        fontSize: 18.0,
      ),
    ),
  );
}
