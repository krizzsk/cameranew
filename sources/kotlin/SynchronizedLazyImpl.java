package kotlin;

import java.io.Serializable;
/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
final class SynchronizedLazyImpl<T> implements f<T>, Serializable {
    private volatile Object _value;
    private kotlin.jvm.b.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.b.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.s.h(initializer, "initializer");
        this.initializer = initializer;
        this._value = r.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.f
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        r rVar = r.a;
        if (t2 != rVar) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == rVar) {
                kotlin.jvm.b.a<? extends T> aVar = this.initializer;
                kotlin.jvm.internal.s.e(aVar);
                t = aVar.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != r.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.b.a aVar, Object obj, int i2, kotlin.jvm.internal.o oVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
