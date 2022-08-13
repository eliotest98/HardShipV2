import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/error/failure.dart';
import 'package:hardship_flutter/core/remote/repository/album_repository.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';

abstract class IAlbumUsecase {
  Future<Either<Failure, List<AlbumModel>>>? getAlbums();
}

class AlbumUsecase extends IAlbumUsecase {
  final IAlbumRepository repository;

  AlbumUsecase(this.repository);

  @override
  Future<Either<Failure, List<AlbumModel>>>? getAlbums() async {
    final result = await repository.getAlbums();

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
