package za.co.renieroosthuizen.infotxt.infoitems.model;

/**
 * Created by Renier on 2015/06/23.
 */
public class InfoItemPartParameter {
    private String guid;
    private String key;
    private String value;

    public InfoItemPartParameter(String guid, String key, String value) {
        this.guid = guid;
        this.key = key;
        this.value = value;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
