package za.co.renieroosthuizen.infotxt;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A {@link Fragment} subclass that lists all sent InfoTXT messages.
 * Use the {@link SentInfoTXTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SentInfoTXTFragment extends Fragment {

    /**
     * Creates a new instance of the SentInfoTXTFragment
     *
     * @return A new instance of fragment SentInfoTXTFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SentInfoTXTFragment newInstance() {
        SentInfoTXTFragment fragment = new SentInfoTXTFragment();
        return fragment;
    }

    public SentInfoTXTFragment() {
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
        return inflater.inflate(R.layout.fragment_sent_info_txt, container, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
