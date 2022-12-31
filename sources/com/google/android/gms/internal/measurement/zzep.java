package com.google.android.gms.internal.measurement;

import android.os.Binder;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzep {
    public static <V> V zza(zzeq<V> zzeqVar) {
        try {
            return zzeqVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzeqVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
