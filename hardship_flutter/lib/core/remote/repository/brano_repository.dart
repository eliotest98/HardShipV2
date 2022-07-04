import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/provider/models/brano_model.dart';

abstract class IBranoRepository {
  Future<Either<DioError, List<BranoModel>>> getBrani(int idAlbum);
}

class BranoRepository implements IBranoRepository {
  final ApiClient _client;

  BranoRepository(this._client);

  @override
  Future<Either<DioError, List<BranoModel>>> getBrani(int idAlbum) async {
    try {
      final response =
          await _client.request("/brani/album/$idAlbum", method: Method.GET);
      List<BranoModel> listBrani = [];
      for (var brano in response.data) {
        listBrani.add(BranoModel.fromJson(brano));
      }
      return Right(listBrani);
    } on DioError catch (e) {
      return (Left(e));
    }
  }
}
