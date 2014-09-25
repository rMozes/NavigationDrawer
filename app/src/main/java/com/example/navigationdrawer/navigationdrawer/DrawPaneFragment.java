package com.example.navigationdrawer.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RICHI on 2014.09.22..
 */
public class DrawPaneFragment extends Fragment {

    private static final String TAG = "DrawPaneFragment";

    public static DrawPaneFragment newInstance() {
        Bundle arg = new Bundle();

        DrawPaneFragment fragment = new DrawPaneFragment();
        fragment.setArguments(arg);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = new DrawView(getActivity());

        return view;
    }
}
