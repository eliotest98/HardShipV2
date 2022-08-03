import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hardship_flutter/ui/screens/login_screen.dart';
import 'package:hardship_flutter/ui/screens/registration_screen.dart';

void main() {
  setUpAll(() {
    // ↓ required to avoid HTTP error 400 mocked returns
    HttpOverrides.global = null;
  });

  testWidgets('http', (WidgetTester tester) async {
    await tester.runAsync(() async {
      final HttpClient client = HttpClient();
      final HttpClientRequest request = await client
          .getUrl(Uri.parse('http://127.0.0.1:8080/api/v1/register'));

      final HttpClientResponse response = await request.close();
      print(response.statusCode); // Should get 200
    });
  });

  testWidgets('RegistrationScreen test', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(surname, "moggio");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(username, "lukeno13");
    await tester.enterText(password, "alcatel13");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();
  });

  testWidgets('Form required username', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(surname, "moggio");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(password, "alcatel13");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo username obbligatorio"), findsOneWidget);
  });

  testWidgets('Form required surname', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(username, "lukeno13");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(password, "alcatel13");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo cognome obbligatorio"), findsOneWidget);
  });

  testWidgets('Form required dateOfBirth', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(username, "lukeno13");
    await tester.enterText(password, "alcatel13");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo Data di nascita obbligatorio"), findsOneWidget);
  });

  testWidgets('Form required password', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "mario");
    await tester.enterText(surname, "moggio");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(username, "lukeno13");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo password obbligatorio"), findsOneWidget);
  });

  testWidgets('Username has a length greater than 15',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(username, "pippobaudocapellone");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo username troppo lunga"), findsOneWidget);
  });

  testWidgets('Name has a length greater than 25', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "pippobaudocapellonebarbabianca");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo nome troppo lungo"), findsOneWidget);
  });

  testWidgets('Surname has a length greater than 30',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(surname, "baudocapellonebarbabiancapippoo");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo cognome troppo lungo"), findsOneWidget);
  });

  testWidgets('Password has a length minus than 6',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(surname, "moggio");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(username, "lukeno13");
    await tester.enterText(password, "al");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo password troppo corta"), findsOneWidget);
  });

  testWidgets('Password has a length greater than 30',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: RegistrationScreen(),
    ));

    //ho trovato i widgets
    final Finder name = find.byKey(const ValueKey("nameSignUpField"));
    final Finder surname = find.byKey(const ValueKey("surnameSignUpField"));
    final Finder dateOfBirthSignUpField =
        find.byKey(const ValueKey("dateOfBirthSignUpField"));
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder registerButton = find.byKey(const ValueKey("registerButton"));

    await tester.enterText(name, "luca");
    await tester.enterText(surname, "moggio");
    await tester.enterText(dateOfBirthSignUpField, "01/01/2000");
    await tester.enterText(username, "lukeno13");
    await tester.enterText(password,
        "alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12");

    await tester.tap(registerButton, warnIfMissed: false);
    await tester.pump();

    expect(find.text("Campo password troppo lunga"), findsOneWidget);
  });
}
