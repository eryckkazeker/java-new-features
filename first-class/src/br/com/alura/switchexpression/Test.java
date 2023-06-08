package br.com.alura.switchexpression;

public class Test {

    // Java 14 lambda switch expression
	public static void main(String[] args) {
		String name = "John";
		// switch (name) {
		// case "Mary": {
		// 	System.out.println("Found: " + name);
		// 	break;
		// }
		// case "John": {
		// 	System.out.println("Found: " + name);
		// 	break;
		// }
		// default: {
		// 	System.out.println("Name not found!!");
		// }
		// }

        switch(name) {
            case "Mary" -> System.out.println("Found: " + name);
            case "John" -> System.out.println("Found: " + name);
            default -> System.out.println("Name not found!!");
        }
	}
}
