package com.ziyata.stadiummvp.detail;

import android.os.Bundle;

import com.ziyata.stadiummvp.model.StadiumData;

import java.util.List;

public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataStadium(List<StadiumData> stadiumData);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataStadium(Bundle bundle);
    }
}
