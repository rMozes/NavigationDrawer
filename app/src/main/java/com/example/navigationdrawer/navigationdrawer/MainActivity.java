package com.example.navigationdrawer.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mListView;
    private String[] mItems;
    private MyAdapter mAdapter;
    private MyDrawerToggle mDrawerToggle;
    private boolean isHomePressed;
    private String mTitle = "Drawe Pane";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(mTitle);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.content_frame);

        if(fragment == null) {
            fragment = DrawPaneFragment.newInstance();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.content_frame, fragment);
            transaction.commit();
        }

        mItems = getResources().getStringArray(R.array.list_names);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerToggle = new MyDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_opened,
                0);
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        mListView = (ListView) findViewById(R.id.left_drawer);

        mAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1, mItems);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new MyListListener(fragmentManager));

    }

    public class MyAdapter extends ArrayAdapter<String> {

        Context context;

        public MyAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);

            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custom_list_item, parent, false);
            }
            TextView view = (TextView) convertView.findViewById(R.id.list_item_name);
            String title = getItem(position);
            view.setText(title);
            return convertView;
        }
    }

    public class MyListListener implements AdapterView.OnItemClickListener {

        private FragmentManager fm;

        public MyListListener(FragmentManager fragmentManager) {
            fm = fragmentManager;
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           switch (i) {
               case 0:
                   Fragment fragment = DrawPaneFragment.newInstance();
                   replaceFragment(fragment, i);
                   break;
               case 1:
                   Fragment fragment1 = MultiTouchFragment.newInstance();
                   replaceFragment(fragment1, i);
                   break;
               case 2:
                   Fragment fragment2 = ToastMessageFragment.newInstance();
                   replaceFragment(fragment2, i);
           }
        }

        private void replaceFragment(Fragment fragment, int position) {
            fm.beginTransaction()
                     .replace(R.id.content_frame, fragment)
                     .commit();

            mTitle = mItems[position];
            MainActivity.this.setTitle(mTitle);
            mDrawerLayout.closeDrawer(mListView);
            isHomePressed = false;

        }

    }

    public class MyDrawerToggle extends ActionBarDrawerToggle {

       Activity activity;

        public MyDrawerToggle(Activity activity, DrawerLayout drawerLayout
                , int drawerImageRes, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);

            this.activity = activity;
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            activity.setTitle(R.string.drawer_opened);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            activity.setTitle(mTitle);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if(isHomePressed) {
                mDrawerLayout.closeDrawer(mListView);
                isHomePressed = false;
                return true;
            } else {
                mDrawerLayout.openDrawer(mListView);
                isHomePressed = true;
                return true;
            }
        }
        setTitle(mTitle);
        return super.onOptionsItemSelected(item);
    }
}
