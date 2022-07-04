import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';

import '../widgets/app_large_text.dart';

class NewsDetailsScreen extends StatefulWidget {
  const NewsDetailsScreen({Key? key, required this.news}) : super(key: key);
  final NewsModel news;

  @override
  State<NewsDetailsScreen> createState() => _NewsDetailsScreenState();
}

class _NewsDetailsScreenState extends State<NewsDetailsScreen> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Center(
              child: Padding(
                padding:
                    const EdgeInsets.only(top: 40.0, left: 20.0, right: 20.0),
                child: SizedBox(
                  height: 100,
                  child: Stack(
                    children: <Widget>[
                      ClipRRect(
                        borderRadius: BorderRadius.circular(20.0),
                        child: Image.asset(
                          "assets/png/holliwood.png",
                          fit: BoxFit.cover,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(left: 20.0, top: 30.0),
              child: AppLargeText(
                text: widget.news.titolo,
                size: 20,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(left: 20.0, top: 5.0),
              child: AppLargeText(
                text: widget.news.contenuto,
                size: 20,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
