package za.co.renieroosthuizen.infotxt.infoitems.manage.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import za.co.renieroosthuizen.infotxt.R;
import za.co.renieroosthuizen.infotxt.infoitems.manage.presenter.IManageInfoItemFragmentPresenter;
import za.co.renieroosthuizen.infotxt.infoitems.manage.presenter.ManageInfoItemFragmentPresenter;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPart;

public class ManageInfoItemFragment extends Fragment implements IManageInfoItemFragmentView {

    private IManageInfoItemFragmentPresenter mPresenter;

    @Bind(R.id.llParts)
    LinearLayout llParts;

    public ManageInfoItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        mPresenter = new ManageInfoItemFragmentPresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_manage_info_item, container, false);

        if (mPresenter == null)
            mPresenter = new ManageInfoItemFragmentPresenter(this);

        mPresenter.setView(this);
        mPresenter.loadData();

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_manage_info_item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            mPresenter.saveClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setInfoItem(InfoItem item) {
        mPresenter.setInfoItem(item);
        mPresenter.loadData();
    }

    @Override
    public void setModel(InfoItem item) {

    }

    @OnClick(R.id.fabNew)
    public void onClick(View view) {
        if (view.getId() == R.id.fabNew) {
            mPresenter.addNewInfoItemPart(
                    InfoItemPart.InfoItemType.Text
            );
        }
    }


    @Override
    public void addInfoItemPart(InfoItemPart part) {
        llParts.addView(part.getView());
    }

    @Override
    public Context getAppContext() {
        return getActivity().getApplicationContext();
    }
}
