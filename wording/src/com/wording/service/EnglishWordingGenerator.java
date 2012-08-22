package com.wording.service;
public class EnglishWordingGenerator implements WordingGenerator {

	private static final String digits[] = { "", "", "hundred ", "thousand ",
			"", "hundred ", "million ", "", "hundred ", "billion ", "",
			"hundred " };
	private static final String teens[] = { "ten ", "eleven ", "twelve ",
			"thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ",
			"eighteen ", "nineteen " };
	private static final String ties[] = { "", "", "twenty ", "thirty ",
			"forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety " };
	private static final String ones[] = { "", "one ", "two ", "three ",
			"four ", "five ", "six ", "seven ", "eight ", "nine " };

	@Override
	public String getWordingsForNumber(String actualNumber) {

		String numberString, resultString = "";

		numberString = actualNumber;

		int order = numberString.length();
		order--;

		while (numberString.length() > 0) {

			int digit = getInt(numberString.charAt(0));

			if (digit == 0) {

				numberString = numberString.substring(1);

				if (order == 6 || order == 3 || order == 0 || order == 9)
					if (getInt(actualNumber
							.charAt(((actualNumber.length() - 1) - order) - 2)) != 0)
						resultString += digits[order];

				order--;

				continue;
			}

			if (order == 7 || order == 4 || order == 1 || order == 10) {
				if (digit == 1) {

					resultString += (teens[getInt(numberString.charAt(1))]);

					numberString = numberString.substring(1);
					order--;

					resultString += (digits[order]);

				} else
					resultString += (ties[digit]);
			}

			else {
				resultString += (ones[digit]);
				resultString += (digits[order]);

				if (order == 5 || order == 8 || order == 2 || order == 11)
					if (getInt(actualNumber
							.charAt(((actualNumber.length() - 1) - order) + 2)) != 0
							|| getInt(actualNumber.charAt(((actualNumber
									.length() - 1) - order) + 1)) != 0)
						resultString += ("and ");

			}

			numberString = numberString.substring(1);

			order--;

		}
		return resultString;
	}

	public int getInt(char character) {
		return Integer.parseInt(new String(new char[] { character }));
	}

}
