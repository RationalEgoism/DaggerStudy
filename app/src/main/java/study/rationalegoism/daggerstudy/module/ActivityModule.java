package study.rationalegoism.daggerstudy.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import study.rationalegoism.daggerstudy.interfaces.ApplicationContext;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApplicationScope;

@Module
public class ActivityModule {
    Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    public Context context(){
        return this.context;
    }
}
