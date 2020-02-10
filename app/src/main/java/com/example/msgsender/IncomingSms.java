package com.example.msgsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class IncomingSms extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		
		try{
			if (bundle != null){
				Object[] pdusObj = (Object[]) bundle.get("pdus");
				for (int i = 0; i < pdusObj.length; i++) {
					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
 
                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);
                     
 
                   // Show Alert
                    int duration = Toast.LENGTH_LONG * 4;
                    Toast toast = Toast.makeText(context, "senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();
                    
                    if ((message.equalsIgnoreCase("coucou") || message.equalsIgnoreCase("cc")) && 
                    		(senderNum.endsWith("616922318"))){
                    }
                    
                    //OutgoingSms.sendMessage(senderNum, "Ceci est une réponse automatisée : je suis à la plage !!!");
                     
				} // end for loop
			} // bundle is null

		}catch (Exception e){
			Log.e("SmsReceiver", "Exception smsReceiver " + e.getMessage());
		}
	}
	
}
