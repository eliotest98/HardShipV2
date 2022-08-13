import 'package:dartz/dartz.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hardship_flutter/core/remote/repository/album_repository.dart';
import 'package:hardship_flutter/core/remote/usecases/album_usecase.dart';
import 'package:hardship_flutter/provider/models/album_model.dart';
import 'package:hardship_flutter/provider/viewmodels/album_viewmodel.dart';
import 'package:hardship_flutter/ui/screens/albums_screen.dart';
import 'package:mockito/mockito.dart';
import 'package:provider/provider.dart';

class MockRepository extends Mock implements IAlbumRepository {}

class MockUseCase extends Mock implements IAlbumUsecase {}

void main() {
  late MockUseCase albumUsecase;
  //late MockRepository mockRepository;

  List<AlbumModel> listAlbum = [
    AlbumModel(01, "rock", "In the end", "", 3, "", "", "", "", 01, 02),
    AlbumModel(02, "pop", "Time", "", 3, "", "", "", "", 01, 02),
    AlbumModel(03, "disco", "Work hard", "", 3, "", "", "", "", 01, 02),
    AlbumModel(01, "rock", " the end", "", 4, "", "", "", "", 01, 02),
  ];

  setUp(() {
    // mockRepository = MockRepository();
    albumUsecase = MockUseCase();
  });

  // test(
  //   'should get trivia for the number from the repository',
  //   () async {
  //     when(mockRepository.getAlbums()).thenAnswer((_) async => Right(listNews));

  //     final result = await albumUsecase.getAlbums();

  //     expect(result, Right(listNews));

  //     verify(mockRepository.getAlbums());

  //     verifyNoMoreInteractions(mockRepository);
  //   },
  // );

  Widget createWidgetCallGetListAlbum() {
    return MaterialApp(
      title: 'Albums Screen',
      home: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: true,
        ),
        body: SafeArea(
          child: ChangeNotifierProvider<AlbumViewModel>(
              create: (BuildContext context) =>
                  AlbumViewModel(usecaseAlbum: albumUsecase)..getListAlbum(),
              child: BodyAlbum()),
        ),
      ),
    );
  }

  Widget createWidgetUnderTest() {
    return MaterialApp(
      title: 'Albums Screen',
      home: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: true,
        ),
        body: SafeArea(
          child: ChangeNotifierProvider<AlbumViewModel>(
              create: (BuildContext context) =>
                  AlbumViewModel(usecaseAlbum: albumUsecase),
              child: BodyAlbum()),
        ),
      ),
    );
  }

  void albumUseCaseReturn() {
    //  when(mockRepository.getAlbums()).thenAnswer((_) async => Right(listNews));
    when(albumUsecase.getAlbums()).thenAnswer((_) async => Right(listAlbum));
  }

  void albumUseCaseReturn3AfterTwoSecond() {
    // when(mockRepository.getAlbums()).thenAnswer((_) async => Right(listNews));
    when(albumUsecase.getAlbums()).thenAnswer((_) async {
      await Future.delayed(const Duration(seconds: 3));
      return Right(listAlbum);
    });
  }

  testWidgets(
    "initial state Album Screen",
    (WidgetTester tester) async {
      await tester.pumpWidget(createWidgetUnderTest());
      expect(find.byKey(const Key('__initial__')), findsOneWidget);
    },
  );

  testWidgets(
    "loading indicator is displayed while waiting for album",
    (WidgetTester tester) async {
      albumUseCaseReturn3AfterTwoSecond();

      await tester.pumpWidget(createWidgetCallGetListAlbum());
      await tester.pump(const Duration(milliseconds: 500));

      expect(find.byKey(const Key('progress-indicator')), findsOneWidget);

      await tester.pumpAndSettle();
    },
  );

  testWidgets(
    "articles are displayed",
    (WidgetTester tester) async {
      albumUseCaseReturn();
      await tester.pumpWidget(createWidgetCallGetListAlbum());

      await tester.pump(const Duration(milliseconds: 3000));

      expect(find.byKey(const Key('__loaded__')), findsOneWidget);
      await tester.pumpAndSettle();
    },
  );
}
