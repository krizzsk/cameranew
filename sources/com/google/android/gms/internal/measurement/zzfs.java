package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfs {
    public static <T> zzfo<T> zza(zzfo<T> zzfoVar) {
        if ((zzfoVar instanceof zzfq) || (zzfoVar instanceof zzfp)) {
            return zzfoVar;
        }
        if (zzfoVar instanceof Serializable) {
            return new zzfp(zzfoVar);
        }
        return new zzfq(zzfoVar);
    }

    public static <T> zzfo<T> zzb(@NullableDecl T t) {
        return new zzfr(t);
    }
}
