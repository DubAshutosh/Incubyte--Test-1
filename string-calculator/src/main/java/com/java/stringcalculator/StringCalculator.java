package com.java.stringcalculator;

public class StringCalculator {
	public int add(String input) {
		 char customDelimiter = getCustomDelimiter(input.split("\n")[0]);
		  String[] numbers = (customDelimiter == ',') ? 
                  input.split(",|\n") : input.split("\n|" + customDelimiter);

		if (input.isEmpty()) {
			return 0;
		} else if (numbers.length > 1) {
			return getSum(numbers);
		}
		return stringToInt(input);
	}

	private int getSum(String[] numbers) {
		int sum = 0;
		for (String curr : numbers) {
			if (stringToInt(curr) > 1000) {
				continue;
			}
			sum += stringToInt(curr);
		}
		return sum;
	}

	private int stringToInt(String number) {
		int num = Integer.parseInt(number);
		if (num < 0) {
			throw new IllegalArgumentException("Negative input Not Allowed");
		} else {
			return num;
		}

	}
	private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
	private char getCustomDelimiter(String line) {
        if (line == null || line.isEmpty()) {
            return ',';
        }
        if (isNumeric(line)) {
            return ',';
        }
        if (line.length() == 1) {
            return line.charAt(0);
        }
        return ',';
    }

}
