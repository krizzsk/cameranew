package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqa {
    public static <T> List<T> zzid(int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> zzie(int i2) {
        return new HashSet<>(zzig(i2));
    }

    public static <K, V> LinkedHashMap<K, V> zzif(int i2) {
        return new LinkedHashMap<>(zzig(i2));
    }

    private static int zzig(int i2) {
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
