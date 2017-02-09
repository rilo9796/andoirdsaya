package rilonur.gunawan.listfilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String [] filmTitles = {"The Thor","Harry Potter","Inception",
    //                                "Will Of Wallstreet","Django Unchained",
    //                                "Titanic","Captain America","Doctor Strange",
     //                               "X-Men Apocalypse","Shutter Island"};

    private ArrayList<Movie> movies = new ArrayList<>();

    private void initMovies(){
        movies.add(new Movie("A thousand Word", "Film bergenre drama tentang seorang pengusaha yang sedang dikutuk untuk tidak bicara",
                            8.0, 2014));
        movies.add(new Movie("Up", "Film tentang Perjuangan seorang suami yang sudah berumur paruh baya yang ingin mewujudkan"+
                            "keinginan istrinya yang sudah tiada", 9.0,2012));
        movies.add(new Movie("Fury","Film ini menceritakan tentang peperangan melawan Nazi yang bintangi oleh aktor Brad Pitt",
                            8.5, 2014));
        movies.add(new Movie("Max", "Film ini menceritakan hewan peliharaan anjing yang kehilang pemilikinya ketika ditugaskan perang",
                            8.7, 2015));
        movies.add(new Movie("Annabelle","Film yang begenre horror, menceritakan tentang sebuah boneka yang bernama Annabelle"+
                            "boneka ini merupakan boneka yang dibuat pemujaan kepada setan", 8.0, 2014));
        movies.add(new Movie("Finding Dory", "Film Animasi yang menceritakan tentang ikan yang bernama Dory"+
                            "yang sedang mencari kedua Orang Tuannya", 8.0,2016));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovies();
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,
                                        android.R.layout.simple_list_item_1,movies);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //                                android.R.layout.simple_list_item_1, filmTitles);
        ListView listView = (ListView) findViewById(R.id.list_film);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int postion, long id){
                Movie selectMovie = movies.get(postion);
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("rilonur.gunawan.listfilm", selectMovie);
                startActivity(intent);
            }
        });

    }
}
