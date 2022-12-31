package j.a.f;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import j.a.f.e;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import us.pinguo.bigdata.config.BDConfig;
/* compiled from: StatInterfaceImpl.java */
/* loaded from: classes6.dex */
public class h implements e.a {
    private ExecutorService a;
    private boolean b = true;

    private void f(Runnable runnable) {
        if (this.a == null) {
            this.a = Executors.newSingleThreadExecutor();
        }
        this.a.execute(runnable);
    }

    @Override // j.a.f.e.a
    public void a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        us.pinguo.common.log.a.e(stackTraceString, new Object[0]);
        e.onEvent("id_pg_exception_msg", th.getClass().getName(), stackTraceString);
    }

    @Override // j.a.f.e.a
    public void b(boolean z) {
        us.pinguo.bigdata.a.m(z);
    }

    @Override // j.a.f.e.a
    public void c(String str) {
    }

    @Override // j.a.f.e.a
    public String d(Context context) {
        return us.pinguo.bigdata.f.a.e(context);
    }

    @Override // j.a.f.e.a
    public void e(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context, boolean z2) {
        us.pinguo.bigdata.a.m(z2);
        us.pinguo.bigdata.a.c = true;
        us.pinguo.bigdata.a.g(new BDConfig.Builder((Application) context).setDebug(true).setCuid(str2).setCid(str3).setGps(str4, str5).setNewUserTime(str6).setChannel(str).setPicNum(str7, str8).build());
        us.pinguo.bigdata.f.a.w(context);
    }

    @Override // j.a.f.e.a
    public void onEvent(final String str) {
        if (this.b) {
            f(new Runnable() { // from class: j.a.f.c
                @Override // java.lang.Runnable
                public final void run() {
                    us.pinguo.bigdata.a.onEvent(str);
                }
            });
        }
    }

    @Override // j.a.f.e.a
    public void onPause() {
    }

    @Override // j.a.f.e.a
    public void onResume() {
    }

    @Override // j.a.f.e.a
    public void onEvent(final String str, final String str2) {
        if (this.b) {
            f(new Runnable() { // from class: j.a.f.d
                @Override // java.lang.Runnable
                public final void run() {
                    us.pinguo.bigdata.a.onEvent(str, str2);
                }
            });
        }
    }

    @Override // j.a.f.e.a
    public void onEvent(final String str, final String str2, final String str3) {
        if (this.b) {
            f(new Runnable() { // from class: j.a.f.b
                @Override // java.lang.Runnable
                public final void run() {
                    us.pinguo.bigdata.a.onEvent(str, str2, str3);
                }
            });
        }
    }

    @Override // j.a.f.e.a
    public void onEvent(final String str, final HashMap<String, String> hashMap) {
        if (this.b) {
            f(new Runnable() { // from class: j.a.f.a
                @Override // java.lang.Runnable
                public final void run() {
                    us.pinguo.bigdata.a.onEvent(str, hashMap);
                }
            });
        }
    }
}
