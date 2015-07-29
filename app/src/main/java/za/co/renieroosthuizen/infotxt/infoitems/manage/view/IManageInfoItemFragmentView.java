package za.co.renieroosthuizen.infotxt.infoitems.manage.view;

import android.content.Context;

import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;

/**
 * Created by Renier on 2015/07/28.
 */
public interface IManageInfoItemFragmentView {
    Context         getAppContext           ();
    void            setInfoItem             (InfoItem item);
    void            setModel                (InfoItem item);
    void            addInfoItemPart         (InfoItemPart part);
}
