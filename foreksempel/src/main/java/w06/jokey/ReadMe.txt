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
I de tidligere utgavene s� har vi kjempet oss igjennom en liste med heller d�rlige vitser. De var egentlig 
h�n mot andre vitser. Men uansett, gratulerer for at du har kommet s� langt. N� skal det alts� endelig skje, 
vi legger til en ny kilde og med det ogs� gir et nytt eksempel for bruken av interfaces!!


UTGAVER
** v0601 **
Denne nye kilden er en fil med vitser i json-format. Vi har laget et lite bibliotek som forenkler dette med � 
lese og skrive fra fil. Merk at dette biblioteket er for viderekommende og ikke pensum, men for dem som er 
interessert � se en litt annen type kode. Dette biblioteket benytter igjen et annet bibliotek som m� legges 
til for at denne koden skal kj�re (se under). Videre s� lager vi noen nye interfaces for kilder generelt, 
dette gir oss seinere mulighet til � legge til nye kilder uten � endre vesentlig kode, bare � registrere nye 
kilder (et hint er at vi etter hvert ogs� skal kunne hente vitser fra et API p� nett). Men alts� en ny kilde 
som gir oss en mulighet til � se enda st�rre nytte av interfaces. Med mer data kan vi ogs� gj�re flere andre 
interessant ting. Vi vil etter hvert se flere bruksomr�der for interfaces ved at vi skal gj�re ulike former 
for enkle analyser av dataene, b�de fra v�re brukere (som n� ogs� har implementert IJokeyIdentifier).

Merk at forel�pig m� du sette kilden for vitser i koden, enten i JokeyApp eller JokeyConsole klassene.
