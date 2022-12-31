package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.a;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class g implements e<T> {
    private final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.google.android.gms.dynamic.e
    public final void a(c cVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        c cVar2;
        this.a.a = cVar;
        linkedList = this.a.c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cVar2 = this.a.a;
            ((a.InterfaceC0139a) it.next()).a(cVar2);
        }
        linkedList2 = this.a.c;
        linkedList2.clear();
        this.a.b = null;
    }
}
