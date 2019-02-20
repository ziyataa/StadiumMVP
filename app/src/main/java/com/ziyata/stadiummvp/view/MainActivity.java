package com.ziyata.stadiummvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ziyata.stadiummvp.R;
import com.ziyata.stadiummvp.adapter.MainAdapter;
import com.ziyata.stadiummvp.main.MainContract;
import com.ziyata.stadiummvp.main.MainPresenter;
import com.ziyata.stadiummvp.model.StadiumData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.rv_teams)
    RecyclerView rvTeams;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private ProgressDialog progressDialog;
    private final MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter.getDataListUser();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.getDataListUser();
            }
        });
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.show();

    }

    @Override
    public void hideProgress() {
        swipeRefresh.setRefreshing(false);
        progressDialog.dismiss();
    }

    @Override
    public void showDataListUser(List<StadiumData> stadiumDataList) {
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        rvTeams.setAdapter(new MainAdapter(this, stadiumDataList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
