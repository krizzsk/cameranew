package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i2, p<? super K, ? super V, Integer> sizeOf, l<? super K, ? extends V> create, r<? super Boolean, ? super K, ? super V, ? super V, u> onEntryRemoved) {
        s.h(sizeOf, "sizeOf");
        s.h(create, "create");
        s.h(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i2);
    }

    public static /* synthetic */ LruCache lruCache$default(int i2, p sizeOf, l create, r onEntryRemoved, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            sizeOf = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i3 & 4) != 0) {
            create = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i3 & 8) != 0) {
            onEntryRemoved = LruCacheKt$lruCache$3.INSTANCE;
        }
        s.h(sizeOf, "sizeOf");
        s.h(create, "create");
        s.h(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i2);
    }
}
