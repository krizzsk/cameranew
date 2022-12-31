package us.pinguo.smaatoapi.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: HttpUtils.java */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: HttpUtils.java */
    /* renamed from: us.pinguo.smaatoapi.network.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class RunnableC0448a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11992d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f11993e;

        /* compiled from: HttpUtils.java */
        /* renamed from: us.pinguo.smaatoapi.network.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0449a implements Runnable {
            final /* synthetic */ Map a;

            RunnableC0449a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                if ("200".equals(this.a.get("ResponseCode"))) {
                    RunnableC0448a.this.f11993e.a((String) this.a.get("data"), (String) this.a.get("smt_adtype"));
                } else {
                    RunnableC0448a.this.f11993e.error((String) this.a.get("data"));
                }
            }
        }

        RunnableC0448a(Context context, String str, String str2, String str3, b bVar) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.f11992d = str3;
            this.f11993e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                str = AdvertisingIdClient.a(this.a.getApplicationContext());
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(IjkMediaMeta.IJKM_KEY_FORMAT, this.b);
            hashMap.put("adspace", this.c);
            hashMap.put("pub", this.f11992d);
            if ("display".equals(this.b)) {
                hashMap.put(TypedValues.Custom.S_DIMENSION, "full_320x480");
            }
            hashMap.put("googleadid", str);
            hashMap.put("googlednt", Boolean.FALSE);
            hashMap.put("androidid", Settings.Secure.getString(this.a.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID));
            hashMap.put("coppa", 0);
            hashMap.put(TJAdUnitConstants.String.BUNDLE, this.a.getPackageName());
            new Handler(Looper.getMainLooper()).post(new RunnableC0449a(a.b(this.a, "http://api.ad.smaato.net/oapi/v6/ad", hashMap)));
        }
    }

    /* compiled from: HttpUtils.java */
    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, String str2);

        void error(String str);
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 0) {
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                                return nextElement.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e2) {
                    e2.printStackTrace();
                    return "";
                }
            } else if (activeNetworkInfo.getType() == 1) {
                return c(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0094 A[Catch: IOException -> 0x00f6, MalformedURLException -> 0x0108, TryCatch #2 {MalformedURLException -> 0x0108, IOException -> 0x00f6, blocks: (B:4:0x0012, B:7:0x0019, B:8:0x0029, B:10:0x002f, B:11:0x005c, B:13:0x0069, B:15:0x0094, B:16:0x00a7, B:18:0x00ad, B:19:0x00b1, B:20:0x00db, B:12:0x0066), top: B:27:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db A[Catch: IOException -> 0x00f6, MalformedURLException -> 0x0108, TRY_LEAVE, TryCatch #2 {MalformedURLException -> 0x0108, IOException -> 0x00f6, blocks: (B:4:0x0012, B:7:0x0019, B:8:0x0029, B:10:0x002f, B:11:0x005c, B:13:0x0069, B:15:0x0094, B:16:0x00a7, B:18:0x00ad, B:19:0x00b1, B:20:0x00db, B:12:0x0066), top: B:27:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> b(android.content.Context r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.smaatoapi.network.a.b(android.content.Context, java.lang.String, java.util.Map):java.util.Map");
    }

    private static String c(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static void d(Context context, String str, String str2, String str3, b bVar) {
        new Thread(new RunnableC0448a(context, str, str3, str2, bVar)).start();
    }
}
