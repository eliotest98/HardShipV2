import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/card_album.dart';
import 'package:hardship_flutter/ui/widgets/circle_indicator.dart';

import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class AlbumsScreen extends StatefulWidget {
  const AlbumsScreen({Key? key}) : super(key: key);

  @override
  State<AlbumsScreen> createState() => _AlbumsScreenState();
}

class _AlbumsScreenState extends State<AlbumsScreen>
    with TickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 2, vsync: this);
    getAlbumOrderedByEtichetta();
    getAlbumOrderedByArtista();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: true,
      ),
      body: SafeArea(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Padding(
                padding: EdgeInsets.only(left: kDefaultPadding),
                child: AppLargeText(text: 'Albums')),
            _tabBar(context),
            _tabBarView()
          ],
        ),
      ),
    );
  }

  Widget _tabBarView() {
    return Expanded(
      child: TabBarView(
        controller: _tabController,
        children: [_viewArtist(), _viewLabel()],
      ),
    );
  }

  Widget _viewArtist() {
    return Expanded(
        child: Container(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ListView.builder(
          itemCount: 4,
          itemBuilder: (context, index) {
            return const CardAlbum();
          }),
    ));
  }

  Widget _viewLabel() {
    return Expanded(
        child: Container(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ListView.builder(
          itemCount: 4,
          itemBuilder: (context, index) {
            return const CardAlbum();
          }),
    ));
  }

  Widget _tabBar(BuildContext context) {
    return Container(
      height: 80,
      alignment: Alignment.centerLeft,
      child: TabBar(
        controller: _tabController,
        isScrollable: true,
        labelPadding: const EdgeInsets.only(
            left: kDefaultPadding, right: kDefaultPadding),
        indicatorSize: TabBarIndicatorSize.label,
        indicator: CircleIndicator(
          Theme.of(context).colorScheme.primary,
          4.0,
        ),
        unselectedLabelColor: Theme.of(context).unselectedWidgetColor,
        labelColor: Theme.of(context).colorScheme.primary,
        tabs: const <Widget>[
          Tab(
            text: 'Artitsta',
          ),
          Tab(
            text: 'Etichetta',
          ),
        ],
      ),
    );
  }

  Future<void> getAlbumOrderedByEtichetta() async {
    var url = Uri.parse("http://10.0.2.2:8080/api/v1/albums/etichetta");
    final response = await http.get(url);
    if (response.statusCode == 200) {
      var responseBody = jsonDecode(response.body);
      responseBody.forEach((element) {
        print(element);
      });
    }
  }

  Future<void> getAlbumOrderedByArtista() async {
    var url = Uri.parse("http://10.0.2.2:8080/api/v1/albums/artista");
    final response = await http.get(url);
    if (response.statusCode == 200) {
      var responseBody = jsonDecode(response.body);
      responseBody.forEach((element) {
        print(element);
      });
    }
  }
}
