
// A program to generate random words

import textio.TextIO;

public class WordGen {

	public static void main(String[] args) {

		int charNumA = 0;
		int charNumB = 0;
		int charNumC = 0;
		int charNumD = 0;
		boolean Avow = false;
		boolean Bvow = false;
		boolean Cvow = false;

		boolean wordFound = false;

		long startt = 0;
		long endd = 0;
		double timerr;

		String wordy = "";
		int wordLength = 0;
		int wordCount = 0;
		int consocount;
		int vowelcount;
		int doublcount;
		double space;
		char letter;
		String word;

		// characters 'a' to 'z' are found in (char)97 to (char)122 (inclusive)
		// characters 'A' to 'Z' are found in (char)65 to (char)90 (inclusive)

		TextIO.writeFile("WordGenOutput.txt");

		startt = System.currentTimeMillis();

		charNumB = (int) (Math.random() * 25 + 97);
		charNumC = (int) (Math.random() * 25 + 97);
		charNumD = (int) (Math.random() * 25 + 97);

		while (wordFound == false) {
			charNumD = charNumC;
			charNumC = charNumB;
			charNumB = charNumA;
			if (charNumB == 97 || charNumB == 101 || charNumB == 105 || charNumB == 111 || charNumB == 117
					|| charNumB == 121) {
				Bvow = true;
			} else
				Bvow = false;
			if (charNumC == 97 || charNumC == 101 || charNumC == 105 || charNumC == 111 || charNumC == 117
					|| charNumC == 121) {
				Cvow = true;
			} else
				Cvow = false;

			charNumA = (int) (Math.random() * 771 + 1);
			if (charNumA <= 13)
				charNumA = 98;
			else if (charNumA <= 41)
				charNumA = 99;
			else if (charNumA <= 66)
				charNumA = 100;
			else if (charNumA <= 82)
				charNumA = 102;
			else if (charNumA <= 95)
				charNumA = 103;
			else if (charNumA <= 129)
				charNumA = 104;
			else if (charNumA <= 132)
				charNumA = 106;
			else if (charNumA <= 136)
				charNumA = 107;
			else if (charNumA <= 167)
				charNumA = 108;
			else if (charNumA <= 188)
				charNumA = 109;
			else if (charNumA <= 241)
				charNumA = 110;
			else if (charNumA <= 260)
				charNumA = 112;
			else if (charNumA <= 261)
				charNumA = 113;
			else if (charNumA <= 309)
				charNumA = 114;
			else if (charNumA <= 362)
				charNumA = 115;
			else if (charNumA <= 443)
				charNumA = 116;
			else if (charNumA <= 451)
				charNumA = 118;
			else if (charNumA <= 462)
				charNumA = 119;
			else if (charNumA <= 466)
				charNumA = 120;
			else if (charNumA <= 477)
				charNumA = 121;
			else if (charNumA <= 540)
				charNumA = 97;
			else if (charNumA <= 639)
				charNumA = 101;
			else if (charNumA <= 690)
				charNumA = 105;
			else if (charNumA <= 747)
				charNumA = 111;
			else if (charNumA <= 770)
				charNumA = 117;
			else
				charNumA = 122;

			while (Bvow == false || Bvow == true && Cvow == true || charNumA == charNumB) {
				if (charNumA == charNumB) {
					while (charNumA == charNumB) {
						charNumA = (int) (Math.random() * 771 + 1);
						if (charNumA <= 13)
							charNumA = 98;
						else if (charNumA <= 41)
							charNumA = 99;
						else if (charNumA <= 66)
							charNumA = 100;
						else if (charNumA <= 82)
							charNumA = 102;
						else if (charNumA <= 95)
							charNumA = 103;
						else if (charNumA <= 129)
							charNumA = 104;
						else if (charNumA <= 132)
							charNumA = 106;
						else if (charNumA <= 136)
							charNumA = 107;
						else if (charNumA <= 167)
							charNumA = 108;
						else if (charNumA <= 188)
							charNumA = 109;
						else if (charNumA <= 241)
							charNumA = 110;
						else if (charNumA <= 260)
							charNumA = 112;
						else if (charNumA <= 261)
							charNumA = 113;
						else if (charNumA <= 309)
							charNumA = 114;
						else if (charNumA <= 362)
							charNumA = 115;
						else if (charNumA <= 443)
							charNumA = 116;
						else if (charNumA <= 451)
							charNumA = 118;
						else if (charNumA <= 462)
							charNumA = 119;
						else if (charNumA <= 466)
							charNumA = 120;
						else if (charNumA <= 477)
							charNumA = 121;
						else if (charNumA <= 540)
							charNumA = 97;
						else if (charNumA <= 639)
							charNumA = 101;
						else if (charNumA <= 690)
							charNumA = 105;
						else if (charNumA <= 747)
							charNumA = 111;
						else if (charNumA <= 770)
							charNumA = 117;
						else
							charNumA = 122;
						break;
					}
					// TextIO.putln("Broke out of double letter.");
				} else if (Bvow == true && Cvow == true) {
					while (charNumA == 97 || charNumA == 101 || charNumA == 105 || charNumA == 111 || charNumA == 117
							|| charNumA == 121) {
						charNumA = (int) (Math.random() * 467 + 1);
						if (charNumA <= 13)
							charNumA = 98;
						else if (charNumA <= 41)
							charNumA = 99;
						else if (charNumA <= 66)
							charNumA = 100;
						else if (charNumA <= 82)
							charNumA = 102;
						else if (charNumA <= 95)
							charNumA = 103;
						else if (charNumA <= 129)
							charNumA = 104;
						else if (charNumA <= 132)
							charNumA = 106;
						else if (charNumA <= 136)
							charNumA = 107;
						else if (charNumA <= 167)
							charNumA = 108;
						else if (charNumA <= 188)
							charNumA = 109;
						else if (charNumA <= 241)
							charNumA = 110;
						else if (charNumA <= 260)
							charNumA = 112;
						else if (charNumA <= 261)
							charNumA = 113;
						else if (charNumA <= 309)
							charNumA = 114;
						else if (charNumA <= 362)
							charNumA = 115;
						else if (charNumA <= 443)
							charNumA = 116;
						else if (charNumA <= 451)
							charNumA = 118;
						else if (charNumA <= 462)
							charNumA = 119;
						else if (charNumA <= 466)
							charNumA = 120;
						else
							charNumA = 122;
						break;
					}
					// TextIO.putln("Broke out of double vowel.");
				} else if (Bvow == false) {
					if (charNumA != 97 || charNumA != 101 || charNumA != 105 || charNumA != 111 || charNumA != 117
							|| charNumA != 121) {
						charNumA = (int) (Math.random() * 30 + 1);
						if (charNumA <= 6)
							charNumA = 97;
						else if (charNumA <= 16)
							charNumA = 101;
						else if (charNumA <= 21)
							charNumA = 105;
						else if (charNumA <= 27)
							charNumA = 111;
						else if (charNumA <= 29)
							charNumA = 117;
						else
							charNumA = 121;
					}
					// TextIO.putln("Broke out of double consonant.");
					break;
				} else
					break;
				break;
			}

			wordy = wordy + (char) charNumA;
			wordLength++;

			if (wordLength == 3) {
				if ((int) (Math.random() * 10 + 1) == 1) {
					TextIO.put(wordy + " ");
					wordy = "";
					wordLength = 0;
					wordCount++;
				}
			} else if (wordLength == 4) {
				if ((int) (Math.random() * 5 + 1) == 1) {
					TextIO.put(wordy + " ");
					wordy = "";
					wordLength = 0;
					wordCount++;
				}
			} else if (wordLength == 5) {
				if ((int) (Math.random() * 3 + 1) == 1) {
					TextIO.put(wordy + " ");
					wordy = "";
					wordLength = 0;
					wordCount++;
				}
			} else if (wordLength > 5) {
				if ((int) (Math.random() * 2 + 1) == 1) {
					TextIO.put(wordy + " ");
					wordy = "";
					wordLength = 0;
					wordCount++;
				}
			} else
				;

			if (wordLength == 0 && wordCount % 20 == 0) {
				TextIO.putln("");
			}

			if (wordy.equals("love")) {
				TextIO.putln(wordy);
				endd = System.currentTimeMillis();
				timerr = (endd - startt) / 1000.0;
				TextIO.putf("It took this program %d words and %1.2f seconds to generate love.", wordCount, timerr);
				TextIO.putln("");
				wordFound = true;
				break;
			}
		}

	}

}
