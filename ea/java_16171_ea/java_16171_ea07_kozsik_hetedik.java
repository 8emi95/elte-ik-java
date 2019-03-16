ArrayList<Integer> ls = new ArrayList<Integer>();

ls.add(new Integer(4));
Integer result = ls.get(0);

ls.add(5);       --- auto-boxing --->   ls.add(new Integer(5));
int value = ls.get(1); --- auto-unboxing ---> int value = ls.get(1).intValue();

auto-(un)boxing: automatikus típuskonverzió, amit a fordító tesz be a kódba
objektumba csomagolás
akkor, ha másként nem értelmes a kód, de azzal értelmessé tehető

1+1

1 + new Integer(3)

long val = 12L;    // 12l is jó, de rosszul olvasható
long val2 = 12;   --automatikus típuskonverzió --> 12 -> 12L

long típusúnak értékül adható int típusú

int i = 2;
val2 = i + 2;
val2 = ((long) i) + 2L    explicit típuskonverzió, typecast operátor

ellenkező irány:
int v = val;         // forditasi hiba
int v = (int)val;    // mukodik, de veszelyes: ha val tul nagy vagy tul kicsi,
                 // v-be "fura" ertek kerul  (32 bitnyi informaciot eldobtunk)

automatikus a primitiv tipusok kozott:
b < s < i < l
f < d
biztonsagos, de ez is megy automatikus konvezrioval:
int f = i      pontossagveszto ertekadas, nem biztonsagos

vissza a csomagolokhoz:

int Integer.parseInt(String)
Integer.MAX_VALUE   (public static final mezo),   2^31-1

csomagolo osztalyok: immutable, modosithatatlan
java.lang.String   is ilyen

"hello" + " " + "world!"

String concat( String[] args ){
	String result = "";
	for( String str: args ) result += str;
	return result;
}

String concat( String[] args ){
	String result = "";
	for( String str: args ){
		result = result + str;
	}
	return result;
}

String concat( String[] args ){
	StringBuilder result = new StringBuilder();    // mutable karakterlanc
	for( String str: args ) result.append(str);
	return result.toString();
}

new StringBuilder().append("hello").append(" ").append("world!").toString()


enum Color { RED, WHITE, GREEN }

három érték felsorolásával felsorolási típust hoztam létre
ennek a típusnak nincs több típusértéke
hasznos, ha viszonylag kicsi, de fix típusértékhalmazt szeretnénk
biztonságosabb, olvashatóbb kódot eredményez, mint számokkal reprezentálni

public enum Month {
	JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30); // ...
	public final int days;
	Month( int days ){ this.days = days; }
	public int firstSaturday( int year ){ ... }
}

int v = 12;
switch ( v-8 ){
	case 3: ++v;
	case 4: --v;
	default: v +=5;
}

vicces utasitas  (serti a struktiralt programozas elveit)
strukturalt valtozat: switch-case-break utasitas

int v = 12;
switch ( v-8 ){
	case 3: ++v; break;
	case 4: --v; break;
	default: v +=5;
}

switch (str ){
	case "hello": return "bye";
	case "salut": return "a bientot";
	deafault: return "viszlat";
}

switch( myColor ){
	case RED: ...
	...
}


RED.ordinal()

for( Color c: Color.values() ) ....

csellengő else (dangling else) probléma

if( x>0 )
	if( y>0 )
		z = 1;
else
	z = -1;

azzal ekvivalens, hogy

if( x>0 )
	if( y>0 )
		z = 1;
	else
		z = -1;

csak rosszul volt tordelve. ez az uj tordeles felel meg a kod jelentesenek

amit valoszinuleg szerettunk volna:

if( x>0 ){
	if( y>0 )
		z = 1;
} else
	z = -1;

ajanlott kodolasi stilus: mindig kitesszuk a {}-ket

if( x>0 ){
	if( y>0 ){
		z = 1;
	}
} else {
	z = -1;
}

többágú elágazás idiómája

if( felt-1 ){

} else if( felt-2 ){

} else if( felt-3 ){

} else {

}

if( felt-1 ){

} else {
	if( felt-2 ){

	} else {
		if( felt-3 ){

		} else {

		}
	}
}



while (x > 0)
	--x;
	System.out.println(x);

helyesen tordelve (jelentesnek megfeleloen tordelve)

while (x > 0)
	--x;
System.out.println(x);

while (x > 0){
	--x;
	System.out.println(x);
}

karbantartas sopran nehezebben romlik el a kod, ha mindig kitesszuk a {}-ket

while (<feltetel>) <utasitas>
jellemzoen <utasitas> egy <blokk-utasitas>

do <utasitas> while (<feltetel>)

for(<init> ; <feltetel> ; <utasitas>) <utasitas>

for(;;);
while(true);

for( <dekl> : <adatszerk> ) <utasitas>

ciklusok átírása egymásba:

do <utasitas> while (<feltetel>)
=>
<utasitas>; while (<feltetel>) <utasitas>

while (<feltetel>) <utasitas>
=>
if(<feltetel>) do <utasitas> while (<feltetel>)

while (<feltetel>) <utasitas>
=>
for( ; <feltetel>; ) <utasitas>

Másik irány nem mindig működik:

for( <init> ; <feltetel>; <utasitas1>) <utasitas2>
=>
<init> ; while (<feltetel>){ <utasitas_2>; <utasitas1> }

mi okozza azt, hogy ez az utóbbi átírás nem tökéletes? Házi feladat!

