import 'package:hardship_flutter/core/remote/error/exceptions.dart';

abstract class Failure {
  const Failure();
  dynamic when(
      {required dynamic Function() serverFailure,
      required dynamic Function() dataParsingFailure,
      required dynamic Function() noConnectionFailure}) {
    if (this is ServerException) {
      return serverFailure();
    } else if (this is DataParsingException) {
      return dataParsingFailure();
    } else if (this is NoConnectionException) {
      return noConnectionFailure();
    }
    throw Exception('Failure $this was not mapped');
  }

  factory Failure.serverFailure() => ServerException();
  factory Failure.dataParsingFailure() => DataParsingException();
  factory Failure.noConnectionFailure() => NoConnectionException();
}
