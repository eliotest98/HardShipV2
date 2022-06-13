import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.white,
        body: Column(
          children: [_buildHeader()],
        ));
  }

  Widget _buildHeader() {
    return Container(
      padding: const EdgeInsets.only(top: 70, left: 20, right: 20),
      child: Row(children: [
        IconButton(
          icon: const Icon(Icons.menu, size: 30, color: Colors.black54),
          onPressed: () {},
        ),
      ]),
    );
  }
}
