package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Compiler {
	String text, sentence = "", word = "", code = "", path, className = "";
	char c;

	boolean classy = false;

	Compiler(String text, String path) {
		this.text = text;
		this.path = path;
		sentence_maker();
	}

	void sentence_maker() {
		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			if (c != ';' && c != '{')
				sentence = sentence + c;
			else {
				code_maker(sentence + c);
				sentence = "";
			}
		}
		code = code + "\t}\n}";
		System.out.println("Java Code :-\n"+code);
		FileWriting();
	}

	void code_maker(String sent) {
		for (int i = 0; i < sent.length(); i++) {
			c = sent.charAt(i);
			if (c != ' ') {
				word = word + c;
				if (classy == true)
					className = word;
			} else {
				classy = false;
				if (word.equals("IntricateEttiquette"))
					classy = true;

				word = "";
			}
		}
		sent = sent.replace("integer", "int");
		sent = sent.replace("decimalPointNo", "double");
		sent = sent.replace("groupOfCharacters", "String");
		sent = sent.replace("true_falseHolder", "boolean");
		sent = sent.replace("makeWindow", "JFrame");
		sent = sent.replace("PrintToConsole", "System.out.println");
		sent = sent.replace("includeToFile", "import");
		sent = sent.replace("Goofy Ahh Harry Potter Like Spell", "public static void main");
		sent = sent.replace("IntricateEttiquette", "class");
		sent = sent.replace("lengthenWith", "extends");
		sent = sent.replace("PrintToConsole", "System.out.println");
		code = code + sent + "\n";
	}

	void FileWriting() {
		String running = this.path + "\\YRF.bat";
		this.path = this.path + "\\"+className+".java";
		String fileName = className + ".java";
		File file = new File(fileName);
		FileWriter writer;
		if (file.exists()) {
//			System.out.println(fileName + " exists.");
		} else {
			file = new File(path);
		}
		try {
			writer = new FileWriter(file);
			// write some data to the file
			writer.write(code);

			// flush the writer to ensure that all data is written to the file
			writer.flush();

			// close the writer to free up system resources
			writer.close();
//			System.out.println("Data written to file successfully!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(running);
		File runner = new File(running);
		if (runner.exists()) {
//			System.out.println(running + " exists.");
		} else {
			runner = new File(running);
		}
		try {
			writer = new FileWriter(runner);
			// write some data to the file
			writer.write("java "+className+".java");

			// flush the writer to ensure that all data is written to the file
			writer.flush();

			// close the writer to free up system resources
			writer.close();

//			System.out.println("Data written to file successfully!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MyClass(path, className);
	}
}