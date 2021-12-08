package attacks;

import java.util.ArrayList;

/**
 * Brute force attacks to a password hash file for BSI classes PJATK Gdańsk
 *
 * @author Anastasiia Ponkratova and Julia Migiel
 * @version IntelliJ IDEA 2021.3 Build #IU-213.5744.223, built on November 27, 2021
 */

public class Main {
	public static void main(String[] args) throws Exception {
		FileRetriever fileRetriever = new FileRetriever();
		String[][] randomPasswords = fileRetriever.getRandomPasswords();
		ArrayList<String> dictionary = fileRetriever.getDictionary();

		BruteForceAttacker bruteForceAttacker = new BruteForceAttacker(randomPasswords, dictionary);

		System.out.println("Brute Force Attack");
		bruteForceAttacker.attack();
		System.out.println();
	}
}
