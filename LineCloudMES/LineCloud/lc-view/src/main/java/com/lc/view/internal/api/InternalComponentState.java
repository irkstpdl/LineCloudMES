package com.lc.view.internal.api;

import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import com.lc.view.api.ComponentState;


public interface InternalComponentState  extends ComponentState {

    /**
     * Initialize this component state using data from client. <b>For internal usage only</b>
     *
     * @param json
     *            data from client
     * @param locale
     *            current localization
     * @throws JSONException
     *             when data from client contains errors
     */
    void initialize(JSONObject json, Locale locale) throws JSONException;

    /**
     * Renders this component state back to client. <b>For internal usage only</b>
     *
     * @return data to client
     * @throws JSONException
     *             when data for client contains errors
     */
    JSONObject render() throws JSONException;

    /**
     * Returns true if element defined by this component is permanently disabled
     *
     * @return true if element defined by this component is permanently disabled
     */
    boolean isPermanentlyDisabled();

    /**
     * Defines if element defined by this component should be permanently disabled. Permanently disabled means that you can not
     * enable them using {@link ComponentState.setEnabled()}
     *
     * @param permanentlyDisabled
     *            true if element defined by this component should be permanently disabled
     */
    void setPermanentlyDisabled(boolean permanentlyDisabled);
}
