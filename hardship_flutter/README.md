# hardship_flutter
Parte frontend dell' applicativo hardship, ascolta, pubblica e guardagna con la tua musica indie

## Istruzioni
- [Scaricare Flutter v3.0](https://docs.flutter.dev/get-started/install)
- Impostare la variabile d'ambiente --> per macos export PATH="$PATH:`pwd`/flutter/bin"
- Scaricare obbligatorio [Android studio](https://developer.android.com/studio?gclid=Cj0KCQjwqPGUBhDwARIsANNwjV6Y6gTbi00QSy7SiYMflP1o2UTqGrLdPLtn8vaU8z9GrBhQf3wjDyYaAqTkEALw_wcB&gclsrc=aw.ds) e [Vs code](https://code.visualstudio.com/) scelta dello sviluppatore
- Importare i seguenti plugin Flutter e Dart
- Drag and drop del progetto sul proprio IDE
- Lanciare il comando pub get per importare le dependecy del progetto

## Perché Flutter? 
Questi vantaggi sono insiti nel linguaggio di programmazione e in un insieme di strumenti di sviluppo che consentono a Flutter di risolvere problemi e svantaggi che altre tecnologie non possono affrontare.
Pro di Flutter:
1. Dart
2. Crescente popolarità
3. Alte prestazioni
4. Curva di apprendimento lieve
5. Un design dell'interfaccia utente
6. Risparmio di denaro e tempo
7. Comunità potente

Flutter è apprezzato per la sua documentazione chiara e la comunità amichevole di sviluppatori, che riunisce esperti e principianti che sono pronti ad aiutare e condividere la loro esperienza, fornendo eccellenti esempi di lavoro dei loro modelli di progettazione e modelli di sviluppo. Qui regna un'atmosfera accogliente, che facilita il facile sviluppo delle tecnologie da parte di una vasta gamma di utenti.

Un altro motivo della rapida crescita della popolarità di Flutter tra gli sviluppatori (oltre all'elevata produttività) è stata la disponibilità di documentazione dettagliata e un gran numero di esempi. E questo è molto importante per gli sviluppatori che vogliono imparare una nuova piattaforma, un insieme di strumenti o una lingua.

## Risparmiare denaro e tempo
La scelta di questo Framework é ricaduta anche per una questione di imitare i processi di Mantainence e Aziendali.
Flutter:  Le applicazioni MVP di Flutter possono effettivamente essere create in 2-3 mesi e lo sviluppo completo costerà in media il 30% in meno rispetto alla creazione di due applicazioni native. Quindi il framework farà risparmiare due importanti risorse: tempo e denaro  che risultano fondamentali come obiettivi Aziendali

## Architettura Flutter MVVM + Provider 
Flutter non supporta alcuna architettura per lo sviluppo. Ció significa che abbiamo scelto quale architettura costruire. La scelta finale é stata quella dell’architettura MVVM perché così abbiamo separato la business logic dall’interfaccia. I principali vantaggi che si ottengono scegliendo la seguente architettura sono i seguenti:
- La logica aziendale è separata dall'interfaccia utente
- La vista è indipendente dalla classe ViewModel e legge solo lo stato da ViewModel
- Il codice sarà facile da mantenere e aggiornare in termini di logica e interfaccia utente
- Facile da scrivere i casi di test per il progetto

## Dependency Injection
- L'aggiunta di nuove funzionalità all'app già esistente diventa più semplice.
- Consente l'accoppiamento libero.
- Il processo di test unitario è più rapido e semplice.
- Riduce il codice boilerplate.
