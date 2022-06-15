import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/routes/route_constants.dart';
import 'package:hardship_flutter/ui/routes/routes.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/strings/Strings.dart';

// ignore: must_be_immutable
class AppDrawer extends StatelessWidget {
  bool isAuth = false;
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: <Widget>[
          AppBar(
            title: const AppLargeText(text: title_appHARDSHIP),
            automaticallyImplyLeading: false,
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.album),
            title: const Text(album),
            onTap: () {
              RoutesService.pushNamed(RouteList.albums);
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.login),
            title: const Text(login),
            onTap: () {
              RoutesService.pushNamed(RouteList.login);
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.app_registration_rounded),
            title: const Text(registrati),
            onTap: () {
              RoutesService.pushNamed(RouteList.register);
            },
          ),
          const Divider(),
          Expanded(child: Container()),
          isAuth
              ? ListTile(
                  leading: const Icon(Icons.exit_to_app),
                  title: const Text(logout),
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
