package martialcoder.surajsahani.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import martialcoder.surajsahani.assignment.Model.DataModels.Album;
import martialcoder.surajsahani.assignment.View.adapters.SectionsPagerAdapter;
import martialcoder.surajsahani.assignment.ViewModels.AlbumViewModel;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private List<Album> Albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlbumViewModel albumViewModel = new ViewModelProvider(this).get(AlbumViewModel.class);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), Albums);

        albumViewModel.getAlbumsLiveData().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumList) {
                Albums = albumList;
                sectionsPagerAdapter.setData(albumList);
            }
        });
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}