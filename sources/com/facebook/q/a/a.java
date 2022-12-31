package com.facebook.q.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.l;
import com.facebook.internal.x;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;
import com.google.zxing.e;
import com.tapjoy.TapjoyConstants;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: DeviceRequestsHelper.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = "com.facebook.q.a.a";
    private static HashMap<String, NsdManager.RegistrationListener> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceRequestsHelper.java */
    /* renamed from: com.facebook.q.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0113a implements NsdManager.RegistrationListener {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        C0113a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
            a.a(this.b);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            if (this.a.equals(nsdServiceInfo.getServiceName())) {
                return;
            }
            a.a(this.b);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
        }
    }

    public static void a(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            b(str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    @TargetApi(16)
    private static void b(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            NsdManager.RegistrationListener registrationListener = b.get(str);
            if (registrationListener != null) {
                try {
                    ((NsdManager) f.f().getSystemService("servicediscovery")).unregisterService(registrationListener);
                } catch (IllegalArgumentException e2) {
                    x.X(a, e2);
                }
                b.remove(str);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    public static Bitmap c(String str) {
        int g2;
        int i2;
        int[] iArr;
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 2);
            try {
                b a2 = new e().a(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                g2 = a2.g();
                i2 = a2.i();
                iArr = new int[g2 * i2];
                for (int i3 = 0; i3 < g2; i3++) {
                    int i4 = i3 * i2;
                    for (int i5 = 0; i5 < i2; i5++) {
                        iArr[i4 + i5] = a2.e(i5, i3) ? ViewCompat.MEASURED_STATE_MASK : -1;
                    }
                }
                createBitmap = Bitmap.createBitmap(i2, g2, Bitmap.Config.ARGB_8888);
            } catch (WriterException unused) {
            }
            try {
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, g2);
                return createBitmap;
            } catch (WriterException unused2) {
                bitmap = createBitmap;
                return bitmap;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static String d() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, Build.DEVICE);
                jSONObject.put(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static boolean e() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            l j2 = FetchedAppSettingsManager.j(f.g());
            if (Build.VERSION.SDK_INT < 16 || j2 == null) {
                return false;
            }
            return j2.m().contains(SmartLoginOption.Enabled);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    public static boolean f(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            if (e()) {
                return g(str);
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    @TargetApi(16)
    private static boolean g(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            if (b.containsKey(str)) {
                return true;
            }
            String format = String.format("%s_%s_%s", "fbsdk", String.format("%s-%s", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE, f.w().replace('.', '|')), str);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType("_fb._tcp.");
            nsdServiceInfo.setServiceName(format);
            nsdServiceInfo.setPort(80);
            C0113a c0113a = new C0113a(format, str);
            b.put(str, c0113a);
            ((NsdManager) f.f().getSystemService("servicediscovery")).registerService(nsdServiceInfo, 1, c0113a);
            return true;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }
}
