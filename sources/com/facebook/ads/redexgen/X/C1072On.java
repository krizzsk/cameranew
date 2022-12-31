package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.BuildConfig;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.On  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1072On {
    public static byte[] A0K;
    public static String[] A0L = {"FzSVXB4mYbOB8Ap0RZsCDdXVsmLfm8Jd", "1LkH26oE6mA26lQtC6YvQW7uIFVycFeK", "rW0HdwO1ZwlnSaQ2Af", "GQ1qj5ap6z56eCi2le", "uXieXG3T7mAXvJ2", "QucdoxB0vpGTNezXYptNtkyhh8Rjdnlc", "00yn0QSHmKstnvXW3I3NQQkY4p", "j2c94AiQV22NdXj9VV604tyulZ5jlQdF"};
    public static final AtomicInteger A0M;
    @Nullable
    public InterfaceC1070Ol A01;
    @Nullable
    public InterfaceC1071Om A02;
    @Nullable
    public QZ A03;
    public final AnonymousClass16 A06;
    public final C7J A07;
    public final XT A08;
    public final JT A09;
    public final C0937Jb A0A;
    public final C1062Ob A0C;
    public final S4 A0D;
    public final C1083Oy A0E;
    public final C1084Oz A0F;
    public final LinkedList<C1069Ok> A0I = new LinkedList<>();
    public final C1009Lz A0B = new C1009Lz();
    public final AtomicReference<String> A0J = new AtomicReference<>();
    public boolean A05 = true;
    public boolean A04 = false;
    public long A00 = -1;
    public final String A0H = UUID.randomUUID().toString();
    public final P1 A0G = new S5(this);

    public static String A0B(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 2);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0K = new byte[]{37, 63, 39, 60, 39, 57, Draft_75.CR, 34, 40, 62, 35, 37, 40, 5, 34, 56, 41, 62, 42, 45, 47, 41, 5, 0, 54, 1, 20, 11, 22, 16, Draft_75.CR, 10, 3, 34, Draft_75.CR, 10, Draft_75.CR, 23, 12, 1, 0, 76, 67, 65, 23, 67, 77, 95, 96, 101, 83, 100, 113, 110, 115, 117, 104, 111, 102, 82, 117, 96, 115, 117, 100, 101, 41, 38, 36, 114, 38, 40, 58, 34, 55, 55, 34, 32, 43, 38, 39, 20, 21, Draft_75.CR, 54, 46, 11, 29, 26, 26, Draft_75.CR, 6, 28, 63, 62, 38, 29, 5, 88, 89, 118, 84, 67, 94, 65, 94, 67, 78, 103, 86, 66, 68, 82, 83, 31, 16, 18, 68, 16, 30, 12, 57, 56, 23, 53, 34, 63, 32, 63, 34, 47, 4, 51, 37, 35, 59, 51, 50, 126, 113, 115, 37, 113, Byte.MAX_VALUE, 109, 120, 121, 65, 118, 123, 98, 114, 69, 114, 118, 115, 63, 48, 50, 100, 48, 59, 55, 48, 50, 100, 48, 59, 55, 48, 50, 100, 48, 62, 44, 36, 37, 29, 42, 39, 62, 46, 28, 57, 34, 63, 63, 46, 37, 99, 108, 110, 56, 108, 103, 107, 108, 110, 56, 108, 98, 112, 79, 89, 72, 125, 73, 72, 84, 119, 89, 69, 20, 27, 25, 79, 27, 16, 27, 25, 79, 27, 21, 7, 95, 73, 88, 110, 77, 95, 73, 26, 24, 109, 95, 95, 73, 88, 95, 4, 11, 9, 95, 11, 0, 11, 9, 95, 11, 5, 83, 72, 83, 70, 75, 112, 113, 105, 82, 74, 98, 101, 123, 111, 112, 125, 124, 118, 92, 111, 124, 119, 109, 49, 62, 60, 106, 62, 53, 57, 62, 60, 106, 62, 53, 57, 62, 60, 106, 62, 48, 34, 17, 14, 2, 16, 53, 2, 6, 3, 30, 51, 8, 52, 15, 8, 16, 79, 64, 66, 20, 64, 78, 92};
    }

    static {
        A0E();
        A0M = new AtomicInteger();
    }

    public C1072On(XT xt, AnonymousClass16 anonymousClass16, JT jt, int i2) {
        this.A08 = xt;
        this.A09 = jt;
        this.A06 = anonymousClass16;
        this.A0D = new S4(this, xt);
        this.A07 = new C7J(this.A08);
        this.A0A = new C0937Jb(anonymousClass16.A0Q(), jt);
        this.A0C = new C1062Ob(anonymousClass16.A0V(), anonymousClass16.A0K().A0D().A08(), i2);
        this.A0F = P0.A00(this.A08, anonymousClass16.A0Y(), this.A07, this.A0A, this.A0C, A0I());
        this.A0E = new C1083Oy(this.A08, this, jt, this.A0C, this.A0H, anonymousClass16.A0Q());
    }

    private void A0D() {
        A0G(new C1069Ok(A0B(202, 22, 62), new String[]{this.A0H, A0B(1, 5, 11)}));
        A0G(new C1069Ok(A0B(224, 26, 46), new String[]{Base64.encodeToString(this.A0F.A05.toString().getBytes(), 0).replace(A0B(0, 1, 45), A0B(0, 0, 109)), this.A0H}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public synchronized void A0F() {
        if (this.A04) {
            while (!this.A0I.isEmpty()) {
                C1069Ok poll = this.A0I.poll();
                if (poll != null) {
                    this.A0D.A05(String.format(Locale.US, poll.A00, poll.A02));
                    if (poll.A01) {
                        this.A0A.A02(EnumC0936Ja.A0L, null);
                        this.A08.A0D().A4t(poll.A00);
                    }
                }
            }
        }
        String[] strArr = A0L;
        if (strArr[0].charAt(13) == strArr[7].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[2] = "zGpus9wW0BJIjoljGX";
        strArr2[3] = "A1e8XSvn3Bv6Tp7Ifd";
    }

    private synchronized void A0G(C1069Ok c1069Ok) {
        this.A0I.offer(c1069Ok);
        A0F();
    }

    private boolean A0I() {
        return !A0J();
    }

    private boolean A0J() {
        return JD.A1x(this.A08, QJ.A03());
    }

    public final C0937Jb A0L() {
        return this.A0A;
    }

    public final C1009Lz A0M() {
        return this.A0B;
    }

    public final S4 A0N() {
        return this.A0D;
    }

    @Nullable
    public final String A0O() {
        return this.A0J.get();
    }

    public final void A0P() {
        A0G(new C1069Ok(A0B(22, 26, 102), new String[]{this.A0H}));
    }

    public final void A0Q() {
        A0G(new C1069Ok(A0B(48, 25, 3), new String[]{this.A0H}));
    }

    public final void A0R() {
        this.A05 = true;
    }

    public final void A0S() {
        this.A05 = false;
    }

    public final void A0T() {
        A0G(new C1069Ok(A0B(98, 23, 53), new String[]{this.A0H}));
    }

    public final void A0U() {
        A0G(new C1069Ok(A0B(292, 22, 101), new String[]{this.A0H}));
    }

    public final void A0V() {
        A0G(new C1069Ok(A0B(121, 24, 84), new String[]{this.A0H}));
    }

    public final void A0W(InterfaceC1070Ol interfaceC1070Ol) {
        this.A01 = interfaceC1070Ol;
    }

    public final void A0X(InterfaceC1071Om interfaceC1071Om) {
        this.A02 = interfaceC1071Om;
    }

    public final void A0Y(S3 s3) {
        this.A0E.A0L(s3);
    }

    public final void A0Z(@Nullable QZ qz) {
        this.A03 = qz;
    }

    public final void A0a(String str) {
        A0G(new C1069Ok(A0B(175, 27, 73), new String[]{this.A0H, str}));
    }

    public final void A0b(String str, String str2) {
        A0G(new C1069Ok(A0B(BuildConfig.VERSION_CODE, 30, 21), new String[]{this.A0H, str, str2}));
    }

    public final void A0c(String str, JSONObject jSONObject) {
        A0G(new C1069Ok(A0B(263, 29, 27), new String[]{this.A0H, str, jSONObject.toString()}, false));
    }

    public final void A0d(Map<String, String> map) {
        this.A09.A8p(this.A06.A0Q(), new C1055Nu(map).A03(this.A03).A05());
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void A0e(boolean z) {
        String str;
        int attachedDynamicAdViews;
        if (Build.VERSION.SDK_INT > 16) {
            this.A0D.addJavascriptInterface(this.A0E, A0B(6, 16, 78));
        }
        C0937Jb c0937Jb = this.A0A;
        EnumC0936Ja enumC0936Ja = EnumC0936Ja.A0O;
        String[] strArr = A0L;
        if (strArr[2].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[0] = "xUzOvs22CfktfeCCcYWx46fXBHS31rah";
        strArr2[7] = "foKCfE4j78jeFbkV7IcjWafsYMWx62Vp";
        c0937Jb.A02(enumC0936Ja, null);
        if (z) {
            str = this.A0F.A01;
            this.A00 = System.currentTimeMillis();
            this.A0D.loadUrl(str);
        } else {
            str = this.A0F.A00;
            this.A0D.loadUrl(str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A0B(260, 3, 21), str);
            jSONObject.put(A0B(86, 12, 106), C1073Oo.A00());
            jSONObject.put(A0B(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 10, 37), A0M.getAndIncrement());
            String A0B = A0B(73, 13, 65);
            if (z) {
                attachedDynamicAdViews = C06999f.getAttachedDynamicAdViews();
            } else {
                attachedDynamicAdViews = C06949a.getAttachedDynamicAdViews();
            }
            jSONObject.put(A0B, attachedDynamicAdViews);
        } catch (JSONException unused) {
        }
        String funnelMessage = jSONObject.toString();
        this.A08.A0D().A4z(funnelMessage);
        A0D();
    }

    public final boolean A0f() {
        return this.A0E.A0M();
    }

    public final boolean A0g() {
        return this.A05;
    }
}
