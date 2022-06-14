import 'package:flutter/material.dart';

class AppLargeText extends StatelessWidget {
  const AppLargeText({
    Key? key,
    required this.text,
    this.size = 30.0,
  }) : super(key: key);

  final String text;
  final double size;

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: Theme.of(context).textTheme.headline6!.copyWith(
            fontSize: size,
          ),
    );
  }
}
