package za.co.renieroosthuizen.infotxt;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A {@link Fragment} subclass that lists all the InfoItems that the user has set up.
 * Use the {@link InfoItemsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoItemsFragment extends Fragment {
    /**
     * Creates a new instance of the InfoItemsFragment
     *
     * @return A new instance of fragment InfoItemsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoItemsFragment newInstance() {
        InfoItemsFragment fragment = new InfoItemsFragment();
        return fragment;
    }

    public InfoItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_items, container, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
