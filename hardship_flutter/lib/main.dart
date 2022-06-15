import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:hardship_flutter/ui/constants/app_theme.dart';
import 'package:hardship_flutter/ui/routes/routes.dart';
import 'package:hardship_flutter/ui/screens/onboarding_screen.dart';

void main() {
  SystemChrome.setSystemUIOverlayStyle(const SystemUiOverlayStyle(
    systemNavigationBarColor: Colors.white, // navigation bar color
    statusBarColor: Colors.white,
  ));
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        navigatorKey: RoutesService.navigationKey,
        debugShowCheckedModeBanner: false,
        title: 'HardShip',
        theme: AppTheme.lightTheme,
        darkTheme: AppTheme.darkTheme,
        onGenerateRoute: RoutesService.onGenerateRoute,
        home: const OnboardingScreen());
  }
}
