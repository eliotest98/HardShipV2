import 'package:flutter/material.dart';
import 'package:just_audio/just_audio.dart';

class MusicViewModel extends ChangeNotifier {
  late AudioPlayer _audioPlayer;

  MusicViewModel() {
    _audioPlayer = AudioPlayer();
  }
  get audioPlayer => _audioPlayer;

  void play(String url) {
    _audioPlayer.setUrl(url);
    _audioPlayer.play();
  }

  void dispose() {
    _audioPlayer.stop();
    super.dispose();
  }
}
