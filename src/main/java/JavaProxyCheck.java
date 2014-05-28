package de.lassitu;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;

class JavaProxyCheck {
		public static void main(String args[]) {
				ProxySelector s = ProxySelector.getDefault();

				if (args.length == 0) {
					System.err.println("usage: java -jar JavaProxyCheck.jar http://www.example.com/");
				}				
				for (String a : args) {
						try {
								System.out.printf("%-40.40s %s\n", a, s.select(new URI(a)));
						} catch (URISyntaxException | IllegalArgumentException e) {
								System.out.printf("%-40.40s Invalid URI: %s\n", a, e.getMessage());
						}
				}
		}
}