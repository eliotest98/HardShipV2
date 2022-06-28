import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/news_model.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/screens/news_details_screen.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:hardship_flutter/ui/widgets/shadow_image.dart';

class CardNews extends StatelessWidget {
  const CardNews(
      {Key? key, required this.newsModel, this.size = const Size(180, 180)})
      : super(key: key);
  final NewsModel newsModel;
  final Size size;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: kDefaultPaddingItemList),
      child: Card(
        margin: const EdgeInsets.only(right: kMarginCard),
        elevation: kElevationCard,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(kRadius),
        ),
        child: InkWell(
          onTap: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const NewsDetails()),
            );
          },
          child: Container(
            padding: const EdgeInsets.symmetric(
                vertical: kDefaultPaddingItemList, horizontal: kDefaultPadding),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                ShadowImage(
                  imageProvider:
                      const AssetImage('assets/png/spiderman_album.png'),
                  size: size,
                  borderRadius: BorderRadius.circular(kRadius),
                  offset: const Offset(0, 0),
                ),
                const SizedBox(width: 8.0),
                Expanded(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      AppLargeText(
                        text: newsModel.titolo,
                        size: 20,
                      ),
                      const SizedBox(height: 5),
                      AppText(
                        size: 16.0,
                        text: newsModel.contenuto,
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
