import 'package:hardship_flutter/core/remote/error/error_object.dart';
import 'package:hardship_flutter/core/remote/error/failure.dart';
import 'package:hardship_flutter/core/remote/usecases/brano_usecase.dart';
import 'package:hardship_flutter/provider/models/brano_model.dart';
import 'package:hardship_flutter/provider/viewmodels/base_viewmodel.dart';

class BranoViewModel extends BaseViewModel {
  final IBranoUsecase usecaseBrano;

  BranoViewModel({required this.usecaseBrano});

  List<BranoModel> _listBrano = [];
  ErrorObject? error;

  List<BranoModel> get listBrano => _listBrano;

  Future<void> getListBrani(int idAlbum) async {
    setState(ViewState.loding);
    final result = await usecaseBrano.getBrani(idAlbum);
    await Future.delayed(const Duration(seconds: 1));
    result.fold((failure) {
      _setError(failure);
    }, (result) {
      _setListBrani(result);
    });
  }

  void _setListBrani(List<BranoModel> listBrano) {
    _listBrano = listBrano;
    setState(ViewState.loaded);
  }

  void _setError(Failure f) {
    error = ErrorObject.mapFailureToErrorObject(failure: f);
    setState(ViewState.error);
  }
}
