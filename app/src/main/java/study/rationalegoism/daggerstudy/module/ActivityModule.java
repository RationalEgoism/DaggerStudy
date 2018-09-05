package study.rationalegoism.daggerstudy.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApplicationScope;

@Module
public class ActivityModule {
    Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @RandomUserApplicationScope
    @Provides
    public Context context(){
        return this.context;
    }
}
