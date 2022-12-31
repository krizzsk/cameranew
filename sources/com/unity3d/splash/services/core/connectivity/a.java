package com.unity3d.splash.services.core.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import com.unity3d.splash.services.core.webview.WebViewEventCategory;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private static int a = -1;
    private static boolean b = false;
    private static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8461d = false;

    /* renamed from: e  reason: collision with root package name */
    private static int f8462e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static HashSet f8463f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unity3d.splash.services.core.connectivity.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0289a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConnectivityEvent.values().length];
            a = iArr;
            try {
                iArr[ConnectivityEvent.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConnectivityEvent.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConnectivityEvent.NETWORK_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void a(c cVar) {
        if (f8463f == null) {
            f8463f = new HashSet();
        }
        f8463f.add(cVar);
        j();
    }

    public static void b() {
        if (a == 1) {
            return;
        }
        DeviceLog.c("Unity Ads connectivity change: connected");
        e();
        HashSet hashSet = f8463f;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onConnected();
            }
        }
        g(ConnectivityEvent.CONNECTED, f8461d, f8462e);
    }

    public static void c() {
        NetworkInfo activeNetworkInfo;
        if (a == 1 && (activeNetworkInfo = ((ConnectivityManager) com.unity3d.splash.services.c.b.a.b().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            boolean z = activeNetworkInfo.getType() == 1;
            int networkType = ((TelephonyManager) com.unity3d.splash.services.c.b.a.b().getSystemService("phone")).getNetworkType();
            boolean z2 = f8461d;
            if (z == z2 && (networkType == f8462e || z2)) {
                return;
            }
            f8461d = z;
            f8462e = networkType;
            DeviceLog.c("Unity Ads connectivity change: network change");
            g(ConnectivityEvent.NETWORK_CHANGE, z, networkType);
        }
    }

    public static void d() {
        if (a == 0) {
            return;
        }
        a = 0;
        DeviceLog.c("Unity Ads connectivity change: disconnected");
        HashSet hashSet = f8463f;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a();
            }
        }
        g(ConnectivityEvent.DISCONNECTED, false, 0);
    }

    private static void e() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.unity3d.splash.services.c.b.a.b().getSystemService("connectivity");
        if (connectivityManager == null) {
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            a = 0;
            return;
        }
        a = 1;
        boolean z = activeNetworkInfo.getType() == 1;
        f8461d = z;
        if (z) {
            return;
        }
        f8462e = ((TelephonyManager) com.unity3d.splash.services.c.b.a.b().getSystemService("phone")).getNetworkType();
    }

    public static void f(c cVar) {
        HashSet hashSet = f8463f;
        if (hashSet == null) {
            return;
        }
        hashSet.remove(cVar);
        j();
    }

    private static void g(ConnectivityEvent connectivityEvent, boolean z, int i2) {
        WebViewApp e2;
        if (c && (e2 = WebViewApp.e()) != null && e2.i()) {
            int i3 = C0289a.a[connectivityEvent.ordinal()];
            if (i3 == 1) {
                WebViewEventCategory webViewEventCategory = WebViewEventCategory.CONNECTIVITY;
                if (z) {
                    e2.k(webViewEventCategory, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), 0);
                } else {
                    e2.k(webViewEventCategory, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), Integer.valueOf(i2));
                }
            } else if (i3 == 2) {
                e2.k(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.DISCONNECTED, new Object[0]);
            } else if (i3 != 3) {
            } else {
                WebViewEventCategory webViewEventCategory2 = WebViewEventCategory.CONNECTIVITY;
                if (z) {
                    e2.k(webViewEventCategory2, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), 0);
                } else {
                    e2.k(webViewEventCategory2, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), Integer.valueOf(i2));
                }
            }
        }
    }

    private static void h() {
        if (b) {
            return;
        }
        b = true;
        e();
        if (Build.VERSION.SDK_INT < 21) {
            ConnectivityChangeReceiver.a();
        } else {
            b.a();
        }
    }

    private static void i() {
        if (b) {
            b = false;
            if (Build.VERSION.SDK_INT < 21) {
                ConnectivityChangeReceiver.b();
            } else {
                b.b();
            }
        }
    }

    private static void j() {
        HashSet hashSet;
        if (c || !((hashSet = f8463f) == null || hashSet.isEmpty())) {
            h();
        } else {
            i();
        }
    }
}
