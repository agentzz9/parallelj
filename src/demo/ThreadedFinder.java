package demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/*
 * PARALLEL EXECUTION using 4 threads, see main() for entry point.
 */
public class ThreadedFinder implements Runnable {

	private List<String> list, salts;
	private int startIndex, endIndex;
	private String hash;
	private long time;

	ThreadedFinder(List<String> l, int s, int e, String hash, List<String> salts) {

		super();
		this.list = l;
		this.startIndex = s;
		this.endIndex = e;
		this.hash = hash;
		this.salts = salts;

		this.time = System.currentTimeMillis();

	}

	@Override
	public void run() {

		for (int i = startIndex; i < endIndex; i++) {
			for (int j = 0; j < salts.size(); j++) {
				try {

					if (MD5.md5(list.get(i) + salts.get(j)).equalsIgnoreCase(hash)) {
						
						System.out.println("Password match found: " + list.get(i));
						System.out.println("thread id: " + this + " took time : "
								+ (System.currentTimeMillis() - this.time) + " ms. to locate match.");
						return;
					}

				} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }

			}
		}


	}

	public static void main(String[] args) throws IOException, InterruptedException {

		String secrethash = "D029515543C86A1E51E3C15DF52F0C1A";

		Path filePath = Paths.get("./10milpasswords.txt");
		Path saltPath = Paths.get("./probablesalts.txt");

		Charset charset = Charset.forName("UTF-8");

		List<String> lines = Files.readAllLines(filePath, charset);
		List<String> salts = Files.readAllLines(saltPath, charset);

		Thread threadedFinder1 = new Thread(new ThreadedFinder(lines, 0, lines.size() / 4, secrethash, salts));
		Thread threadedFinder2 = new Thread(
				new ThreadedFinder(lines, lines.size() / 4, lines.size() / 2, secrethash, salts));
		Thread threadedFinder3 = new Thread(
				new ThreadedFinder(lines, lines.size() / 2, (lines.size() / 4) * 3, secrethash, salts));
		Thread threadedFinder4 = new Thread(
				new ThreadedFinder(lines, (lines.size() / 4) * 3, lines.size(), secrethash, salts));

		threadedFinder1.start();
		threadedFinder2.start();
		threadedFinder3.start();
		threadedFinder4.start();

		/*
		 * threadedFinder1.join(); threadedFinder2.join(); threadedFinder3.join();
		 * threadedFinder4.join();
		 */

	}

}

//Password match found: notsosecurepassword
//thread id: demo.ThreadedFinder@72792b5f took time : 7855 ms. to locate match.
//Password match found: notsosecurepassword
//thread id: demo.ThreadedFinder@77aea4c6 took time : 7193 ms. to locate match.
//Password match found: notsosecurepassword
//thread id: demo.ThreadedFinder@29bfa297 took time : 6888 ms. to locate match.
//Password match found: notsosecurepassword
//thread id: demo.ThreadedFinder@5a4ff5c took time : 7604 ms. to locate match.
//Password match found: notsosecurepassword
//thread id: demo.ThreadedFinder@5053ede8 took time : 7874 ms. to locate match.

/*
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@79efa7af took time : 3409 ms. to locate match.
 * 
 * 
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@47b953f5 took time : 4266 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@13fc7190 took time : 3662 ms. to locate match.
 * 
 * 
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@334d2dc1 took time : 4070 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@492303ca took time : 4066 ms. to locate match.
 * 
 */
/*
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@34e024be took time : 40 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@656fdd9a took time : 43 ms. to locate match.
 * 
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@64302ce1 took time : 72 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@27c9dcb took time : 56 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@7ebe7b2e took time : 63 ms. to locate match.
 * 
 * 
 */
/*
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@53ba2280 took time : 14463 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@191a4a5a took time : 15007 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@8cbab62 took time : 14123 ms. to locate match.
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@3c74395a took time : 13832 ms. to locate match.
 * 
 * 
 * Password match found: notsosecurepassword thread id:
 * demo.ThreadedFinder@1a05d25e took time : 14751 ms. to locate match.
 * 
 * 
 * 
 */
