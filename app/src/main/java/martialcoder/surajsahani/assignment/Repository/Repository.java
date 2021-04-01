package martialcoder.surajsahani.assignment.Repository;

import android.util.Log;


import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import martialcoder.surajsahani.assignment.Model.DataModels.Album;
import martialcoder.surajsahani.assignment.Model.DataModels.Photo;
import martialcoder.surajsahani.assignment.Model.api.KreditBeeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {
    private static final String TAG = "Repository";
    private final KreditBeeAPI api;

    private final MutableLiveData<List<Album>> albumListLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Photo>> photoListLiveData = new MutableLiveData<>();

    @Inject
    public Repository(KreditBeeAPI api) {
        this.api = api;
    }
    public LiveData<List<Album>> getAlbums() {
        api.getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call, @NonNull Response<List<Album>> response) {
                albumListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: failed to fetch album list from server");
            }
        });
        return albumListLiveData;
    }

    public LiveData<List<Photo>> getPhotos(int id) {
        api.getPhotos(id).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull Response<List<Photo>> response) {
                photoListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: failed to get photo list");
            }
        });
        return photoListLiveData;
    }
}
