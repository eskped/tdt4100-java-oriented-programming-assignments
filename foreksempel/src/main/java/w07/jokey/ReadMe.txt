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


BRUK AV BIBLIOTEK (lib-katalogen)
** JSON **
For at du skal kunne bruke filer i Json-format benyttes et bibliotek som kalles Jackson. For å kunne bruke 
det må du gjøre som følger:
1. I Project Explorer, høyreklikk 'foreksempel'-prosjektet og velg Maven -> Add Dependency og legg til 
følgende og trykk OK
	Group Id: 		com.fasterxml.jackson.core
	Artifact Id: 	jackson-databind
	Version: 		2.12.1
2. I Project Explorer, høyreklikk 'foreksempel'-prosjektet og velg Maven -> Update Project...
3. I Project Explorer under src/main/java finner du module-info.java. Der må du legge til:
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;

Hvis det har blitt lagt til riktig og oppdatert kan du også sjekke om du ser jackson-databind, 
jackson-annotations og jackson-core under Maven Dependencies i Project Explorer. Hvis det ikke er tilfellet 
må du prøve igjen, eventuelt se i pom.xml filen for prosjektet om du har skrevet inn riktige verdier.


MOTIVASJON FOR ENDRINGER AV FORRIGE UTGAVE
I forrige utgave la vi til muligheter for å hente data fra en ny kilde, dvs vi kan nå hente vitser fra en fil 
i json-format. Vi lagde 2 interfaces, for å skape felles grensesnitt for de to ulike implementasjonene, den 
ene fra minne mens den andre fra fil. Men, når en ser på koden er det flere metoder som rett og slett er en 
duplisering av kode, logikken er det samme. Duplisering av kode bør en helst unngå hvis en kan det. Nå skal 
vi se på hvordan dette kan gjøres på en annen måte. En annen ulempe er at for å bytte kilde kreves det 
kodeendring som er tungvint. Det hadde vært mye mer elegant om en kunne sette kilde til vitser via det 
grafiske grensesnittet. Eller hva? Så hvordan kan vi gjøre det?

TIPS! Bruk PlantUML og marker de filene av interesse for utgaven av Jokey av interesse. Marker tilsvarende
filer i den nye utgaven for visuelt å kunne se forskjellene.

UTGAVER
** v0701 **
Vi gjør litt forbedringer av implementasjonen med flere kilder til vitser ved at vi blant annet lager en 
abstrakt klasse (AbstractJokesRepository) som inneholder den koden som er felles for de to implementasjonene. 
Men det er fortsatt noe kode som må implementeres og som er spesifikk for de ulike implementasjonene til 
kilder, derfor setter vi den til å være abstrakt slik at den som arver fra denne klassen blir tvunget til å 
implementere det som ennå ikke er implementert (både JokesMemoryRepository og JokesWockaFileRepository arver 
fra AbstractJokesRepository).

I tillegg gjør vi diverse endringer via Scene Builder slik at vi via det grafiske grensesnittet kan sette 
ønsket kilde til vitser. Dette medførte blant annet noen endringer i JokeyGUIMainController som nå benytter 
en ny klasse som er satt til å administrere vitsekildene våre, nemlig JokesRepositoryManager. Legg merke til 
hvordan denne klassen er implementert ved hjelp av static slik at vi kan få lett tilgang til en instans av 
klassen.

TI
