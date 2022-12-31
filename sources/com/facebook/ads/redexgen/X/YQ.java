package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class YQ extends C06266b {
    public static byte[] A07;
    public static final String A08;
    public final Context A00;
    @Nullable
    public final PackageInfo A01;
    @Nullable
    public final PackageManager A02;
    public final AnonymousClass61 A03;
    @Nullable
    public final ActivityInfo[] A04;
    @Nullable
    public final ServiceInfo[] A05;
    @Nullable
    public final String[] A06;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{29, 57, 35, 35, 57, 62, 55, 112, 0, 49, 51, 59, 49, 55, 53, 112, 0, 53, 34, 61, 57, 35, 35, 57, 63, 62, 35};
    }

    static {
        A07();
        A08 = YQ.class.getSimpleName();
    }

    public YQ(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = context;
        this.A03 = anonymousClass61;
        this.A01 = A02(context);
        this.A02 = context.getPackageManager();
        this.A04 = A08(context);
        this.A05 = A0A(context);
        this.A06 = A0C(context);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private PackageInfo A02(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ActivityInfo[] A08(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ServiceInfo[] A0A(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private String[] A0C(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    public final InterfaceC06356k A0G() {
        return new YS(this);
    }

    public final InterfaceC06356k A0H() {
        return new YT(this);
    }

    public final InterfaceC06356k A0I() {
        return new YR(this);
    }

    public final InterfaceC06356k A0J() {
        return new YU(this);
    }

    public final InterfaceC06356k A0K() {
        return new YZ(this);
    }

    public final InterfaceC06356k A0L() {
        return new C1319Yd(this);
    }

    public final InterfaceC06356k A0M() {
        return new YY(this);
    }

    public final InterfaceC06356k A0N() {
        return new YV(this);
    }

    public final InterfaceC06356k A0O() {
        return new YX(this);
    }

    public final InterfaceC06356k A0P() {
        return new YW(this);
    }

    public final InterfaceC06356k A0Q() {
        return new C1316Ya(this);
    }

    public final InterfaceC06356k A0R() {
        return new C1317Yb(this);
    }

    public final InterfaceC06356k A0S() {
        return new C1318Yc(this);
    }

    public final InterfaceC06356k A0T() {
        return new C1321Yf(this);
    }

    public final InterfaceC06356k A0U() {
        return new C1322Yg(this);
    }

    public final InterfaceC06356k A0V() {
        return new C1320Ye(this);
    }

    public final InterfaceC06356k A0W() {
        return new C1324Yi(this);
    }

    public final InterfaceC06356k A0X() {
        return new C1325Yj(this);
    }

    public final InterfaceC06356k A0Y() {
        return new C1323Yh(this);
    }
}
