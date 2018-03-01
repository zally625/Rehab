package crud.vaadin;

import crud.backend.*;
import java.io.Serializable;

public class PropertyModifiedEvent implements Serializable {

    private final Property_a house;

    public PropertyModifiedEvent(Property_a h) {
        this.house = h;
    }

    public Property_a getProperty() {
        return house;
    }
    
}
