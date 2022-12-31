package kotlin.collections;
/* compiled from: ArrayDeque.kt */
/* loaded from: classes3.dex */
public final class i<E> extends e<E> {
    public static final a a = new a(null);
    private static final Object[] b = new Object[0];

    /* compiled from: ArrayDeque.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final int a(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
        }
    }
}
