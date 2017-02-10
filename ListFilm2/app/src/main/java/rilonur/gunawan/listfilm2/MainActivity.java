package rilonur.gunawan.listfilm2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private  String [] filmTitles = {"The Thor","Harry Potter","Titanic","Captain America"
            //,"X-Men Apocalypse","Shutter Island"};

    ArrayAdapter<Movie> adapter;
    ListView listView;

    private ArrayList<Movie> movies = new ArrayList<>();

    private void initMovies(){
        movies.add(new Movie("The Thor","Film Tentang superhero Thor yang turun ke semarang",7.5,2009));
        movies.add(new Movie("Harry Potter","Film Tentang Sekolah sihir",7.5,2010));
        movies.add(new Movie("Titanic","Film Tentang Kapal yang Tenggelam",8.5,2005));
        movies.add(new Movie("Captain America","Film Tentang Superhero dari pasukan Tentara Amerika",8,2012));
        movies.add(new Movie("X-Men Apocalypse","Film Tentang superhero Mutasi dengan cakar besi",9.5,2011));
        movies.add(new Movie("Shutter Island","Pulau yang misterius",9,2009));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovies();

        adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);


        // membuat tulisan jika di klik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                Movie selectedMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(),DetailActivity.class);
                intent.putExtra("rilonur.gunawan", selectedMovie);
                startActivity(intent);
            }
        });
    }

    public void fromAdd(View view){
        Intent intent = new Intent(this, TambahFilm.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("rilonur.gunawan");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();
            }

        }
    }
}
