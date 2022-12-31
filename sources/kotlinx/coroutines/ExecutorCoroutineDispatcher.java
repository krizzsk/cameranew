package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* compiled from: Executors.kt */
    /* loaded from: classes3.dex */
    public static final class Key extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {

        /* compiled from: Executors.kt */
        /* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<CoroutineContext.Element, ExecutorCoroutineDispatcher> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            public final ExecutorCoroutineDispatcher invoke(CoroutineContext.Element element) {
                if (element instanceof ExecutorCoroutineDispatcher) {
                    return (ExecutorCoroutineDispatcher) element;
                }
                return null;
            }
        }

        private Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    static {
        new Key(null);
    }
}
