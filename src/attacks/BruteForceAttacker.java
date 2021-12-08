package attacks;

import java.util.ArrayList;

class BruteForceAttacker extends Attacker {
	private final char[] possibleCharacters = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890-+_\"'".toCharArray();
	private ArrayList<String> currentCombination;

	BruteForceAttacker(String[][] passwords, ArrayList<String> dictionary) {
		super(passwords, dictionary);
		currentCombination = new ArrayList<>();
	}

	void attack() throws Exception {
		for (char possibleCharacter : possibleCharacters) {
			String passwordGuess = String.valueOf(possibleCharacter);
			currentCombination.add(passwordGuess);
			for (String[] password : userInfo) validatePassword(password[0], passwordGuess, "");
		}

		for (int i = 0; i < 7; i++) verifyCurrentCombination();
	}

	private void verifyCurrentCombination() throws Exception {
		ArrayList<String> temp = new ArrayList<>();
		for (char possibleCharacter : possibleCharacters)
			for (String combination : currentCombination) {
				combination += possibleCharacter;
				temp.add(combination);
				for (String[] password : userInfo) validatePassword(password[0], combination, "");
			}
		currentCombination.clear();
		currentCombination.trimToSize();
		currentCombination = new ArrayList<>(temp);
		temp.clear();
		temp.trimToSize();
	}
}
