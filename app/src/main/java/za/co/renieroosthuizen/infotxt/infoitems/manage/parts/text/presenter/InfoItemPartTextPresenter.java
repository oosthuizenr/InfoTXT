package za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.presenter;

import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;
import za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.view.IInfoItemPartTextView;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPartText;

/**
 * Created by Renier on 2015/07/28.
 */
public class InfoItemPartTextPresenter implements IInfoItemPartTextPresenter {

    private IInfoItemPartTextView mView;
    private InfoItemPartText mModel;

    @Override
    public void setView(IInfoItemPartTextView view) {
        mView = view;
    }

    @Override
    public void setModel(InfoItemPartText model) {
        mModel = model;

        mView.setName(mModel.getName());
        mView.setValue(mModel.getParameters().get(0).getValue());
    }

    @Override
    public void validate() throws ValidateException {
        mModel.validateItem();
    }
}
