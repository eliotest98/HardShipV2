import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/viewmodels/brano_viewmodel.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
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
              child: AppText(text: "Brani"),
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
        const Padding(
            padding: EdgeInsets.only(left: kDefaultPadding),
            child: AppLargeText(text: 'Tracce')),
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

  artistSongs(BranoViewModel model) {
    return ListView.builder(
        itemCount: model.listBrano.length,
        itemBuilder: (context, index) {
          return Row(
            children: <Widget>[
              ClipRRect(
                borderRadius: BorderRadius.circular(10.0),
                child: Image.asset(
                  model.listBrano[index].anno,
                  fit: BoxFit.cover,
                  height: 50,
                  width: 50,
                ),
              ),
              const SizedBox(
                width: 20.0,
              ),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    model.listBrano[index].titolo,
                    style: const TextStyle(
                        fontFamily: 'Nunito',
                        fontSize: 20,
                        color: Colors.black,
                        fontWeight: FontWeight.bold),
                  ),
                ],
              ),
              Spacer(),
              Text(
                model.listBrano[index].durata,
                style: TextStyle(
                    fontFamily: 'Nunito', fontSize: 20, color: Colors.black),
              ),
              SizedBox(
                width: 20.0,
              ),
            ],
          );
        });
  }
}
