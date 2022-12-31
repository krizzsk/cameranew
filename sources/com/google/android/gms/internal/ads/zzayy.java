package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayy implements zzrm {
    private final com.google.android.gms.ads.internal.util.zzf zzedg;
    private final zzayv zzedn;
    private final Object lock = new Object();
    private final HashSet<zzayn> zzedo = new HashSet<>();
    private final HashSet<zzayw> zzedp = new HashSet<>();
    private boolean zzedq = false;
    private final zzayx zzedm = new zzayx();

    public zzayy(String str, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzedn = new zzayv(str, zzfVar);
        this.zzedg = zzfVar;
    }

    public final Bundle zza(Context context, zzayu zzayuVar) {
        HashSet<zzayn> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzedo);
            this.zzedo.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzedn.zzn(context, this.zzedm.zzyd()));
        Bundle bundle2 = new Bundle();
        Iterator<zzayw> it = this.zzedp.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzayn> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzayuVar.zza(hashSet);
            return bundle;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final void zzb(zzayn zzaynVar) {
        synchronized (this.lock) {
            this.zzedo.add(zzaynVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final void zzp(boolean z) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzedg.zzyo() > ((Long) zzwr.zzqr().zzd(zzabp.zzcpm)).longValue()) {
                this.zzedn.zzedd = -1;
            } else {
                this.zzedn.zzedd = this.zzedg.zzyp();
            }
            this.zzedq = true;
            return;
        }
        this.zzedg.zzez(currentTimeMillis);
        this.zzedg.zzde(this.zzedn.zzedd);
    }

    public final void zzxi() {
        synchronized (this.lock) {
            this.zzedn.zzxi();
        }
    }

    public final void zzxj() {
        synchronized (this.lock) {
            this.zzedn.zzxj();
        }
    }

    public final boolean zzyf() {
        return this.zzedq;
    }

    public final void zzb(HashSet<zzayn> hashSet) {
        synchronized (this.lock) {
            this.zzedo.addAll(hashSet);
        }
    }

    public final void zza(zzvl zzvlVar, long j2) {
        synchronized (this.lock) {
            this.zzedn.zza(zzvlVar, j2);
        }
    }

    public final zzayn zza(Clock clock, String str) {
        return new zzayn(clock, this, this.zzedm.zzyc(), str);
    }
}
