package za.co.renieroosthuizen.infotxt.infoitems.manage.presenter;

import za.co.renieroosthuizen.infotxt.infoitems.manage.parts.interactor.InfoItemPartInflatorInteractor;
import za.co.renieroosthuizen.infotxt.infoitems.manage.view.IManageInfoItemFragmentView;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;

/**
 * Created by Renier on 2015/07/28.
 */
public class ManageInfoItemFragmentPresenter implements IManageInfoItemFragmentPresenter {
    private IManageInfoItemFragmentView mView;
    private InfoItemPartInflatorInteractor mInflatorInteractor;
    private InfoItem mItem;

    public ManageInfoItemFragmentPresenter(IManageInfoItemFragmentView view)
    {
        mView = view;

        mInflatorInteractor = new InfoItemPartInflatorInteractor(this);
    }


    @Override
    public void setView(IManageInfoItemFragmentView view) {
        mView = view;
    }

    @Override
    public IManageInfoItemFragmentView getView() {
        return mView;
    }

    @Override
    public void saveClicked() {


    }

    @Override
    public void setInfoItem(InfoItem item) {
        mItem = item;
    }

    @Override
    public void loadData() {
        if (mItem == null)
        {
            mItem = new InfoItem();
        }
    }

    @Override
    public void addNewInfoItemPart(InfoItemPart.InfoItemType type) {
        mView.addInfoItemPart(mInflatorInteractor.inflateNewInfoItemPart(type));
    }
}
