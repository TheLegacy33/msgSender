package com.example.msgsender;

import android.telephony.SmsManager;
import android.telephony.SubscriptionManager;

class OutgoingSms {

	static void sendMessage(String pNumero, String pMessage){
		try {SmsManager smsManager = SmsManager.getSmsManagerForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId());
			smsManager.sendTextMessage(pNumero, null, pMessage, null, null);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
