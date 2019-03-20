package uk.ac.ncl.undergraduate.modules.csc3621.cryptanalysis.easyfreq;

import java.text.DecimalFormat;

/**
 * This class is to compute a frequency table of a texts.
 *
 * @author Changyu Dong
 * @author Roberto Metere
 * @author Natalie Hargreaves
 */
public class FrequencyAnalyser {

	/**
	 * The text to analyse
	 */
	private String text;

	/**
	 * Get the text to analyse.
	 *
	 * @return the text to analyse.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the text to analyse.
	 *
	 * @param text
	 *            the text to analyse.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * This method returns a frequency table as a result of the analysis of the
	 * text.
	 *
	 * TODO: complete the function that conduct a frequency analysis of the
	 * internal buffer and produce a frequency table based on the analysis.
	 * Please, write your code between the comments as appropriate.
	 *
	 * @return frequency table as a result of the analysis of the text
	 */
	public FrequencyTable analyse() {
		// Please, do not remove the editor-fold comments.
		// <editor-fold defaultstate="collapsed" desc="Write your code here
		// below!">
		FrequencyTable table = new FrequencyTable();
		int totalLetters = 0;
		double[] letterFreq = new double[26];
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		DecimalFormat df = new DecimalFormat("0.###");

		// text is the text to be operated on

		// count all letters
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			switch (currentChar) {

			case 'a':
			case 'A':
				letterFreq[0]++;
				totalLetters++;
				break;

			case 'b':
			case 'B':
				letterFreq[1]++;
				totalLetters++;
				break;

			case 'c':
			case 'C':
				letterFreq[2]++;
				totalLetters++;
				break;

			case 'd':
			case 'D':
				letterFreq[3]++;
				totalLetters++;
				break;

			case 'e':
			case 'E':
				letterFreq[4]++;
				totalLetters++;
				break;

			case 'f':
			case 'F':
				letterFreq[5]++;
				totalLetters++;
				break;

			case 'g':
			case 'G':
				letterFreq[6]++;
				totalLetters++;
				break;

			case 'h':
			case 'H':
				letterFreq[7]++;
				totalLetters++;
				break;

			case 'i':
			case 'I':
				letterFreq[8]++;
				totalLetters++;
				break;

			case 'j':
			case 'J':
				letterFreq[9]++;
				totalLetters++;
				break;

			case 'k':
			case 'K':
				letterFreq[10]++;
				totalLetters++;
				break;

			case 'l':
			case 'L':
				letterFreq[11]++;
				totalLetters++;
				break;

			case 'm':
			case 'M':
				letterFreq[12]++;
				totalLetters++;
				break;

			case 'n':
			case 'N':
				letterFreq[13]++;
				totalLetters++;
				break;

			case 'o':
			case 'O':
				letterFreq[14]++;
				totalLetters++;
				break;

			case 'p':
			case 'P':
				letterFreq[15]++;
				totalLetters++;
				break;

			case 'q':
			case 'Q':
				letterFreq[16]++;
				totalLetters++;
				break;

			case 'r':
			case 'R':
				letterFreq[17]++;
				totalLetters++;
				break;

			case 's':
			case 'S':
				letterFreq[18]++;
				totalLetters++;
				break;

			case 't':
			case 'T':
				letterFreq[19]++;
				totalLetters++;
				break;

			case 'u':
			case 'U':
				letterFreq[20]++;
				totalLetters++;
				break;

			case 'v':
			case 'V':
				letterFreq[21]++;
				totalLetters++;
				break;

			case 'w':
			case 'W':
				letterFreq[22]++;
				totalLetters++;
				break;

			case 'x':
			case 'X':
				letterFreq[23]++;
				totalLetters++;
				break;

			case 'y':
			case 'Y':
				letterFreq[24]++;
				totalLetters++;
				break;

			case 'z':
			case 'Z':
				letterFreq[25]++;
				totalLetters++;
				break;
			}
		}

		// get frequency of letters
		for (int i = 0; i < 26; i++) {
			if (letterFreq[i] > 0) {
				String formatDecimal = df.format(letterFreq[i] / totalLetters);
				double strToDec = Double.parseDouble(formatDecimal);
				table.setFrequency(letters[i], strToDec);
			} else {
				table.setFrequency(letters[i], 0);
			}
		}

		return table;
		// </editor-fold> // END OF YOUR CODE
	}

}
