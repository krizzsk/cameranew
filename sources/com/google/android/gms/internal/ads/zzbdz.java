package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdz implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeqq;
    private final /* synthetic */ EditText zzeqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdz(JsPromptResult jsPromptResult, EditText editText) {
        this.zzeqq = jsPromptResult;
        this.zzeqr = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        VdsAgent.onClick(this, dialogInterface, i2);
        this.zzeqq.confirm(this.zzeqr.getText().toString());
    }
}
