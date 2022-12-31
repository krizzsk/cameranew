package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeb implements Runnable {
    private final /* synthetic */ Context zzxl;
    private final /* synthetic */ View zzxm;
    private final /* synthetic */ Activity zzxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(zzea zzeaVar, Context context, View view, Activity activity) {
        this.zzxl = context;
        this.zzxm = view;
        this.zzxn = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxa;
            zzdsVar.zza(this.zzxl, this.zzxm, this.zzxn);
        } catch (Exception e2) {
            zzdsyVar = zzea.zzxc;
            zzdsyVar.zza(2020, -1L, e2);
        }
    }
}
