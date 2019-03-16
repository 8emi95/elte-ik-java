package bead.championships.results;

import java.lang.Object;

public final class Factory extends Object {


    public static Results createResults(){
        Results results = new Return();
        return results;
    }
}
