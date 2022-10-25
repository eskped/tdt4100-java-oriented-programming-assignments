TDT4100 - Objektorientert programmering
JOKEY - HVA ER VITSEN?

README
Jokey er en applikasjon som kan vise vitser. Vi skal utvikle denne utover semesteret. Applikasjonen vil bli 
stadig utvidet med blant annet � kunne vise vitser fra flere ulike kilder og vise praktisk bruk av ulike 
objektorienterte teknikker. Applikasjonen vil gjennom typiske problemstillinger gi motivasjon for hvorfor en 
b�r benytte de ulike objektorienterte teknikkene og i hvilke tilfeller.

Hver utgave har en readme.txt fil hvor det st�r hva som er nytt siden forrige utgave. Hver utgave har en 
nummerering som har formatet "v[uke][versjon for uken]", feks "v0201" referer til versjon 1 i uke 2. Hver 
versjon bygger p� forrige versjon med enten utvidelser eller forbedringer/endringer. Endringene er beskrevet 
i denne filen.

MOTIVASJON FOR ENDRINGER AV FORRIGE UTGAVE
I forrige utgave hadde vi litt flere midlertidige l�sningen slik som det med � identifisere en vits p� en god 
m�te i UserData-klassen, dvs at en vits kan f� en trygg identifikator. Med en god identifikatorl�sning kan 
identifikatoren for et objekt trygt bli benyttet p� tvers at komponenter i systemet og ikke spesifikt for 
ulike komponenter slik vi gjorde i UserData-klassen. Det er ogs� flere som kan ha nytte av � bruke en 
identifikator. L�sningen for dette er dermed � lage et identifikatorgrensesnitt/interface som kan 
implementeres der det er n�dvendig, samt de komponentene som benytter denne id�en kan bare benytte dette 
interfacet. Vi ser p� hvordan dette kan gj�res. Videre s� er det p� tide � lage et grafisk brukergrensesnitt, 
s� vi lager en enkel f�rsteutgave som vi kan bygge videre p�. 

UTGAVER
** v0501 **
I UserData laget vi lokal l�sning i den klassen for � identifisere de ulike vitsene slik at vi kunne holde 
oversikt over hvilke vitser som brukeren har sett f�r. Dette var litt uheldig og med stor sannsynlighet skape 
feil etter hvert. Det er de enkelte klassene som b�r vite best hvordan dens instanser b�r kunne 
identifiseres, ikke bare n�r de kj�res, men ogs� med tanke p� hvis noe skal lagres og fortsatt v�re gyldige 
p� tvers av kj�ringer. L�sningen var et eget grensesnitt/interface som muliggj�r en identifikator for de 
ulike objekter som dette gjelder. De som har behov for en identifikator, slik som Joke klassen, implementerer 
dette grensesnittet/interfacet, deretter kan denne benyttes p� en trygg m�te slik som i UserData-klassen som 
tar vare p� informasjon om vitser som er sett.

** v0502 **
Her lager vi et grafisk brukergrensesnitt, men vi tar ogs� vare p� konsollversjonen. Via parametre til 
programmet ved oppstart kan en velge om en vil ha en konsollversjon eller en grafisk versjon av programmet. 
Vi ser p� hvordan dette kan gj�res.