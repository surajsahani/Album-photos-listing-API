package martialcoder.surajsahani.assignment.View.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import martialcoder.surajsahani.assignment.Model.DataModels.Album;
import martialcoder.surajsahani.assignment.View.main.PlaceholderFragment;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private List<Album> albums;
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, List<Album> list) {
        super(fm);
        mContext = context;
        albums = list;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(albums!=null)
            return PlaceholderFragment.newInstance(albums.get(position).getId());
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(albums!=null)
            return albums.get(position).getTitle();
        return null;
    }


    @Override
    public int getCount() {
        // Show total pages.
        if(albums!=null)
            return albums.size();
        return 0;
    }

    public void setData(List<Album> list) {
        albums = list;
        notifyDataSetChanged();
    }
}