import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';
import 'package:hardship_flutter/provider/viewmodels/news_viewmodel.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_drawer.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/card_news.dart';
import 'package:provider/provider.dart';

import '../../provider/di/get_it.dart';
import '../../provider/viewmodels/base_viewmodel.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        key: _scaffoldKey,
        backgroundColor: Colors.white,
        drawer: AppDrawer(),
        body: SafeArea(
          child: Container(
            padding: const EdgeInsets.only(
                left: kDefaultPadding, right: kDefaultPadding),
            child: SingleChildScrollView(
              physics: const BouncingScrollPhysics(),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _buildHeader(),
                  const SizedBox(height: 8.0),
                  _buildBody()
                ],
              ),
            ),
          ),
        ));
  }

  Widget _buildHeader() {
    return Row(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          IconButton(
            alignment: Alignment.centerLeft,
            padding: const EdgeInsets.all(0.0),
            icon: const Icon(
              Icons.menu,
              size: 32,
            ),
            onPressed: () {
              _scaffoldKey.currentState?.openDrawer();
            },
          ),
        ]);
  }

  Widget _buildBody() {
    return Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          const AppLargeText(
            text: 'News',
          ),
          const SizedBox(height: 10),
          SizedBox(
            width: double.infinity,
            child: ChangeNotifierProvider<NewsProvider>(
              create: (BuildContext context) =>
                  NewsProvider(usecaseNews: getItInstance())..getListNews(),
              child: Consumer<NewsProvider>(
                builder: (BuildContext context, NewsProvider model, _) {
                  switch (model.state) {
                    case ViewState.initial:
                      //Provider.of<NewsProvider>(context).getListNews();
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
        ]);
  }

  Widget _buildLoading() {
    return const Center(
      child: CircularProgressIndicator(),
    );
  }

  Widget _buildInitial() {
    return const SizedBox();
  }

  Widget _buildLoaded(BuildContext context, NewsProvider model) {
    List<NewsModel> listNews = model.getListNewsOrdered;
    return SizedBox(
      width: double.infinity,
      child: ListView.builder(
        shrinkWrap: true,
        scrollDirection: Axis.horizontal,
        physics: const BouncingScrollPhysics(),
        itemCount: listNews.length,
        itemBuilder: (BuildContext context, int index) {
          return CardNews(
            newsModel: listNews[index],
          );
        },
      ),
    );
  }

  /*Widget _viewNews(NewsProvider model) {
    List<NewsModel> listNews = model.getListNewsOrdered;
    return Expanded(
        child: Container(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ListView.builder(
          itemCount: listNews.length,
          itemBuilder: (context, index) {
            return CardNews(newsModel: listNews[index]);
          }),
    ));
  }*/

  Widget _buildError() {
    return const Center(
      child: AppLargeText(
        text: 'Al momento non è stato possibile recuperare le news',
      ),
    );
  }
}
