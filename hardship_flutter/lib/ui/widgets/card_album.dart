import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:hardship_flutter/ui/widgets/shadow_image.dart';

class CardAlbum extends StatelessWidget {
  const CardAlbum({Key? key, this.size = const Size(60, 60)}) : super(key: key);
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
                  children: const [
                    AppLargeText(
                      text: 'Album 1',
                      size: 20,
                    ),
                    SizedBox(height: 5),
                    AppText(
                      size: 16.0,
                      text:
                          'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
