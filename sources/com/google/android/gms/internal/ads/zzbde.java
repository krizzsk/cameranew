package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbde implements Iterable<zzbdc> {
    private final List<zzbdc> zzepo = new ArrayList();

    public static boolean zzc(zzbbo zzbboVar) {
        zzbdc zzd = zzd(zzbboVar);
        if (zzd != null) {
            zzd.zzepm.abort();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbdc zzd(zzbbo zzbboVar) {
        Iterator<zzbdc> it = com.google.android.gms.ads.internal.zzr.zzln().iterator();
        while (it.hasNext()) {
            zzbdc next = it.next();
            if (next.zzeix == zzbboVar) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbdc> iterator() {
        return this.zzepo.iterator();
    }

    public final void zza(zzbdc zzbdcVar) {
        this.zzepo.add(zzbdcVar);
    }

    public final void zzb(zzbdc zzbdcVar) {
        this.zzepo.remove(zzbdcVar);
    }
}
