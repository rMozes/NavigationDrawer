package com.example.navigationdrawer.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by RICHI on 2014.09.23..
 */
public class ToastMessageFragment extends Fragment {

    public static ToastMessageFragment newInstance() {
        Bundle args = new Bundle();

        ToastMessageFragment fragment = new ToastMessageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private void makeToast(String message) {
        Toast
                .makeText(getActivity(), message, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        makeToast("onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeToast("onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        makeToast("onActivityCreated");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        makeToast("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        makeToast("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        makeToast("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        makeToast("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        makeToast("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        makeToast("onDetach");
    }
}


