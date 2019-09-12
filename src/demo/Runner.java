package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;

public class Runner {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException {

		String secrethash = "b4e76dfa18d7731b5bb13b5ea26c8232";

		Path filePath = Paths.get("./10milpasswords.txt");

		Charset charset = Charset.forName("UTF-8");

		List<String> lines = Files.readAllLines(filePath, charset);

		long startTime = System.currentTimeMillis();
		//SequentialFinder sequentialFinder = new SequentialFinder(lines, secrethash);
		//sequentialFinder.run();
		//5885
		System.out.println("Time elapsed (ms): " + (System.currentTimeMillis() - startTime));

		//Thread threadedFinder1 =  new Thread(new ThreadedFinder(lines, 0, lines.size()/4, secrethash));
		//Thread threadedFinder2 =  new Thread(new ThreadedFinder(lines, lines.size()/2, lines.size(), secrethash));
		//Thread threadedFinder3 =  new Thread(new ThreadedFinder(lines, lines.size()/2, (lines.size()/4)*3, secrethash));
		//Thread threadedFinder4 =  new Thread(new ThreadedFinder(lines, (lines.size()/4)*3, lines.size(), secrethash));
		
		//4: 2071
		
		//threadedFinder4.start();
		//threadedFinder3.start();
		//threadedFinder2.start();
		//threadedFinder1.start();
		
		
		//threadedFinder4.join();
		//threadedFinder3.join();
		//threadedFinder2.join();
		//threadedFinder1.join();
		
		System.out.println("Time elapsed (ms): " + (System.currentTimeMillis() - startTime));
		
		

		/*
		 * for(String line : lines) { //System.out.println(line + "->" + md5(line));
		 * if(md5(line).equalsIgnoreCase(secrethash)) {
		 * System.out.println("Password match found: " + line); } }
		 */

		/*
		 * lines.parallelStream().forEach((line)->{ try {
		 * if(md5(line).equalsIgnoreCase(secrethash)) {
		 * System.out.println("Password match found: " + line); } } catch
		 * (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } });
		 */
		/*
		 * lines.stream().forEach((line)->{ try {
		 * if(md5(line).equalsIgnoreCase(secrethash)) {
		 * System.out.println("Password match found: " + line); } } catch
		 * (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } });
		 */
		
		


	}

}
