package com.example.u5780527.searchtrackingnumber;

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


    EditText search_AUET;
    EditText search_XFET;

    String schAU;
    String schXF;

    Button auBT;
    Button xfBT;


    String firstUrl="http://m.kuaidi100.com/result.jsp?com=auexpress&nu=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_AUET=(EditText)findViewById(R.id.search_AUET);
        search_XFET=(EditText)findViewById(R.id.search_XFET);

        auBT=(Button)findViewById(R.id.AUBT);
        xfBT=(Button)findViewById(R.id.XFBT);

        search_AUET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    schAU=search_AUET.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        search_XFET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    schXF=search_XFET.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        auBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search_AUET.getText() != null &&
                        !(search_AUET.getText().toString().equals(""))) {
                    String URL = firstUrl + schAU;
                    Intent getWebPage = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(getWebPage);
                }
            }
        });

        xfBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_XFET.getText()!=null &&
                        !(search_XFET.getText().toString().equals(""))){
                    String URL=firstUrl+"+"+schXF;
                    Intent getWebPage=new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(getWebPage);
                }
            }
        });

    }


}
