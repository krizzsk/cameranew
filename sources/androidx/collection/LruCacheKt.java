package androidx.collection;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i2, p<? super K, ? super V, Integer> sizeOf, l<? super K, ? extends V> create, r<? super Boolean, ? super K, ? super V, ? super V, u> onEntryRemoved) {
        s.i(sizeOf, "sizeOf");
        s.i(create, "create");
        s.i(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i2, i2);
    }

    public static /* synthetic */ LruCache lruCache$default(int i2, p pVar, l lVar, r rVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        p sizeOf = pVar;
        if ((i3 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        l create = lVar;
        if ((i3 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        r onEntryRemoved = rVar;
        s.i(sizeOf, "sizeOf");
        s.i(create, "create");
        s.i(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i2, i2);
    }
}
