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
I de tidligere utgavene så har vi kjempet oss igjennom en liste med heller dårlige vitser. De var egentlig 
hån mot andre vitser. Men uansett, gratulerer for at du har kommet så langt. Nå skal det altså endelig skje, 
vi legger til en ny kilde og med det også gir et nytt eksempel for bruken av interfaces!!


UTGAVER
** v0601 **
Denne nye kilden er en fil med vitser i json-format. Vi har laget et lite bibliotek som forenkler dette med å 
lese og skrive fra fil. Merk at dette biblioteket er for viderekommende og ikke pensum, men for dem som er 
interessert å se en litt annen type kode. Dette biblioteket benytter igjen et annet bibliotek som må legges 
til for at denne koden skal kjøre (se under). Videre så lager vi noen nye interfaces for kilder generelt, 
dette gir oss seinere mulighet til å legge til nye kilder uten å endre vesentlig kode, bare å registrere nye 
kilder (et hint er at vi etter hvert også skal kunne hente vitser fra et API på nett). Men altså en ny kilde 
som gir oss en mulighet til å se enda større nytte av interfaces. Med mer data kan vi også gjøre flere andre 
interessant ting. Vi vil etter hvert se flere bruksområder for interfaces ved at vi skal gjøre ulike former 
for enkle analyser av dataene, både fra våre brukere (som nå også har implementert IJokeyIdentifier).

Merk at foreløpig må du sette kilden for vitser i koden, enten i JokeyApp eller JokeyConsole klassene.
