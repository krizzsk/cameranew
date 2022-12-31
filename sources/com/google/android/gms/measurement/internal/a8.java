package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class a8 implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ f8 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a8(f8 f8Var, ComponentName componentName) {
        this.b = f8Var;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g8.v(this.b.c, this.a);
    }
}
