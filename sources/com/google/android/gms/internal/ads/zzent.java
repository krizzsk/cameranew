package com.google.android.gms.internal.ads;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzent implements Comparable<zzent>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzeno zzius;
    private final Comparable zziuw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzent(zzeno zzenoVar, Map.Entry<K, V> entry) {
        this(zzenoVar, (Comparable) entry.getKey(), entry.getValue());
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzent zzentVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzentVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.zziuw, entry.getKey()) && equals(this.value, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zziuw;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zziuw;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.value;
        return hashCode ^ (v != 0 ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzius.zzbkt();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zziuw);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzent(zzeno zzenoVar, K k2, V v) {
        this.zzius = zzenoVar;
        this.zziuw = k2;
        this.value = v;
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
