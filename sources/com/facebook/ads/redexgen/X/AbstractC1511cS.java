package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;
@SuppressLint({"HardcodedIPAddressUse"})
/* renamed from: com.facebook.ads.redexgen.X.cS  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1511cS implements KW {
    public static byte[] A0D;
    public static String[] A0E = {"4yJhIog9RzpC9w4XHjq79o6hmz2pMXrt", "bLneqHgNlbzxjE", "P7gevZ65hMGDm5VmgpkLcWEi46YxYduR", "Pajg2XTKXpS0pN0AoGLcPnQoa2IWF6Z7", "YyJRdl3XxpBTstTmsw", "OvgbPt0JG7dlaj99kqPbJKVmb9CPKTVr", "21VbiQWRKHmC0d4xB3zoTsbqXtN2ZOxw", "Q3Y9mBD7X4l0uaedlY7FP5X0xCsXbtIX"};
    public static final Handler A0F;
    public static final C04890s A0G = null;
    @SuppressLint({"StaticFieldLeak"})
    public static final KX A0H = null;
    public static final String A0I;
    @Nullable
    public InterfaceC04840n A00;
    public InterfaceC04840n A01;
    public AnonymousClass94 A04;
    public KU A05;
    public AbstractC04850o A06;
    public final C05111o A07;
    public final JT A08;
    public final C04890s A09;
    public final KX A0A;
    public final XT A0B;
    public volatile boolean A0C;
    public long A03 = -1;
    @Nullable
    public String A02 = null;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 8);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{75, 110, 107, 122, 126, 111, 120, 42, 110, 101, 111, 121, 42, 100, 101, 126, 42, 111, 114, 99, 121, 126, 78, 107, 110, Byte.MAX_VALUE, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 96, 97, 47, 124, 123, 110, 125, 123, 78, 107, 62, 25, 17, 20, 29, 28, 88, 12, 23, 88, 17, 22, 17, 12, 17, 25, 20, 17, 2, 29, 88, 59, 23, 23, 19, 17, 29, 53, 25, 22, 25, 31, 29, 10, 86, 34, 3, 76, 1, 3, 30, 9, 76, Draft_75.CR, 8, 76, 15, Draft_75.CR, 2, 8, 5, 8, Draft_75.CR, 24, 9, 31, 66, 88, 125, 96, 97, 104, 47, 110, 107, 110, Byte.MAX_VALUE, 123, 106, 125, 47, 123, 118, Byte.MAX_VALUE, 106, 33, 42, 47, 107, 42, 39, 57, 46, 42, 47, 50, 107, 56, 63, 42, 57, 63, 46, 47, 76, 93, 68, 44, 59, 91, 94, 75, 94, 112, 93, 85, 90, 92, 75, 31, 86, 76, 31, 81, 74, 83, 83, 48, 59, 54, 39, 44, 37, 33, 48, 49, 10, 60, 49, 28, 23, 15, 16, 11, 22, 23, 20, 28, 23, Draft_75.CR, 89, 16, 10, 89, 28, 20, 9, Draft_75.CR, 0, 73, 93, 74, 94, 90, 74, 65, 76, 86, 112, 76, 78, 95, 95, 70, 65, 72, 71, 64, 88, 79, 66, 71, 74, 14, 94, 66, 79, 77, 75, 67, 75, 64, 90, 14, 71, 64, 14, 92, 75, 93, 94, 65, 64, 93, 75, 47, 44, 34, 39, 28, 55, 42, 46, 38, 28, 46, 48, 109, 122, 110, 106, 122, 108, 107, 64, 118, 123};
    }

    public abstract void A0J();

    public abstract void A0L(InterfaceC04840n interfaceC04840n, AnonymousClass94 anonymousClass94, AnonymousClass92 anonymousClass92, C05121p c05121p);

    static {
        A07();
        M7.A02();
        A0I = AbstractC1511cS.class.getSimpleName();
        A0F = new Handler(Looper.getMainLooper());
    }

    public AbstractC1511cS(XT xt, C05111o c05111o) {
        this.A0B = xt;
        this.A07 = c05111o;
        KX kx = A0H;
        if (kx != null) {
            this.A0A = kx;
        } else {
            this.A0A = new KX(this.A0B);
        }
        this.A0A.A0O(this);
        C04890s c04890s = A0G;
        if (c04890s != null) {
            this.A09 = c04890s;
        } else {
            this.A09 = new C04890s();
        }
        if (JD.A0m(this.A0B)) {
            try {
                CookieManager.getInstance();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(this.A0B);
                }
            } catch (Exception e2) {
                Log.w(A0I, A06(48, 35, 112), e2);
            }
        }
        DynamicLoaderFactory.makeLoader(this.A0B).getInitApi().onAdLoadInvoked(this.A0B);
        this.A08 = xt.A08();
        this.A0B.A0D().A4V();
    }

    private void A08(TW tw) {
        AnonymousClass94 A00 = tw.A00();
        if (A00 == null || A00.A05() == null) {
            String A06 = A06(214, 29, 38);
            K3 k3 = new K3(AdErrorType.NO_AD_PLACEMENT, A06);
            this.A0B.A0D().A4X(k3.A03().getErrorCode(), A06);
            this.A06.A0G(k3);
            return;
        }
        this.A04 = A00;
        this.A00 = null;
        AnonymousClass94 anonymousClass94 = this.A04;
        AnonymousClass92 A04 = anonymousClass94.A04();
        String A062 = A06(0, 0, 73);
        if (A04 == null) {
            K3 A01 = K3.A01(AdErrorType.NO_FILL, A062);
            this.A0B.A0D().A4X(A01.A03().getErrorCode(), A06(83, 22, 100));
            this.A06.A0G(A01);
            return;
        }
        String A02 = A04.A02();
        InterfaceC04840n A002 = this.A09.A00(anonymousClass94.A05().A0D());
        if (A002 == null) {
            this.A0B.A06().A8q(A06(142, 3, 37), C06808m.A0S, new C06818n(A06(0, 22, 2), A02));
            AAW(K3.A00(AdErrorType.INTERNAL_ERROR));
            return;
        }
        AdPlacementType A003 = this.A07.A00();
        AdPlacementType adapterType = A002.A75();
        if (A003 != adapterType) {
            K3 A012 = K3.A01(AdErrorType.INTERNAL_ERROR, A062);
            this.A0B.A0D().A4X(A012.A03().getErrorCode(), A06(105, 19, 7));
            this.A06.A0G(A012);
            return;
        }
        this.A00 = A002;
        AnonymousClass95 A05 = anonymousClass94.A05();
        if (A05.A0F()) {
            this.A0B.A0D().AE0();
        }
        JSONObject A042 = A04.A04();
        if (A042 != null) {
            String optString = A042.optString(A06(255, 10, 23));
            this.A0B.A0D().AEV(optString);
            this.A0B.A0B(optString);
            XS A004 = C8I.A00();
            if (A004 != null) {
                A004.A0B(optString);
            }
            String requestId = A06(197, 17, 39);
            A0A(A042.optJSONObject(requestId));
            C05121p c05121p = new C05121p(A042, A05, this.A07.A08, A05.A0C());
            if (this.A05 == null) {
                String A063 = A06(177, 20, 113);
                K3 A013 = K3.A01(AdErrorType.UNKNOWN_ERROR, A063);
                this.A0B.A0D().A4X(A013.A03().getErrorCode(), A063);
                this.A06.A0G(A013);
                return;
            }
            A0L(A002, anonymousClass94, A04, c05121p);
            return;
        }
        String A064 = A06(147, 18, 55);
        K3 error = K3.A01(AdErrorType.UNKNOWN_ERROR, A064);
        this.A0B.A0D().A4X(error.A03().getErrorCode(), A064);
        this.A06.A0G(error);
    }

    private final void A09(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        this.A0B.A0D().A4Y(str != null);
        this.A03 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            AAW(new K3(AdErrorType.API_NOT_SUPPORTED, A06(0, 0, 73)));
            return;
        }
        try {
            this.A05 = this.A07.A01(this.A0B, new KE(this.A0B, str, this.A07.A08, this.A07.A07), adExperienceType);
            if (A0E[6].charAt(21) == '6') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[4] = "3q2wB1pMY3UXfOrLgu";
            strArr[1] = "CsXqAZILgfX2KA";
            this.A0A.A0N(this.A05);
        } catch (K4 e2) {
            AAW(K3.A02(e2));
        }
    }

    private void A0A(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A02 = jSONObject.optString(A06(165, 12, 93));
            C04910u.A0G(jSONObject);
        }
    }

    public final long A0B() {
        AnonymousClass94 anonymousClass94 = this.A04;
        if (anonymousClass94 != null) {
            return anonymousClass94.A03();
        }
        return -1L;
    }

    public final Handler A0C() {
        return A0F;
    }

    public final AnonymousClass95 A0D() {
        AnonymousClass94 anonymousClass94 = this.A04;
        if (anonymousClass94 == null) {
            return null;
        }
        return anonymousClass94.A05();
    }

    @Nullable
    public final String A0E() {
        InterfaceC04840n interfaceC04840n = this.A01;
        if (interfaceC04840n == null) {
            return null;
        }
        return interfaceC04840n.A61();
    }

    public final void A0F() {
        this.A0B.A0D().A2e(C1008Ly.A01(this.A03));
        if (this.A01 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A06(243, 12, 75), C1008Ly.A04(this.A03));
        new C0937Jb(this.A01.A61(), this.A08).A02(EnumC0936Ja.A08, hashMap);
    }

    public final void A0G() {
        InterfaceC04840n interfaceC04840n = this.A01;
        String A06 = A06(142, 3, 37);
        if (interfaceC04840n == null) {
            String A062 = A06(22, 26, 7);
            this.A0B.A06().A8q(A06, C06808m.A0I, new C06818n(A062));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0B.A0D().A4X(adErrorType.getErrorCode(), A062);
            this.A06.A0G(K3.A01(adErrorType, adErrorType.getDefaultErrorMessage()));
            this.A0B.A0D().A4a();
        } else if (this.A0C) {
            String A063 = A06(124, 18, 67);
            this.A0B.A06().A8q(A06, C06808m.A0E, new C06818n(A063));
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            this.A0B.A0D().A4X(adErrorType2.getErrorCode(), A063);
            this.A06.A0G(K3.A01(adErrorType2, adErrorType2.getDefaultErrorMessage()));
            this.A0B.A0D().A4Z();
        } else {
            if (!TextUtils.isEmpty(this.A01.A61())) {
                this.A08.A99(this.A01.A61());
            }
            this.A0B.A0D().A4b();
            this.A0C = true;
            A0J();
        }
    }

    public final void A0H() {
        A0R(false);
    }

    public final void A0I() {
        String str = this.A02;
        if (str != null) {
            C04910u.A0D(str);
        }
    }

    public final void A0K(InterfaceC04840n interfaceC04840n) {
        if (interfaceC04840n != null) {
            interfaceC04840n.onDestroy();
        }
    }

    public final void A0M(AbstractC04850o abstractC04850o) {
        this.A06 = abstractC04850o;
    }

    public final void A0N(C05121p c05121p) {
        this.A0B.A0D().A4U();
        String optString = c05121p.A03().optString(A06(BuildConfig.VERSION_CODE, 2, 71));
        if (!TextUtils.isEmpty(optString)) {
            new C0937Jb(optString, this.A08).A02(EnumC0936Ja.A04, null);
        }
    }

    public void A0O(@Nullable String str) {
        A09(str, null);
    }

    public final void A0P(@Nullable String str) {
        A0O(str);
    }

    public final void A0Q(@Nullable String str, @Nullable AdExperienceType adExperienceType) {
        A09(str, adExperienceType);
    }

    public void A0R(boolean z) {
        if (!z && !this.A0C) {
            return;
        }
        this.A0B.A0D().A4c();
        A0K(this.A01);
        this.A0C = false;
    }

    public final boolean A0S() {
        AnonymousClass94 anonymousClass94 = this.A04;
        return anonymousClass94 == null || anonymousClass94.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.KW
    public final synchronized void AAW(K3 k3) {
        A0C().post(new C1512cT(this, k3));
    }

    @Override // com.facebook.ads.redexgen.X.KW
    @SuppressLint({"CatchGeneralException"})
    public final synchronized void ACC(TW tw) {
        try {
            A08(tw);
        } catch (Exception e2) {
            this.A0B.A06().A8q(A06(142, 3, 37), C06808m.A0L, new C06818n(e2));
        }
    }
}
