package sg.edu.rp.c346.id19028654.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter{

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movie;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movie = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewMoviwName);
        TextView tvYearF = rowView.findViewById(R.id.textViewYearF);


        // Obtain the Android Version information based on the position
        Movie currentItem = movie.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentItem.getTitle());
        tvYearF.setText( currentItem.getYear()+" " +currentItem.getGenre());

        ImageView ivMovie=rowView.findViewById(R.id.imageView);


        if(currentItem.getRated() == "pg13" ){
            ivMovie.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRated() == "g"){
            ivMovie.setImageResource((R.drawable.rating_g));
        }
        else if(currentItem.getRated() == "nc16"){
            ivMovie.setImageResource((R.drawable.rating_nc16));
        }
        else if(currentItem.getRated() == "m18"){
            ivMovie.setImageResource((R.drawable.rating_m18));
        }
        else if(currentItem.getRated() == "r21"){
            ivMovie.setImageResource((R.drawable.rating_r21));
        }
        else if(currentItem.getRated() == "pg"){
            ivMovie.setImageResource((R.drawable.rating_pg));
        }
        else {
            ivMovie.setImageResource(R.drawable.ic_launcher_foreground);
        }
        return rowView;

    }
}

