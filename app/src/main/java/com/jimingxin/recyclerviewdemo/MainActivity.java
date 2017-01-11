package com.jimingxin.recyclerviewdemo;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView cv;
    MyNewsDataAdapter adapter;
    SwipeRefreshLayout swip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = (RecyclerView) findViewById(R.id.rv);
        swip = (SwipeRefreshLayout) findViewById(R.id.swip);

        swip.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW);
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swip.setRefreshing(false);
                Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
            }
        });
        adapter = new MyNewsDataAdapter(MainActivity.this);

        adapter.setOnClickListener(new MyNewsDataAdapter.OnRecyclerViewItemClickLisetener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + "位置" + "被点击了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + "位置" + "被长时间点击了", Toast.LENGTH_SHORT).show();
            }
        });

        cv.setLayoutManager(new LinearLayoutManager(
                MainActivity.this,//上下文
                LinearLayoutManager.VERTICAL,//设置布局方向
                false//是否翻转
        ));
        //设置适配器
        cv.setAdapter(adapter);

        /*
        * //2. GridView
    rv.setLayoutManager(new GridLayoutManager(
            MainActivity.this,                //上下文
            3,                                //列或者行的数量
            LinearLayoutManager.VERTICAL,    //布局方向
            false                            //是否翻转
    ));
    //3. 瀑布流
    rv.setLayoutManager(new StaggeredGridLayoutManager(
            3,                                //如果方向垂直则代表列，否则代表行
            StaggeredGridLayoutManager.VERTICAL//布局方向
    ));
        * */
    }
}
