package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdxh<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzhxu = new Map.Entry[0];
    private transient zzdxg<Map.Entry<K, V>> zzhxv;
    private transient zzdxg<K> zzhxw;
    private transient zzdwy<V> zzhxx;

    public static <K, V> zzdxh<K, V> zza(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        zzdwx.zzb(k2, v);
        zzdwx.zzb(k3, v2);
        zzdwx.zzb(k4, v3);
        zzdwx.zzb(k5, v4);
        zzdwx.zzb(k6, v5);
        return zzdxq.zzc(5, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5});
    }

    public static <K, V> zzdxh<K, V> zzc(K k2, V v) {
        zzdwx.zzb(k2, v);
        return zzdxq.zzc(1, new Object[]{k2, v});
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdwy) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdxg<Map.Entry<K, V>> zzdxgVar = this.zzhxv;
        if (zzdxgVar == null) {
            zzdxg<Map.Entry<K, V>> zzazp = zzazp();
            this.zzhxv = zzazp;
            return zzazp;
        }
        return zzdxgVar;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzdxw.zzg((zzdxg) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdxg<K> zzdxgVar = this.zzhxw;
        if (zzdxgVar == null) {
            zzdxg<K> zzazq = zzazq();
            this.zzhxw = zzazq;
            return zzazq;
        }
        return zzdxgVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzdwx.zzh(size, BigAlbumStore.PhotoColumns.SIZE);
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, (long) IjkMediaMeta.AV_CH_STEREO_RIGHT));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdwy<V> zzdwyVar = this.zzhxx;
        if (zzdwyVar == null) {
            zzdwy<V> zzazr = zzazr();
            this.zzhxx = zzazr;
            return zzazr;
        }
        return zzdwyVar;
    }

    abstract zzdxg<Map.Entry<K, V>> zzazp();

    abstract zzdxg<K> zzazq();

    abstract zzdwy<V> zzazr();
}
