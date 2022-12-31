package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.model.p;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class CappingManager {

    /* loaded from: classes2.dex */
    public enum ECappingStatus {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PlacementCappingType.values().length];
            a = iArr;
            try {
                iArr[PlacementCappingType.PER_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PlacementCappingType.PER_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void a(Context context, com.ironsource.mediationsdk.model.h hVar) {
        synchronized (CappingManager.class) {
            if (context == null || hVar == null) {
                return;
            }
            p a2 = hVar.a();
            if (a2 == null) {
                return;
            }
            d(context, "Banner", hVar.c(), a2);
        }
    }

    public static synchronized void b(Context context, com.ironsource.mediationsdk.model.k kVar) {
        synchronized (CappingManager.class) {
            if (context == null || kVar == null) {
                return;
            }
            p a2 = kVar.a();
            if (a2 == null) {
                return;
            }
            d(context, "Interstitial", kVar.c(), a2);
        }
    }

    public static synchronized void c(Context context, o oVar) {
        synchronized (CappingManager.class) {
            if (context == null || oVar == null) {
                return;
            }
            p a2 = oVar.a();
            if (a2 == null) {
                return;
            }
            d(context, "Rewarded Video", oVar.c(), a2);
        }
    }

    private static void d(Context context, String str, String str2, p pVar) {
        boolean e2 = pVar.e();
        IronSourceUtils.V(context, e(str, "CappingManager.IS_DELIVERY_ENABLED", str2), e2);
        if (e2) {
            boolean d2 = pVar.d();
            IronSourceUtils.V(context, e(str, "CappingManager.IS_CAPPING_ENABLED", str2), d2);
            if (d2) {
                IronSourceUtils.f0(context, e(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), pVar.b());
                IronSourceUtils.i0(context, e(str, "CappingManager.CAPPING_TYPE", str2), pVar.a().toString());
            }
            boolean f2 = pVar.f();
            IronSourceUtils.V(context, e(str, "CappingManager.IS_PACING_ENABLED", str2), f2);
            if (f2) {
                IronSourceUtils.f0(context, e(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), pVar.c());
            }
        }
    }

    private static String e(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private static String f(IronSource.AD_UNIT ad_unit) {
        return ad_unit == IronSource.AD_UNIT.INTERSTITIAL ? "Interstitial" : ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO ? "Rewarded Video" : ad_unit == IronSource.AD_UNIT.BANNER ? "Banner" : ad_unit.toString();
    }

    public static synchronized void g(Context context, String str) {
        synchronized (CappingManager.class) {
            if (!TextUtils.isEmpty(str)) {
                k(context, "Banner", str);
            }
        }
    }

    public static synchronized void h(Context context, String str) {
        synchronized (CappingManager.class) {
            k(context, "Interstitial", str);
        }
    }

    public static synchronized void i(Context context, com.ironsource.mediationsdk.model.k kVar) {
        synchronized (CappingManager.class) {
            if (kVar != null) {
                k(context, "Interstitial", kVar.c());
            }
        }
    }

    public static synchronized void j(Context context, String str, IronSource.AD_UNIT ad_unit) {
        synchronized (CappingManager.class) {
            k(context, f(ad_unit), str);
        }
    }

    private static void k(Context context, String str, String str2) {
        int i2 = 0;
        if (IronSourceUtils.d(context, e(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            IronSourceUtils.h0(context, e(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.d(context, e(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            IronSourceUtils.y(context, e(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String e2 = e(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int y = IronSourceUtils.y(context, e2, 0);
            if (y == 0) {
                String M = IronSourceUtils.M(context, e(str, "CappingManager.CAPPING_TYPE", str2), PlacementCappingType.PER_DAY.toString());
                PlacementCappingType placementCappingType = null;
                PlacementCappingType[] values = PlacementCappingType.values();
                int length = values.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    PlacementCappingType placementCappingType2 = values[i2];
                    if (placementCappingType2.value.equals(M)) {
                        placementCappingType = placementCappingType2;
                        break;
                    }
                    i2++;
                }
                IronSourceUtils.h0(context, e(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2), l(placementCappingType));
            }
            IronSourceUtils.f0(context, e2, y + 1);
        }
    }

    private static long l(PlacementCappingType placementCappingType) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i2 = a.a[placementCappingType.ordinal()];
        if (i2 == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i2 == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    public static synchronized boolean m(Context context, String str) {
        boolean z;
        synchronized (CappingManager.class) {
            z = p(context, "Banner", str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized boolean n(Context context, String str) {
        boolean z;
        synchronized (CappingManager.class) {
            z = p(context, "Interstitial", str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized ECappingStatus o(Context context, com.ironsource.mediationsdk.model.k kVar) {
        synchronized (CappingManager.class) {
            if (context != null && kVar != null) {
                if (kVar.a() != null) {
                    return p(context, "Interstitial", kVar.c());
                }
            }
            return ECappingStatus.NOT_CAPPED;
        }
    }

    private static ECappingStatus p(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.d(context, e(str, "CappingManager.IS_DELIVERY_ENABLED", str2), true)) {
            return ECappingStatus.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.d(context, e(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            if (currentTimeMillis - IronSourceUtils.B(context, e(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), 0L) < IronSourceUtils.y(context, e(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), 0) * 1000) {
                return ECappingStatus.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.d(context, e(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            int y = IronSourceUtils.y(context, e(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String e2 = e(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int y2 = IronSourceUtils.y(context, e2, 0);
            String e3 = e(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2);
            if (currentTimeMillis >= IronSourceUtils.B(context, e3, 0L)) {
                IronSourceUtils.f0(context, e2, 0);
                IronSourceUtils.h0(context, e3, 0L);
            } else if (y2 >= y) {
                return ECappingStatus.CAPPED_PER_COUNT;
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    public static synchronized boolean q(Context context, String str, IronSource.AD_UNIT ad_unit) {
        boolean z;
        synchronized (CappingManager.class) {
            z = p(context, f(ad_unit), str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }
}
