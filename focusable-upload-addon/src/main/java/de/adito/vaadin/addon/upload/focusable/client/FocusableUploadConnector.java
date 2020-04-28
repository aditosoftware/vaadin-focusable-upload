package de.adito.vaadin.addon.upload.focusable.client;

import com.vaadin.client.ui.ConnectorFocusAndBlurHandler;
import com.vaadin.client.ui.upload.UploadConnector;
import com.vaadin.shared.ui.Connect;
import de.adito.vaadin.addon.upload.focusable.FocusableUpload;

/**
 * The connector between the Server-Side and Client-Side for the Upload.
 * This will add a focus handler to the submit button and the file input.
 */
@Connect(FocusableUpload.class)
public class FocusableUploadConnector extends UploadConnector {
  @Override
  protected void init () {
    super.init();

    // Add the focus handler to the submit button and the upload as we can
    // not make the file upload input unfocusable.
    ConnectorFocusAndBlurHandler.addHandlers(this, getWidget().submitButton);
    ConnectorFocusAndBlurHandler.addHandlers(this, getWidget().fu);
  }

  @Override
  public FocusableUploadWidget getWidget () {
    return (FocusableUploadWidget) super.getWidget();
  }
}
