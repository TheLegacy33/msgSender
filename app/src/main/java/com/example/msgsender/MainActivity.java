package com.example.msgsender;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity implements OnClickListener{

	Button btSend;
	EditText ttNum, ttContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btSend = (Button) findViewById(R.id.btSend);
		btSend.setOnClickListener(this);
		ttNum = (EditText) findViewById(R.id.telNumber);
		ttNum.setText("+33647203918");
		ttContent = (EditText) findViewById(R.id.msgContent);
		ttContent.setText("test");
		
		//System.exit(0);
		
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
	
	@Override
	public void onClick(View v) {
		HashMap<String, String> lstNums = new HashMap<String, String>();
		lstNums.put("Maxime", "+33789223133");
		lstNums.put("Damien", "+33695878908");
		lstNums.put("Thierry", "+33647205918");
		lstNums.put("Michel", "+33603457118");
		
		try {
			String msg = "Voici un nouveau jeu de piste :-)";
			OutgoingSms.sendMessage(lstNums.get("Maxime"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);

			msg = "La première partie du message que tu dois reconstruire arrive maintenant sur le téléphone de Damien ;-)";
			OutgoingSms.sendMessage(lstNums.get("Maxime"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);
			msg = "Message à donner à Maxime (+33789223133) : \"Il faut que tu intègres une nouveauté : \" ";
			OutgoingSms.sendMessage(lstNums.get("Damien"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);
			
			msg = "La deuxième partie du message que tu dois reconstruire arrive maintenant sur le téléphone de Thierry ;-)";
			OutgoingSms.sendMessage(lstNums.get("Maxime"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);
			msg = "Message à donner à Maxime (+33789223133): \"C'est super pratique et extremement intéressant \" ";
			OutgoingSms.sendMessage(lstNums.get("Thierry"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);

			msg = "La dernière partie du message que tu dois reconstruire est \" Cela s'appelle Docker :-) :-) :-)\" ;-)";
			OutgoingSms.sendMessage(lstNums.get("Maxime"), msg);
			Log.d(getString(R.string.app_name), msg);
			Thread.sleep(5000);

			msg = "Oui je sais, je suis nul ;-)";
			OutgoingSms.sendMessage(lstNums.get("Maxime"), msg);
			Log.d(getString(R.string.app_name), msg);
		} catch (InterruptedException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
//		OutgoingSms.sendMessage(ttNum.getText().toString(), ttContent.getText().toString());
	}
}
