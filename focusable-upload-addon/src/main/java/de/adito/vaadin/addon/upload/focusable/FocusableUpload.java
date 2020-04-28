package de.adito.vaadin.addon.upload.focusable;

import com.vaadin.event.FieldEvents;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Component;
import com.vaadin.ui.Upload;

/**
 * A {@link Upload} implementation which adds the {@link Component.Focusable}
 * and {@link FieldEvents.FocusNotifier} ability to a Vaadin Upload. This will
 * add a focus listener to the button of the upload.
 */
public class FocusableUpload extends Upload implements Component.Focusable, FieldEvents.FocusNotifier {
  public FocusableUpload () {
    _registerFocusAndBlur();
  }

  public FocusableUpload (String caption, Receiver uploadReceiver) {
    super(caption, uploadReceiver);
    _registerFocusAndBlur();
  }

  @Override
  public Registration addFocusListener (FieldEvents.FocusListener listener) {
    return addListener("focus", FieldEvents.FocusEvent.class, listener, FieldEvents.FocusListener.focusMethod);
  }

  /**
   * Will register the Rpc which handles the focus and blur events from the
   * client-side.
   */
  private void _registerFocusAndBlur () {
    registerRpc(new FieldEvents.FocusAndBlurServerRpcDecorator(this, this::fireEvent));
  }
}
