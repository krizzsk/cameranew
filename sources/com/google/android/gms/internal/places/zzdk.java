package com.google.android.gms.internal.places;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class zzdk implements Comparable<zzdk>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzdb zzma;
    private final Comparable zzme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdk(zzdb zzdbVar, Map.Entry<K, V> entry) {
        this(zzdbVar, (Comparable) entry.getKey(), entry.getValue());
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzdk zzdkVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzdkVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.zzme, entry.getKey()) && equals(this.value, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzme;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zzme;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.value;
        return hashCode ^ (v != 0 ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzma.zzcx();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzme);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzdk(zzdb zzdbVar, K k2, V v) {
        this.zzma = zzdbVar;
        this.zzme = k2;
        this.value = v;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
