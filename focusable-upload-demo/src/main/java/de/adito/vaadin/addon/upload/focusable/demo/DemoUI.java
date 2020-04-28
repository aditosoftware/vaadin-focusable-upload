package de.adito.vaadin.addon.upload.focusable.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.adito.vaadin.addon.upload.focusable.FocusableUpload;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("MyComponent Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init (VaadinRequest request) {

    // Initialize our new UI component
    final FocusableUpload component = new FocusableUpload();
    component.setImmediateMode(true);
    component.setButtonCaption("Hier Datei hochladen");
    component.addFocusListener(event -> System.out.println("FOCUS!"));

    final Button focusButton = new Button();
    focusButton.addClickListener(event -> component.focus());

    // Show it in the middle of the screen
    final VerticalLayout layout = new VerticalLayout();
    layout.setStyleName("demoContentLayout");
    layout.setSizeFull();
    layout.setMargin(false);
    layout.setSpacing(false);
    layout.addComponent(component);
    layout.addComponent(focusButton);
    layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
    setContent(layout);
  }
}
