package study.rationalegoism.daggerstudy.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;
import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import study.rationalegoism.daggerstudy.interfaces.ApplicationContext;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApplicationScope;

@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @RandomUserApplicationScope
    @Provides
    public Picasso picasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

}
