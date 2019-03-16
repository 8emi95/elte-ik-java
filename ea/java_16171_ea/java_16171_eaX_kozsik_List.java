package hu.elte.kto;
import java.util.Iterator;
import java.util.Comparator;
import java.lang.function.Predicate;
public class List<T> implements Iterable<T> {   // enhanced for-loop!

	private Node<T> first;

	public void add( T item ){
		... new Node<T>() ...
	}

	private static class Node<S> {
		T item;
		Node<S> next;
	}

	public Iterator<T> iterator(){
		return new Iterator<T>(){
			Node<S> currentPosition = first;  // List.this.first
			public boolean hasNext(){ return currentPosition != null; }
			public S next(){
				T result = currentPosition.item;
				currentPosition = currentPosition.next;
			}
		};
	}

	public void sortBy( Comparator<T> comparator ){ ... }

	public T find( Predicate<T> predicate ){ ... }
}

List<String> list = ...
list.sortBy( new Comparator<String>(){
				public int compare( String left, String right ){
					return left.length() - right.length();
				}
			}
);

lambda:

list.sortBy( (left,right) -> left.length() - right.length() );
list.find( str -> str.isEmpty() )

"functional interface": egy absztrakt metódus, használható lambdával

pl. Predicate, Comparator...

@FunctionalInterface
public interface Predicate<T> { ... }

annotáció típus:
pl. @Override

public @interface Override { ... }


// fordítási egység tartalmazhat több típusdefiníciót, legfeljebb 1 public
// mindből lesz egy-egy bájtkód
// forrásfájl neve a public típus nevével egyezik
// inkább beágyazott típus kellene ide

// statikus tag: osztályszintű tag


// típus tagjai: attribútum, metódus, tagosztály, taginterfész
// plusz konstruktor, inicializációs blokk

// privát dolgokhoz is hozzáférünk


package java.util;
public interface Iterator<T> {
	boolean hasNext();
	T next();
	default void remove() { throw new OperationNotSupportedException(); }
	// Java 8-tól interface-ben lehetnek static és default műveletek
}

// példányszintű tagosztály (vagy -interface): nem static
// befoglaló objektum this-e is megvan

// metódusba beágyazott típusdefiníció
// lokális osztály, interfész
// mint a lokális változó, csak abban a metódusban használható
// a hatóköre a metódus

// hu.elte.kto.List.Node
// hu.elte.kto.List.ListIterator
// List.class, List$Node.class

// kifejezésbe ágyazott típusdefiníció: nem adok neki nevet, mert csak
// egyszer használom a definíciót: anoním osztály

// Comparable -> részbenrendezés: természetes rendezés, natural ordering
// Comparator: más rendezési szempont, int compare( T left, T right )

