import 'package:encrypt/encrypt.dart' as encrypt;

class EncryptData {
//for AES Algorithms

  static final key = encrypt.Key.fromLength(16);
  static final iv = encrypt.IV.fromLength(16);
  static final encrypter = encrypt.Encrypter(encrypt.AES(key));

  static encryptAES(plainText) {
    final encrypted = encrypter.encrypt(plainText, iv: iv);
    return encrypted.base16;
  }

  static String decryptAES(plainText) {
    return encrypter.decrypt(plainText, iv: iv);
  }
}
