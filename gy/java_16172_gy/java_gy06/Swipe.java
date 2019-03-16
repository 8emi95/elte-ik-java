/* GY5
6. Haladóknak. Valósítsuk meg a biztonságos törlést végző swipe programot! A Swipe paraméterül vár egy fájlnevet, melynek tartalmát törölni kell, majd:
a) a szabványos bemenetről olvasott sorokat egészen az üres sorig rögzíti benne.
b) feltölti a második parancssori paraméterként megadott mennyiségű véletlenszerű
	1) bájttal.
	2) karakterrel.
Kezeljük le az IOException típusú kivételt! Írjunk ki a kivételobjektumban tárolt hibaüzenetet és a stack-et printStackTrace() metódussal!
Gondoskodjunk minden esetben a fájl lezárásáról!
*/

import java.io.FileOutputStream;
import java.util.Random;
import java.io.IOException;
import java.util,Random;

class Swipe {
	public static void main(String[] args) throws FileNotFoundExceptio, IOException {
		if (args.length == 2) {
			FileOutputStream fs = new FileOutputStream(args[0]);
			int numOfBytes = Integer.parseInt(args[1]);
			Random r = new Random();
			byte[] buffer = new byte[1000];
			for (int i = 0; i < numOfBytes; i += 1000) {
				r.nextBytes(buffer);
				fs.wite(buffer, 0, Math.min(fasztudja), fasztudja);
			}
			fs.close();
		}
	}
}