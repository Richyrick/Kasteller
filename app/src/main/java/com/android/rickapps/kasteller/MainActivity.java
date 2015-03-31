package com.android.rickapps.kasteller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.app.AlertDialog;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void rekenaar(View v){
        try {
            //Input in variabelen zetten
            EditText centvijf = (EditText) findViewById(R.id.centvijfuser);
            EditText centtien = (EditText) findViewById(R.id.centtienuser);
            EditText centtwintig = (EditText) findViewById(R.id.centtwintiguser);
            EditText centvijftig = (EditText) findViewById(R.id.centvijftiguser);
            EditText euro1 = (EditText) findViewById(R.id.euro1user);
            EditText euro2 = (EditText) findViewById(R.id.euro2user);
            EditText euro5 = (EditText) findViewById(R.id.euro5user);
            EditText euro10 = (EditText) findViewById(R.id.euro10user);
            EditText euro20 = (EditText) findViewById(R.id.euro20user);
            EditText euro50 = (EditText) findViewById(R.id.euro50user);
            EditText euro100 = (EditText) findViewById(R.id.euro100user);

            //Variabelen omzetten naar doubles
            double centvijfDouble = Double.parseDouble(centvijf.getText().toString());
            double centtienDouble = Double.parseDouble(centtien.getText().toString());
            double centtwintigDouble = Double.parseDouble(centtwintig.getText().toString());
            double centvijftigDouble = Double.parseDouble(centvijftig.getText().toString());
            double euro1Double = Double.parseDouble(euro1.getText().toString());
            double euro2Double = Double.parseDouble(euro2.getText().toString());
            double euro5Double = Double.parseDouble(euro5.getText().toString());
            double euro10Double = Double.parseDouble(euro10.getText().toString());
            double euro20Double = Double.parseDouble(euro20.getText().toString());
            double euro50Double = Double.parseDouble(euro50.getText().toString());
            double euro100Double = Double.parseDouble(euro100.getText().toString());
            //Rekenen aan variabelen
            double bedrag = centvijfDouble * 0.05 + centtienDouble * 0.1 + centtwintigDouble * 0.2 + centvijftigDouble * 0.5 + euro1Double + euro2Double * 2 + euro5Double * 5 + euro10Double * 10 + euro20Double * 20 + euro50Double * 50 + euro100Double * 100;
            //Variabele naar string sturen en afronden op max 2 decimalen
            DecimalFormat dec = new DecimalFormat("#.00");
            String bedragText = dec.format(bedrag);
            String bedragText2 = "Er zit €" + bedragText + " in de kas";
            //Variabele naar text op Activity sturen
            TextView textResultaat = (TextView) findViewById(R.id.resultaat);
            textResultaat.setText(bedragText2);
        } catch(NumberFormatException exception){
            messageBox("rekenaar", exception.getMessage());
        } //Stuur exception naar messageBox


    }

    private void messageBox(String method, String message) {
        Log.d("EXCEPTION: " + method,  message);

        AlertDialog.Builder messageBox = new AlertDialog.Builder(this);
        messageBox.setTitle(method);
        messageBox.setMessage(message);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK", null);
        messageBox.show();
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
        if (id == R.id.action_calculate){
            rekenaar(findViewById(R.id.button) );

        }
        if (id == R.id.Reset){
            reset();
        }

        return super.onOptionsItemSelected(item);
    }

    public void reset(){
    //Textvelden importeren en op 0 zetten
    TextView textvijfcent = (TextView) findViewById(R.id.centvijfuser);
        textvijfcent.setText("0");
    TextView textttiencent = (TextView) findViewById(R.id.centtienuser);
        textttiencent.setText("0");
    TextView texttwintigcent = (TextView) findViewById(R.id.centtwintiguser);
        texttwintigcent.setText("0");
    TextView textvijftigcent = (TextView) findViewById(R.id.centvijftiguser);
        textvijftigcent.setText("0");
    TextView text1euro = (TextView) findViewById(R.id.euro1user);
             text1euro.setText("0");
    TextView text2euro = (TextView) findViewById(R.id.euro2user);
        text2euro.setText("0");
    TextView text5euro = (TextView) findViewById(R.id.euro5user);
        text5euro.setText("0");
    TextView text10euro = (TextView) findViewById(R.id.euro10user);
        text10euro.setText("0");
    TextView text20euro = (TextView) findViewById(R.id.euro20user);
        text20euro.setText("0");
    TextView text50euro = (TextView) findViewById(R.id.euro50user);
        text50euro.setText("0");
    TextView text100euro = (TextView) findViewById(R.id.euro100user);
        text100euro.setText("0");


    }







}
