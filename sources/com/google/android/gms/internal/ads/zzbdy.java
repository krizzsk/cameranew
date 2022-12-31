package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdy implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzeqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdy(JsResult jsResult) {
        this.zzeqp = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        VdsAgent.onClick(this, dialogInterface, i2);
        this.zzeqp.confirm();
    }
}
