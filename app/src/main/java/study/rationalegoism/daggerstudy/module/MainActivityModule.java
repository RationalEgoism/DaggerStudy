package study.rationalegoism.daggerstudy.module;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import study.rationalegoism.daggerstudy.MainActivity;
import study.rationalegoism.daggerstudy.adapter.RandomUserAdapter;
import study.rationalegoism.daggerstudy.interfaces.MainActivityScope;

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RandomUserAdapter randomUserAdapter(Picasso picasso){
        return new RandomUserAdapter(mainActivity, picasso);
    }
}
