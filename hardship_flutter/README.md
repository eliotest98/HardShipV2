# hardship_flutter
Parte frontend dell' applicativo hardship, ascolta, pubblica e guardagna con la tua musica indie

## Istruzioni
- [Scaricare Flutter v3.0](https://maven.apache.org/download.cgi?Preferred=https%3A%2F%2Fdlcdn.apache.org%2F](https://docs.flutter.dev/get-started/install)
- Impostare la variabile d'ambiente --> per macos export PATH="$PATH:`pwd`/flutter/bin"
- Scaricare obbligatorio [Android studio](https://developer.android.com/studio?gclid=Cj0KCQjwqPGUBhDwARIsANNwjV6Y6gTbi00QSy7SiYMflP1o2UTqGrLdPLtn8vaU8z9GrBhQf3wjDyYaAqTkEALw_wcB&gclsrc=aw.ds) e [Vs code](https://code.visualstudio.com/) scelta dello sviluppatore
- Importare i seguenti plugin Flutter e Dart
- Drag and drop del progetto sul proprio IDE
- Lanciare il comando pub get per importare le dependecy del progetto 


## Architettura Flutter MVVM + Provider 
Flutter non supporta alcuna architettura per lo sviluppo. Ció significa che abbiamo potuto scegliere quale architettura costruire. La scelta finale é stata quella dell’architettura MVVM perché così abbiamo potuto separare la business logic dall’interfaccia. I principali vantaggi che si ottengono scegliendo la seguente architettura sono i seguenti:
- La logica aziendale è separata dall'interfaccia utente
- La vista è indipendente dalla classe ViewModel e legge solo lo stato da ViewModel
- Il codice sarà facile da mantenere e aggiornare in termini di logica e interfaccia utente
- Facile da scrivere i casi di test per il progetto

