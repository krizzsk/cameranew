package kotlin.random;

import kotlin.jvm.internal.s;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public final class b extends kotlin.random.a {
    private final a a = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<java.util.Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.a
    public java.util.Random getImpl() {
        java.util.Random random = this.a.get();
        s.g(random, "implStorage.get()");
        return random;
    }
}
