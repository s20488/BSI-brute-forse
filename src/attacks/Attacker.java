package attacks;

import java.util.ArrayList;

class Attacker {

	String[][] userInfo;
	ArrayList<String> dictionary;
	private hashGenerator sha1;
	private long startTime = System.currentTimeMillis();


	Attacker(String[][] userInfo, ArrayList<String> dictionary) {
		this.userInfo = userInfo;
		this.dictionary = dictionary;
		sha1 = new hashGenerator();
	}

	void validatePassword(String password, String passwordGuess, String salt) throws Exception {
		String hash = sha1.getHash(passwordGuess + salt);
		if (password.equals(hash))
			System.out.println("Password: " + passwordGuess);
	}
}
