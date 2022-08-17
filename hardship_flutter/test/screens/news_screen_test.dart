import 'package:dartz/dartz.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hardship_flutter/core/remote/repository/news_repository.dart';
import 'package:hardship_flutter/core/remote/usecases/news_usecase.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';
import 'package:hardship_flutter/provider/viewmodels/news_viewmodel.dart';
import 'package:hardship_flutter/ui/screens/home_screen.dart';
import 'package:mockito/mockito.dart';
import 'package:provider/provider.dart';

class MockRepository extends Mock implements INewsRepository {}

class MockUseCase extends Mock implements INewsUsecase {}

void main() {
  late MockUseCase newsUseCase;

  List<NewsModel> listNews = [
    NewsModel(
        1,
        'Ogni giovedì, fino al 25 agosto, una serie di appuntamenti con musica dal vivo e dj set nel Villaggio dello shopping emiliano',
        '04-07-2022',
        'RollingStoneMagazine',
        'Continua il Fidenza Village Sound Festival',
        'jakelafuria.jpeg',
        'Pop',
        'root'),
    NewsModel(
        2,
        'Un nuovo festival per l\'estate ferrarese con grandi nomi del panorama trap e pop italiano ',
        '05-07-2022',
        'RollingStoneMagazine',
        'Al via il Summer Vibez',
        'BLANCO.jpeg',
        'Pop',
        'root'),
    NewsModel(
        3,
        'Dal 12 al 14 agosto, ad Helsinki, torna uno dei festival europei più interessanti con Gorillaz, Florence + The Machine e Nick Cave & The Bad Seeds',
        '06-07-2022',
        'RollingStoneMagazine',
        'Il Flow Festival è la fuga ideale per l’estate',
        'baloonflowfestival.jpeg',
        'Pop',
        'root'),
    NewsModel(
        4,
        '«È così da fine anni ’80 e ancora non lo avete capito, che palle. Io avrò anche la vostra età, ma godo quando vi chiamano boomer. La maggior parte di quelli che criticano i trapper sono musicisti falliti»',
        '07-07-2022',
        'RollingStoneMagazine',
        'J-Ax: e il suo sfogo',
        'jax.jpeg',
        'Pop',
        'root'),
  ];

  setUp(() {
    // mockRepository = MockRepository();
    newsUseCase = MockUseCase();
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

  Widget createWidgetCallGetListNews() {
    return MaterialApp(
      title: 'News Screen',
      home: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: true,
        ),
        body: SafeArea(
          child: ChangeNotifierProvider<NewsProvider>(
              create: (BuildContext context) =>
                  NewsProvider(usecaseNews: newsUseCase)..getListNews(),
              child: BodyNews()),
        ),
      ),
    );
  }

  Widget createWidgetUnderTest() {
    return MaterialApp(
      title: 'News Screen',
      home: Scaffold(
        appBar: AppBar(
          automaticallyImplyLeading: true,
        ),
        body: SafeArea(
          child: ChangeNotifierProvider<NewsProvider>(
              create: (BuildContext context) =>
                  NewsProvider(usecaseNews: newsUseCase),
              child: BodyNews()),
        ),
      ),
    );
  }

  void newsUseCaseReturn() {
    //  when(mockRepository.getAlbums()).thenAnswer((_) async => Right(listNews));
    when(newsUseCase.getNews()).thenAnswer((_) async => Right(listNews));
  }

  void newsUseCaseReturn3AfterTwoSecond() {
    // when(mockRepository.getAlbums()).thenAnswer((_) async => Right(listNews));
    when(newsUseCase.getNews()).thenAnswer((_) async {
      await Future.delayed(const Duration(seconds: 3));
      return Right(listNews);
    });
  }

  testWidgets(
    "initial state News Screen",
    (WidgetTester tester) async {
      await tester.pumpWidget(createWidgetUnderTest());
      expect(find.byKey(const Key('__initial__')), findsOneWidget);
    },
  );

  testWidgets(
    "loading indicator is displayed while waiting for news",
    (WidgetTester tester) async {
      newsUseCaseReturn3AfterTwoSecond();

      await tester.pumpWidget(createWidgetCallGetListNews());
      await tester.pump(const Duration(milliseconds: 500));

      expect(find.byKey(const Key('progress-indicator')), findsOneWidget);

      await tester.pumpAndSettle();
    },
  );

  testWidgets(
    "news are displayed",
    (WidgetTester tester) async {
      newsUseCaseReturn();
      await tester.pumpWidget(createWidgetCallGetListNews());

      await tester.pump(const Duration(milliseconds: 3000));

      expect(find.byKey(const Key('__loaded__')), findsOneWidget);
      await tester.pumpAndSettle();
    },
  );
}
