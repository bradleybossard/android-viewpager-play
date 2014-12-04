package com.bradleybossard.viewpagerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

//import android.media.AudioAttributes.Builder;

//import android.media.SoundPool.Builder;


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
    private static final String TAG = "ScreenSlidePageFragment";

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


    // Set different text and background color for each page
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);


        // Get a list of ids in the raw folder.
        // TODO(bradleybossard) : Move logic that gets the list of raw resources in an object.
        ArrayList<Integer> list = new ArrayList<Integer>();
        Field[] fields = R.raw.class.getFields();

        int numItemsPerPage = 10;
        int numItemsPerRow = 3;
        int minIndex = mPageNum *  numItemsPerPage;
        if (minIndex > fields.length) {
            return rootView;
        }

        int maxIndex = (mPageNum + 1) * numItemsPerPage > fields.length ? fields.length : (mPageNum + 1) * numItemsPerPage;

        String pageTitleText = "Sounds " + minIndex + " - " + (maxIndex - 1);
        int colorText = 0xFFFFFFFF;

/*
        //TODO(bbossard) : Here is where you might do some customization for each page.
        if (mPageNum == 0) {
            pageTitleText = "Farm Sounds";
            colorText = 0xFFFF0000;
        } else if (mPageNum == 1) {
            pageTitleText = "War Sounds";
            colorText = 0xFF00FF00;
        }
*/

        ((TextView) rootView.findViewById(R.id.page_title_text)).setText(pageTitleText);
        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.content);
        scrollView.setBackgroundColor(colorText);

        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.button_container);
        layout.setOrientation(LinearLayout.VERTICAL);  //Can also be done in xml by android:orientation="vertical"

        int soundIndex = numItemsPerPage * mPageNum;
        int numRows = (int)Math.ceil((double)numItemsPerPage / (double)numItemsPerRow);
        for (int rowCount = 0; rowCount < numRows; rowCount++) {
            LinearLayout row = new LinearLayout(layout.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            row.setLayoutParams(layoutParams);

           for (int column = 0; column < numItemsPerRow; column++) {
                try {
                    String soundName = fields[soundIndex].getName();
                    final int resourceId = fields[soundIndex].getInt(null);

                    final Button btnTag = new Button(layout.getContext());
                    btnTag.setText(soundName);

                    LayoutParams buttonParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                    buttonParams.setMargins(10, 10, 10, 10);
                    btnTag.setLayoutParams(buttonParams);
                    btnTag.setBackgroundColor(0xFFFFFFFF);
                    btnTag.setBackgroundResource(R.drawable.button_style);
                    row.addView(btnTag);

                    btnTag.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v) {
                            Intent playSound = new Intent(getActivity(), SoundPlayerService.class);
                            playSound.putExtra("soundid", resourceId);
                            getActivity().startService(playSound);
                        }
                    });
                    soundIndex++;
                    if (soundIndex >= maxIndex) {
                        break;
                    }

                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }

            layout.addView(row);
        }
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
