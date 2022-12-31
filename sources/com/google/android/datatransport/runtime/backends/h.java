package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Inject;
/* compiled from: CreationContextFactory.java */
/* loaded from: classes2.dex */
class h {
    private final Context a;
    private final com.google.android.datatransport.runtime.x.a b;
    private final com.google.android.datatransport.runtime.x.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public h(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2) {
        this.a = context;
        this.b = aVar;
        this.c = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(String str) {
        return g.a(this.a, this.b, this.c, str);
    }
}
