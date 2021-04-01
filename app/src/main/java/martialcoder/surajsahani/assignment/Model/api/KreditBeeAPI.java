package martialcoder.surajsahani.assignment.Model.api;

import java.util.List;

import martialcoder.surajsahani.assignment.Model.DataModels.Album;
import martialcoder.surajsahani.assignment.Model.DataModels.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KreditBeeAPI {
    @GET("albums")
    Call<List<Album>> getAlbums();
    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("album")int id);
}
