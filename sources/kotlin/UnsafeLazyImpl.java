package kotlin;

import java.io.Serializable;
/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public final class UnsafeLazyImpl<T> implements f<T>, Serializable {
    private Object _value;
    private kotlin.jvm.b.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.b.a<? extends T> initializer) {
        kotlin.jvm.internal.s.h(initializer, "initializer");
        this.initializer = initializer;
        this._value = r.a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.f
    public T getValue() {
        if (this._value == r.a) {
            kotlin.jvm.b.a<? extends T> aVar = this.initializer;
            kotlin.jvm.internal.s.e(aVar);
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != r.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
