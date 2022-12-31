package kotlin;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
public class h {

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static <T> f<T> a(LazyThreadSafetyMode mode, kotlin.jvm.b.a<? extends T> initializer) {
        kotlin.jvm.internal.s.h(mode, "mode");
        kotlin.jvm.internal.s.h(initializer, "initializer");
        int i2 = a.a[mode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }

    public static <T> f<T> b(kotlin.jvm.b.a<? extends T> initializer) {
        kotlin.jvm.internal.s.h(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
