package com.example.sadu.searchbar;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1sadu);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);

//        getSupportActionBar().setTitle("Appname Search");
//        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        //search = findViewById(R.id.msearch_View12);
        //Log.i("searchtag", search.toString());

        //setSearch();

    }

//    public void setSearch(){
//
//        search.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
//        search.setEllipsize(true);
//        search.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                //Log.i("query,", query);
//                Toast.makeText(MainActivity.this, "submit", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                //Log.i("newText,", newText);
//                return false;
//            }
//        });
//        search.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
//            @Override
//            public void onSearchViewShown() {
//
//            }
//
//            @Override
//            public void onSearchViewClosed() {
//
//            }
//        });
//
//        Log.i("after listener","after listener");
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.meny_item, menu);
        //MenuItem item = menu.findItem(R.id.action_search);
        //search.setMenuItem(item);


        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_2, menu);
        MenuItem item = menu.findItem(R.id.action_search_2);
        searchView = (SearchView) item.getActionView();
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        //search.setSuggestionsAdapter(new ExampleAdapter(this, cursor, items));
        // for history suggestion if needed

        Log.i("menutag", item.toString());
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        Log.i("search", "hint set");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do your search
                Log.i("query", query);
                textView.setText(query+" found");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //if (newText.isEmpty()) clearSearch();
                Log.i("hint",newText);
                return false;
            }
        });

        //TODO: SearchView.OnSuggestionListener

        return super.onPrepareOptionsMenu(menu);
    }
}
