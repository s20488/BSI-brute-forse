package attacks;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class hashGenerator {

	public hashGenerator() {
	}

	public String getHash(String toHash) throws Exception {
		MessageDigest hash = MessageDigest.getInstance("SHA1");
		hash.update(toHash.getBytes());
		byte[] digest = hash.digest();
		return DatatypeConverter.printHexBinary(digest).toLowerCase();
	}
}
