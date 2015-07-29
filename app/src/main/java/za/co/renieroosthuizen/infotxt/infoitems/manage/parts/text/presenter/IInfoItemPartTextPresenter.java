package za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.presenter;

import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;
import za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.view.IInfoItemPartTextView;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPartText;

/**
 * Created by Renier on 2015/07/28.
 */
public interface IInfoItemPartTextPresenter {
    void            setView             (IInfoItemPartTextView view);
    void            setModel            (InfoItemPartText model);
    void            validate            ()                                      throws ValidateException;
}
