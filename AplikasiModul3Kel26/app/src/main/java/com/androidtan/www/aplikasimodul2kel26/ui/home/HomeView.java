package com.androidtan.www.aplikasimodul2kel26.ui.home;

import com.androidtan.www.aplikasimodul2kel26.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);
}
