# Hardship Rest API

### Guida 
- [Scaricare Maven 3.2](https://maven.apache.org/download.cgi?Preferred=https%3A%2F%2Fdlcdn.apache.org%2F)
- JDK 1.8 or later
- You can also import the code straight into your IDE:
    -  [Spring Tool Suite (STS)](https://spring.io/tools)
    -  [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
    
- Installare la variabile d’ambiente per MAC
    - export PATH=PATH_MAVEN/bin:$PATH
    - Per verificare che sia settanta correttamente bisogna lanciare il comando mvn --v 
- Una volta pullato il progetto basta fare il drag and drop della cartella del nuovo progetto su intellj o sul tool Spring Tool Suite

#### Architettura 
L'architettura esagonale, o architettura delle porte e degli adattatori, è un modello architettonico utilizzato nella progettazione del software. Mira a creare sistemi basati su componenti applicativi che sono liberamente accoppiati e possono essere facilmente collegati al loro ambiente software tramite porte e adattatori. Questi componenti sono modulari e intercambiabili, il che migliora la coerenza dell'elaborazione e facilita l'automazione dei test.

AGGIUNGERE IMG

L'esterno dell'esagono (l'infrastruttura) è diviso in due parti virtuali, il lato sinistro e il lato destro. Sulla sinistra, hai tutto ciò che interrogherà il dominio (il controller, il livello REST, ecc.). E a destra, tutto ciò che fornirà alcune informazioni/servizi al dominio (livello di persistenza, servizi di terze parti, ecc.).

AGGIUNGERE IMG

— config —>         jwt token, encoding di password 
— controller —>     entry point 
— dao —>            External interface
— entity —>         Non sono ancora se separare le entity in POJO e DTO
— service —>        Business logic
—— resources —>     application.properties configurazione del db

La nostra servlet si trasforma in un controller che richiama il service che a sua volta va a richiamare il dao. La parte business logic è presente nel Service che può restituire l’oggetto oppure può invocare una throw per qualche errore.

#### DEPENDENCY INJECTION E INVERSIONE CONTROL
Che cos'è l'inversione di controllo?
L'inversione del controllo è un principio nell'ingegneria del software che trasferisce il controllo di oggetti o parti di un programma a un contenitore o framework. Lo usiamo più spesso nel contesto della programmazione orientata agli oggetti. In contrasto con la programmazione tradizionale, in cui il nostro codice personalizzato effettua chiamate a una libreria, IoC consente a un framework di assumere il controllo del flusso di un programma ed effettuare chiamate al nostro codice personalizzato. Per abilitare ciò, i framework utilizzano astrazioni con un comportamento aggiuntivo integrato. Se vogliamo aggiungere il nostro comportamento, dobbiamo estendere le classi del framework o aggiungere le nostre classi.I vantaggi di questa architettura sono:

- disaccoppiare l'esecuzione di un compito dalla sua attuazione
- semplificando il passaggio tra diverse implementazioni
- maggiore modularità di un programma
- maggiore facilità nel testare un programma isolando un componente o prendendo in giro le sue dipendenze e consentendo ai componenti di comunicare tramite contratti

Possiamo ottenere l'inversione del controllo attraverso vari meccanismi come: modello di progettazione della strategia, modello di localizzazione del servizio, modello di fabbrica e iniezione di dipendenza (DI).





