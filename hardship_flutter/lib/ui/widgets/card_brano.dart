import 'package:flutter/material.dart';
import 'package:hardship_flutter/provider/models/brano_model.dart';
import 'package:hardship_flutter/provider/viewmodels/music_viewmodel.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/routes/route_constants.dart';
import 'package:hardship_flutter/ui/routes/routes.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';
import 'package:hardship_flutter/ui/widgets/shadow_image.dart';
import 'package:provider/provider.dart';

class CardBrano extends StatelessWidget {
  const CardBrano(
      {Key? key, required this.brano, this.size = const Size(60, 60)})
      : super(key: key);
  final BranoModel brano;
  final Size size;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: kDefaultPaddingItemList),
      child: ChangeNotifierProvider<MusicViewModel>(
        lazy: false,
        create: (_) => MusicViewModel(),
        child: Consumer<MusicViewModel>(
          builder: (BuildContext context, MusicViewModel model, _) {
            return Card(
              margin: const EdgeInsets.only(right: kMarginCard),
              elevation: kElevationCard,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(kRadius),
              ),
              child: InkWell(
                child: Container(
                  padding: const EdgeInsets.symmetric(
                      vertical: kDefaultPaddingItemList,
                      horizontal: kDefaultPadding),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      /*ShadowImage(
                  imageProvider: NetworkImage(album.copertina),
                  size: size,
                  borderRadius: BorderRadius.circular(kRadius),
                  offset: const Offset(0, 0),
                ),*/
                      const SizedBox(width: 8.0),
                      Expanded(
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.start,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            AppLargeText(
                              text: brano.titolo,
                              size: 20,
                            ),
                            const SizedBox(height: 5),
                            AppText(
                              size: 16.0,
                              text: brano.durata,
                            ),
                          ],
                        ),
                      ),
                      IconButton(
                        icon: Icon(Icons.play_circle_outline),
                        onPressed: () {
                          Provider.of<MusicViewModel>(context, listen: false)
                              .play(brano.traccia);
                        },
                      ),
                    ],
                  ),
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}
