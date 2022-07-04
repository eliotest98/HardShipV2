import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/viewmodels/brano_viewmodel.dart';
import 'package:provider/provider.dart';

import '../../provider/di/get_it.dart';
import '../../provider/models/brano_model.dart';
import '../../provider/viewmodels/base_viewmodel.dart';
import '../constants/app_constants.dart';
import '../widgets/app_large_text.dart';

class AlbumDetails extends StatefulWidget {
  const AlbumDetails({Key? key, required this.albumModel}) : super(key: key);
  final AlbumModel albumModel;

  @override
  State<AlbumDetails> createState() => _AlbumDetailsState();
}

class _AlbumDetailsState extends State<AlbumDetails> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            GestureDetector(
                onTap: () {
                  Navigator.pop(context);
                },
                child: const Padding(
                  padding: EdgeInsets.only(left: 20.0, top: 50.0),
                  child: Icon(
                    Icons.arrow_back_ios,
                    color: Colors.black,
                  ),
                )),
            Center(
              child: Padding(
                padding:
                    const EdgeInsets.only(top: 40.0, left: 20.0, right: 20.0),
                child: SizedBox(
                  height: 100,
                  child: Stack(
                    children: <Widget>[
                      ClipRRect(
                        borderRadius: BorderRadius.circular(20.0),
                        child: Image.asset(
                          "assets/png/holliwood.png",
                          fit: BoxFit.cover,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.only(left: 20.0, top: 30.0),
              child: Text(
                widget.albumModel.copertina,
                style: TextStyle(
                    color: Colors.black,
                    fontFamily: 'Nunito-Bold',
                    fontSize: 20),
              ),
            ),
            Padding(
              padding: EdgeInsets.only(left: 20.0, top: 5.0),
              child: Text(
                widget.albumModel.titolo,
                style: TextStyle(
                    color: Colors.grey,
                    fontFamily: 'Nunito-Regular',
                    fontSize: 20),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(
                  left: 20.0, right: 20.0, top: 30.0, bottom: 20.0),
              child: Container(
                child: ChangeNotifierProvider<BranoViewModel>(
                  create: (BuildContext context) =>
                      BranoViewModel(usecaseBrano: getItInstance())
                        ..getListBrani(widget.albumModel.id),
                  child: Consumer<BranoViewModel>(
                    builder: (BuildContext context, BranoViewModel model, _) {
                      switch (model.state) {
                        case ViewState.initial:
                          Provider.of<BranoViewModel>(context)
                              .getListBrani(widget.albumModel.id);
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
                /*Column(
                  children: <Widget>[
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                    SizedBox(
                      height: 20.0,
                    ),
                    GestureDetector(
                      onTap: () {},
                      child: artistSongs("assets/png/spiderman_album.png",
                          "Sunflower", "Post Malone e Swae Lee", "2:37"),
                    ),
                    SizedBox(
                      height: 20.0,
                    ),
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                    SizedBox(
                      height: 20.0,
                    ),
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                  ],
                ),*/
              ),
            )
          ],
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
          return Container(
            child: Row(
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
                SizedBox(
                  width: 20.0,
                ),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Text(
                      model.listBrano[index].titolo,
                      style: TextStyle(
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
            ),
          );
        });
  }
}
