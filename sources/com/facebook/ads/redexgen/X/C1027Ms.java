package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Ms  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1027Ms implements InterfaceC1000Lq<Bundle> {
    public static byte[] A0D;
    public static String[] A0E = {"nkjKj1MvUJoP2SJPYcgbaBjYPy4EsWOF", "UEaFlSlVJfgDxU2HAGuUlGjRHCZL3UC5", "HKOtxcgqDUvcB7Zt0rEFxuoEqCvYEtNO", "rowCAjgGiKT2zEBSq3xmGSL0Kf3UrlyG", "EJAz0i2eNdRPLBpGYGjYpv17GQTuD6uU", "hVbT72qq2pp8XHiEw", "RwROuq5e2nKVw7hJaeybV0hHAIDx5UQQ", "neuOh54FNoDLqHEFUxNtW4G7fWRiy4GW"};
    public int A00;
    public int A01;
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public boolean A04;
    public final C1489c0 A05;
    public final XT A06;
    public final JT A07;
    public final InterfaceC1088Pd A08;
    public final C1093Pi A09;
    public final Object A0A;
    public final String A0B;
    @Nullable
    public final Map<String, String> A0C;

    public static String A0G(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 48);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0D = new byte[]{11, Draft_75.CR, 30, 19, 25, 24, -82, -79, -98, -62, -82, -71, -74, -63, -58, -102, -82, -69, -82, -76, -78, -65, -18, 1, -10, -6, -14, -20, -6, 0, -96, -77, -86, -85, -89, -100, -76, -96, -83, -56, -67, -49, -48, -98, -53, -47, -54, -64, -67, -50, -43, -80, -59, -55, -63, -87, -81, -98, -109, -91, -90, -126, -92, -95, -103, -92, -105, -91, -91, -122, -101, -97, -105, Byte.MAX_VALUE, -123, -21, -31, -33, -14, -35, -21, -15, -23, -33, -14, -16, -37, -23, -17, 20, 12, -33, -37, -45, -43, -56, -45, 26, 30, Draft_75.CR, 17, 6, 10, 2, 27, 34, -87, -98, -94, -102, 37, 27, 16, -16, -26, -25, 19, 9, 10, -2, 21, -64, -70, -78, 10, 4, 11, 5, 3, -8, -4, -12, -18, -4, 2, -64, -63, -87, -82, 0, 1, -23, -4, -3, -8, -9, -8, -30, 5, 6, -4, -74, -73, -83, -95, -72, -21, -35, -30, -40, -29, -21};
    }

    static {
        A0O();
    }

    public C1027Ms(XT xt, JT jt, InterfaceC1088Pd interfaceC1088Pd, List<AnonymousClass27> list, String str, boolean z) {
        this(xt, jt, interfaceC1088Pd, list, str, z, null);
    }

    public C1027Ms(XT xt, JT jt, InterfaceC1088Pd interfaceC1088Pd, List<AnonymousClass27> list, String str, boolean z, @Nullable Bundle bundle) {
        this(xt, jt, interfaceC1088Pd, list, str, z, bundle, null);
    }

    public C1027Ms(XT xt, JT jt, InterfaceC1088Pd interfaceC1088Pd, List<AnonymousClass27> list, String str, boolean z, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        this.A0A = new Object();
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
        this.A03 = null;
        this.A06 = xt;
        this.A07 = jt;
        this.A08 = interfaceC1088Pd;
        this.A0B = str;
        this.A0C = map;
        this.A04 = z;
        list.add(new N4(this, 0.5d, -1.0d, 2.0d, true));
        list.add(new C1028Mt(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A05 = new C1489c0(interfaceC1088Pd.getView(), list, bundle.getBundle(A0G(6, 16, 29)), xt);
            this.A01 = bundle.getInt(A0G(57, 18, 2));
            this.A00 = bundle.getInt(A0G(39, 18, 44));
        } else {
            this.A05 = new C1489c0(interfaceC1088Pd.getView(), list, xt);
        }
        this.A09 = new C1093Pi(new Handler(), this);
    }

    private final float A0E() {
        return M2.A00(this.A06) * this.A08.getVolume();
    }

    private Map<String, String> A0I(int i2) {
        HashMap<String, String> hashMap = new HashMap<>();
        M2.A03(hashMap, this.A08.getVideoStartReason() == EnumC1094Pj.A03, !this.A08.A8O());
        A0R(hashMap);
        A0Q(hashMap);
        A0T(hashMap, i2);
        A0S(hashMap);
        A0P(hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A0J(EnumC1089Pe enumC1089Pe) {
        return A0K(enumC1089Pe, this.A08.getCurrentPositionInMillis());
    }

    private Map<String, String> A0K(EnumC1089Pe enumC1089Pe, int i2) {
        Map<String, String> A0I = A0I(i2);
        A0I.put(A0G(0, 6, 122), String.valueOf(enumC1089Pe.A00));
        return A0I;
    }

    private void A0M() {
        this.A07.A9H(this.A0B, A0J(EnumC1089Pe.A04));
    }

    private void A0N() {
        this.A07.A9H(this.A0B, A0J(EnumC1089Pe.A0A));
    }

    private void A0P(HashMap<String, String> hashMap) {
        Map<String, String> map = this.A0C;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    private void A0Q(Map<String, String> map) {
        AnonymousClass29 A03 = this.A05.A03();
        AnonymousClass28 A00 = A03.A00();
        map.put(A0G(BuildConfig.VERSION_CODE, 3, 81), String.valueOf(A00.A00()));
        map.put(A0G(148, 3, 95), String.valueOf(A00.A05()));
        map.put(A0G(151, 5, 16), String.valueOf(A00.A02()));
        map.put(A0G(127, 8, 95), String.valueOf(A00.A01() * 1000.0d));
        map.put(A0G(82, 7, 76), String.valueOf(A00.A03() * 1000.0d));
        String str = this.A02;
        if (str != null) {
            map.put(A0G(135, 4, 26), str);
        }
        String str2 = this.A03;
        if (str2 != null) {
            map.put(A0G(139, 6, 90), str2);
        }
        AnonymousClass28 A01 = A03.A01();
        map.put(A0G(110, 3, 127), String.valueOf(A01.A00()));
        map.put(A0G(113, 3, 74), String.valueOf(A01.A05()));
        map.put(A0G(116, 5, 109), String.valueOf(A01.A02()));
        map.put(A0G(22, 8, 93), String.valueOf(A01.A01() * 1000.0d));
        map.put(A0G(75, 7, 78), String.valueOf(A01.A03() * 1000.0d));
    }

    private void A0R(Map<String, String> map) {
        map.put(A0G(30, 9, 11), String.valueOf(this.A08.A8L()));
        map.put(A0G(93, 4, 51), Long.toString(this.A08.getInitialBufferTime()));
    }

    private void A0S(Map<String, String> map) {
        Rect rect = new Rect();
        this.A08.getGlobalVisibleRect(rect);
        map.put(A0G(97, 2, 122), String.valueOf(rect.top));
        map.put(A0G(91, 2, 63), String.valueOf(rect.left));
        map.put(A0G(89, 2, 116), String.valueOf(this.A08.getMeasuredHeight()));
        map.put(A0G(104, 2, 123), String.valueOf(this.A08.getMeasuredWidth()));
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) this.A06.getSystemService(A0G(156, 6, 68))).getDefaultDisplay().getMetrics(metrics);
        map.put(A0G(121, 3, 26), String.valueOf(metrics.heightPixels));
        map.put(A0G(124, 3, 100), String.valueOf(metrics.widthPixels));
    }

    private void A0T(Map<String, String> map, int i2) {
        map.put(A0G(99, 5, 109), String.valueOf(this.A00 / 1000.0f));
        map.put(A0G(106, 4, 5), String.valueOf(i2 / 1000.0f));
    }

    public final int A0U() {
        return this.A01;
    }

    public final Bundle A0V() {
        A0e(A0U(), A0U());
        Bundle bundle = new Bundle();
        bundle.putInt(A0G(57, 18, 2), this.A01);
        bundle.putInt(A0G(39, 18, 44), this.A00);
        bundle.putBundle(A0G(6, 16, 29), this.A05.A02());
        return bundle;
    }

    public final void A0W() {
        this.A05.A04();
        this.A07.A9H(this.A0B, A0J(EnumC1089Pe.A05));
    }

    public final void A0X() {
        this.A07.A9H(this.A0B, A0J(EnumC1089Pe.A07));
    }

    public final void A0Y() {
        this.A07.A9H(this.A0B, A0J(EnumC1089Pe.A08));
    }

    public final void A0Z() {
        if (A0E() < 0.05d) {
            synchronized (this.A0A) {
                if (this.A04) {
                    A0M();
                    this.A04 = false;
                }
            }
            return;
        }
        synchronized (this.A0A) {
            if (!this.A04) {
                A0N();
                this.A04 = true;
            }
        }
    }

    public final void A0a() {
        this.A06.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A09);
    }

    public final void A0b() {
        this.A06.getContentResolver().unregisterContentObserver(this.A09);
    }

    public final void A0c(int i2) {
        A0f(i2, false, false);
    }

    public final void A0d(int i2) {
        A0f(i2, true, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0e(int i2, int i3) {
        A0f(i2, true, false);
        this.A00 = i3;
        this.A01 = i3;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0f(int i2, boolean z, boolean z2) {
        int i3;
        if (i2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || i2 < (i3 = this.A01)) {
            return;
        }
        if (i2 > i3) {
            this.A05.A06((i2 - i3) / 1000.0f, A0E());
            this.A01 = i2;
            if (z2 || i2 - this.A00 >= 5000) {
                JT jt = this.A07;
                String str = this.A0B;
                Map<String, String> A0K = A0K(EnumC1089Pe.A09, i2);
                if (A0E[5].length() == 0) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[1] = "IXDsMs8MiMzYVjpFmNZXbOdNx8hS7U1p";
                strArr[6] = "KaqaEYbZ8TBX2kyM8fVmd1OK78kemUif";
                jt.A9H(str, A0K);
                this.A00 = this.A01;
                this.A05.A05();
                return;
            }
        }
        if (z) {
            this.A07.A9H(this.A0B, A0K(EnumC1089Pe.A09, i2));
        }
    }
}
