package us.pinguo.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class PushPgReceiver extends BroadcastReceiver {
    private static final long b = TimeZone.getDefault().getRawOffset();
    private ConnectivityManager a = null;

    private static boolean a(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            return networkInfo2 != null && networkInfo2.isConnected();
        }
        return true;
    }

    private boolean b() {
        ConnectivityManager connectivityManager = this.a;
        if (connectivityManager != null) {
            return a(connectivityManager);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(android.content.Context r12) {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = us.pinguo.push.PushPgReceiver.b
            long r2 = r2 + r0
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r2 / r4
            long r6 = r6 * r4
            r4 = 82800000(0x4ef6d80, double:4.09086355E-316)
            long r4 = r4 + r6
            r8 = 28800000(0x1b77400, double:1.42290906E-316)
            long r6 = r6 + r8
            r8 = 1
            r9 = 0
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 <= 0) goto L22
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L22
            r2 = 1
            goto L23
        L22:
            r2 = 0
        L23:
            android.net.ConnectivityManager r3 = r11.a
            if (r3 != 0) goto L31
            java.lang.String r3 = "connectivity"
            java.lang.Object r3 = r12.getSystemService(r3)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            r11.a = r3
        L31:
            if (r2 == 0) goto L93
            us.pinguo.push.PushPreference r2 = new us.pinguo.push.PushPreference
            r2.<init>(r12)
            java.lang.String r12 = "key_last_lunch_time"
            r2.c(r12, r0)
            r12 = 30
            java.lang.String r3 = "key_weak_up_days"
            r2.b(r3, r12)
            boolean r12 = r11.b()
            if (r12 == 0) goto L8d
            r3 = 0
            java.lang.String r12 = "key_last_push_time"
            long r3 = r2.c(r12, r3)
            long r3 = r0 - r3
            r5 = 1800000(0x1b7740, double:8.89318E-318)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L8d
            java.lang.String r3 = "us.pinguo.push.PushParser"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r9]     // Catch: java.lang.Throwable -> L8d
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Throwable -> L8d
            r4.setAccessible(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L8d
            r6 = 0
            java.lang.Object r4 = r4.invoke(r6, r5)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r5 = "onHandleJson"
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch: java.lang.Throwable -> L8d
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r7[r9] = r10     // Catch: java.lang.Throwable -> L8d
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r5, r7)     // Catch: java.lang.Throwable -> L8d
            r3.setAccessible(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L8d
            r5[r9] = r6     // Catch: java.lang.Throwable -> L8d
            r3.invoke(r4, r5)     // Catch: java.lang.Throwable -> L8d
            r2.g(r12, r0)     // Catch: java.lang.Throwable -> L8d
            goto L8e
        L8d:
            r8 = 0
        L8e:
            if (r8 == 0) goto L93
            r2.a()
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.push.PushPgReceiver.c(android.content.Context):void");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        intent.getAction();
        try {
            Class.forName("us.pinguo.push.PushParser");
            c(context);
        } catch (Exception unused) {
        }
    }
}
