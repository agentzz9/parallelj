package demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/*
 * SEQUENTIAL EXECUTION, see main() for entry point.
 */
public class SequentialFinder {

	private List<String> list, salts;
	private String hash;
	private long time;

	public SequentialFinder(List<String> l, String hash, List<String> salts) {

		super();
		this.list = l;
		this.hash = hash;
		this.salts = salts;
		this.time = System.currentTimeMillis();

	}

	public void run() {

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < salts.size(); j++) {
				try {
					
					if (MD5.md5(list.get(i) + salts.get(j)).equalsIgnoreCase(hash)) {
						
						System.out.println("Password match found: " + list.get(i));
						System.out.println("Sequential finder: " + this + "took time : "
								+ (System.currentTimeMillis() - this.time) + " ms");
						return;
					}
					
				} catch (NoSuchAlgorithmException e) {	e.printStackTrace(); }

			}

		}

	}

	public static void main(String[] args) throws IOException {
		// notsosecurepasswordsalted
		String secrethash = "D029515543C86A1E51E3C15DF52F0C1A";

		Path filePath = Paths.get("./10milpasswords.txt");
		Path saltPath = Paths.get("./probablesalts.txt");

		Charset charset = Charset.forName("UTF-8");

		List<String> lines = Files.readAllLines(filePath, charset);
		List<String> salts = Files.readAllLines(saltPath, charset);

		SequentialFinder sequentialFinder = new SequentialFinder(lines, secrethash, salts);
		sequentialFinder.run();

	}

}

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

//
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 43477 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 44099 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 41725 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 42615 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 42823 ms

//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 14993 ms
//	Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 15240 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 15250 ms
//	Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 15430 ms
//Password match found: notsosecurepassword
//	Sequential finder: demo.SequentialFinder@1de0aca6took time : 15840 ms

/*
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 30 ms
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 29 ms
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 33 ms
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 30 ms
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 30 ms
 * 
 */
/*
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 46000 ms
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 49621 ms
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 48717 ms
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 46136 ms
 * 
 * 
 * Password match found: notsosecurepassword Sequential finder:
 * demo.SequentialFinder@1de0aca6took time : 53892 ms
 * 
 * 
 */
