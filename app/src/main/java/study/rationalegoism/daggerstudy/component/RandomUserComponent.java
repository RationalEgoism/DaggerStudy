package study.rationalegoism.daggerstudy.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;

@Component
public interface RandomUserComponent {
    RandomUserApi getRandomUserApi();
    Picasso getPicasso();
}
