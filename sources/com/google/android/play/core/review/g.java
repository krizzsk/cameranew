package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.internal.k;
import com.google.android.play.core.tasks.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g extends k {
    final /* synthetic */ p b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, p pVar, p pVar2) {
        super(pVar);
        this.c = hVar;
        this.b = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        String str;
        String str2;
        try {
            str2 = this.c.b;
            this.c.a.f().F(str2, com.google.android.play.core.common.a.a(), new j(this.c, this.b));
        } catch (RemoteException e2) {
            jVar = h.c;
            str = this.c.b;
            jVar.d(e2, "error requesting in-app review for %s", str);
            this.b.d(new RuntimeException(e2));
        }
    }
}
