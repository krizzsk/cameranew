package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class v extends f {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Intent intent, Activity activity, int i2) {
        this.a = intent;
        this.b = activity;
        this.c = i2;
    }

    @Override // com.google.android.gms.common.internal.f
    public final void b() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
