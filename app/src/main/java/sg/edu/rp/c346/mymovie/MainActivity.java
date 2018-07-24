package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView lvMovieList;
    ArrayList<MovieList> alMovieList;
    CustomAdapter caMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovieList=findViewById(R.id.listViewmovie);

        //Create data object
        alMovieList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,10,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,4,15);

        MovieList item1= new MovieList("The Avengers",
                "2012", "pg13", "Action | Sci-Fi", date1, "Golden Village - Bishan", "Nick fury of S.H.I.E.L.D assembles a team of superheroes to save the planet from Loki and his army." , true);

        MovieList item2= new MovieList("Planes",
                "2013", "pg", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", false);

        alMovieList.add(item1);
        alMovieList.add(item2);

        //binding CA to AL
        caMovieList= new CustomAdapter(this,R.layout.moviedetail,alMovieList);

        //binding LV to CA
        lvMovieList.setAdapter(caMovieList);

//        lvMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Intent intent = new Intent(getBaseContext(), moviedetail.class);
//                 MovieList currentMovie = alMovieList.get(position);
//
//                intent.putExtra("title", currentMovie.getName());
//                intent.putExtra("year", currentMovie.getYear());
//                intent.putExtra("rated", currentMovie.getRating());
//                intent.putExtra("genre", currentMovie.getGenre());
//                intent.putExtra("watchDate", currentMovie.getDate());
//                intent.putExtra("theatre", currentMovie.getTheatre());
//                intent.putExtra("desc", currentMovie.getDes());
//
//                startActivity(intent);
//            }
//        });

        lvMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               String colour = alColours.get(i);
//                Toast.makeText(MainActivity.this,colour , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), moviedetail.class);
                startActivity(intent);
            }
        });

//            lvMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Toast.makeText(MainActivity.this, "asdsad", Toast.LENGTH_LONG).show();
//                }
//            });

    }
}

