package androidx.collection;

import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3 extends Lambda implements r<Boolean, K, V, V, u> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return u.a;
    }

    public final void invoke(boolean z, K k2, V v, V v2) {
        s.i(k2, "<anonymous parameter 1>");
        s.i(v, "<anonymous parameter 2>");
    }
}
