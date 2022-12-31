package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaua implements Callable<zzatz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaub zzdyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaua(zzaub zzaubVar, Context context) {
        this.zzdyv = zzaubVar;
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzatz call() throws Exception {
        WeakHashMap weakHashMap;
        zzatz zzws;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzdyv.zzdyw;
        zzaud zzaudVar = (zzaud) weakHashMap.get(this.val$context);
        if (zzaudVar != null) {
            if (!(zzaudVar.zzdyz + zzada.zzdcn.get().longValue() < com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis())) {
                zzws = new zzaty(this.val$context, zzaudVar.zzdza).zzws();
                weakHashMap2 = this.zzdyv.zzdyw;
                weakHashMap2.put(this.val$context, new zzaud(this.zzdyv, zzws));
                return zzws;
            }
        }
        zzws = new zzaty(this.val$context).zzws();
        weakHashMap2 = this.zzdyv.zzdyw;
        weakHashMap2.put(this.val$context, new zzaud(this.zzdyv, zzws));
        return zzws;
    }
}
