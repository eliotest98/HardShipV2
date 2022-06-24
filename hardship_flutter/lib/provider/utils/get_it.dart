import 'package:get_it/get_it.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/core/remote/repository/album_repository.dart';
import 'package:hardship_flutter/core/remote/usecases/album_usecase.dart';

final getItInstance = GetIt.I;

Future init() async {
  getItInstance.registerLazySingleton<ApiClient>(() => ApiClient());
  getItInstance.registerLazySingleton<IAlbumRepository>(
      () => AlbumRepository(getItInstance()));

  getItInstance.registerLazySingleton<IAlbumUsecase>(
      () => AlbumUsecase(getItInstance()));
}
