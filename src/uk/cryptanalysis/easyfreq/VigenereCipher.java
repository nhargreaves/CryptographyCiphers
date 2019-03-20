package uk.ac.ncl.undergraduate.modules.csc3621.cryptanalysis.easyfreq;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * This class is capable of encrypt and decrypt according to the Vigen&egrave;re
 * cipher.
 *
 * @author Changyu Dong
 * @author Roberto Metere
 * @author Natalie Hargreaves
 */
public class VigenereCipher {

	/**
	 * Encryption function of the Vigen&egrave;re cipher.
	 *
	 * <p>
	 * TODO: Complete the Vigen&egrave;re encryption function.
	 *
	 * @param plaintext
	 *            the plaintext to encrypt
	 * @param key
	 *            the encryption key
	 * @return the ciphertext according with the Vigen&egrave;re cipher.
	 */
	//ALSO EDITED CODE - main statement added in order to test vigenere for task
	public static void main(String[] args) throws IOException, URISyntaxException {
		FrequencyAnalyser frequencyAnalyser = new FrequencyAnalyser();
		FrequencyTable frequencyTable2;
		String mainPath = Paths.get(FrequencyCryptanalysis.class.getResource("/").toURI()).toString();
		String textPath = mainPath + "/res/pg1661.txt";
		String plaintext = Util.readFileToBuffer(textPath);

		String vigCipher = encrypt(plaintext, "ncl");
		frequencyAnalyser.setText(vigCipher);
		frequencyTable2 = frequencyAnalyser.analyse();
		frequencyTable2.print();
	}

	public static String encrypt(String plaintext, String key) {
		// Please, do not remove the editor-fold comments.
		// <editor-fold defaultstate="collapsed" desc="Write your code here
		// below!">
		

		Util util = new Util();
		char[] ptArray = plaintext.toCharArray();
		char[] ctArray = ptArray;
		// get how many times key must be duplicated to match length
		int dupeAmount = (plaintext.length() / key.length()) - 1;
		if (plaintext.length() % key.length() > 0) {
			dupeAmount++;
		}
		// duplicate key to be equal or greater than text length
		String origKey = key;
		for (int i = 0; i < dupeAmount; i++) {
			key = key + origKey;
		}
		char[] keyArray = key.toCharArray();

		// encrypt
		int cipherLoc;
		for (int i = 0; i < plaintext.length(); i++) {
			if (util.isValidLetter(ptArray[i])) {
				cipherLoc = (util.charToIndex(ptArray[i]) + util.charToIndex(keyArray[i])) % 26;
				ctArray[i] = util.indexToChar(cipherLoc);
			} else {
				ctArray[i] = ptArray[i];
			}
		}
		String ciphertext = new String(ctArray);
		return ciphertext;

		// </editor-fold> // END OF YOUR CODE
	}

	/**
	 * Decryption function of the Vigen&egrave;re cipher.
	 *
	 * <p>
	 * TODO: Complete the Vigen&egrave;re decryption function.
	 *
	 * @param ciphertext
	 *            the encrypted text
	 * @param key
	 *            the encryption key
	 * @return the plaintext according with the Vigen&egrave;re cipher.
	 */
	public static String decrypt(String ciphertext, String key) {
		// Please, do not remove the editor-fold comments.
		// <editor-fold defaultstate="collapsed" desc="Write your code here
		// below!">
		Util util = new Util();
		char[] ctArray = ciphertext.toCharArray();
		char[] ptArray = ctArray;

		// get how many times key must be duplicated to match length
		int dupeAmount = (ciphertext.length() / key.length()) - 1;
		if (ciphertext.length() % key.length() > 0) {
			dupeAmount++;
		}
		// duplicate key to be equal or greater than text length
		String origKey = key;
		for (int i = 0; i < dupeAmount; i++) {
			key = key + origKey;
		}
		char[] keyArray = key.toCharArray();

		int ptLoc;
		for (int i = 0; i < ciphertext.length(); i++) {
			// plaintext = ciphertext + keylocation all mod 26
			ptLoc = (util.charToIndex(ctArray[i]) - util.charToIndex(keyArray[i])) % 26;
			if (ptLoc < 0) {
				ptLoc = ptLoc + 26;
			}
			ptArray[i] = util.indexToChar(ptLoc);
		}
		String plaintext = new String(ptArray);
		System.out.println(plaintext);

		// </editor-fold> // END OF YOUR CODE
		return plaintext; // temp
	}

}
