package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxh {
    private final zzcin zzgmw;
    private final ConcurrentHashMap<String, zzapk> zzgxh = new ConcurrentHashMap<>();

    public zzcxh(zzcin zzcinVar) {
        this.zzgmw = zzcinVar;
    }

    public final void zzgn(String str) {
        try {
            this.zzgxh.put(str, this.zzgmw.zzdf(str));
        } catch (RemoteException e2) {
            zzazk.zzc("Couldn't create RTB adapter : ", e2);
        }
    }

    @CheckForNull
    public final zzapk zzgo(String str) {
        if (this.zzgxh.containsKey(str)) {
            return this.zzgxh.get(str);
        }
        return null;
    }
}
