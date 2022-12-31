package cn.sharesdk.wechat.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* compiled from: RegToWx.java */
/* loaded from: classes.dex */
public class c {
    private static IWXAPI a;

    public static synchronized IWXAPI a(final String str) {
        synchronized (c.class) {
            IWXAPI iwxapi = a;
            if (iwxapi != null) {
                return iwxapi;
            }
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(MobSDK.getContext(), str, true);
            a = createWXAPI;
            createWXAPI.registerApp(str);
            MobSDK.getContext().registerReceiver(new BroadcastReceiver() { // from class: cn.sharesdk.wechat.utils.c.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    VdsAgent.onBroadcastReceiver(this, context, intent);
                    c.a.registerApp(str);
                }
            }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
            return a;
        }
    }
}
