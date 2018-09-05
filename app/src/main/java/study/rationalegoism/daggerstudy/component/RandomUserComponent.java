package study.rationalegoism.daggerstudy.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApplicationScope;
import study.rationalegoism.daggerstudy.module.PicassoModule;
import study.rationalegoism.daggerstudy.module.RandomUserModule;

@RandomUserApplicationScope
@Component(modules = {RandomUserModule.class, PicassoModule.class})
public interface RandomUserComponent {
    RandomUserApi getRandomUserApi();
    Picasso getPicasso();
}
