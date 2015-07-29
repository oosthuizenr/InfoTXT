package za.co.renieroosthuizen.infotxt.infoitems;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import za.co.renieroosthuizen.infotxt.R;
import za.co.renieroosthuizen.infotxt.infoitems.model.InfoItem;


/**
 * A {@link Fragment} subclass that lists all the InfoItems that the user has set up.
 * Use the {@link InfoItemsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *  * Activities that contain this fragment must implement the
 * {@link InfoItemsFragment.OnInfoItemsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class InfoItemsFragment extends Fragment {

    private OnInfoItemsFragmentInteractionListener mListener;
    private ListView lstItems;


    /**
     * Creates a new instance of the InfoItemsFragment
     *
     * @return A new instance of fragment InfoItemsFragment.
     */
    public static InfoItemsFragment newInstance() {
        InfoItemsFragment fragment = new InfoItemsFragment();
        return fragment;
    }

    public InfoItemsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_items, container, false);

        lstItems = (ListView) v.findViewById(R.id.lstItems);
        v.findViewById(R.id.fabNew).setOnClickListener(fabClickListener);

        return v;
    }

    private View.OnClickListener fabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mListener != null)
            {
                mListener.newInfoItemTapped();
            }
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnInfoItemsFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnInfoItemsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnInfoItemsFragmentInteractionListener {
        /**
         * Lets the implementing activity know that the user wishes to create a new InfoItem
         */
        void newInfoItemTapped();

        /**
         * Lets the implementing activity know that the user wishes to modify an existing InfoItem
         */
        void manageExistingInfoItem(InfoItem item);

    }

}
