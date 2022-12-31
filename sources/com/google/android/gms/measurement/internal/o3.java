package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
@WorkerThread
/* loaded from: classes2.dex */
final class o3 implements Runnable {
    private final n3 a;
    private final int b;
    private final Throwable c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f3897d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3898e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<String>> f3899f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o3(String str, n3 n3Var, int i2, Throwable th, byte[] bArr, Map map, m3 m3Var) {
        com.google.android.gms.common.internal.q.j(n3Var);
        this.a = n3Var;
        this.b = i2;
        this.c = th;
        this.f3897d = bArr;
        this.f3898e = str;
        this.f3899f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.f3898e, this.b, this.c, this.f3897d, this.f3899f);
    }
}
