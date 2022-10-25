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


BRUK AV BIBLIOTEK (lib-katalogen)
** JSON **
For at du skal kunne bruke filer i Json-format benyttes et bibliotek som kalles Jackson. For � kunne bruke 
det m� du gj�re som f�lger:
1. I Project Explorer, h�yreklikk 'foreksempel'-prosjektet og velg Maven -> Add Dependency og legg til 
f�lgende og trykk OK
	Group Id: 		com.fasterxml.jackson.core
	Artifact Id: 	jackson-databind
	Version: 		2.12.1
2. I Project Explorer, h�yreklikk 'foreksempel'-prosjektet og velg Maven -> Update Project...
3. I Project Explorer under src/main/java finner du module-info.java. Der m� du legge til:
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;

Hvis det har blitt lagt til riktig og oppdatert kan du ogs� sjekke om du ser jackson-databind, 
jackson-annotations og jackson-core under Maven Dependencies i Project Explorer. Hvis det ikke er tilfellet 
m� du pr�ve igjen, eventuelt se i pom.xml filen for prosjektet om du har skrevet inn riktige verdier.


MOTIVASJON FOR ENDRINGER AV FORRIGE UTGAVE
I forrige utgave la vi til muligheter for � hente data fra en ny kilde, dvs vi kan n� hente vitser fra en fil 
i json-format. Vi lagde 2 interfaces, for � skape felles grensesnitt for de to ulike implementasjonene, den 
ene fra minne mens den andre fra fil. Men, n�r en ser p� koden er det flere metoder som rett og slett er en 
duplisering av kode, logikken er det samme. Duplisering av kode b�r en helst unng� hvis en kan det. N� skal 
vi se p� hvordan dette kan gj�res p� en annen m�te. En annen ulempe er at for � bytte kilde kreves det 
kodeendring som er tungvint. Det hadde v�rt mye mer elegant om en kunne sette kilde til vitser via det 
grafiske grensesnittet. Eller hva? S� hvordan kan vi gj�re det?

TIPS! Bruk PlantUML og marker de filene av interesse for utgaven av Jokey av interesse. Marker tilsvarende
filer i den nye utgaven for visuelt � kunne se forskjellene.

UTGAVER
** v0701 **
Vi gj�r litt forbedringer av implementasjonen med flere kilder til vitser ved at vi blant annet lager en 
abstrakt klasse (AbstractJokesRepository) som inneholder den koden som er felles for de to implementasjonene. 
Men det er fortsatt noe kode som m� implementeres og som er spesifikk for de ulike implementasjonene til 
kilder, derfor setter vi den til � v�re abstrakt slik at den som arver fra denne klassen blir tvunget til � 
implementere det som enn� ikke er implementert (b�de JokesMemoryRepository og JokesWockaFileRepository arver 
fra AbstractJokesRepository).

I tillegg gj�r vi diverse endringer via Scene Builder slik at vi via det grafiske grensesnittet kan sette 
�nsket kilde til vitser. Dette medf�rte blant annet noen endringer i JokeyGUIMainController som n� benytter 
en ny klasse som er satt til � administrere vitsekildene v�re, nemlig JokesRepositoryManager. Legg merke til 
hvordan denne klassen er implementert ved hjelp av static slik at vi kan f� lett tilgang til en instans av 
klassen.

TI
