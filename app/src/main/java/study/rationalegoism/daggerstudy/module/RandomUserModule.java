package study.rationalegoism.daggerstudy.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;

@Module(includes = OkHttpClientModule.class)
public class RandomUserModule {

    @Provides
    public RandomUserApi randomUserApi(Retrofit retrofit){
        return retrofit.create(RandomUserApi.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public Gson gson(){
        return new GsonBuilder().create();
    }
}
