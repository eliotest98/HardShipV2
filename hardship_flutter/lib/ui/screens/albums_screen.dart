import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/di/get_it.dart';
import 'package:hardship_flutter/provider/viewmodels/album_viewmodel.dart';
import 'package:hardship_flutter/provider/viewmodels/base_viewmodel.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/card_album.dart';
import 'package:hardship_flutter/ui/widgets/circle_indicator.dart';
import 'package:provider/provider.dart';

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
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: true,
      ),
      body: ChangeNotifierProvider<AlbumViewModel>(
        create: (BuildContext context) =>
            AlbumViewModel(usecaseAlbum: getItInstance()),
        child: Consumer<AlbumViewModel>(
          builder: (BuildContext context, AlbumViewModel model, _) {
            switch (model.state) {
              case ViewState.initial:
                return _buildInitial();
              case ViewState.loding:
                return _buildLoading();
              case ViewState.loaded:
                return _buildLoaded(context, model);
              case ViewState.error:
                return _buildError(context, model);
            }
          },
        ),
      ),
    );
  }

  Widget _buildLoading() {
    return const Center(
      child: CircularProgressIndicator(),
    );
  }

  Widget _buildInitial() {
    return const SizedBox();
  }

  Widget _buildLoaded() {
    return const SizedBox();
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
}
