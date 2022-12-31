package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbea implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbea(JsPromptResult jsPromptResult) {
        this.zzeqq = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        VdsAgent.onClick(this, dialogInterface, i2);
        this.zzeqq.cancel();
    }
}
