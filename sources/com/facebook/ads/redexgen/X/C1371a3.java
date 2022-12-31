package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.a3  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1371a3 extends C06266b {
    public final Context A00;
    public final ApplicationInfo A01;
    public final AnonymousClass61 A02;
    public final AnonymousClass74 A03;

    public C1371a3(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A01 = context.getApplicationInfo();
        this.A00 = context;
        this.A02 = anonymousClass61;
        this.A03 = AnonymousClass74.A00(this.A00, this.A02.A0a(), this.A02.A0g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A05(HashMap<Integer, C1372a4> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A06);
    }

    public final InterfaceC06356k A0G() {
        return new C1382aE(this);
    }

    public final InterfaceC06356k A0H() {
        return new C1384aG(this);
    }

    public final InterfaceC06356k A0I() {
        return new C1385aH(this);
    }

    public final InterfaceC06356k A0J() {
        return new C1389aL(this);
    }

    public final InterfaceC06356k A0K() {
        return new C1377a9(this);
    }

    public final InterfaceC06356k A0L() {
        return new C1374a6(this);
    }

    public final InterfaceC06356k A0M() {
        return new C1381aD(this);
    }

    public final InterfaceC06356k A0N() {
        return new C1380aC(this);
    }

    public final InterfaceC06356k A0O() {
        return new C1376a8(this);
    }

    public final InterfaceC06356k A0P() {
        return new C1373a5(this);
    }

    public final InterfaceC06356k A0Q() {
        return new C1375a7(this);
    }

    public final InterfaceC06356k A0R() {
        return new C1378aA(this);
    }

    public final InterfaceC06356k A0S() {
        return new C1379aB(this);
    }

    public final InterfaceC06356k A0T() {
        return new C1391aN(this);
    }

    public final InterfaceC06356k A0U() {
        return new C1390aM(this);
    }

    public final InterfaceC06356k A0V() {
        return new C1388aK(this);
    }

    public final InterfaceC06356k A0W() {
        return new C1387aJ(this);
    }

    public final InterfaceC06356k A0X() {
        return new C1386aI(this);
    }

    public final InterfaceC06356k A0Y() {
        return new C1383aF(this);
    }
}
