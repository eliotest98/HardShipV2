import 'package:hardship_flutter/core/remote/error/error_object.dart';
import 'package:hardship_flutter/core/remote/error/failure.dart';
import 'package:hardship_flutter/core/remote/usecases/news_usecase.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';
import 'package:hardship_flutter/provider/viewmodels/base_viewmodel.dart';

class NewsProvider extends BaseViewModel {
  final INewsUsecase usecaseNews;

  NewsProvider({required this.usecaseNews});

  List<NewsModel> _listNews = [];
  ErrorObject? error;

  List<NewsModel> get listNews => _listNews;

  List<NewsModel> get getListNewsOrdered {
    return _listNews;
  }

  Future<void> getListNews() async {
    setState(ViewState.loding);
    final result = await usecaseNews.getNews();
    await Future.delayed(const Duration(seconds: 1));
    result.fold((failure) {
      _setError(failure);
    }, (result) {
      _setListNews(result);
    });
  }

  void _setListNews(List<NewsModel> listNews) {
    _listNews = listNews;
    setState(ViewState.loaded);
    notifyListeners();
  }

  void _setError(Failure f) {
    error = ErrorObject.mapFailureToErrorObject(failure: f);
    setState(ViewState.error);
    notifyListeners();
  }
}
