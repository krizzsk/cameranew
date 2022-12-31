package com.google.android.gms.common;

import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class q extends o {

    /* renamed from: e  reason: collision with root package name */
    private final Callable<String> f3690e;

    private q(Callable<String> callable) {
        super(false, null, null);
        this.f3690e = callable;
    }

    @Override // com.google.android.gms.common.o
    final String f() {
        try {
            return this.f3690e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
