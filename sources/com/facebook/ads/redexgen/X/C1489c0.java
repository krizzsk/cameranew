package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.c0  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1489c0 implements InterfaceC1000Lq<Bundle> {
    public static byte[] A04;
    public AnonymousClass29 A00;
    public final View A01;
    public final XT A02;
    public final List<C1488bz> A03;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{126, 121, 108, 121, 100, 126, 121, 100, 110, 126, 106, 123, 109, 106, 109};
    }

    public C1489c0(View view, List<AnonymousClass27> list, Bundle bundle, XT xt) {
        this.A02 = xt;
        this.A01 = view;
        this.A03 = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 15));
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.A03.add(new C1488bz(list.get(i2), (Bundle) parcelableArrayList.get(i2)));
        }
        this.A00 = (AnonymousClass29) C0994Lk.A00(bundle.getByteArray(A00(0, 10, 28)));
    }

    public C1489c0(View view, List<AnonymousClass27> list, XT xt) {
        this.A02 = xt;
        this.A01 = view;
        this.A03 = new ArrayList(list.size());
        for (AnonymousClass27 anonymousClass27 : list) {
            this.A03.add(new C1488bz(anonymousClass27));
        }
        this.A00 = new AnonymousClass29();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 28), C0994Lk.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A03.size());
        for (C1488bz c1488bz : this.A03) {
            arrayList.add(c1488bz.A05());
        }
        bundle.putParcelableArrayList(A00(10, 5, 15), arrayList);
        return bundle;
    }

    public final AnonymousClass29 A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        for (C1488bz test : this.A03) {
            test.A06();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double viewableRatio, double d2) {
        if (d2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.A00.A05(viewableRatio, d2);
        }
        double A00 = QZ.A0E(this.A01, 0, this.A02).A00();
        this.A00.A04(viewableRatio, A00);
        for (C1488bz c1488bz : this.A03) {
            c1488bz.A07(viewableRatio, A00);
        }
    }
}
