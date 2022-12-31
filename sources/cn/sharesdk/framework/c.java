package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
/* compiled from: ForbSwitchFunction.java */
/* loaded from: classes.dex */
public class c {
    private static volatile c b;
    private boolean a = false;

    private c() {
        new Thread() { // from class: cn.sharesdk.framework.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    c.this.a = MobSDK.isForb();
                } catch (Throwable th) {
                    SSDKLog.b().w(th);
                }
            }
        }.start();
    }

    public static c a() {
        synchronized (c.class) {
            if (b == null) {
                synchronized (c.class) {
                    if (b == null) {
                        b = new c();
                    }
                }
            }
        }
        return b;
    }
}
