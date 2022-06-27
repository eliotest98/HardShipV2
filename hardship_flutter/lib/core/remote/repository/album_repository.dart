import 'dart:convert';

import 'package:dartz/dartz.dart';
import 'package:dio/dio.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';

abstract class IAlbumRepository {
  Future<Either<DioError, List<AlbumModel>>> getAlbums();
}

class AlbumRepository implements IAlbumRepository {
  final ApiClient _client;

  AlbumRepository(this._client);

  @override
  Future<Either<DioError, List<AlbumModel>>> getAlbums() async {
    try {
      final response =
          await _client.request("albums/etichetta", method: Method.GET);
      List<AlbumModel> listAlbum = [];
      for (var album in response.data) {
        listAlbum.add(AlbumModel.fromJson(album));
      }
      return Right(listAlbum);
    } on DioError catch (e) {
      return (Left(e));
    }
  }
}
