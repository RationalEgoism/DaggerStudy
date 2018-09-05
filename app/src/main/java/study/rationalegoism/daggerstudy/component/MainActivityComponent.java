package study.rationalegoism.daggerstudy.component;

import dagger.Component;
import study.rationalegoism.daggerstudy.adapter.RandomUserAdapter;
import study.rationalegoism.daggerstudy.interfaces.MainActivityScope;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;

@MainActivityScope
@Component(dependencies = RandomUserComponent.class)
public interface MainActivityComponent {
    RandomUserAdapter getRandomUserAdapter();
    RandomUserApi getRandomUserApi();

}
