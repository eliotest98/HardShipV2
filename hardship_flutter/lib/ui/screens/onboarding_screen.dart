import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/routes/route_constants.dart';
import 'package:hardship_flutter/ui/routes/routes.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/constants/app_strings.dart';

class OnboardingScreen extends StatelessWidget {
  const OnboardingScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        elevation: 0.0,
        toolbarHeight: 50.0,
      ),
      body: SafeArea(
        child: Container(
          decoration: const BoxDecoration(
              image: DecorationImage(
            image: AssetImage('assets/png/onboarding.png'),
            fit: BoxFit.cover,
          )),
          child: Padding(
            padding: const EdgeInsets.only(
                left: 24.0, right: 16.0, bottom: 24.0, top: 24.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const AppLargeText(
                  text: welcomeMessage,
                ),
                Expanded(child: Container()),
                Container(
                  alignment: Alignment.center,
                  child: FloatingActionButton(
                      elevation: 0.0,
                      onPressed: () {
                        RoutesService.pushNamedAndRemoveUntil(RouteList.home);
                      },
                      child: const Icon(Icons.arrow_forward)),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
