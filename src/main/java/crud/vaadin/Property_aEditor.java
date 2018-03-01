package crud.vaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import crud.backend.Property_a;
import crud.backend.Property_aRepository;


/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */
@SpringComponent
@UIScope

public class Property_aEditor extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Property_aRepository repositoryHouse;
	
	private Property_a house;
	
	/* Fields to edit properties in Customer entity */
	TextField pName = new TextField("P Name");
	TextField pStreetAddress1 = new TextField("Street Address");
	
	
	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	//VaadinIcons.PLUS,
	
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);
	
	Binder<Property_a> binder = new Binder<>(Property_a.class);
	
	
	@Autowired
	public Property_aEditor(Property_aRepository repositoryHouse) {
		this.repositoryHouse = repositoryHouse;

		addComponents(pName, pStreetAddress1, actions);
	
		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repositoryHouse.save(house));
		delete.addClickListener(e -> repositoryHouse.delete(house));
		cancel.addClickListener(e -> editProperty_a(house));
		setVisible(false);				
	}
	
	public interface ChangeHandler {

		void onChange();
	}

	public final void editProperty_a(Property_a h) {
		if (h == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = h.getPropertyId() != null;
		if (persisted) {
			// Find fresh entity for editing
			house = repositoryHouse.findOne(h.getPropertyId());
		}
		else {
			house = h;
		}
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(house);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		pName.selectAll();
	}	
	
	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}
	
}
