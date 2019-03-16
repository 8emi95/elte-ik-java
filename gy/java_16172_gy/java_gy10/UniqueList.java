import java.util.*;

class UniqueList<T> {
    private List<T> elems = new ArrayList<T>();

    public void uniqueAdd(T elem) throws AlreadyContainsException {
        if (elems.contains(elem)) {
            throw new AlreadyContainsException("Already in the list: " + elem);
        } else {
            elems.add(elem);
        }
    }
}