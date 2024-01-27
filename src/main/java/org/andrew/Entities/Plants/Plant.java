package org.andrew.Entities.Plants;

import org.andrew.Entities.EntityType;
import org.andrew.Entities.Organism;
import org.andrew.Services.ConfigLoader;

public abstract class Plant extends Organism {
    private final PlantType PLANT_TYPE;
    public Plant(String PROPERTIES_KEY, PlantType PLANT_TYPE){
        super(PROPERTIES_KEY, EntityType.PLANT);
        this.PLANT_TYPE = PLANT_TYPE;
    }

    @Override
    public String toString() {
        return PLANT_TYPE.toString();
    }
}
