package com.ziyata.stadiummvp.main;

import com.ziyata.stadiummvp.model.StadiumResponse;
import com.ziyata.stadiummvp.network.ApiClient;
import com.ziyata.stadiummvp.network.ApiInterface;
import com.ziyata.stadiummvp.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getCliend().create(ApiInterface.class);

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


    @Override
    public void getDataListUser() {
        view.showProgress();
        Call<StadiumResponse> call = apiInterface.getStadiumResponse(Constant.l);
        call.enqueue(new Callback<StadiumResponse>() {
            @Override
            public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                view.hideProgress();
                if (response.body() != null){
                    StadiumResponse stadiumResponse = response.body();

                    if (stadiumResponse.getTeams() != null){
                        view.showDataListUser(stadiumResponse.getTeams());
                    }
                }
            }

            @Override
            public void onFailure(Call<StadiumResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getMessage());
            }
        });
    }
}
