package crud.vaadin;

import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import crud.backend.*;
import org.vaadin.spring.events.EventBus;
import org.vaadin.teemu.switchui.Switch;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@UIScope
@SpringComponent
public class PropertyForm extends AbstractForm<Property_a> {

    private static final long serialVersionUID = 1L;

    EventBus.UIEventBus eventBus;
    Property_aRepository repo;

    TextField pName = new MTextField("Property Name");
    TextField pStreetAddress1 = new MTextField("Street Address");
    TextField pCity = new MTextField("City");
    TextField pZipcode = new MTextField("Zipcode");
    TextField pState = new MTextField("State");
    
   // TextField phoneNumber = new MTextField("Phone");
    //DateField birthDay = new DateField("Birthday");
    //Switch colleague = new Switch("Colleague");

    PropertyForm(Property_aRepository r, EventBus.UIEventBus b) {
        super(Property_a.class);
        this.repo = r;
        this.eventBus = b;

        // On save & cancel, publish events that other parts of the UI can listen
        setSavedHandler(house -> {
            // persist changes
            repo.save(house);
            // send the event for other parts of the application
            eventBus.publish(this, new PropertyModifiedEvent(house));
        });
        setResetHandler(p -> eventBus.publish(this, new PropertyModifiedEvent(p)));

        setSizeUndefined();
    }

    @Override
    protected void bind() {
        // DateField in Vaadin 8 uses LocalDate by default, the backend
        // uses plain old java.util.Date, thus we need a converter, using
        // built in helper here
        getBinder();
//                .forMemberField(birthDay)
//                .withConverter(new LocalDateToDateConverter());
        super.bind();
    }

    @Override
    protected Component createContent() {
        return new MVerticalLayout(
                new MFormLayout(
                		pName,
                		pStreetAddress1,
                		pCity,
                		pZipcode,
                		pState
                        //phoneNumber,
                        //birthDay,
                        //colleague
                ).withWidth(""),
                getToolbar()
        ).withWidth("");
    }

}
