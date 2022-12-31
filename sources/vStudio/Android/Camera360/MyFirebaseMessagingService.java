package vStudio.Android.Camera360;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tapjoy.TapjoyAuctionFlags;
import org.json.JSONObject;
import us.pinguo.push.PushParser;
import us.pinguo.push.PushPreference;
import us.pinguo.push.f;
/* loaded from: classes7.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PushPreference pushPreference = new PushPreference(this);
        pushPreference.h("clientId", str);
        pushPreference.a();
        f.a aVar = f.c;
        if (aVar != null) {
            aVar.b(Constants.ScionAnalytics.ORIGIN_FCM, str);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("FCMDemo", "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.i("FCMDemo", "Message data payload: " + remoteMessage.getData());
            JSONObject jSONObject = new JSONObject(remoteMessage.getData());
            String jSONObject2 = jSONObject.toString();
            us.pinguo.common.log.a.g("Frisky", "push json:" + jSONObject2, new Object[0]);
            try {
                if (f.c == null) {
                    return;
                }
                f.c.a(jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID), Constants.ScionAnalytics.ORIGIN_FCM, jSONObject.getInt("show") == 1);
                PushParser.get().onHandleJson(jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (remoteMessage.getNotification() != null) {
            Log.d("FCMDemo", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NonNull String str) {
        us.pinguo.common.log.a.g("MyFirebaseMessagingService", "cid:" + str + "   " + str.length(), new Object[0]);
        a(str);
    }
}
