import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/di/get_it.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/viewmodels/album_viewmodel.dart';
import 'package:hardship_flutter/provider/viewmodels/base_viewmodel.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/card_album.dart';
import 'package:hardship_flutter/ui/widgets/circle_indicator.dart';
import 'package:provider/provider.dart';

class AlbumsScreen extends StatelessWidget {
  const AlbumsScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: true,
        ),
        body: SafeArea(
          child: ChangeNotifierProvider<AlbumViewModel>(
              create: (BuildContext context) =>
                  AlbumViewModel(usecaseAlbum: getItInstance())..getListAlbum(),
              child: const BodyAlbum()),
        ));
  }
}

class BodyAlbum extends StatefulWidget {
  const BodyAlbum({Key? key}) : super(key: key);

  @override
  State<BodyAlbum> createState() => _BodyAlbumState();
}

class _BodyAlbumState extends State<BodyAlbum> with TickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 2, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<AlbumViewModel>(
      builder: (BuildContext context, AlbumViewModel model, _) {
        switch (model.state) {
          case ViewState.initial:
            return _buildInitial();
          case ViewState.loding:
            return _buildLoading();
          case ViewState.loaded:
            return _buildLoaded(context, model);
          case ViewState.error:
            return _buildError();
        }
      },
    );
  }

  Widget _buildLoading() {
    return const Center(
      child: CircularProgressIndicator(
        key: Key('progress-indicator'),
      ),
    );
  }

  Widget _buildInitial() {
    return const SizedBox(
      key: Key('__initial__'),
    );
  }

  Widget _buildLoaded(BuildContext context, AlbumViewModel model) {
    return Column(
      key: const Key('__loaded__'),
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const Padding(
            padding: EdgeInsets.only(left: kDefaultPadding),
            child: AppLargeText(text: 'Albums')),
        _tabBar(context, model),
        _tabBarView(model)
      ],
    );
  }

  Widget _buildError() {
    return const Center(
      child: AppLargeText(
        text: 'Al momento non è stato possibile recuperare gli album',
      ),
    );
  }

  Widget _tabBarView(AlbumViewModel model) {
    return Expanded(
      child: TabBarView(
        controller: _tabController,
        children: [_viewArtist(model), _viewLabel(model)],
      ),
    );
  }

  Widget _viewArtist(AlbumViewModel model) {
    List<AlbumModel> listAlbum = model.getListAlbumOrderedByArtista;
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ListView.builder(
          itemCount: listAlbum.length,
          itemBuilder: (context, index) {
            return CardAlbum(
              album: listAlbum[index],
            );
          }),
    );
  }

  Widget _viewLabel(AlbumViewModel model) {
    List<AlbumModel> listAlbum = model.getListAlbumOrderedByEtichetta;
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ListView.builder(
          key: const Key('__loaded__'),
          itemCount: listAlbum.length,
          itemBuilder: (context, index) {
            return CardAlbum(
              album: listAlbum[index],
            );
          }),
    );
  }

  Widget _tabBar(BuildContext context, AlbumViewModel model) {
    return Container(
      height: 80,
      alignment: Alignment.centerLeft,
      child: TabBar(
        onTap: (value) {
          // if(value == 0){
          //   Provider.of<AlbumViewModel>(context).orderByEtichetta();
          // } else if(value == 1){
          //   Provider.of<AlbumViewModel>(context).orderByArtista();
          // }
        },
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
