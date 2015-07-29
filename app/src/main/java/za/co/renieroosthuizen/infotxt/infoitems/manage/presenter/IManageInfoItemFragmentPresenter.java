package za.co.renieroosthuizen.infotxt.infoitems.manage.presenter;

import za.co.renieroosthuizen.infotxt.infoitems.manage.view.IManageInfoItemFragmentView;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;

/**
 * Created by Renier on 2015/07/28.
 */
public interface IManageInfoItemFragmentPresenter {
    IManageInfoItemFragmentView         getView();
    void                                setView             (IManageInfoItemFragmentView view);
    void                                saveClicked         ();
    void                                setInfoItem         (InfoItem item);
    void                                loadData            ();
    void                                addNewInfoItemPart  (InfoItemPart.InfoItemType type);
}
