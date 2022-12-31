package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
/* compiled from: Unconfined.kt */
/* loaded from: classes3.dex */
public final class b3 extends AbstractCoroutineContextElement {
    public static final a b = new a(null);
    public boolean a;

    /* compiled from: Unconfined.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CoroutineContext.Key<b3> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public b3() {
        super(b);
    }
}
