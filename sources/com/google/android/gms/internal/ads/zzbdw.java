package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdw implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzeqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdw(JsResult jsResult) {
        this.zzeqp = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeqp.cancel();
    }
}
