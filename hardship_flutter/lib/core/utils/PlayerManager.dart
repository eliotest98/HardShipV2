import 'package:just_audio/just_audio.dart';

class PLayerManager {
  PLayerManager._init();
  static final PLayerManager _instance = PLayerManager._init();

  late AudioPlayer _audioPlayer;

  factory PLayerManager() {
    _instance._audioPlayer = AudioPlayer();
    return _instance;
  }

  get audioPlayer => _audioPlayer;
}
