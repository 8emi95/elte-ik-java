A Main.java fájl egy főprogramot tartalmaz, mely három parancssori argumentumot
vár:

    - almákat tartalmazó fájl neve,
    - mozgatásokat tartalmazó fájl neve,
    - kimeneti fájl neve.

A program az első két fájl tartalmát beolvassa soronként egy-egy listába.
Ezután létrehoz egy Game objektumot, paraméterül adva neki az első fájlból
beolvasott sorok listáját, majd meghívja a Game play metódusát, a második
fájl sorainak listájával. Az eredményül kapott szöveget írja ki a harmadik
fájlba.

Minták:

    1) Egyszerű minta. A kígyó nem eszik meg egy almát sem, magának ütközik.

    2) A kígyó 3 almát megeszik, járkál kicsit, és falnak ütközik. 

    3) Az almák elfogynak, a kígyó nem ütközik semminek.

    4) A kígyó sok almát megeszik, nagyra nő, végül magának ütközik.

    5) Ugyanaz, mint a 3)-as minta, csak hibás sorokat is tartalmaznak a
    bemenetek.

Az N. minta esetén az applesN.txt tartalmazza az almák leírását, a movesN.txt
a mozgatásokat, míg az outputN_exp.txt az elvárt kimenetet.

Így például az első minta futtatása:

    $ javac main.Main.java

    $ java main.Main apples1.txt moves1.txt output1.txt

    És ekkor az output1.txt tartalmát kell az output1_exp.txt-vel
	összehasonlítani. (Javasolt valamilyen diff tool alkalmazása.)
