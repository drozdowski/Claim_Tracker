package jdrozdow.claimtracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;



public class MainActivity extends Activity {

	private ArrayList<Claim> claims = new ArrayList<Claim>();
	private ArrayAdapter<String> claim_adapter;
	private static final String FILENAME = "claims.sav";
	protected Claim currentClaim = new Claim();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    //click New button on home screen
    public void change_newclaim_screen(View v) {
    	setContentView(R.layout.newclaim);
    	
    }

    //create new claim from form data
    public void new_claim(View v){
    	
    	Claim c = new Claim();
    	EditText name;
    	EditText description;
    	EditText date_start;
    	EditText date_end;
    	name = (EditText)findViewById(R.id.new_claim_name);
    	description = (EditText)findViewById(R.id.claim_description);
    	date_start = (EditText)findViewById(R.id.claim_date_start);
    	date_end = (EditText)findViewById(R.id.claim_date_end);
    	c.setName(name.getText().toString());
    	c.setDescription(description.getText().toString());
    	c.setDate_start(date_start.getText().toString());
    	c.setDate_end(date_end.getText().toString());
    	currentClaim = c;
    	claims.add(currentClaim);
    }
    
    //return to main menu and represent/update claims in list
    public void main_menu(View v){
    	
    	ArrayAdapter<Claim> claim_adapter = new ArrayAdapter<Claim>(this,
    	        R.layout.claim_list, claims);
    	setContentView(R.layout.activity_main);
    	ListView listView = (ListView) findViewById(R.id.list_claimsID);
    	listView.setAdapter(claim_adapter); 
    	//save_claims(claims);
    }
    
    //click New expense button on claim screen
    public void change_newexpense_screen(View v) {
    	setContentView(R.layout.newexpense);
    	
    }
    
    //create new expense from form data
    public void new_expense(View v) {

    	EditText name = (EditText)findViewById(R.id.expense_name);
    	EditText description = (EditText)findViewById(R.id.expense_description);
    	EditText date = (EditText)findViewById(R.id.expense_date);
    	Spinner currency = (Spinner)findViewById(R.id.currency_spinner);
    	EditText amount = (EditText)findViewById(R.id.expense_amount);
    	
    	//calling the method in class Claim to add an Expense item
    	currentClaim.addItem(name.getText().toString(), date.getText().toString(),
    			description.getText().toString(), currency.getSelectedItem().toString(), Float.valueOf(amount.getText().toString())); 
    	//and return to main menu
    	main_menu(v);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

// After numerous tries and google searches, my eclipse was unable to find Gson
// I've left this commented section in my code with hopes that some of it is functional

/*  public void save_claims(ArrayList<Claim> claims) {
	//Copied from LonelyTwitter in-class demo 28-01-2015
   		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claims, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Claim> loadFromFile() {
	//Copied from LonelyTwitter in-class demo 28-01-2015
		Gson gson = new Gson();
		ArrayList<Claim> claims = null;
		try {
			FileInputStream fis = openFileInput(FILENAME);
			//https://sites.google.com/site/gson/gson-user-guide 2015-01-21
			InputStreamReader isr = new InputStreamReader(fis);
			Type dataType = new TypeToken<ArrayList<Claim>>() {}.getType();
			claims = gson.fromJson(isr, dataType);
			fis.close();
	} 	catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} 	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		if (claims==null){
			claims = new ArrayList<Claim>();
	}
		return claims;
}

	protected void onStart() {

		super.onStart();
	//	claims = loadFromFile();

		
	}
	*/
