package com.example.dan.mothertobe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dan.mothertobe.Fragment.MotherManualFragment;
import com.example.dan.mothertobe.Fragment.HotRecommendedFragment;
import com.example.dan.mothertobe.Fragment.HotThisMonthFragment;
import com.example.dan.mothertobe.Fragment.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;//定义viewPager

    private TabLayout tab_tabLayoutFragment_title;//定义TabLayout
    private FragmentPagerAdapter fragmentAdapter;//定义adapter

    private List<Fragment> list_fragment; //定义要装fragment的列表
    private List<String> list_title; //tab名称列表

    private MotherManualFragment homePageFragment;
    private HotRecommendedFragment hotRecommendedFragment;
    private HotThisMonthFragment hotThisMonthFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tab_tabLayoutFragment_title = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        initControls();
    }

    /**
     * 初始化各控件
     */
    private void initControls() {

        //初始化各fragment
        homePageFragment = new MotherManualFragment();
        hotRecommendedFragment = new HotRecommendedFragment();
        hotThisMonthFragment = new HotThisMonthFragment();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(homePageFragment);
        list_fragment.add(hotRecommendedFragment);
        list_fragment.add(hotThisMonthFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("宝妈手册");
        list_title.add("热门推荐");
        list_title.add("热门收藏");

        //设置TabLayout的模式
        tab_tabLayoutFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_tabLayoutFragment_title.addTab(tab_tabLayoutFragment_title.newTab().setText(list_title.get(0)));
        tab_tabLayoutFragment_title.addTab(tab_tabLayoutFragment_title.newTab().setText(list_title.get(1)));
        tab_tabLayoutFragment_title.addTab(tab_tabLayoutFragment_title.newTab().setText(list_title.get(2)));

        fragmentAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        viewPager.setAdapter(fragmentAdapter);
        //tab_FindFragment_title.setViewPager(viewPager);
        //TabLayout加载viewpager
        tab_tabLayoutFragment_title.setupWithViewPager(viewPager);
        //tab_FindFragment_title.set
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
