package nativesdk.ad.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class NetworkSwitchReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
    }
}
