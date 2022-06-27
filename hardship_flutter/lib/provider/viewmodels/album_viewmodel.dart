import 'package:hardship_flutter/core/remote/error/error_object.dart';
import 'package:hardship_flutter/core/remote/error/failure.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/viewmodels/base_viewmodel.dart';

import '../../core/remote/usecases/album_usecase.dart';

class AlbumViewModel extends BaseViewModel {
  final IAlbumUsecase usecaseAlbum;

  AlbumViewModel({required this.usecaseAlbum});

  List<AlbumModel> _listAlbum = [];
  ErrorObject? error;

  List<AlbumModel> get listAlbum => _listAlbum;

  List<AlbumModel> get getListAlbumOrderedByEtichetta {
    _listAlbum.sort((a, b) => a.idEtichetta.compareTo(b.idEtichetta));
    return _listAlbum;
  }

  List<AlbumModel> get getListAlbumOrderedByArtista {
    _listAlbum.sort((a, b) => a.idArtista.compareTo(b.idArtista));
    return _listAlbum;
  }

  Future<void> getListAlbum() async {
    setState(ViewState.loding);
    final result = await usecaseAlbum.getAlbums();
    await Future.delayed(const Duration(seconds: 1));
    result.fold((failure) {
      _setError(failure);
    }, (result) {
      _setListAlbum(result);
    });
  }

  void _setListAlbum(List<AlbumModel> listAlbum) {
    _listAlbum = listAlbum;
    setState(ViewState.loaded);
  }

  void _setError(Failure f) {
    error = ErrorObject.mapFailureToErrorObject(failure: f);
    setState(ViewState.error);
  }
}
