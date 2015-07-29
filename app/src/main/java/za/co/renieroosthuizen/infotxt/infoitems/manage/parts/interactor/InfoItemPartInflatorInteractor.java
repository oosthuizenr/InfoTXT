package za.co.renieroosthuizen.infotxt.infoitems.manage.parts.interactor;

import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.UUID;

import za.co.renieroosthuizen.infotxt.R;
import za.co.renieroosthuizen.infotxt.infoitems.manage.presenter.IManageInfoItemFragmentPresenter;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPartParameter;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPartText;

/**
 * Created by Renier on 2015/07/29.
 */
public class InfoItemPartInflatorInteractor {
    private IManageInfoItemFragmentPresenter mPresenter;
    private LayoutInflater mLayoutInflater;

    public InfoItemPartInflatorInteractor(IManageInfoItemFragmentPresenter presenter)
    {
        mPresenter = presenter;
        mLayoutInflater = LayoutInflater.from(presenter.getView().getAppContext());
    }


    public InfoItemPart inflateNewInfoItemPart(InfoItemPart.InfoItemType type)
    {
        switch (type)
        {
            case Address:

                break;
            case Email:

                break;
            case GPS:

                break;
            case PhoneNumber:

                break;
            case Text:
                InfoItemPartText part = new InfoItemPartText(UUID.randomUUID().toString(), "", new ArrayList<InfoItemPartParameter>());
                part.setView(inflateView(R.layout.manage_part_text));

                return part;
            case Website:

                break;
        }

        return null;
    }

    public InfoItemPart inflateFromExistingInfoItemPart(InfoItemPart part)
    {
        return null;
    }

    private View inflateView(int viewId)
    {
        return mLayoutInflater.inflate(viewId, null);
    }



}
