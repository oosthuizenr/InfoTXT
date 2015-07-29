package za.co.renieroosthuizen.infotxt;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import za.co.renieroosthuizen.infotxt.drawer.DrawerItem;
import za.co.renieroosthuizen.infotxt.drawer.NavigationDrawerFragment;
import za.co.renieroosthuizen.infotxt.infoitems.InfoItemsFragment;
import za.co.renieroosthuizen.infotxt.infoitems.InfoItemsFragment.OnInfoItemsFragmentInteractionListener;
import za.co.renieroosthuizen.infotxt.infoitems.manage.view.ManageInfoItemFragment;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;
import za.co.renieroosthuizen.infotxt.sentinfotxt.SentInfoTXTFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment
        .NavigationDrawerCallbacks, OnInfoItemsFragmentInteractionListener{

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is so that we can use application context to inflate view with the apptheme later
        getApplicationContext().setTheme(R.style.AppTheme);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set a toolbar which will replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        // Load InfoItems fragment when the app starts
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new SentInfoTXTFragment())
                .commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mNavigationDrawerFragment.getDrawerToggle().syncState();
    }

    @Override
    public void onNavigationDrawerItemSelected(DrawerItem drawerItem) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (drawerItem.getType()) {
            case InfoItemsList:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new InfoItemsFragment())
                        .addToBackStack("InfoItemsList")
                        .commit();
                break;

            case SentInfoItems:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SentInfoTXTFragment())
                        .addToBackStack("SentInfoItems")
                        .commit();
                break;

            case Settings:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SettingsFragment())
                        .addToBackStack("Settings")
                        .commit();
                break;
        }

    }

    @Override
    public void newInfoItemTapped() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.container, new ManageInfoItemFragment())
                .addToBackStack("NewInfoItem")
                .commit();
    }

    @Override
    public void manageExistingInfoItem(InfoItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        ManageInfoItemFragment frag = new ManageInfoItemFragment();
        frag.setInfoItem(item);

        fragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .addToBackStack("ManageExistingInfoItem")
                .commit();
    }
}
