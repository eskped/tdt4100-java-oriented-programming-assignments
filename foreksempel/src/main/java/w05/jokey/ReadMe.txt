TDT4100 - Objektorientert programmering
JOKEY - HVA ER VITSEN?

README
Jokey er en applikasjon som kan vise vitser. Vi skal utvikle denne utover semesteret. Applikasjonen vil bli 
stadig utvidet med blant annet å kunne vise vitser fra flere ulike kilder og vise praktisk bruk av ulike 
objektorienterte teknikker. Applikasjonen vil gjennom typiske problemstillinger gi motivasjon for hvorfor en 
bør benytte de ulike objektorienterte teknikkene og i hvilke tilfeller.

Hver utgave har en readme.txt fil hvor det står hva som er nytt siden forrige utgave. Hver utgave har en 
nummerering som har formatet "v[uke][versjon for uken]", feks "v0201" referer til versjon 1 i uke 2. Hver 
versjon bygger på forrige versjon med enten utvidelser eller forbedringer/endringer. Endringene er beskrevet 
i denne filen.

MOTIVASJON FOR ENDRINGER AV FORRIGE UTGAVE
I forrige utgave hadde vi litt flere midlertidige løsningen slik som det med å identifisere en vits på en god 
måte i UserData-klassen, dvs at en vits kan få en trygg identifikator. Med en god identifikatorløsning kan 
identifikatoren for et objekt trygt bli benyttet på tvers at komponenter i systemet og ikke spesifikt for 
ulike komponenter slik vi gjorde i UserData-klassen. Det er også flere som kan ha nytte av å bruke en 
identifikator. Løsningen for dette er dermed å lage et identifikatorgrensesnitt/interface som kan 
implementeres der det er nødvendig, samt de komponentene som benytter denne id’en kan bare benytte dette 
interfacet. Vi ser på hvordan dette kan gjøres. Videre så er det på tide å lage et grafisk brukergrensesnitt, 
så vi lager en enkel førsteutgave som vi kan bygge videre på. 

UTGAVER
** v0501 **
I UserData laget vi lokal løsning i den klassen for å identifisere de ulike vitsene slik at vi kunne holde 
oversikt over hvilke vitser som brukeren har sett før. Dette var litt uheldig og med stor sannsynlighet skape 
feil etter hvert. Det er de enkelte klassene som bør vite best hvordan dens instanser bør kunne 
identifiseres, ikke bare når de kjøres, men også med tanke på hvis noe skal lagres og fortsatt være gyldige 
på tvers av kjøringer. Løsningen var et eget grensesnitt/interface som muliggjør en identifikator for de 
ulike objekter som dette gjelder. De som har behov for en identifikator, slik som Joke klassen, implementerer 
dette grensesnittet/interfacet, deretter kan denne benyttes på en trygg måte slik som i UserData-klassen som 
tar vare på informasjon om vitser som er sett.

** v0502 **
Her lager vi et grafisk brukergrensesnitt, men vi tar også vare på konsollversjonen. Via parametre til 
programmet ved oppstart kan en velge om en vil ha en konsollversjon eller en grafisk versjon av programmet. 
Vi ser på hvordan dette kan gjøres.