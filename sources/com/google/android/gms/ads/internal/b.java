package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzdsy;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ zzf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzf zzfVar, boolean z) {
        this.b = zzfVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzazn zzaznVar;
        Context context;
        Context g2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzaznVar = this.b.f3509l;
            String str = zzaznVar.zzbrp;
            context = this.b.f3507j;
            g2 = zzf.g(context);
            zzds.zza(str, g2, this.a).zzbt();
        } catch (NullPointerException e2) {
            zzdsyVar = this.b.f3505h;
            zzdsyVar.zza(2027, System.currentTimeMillis() - currentTimeMillis, e2);
        }
    }
}
