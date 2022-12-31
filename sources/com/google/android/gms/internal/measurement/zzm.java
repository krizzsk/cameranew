package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzm extends zzr {
    private final AtomicReference<Bundle> zza = new AtomicReference<>();
    private boolean zzb;

    public static final <T> T zze(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", cls.getCanonicalName(), obj.getClass().getCanonicalName()), e2);
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void zzb(Bundle bundle) {
        synchronized (this.zza) {
            this.zza.set(bundle);
            this.zzb = true;
            this.zza.notify();
        }
    }

    public final String zzc(long j2) {
        return (String) zze(zzd(j2), String.class);
    }

    public final Bundle zzd(long j2) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j2);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }
}
