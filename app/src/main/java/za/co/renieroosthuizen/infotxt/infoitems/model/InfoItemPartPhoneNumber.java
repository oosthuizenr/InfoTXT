package za.co.renieroosthuizen.infotxt.infoitems.model;

import java.util.List;

import za.co.renieroosthuizen.infotxt.exceptions.SMSGenerationException;
import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;

/**
 * Created by Renier on 2015/06/23.
 */
public class InfoItemPartPhoneNumber extends InfoItemPart {

    public InfoItemPartPhoneNumber(String guid, String name, List<InfoItemPartParameter> parameters)
    {
        this.setType(InfoItemType.PhoneNumber);
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
