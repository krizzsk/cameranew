package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class i implements DialogInterface.OnClickListener {
    private final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        VdsAgent.onClick(this, dialogInterface, i2);
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzj.zzb(this.a.a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
