package androidx.core.util;

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

    public final void invoke(boolean z, K noName_1, V noName_2, V v) {
        s.h(noName_1, "$noName_1");
        s.h(noName_2, "$noName_2");
    }
}
