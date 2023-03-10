package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class zzfk<T> extends zzfm<T> {
    static final zzfk<Object> zza = new zzfk<>();

    private zzfk() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
