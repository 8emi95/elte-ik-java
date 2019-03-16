/*
Definiáljunk egy saját ellenőrzött util.AlreadyContainsException kivételosztályt! Ilyet akkor váltunk ki, ha egy gyűjteménybe olyan elemet akarunk beszúrni, mely már megtalálható benne.
*/

class AlreadyContainsException extends Exception {
    public AlreadyContainsException(String message) {
        super(message);
    }
}