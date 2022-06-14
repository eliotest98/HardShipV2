import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';

// ignore: must_be_immutable
class AppDrawer extends StatelessWidget {
  bool isAuth = false;
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: <Widget>[
          AppBar(
            title: const AppLargeText(text: 'HARDSHIP'),
            automaticallyImplyLeading: false,
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.album),
            title: const Text('Album'),
            onTap: () {
              Navigator.of(context).pushReplacementNamed('/album');
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.login),
            title: const Text('Login'),
            onTap: () {
              Navigator.of(context).pushReplacementNamed('/login');
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.app_registration_rounded),
            title: const Text('Registrati'),
            onTap: () {
              Navigator.of(context).pushReplacementNamed('/');
            },
          ),
          const Divider(),
          Expanded(child: Container()),
          isAuth
              ? ListTile(
                  leading: const Icon(Icons.exit_to_app),
                  title: const Text('Logout'),
                  onTap: () {
                    Navigator.of(context).pop();
                    Navigator.of(context).pushReplacementNamed('/');
                  },
                )
              : Container(),
        ],
      ),
    );
  }
}
