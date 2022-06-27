import 'package:flutter/material.dart';

enum ViewState { initial, loding, loaded, error }

class BaseViewModel extends ChangeNotifier {
  ViewState _state = ViewState.initial;

  ViewState get state => _state;

  void setState(ViewState viewState) {
    _state = viewState;
    notifyListeners();
  }
}
