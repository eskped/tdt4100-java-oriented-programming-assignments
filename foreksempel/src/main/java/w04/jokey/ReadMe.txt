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
I forrige utgave hadde vi et �problem� ved at en vits kunne bli vist flere ganger p� rad hvis en spurte om � 
bli vist en tilfeldig vits. N� �nsker vi � ta vare p� hvilke vitser som har blitt sett slik at vi kan vise 
tilfeldige vitser, men unng� � vise samme vits igjen, i hvert fall for denne sesjonen. Videre s� vi at n�r vi 
la til en bruker med et brukernavn kunne vi potensielt sette brukernavnet til ingenting uten at vi fikk noen 
feil for dette da det ble gjort som en del av konstrukt�ren til User. En konstrukt�r returnerer en referanse 
til det opprettede objektet og vi kan dermed ikke returnere f.eks. true/false om brukernavnet er gyldig. Vi 
skal n� ogs� se p� hvordan vi kan bedre dette ved hjelp av exceptions som kan kastes av en konstrukt�r og 
hvordan fange disse exceptions.

Merk at v0402 er egnet for testing med debugger og bli litt kjent med debugger. Finn feilen ved hjelp av 
debugger og fiks feilen(e).

UTGAVER
** v0401 **
Her ser vi p� hvordan vi kan utvide systemet med � ta vare p� brukerdata og hvordan vi kan bruke disse 
dataene til � forbedre systemet.

** v0402 **
Her forbedrer vi systemet litt ved bruk av exceptions som gir oss bedre kontroll over eventuelle feil og 
deretter kunne gj�re bedre h�ndteringer av feil.