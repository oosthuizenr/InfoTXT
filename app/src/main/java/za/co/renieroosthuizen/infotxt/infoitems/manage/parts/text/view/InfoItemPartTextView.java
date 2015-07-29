package za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.Bind;
import za.co.renieroosthuizen.infotxt.R;
import za.co.renieroosthuizen.infotxt.exceptions.ValidateException;
import za.co.renieroosthuizen.infotxt.infoitems.manage.interfaces.IValidate;
import za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.presenter.IInfoItemPartTextPresenter;
import za.co.renieroosthuizen.infotxt.infoitems.manage.parts.text.presenter.InfoItemPartTextPresenter;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItemPartText;

/**
 * Created by Renier on 2015/07/28.
 */
public class InfoItemPartTextView extends RelativeLayout implements IInfoItemPartTextView, IValidate {
    private IInfoItemPartTextPresenter mPresenter;

    @Bind(R.id.edtName)
    EditText edtName;

    @Bind(R.id.edtValue)
    EditText edtValue;

    public InfoItemPartTextView(Context context) {
        super(context);
        init();
    }

    public InfoItemPartTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InfoItemPartTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InfoItemPartTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init()
    {
        inflate(getContext(), R.layout.manage_part_text, this);

        mPresenter = new InfoItemPartTextPresenter();
        mPresenter.setView(this);
    }


    @Override
    public void setModel(InfoItemPartText model) {
        mPresenter.setModel(model);
    }

    @Override
    public void validate() throws ValidateException {
        mPresenter.validate();
    }

    @Override
    public void setName(String value) {
        edtName.setText(value);
    }

    @Override
    public void setValue(String value) {
        edtValue.setText(value);
    }
}
