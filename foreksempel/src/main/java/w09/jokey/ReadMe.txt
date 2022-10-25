TDT4100 - Objektorientert programmering
JOKEY - HVA ER VITSEN?

README
Jokey er en applikasjon som kan vise vitser. Vi skal utvikle denne utover 
semesteret. Applikasjonen vil bli stadig utvidet med blant annet � kunne vise 
vitser fra flere ulike kilder og vise praktisk bruk av ulike objektorienterte 
teknikker. Applikasjonen vil gjennom typiske problemstillinger gi motivasjon for 
hvorfor en b�r benytte de ulike objektorienterte teknikkene og i hvilke tilfeller.

Hver utgave har en readme.txt fil hvor det st�r hva som er nytt siden forrige 
utgave. Hver utgave har en nummerering som har formatet "v[uke][versjon for uken]", 
feks "v0201" referer til versjon 1 i uke 2. Hver versjon bygger p� forrige versjon 
med enten utvidelser eller forbedringer/endringer. Endringene er beskrevet i denne 
filen.


BRUK AV BIBLIOTEK (lib-katalogen)
** JSON **
For at du skal kunne bruke filer i Json-format benyttes et bibliotek som kalles 
Jackson. For � kunne bruke det m� du gj�re som f�lger:
1. I Project Explorer, h�yreklikk 'foreksempel'-prosjektet og velg Maven -> Add 
Dependency og legg til f�lgende og trykk OK
	Group Id: 		com.fasterxml.jackson.core
	Artifact Id: 	jackson-databind
	Version: 		2.12.1
2. I Project Explorer, h�yreklikk 'foreksempel'-prosjektet og velg Maven -> Update 
Project...
3. I Project Explorer under src/main/java finner du module-info.java. Der m� du 
legge 
til:
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;

Hvis det har blitt lagt til riktig og oppdatert kan du ogs� sjekke om du ser 
jackson-databind, jackson-annotations og jackson-core under Maven Dependencies i 
Project Explorer. Hvis det ikke er tilfellet m� du pr�ve igjen, eventuelt se i 
pom.xml filen for prosjektet om du har skrevet inn riktige verdier.


MOTIVASJON FOR ENDRINGER AV FORRIGE UTGAVE
Tidligere versjon startet p� nytt hver gang vi startet opp applikasjonen. N� skal 
vi legge til lagring av tilstand slik at den husker hvor vi var sist.

I forrige utgave var AbstractJokesRepository.getRandomJoke() litt tungvint 
implementert, vi m�tte huske hver enkelt vits som er sett for � ikke vise en 
tidliger sett vits. Er det egentlig s� viktig � huske hver enkelt vits? Hva om vi 
heller er litt smart og har det heller som en random liste

TIPS! Bruk PlantUML og marker de filene av interesse for utgaven av Jokey av 
interesse. Marker tilsvarende filer i den nye utgaven for visuelt � kunne se 
forskjellene.


UTGAVER
** v0901 **
Vi legger til en ny klasse AppPropertiesManager som muligj�r lagring av 
applikasjonsoppsett og brukerpreferanser. Videre er det blitt gjort endringer i 
JokeyGUIMainController, n�rmere bestem onRepositorySelect og 
populateRepositorySelector som begge benytter seg av AppPropertiesManager for � 
huske sist valgte kilde for vitser.

** v0902 **
Vi legger til en ny kilde for vitser, men denne benytter vi en API p� nett. Det nye 
repository er implementert i klassen JokesChuckNorrisRepository og lagt til listen 
av kilder i JokeyApp.