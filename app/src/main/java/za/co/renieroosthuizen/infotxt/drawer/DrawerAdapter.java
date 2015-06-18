package za.co.renieroosthuizen.infotxt.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import za.co.renieroosthuizen.infotxt.R;

/**
 * Created by Renier on 2015/06/17.
 */
public class DrawerAdapter extends BaseAdapter {
    /**
     * LayoutInflater instance for inflating the requested layout in the list view
     */
    private LayoutInflater mInflater;

    private List<DrawerItem> mDataSet;

    /**
     * Default constructor
     */
    public DrawerAdapter(Context context, List<DrawerItem> dataSet) {

        mInflater = LayoutInflater.from(context);
        mDataSet = dataSet;

    }

    public int getCount() {
        return mDataSet.size();
    }

    public Object getItem(int index) {
        return mDataSet.get(index);
    }

    public long getItemId(int index) {
        return index;
    }

    public View getView(int position, View recycledView, ViewGroup parent) {
        ViewHolder holder;

        if (recycledView == null) {

            holder = new ViewHolder();
            recycledView = mInflater.inflate(R.layout.item_drawer, parent, false);
            holder.title = (TextView) recycledView.findViewById(R.id.title);
            holder.icon = (ImageView) recycledView.findViewById(R.id.icon);

            recycledView.setTag(holder);

        } else {
            holder = (ViewHolder) recycledView.getTag();
        }

        DrawerItem item = mDataSet.get(position);

        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getDrawableId());

        return recycledView;
    }

    private static class ViewHolder {
        TextView title;
        ImageView icon;
    }
}
