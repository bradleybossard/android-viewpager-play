package com.bradleybossard.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScreenSlidePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScreenSlidePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ScreenSlidePageFragment extends Fragment {
    private static final String ARG_PAGENUM = "arg_pagenum";

    private int mPageNum;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pageNum Parameter 1.
     * @return A new instance of fragment ScreenSlidePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScreenSlidePageFragment newInstance(int pageNum) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGENUM, pageNum);
        fragment.setArguments(args);
        return fragment;
    }

/*
    public static ScreenSlidePageFragment newInstance2() {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        return fragment;
    }
*/

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPageNum = getArguments().getInt(ARG_PAGENUM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        String ipsumText = "";
        int colorText = 0xFF000000;

        if (mPageNum == 0) {
            ipsumText = getText(R.string.lorem_ipsum1).toString();
            colorText = 0xFFFF0000;
        } else if (mPageNum == 1) {
            ipsumText = getText(R.string.lorem_ipsum2).toString();
            colorText = 0xFF00FF00;
        } else if (mPageNum == 2) {
            ipsumText = getText(R.string.lorem_ipsum3).toString();
            colorText = 0xFF0000FF;
        }

        ((TextView) rootView.findViewById(R.id.ipsum_text)).setText(ipsumText);
        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.content);
        scrollView.setBackgroundColor(colorText);
        return rootView;
    }

/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
/*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
*/

}
