package martialcoder.surajsahani.assignment.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import martialcoder.surajsahani.assignment.Model.api.KreditBeeAPI;
import martialcoder.surajsahani.assignment.Repository.Repository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
final class AppModule {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Singleton
    @Provides
    static KreditBeeAPI provideKreditBeeApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(KreditBeeAPI.class);
    }

    @Singleton
    @Provides
    static Repository provideRepository(KreditBeeAPI api) {
        return new Repository(api);
    }

}
