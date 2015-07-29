package za.co.renieroosthuizen.infotxt.sentinfotxt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import za.co.renieroosthuizen.infotxt.R;


/**
 * A {@link Fragment} subclass that lists all sent InfoTXT messages.
 * Use the {@link SentInfoTXTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SentInfoTXTFragment extends Fragment {

    private FloatingActionMenu mActionMenu;

    /**
     * Creates a new instance of the SentInfoTXTFragment
     *
     * @return A new instance of fragment SentInfoTXTFragment.
     */
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
        View v = inflater.inflate(R.layout.fragment_sent_info_txt, container, false);

        mActionMenu = (FloatingActionMenu) v.findViewById(R.id.famSend);

        v.findViewById(R.id.fabManual).setOnClickListener(fabClickListener);
        v.findViewById(R.id.fabContact).setOnClickListener(fabClickListener);
        v.findViewById(R.id.fabCallLog).setOnClickListener(fabClickListener);

        return v;
    }


    private View.OnClickListener fabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.fabManual:
                    Toast.makeText(getActivity(), "Manual tapped", Toast.LENGTH_LONG).show();
                    break;

                case R.id.fabContact:
                    Toast.makeText(getActivity(), "Contact tapped", Toast.LENGTH_LONG).show();
                    break;

                case R.id.fabCallLog:
                    Toast.makeText(getActivity(), "Call Log tapped", Toast.LENGTH_LONG).show();
                    break;
            }

            mActionMenu.close(true);
        }
    };


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
