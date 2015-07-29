package za.co.renieroosthuizen.infotxt.infoitems.model;

import java.util.List;

import za.co.renieroosthuizen.infotxt.exceptions.SMSGenerationException;
import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;

/**
 * Created by Renier on 2015/06/23.
 */
public class InfoItemPartAddress extends InfoItemPart {

    public InfoItemPartAddress(String guid, String name, List<InfoItemPartParameter> parameters)
    {
        this.setType(InfoItemType.Address);
        this.setGuid(guid);
        this.setName(name);
        this.setParameters(parameters);
    }

    @Override
    public String generateSMSString() throws SMSGenerationException {
        return getName() + " - " + getParameters().get(0).getValue();
    }

    @Override
    public void validateItem() throws ValidateException {

    }
}
