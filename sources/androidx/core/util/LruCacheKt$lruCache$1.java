package androidx.core.util;

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
    public final Integer invoke(K noName_0, V noName_1) {
        s.h(noName_0, "$noName_0");
        s.h(noName_1, "$noName_1");
        return 1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
        return invoke((LruCacheKt$lruCache$1) obj, obj2);
    }
}
