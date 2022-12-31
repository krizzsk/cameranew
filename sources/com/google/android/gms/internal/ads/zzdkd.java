package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdkd {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdkc<T> zzdkcVar) {
        T t = atomicReference.get();
        if (t == null) {
            return;
        }
        try {
            zzdkcVar.zzp(t);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
