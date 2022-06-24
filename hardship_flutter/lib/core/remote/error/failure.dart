import 'package:hardship_flutter/core/remote/error/exceptions.dart';

abstract class Failure {
  const Failure();
  dynamic when(
      {required dynamic Function() serverFailure,
      required dynamic Function() dataParsingFailure,
      required dynamic Function() noConnectionFailure}) {
    final _this = this;
    if (_this is ServerException) {
      return serverFailure();
    } else if (_this is DataParsingException) {
      return dataParsingFailure();
    } else if (_this is NoConnectionException) {
      return noConnectionFailure();
    }
    throw Exception('Failure $_this was not mapped');
  }

  factory Failure.serverFailure() => ServerException();
  factory Failure.dataParsingFailure() => DataParsingException();
  factory Failure.noConnectionFailure() => NoConnectionException();
}
