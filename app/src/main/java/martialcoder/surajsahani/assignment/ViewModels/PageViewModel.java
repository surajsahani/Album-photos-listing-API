package martialcoder.surajsahani.assignment.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import martialcoder.surajsahani.assignment.Model.DataModels.Photo;
import martialcoder.surajsahani.assignment.Repository.Repository;

@HiltViewModel
public class PageViewModel extends ViewModel {

    private LiveData<List<Photo>> photosLiveData;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final Repository repository;

    @Inject
    public PageViewModel(Repository repository) {
        super();
        this.repository = repository;
        isLoading.setValue(true);
    }
    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setAlbumId(int id) {
        photosLiveData = repository.getPhotos(id);
    }

    public LiveData<List<Photo>> getPhotosLiveData() {
        return photosLiveData;
    }
}