package main;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class MyClass {
	MyClass(String path,String className) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, path);
		if (result == 0) {
			System.out.println("Compilation successful");
			try {
			    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", path.replaceAll(className+".java", "YRF.bat"));
			    pb.inheritIO();
			    Process process = pb.start();
			    process.waitFor();
			} catch (Exception e) {
			    e.printStackTrace();
			}

		} else {
			System.out.println("Compilation failed");
		}
	}
}
