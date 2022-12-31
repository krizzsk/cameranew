package kotlinx.coroutines.internal;

import java.util.Objects;
/* compiled from: ArrayQueue.kt */
/* loaded from: classes3.dex */
public class a<T> {
    private Object[] a = new Object[16];
    private int b;
    private int c;

    private final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.m.f(objArr, objArr2, 0, this.b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i2 = this.b;
        kotlin.collections.m.f(objArr3, objArr2, length2 - i2, 0, i2, 4, null);
        this.a = objArr2;
        this.b = 0;
        this.c = length;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.c = length;
        if (length == this.b) {
            b();
        }
    }

    public final boolean c() {
        return this.b == this.c;
    }

    public final T d() {
        int i2 = this.b;
        if (i2 == this.c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.b = (i2 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return t;
    }
}
