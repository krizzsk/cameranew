package kotlin.collections;
/* compiled from: ArraysJVM.kt */
/* loaded from: classes3.dex */
class k {
    public static final void a(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }
}
