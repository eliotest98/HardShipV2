import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/repository/news_repository.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';

import '../error/failure.dart';

abstract class INewsUsecase {
  Future<Either<Failure, List<NewsModel>>> getNews();
}

class NewsUsecase extends INewsUsecase {
  final INewsRepository repository;

  NewsUsecase(this.repository);

  @override
  Future<Either<Failure, List<NewsModel>>> getNews() async {
    final result = await repository.getNews();

    return result.fold((l) {
      if (l.type == DioErrorType.connectTimeout) {
        return Left(Failure.noConnectionFailure());
      } else if (l.type == DioErrorType.receiveTimeout) {
        return Left(Failure.serverFailure());
      } else if (l.type == DioErrorType.response) {
        return Left(Failure.dataParsingFailure());
      }
      return Left(Failure.serverFailure());
    }, (r) {
      return Right(r);
    });
  }
}
