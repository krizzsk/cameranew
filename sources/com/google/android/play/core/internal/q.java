package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.List;
/* loaded from: classes2.dex */
final class q extends k {
    final /* synthetic */ IBinder b;
    final /* synthetic */ s c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(s sVar, IBinder iBinder) {
        this.c = sVar;
        this.b = iBinder;
    }

    @Override // com.google.android.play.core.internal.k
    public final void a() {
        p pVar;
        List<Runnable> list;
        List list2;
        t tVar = this.c.a;
        pVar = tVar.f4863g;
        tVar.f4867k = (IInterface) pVar.a(this.b);
        t.n(this.c.a);
        this.c.a.f4861e = false;
        list = this.c.a.f4860d;
        for (Runnable runnable : list) {
            runnable.run();
        }
        list2 = this.c.a.f4860d;
        list2.clear();
    }
}
