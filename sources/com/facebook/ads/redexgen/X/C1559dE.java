package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.dE  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1559dE implements C0R {
    public static byte[] A07;
    public static String[] A08 = {"nHMpSWMsnsV7ze4k7TMdpo8w7eAhh5yl", "NZIGXtqvLJqJvnsqDFZQPtZx", "Ad1TvQCscaWcF7stMWLl9lRlqQAvL", "Ujq4dS9mEeqxvShJwD8UISSMYbM", "6D9", "oL3lqgBhSNj2gXyheQdgS3kbnnn96fNg", "3X2AVVUyUAfxSvaFg1Rh03BQkiDduKF9", "x5OfLFoNyht1tsSSgvPC5bYcCNR"};
    public final C1557dC A00;
    public final AtomicReference<String> A05 = new AtomicReference<>();
    public final AtomicReference<String> A04 = new AtomicReference<>();
    public final AtomicReference<String> A03 = new AtomicReference<>();
    public final AtomicReference<EnumC04740c> A06 = new AtomicReference<>();
    public final UUID A01 = UUID.randomUUID();
    public final AtomicInteger A02 = new AtomicInteger(1);

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{5, 22, Draft_75.CR, Draft_75.CR, 6, 15, 60, 109, 126, 101, 101, 110, 103, 84, 120, 110, 122};
        String[] strArr = A08;
        if (strArr[7].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        A08[2] = "yQ17NavN7ZSoq7zHySEgN4tR7loqT";
    }

    static {
        A01();
    }

    public C1559dE(C1557dC c1557dC) {
        this.A00 = c1557dC;
    }

    private void A02(int i2, String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A00(0, 7, 60) + C0X.A0O.getName(), str);
            } catch (JSONException unused) {
            }
            A03(jSONObject);
            this.A00.A00().A94(i2, jSONObject);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    private final void A03(JSONObject jSONObject) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            try {
                jSONObject.put(A00(7, 10, 84), this.A02.getAndIncrement());
            } catch (JSONException unused) {
            }
            C0X.A0F.A05(this.A01).A02(jSONObject);
            String str = this.A05.get();
            if (!TextUtils.isEmpty(str)) {
                C0X.A0R.A05(str).A02(jSONObject);
            }
            String str2 = this.A04.get();
            if (!TextUtils.isEmpty(str2)) {
                C0X.A0Q.A05(str2).A02(jSONObject);
            }
            String str3 = this.A03.get();
            if (!TextUtils.isEmpty(str3)) {
                C0X.A0P.A05(str3).A02(jSONObject);
            }
            EnumC04740c enumC04740c = this.A06.get();
            if (enumC04740c != null) {
                C0X.A0E.A05(enumC04740c).A02(jSONObject);
            }
        } catch (Throwable th) {
            String placementType = A08[2];
            if (placementType.length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[7] = "UnqhnC2RP1s6q9DMOMPvS7zFM4J";
            strArr[3] = "fX0qBiaLsOBwY7ffp1ojH1RHxSy";
            C0974Kn.A00(th, this);
        }
    }

    public final void A04(C0T c0t, C0W... c0wArr) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (C0W c0w : c0wArr) {
                c0w.A02(jSONObject);
            }
            A03(jSONObject);
            this.A00.A00().A8s(c0t, jSONObject);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2Q(String str, int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0R, C0X.A0H.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2R(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0S, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2S(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0T, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2T(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0U, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2U(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0V, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2V(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0W, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2W(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0X, C0X.A0L.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2X() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0i, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2Y() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0v, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2Z(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0Z, C0X.A02.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2a(long j2, int i2, String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0x, C0X.A0G.A05(Integer.valueOf(i2)), C0X.A0M.A05(str), C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2b() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0z, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2c() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0y, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2d() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A10, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2e(long j2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A11, C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2f(C0Q c0q) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2E, C0X.A01.A05(c0q));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2g(String str, String str2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A04.set(str);
            this.A03.set(str2);
            A04(C0T.A0a, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2h() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0b, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2i() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0c, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2j(long j2, int i2, @Nullable String str, boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0d, C0X.A0K.A05(Long.valueOf(j2)), C0X.A0G.A05(Integer.valueOf(i2)), C0X.A0M.A05(str), C0X.A0A.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2k(long j2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0e, C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2l(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A18, C0X.A0D.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A08[6] = "gK8mXYwR0ckPpFtcTSNh6868pPwacmBZ";
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2m() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A19, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2n() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1E, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2o() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1F, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2p() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1G, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2q(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1H, C0X.A0H.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2r() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1I, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2s() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1L, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2t() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1J, new C0W[0]);
        } catch (Throwable th) {
            if (A08[6].charAt(19) != 'h') {
                throw new RuntimeException();
            }
            A08[6] = "TXE2cMU86vxtF7wI18ThzZXaU0uTRMLS";
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2u(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1K, C0X.A0H.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2v() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1M, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2w(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1N, C0X.A0O.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2x() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1O, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2y() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1P, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A2z() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1Q, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A30() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1R, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A31(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1S, C0X.A0H.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A32() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1T, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A33(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1U, C0X.A0H.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A34() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2G, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[4].length() != 3) {
                throw new RuntimeException();
            }
            A08[6] = "VZoNBueTz9dHgRCK2oHhqd2tucTd08Xg";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A35() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2H, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A36(C0Q c0q) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2D, C0X.A01.A05(c0q));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A37(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2F, C0X.A0I.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A38() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2I, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3t(long j2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0g, C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[0].charAt(15) != 'k') {
                throw new RuntimeException();
            }
            A08[1] = "iGvSb1Hz3BIwYRP6JXvlZVW4";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3u(long j2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0h, C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A3z() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0j, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4U() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0k, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4V() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0o, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4W(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0f, C0X.A09.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            if (A08[1].length() == 19) {
                throw new RuntimeException();
            }
            A08[5] = "sws4bQbg9GprWoTPEe05ZlT1gMn94mHS";
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4X(int i2, String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0p, C0X.A0G.A05(Integer.valueOf(i2)), C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4Y(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0n, C0X.A04.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4Z() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0r, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4a() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0s, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4b() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0t, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4c() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A0u, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4s() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1X, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4t(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1Y, C0X.A0O.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4u() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1Z, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4v() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1a, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4w() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1b, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4x(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1c, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4y(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1d, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A4z(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1e, C0X.A0O.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A50(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1g, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A51() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1h, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A52(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1i, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A53(long j2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1j, C0X.A0K.A05(Long.valueOf(j2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A54(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1k, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A80() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1l, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A81(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1m, C0X.A08.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A82() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1n, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A83(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1o, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A84() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1p, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A85() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1q, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A86(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1r, C0X.A0N.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A8o(int i2, String str) {
        if (C0974Kn.A02(this) || i2 < 11000 || i2 > 11099) {
            return;
        }
        try {
            A02(i2, str);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9R(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A12, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9S(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A13, C0X.A0I.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[4].length() != 3) {
                throw new RuntimeException();
            }
            A08[1] = "n4mJfQKCjkVGyNTXc44lq1NfZCr";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9T() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1u, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9U() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1v, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9V() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1w, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void A9X() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A14, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[5].charAt(28) == 'u') {
                throw new RuntimeException();
            }
            A08[0] = "A3lONLTCXWx4KhpkbRCT5RNlo5C8otzX";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADQ(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A16, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADR() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A17, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADu() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A23, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADv() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A24, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADw() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A26, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADx() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A27, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADy() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A28, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            String[] strArr = A08;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A08[0] = "8D0tcue5j6RyJlSkx73RNPFkP16S30Kf";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void ADz() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A29, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE0() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2A, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AE1() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2B, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEV(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A05.set(str);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AEX(EnumC04740c enumC04740c) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A06.set(enumC04740c);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFB() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1B, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFF() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2J, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFG(int i2, String str) {
        if (C0974Kn.A02(this) || i2 < 12000 || i2 > 12099) {
            return;
        }
        try {
            A02(i2, str);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFH() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2K, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFI() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2L, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFJ() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2M, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFK(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2N, C0X.A03.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFL() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2O, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFM() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2P, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFN(int i2, @Nullable String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2Q, C0X.A0G.A05(Integer.valueOf(i2)), C0X.A0M.A05(str));
        } catch (Throwable th) {
            if (A08[0].charAt(15) != 'k') {
                throw new RuntimeException();
            }
            A08[2] = "2PKYVe8Qgwv7j3CDJ6bxblARvZgyh";
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFO(boolean z) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2R, C0X.A07.A05(Boolean.valueOf(z)));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFP() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2S, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFQ(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2T, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFR(int i2, String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2U, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[6].charAt(19) != 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[7] = "5qwGvT3tjlGxlYjcZrXYRuOycIv";
            strArr[3] = "UEyDz1QZjBltnQnS2IeC3S3ns7y";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFS() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2V, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFT(int i2) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A2W, C0X.A0J.A05(Integer.valueOf(i2)));
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A08[2] = "bm6dbMytZvpqzg8D3QKVLEJHQj3Ec";
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFY(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1V, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void AFZ(String str) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1W, C0X.A0M.A05(str));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A08[1].length() == 19) {
                throw new RuntimeException();
            }
            A08[5] = "ivuB5Sydf2jbsPKu7So7nbx7xRGWOHbH";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final String getId() {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return this.A01.toString();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0R
    public final void unregisterView() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A04(C0T.A1A, new C0W[0]);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
