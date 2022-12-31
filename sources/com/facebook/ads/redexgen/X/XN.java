package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public final class XN implements C8Y {
    public static byte[] A03;
    public static String[] A04 = {"D3PJ2GNcgNGI4MtKfCaHjqEOfdHoPcVQ", "EJL0aGmI3i0Imoz4UWgpTxwTxGm9WRxT", "tfWCUNw0WGkvc5ldnWfg2BDK3aY0ceq2", "VYnzwe", "FWw4Dif8pFGferaZg4Cc6MDYh6zRU5", "BYQArfMrHiqwTG3fAjpcYjBOCFZN2nO4", "ZJiZak5asVL", "k4pPkd4ODWsyAa7ylPFb6IMORyuDH4"};
    public Context A00;
    public final AtomicBoolean A02 = new AtomicBoolean(false);
    @Nullable
    public C8X A01 = A00();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{107, 110, 123, 110, 112, Byte.MAX_VALUE, 125, 96, 108, 106, 124, 124, 102, 97, 104, 112, 96, Byte.MAX_VALUE, 123, 102, 96, 97, 124, 112, 108, 96, 122, 97, 123, 125, 118, 112, 100, 106, 118, 1, 4, 17, 4, 26, 21, 23, 10, 6, 0, 22, 22, 12, 11, 2, 26, 10, 21, 17, 12, 10, 11, 22, 26, 14, 0, 28, 106, 111, 122, 111, 113, 126, 124, 97, 109, 107, 125, 125, 103, 96, 105, 113, 97, 126, 122, 103, 97, 96, 125, 113, 125, 122, 111, 122, 107, 113, 101, 107, 119, 14, 26, 5, 21, 25, 15, 30, 30, 3, 4, Draft_75.CR, 25, 21, 1, 15, 19};
    }

    static {
        A03();
    }

    public XN(Context context) {
        this.A00 = context;
    }

    @Nullable
    private C8X A00() {
        return C8X.A00(C0967Kg.A00(this.A00).getString(A01(95, 16, 52), null));
    }

    private void A02() {
        String[] stringArray;
        Integer integer;
        Integer country;
        if (!AdInternalSettings.sDataProcessingOptionsUpdate.getAndSet(false)) {
            return;
        }
        synchronized (AdInternalSettings.sSettingsBundle) {
            stringArray = AdInternalSettings.sSettingsBundle.getStringArray(A01(35, 27, 59));
            integer = AdInternalSettings.sSettingsBundle.getInteger(A01(0, 35, 81));
            country = AdInternalSettings.sSettingsBundle.getInteger(A01(62, 33, 80));
        }
        A04(stringArray, integer, country);
    }

    public final void A04(@Nullable String[] strArr, @Nullable Integer num, @Nullable Integer num2) {
        C8X c8x = new C8X(strArr, num, num2);
        if (c8x.equals(this.A01)) {
            return;
        }
        this.A01 = c8x;
        this.A02.set(true);
        SharedPreferences A00 = C0967Kg.A00(this.A00);
        if (A04[2].charAt(16) != 'n') {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[7] = "txsFPtaRD11LyA3dzoyK5U0Vbdrctz";
        strArr2[4] = "NLpqiEYsaOJ6LGl2A1qehjxsg53G43";
        A00.edit().putString(A01(95, 16, 52), this.A01.A07()).apply();
    }

    @Override // com.facebook.ads.redexgen.X.C8Y
    @Nullable
    public final C8X A6G() {
        A02();
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.C8Y
    public final boolean A8V() {
        A02();
        if (this.A01 == null) {
            return false;
        }
        Set<String> A0X = JD.A0X(this.A00);
        String A07 = this.A01.A07();
        for (String str : A0X) {
            if (A07.contains(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C8Y
    public final boolean AEa() {
        A02();
        return this.A02.getAndSet(false);
    }
}
