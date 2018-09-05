package study.rationalegoism.daggerstudy.component;

import dagger.Component;
import study.rationalegoism.daggerstudy.MainActivity;
import study.rationalegoism.daggerstudy.adapter.RandomUserAdapter;
import study.rationalegoism.daggerstudy.interfaces.MainActivityScope;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;
import study.rationalegoism.daggerstudy.module.MainActivityModule;

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

}
