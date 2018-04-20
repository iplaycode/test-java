package live.fangwei.lang;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Test;

public class TestRuntime {

	@Test
	public void test() throws IOException {
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"ls","-l"};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new 
		     InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    System.out.println(s);
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
		    System.out.println(s);
		}
	}
	
	@Test
	public void test1() throws ExecuteException, IOException {
		CommandLine cl = new CommandLine("python");
		cl.addArgument("/fwei/test/push_stat_gmsg_report.py");
		cl.addArgument("2016-01-01");
		cl.addArgument("2016-02-29");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		int exitValue = executor.execute(cl);

		String out = outputStream.toString();
		String error = errorStream.toString();
		System.out.println("exitValue: " + exitValue);
		System.out.println("\nout: \n" + out);
		System.out.println("\nerror: \n" + error);
	}

}
