package com.google.android.play.core.internal;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class i<StateT> {
    protected final Set<d.c.a.d.a.a.a<StateT>> a = new HashSet();

    public final synchronized void a(d.c.a.d.a.a.a<StateT> aVar) {
        this.a.add(aVar);
    }

    public final synchronized void b(StateT statet) {
        for (d.c.a.d.a.a.a<StateT> aVar : this.a) {
            aVar.onStateUpdate(statet);
        }
    }
}
