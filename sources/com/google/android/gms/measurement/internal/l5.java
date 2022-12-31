package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class l5 {
    public static void a(@NonNull Bundle bundle, @NonNull Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(FirebaseAnalytics.Param.VALUE, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(FirebaseAnalytics.Param.VALUE, ((Long) obj).longValue());
        } else {
            bundle.putString(FirebaseAnalytics.Param.VALUE, obj.toString());
        }
    }

    public static <T> T b(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = (T) bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t2.getClass().getCanonicalName()));
    }
}
