package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdfl<T> {
    private final Executor executor;
    private final Set<zzdfi<? extends zzdfj<T>>> zzhdn;

    public zzdfl(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        this.executor = executor;
        this.zzhdn = set;
    }

    public final zzdzw<T> zzs(final T t) {
        final ArrayList arrayList = new ArrayList(this.zzhdn.size());
        for (final zzdfi<? extends zzdfj<T>> zzdfiVar : this.zzhdn) {
            zzdzw<? extends zzdfj<T>> zzasy = zzdfiVar.zzasy();
            if (zzadl.zzdee.get().booleanValue()) {
                final long a = com.google.android.gms.ads.internal.zzr.zzky().a();
                zzasy.addListener(new Runnable(zzdfiVar, a) { // from class: com.google.android.gms.internal.ads.zzdfk
                    private final zzdfi zzhdl;
                    private final long zzhdm;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhdl = zzdfiVar;
                        this.zzhdm = a;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdfi zzdfiVar2 = this.zzhdl;
                        long j2 = this.zzhdm;
                        String canonicalName = zzdfiVar2.getClass().getCanonicalName();
                        long a2 = com.google.android.gms.ads.internal.zzr.zzky().a() - j2;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(a2);
                        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
                    }
                }, zzazp.zzeih);
            }
            arrayList.add(zzasy);
        }
        return zzdzk.zzk(arrayList).zzb(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zzdfn
            private final Object zzdlk;
            private final List zzhct;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhct = arrayList;
                this.zzdlk = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdzw> list = this.zzhct;
                Object obj = this.zzdlk;
                for (zzdzw zzdzwVar : list) {
                    zzdfj zzdfjVar = (zzdfj) zzdzwVar.get();
                    if (zzdfjVar != null) {
                        zzdfjVar.zzr(obj);
                    }
                }
                return obj;
            }
        }, this.executor);
    }
}
