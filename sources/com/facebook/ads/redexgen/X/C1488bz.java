package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1488bz implements InterfaceC1000Lq<Bundle> {
    public static byte[] A06;
    public static String[] A07 = {"SAMNpPFpITUhS5O2wArhouwTSBZGJm", "j9883o", "ez1Iu7S0g9Y3okmD0rAeLGMZx9C5J", "cx0ufmmqihH41YoN2BIvmgQC03N5OWKz", "xpotzx92kYS", "WaPg1x3uwEHiu", "28liF7Ug1fq7LT93Jkda", "DJaApxMs4P8Fw5vQM3hjBZIJlCayXT4o"};
    public AnonymousClass29 A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final AnonymousClass27 A04;
    public final AnonymousClass29 A05;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 7);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A06 = new byte[]{43, 39, 37, 56, 36, 45, 60, 45, 84, 95, 85, 84, 85, 21, 4, 22, 22, 0, 1, 100, 117, 99, 100, 67, 100, 113, 100, 99, 111, 112, 124, 110, 120, 123, 117, 124, 74, 109, 120, 109, 106};
    }

    static {
        A04();
    }

    public C1488bz(AnonymousClass27 anonymousClass27) {
        this.A02 = false;
        this.A03 = false;
        this.A01 = false;
        this.A04 = anonymousClass27;
        this.A05 = new AnonymousClass29(anonymousClass27.A01);
        this.A00 = new AnonymousClass29(anonymousClass27.A01);
    }

    public C1488bz(AnonymousClass27 anonymousClass27, Bundle bundle) {
        this.A02 = false;
        this.A03 = false;
        this.A01 = false;
        this.A04 = anonymousClass27;
        this.A05 = (AnonymousClass29) C0994Lk.A00(bundle.getByteArray(A00(19, 9, 23)));
        this.A00 = (AnonymousClass29) C0994Lk.A00(bundle.getByteArray(A00(28, 13, 30)));
        this.A02 = bundle.getBoolean(A00(8, 5, 54));
        this.A03 = bundle.getBoolean(A00(13, 6, 98));
        this.A01 = bundle.getBoolean(A00(0, 8, 79));
    }

    private void A01() {
        this.A01 = true;
        A02();
    }

    private void A02() {
        this.A02 = true;
        this.A04.A00(this.A01, this.A03, this.A03 ? this.A00 : this.A05);
    }

    private void A03() {
        this.A03 = true;
        A01();
    }

    public final Bundle A05() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(28, 13, 30), C0994Lk.A01(this.A00));
        bundle.putByteArray(A00(19, 9, 23), C0994Lk.A01(this.A05));
        bundle.putBoolean(A00(8, 5, 54), this.A02);
        bundle.putBoolean(A00(13, 6, 98), this.A03);
        bundle.putBoolean(A00(0, 8, 79), this.A01);
        return bundle;
    }

    public final void A06() {
        if (!this.A02) {
            this.A00.A03();
        }
    }

    public final void A07(double d2, double d3) {
        double A01;
        if (this.A02) {
            return;
        }
        AnonymousClass29 anonymousClass29 = this.A05;
        if (A07[5].length() != 13) {
            throw new RuntimeException();
        }
        A07[4] = "MN6YiANN1x8";
        anonymousClass29.A04(d2, d3);
        this.A00.A04(d2, d3);
        if (this.A04.A03) {
            A01 = this.A00.A00().A03();
        } else {
            A01 = this.A00.A00().A01();
        }
        if (this.A04.A00 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.A05.A00().A04() > this.A04.A00 && A01 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            A01();
        } else if (A01 >= this.A04.A02) {
            A03();
        }
    }
}
