package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads-base@@19.7.0 */
/* loaded from: classes2.dex */
final class zzejb extends WeakReference<Throwable> {
    private final int zzilf;

    public zzejb(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zzilf = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzejb.class) {
            if (this == obj) {
                return true;
            }
            zzejb zzejbVar = (zzejb) obj;
            if (this.zzilf == zzejbVar.zzilf && get() == zzejbVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzilf;
    }
}
