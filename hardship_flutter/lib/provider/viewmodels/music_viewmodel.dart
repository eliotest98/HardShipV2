import 'package:flutter/material.dart';
import 'package:hardship_flutter/core/utils/PlayerManager.dart';

class MusicViewModel extends ChangeNotifier {
  late PLayerManager pLayerManager;

  MusicViewModel() {
    pLayerManager = PLayerManager();
  }

  void play(String url) {
    pLayerManager.audioPlayer.setUrl(url);
    pLayerManager.audioPlayer.play();
  }

  void dispose() {
    pLayerManager.audioPlayer.stop();
    super.dispose();
  }
}
