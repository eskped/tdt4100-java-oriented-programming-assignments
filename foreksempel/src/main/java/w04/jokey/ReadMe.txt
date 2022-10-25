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
I forrige utgave hadde vi et «problem» ved at en vits kunne bli vist flere ganger på rad hvis en spurte om å 
bli vist en tilfeldig vits. Nå ønsker vi å ta vare på hvilke vitser som har blitt sett slik at vi kan vise 
tilfeldige vitser, men unngå å vise samme vits igjen, i hvert fall for denne sesjonen. Videre så vi at når vi 
la til en bruker med et brukernavn kunne vi potensielt sette brukernavnet til ingenting uten at vi fikk noen 
feil for dette da det ble gjort som en del av konstruktøren til User. En konstruktør returnerer en referanse 
til det opprettede objektet og vi kan dermed ikke returnere f.eks. true/false om brukernavnet er gyldig. Vi 
skal nå også se på hvordan vi kan bedre dette ved hjelp av exceptions som kan kastes av en konstruktør og 
hvordan fange disse exceptions.

Merk at v0402 er egnet for testing med debugger og bli litt kjent med debugger. Finn feilen ved hjelp av 
debugger og fiks feilen(e).

UTGAVER
** v0401 **
Her ser vi på hvordan vi kan utvide systemet med å ta vare på brukerdata og hvordan vi kan bruke disse 
dataene til å forbedre systemet.

** v0402 **
Her forbedrer vi systemet litt ved bruk av exceptions som gir oss bedre kontroll over eventuelle feil og 
deretter kunne gjøre bedre håndteringer av feil.