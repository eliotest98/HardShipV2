import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/screens/news_details_screen.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:hardship_flutter/ui/widgets/shadow_image.dart';

class CardNews extends StatelessWidget {
  const CardNews({Key? key, this.size = const Size(180, 180)})
      : super(key: key);
  final Size size;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(right: kMarginCard),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          InkWell(
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => const NewsDetails()),
              );
              print("click news");
            },
            child: ShadowImage(
              imageProvider: const AssetImage('assets/png/spiderman_album.png'),
              size: const Size(180, 180),
              borderRadius: BorderRadius.circular(kRadius),
              offset: const Offset(-5, 15),
            ),
          ),
          const SizedBox(height: 20),
          SizedBox(
            width: size.width,
            child: const AppLargeText(
              text: 'News Ciccio',
              size: 20,
            ),
          ),
          const SizedBox(height: 5),
          SizedBox(
            width: size.width,
            child: const AppText(
              text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
            ),
          )
        ],
      ),
    );
  }
}
