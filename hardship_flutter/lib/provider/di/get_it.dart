import 'package:get_it/get_it.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/core/remote/repository/album_repository.dart';
import 'package:hardship_flutter/core/remote/repository/news_repository.dart';
import 'package:hardship_flutter/core/remote/usecases/album_usecase.dart';
import 'package:hardship_flutter/core/remote/usecases/news_usecase.dart';

final getItInstance = GetIt.I;

Future init() async {
  getItInstance.registerLazySingleton<ApiClient>(() => ApiClient());

  getItInstance.registerLazySingleton<INewsRepository>(
      () => NewsRepository(getItInstance()));

  getItInstance.registerLazySingleton<IAlbumRepository>(
      () => AlbumRepository(getItInstance()));

  getItInstance.registerLazySingleton<IAlbumUsecase>(
      () => AlbumUsecase(getItInstance()));

  getItInstance
      .registerLazySingleton<INewsUsecase>(() => NewsUsecase(getItInstance()));
}
