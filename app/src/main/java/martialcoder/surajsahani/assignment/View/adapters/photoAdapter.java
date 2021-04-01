package martialcoder.surajsahani.assignment.View.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import martialcoder.surajsahani.assignment.Model.DataModels.Photo;
import martialcoder.surajsahani.assignment.R;

public class photoAdapter extends RecyclerView.Adapter<photoAdapter.ViewHolder> {

    private List<Photo> mData;
    private final LayoutInflater mInflater;


    public photoAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(mData!=null)
        {
            Photo p = mData.get(position);
            Picasso.get()
                    .load(p.getUrl())
                    .into(holder.url_photo);
            holder.title.setText(p.getTitle());
            holder.id.setText(String.valueOf(p.getId()));
        }
    }

    @Override
    public int getItemCount() {
        if(mData!=null)
            return mData.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView url_photo;
        TextView title;
        TextView id;
        ViewHolder(View itemView) {
            super(itemView);
            url_photo = itemView.findViewById(R.id.url_photo);
            title = itemView.findViewById(R.id.title_photo);
            id = itemView.findViewById(R.id.id_photo);
        }
    }

    public void setData(List<Photo> list)
    {
        this.mData = list;
        notifyDataSetChanged();
    }
}
