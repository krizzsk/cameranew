package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqe implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqf zzdpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqe(zzaqf zzaqfVar) {
        this.zzdpc = zzaqfVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Context context;
        VdsAgent.onClick(this, dialogInterface, i2);
        Intent createIntent = this.zzdpc.createIntent();
        com.google.android.gms.ads.internal.zzr.zzkr();
        context = this.zzdpc.context;
        com.google.android.gms.ads.internal.util.zzj.zza(context, createIntent);
    }
}
