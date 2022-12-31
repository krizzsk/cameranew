package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6z  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC06506z<T> {
    public static byte[] A04;
    public static String[] A05 = {"IPzGtGdAf7dMWjoiAfsJwT8MSbfW", "XMCeZkZyu3cdrivUr2jZRBASAtioBKsk", "M9df3TmYW4NVaJXwV617xCLf0ka0RL", "QgNQyFbsObpuCkNzfa3XkTwr8fWterHM", "OM6XrXF8htknNzzoWXy", "2umg9hNEEJctkPlZR8BXtgIxIwG9FY0j", "MjJVouBCVmg2kVwWDhDqrlmadtoLZ7M", "22y3hOnyLMExHbJepmdK5jKs80KnwphC"};
    public static final String A06;
    public final long A00;
    @Nullable
    public final C06486x A01;
    public final EnumC06496y A02;
    public final T A03;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{105, 126, 114, 40, 124};
    }

    public abstract int A06() throws Exception;

    public abstract JSONObject A08(JSONObject jSONObject) throws JSONException;

    public abstract boolean A0A(AbstractC06506z<T> abstractC06506z);

    static {
        A04();
        A06 = AbstractC06506z.class.getSimpleName();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public AbstractC06506z(long j2, @Nullable C06486x c06486x, T signalValue, EnumC06496y enumC06496y) {
        this.A00 = j2;
        this.A01 = c06486x;
        this.A03 = signalValue;
        this.A02 = enumC06496y;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final long A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @Nullable
    private final C06486x A01() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    private final EnumC06496y A02() {
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @SuppressLint({"CatchGeneralException"})
    public final int A05() {
        int length = (A01() != null ? A01().A02().getBytes().length : 0) + 8;
        try {
            return A06() + length;
        } catch (Exception e2) {
            C6D.A03(e2);
            return length;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public final T A07() {
        return this.A03;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public final JSONObject A09(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put(A03(4, 1, 2), ((float) this.A00) / 1000.0f);
            } catch (Throwable th) {
                C6D.A03(th);
            }
        }
        if (this.A01 != null && z) {
            jSONObject.put(A03(0, 3, 0), this.A01.A03());
        }
        if (this.A02 != EnumC06496y.A04 && A07() != null) {
            A08(jSONObject);
        } else {
            EnumC06496y enumC06496y = this.A02;
            EnumC06496y enumC06496y2 = EnumC06496y.A04;
            if (A05[7].charAt(6) != 'n') {
                throw new RuntimeException();
            }
            A05[7] = "j6hvLenmhks7DifvzYp6ZMm4s1P7WZuQ";
            String A03 = A03(3, 1, 71);
            if (enumC06496y == enumC06496y2) {
                jSONObject.put(A03, ((C06476w) this.A03).A08());
            } else if (this.A03 == null) {
                jSONObject.put(A03, new C06476w(EnumC06466v.A07).A08());
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<T> */
    public final boolean A0B(@Nullable AbstractC06506z<T> abstractC06506z, EnumSet<EnumC06396o> enumSet) {
        long A08;
        if (abstractC06506z == null || A02() != abstractC06506z.A02()) {
            return false;
        }
        if (A02() == EnumC06496y.A04 && abstractC06506z.A02() == EnumC06496y.A04) {
            return A0A(abstractC06506z);
        }
        boolean z = false;
        if (enumSet.contains(EnumC06396o.A0E)) {
            z = A0A(abstractC06506z);
        }
        if (enumSet.contains(EnumC06396o.A0C)) {
            z &= (A01() == null || abstractC06506z.A01() == null || !A01().A02().equals(abstractC06506z.A01().A02())) ? false : true;
        }
        if (enumSet.contains(EnumC06396o.A0D)) {
            if (A02() == EnumC06496y.A0D || A02() == EnumC06496y.A0B) {
                A08 = AnonymousClass61.A08();
            } else {
                A08 = AnonymousClass61.A09();
            }
            long epsilon = Math.abs(this.A00 - abstractC06506z.A00());
            return z & (epsilon < A08);
        }
        return z;
    }
}
