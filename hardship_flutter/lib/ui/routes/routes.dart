import 'package:flutter/material.dart';

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

    args as Map<String, dynamic>?;

    switch (settings.name) {
      default:
        return null;
    }
  }
}
