package study.rationalegoism.daggerstudy.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import study.rationalegoism.daggerstudy.model.RandomUsers;

public interface RandomUserApi {

    @GET("api")
    Call<RandomUsers> gerRandomUsers(@Query("results") int size);
}
