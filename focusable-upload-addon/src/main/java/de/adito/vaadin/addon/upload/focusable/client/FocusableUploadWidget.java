package de.adito.vaadin.addon.upload.focusable.client;

import com.vaadin.client.Focusable;
import com.vaadin.client.ui.VUpload;

/**
 * Implements the {@link Focusable#focus()} method to redirect the focus on
 * this widget to the submit button.
 */
public class FocusableUploadWidget extends VUpload implements Focusable {
  @Override
  public void focus () {
    // Set the focus on the button.
    submitButton.setFocus(true);
  }
}
