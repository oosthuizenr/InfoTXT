package za.co.renieroosthuizen.infotxt.infoitems.model;

import android.view.View;

import java.util.List;

import za.co.renieroosthuizen.infotxt.exceptions.SMSGenerationException;
import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;

/**
 * Created by Renier on 2015/06/23.
 */
public abstract class InfoItemPart {
    public enum InfoItemType {
        Text,
        PhoneNumber,
        Email,
        Website,
        Address,
        GPS
    }

    private String guid;

    private InfoItemType type;
    private String name;
    private List<InfoItemPartParameter> parameters;
    private View view;


    public InfoItemType getType() {
        return type;
    }

    public void setType(InfoItemType type) {
        this.type = type;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InfoItemPartParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<InfoItemPartParameter> parameters) {
        this.parameters = parameters;
    }

    public abstract String generateSMSString() throws SMSGenerationException;

    public abstract void validateItem() throws ValidateException;

    public void setView (View v) { view = v; }
    public View getView () { return view; }

}
