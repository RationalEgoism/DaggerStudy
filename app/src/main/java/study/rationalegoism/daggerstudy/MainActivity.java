package study.rationalegoism.daggerstudy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import study.rationalegoism.daggerstudy.adapter.RandomUserAdapter;
import study.rationalegoism.daggerstudy.application.RandomUserApplication;
import study.rationalegoism.daggerstudy.component.DaggerMainActivityComponent;
import study.rationalegoism.daggerstudy.component.MainActivityComponent;
import study.rationalegoism.daggerstudy.interfaces.RandomUserApi;
import study.rationalegoism.daggerstudy.model.RandomUsers;
import study.rationalegoism.daggerstudy.module.MainActivityModule;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Inject
    RandomUserApi randomUserApi;

    @Inject
    RandomUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        afterActivityLevelComponent();
        populateUsers();

    }

    private void afterActivityLevelComponent() {
        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUserComponent(RandomUserApplication.get(this).getRandomUserApplicationComponent())
                .build();
        component.injectMainActivity(this);
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = randomUserApi.gerRandomUsers(10);
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
                if(response.isSuccessful()) {
                    mAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
