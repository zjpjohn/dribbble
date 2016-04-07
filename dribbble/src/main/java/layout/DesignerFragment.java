package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangshiba.dribbble.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DesignerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DesignerFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DesignerFragment extends Fragment {

    public static DesignerFragment newInstance() {
        DesignerFragment fragment = new DesignerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public DesignerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_designers, container, false);
    }

}
