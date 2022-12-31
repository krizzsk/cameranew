package androidx.collection;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$1 extends Lambda implements p<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.p
    public final Integer invoke(K k2, V v) {
        s.i(k2, "<anonymous parameter 0>");
        s.i(v, "<anonymous parameter 1>");
        return 1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke((LruCacheKt$lruCache$1) obj, obj2));
    }
}
