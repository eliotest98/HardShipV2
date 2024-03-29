import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hardship_flutter/ui/screens/login_screen.dart';

void main() {
  setUpAll(() {
    // ↓ required to avoid HTTP error 400 mocked returns
    HttpOverrides.global = null;
  });

  testWidgets('http', (WidgetTester tester) async {
    await tester.runAsync(() async {
      final HttpClient client = HttpClient();
      final HttpClientRequest request =
          await client.getUrl(Uri.parse('http://127.0.0.1:8080/api/v1/login'));

      final HttpClientResponse response = await request.close();
      print(response.statusCode); // Should get 200
    });
  });

  testWidgets('LoginScreen test', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    //ho trovato i widgets
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "lukeno13");
    await tester.enterText(password, "alcatel13");

    await tester.tap(loginButton);
    await tester.pumpAndSettle();

    expect(find.text("Login Successful"), findsOneWidget);
  });

  testWidgets('Form required username', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    //ho trovato i widgets
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(password, "passwordTest");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Campo username obbligatorio"), findsOneWidget);
  });

  testWidgets('Form required username', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    //ho trovato i widgets
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "mario");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Campo password obbligatorio"), findsOneWidget);
  });

  testWidgets('Username has a length greater than 15',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    //ho trovato i widgets
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "mario");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Campo username troppo corto"), findsOneWidget);
  });

  testWidgets('Password has a length minus than 6',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "lukeno13");
    await tester.enterText(password, "al");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Campo password troppo corta"), findsOneWidget);
  });

  testWidgets('Password has a length greater than 30',
      (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "lukeno13");
    await tester.enterText(password,
        "alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12alcatel12");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Campo password troppo lunga"), findsOneWidget);
  });
}
