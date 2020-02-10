package com.example.msgsender;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
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
		ttNum.setText("0616922318");
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
		lstNums.put("Anthony", "0648253321");
		lstNums.put("Laurence", "0695527993");
		lstNums.put("Nicolas", "0615119548");
		lstNums.put("Michel", "0603457118");
		
		/*try {
			String msg = "Laurence, voici un nouveau jeu de piste :-)";
			sendMessage(lstNums.get("Laurence"), msg);
			Thread.sleep(5000);

			msg = "La première partie du message que tu dois reconstruire arrive maintenant sur le téléphone d'Anthony ;-)";
			sendMessage(lstNums.get("Laurence"), msg);
			msg = "Message à donner à Laurence : \"Je dois la rappeler\" ";
			sendMessage(lstNums.get("Anthony"), msg);			
			Thread.sleep(2000);
			
			msg = "La deuxième partie du message que tu dois reconstruire arrive maintenant sur le téléphone de Nicolas ;-)";
			sendMessage(lstNums.get("Laurence"), msg);
			msg = "Message à donner à Laurence : \"dès qu'elle sera plus en scooter\" ";
			sendMessage(lstNums.get("Nicolas"), msg);			
			Thread.sleep(2000);

			msg = "La dernière partie du message que tu dois reconstruire est \" donc à 16 h 45\" ;-)";
			sendMessage(lstNums.get("Laurence"), msg);
			Thread.sleep(5000);

			msg = "Oui je sais, je suis nul ;-)";
			sendMessage(lstNums.get("Laurence"), msg);
		} catch (InterruptedException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}*/
		OutgoingSms.sendMessage(ttNum.getText().toString(), ttContent.getText().toString());
	}
}
