package com.example.admin.surfinternet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText search_brand;
    EditText search_title;
    Button searchweb;

    String schBrand;
    String schTitle;

    String firstURL="https://www.chemistwarehouse.com.au/search?searchtext=";
    String secondURL="&searchmode=allwords";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_brand=(EditText)findViewById(R.id.search_brandET);
        search_title=(EditText)findViewById(R.id.search_titleET);

        searchweb=(Button)findViewById(R.id.searchBT);

        search_brand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                schBrand=search_brand.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        search_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                schTitle=search_title.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        searchweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String middle="";
                String URL="";
                if(search_brand.getText()!=null&& !search_brand.getText().toString().equals("") ){
                    String[] brands=search_brand.getText().toString().split(" ");
                    if(search_title.getText()!=null&& !search_title.getText().toString().equals("")){
                       if(brands.length>1){
                           for(int i=0;i<brands.length;i++){
                               middle=middle+brands[i];
                               middle=middle+"%20";
                           }
                       }else {
                           middle=middle+brands[0];
                       }
                        middle=middle+search_title.getText().toString();
                    }
                }else if(search_brand.getText()!=null&& !search_brand.getText().toString().equals("") ){
                    String[] brands=search_brand.getText().toString().split(" ");

                        if(brands.length>1){
                            for(int i=0;i<brands.length;i++){
                                middle=middle+brands[i];
                                middle=middle+"%20";
                            }
                        }else {
                            middle=middle+brands[0];
                        }
                        middle=middle+search_title.getText().toString();
                }else if(search_title.getText()!=null&& !search_title.getText().toString().equals("")){
                    middle=middle+search_title.getText().toString();
                }else{
                    URL="https://www.chemistwarehouse.com.au/";
                }

                URL=firstURL+middle+secondURL;
                Intent getWebPage=new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

                startActivity(getWebPage);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
