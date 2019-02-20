package com.ziyata.stadiummvp.main;

import com.ziyata.stadiummvp.model.StadiumData;

import java.util.List;

public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataListUser(List<StadiumData> stadiumDataList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListUser();
    }
}
