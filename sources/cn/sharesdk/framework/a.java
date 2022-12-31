package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
/* compiled from: CheckAppKey.java */
/* loaded from: classes.dex */
public class a {
    public static volatile boolean a = false;
    public static String b;

    public static boolean a() {
        String appkey = MobSDK.getAppkey();
        if (a || TextUtils.isEmpty(appkey)) {
            return false;
        }
        if (TextUtils.isEmpty(b)) {
            SSDKLog.b().d("CheckAppKeyAsynchronously verify the appkey", new Object[0]);
            new Thread() { // from class: cn.sharesdk.framework.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        b.a().b();
                    } catch (Throwable th) {
                        NLog b2 = SSDKLog.b();
                        b2.d("CheckAppKeyAsyn verify the appkey catch " + th, new Object[0]);
                    }
                }
            }.start();
            return true;
        }
        SSDKLog.b().d("CheckAppKeyDetermine whether successAppKey is equal to mobsdk.getappkey", new Object[0]);
        return appkey.equals(b);
    }
}
