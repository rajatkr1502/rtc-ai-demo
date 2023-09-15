package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {
	
	public static void logException(Exception exception, String methodName, String className) {
        try {
        	String systemDirectory = System.getProperty("user.dir");
        	System.out.println(systemDirectory);
            FileWriter fileWriter = new FileWriter(systemDirectory+"/src/test/resources/data/exception_log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("------------------------");
            printWriter.println("Exception occurred in Class : " + className);
            printWriter.println("Exception occurred in Method : " + methodName);
            printWriter.println("Exception Found : " );
            exception.printStackTrace(printWriter);
            printWriter.println("------------------------");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}