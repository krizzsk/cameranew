package cn.sharesdk.sina.weibo;

import androidx.core.view.PointerIconCompat;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
/* compiled from: SinaLinkCardLog.java */
/* loaded from: classes.dex */
public class b {
    private static volatile b a;
    private MobCommunicator b;
    private String c = MobSDK.getAppkey();

    public static b a() {
        synchronized (b.class) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized MobCommunicator b() {
        if (this.b == null) {
            this.b = new MobCommunicator(PointerIconCompat.TYPE_GRABBING, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        return System.currentTimeMillis();
    }

    public void a(final int i2) {
        new Thread() { // from class: cn.sharesdk.sina.weibo.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appkey", b.this.c);
                hashMap.put("plat", 1);
                hashMap.put(AuthActivity.ACTION_KEY, Integer.valueOf(i2));
                hashMap.put("shareTime", Long.valueOf(b.this.c()));
                try {
                    HashMap hashMap2 = (HashMap) b.this.b().requestSynchronized(hashMap, "http://lks.share.mob.com/share/shareLog", false);
                } catch (Throwable th) {
                    NLog b = SSDKLog.b();
                    b.d("LinkCard log up error===> " + th.getMessage(), new Object[0]);
                }
            }
        }.start();
    }
}
