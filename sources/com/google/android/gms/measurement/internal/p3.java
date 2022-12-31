package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.net.URL;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
@WorkerThread
/* loaded from: classes2.dex */
public final class p3 implements Runnable {
    private final URL a;
    private final byte[] b;
    private final n3 c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3911d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f3912e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ q3 f3913f;

    public p3(q3 q3Var, String str, URL url, byte[] bArr, Map<String, String> map, n3 n3Var) {
        this.f3913f = q3Var;
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.j(url);
        com.google.android.gms.common.internal.q.j(n3Var);
        this.a = url;
        this.b = bArr;
        this.c = n3Var;
        this.f3911d = str;
        this.f3912e = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p3.run():void");
    }
}
