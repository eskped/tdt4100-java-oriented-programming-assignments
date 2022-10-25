package w07.jokey.v0701.core.jokes;

import java.util.Collection;
import java.util.HashMap;

import w07.jokey.v0701.core.IJokeyIdentifier;

public class JokesRepositoryManager {
	/*
	 * 
	 */
	private HashMap<String, IJokesRepository> repositories = new HashMap<String, IJokesRepository>();
	
	private IJokesRepository currentRepository = null;
	
	/*
	 * Siden vi benytter singleton pattern og getInstance() for � f� den ene
	 * instansen av denne klassen m� vi begrense tilgang til konstruk�ren, dette
	 * gj�r vi ved � sette den til private.
	 */
	private JokesRepositoryManager() {
	}

	/**
	 * Her bruker vi et s�kalt Singleton Pattern
	 * (https://en.wikipedia.org/wiki/Singleton_pattern) for � sikre at vi bare f�r
	 * en instans av en klasse. Det finnes mange ulike patterns, men det � lage en
	 * helper-klasse er ganske vanlig da den er b�de thread-safe (sikker med tanke
	 * p� flertr�dkj�ring) samt at den ikke lastest f�r det faktisk blir gjort en
	 * foresp�rsel (mao vi sparer eventuelt minne hvis den ikke skulle bli kj�rt).
	 * 
	 * @author steinlt
	 *
	 */
	private static class SingletonHelper {
		private static final JokesRepositoryManager INSTANCE = new JokesRepositoryManager();
	}

	/**
	 * 
	 * @return
	 */
	public static JokesRepositoryManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	/**
	 * 
	 * @param repository
	 * @return
	 */
	public boolean addRepository(IJokesRepository repository) {
		if (repository != null && !repositories.containsKey(repository.getIdentifierAsString()))
			return repositories.put(repository.getIdentifierAsString(), repository) == null;
		return false;
	}

	/**
	 * 
	 * @param repositoryId
	 * @return
	 */
	public IJokesRepository getRepository(IJokeyIdentifier repositoryId) {
		if (repositoryId != null)
			return repositories.get(repositoryId.getIdentifierAsString());
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Collection<IJokesRepository> getRepositories() {
		return repositories.values();
	}
	
	/**
	 * 
	 * @param repository
	 * @return
	 */
	public IJokesRepository removeRepository(IJokesRepository repository) {
		if (repository != null) {
			IJokesRepository repositoryToBeRemoved = getRepository(repository);
			if (repositoryToBeRemoved != null)
				return repositories.remove(repositoryToBeRemoved.getIdentifierAsString());
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public IJokesRepository getCurrentRepository() {
		return currentRepository;
	}

	/**
	 * 
	 * @param currentRepository
	 */
	public void setCurrentRepository(IJokesRepository currentRepository) {		
		this.currentRepository = currentRepository;
	}
}
