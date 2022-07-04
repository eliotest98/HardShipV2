import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/error/failure.dart';
import 'package:hardship_flutter/core/remote/repository/brano_repository.dart';

import '../../../provider/models/brano_model.dart';

abstract class IBranoUsecase {
  Future<Either<Failure, List<BranoModel>>> getBrani(int idAlbum);
}

class BranoUsecase extends IBranoUsecase {
  final IBranoRepository repository;

  BranoUsecase(this.repository);

  @override
  Future<Either<Failure, List<BranoModel>>> getBrani(int idAlbum) async {
    final result = await repository.getBrani(idAlbum);

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
