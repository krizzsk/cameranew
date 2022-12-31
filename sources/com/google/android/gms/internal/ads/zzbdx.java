package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdx implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzeqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdx(JsPromptResult jsPromptResult) {
        this.zzeqq = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeqq.cancel();
    }
}
