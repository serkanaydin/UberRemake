package com.tolga.uber.Services;


import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tolga.uber.Common;
import com.tolga.uber.Model.EventBus.DriverRequestReceived;
import com.tolga.uber.Utils.UserUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;
import java.util.Random;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            UserUtils.updateToken(this,s);
        }
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String,String> dataRcv = remoteMessage.getData();

        if(dataRcv != null){
            if(dataRcv.get(Common.NOTI_TITLE).equals(Common.REQUEST_DRIVER_TITLE)){

                DriverRequestReceived driverRequestReceived =  new DriverRequestReceived();
                driverRequestReceived.setKey(dataRcv.get(Common.RIDER_KEY));
                driverRequestReceived.setPickupLocation(dataRcv.get(Common.RIDER_PICKUP_LOCATION));
                driverRequestReceived.setGetPickupLocationString(dataRcv.get(Common.RIDER_PICKUP_LOCATION_STRING));
                driverRequestReceived.setDestinationLocation(dataRcv.get(Common.RIDER_DESTINATION));
                driverRequestReceived.setGetPickupLocationString(dataRcv.get(Common.RIDER_DESTINATION_STRING));

                EventBus.getDefault().postSticky(driverRequestReceived);
            }
            else {
                Common.showNotification(this, new Random().nextInt(),
                        dataRcv.get(Common.NOTI_TITLE),
                        dataRcv.get(Common.NOTI_CONTENT),
                        null);
            }
        }
    }
}
