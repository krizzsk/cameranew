package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l<K, V> $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ r<Boolean, K, V, V, u> $onEntryRemoved;
    final /* synthetic */ p<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(p<? super K, ? super V, Integer> pVar, l<? super K, ? extends V> lVar, r<? super Boolean, ? super K, ? super V, ? super V, u> rVar, int i2) {
        super(i2);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [V, java.lang.Object] */
    @Override // android.util.LruCache
    protected V create(K key) {
        s.h(key, "key");
        return this.$create.invoke(key);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, K key, V oldValue, V v) {
        s.h(key, "key");
        s.h(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // android.util.LruCache
    protected int sizeOf(K key, V value) {
        s.h(key, "key");
        s.h(value, "value");
        return this.$sizeOf.invoke(key, value).intValue();
    }
}
