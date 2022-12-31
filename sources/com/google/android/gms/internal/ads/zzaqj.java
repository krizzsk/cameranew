package com.google.android.gms.internal.ads;

import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqj implements View.OnClickListener {
    private final /* synthetic */ zzaqg zzdpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqj(zzaqg zzaqgVar) {
        this.zzdpx = zzaqgVar;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        this.zzdpx.zzad(true);
    }
}
