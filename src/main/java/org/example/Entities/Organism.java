package org.example.Entities;

public abstract class Organism {
    private final Entities ENTITY_TYPE;
    public Organism(Entities ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE;
    }

    public Entities getENTITY_TYPE() {
        return ENTITY_TYPE;
    }
}
