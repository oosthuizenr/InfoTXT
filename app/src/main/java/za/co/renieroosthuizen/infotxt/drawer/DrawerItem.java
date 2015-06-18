package za.co.renieroosthuizen.infotxt.drawer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import za.co.renieroosthuizen.infotxt.R;

/**
 * Created by Renier on 2015/06/18.
 */
public class DrawerItem {

    public enum DrawerItemType {
        SentInfoItems,
        InfoItemsList,
        Settings
    }

    private DrawerItemType type;
    private String title;
    private int drawableId;

    public DrawerItemType getType() {
        return type;
    }

    public void setType(DrawerItemType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public DrawerItem(DrawerItemType type, String title, int drawableId) {
        this.type = type;
        this.title = title;
        this.drawableId = drawableId;
    }

    /**
     * Use this method to get a list of all drawer items that need to go into the main navigation drawer
     *
     * @param context The application context
     * @return A list of drawer items
     */
    public static List<DrawerItem> getListOfNavigationDrawerItems(Context context)
    {
        List<DrawerItem> toReturn = new ArrayList<DrawerItem>();

        //Sent Info Items "Home"
        toReturn.add(new DrawerItem(DrawerItemType.SentInfoItems, context.getString(R.string.drawer_sent_info_txt), R.drawable.ic_assignment_returned_black_24dp));

        //Info Items List
        toReturn.add(new DrawerItem(DrawerItemType.InfoItemsList, context.getString(R.string.drawer_info_item_list), R.drawable.ic_assignment_black_24dp));

        //Settings
        toReturn.add(new DrawerItem(DrawerItemType.Settings, context.getString(R.string.drawer_settings), R.drawable.ic_settings_black_24dp));

        return toReturn;
    }
}
