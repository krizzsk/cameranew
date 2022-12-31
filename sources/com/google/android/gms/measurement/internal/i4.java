package com.google.android.gms.measurement.internal;

import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class i4 implements Thread.UncaughtExceptionHandler {
    private final String a;
    final /* synthetic */ l4 b;

    public i4(l4 l4Var, String str) {
        this.b = l4Var;
        com.google.android.gms.common.internal.q.j(str);
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.a.a().m().b(this.a, th);
    }
}
