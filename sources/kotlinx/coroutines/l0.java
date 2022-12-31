package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
/* compiled from: CoroutineName.kt */
/* loaded from: classes3.dex */
public final class l0 extends AbstractCoroutineContextElement {
    public static final a b = new a(null);
    private final String a;

    /* compiled from: CoroutineName.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CoroutineContext.Key<l0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l0) && kotlin.jvm.internal.s.c(this.a, ((l0) obj).a);
    }

    public final String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }
}
