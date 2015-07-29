package za.co.renieroosthuizen.infotxt.infoitems.model;

import java.util.List;

/**
 * Created by Renier on 2015/06/24.
 */
public class InfoItem {
    private String guid;
    private String name;
    private List<InfoItemPart> infoItemParts;

    public InfoItem(String guid, String name, List<InfoItemPart> infoItemParts) {
        this.guid = guid;
        this.name = name;
        this.infoItemParts = infoItemParts;
    }

    public InfoItem()
    {

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

    public List<InfoItemPart> getInfoItemParts() {
        return infoItemParts;
    }

    public void setInfoItemParts(List<InfoItemPart> infoItemParts) {
        this.infoItemParts = infoItemParts;
    }
}
