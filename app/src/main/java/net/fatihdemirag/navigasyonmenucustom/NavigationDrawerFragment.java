package net.fatihdemirag.navigasyonmenucustom;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//fatih_demirağ-fxd

public class NavigationDrawerFragment extends Fragment {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        selectItem(mCurrentSelectedPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    ArrayList<String> basliklar;
    Map<String, ArrayList<String>> ogeler;

    private void VeriYukle() {
        basliklar.add("Menü 1");
        basliklar.add("Menü 2");
        basliklar.add("Menü 3");
        basliklar.add("Menü 4");
        basliklar.add("Menü 5");
        basliklar.add("Menü 6");


        ArrayList<String> menu1List = new ArrayList<>();
        menu1List.add("Alt Menü 1");
        menu1List.add("Alt Menü 2");
        menu1List.add("Alt Menü 3");
        menu1List.add("Alt Menü 4");

        ArrayList<String> menu2List = new ArrayList<>();
        menu2List.add("Alt Menü 5");
        menu2List.add("Alt Menü 6");
        menu2List.add("Alt Menü 7");


        ArrayList<String> menu3List = new ArrayList<>();
        menu3List.add("Alt Menü 8");
        menu3List.add("Alt Menü 9");
        menu3List.add("Alt Menü 10");

        ArrayList<String> menu4List = new ArrayList<>();
        menu4List.add("Alt Menü 11");
        menu4List.add("Alt Menü 12");

        ArrayList<String> menu5List = new ArrayList<>();
        menu5List.add("Alt Menü 13");
        menu5List.add("Alt Menü 14");
        menu5List.add("Alt Menü 15");
        menu5List.add("Alt Menü 16");

        ArrayList<String> menu6List = new ArrayList<>();
        menu6List.add("Alt Menü 17");


        ogeler.put(basliklar.get(0), menu1List);
        ogeler.put(basliklar.get(1), menu2List);
        ogeler.put(basliklar.get(2), menu3List);
        ogeler.put(basliklar.get(3), menu4List);
        ogeler.put(basliklar.get(4), menu5List);
        ogeler.put(basliklar.get(5), menu6List);

    }

    ExpandableListView expandableListView;
    ExpandedListViewAdapter exList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        expandableListView = (ExpandableListView) inflater.inflate(R.layout.drawer_menu, container, false);

        basliklar = new ArrayList<>();
        ogeler = new HashMap<>();

        exList = new ExpandedListViewAdapter(getActivity(), basliklar, ogeler);
        expandableListView.setAdapter(exList);

        final View rootView = inflater.inflate(R.layout.nav_anasayfa, container, false);

        expandableListView.addHeaderView(rootView);

        VeriYukle();


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int last = -1;

            @Override
            public void onGroupExpand(int i) {
                if (last != -1 && last != i) {
                    expandableListView.collapseGroup(last);
                }
                last = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                    }
                });

                TextView oge = view.findViewById(R.id.oge);
                String ogeSecilen = oge.getText().toString();

                switch (ogeSecilen) {
                    case "Alt Menü 1":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 2":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 3":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 4":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 5":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 6":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 7":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 8":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 9":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 10":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 11":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 12":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 13":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 15":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 16":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                    case "Alt Menü 17":
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                        expandableListView.expandGroup(0);
                        break;
                }
                expandableListView.collapseGroup(0);

                rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDrawerLayout.closeDrawer(mFragmentContainerView);
                    }
                });

                return false;
            }
        });

        return expandableListView;
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

                getActivity().invalidateOptionsMenu();
            }
        };

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (mDrawerLayout != null && isDrawerOpen()) {
            inflater.inflate(R.menu.global, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.action_settings) {
            {
                mDrawerLayout.closeDrawer(mFragmentContainerView);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setTitle("Navigasyon Menü");
        actionBar.setSubtitle("Özel Menü");
    }

    private ActionBar getActionBar() {
        return getActivity().getActionBar();
    }

    public static interface NavigationDrawerCallbacks {
        void onNavigationDrawerItemSelected(int position);
    }
}
