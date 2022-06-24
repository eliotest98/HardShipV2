// ignore_for_file: constant_identifier_names

import 'dart:io';

import 'package:dio/dio.dart';

enum Method { POST, GET, PUT, DELETE, PATCH }

class ApiClient {
  late Dio _client;
  final String baseUrl = "http://localhost:3000/api/v1/";
  static header() => {"Content-Type": "application/json"};

  ApiClient() {
    _setup();
  }

  void _setup() {
    _client = Dio(BaseOptions(
      baseUrl: baseUrl,
      receiveTimeout: 15000, // 15 seconds
      connectTimeout: 15000,
      sendTimeout: 15000,
    ));
  }

  Future<dynamic> request(String url,
      {Method? method,
      Map<String, dynamic>? params,
      Map<String, dynamic>? queryParams, //per il momento non è utilizzato
      String? token}) async {
    switch (method) {
      case Method.GET:
        return _getData(url: url, query: params, token: token);
      case Method.POST:
        return _postData(url: url, query: params, token: token);
      case Method.PUT:
        return _putData(url: url, query: params, token: token);
      case Method.DELETE:
        return _deleteData(url: url, query: params, token: token);
      case Method.PATCH:
        return _patchData(url: url, query: params, token: token);
      default:
        return null;
    }
  }

  Future<Response> _getData({
    required String url,
    Map<String, dynamic>? query,
    String lang = 'it',
    String? token,
  }) async {
    _client.options.headers = {
      'Content-Type': 'application/json',
      'lang': lang,
      'Authorization': token != null ? "Bearer $token" : '',
    };
    return await _client.get(url, queryParameters: query);
  }

  Future<Response> _postData({
    required String url,
    Map<String, dynamic>? query,
    String lang = 'it',
    String? token,
  }) async {
    _client.options.headers = {
      'Content-Type': 'application/json',
      'lang': lang,
      'Authorization': token != null ? " Bearer $token" : '',
    };
    return await _client.post(url, queryParameters: query);
  }

  Future<Response> _putData({
    required String url,
    Map<String, dynamic>? query,
    String lang = 'it',
    String? token,
  }) async {
    _client.options.headers = {
      'Content-Type': 'application/json',
      'lang': lang,
      'Authorization': token != null ? "Bearer $token" : '',
    };
    return await _client.put(url, queryParameters: query);
  }

  Future<Response> _deleteData({
    required String url,
    Map<String, dynamic>? query,
    String lang = 'it',
    String? token,
  }) async {
    _client.options.headers = {
      'Content-Type': 'application/json',
      'lang': lang,
      'Authorization': token != null ? "Bearer $token" : '',
    };
    return await _client.delete(url, queryParameters: query);
  }

  Future<Response> _patchData({
    required String url,
    Map<String, dynamic>? query,
    String lang = 'it',
    String? token,
  }) async {
    _client.options.headers = {
      'Content-Type': 'application/json',
      'lang': lang,
      'Authorization': token != null ? "Bearer $token" : '',
    };
    return await _client.patch(url, queryParameters: query);
  }
}

extension DioErrorX on DioError {
  bool get isNoConnectionError =>
      type == DioErrorType.other &&
      error is SocketException; // import 'dart:io' for SocketException
}
