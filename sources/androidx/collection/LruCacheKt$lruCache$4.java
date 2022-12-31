package androidx.collection;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(p pVar, l lVar, r rVar, int i2, int i3) {
        super(i3);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [V, java.lang.Object] */
    @Override // androidx.collection.LruCache
    protected V create(K key) {
        s.i(key, "key");
        return this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    protected void entryRemoved(boolean z, K key, V oldValue, V v) {
        s.i(key, "key");
        s.i(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // androidx.collection.LruCache
    protected int sizeOf(K key, V value) {
        s.i(key, "key");
        s.i(value, "value");
        return ((Number) this.$sizeOf.invoke(key, value)).intValue();
    }
}
