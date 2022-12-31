package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.WorkRequest;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    private static BuglyBroadcastReceiver f7840d;
    private Context b;
    private String c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7841e = true;
    private IntentFilter a = new IntentFilter();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        private /* synthetic */ BuglyBroadcastReceiver a;

        a(BuglyBroadcastReceiver buglyBroadcastReceiver) {
            this.a = buglyBroadcastReceiver;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                x.a(BuglyBroadcastReceiver.f7840d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                synchronized (this.a) {
                    BuglyBroadcastReceiver.this.b.registerReceiver(BuglyBroadcastReceiver.f7840d, BuglyBroadcastReceiver.this.a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f7840d == null) {
                f7840d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f7840d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        x.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.b = context;
        z.a(new a(this));
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f7841e) {
                    this.f7841e = false;
                    return true;
                }
                String b = com.tencent.bugly.crashreport.common.info.b.b(this.b);
                x.c("is Connect BC " + b, new Object[0]);
                x.a("network %s changed to %s", this.c, b);
                if (b == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = b;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
                u a3 = u.a();
                com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a2 != null && a3 != null && a4 != null) {
                    if (!b.equals(str) && currentTimeMillis - a3.a(c.a) > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        x.a("try to upload crash on network changed.", new Object[0]);
                        c a5 = c.a();
                        if (a5 != null) {
                            a5.a(0L);
                        }
                        x.a("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.b.a.b();
                    }
                    return true;
                }
                x.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
