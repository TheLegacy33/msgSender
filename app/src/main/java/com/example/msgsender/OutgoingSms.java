package com.example.msgsender;

import android.telephony.SmsManager;

class OutgoingSms {

	static void sendMessage(String pNumero, String pMessage){
		SmsManager mySmsMan = SmsManager.getDefault();
		mySmsMan.sendTextMessage(pNumero, null, pMessage, null, null);
	}
}
