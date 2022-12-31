package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ThreadSafe
@SuppressLint({"StaticFieldLeak"})
/* renamed from: com.facebook.ads.redexgen.X.62  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass62 {
    public static EnumC06366l A06;
    public static byte[] A07;
    public static String[] A08 = {"eZKmHpMMDfaoBqW8nqrxEoXtMavqlqNM", "AtFM24PyHDF8", "75v22abHTVt154frUD1Ye4KyqdVteY4i", "Q1X3dzo1KUJ0DHl8HY6jDpMlStfBjogW", "z2ZYiDayfErc", "35EgzrmLPkhoCqMLba9eqfKFMV7fawsP", "opJsobvHgIMCHkez4yG45JKspLs2PehX", "oVaFSOpmfGo5v5TJJzClDpDAWRdHWsbi"};
    public static final AtomicReference<AnonymousClass62> A09;
    public AnonymousClass64 A00;
    public C6W A01;
    public final Context A02;
    public final AnonymousClass61 A03;
    public final AtomicReference<C6H> A04 = new AtomicReference<>();
    public final AtomicReference<C1407ad> A05 = new AtomicReference<>();

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{99, 101, 116, Byte.MAX_VALUE, 25, 20, 92, 90, 114, 109, 113};
    }

    static {
        A01();
        A09 = new AtomicReference<>();
    }

    public AnonymousClass62(Context context, AnonymousClass61 anonymousClass61, EnumC06366l enumC06366l) {
        this.A02 = context;
        this.A03 = anonymousClass61;
        this.A01 = new C6W(this.A02, this.A03);
        if (this.A04.get() == null && AnonymousClass78.A0E(enumC06366l)) {
            A02(enumC06366l);
        }
    }

    private synchronized void A02(EnumC06366l enumC06366l) {
        if (this.A04.get() == null) {
            C6D.A02(this.A03.A0Z());
            C1407ad c1407ad = new C1407ad(this.A03, this.A01);
            this.A05.set(c1407ad);
            this.A00 = new AnonymousClass64();
            this.A00.A00(c1407ad);
            if (this.A01.A06() && AnonymousClass78.A0E(enumC06366l)) {
                c1407ad.A05(enumC06366l);
            }
            A06 = enumC06366l;
            this.A00.A01(enumC06366l);
            this.A04.set(C6H.A00(this.A02, this.A03));
        }
    }

    private boolean A03(EnumC06366l enumC06366l) {
        if (AnonymousClass78.A0E(enumC06366l)) {
            A02(enumC06366l);
        }
        if (enumC06366l.equals(A06)) {
            return false;
        }
        A06 = enumC06366l;
        AnonymousClass64 anonymousClass64 = this.A00;
        if (anonymousClass64 != null) {
            anonymousClass64.A01(enumC06366l);
        }
        if (A08[0].charAt(4) != 't') {
            A08[2] = "al3lqCaa3X6BhafyoLSdmdZ2qZ9PyUcx";
            return true;
        }
        throw new RuntimeException();
    }

    private boolean A04(String str, EnumC06406p enumC06406p) {
        if (!AnonymousClass78.A0E(A06) || this.A04.get() == null) {
            return false;
        }
        C6W c6w = this.A01;
        if (c6w != null) {
            c6w.A05(EnumC06386n.A02, A06, str, enumC06406p);
            return true;
        }
        return true;
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A05(MotionEvent motionEvent) {
        try {
            if (this.A04.get() == null) {
                return;
            }
            this.A04.get().A05(motionEvent);
        } catch (Throwable th) {
            C6D.A03(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized boolean A06(String str) {
        JSONObject jSONObject;
        EnumC06406p enumC06406p;
        String string;
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str).getJSONObject(A00(0, 2, 69));
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    C6D.A03(th);
                }
                if (jSONObject != null) {
                    r7 = jSONObject.has(A00(6, 2, 106)) ? false | A03(EnumC06366l.A00(jSONObject.getInt(A00(6, 2, 106)))) : false;
                    JSONArray jSONArray = jSONObject.getJSONArray(A00(2, 2, 83));
                    if (jSONObject.has(A00(8, 3, 69))) {
                        enumC06406p = EnumC06406p.A00(jSONObject.getInt(A00(8, 3, 69)));
                    } else {
                        enumC06406p = EnumC06406p.A04;
                    }
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has(A00(4, 2, 52)) && (string = jSONObject2.getString(A00(4, 2, 52))) != null && !string.isEmpty()) {
                            AnonymousClass78.A0B(this.A03, AnonymousClass68.A04.A02(), string);
                            r7 |= A04(string, enumC06406p);
                        }
                    }
                    return r7;
                }
                return false;
            }
        }
        return false;
    }
}
