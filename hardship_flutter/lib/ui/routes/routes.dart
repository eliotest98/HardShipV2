import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';
import 'package:hardship_flutter/ui/routes/route_constants.dart';
import 'package:hardship_flutter/ui/screens/albums_details_screen.dart';
import 'package:hardship_flutter/ui/screens/albums_screen.dart';
import 'package:hardship_flutter/ui/screens/home_screen.dart';
import 'package:hardship_flutter/ui/screens/login_screen.dart';
import 'package:hardship_flutter/ui/screens/news_details_screen.dart';
import 'package:hardship_flutter/ui/screens/onboarding_screen.dart';

import '../screens/registration_screen.dart';

class RoutesService {
  static GlobalKey<NavigatorState> navigationKey = GlobalKey<NavigatorState>();

  static void pop<T>({T? result}) {
    navigationKey.currentState!.pop<T>(result);
  }

  static Future<T?> pushNamed<T>(String name,
      {Map<String, dynamic>? arguments}) async {
    return navigationKey.currentState?.pushNamed(
      name,
      arguments: arguments,
    );
  }

  static Future<T?>? pushNamedAndRemoveUntil<T>(
    String routeName, {
    Object? args,
  }) async {
    return navigationKey.currentState?.pushNamedAndRemoveUntil<T>(
        routeName, (Route<dynamic> route) => false,
        arguments: args);
  }

  static Route<dynamic>? onGenerateRoute(RouteSettings settings) {
    final args = settings.arguments;

    switch (settings.name) {
      case RouteList.onboarding:
        return MaterialPageRoute(
            builder: (context) => const OnboardingScreen());
      case RouteList.home:
        return MaterialPageRoute(builder: (context) => const HomeScreen());
      case RouteList.login:
        return MaterialPageRoute(builder: (context) => const LoginScreen());
      case RouteList.register:
        return MaterialPageRoute(
            builder: (context) => const RegistrationScreen());

      case RouteList.albums:
        return MaterialPageRoute(builder: (context) => const AlbumsScreen());
      case RouteList.albumDetails:
        args as Map<String, dynamic>;
        return MaterialPageRoute(
            builder: (context) => AlbumDetailsScreen(
                  albumModel: AlbumModel.fromJson(args),
                ));
      case RouteList.newsDetails:
        args as Map<String, dynamic>;
        return MaterialPageRoute(
            builder: (context) =>
                NewsDetailsScreen(news: NewsModel.fromJson(args)));
      default:
        return null;
    }
  }
}
