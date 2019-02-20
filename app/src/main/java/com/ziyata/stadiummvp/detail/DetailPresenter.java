package com.ziyata.stadiummvp.detail;

import android.os.Bundle;

import com.ziyata.stadiummvp.model.StadiumData;
import com.ziyata.stadiummvp.model.StadiumResponse;
import com.ziyata.stadiummvp.network.ApiClient;
import com.ziyata.stadiummvp.network.ApiInterface;
import com.ziyata.stadiummvp.utils.Constant;
import com.ziyata.stadiummvp.view.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.View view;
    private ApiInterface apiInterface = ApiClient.getCliend().create(ApiInterface.class);
    private int id;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataStadium(Bundle bundle) {
        if (bundle != null){
            id = Integer.valueOf(bundle.getString(Constant.id));

            view.showProgress();
            Call<StadiumResponse> call = apiInterface.getStadiumResponse(id);
            call.enqueue(new Callback<StadiumResponse>() {
                @Override
                public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                    view.hideProgress();
                    if (response.body() != null){
                        StadiumResponse stadiumResponse = response.body();

                        if (stadiumResponse.getTeams() != null){
                            view.showDataStadium(stadiumResponse.getTeams());
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
}
