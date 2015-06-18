package za.co.renieroosthuizen.infotxt;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import za.co.renieroosthuizen.infotxt.drawer.DrawerItem;
import za.co.renieroosthuizen.infotxt.drawer.NavigationDrawerFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment
        .NavigationDrawerCallbacks{

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        .commit();
                break;

            case SentInfoItems:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SentInfoTXTFragment())
                        .commit();
                break;

            case Settings:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SettingsFragment())
                        .commit();
                break;
        }

    }
}
