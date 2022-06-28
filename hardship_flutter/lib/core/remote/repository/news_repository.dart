import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';

abstract class INewsRepository {
  Future<Either<DioError, List<NewsModel>>> getNews();
}

class NewsRepository implements INewsRepository {
  final ApiClient _client;

  NewsRepository(this._client);

  @override
  Future<Either<DioError, List<NewsModel>>> getNews() async {
    try {
      final response =
          await _client.request("news/allNews", method: Method.GET);
      List<NewsModel> listNews = [];
      for (var news in response.data) {
        listNews.add(NewsModel.fromJson(news));
      }
      return Right(listNews);
    } on DioError catch (e) {
      return (Left(e));
    }
  }
}
