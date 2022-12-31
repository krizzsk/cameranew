package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class k implements View.OnClickListener {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Intent b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        try {
            this.a.startActivity(this.b);
        } catch (ActivityNotFoundException e2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e2);
        }
    }
}
