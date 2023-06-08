package br.com.alura.factorymethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    // Java 9 - Factory method for collections
	public static void main(String[] args) {
		// ArrayList<String> names = new ArrayList<>();
		// names.add("firstName");
		// names.add("secondName");
		// names.add("thirdName");
		// List<String> immutableNames = Collections.unmodifiableList(names);

        // This list is already Immutable. We can't add new names to it.
        var immutableNames = List.of("firstName", "secondName", "thirdName");
		System.out.println(immutableNames);
        
	}
}
