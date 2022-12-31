package us.pinguo.advconfigdata.service;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
/* loaded from: classes3.dex */
public class AdvKeepLiveReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, "================AdvKeepLiveReceiver");
        String str = Build.VERSION.SDK_INT < 21 ? "us.pinguo.advconfigdata.service.AdvLowCommonService" : "us.pinguo.advconfigdata.service.AdvHightCommonService";
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100);
        if (runningServices.size() > 0) {
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (runningServices.get(i2).service.getClassName().equals(str)) {
                    Log.i(TJAdUnitConstants.String.VIDEO_INFO, "================AdvKeepLiveReceiver +return");
                    return;
                }
            }
            Log.i(TJAdUnitConstants.String.VIDEO_INFO, "================AdvKeepLiveReceiver +start");
        }
    }
}
