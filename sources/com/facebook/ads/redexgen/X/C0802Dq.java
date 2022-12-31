package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Lock;
/* renamed from: com.facebook.ads.redexgen.X.Dq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0802Dq extends XP<String> {
    public static byte[] A08;
    public static String[] A09 = {"l", "T0JdG9ZEnLfTeCeftC9G7d8cUsVG3XZb", "aLcPLzyPnyiGnlL0eBnocVG2Im", "W3EwFUE7CvVeZV", "t2q4fu0Y0bIBimY2SigNyotMmunbmEsF", "TUpEXXUjgi8xLksArOVlucAVZCM", "AqOn5F5Mae0spU5kh0gbanyLcs", "chqW8UrgIl8Ef4OOKimE4h"};
    public final /* synthetic */ double A00;
    public final /* synthetic */ double A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ C8S A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ String A05;
    public final /* synthetic */ String A06;
    public final /* synthetic */ Map A07;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{-112, -115, -96, -115, -114, -115, -97, -111};
    }

    static {
        A02();
    }

    public C0802Dq(C8S c8s, String str, String str2, int i2, double d2, double d3, String str3, Map map) {
        this.A03 = c8s;
        this.A06 = str;
        this.A05 = str2;
        this.A02 = i2;
        this.A01 = d2;
        this.A00 = d3;
        this.A04 = str3;
        this.A07 = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C8V
    @Nullable
    /* renamed from: A00 */
    public final String A03() {
        XS xs;
        Lock lock;
        XS xs2;
        Lock lock2;
        XS xs3;
        Lock lock3;
        XS xs4;
        XR xr;
        XQ xq;
        XS xs5;
        Lock lock4;
        String A01 = A01(0, 8, 12);
        xs = this.A03.A01;
        xs.A06().A87(this.A06);
        if (TextUtils.isEmpty(this.A05)) {
            return null;
        }
        lock = C8S.A08;
        lock.lock();
        String[] strArr = A09;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[1] = "mqnyRlomjFPPGlBu5iJ3A4HRnrnsorAH";
        strArr2[4] = "vLAqNnzkqKgbXCY8NZfbbPBhHyGRm9s6";
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.A03.A0E();
                sQLiteDatabase.beginTransaction();
                xr = this.A03.A02;
                xq = this.A03.A03;
                String A0E = xr.A0E(xq.A0C(this.A05), this.A02, this.A06, this.A01, this.A00, this.A04, this.A07);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase.isOpen()) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e2) {
                        xs5 = this.A03.A01;
                        xs5.A06().A8q(A01, C06808m.A0q, new C06818n(e2));
                    }
                }
                lock4 = C8S.A08;
                String[] strArr3 = A09;
                String str = strArr3[0];
                String eventId = strArr3[3];
                if (str.length() != eventId.length()) {
                    String[] strArr4 = A09;
                    strArr4[6] = "euwrYX6ZBvkkPfbLG6LTpx3NDj";
                    strArr4[2] = "qLYaMtYi2WKu9oTuT6ElhKmpF4";
                    lock4.unlock();
                    return A0E;
                }
                throw new RuntimeException();
            } catch (Exception e3) {
                A01(C8U.A06);
                xs2 = this.A03.A01;
                xs2.A06().A8q(A01, C06808m.A0p, new C06818n(e3));
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e4) {
                        xs3 = this.A03.A01;
                        xs3.A06().A8q(A01, C06808m.A0q, new C06818n(e4));
                    }
                }
                lock2 = C8S.A08;
                lock2.unlock();
                return null;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e5) {
                    xs4 = this.A03.A01;
                    xs4.A06().A8q(A01, C06808m.A0q, new C06818n(e5));
                }
            }
            lock3 = C8S.A08;
            lock3.unlock();
            throw th;
        }
    }
}
