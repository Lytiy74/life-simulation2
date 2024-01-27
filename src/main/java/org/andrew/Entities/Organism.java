package org.andrew.Entities;

import org.andrew.Services.ConfigLoader;

public abstract class Organism {
    private final String  PROPERTIES_KEY;
    private final EntityType ENTITY_TYPE;
    private final int maxEntitiesCount;

    public Organism(String PROPERTIES_KEY, EntityType ENTITY_TYPE){
        this.PROPERTIES_KEY = PROPERTIES_KEY;
        this.ENTITY_TYPE = ENTITY_TYPE;
        this.maxEntitiesCount = ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxEntitiesCount");
    }

    public String getPROPERTIES_KEY() {
        return PROPERTIES_KEY;
    }

    public EntityType getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    public int getMaxEntitiesCount() {
        return maxEntitiesCount;
    }

}
