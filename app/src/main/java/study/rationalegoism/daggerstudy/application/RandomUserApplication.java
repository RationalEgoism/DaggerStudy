package study.rationalegoism.daggerstudy.application;

import android.app.Activity;
import android.app.Application;

import study.rationalegoism.daggerstudy.component.DaggerRandomUserComponent;
import study.rationalegoism.daggerstudy.component.RandomUserComponent;
import study.rationalegoism.daggerstudy.module.ContextModule;
import timber.log.Timber;

public class RandomUserApplication extends Application{
    private RandomUserComponent randomUserApplicationComponent;

    public static RandomUserApplication get(Activity activity){
        return (RandomUserApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        randomUserApplicationComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public RandomUserComponent getRandomUserApplicationComponent() {
        return randomUserApplicationComponent;
    }
}
