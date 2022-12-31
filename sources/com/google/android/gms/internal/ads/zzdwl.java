package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdwl {
    public static void checkArgument(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @NonNullDecl
    public static <T> T zza(@NonNullDecl T t, @NullableDecl String str, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(zzdwt.zzb(str, obj));
    }

    public static int zzb(int i2, int i3, @NullableDecl String str) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(zzc(i2, i3, str));
        }
        return i2;
    }

    private static String zzc(int i2, int i3, @NullableDecl String str) {
        if (i2 < 0) {
            return zzdwt.zzb("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzdwt.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void zzf(int i2, int i3, int i4) {
        String zzc;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 >= 0 && i2 <= i4) {
                zzc = (i3 < 0 || i3 > i4) ? zzc(i3, i4, "end index") : zzdwt.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            } else {
                zzc = zzc(i2, i4, "start index");
            }
            throw new IndexOutOfBoundsException(zzc);
        }
    }

    public static int zzt(int i2, int i3) {
        String zzb;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                zzb = zzdwt.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2));
            } else if (i3 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            } else {
                zzb = zzdwt.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(zzb);
        }
        return i2;
    }

    public static int zzu(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(zzc(i2, i3, FirebaseAnalytics.Param.INDEX));
        }
        return i2;
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
