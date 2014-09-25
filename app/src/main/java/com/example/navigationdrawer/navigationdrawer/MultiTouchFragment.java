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
public class MultiTouchFragment extends Fragment {

    public static MultiTouchFragment newInstance() {
        Bundle bundle = new Bundle();

        MultiTouchFragment touch = new MultiTouchFragment();
        touch.setArguments(bundle);

        return touch;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new CustomView(getActivity());
    }
}
