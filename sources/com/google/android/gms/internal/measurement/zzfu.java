package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzfu extends WeakReference<Throwable> {
    private final int zza;

    public zzfu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzfu.class) {
            if (this == obj) {
                return true;
            }
            zzfu zzfuVar = (zzfu) obj;
            if (this.zza == zzfuVar.zza && get() == zzfuVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}
