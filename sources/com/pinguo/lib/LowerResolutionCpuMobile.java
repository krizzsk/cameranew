package com.pinguo.lib;

import java.util.List;
import java.util.Locale;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: LowerResolutionCpuMobile.kt */
/* loaded from: classes3.dex */
public final class LowerResolutionCpuMobile {
    public static final LowerResolutionCpuMobile INSTANCE = new LowerResolutionCpuMobile();
    private static final List<String> lowerResolutionCpuList;

    static {
        List<String> j2;
        j2 = u.j("samsungexynos7880", "samsungexynos7870", "samsungexynos7580", "samsungexynos5433", "samsungexynos5430", "samsungexynos5800", "samsungexynos5420", "MSM8953", "MSM8956", "MSM8976");
        lowerResolutionCpuList = j2;
    }

    private LowerResolutionCpuMobile() {
    }

    public final boolean isInLowerResolutionList() {
        String lowerCase;
        boolean C;
        String hardware = HardwareInfo.get().getHardware();
        if (hardware == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            s.g(ENGLISH, "ENGLISH");
            lowerCase = hardware.toLowerCase(ENGLISH);
            s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        }
        if (lowerCase == null) {
            return false;
        }
        for (String str : lowerResolutionCpuList) {
            C = StringsKt__StringsKt.C(lowerCase, str, false, 2, null);
            if (C) {
                return true;
            }
        }
        return false;
    }
}
