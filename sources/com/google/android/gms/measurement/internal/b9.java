package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class b9 implements n3 {
    final /* synthetic */ String a;
    final /* synthetic */ i9 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b9(i9 i9Var, String str) {
        this.b = i9Var;
        this.a = str;
    }

    @Override // com.google.android.gms.measurement.internal.n3
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.b.j(i2, th, bArr, this.a);
    }
}
