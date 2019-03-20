package uk.ac.ncl.undergraduate.modules.csc3621.cryptanalysis.easyfreq;

public class HelperClass {
	Util util = new Util();

	// gets greatest common denominator of a array of numbers
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return (gcd(b, a % b));
	}

	// allows for gcd to be used on an array or any length
	static int gcdLoop(int arr[]) {
		int size = arr.length;
		int result = arr[0];
		for (int i = 1; i < size; i++)
			result = gcd(arr[i], result);

		return result;
	}

	// takes in cipher, performs calculation and outputs correct key value for
	// cipher
	public char getKeyValue(String cipher) {
		FrequencyTable cipherTable3 = new FrequencyTable();
		FrequencyAnalyser cipherFreq = new FrequencyAnalyser();
		cipherTable3 = null;
		cipherFreq.setText(cipher);
		cipherTable3 = cipherFreq.analyse();

		// check for highest quantity (to guess which is e and thus get the key)
		double highestQuantity = 0;
		char estimateForE = 'a';
		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			if (cipherTable3.getFrequency(alphabet) > highestQuantity) {
				highestQuantity = cipherTable3.getFrequency(alphabet);
				estimateForE = alphabet;
			}
		}
		char keyChar = Util.indexToChar(Util.charToIndex(estimateForE) - 4);
		return keyChar;
	}
}
