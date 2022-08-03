import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hardship_flutter/ui/screens/login_screen.dart';

void main() {
  testWidgets('LoginScreen test', (WidgetTester tester) async {
    //ho caricato la view
    await tester.pumpWidget(const MaterialApp(
      home: LoginScreen(),
    ));

    //ho trovato i widgets
    final Finder username = find.byKey(const ValueKey("usernameSignUpField"));
    final Finder password = find.byKey(const ValueKey("passwordSignUpField"));
    final Finder loginButton = find.byKey(const ValueKey("loginButton"));

    await tester.enterText(username, "mario");
    await tester.enterText(password, "passwordTest");

    await tester.tap(loginButton);
    await tester.pump();

    expect(find.text("Login Successful"), findsOneWidget);
  });
}
