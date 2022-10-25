package w06.jokey.v0601.core;

import java.util.UUID;

/**
 * Dette er en hjelpeklasse for bruk av Jokey identifikatorer. Legg merke til at
 * klassen er satt til final, dette gj�r at det ikke er mulig � arve fra klassen
 * og eventuelt endre p� en metode ved arv og override. Mer om dette i en
 * forelesning om arv. Videre s� er alle metoder satt til static, det betyr at
 * det ikke er noe behov for � gj�re en instanse av denne klassen for � benytte
 * metodene da metodene er tilgjengelig via klassen. For denne klassen er det
 * heller ingen globale verdier, det er IKKE anbefalt for klasser med bare
 * static metoder
 */

public final class JokeyIdentifierHelper {
	/**
	 * Dette er en konstant som benyttes som skiller mellom namespace og
	 * identifikatoren. Namespace benyttes for bedre � sikre at alle identifikatorer
	 * blir unike i kontekst av applikasjonen (men selv dette gir ingen garanti for
	 * det, � sikre en garantert unik id er utenfor skope av dette faget).
	 * 
	 */
	private final static String DIVIDER = "::";

	/**
	 * Lager en identifikator med et gitt navnerom
	 * 
	 * @param namespace  navnerommet som skal benyttes
	 * @param identifier identifikatoren som skal kobles med navnerommet
	 * @return en identifikatorstreng med navnerom og identifikator
	 * @throws IllegalArgumentException hvis namespace eller identifier er
	 *                                  {@code null} eller blank
	 */
	public final static String create(String namespace, String identifier) {
		if (namespace == null || namespace.isBlank())
			throw new IllegalArgumentException("namespace kan ikke v�re null eller blank");
		else if (identifier == null || identifier.isBlank())
			throw new IllegalArgumentException("identifier kan ikke v�re null eller blank");
		return namespace + DIVIDER + identifier;
	}

	/**
	 * Genererer en identifikator og returnerer en identifikator med et gitt
	 * navnerom
	 * 
	 * @param namespace navnerommet som skal benyttes
	 * @return en identifikatorstreng med navnerom og identifikator
	 * @throws IllegalArgumentException hvis namespace er {@code null} eller blank
	 */
	public final static String create(String namespace) {
		if (namespace == null || namespace.isBlank())
			throw new IllegalArgumentException("namespace kan ikke v�re null eller blank");

		/*
		 * Viderekommende og ikke pensum. UUID lager en s�kalt GUID (Globally Unique
		 * Identifier), som med meget stor grad av sannsynlighet gir en globalt unik
		 * identifikator, men av erfaring s� er heller ikke det tilfelle. Innenfor
		 * storskalasystemer �ker sannsynligheten for crash av identifikatorer. Tips,
		 * derfor i tilfeller hvor det er VELDIG viktig at en ikke skal f� crash med
		 * identifikatorer, som feks kan gi datalekasje, s� er det anbefalt � lage to,
		 * ved litt tilfeldig pause i mellom, som settes i sammen.
		 */
		String identifier = UUID.randomUUID().toString();
		return JokeyIdentifierHelper.create(namespace, identifier);
	}

	/**
	 * Sjekker om en identifikator benytter et bestemt navnerom
	 * 
	 * @param namespace  navnerommet som skal det skal sjekkes for gitt
	 *                   identifikator
	 * @param identifier identifikatoren som skal sjekkes om har gitt navnerom
	 * @return {@code true} hvis like, hvis ikke {@code false}
	 */
	public final static boolean containsNamespace(String namespace, IJokeyIdentifier identifier) {
		return identifier != null && identifier.getIdentifierAsString().startsWith(namespace + DIVIDER);
	}

	/**
	 * Tester om to identifikatorer er like.
	 * 
	 * @param identifier1 identifikator som testes om er lik den andre
	 * @param identifier2 identifikator som testes om er lik den andre
	 * @return {@code true} hvis like, hvis ikke {@code false}
	 */
	public final static boolean equals(IJokeyIdentifier identifier1, IJokeyIdentifier identifier2) {
		return identifier1 != null && identifier2 != null
				&& identifier1.getIdentifier().equals(identifier2.getIdentifier());
	}
}
