package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.73  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass73 {
    public static byte[] A06;
    public static String[] A07 = {"aJ4yIqlrLMt", "EKTEccEpmR5675IOZ9lerUvwdG3ro5hY", "jTSIV3oRBrHoNrPkrRMeoeXpEd5JgTWm", "V52m2mthgbiWP0xFHXCG", "Wq", "BEItf56ADM92z1bkMxhlUdx7QMuMYd3L", "2Z", "ce4p6sp9ssAJXyOyOHhkkoq4sskZtb0W"};
    public int A00;
    public final Context A01;
    public final AnonymousClass61 A02;
    public final AnonymousClass70 A03;
    public final AnonymousClass71 A04;
    public final Set<C06326h> A05 = new HashSet();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "0R";
            strArr2[4] = "EB";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 50);
            i5++;
        }
    }

    public static void A02() {
        A06 = new byte[]{91, 77, 92, 100, 73, 91, 92, 120, 77, 90, 65, 71, 76, 65, 75, 107, 71, 68, 68, 77, 75, 92, 65, 71, 70, 124, 65, 69, 77, 101, 91};
    }

    static {
        A02();
    }

    public AnonymousClass73(Context context, AnonymousClass61 anonymousClass61) {
        this.A02 = anonymousClass61;
        this.A01 = context;
        this.A04 = anonymousClass61.A0c();
        this.A03 = anonymousClass61.A0b();
    }

    @Nullable
    private C06486x A00() {
        if (this.A02.A0a() == EnumC06396o.A0G) {
            return null;
        }
        Context context = this.A01;
        return new C06486x(context == null ? A01(0, 0, 58) : context.getPackageName());
    }

    @SuppressLint({"CatchGeneralException"})
    private void A03(long j2) {
        AbstractC06506z signalValueTypeDef;
        try {
            JSONObject jSONObject = new JSONObject();
            for (C06326h c06326h : this.A05) {
                InterfaceC06356k A01 = c06326h.A01();
                if (A01 == null) {
                    signalValueTypeDef = new C1298Xi(SystemClock.elapsedRealtime(), A00(), new C06476w(EnumC06466v.A04));
                } else {
                    signalValueTypeDef = A01.A5G();
                }
                jSONObject.put(Integer.toString(c06326h.A00()), signalValueTypeDef.A09(false));
            }
            Throwable t = new NullPointerException(A01(0, 31, 26));
            throw t;
        } catch (Throwable t2) {
            C6D.A03(t2);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private void A04(long j2) {
        try {
            this.A02.A0j().schedule(new Runnable() { // from class: com.facebook.ads.redexgen.X.72
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0974Kn.A02(this)) {
                        return;
                    }
                    try {
                        AnonymousClass73.this.A05();
                    } catch (Throwable th) {
                        C0974Kn.A00(th, this);
                    }
                }
            }, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            C6D.A03(th);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public final void A05() {
        if (this.A02.A0W() <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.A04.getLastPeriodicCollectionTimeMs() >= this.A02.A0W()) {
            A03(currentTimeMillis);
            A04(this.A02.A0W());
            return;
        }
        A04(Math.abs(currentTimeMillis - (this.A04.getLastPeriodicCollectionTimeMs() + this.A02.A0W())));
    }

    public final void A06(int i2) {
        this.A00 = i2;
    }

    public final void A07(C06326h c06326h) {
        this.A05.add(c06326h);
    }
}
