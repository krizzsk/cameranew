package kotlinx.coroutines.internal;

import kotlinx.coroutines.p0;
/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class w {
    public abstract d<?> a();

    public final boolean b(w wVar) {
        d<?> a;
        d<?> a2 = a();
        return (a2 == null || (a = wVar.a()) == null || a2.g() >= a.g()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return p0.a(this) + '@' + p0.b(this);
    }
}
