import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class OnboardingScreen extends StatelessWidget {
  const OnboardingScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: Scaffold(
        appBar: AppBar(
            elevation: 0.0,
            toolbarHeight: 25.0,
            backgroundColor: Colors.white,
            systemOverlayStyle: SystemUiOverlayStyle.dark // Status bar color
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
                  const Text(
                    'Lascia che la musica\nti porti via...',
                    style:
                        TextStyle(fontSize: 32.0, fontWeight: FontWeight.bold),
                  ),
                  Expanded(child: Container()),
                  Container(
                    alignment: Alignment.center,
                    child: FloatingActionButton(
                        elevation: 0.0,
                        backgroundColor: Colors.blueGrey,
                        onPressed: () {},
                        child: const Icon(Icons.arrow_forward)),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
