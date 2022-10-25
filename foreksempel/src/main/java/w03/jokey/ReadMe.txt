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
I forrige utgave laget vi basisen for den applikasjonen som vi skal forbedre og utvide utover semesteret. Det 
mest åpenbare problemet med den utgaven var måte vitser ble representert i Jokes klassen, de var globale 
variabler. Hva hvis vi seinere ønsker å kunne legge til og slette vitser, da måtte vi ha gjort det ved å 
endre på programmet. Men ved at vi eventuelt benytter en list med vitser, vil det blir mer fleksibelt. Vi vil 
også se at denne endringen i Jokes-klassen heller ikke har noen påvirkning for de andre klassen, noe som er 
en stor fordel. 

UTGAVER
** v0301 **
Her viser vi noen av de største fordelene med innkapsling ved at vi endrer på hvordan vitsene er representert 
i Jokes-klassen. Disse endringene får INGEN følger for de andre involverte klassene. Det er ellers noen 
mindre endringer i Joke klassen og noen nye kommenterer også, men også her har disse endringene INGEN følger 
for andre involverte klasser. Ved optimal innkapsling vil endringer i en klasse ikke ha betydning for andre 
klasser som benytter denne klassen. Dette er spesielt viktig ved vedlikehold og utvidelser av et litt større 
system.
