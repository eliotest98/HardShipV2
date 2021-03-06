import 'package:get_it/get_it.dart';
import 'package:hardship_flutter/core/remote/api_client.dart';
import 'package:hardship_flutter/core/remote/repository/album_repository.dart';
import 'package:hardship_flutter/core/remote/repository/brano_repository.dart';
import 'package:hardship_flutter/core/remote/repository/news_repository.dart';
import 'package:hardship_flutter/core/remote/usecases/album_usecase.dart';
import 'package:hardship_flutter/core/remote/usecases/brano_usecase.dart';
import 'package:hardship_flutter/core/remote/usecases/news_usecase.dart';
import 'package:hardship_flutter/provider/viewmodels/album_viewmodel.dart';
import 'package:hardship_flutter/provider/viewmodels/news_viewmodel.dart';

import '../viewmodels/brano_viewmodel.dart';

final getItInstance = GetIt.I;

Future init() async {
  getItInstance.registerLazySingleton<ApiClient>(() => ApiClient());

  getItInstance.registerLazySingleton<INewsRepository>(
      () => NewsRepository(getItInstance()));

  getItInstance.registerLazySingleton<NewsProvider>(
      () => NewsProvider(usecaseNews: getItInstance()));

  getItInstance.registerLazySingleton<AlbumViewModel>(
      () => AlbumViewModel(usecaseAlbum: getItInstance()));

  getItInstance.registerLazySingleton<IAlbumRepository>(
      () => AlbumRepository(getItInstance()));

  getItInstance.registerLazySingleton<IAlbumUsecase>(
      () => AlbumUsecase(getItInstance()));

  getItInstance.registerLazySingleton<BranoViewModel>(
      () => BranoViewModel(usecaseBrano: getItInstance()));

  getItInstance.registerLazySingleton<IBranoRepository>(
      () => BranoRepository(getItInstance()));

  getItInstance.registerLazySingleton<IBranoUsecase>(
      () => BranoUsecase(getItInstance()));

  getItInstance
      .registerLazySingleton<INewsUsecase>(() => NewsUsecase(getItInstance()));
}
