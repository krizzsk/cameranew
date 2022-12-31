package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.f0;
/* compiled from: ArrayIterators.kt */
/* loaded from: classes3.dex */
final class e extends f0 {
    private final float[] a;
    private int b;

    public e(float[] array) {
        s.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.f0
    public float a() {
        try {
            float[] fArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            return fArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
