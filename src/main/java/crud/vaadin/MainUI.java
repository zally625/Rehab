package crud.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.provider.GridSortOrder;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.event.SortEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.components.DisclosurePanel;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;


import crud.backend.*;


@Title("Rehab Application")
@Theme("valo")
@SpringUI
public class MainUI extends UI {

    private static final long serialVersionUID = 1L;

    private final Property_aRepository repo;
    //private final Property_aEditor editor;
    
    PropertyForm propertyForm;
    EventBus.UIEventBus eventBus;
 
    
    
    private MGrid<Property_a> list = new MGrid<>(Property_a.class)
            .withProperties("propertyId", "PName", "PStreetAddress1", "PCity", "PZipcode", "PState")  //*** Vaadin Error with Database
           // .withColumnHeaders("Property ID", " Property Name", "Street");
            .withColumnHeaders( "ID", "Property Name", "Street", "City", "Zipcode", "State");
            
            // not yet supported by V8
            //.setSortableProperties("name", "email")
            //.withFullWidth();  // TODO RZD make smaller size
    

    private MTextField filterByName = new MTextField()
            .withPlaceholder("Filter by Property Name"); 
    
    
    private Button addNew = new MButton(VaadinIcons.PLUS, this::add);
    private Button edit = new MButton(VaadinIcons.PENCIL, this::edit);
    private Button delete = new ConfirmButton(VaadinIcons.TRASH,
            "Are you sure you want to delete the entry?", this::remove);
    
    

    public MainUI(Property_aRepository repo, PropertyForm f, EventBus.UIEventBus b) {
        this.repo = repo;
        
        //this.editor = editor;
        
        this.propertyForm = f;
        this.eventBus = b;
    }

    @Override
    protected void init(VaadinRequest request) {
       
        setContent(
                new MVerticalLayout(
                        new MHorizontalLayout(filterByName, addNew, edit, delete),
                        list
                ).expand(list)
        );
        
        list.setWidth("75%");
        listEntities();
        
        // set the size of the text box
        filterByName.setWidth(250, Unit.PIXELS);
        
        
//        list.asSingleSelect().addValueChangeListener(e -> {
//			editor.editProperty_a(e.getValue());
//		});

        list.asSingleSelect().addValueChangeListener(e -> adjustActionButtonState());
        filterByName.addValueChangeListener(e -> {
            listEntities(e.getValue());
        });

        eventBus.subscribe(this);
    }

    
    protected void adjustActionButtonState() {
        boolean hasSelection = !list.getSelectedItems().isEmpty();
        edit.setEnabled(hasSelection);
        delete.setEnabled(hasSelection);
    }
    
    private void listEntities() {
        //listEntities(filterByName.getValue());
        listProperties(filterByName.getValue());
        
    }
    
    private void listEntities(String nameFilter) {

        list.setRows(repo.findByPName(nameFilter));
        adjustActionButtonState();

    }
    

    final int PAGESIZE = 45;

    void listProperties(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			
			list.setRows(repo.findAll());
		}
		else {
			list.setRows(repo.findByPName(filterText));
		}
	}
    
    

    public void add(ClickEvent clickEvent) {
        edit(new Property_a());
    }

    public void edit(ClickEvent e) {
        edit(list.asSingleSelect().getValue());
    }

    public void remove() {
        repo.delete(list.asSingleSelect().getValue());
        list.deselectAll();
        listEntities();
    }
    
    

    protected void edit(final Property_a propertyEntry) {
    	propertyForm.setEntity(propertyEntry);
        propertyForm.openInModalPopup();
    }

    @EventBusListenerMethod(scope = EventScope.UI)
    public void onPropertyModified(PropertyModifiedEvent event) {
        listEntities();
        propertyForm.closePopup();
    }

}
