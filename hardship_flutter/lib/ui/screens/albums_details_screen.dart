import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/models/brano_model.dart';
import 'package:hardship_flutter/provider/viewmodels/brano_viewmodel.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:hardship_flutter/ui/widgets/card_brano.dart';
import 'package:provider/provider.dart';

import '../../provider/di/get_it.dart';
import '../../provider/viewmodels/base_viewmodel.dart';
import '../constants/app_constants.dart';
import '../widgets/app_large_text.dart';

class AlbumDetailsScreen extends StatefulWidget {
  const AlbumDetailsScreen({Key? key, required this.albumModel})
      : super(key: key);
  final AlbumModel albumModel;

  @override
  State<AlbumDetailsScreen> createState() => _AlbumDetailsScreenState();
}

class _AlbumDetailsScreenState extends State<AlbumDetailsScreen> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: SingleChildScrollView(
        scrollDirection: Axis.vertical,
        physics: const BouncingScrollPhysics(),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            _coverAlbum(),
            Padding(
              padding:
                  const EdgeInsets.only(left: 20.0, right: 20.0, top: 16.0),
              child: AppLargeText(
                text: widget.albumModel.titolo,
              ),
            ),
            const Padding(
              padding: EdgeInsets.only(left: 20.0, right: 20.0),
            ),
            Padding(
              padding:
                  const EdgeInsets.only(left: 20.0, right: 20.0, top: 16.0),
              child: ChangeNotifierProvider<BranoViewModel>(
                create: (BuildContext context) =>
                    BranoViewModel(usecaseBrano: getItInstance())
                      ..getListBrani(widget.albumModel.id),
                child: Consumer<BranoViewModel>(
                  builder: (BuildContext context, BranoViewModel model, _) {
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
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget _coverAlbum() {
    return Container(
      width: MediaQuery.of(context).size.width,
      height: 300,
      decoration: BoxDecoration(
        image: DecorationImage(
          fit: BoxFit.fill,
          image: NetworkImage(widget.albumModel.copertina),
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

  Widget _buildLoaded(BuildContext context, BranoViewModel model) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        AppLargeText(text: 'Tracce'),
        artistSongs(model),
      ],
    );
  }

  Widget _buildError() {
    return const Center(
      child: AppLargeText(
        text: 'Al momento non è stato possibile recuperare le tracce',
      ),
    );
  }

  Widget artistSongs(BranoViewModel model) {
    List<BranoModel> listBrani = model.listBrano;
    return ListView.builder(
        scrollDirection: Axis.vertical,
        shrinkWrap: true,
        itemCount: listBrani.length,
        itemBuilder: (context, index) {
          return CardBrano(
            brano: listBrani[index],
          );
        });
  }
}
