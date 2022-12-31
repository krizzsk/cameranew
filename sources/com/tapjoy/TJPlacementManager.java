package com.tapjoy;

import android.content.Context;
import com.tapjoy.internal.az;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.he;
import com.tapjoy.internal.jq;
/* loaded from: classes3.dex */
public class TJPlacementManager {
    private static final az a = az.a();
    private static int b = 0;
    private static int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f7245d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static int f7246e = 3;

    public static TJPlacement a(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (a) {
            tJPlacement = new TJPlacement(a(str, str2, str3, false, false), tJPlacementListener);
        }
        return tJPlacement;
    }

    public static TJPlacement b(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (a) {
            tJPlacement = new TJPlacement(a(str, str2, str3, false, true), tJPlacementListener);
        }
        return tJPlacement;
    }

    public static boolean canCachePlacement() {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static TJPlacement createPlacement(Context context, String str, boolean z, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a2 = a(str, null, null, z, false);
        a2.f7222j = z;
        a2.c.setPlacementType("sdk");
        a2.setContext(context);
        return new TJPlacement(a2, tJPlacementListener);
    }

    public static void decrementPlacementCacheCount() {
        int i2 = b - 1;
        b = i2;
        if (i2 < 0) {
            b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementPreRenderCount() {
        int i2 = c - 1;
        c = i2;
        if (i2 < 0) {
            c = 0;
        }
    }

    public static void dismissContentShowing(boolean z) {
        if (z) {
            TJAdUnitActivity.a();
        }
        he.a();
        gv.a();
    }

    public static int getCachedPlacementCount() {
        return b;
    }

    public static int getCachedPlacementLimit() {
        return f7245d;
    }

    public static int getPreRenderedPlacementCount() {
        return c;
    }

    public static int getPreRenderedPlacementLimit() {
        return f7246e;
    }

    public static void incrementPlacementCacheCount() {
        int i2 = b + 1;
        b = i2;
        int i3 = f7245d;
        if (i2 > i3) {
            b = i3;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int i2 = c + 1;
        c = i2;
        int i3 = f7246e;
        if (i2 > i3) {
            c = i3;
        }
    }

    public static void printPlacementCacheInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available in placement cache: " + b + " out of " + f7245d);
    }

    public static void printPlacementPreRenderInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available for placement pre-render: " + c + " out of " + f7246e);
    }

    public static void setCachedPlacementLimit(int i2) {
        f7245d = i2;
    }

    public static void setPreRenderedPlacementLimit(int i2) {
        f7246e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TJCorePlacement a(String str) {
        TJCorePlacement tJCorePlacement;
        az azVar = a;
        synchronized (azVar) {
            tJCorePlacement = (TJCorePlacement) azVar.get(str);
        }
        return tJCorePlacement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TJCorePlacement a(String str, String str2, String str3, boolean z, boolean z2) {
        TJCorePlacement a2;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "!SYSTEM!" : "");
        sb.append(!jq.c(str) ? str : "");
        if (jq.c(str2)) {
            str2 = "";
        }
        sb.append(str2);
        if (jq.c(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(Boolean.toString(z2));
        String sb2 = sb.toString();
        TapjoyLog.d("TJPlacementManager", "TJCorePlacement key=" + sb2);
        az azVar = a;
        synchronized (azVar) {
            a2 = a(sb2);
            if (a2 == null) {
                a2 = new TJCorePlacement(str, sb2, z2);
                azVar.put(sb2, a2);
                TapjoyLog.d("TJPlacementManager", "Created TJCorePlacement with GUID: " + a2.f7216d);
            }
        }
        return a2;
    }
}
