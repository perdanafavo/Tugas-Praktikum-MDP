package com.androidtan.www.aplikasimodul2kel26.ui.detailCar;

import android.util.Log;
import com.androidtan.www.aplikasimodul2kel26.data.model.DataCar;
import com.androidtan.www.aplikasimodul2kel26.data.network.RetrofitClient;
import com.androidtan.www.aplikasimodul2kel26.ui.addcar.AddView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_UpdatePresenter {

    private DetailView detailView;

    public Detail_UpdatePresenter(DetailView detailView){
        this.detailView = detailView;
    }


    public void updatecar(){
        final String tag = "Add-addCar";
        String name = detailView.getName();
        String merk = detailView.getMerk();
        String model = detailView.getModel();
        String year = detailView.getYear();

        RetrofitClient.getInstance()
                .getApi()
                .putCar(name, merk, model, year)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if(response.isSuccessful()){
                            detailView.successUpdate();
                            Log.e(tag, response.body().toString());
                        } else {
                            detailView.failedUpdate();
                            Log.e(tag, response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        detailView.failedUpdate();
                        Log.e(tag, t.getMessage());
                    }
                });
    }
}
