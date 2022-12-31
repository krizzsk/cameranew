package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzei;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class g implements Callable<zzei> {
    private final /* synthetic */ zzl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzl zzlVar) {
        this.a = zzlVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzei call() throws Exception {
        zzazn zzaznVar;
        Context context;
        zzaznVar = this.a.a;
        String str = zzaznVar.zzbrp;
        context = this.a.f3510d;
        return new zzei(zzef.zzb(str, context, false));
    }
}
