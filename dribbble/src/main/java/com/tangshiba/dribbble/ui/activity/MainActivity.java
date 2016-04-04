package com.tangshiba.dribbble.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseActivicy;
import com.tangshiba.dribbble.ui.adapter.TabPageAdapter;
import com.tangshiba.dribbble.ui.fragment.DesignersFragment;
import com.tangshiba.dribbble.ui.fragment.JobsFragment;
import com.tangshiba.dribbble.ui.fragment.MeetupsFragment;
import com.tangshiba.dribbble.ui.fragment.ShopFragment;
import com.tangshiba.dribbble.ui.fragment.ShotsFragment;
import com.tangshiba.dribbble.ui.fragment.StoriesFragment;
import com.tangshiba.dribbble.ui.fragment.TeamsFragment;

import java.util.List;

public class MainActivity extends BaseActivicy
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPageAdapter mPageAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mPageAdapter = new TabPageAdapter(getSupportFragmentManager());
        mPageAdapter.addTab(ShotsFragment.newInstance(), getResources().getString(R.string.title_shots));
        mPageAdapter.addTab(DesignersFragment.newInstance(), getResources().getString(R.string.title_designers));
        mPageAdapter.addTab(TeamsFragment.newInstance(), getResources().getString(R.string.title_teams));
        mPageAdapter.addTab(StoriesFragment.newInstance(), getResources().getString(R.string.title_stories));
        mPageAdapter.addTab(MeetupsFragment.newInstance(), getResources().getString(R.string.title_meetups));
        mPageAdapter.addTab(ShopFragment.newInstance(), getResources().getString(R.string.title_shop));
        mPageAdapter.addTab(JobsFragment.newInstance(), getResources().getString(R.string.title_jobs));
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

}
