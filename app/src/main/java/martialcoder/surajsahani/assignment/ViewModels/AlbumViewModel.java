package martialcoder.surajsahani.assignment.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import martialcoder.surajsahani.assignment.Model.DataModels.Album;
import martialcoder.surajsahani.assignment.Repository.Repository;

@HiltViewModel
public class AlbumViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private final LiveData<List<Album>> albumsLiveData;

    @Inject
    public AlbumViewModel(Repository repository) {
        super();
        albumsLiveData = repository.getAlbums();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Album>> getAlbumsLiveData() {
        return albumsLiveData;
    }
}
