package br.com.alura.variableInference;

import java.util.HashMap;
import java.util.Map;

public class Test {

    // Combining the variable inference from Java 10 with the factory method from Java 9
	public static void main(String[] args) {
		// HashMap<String, String> cpfByNames = new HashMap<String, String>();
		// cpfByNames.put("John", "04813189");

        var cpfByNames = Map.of("John", "04813189");

		System.out.println(cpfByNames);
	}
}
