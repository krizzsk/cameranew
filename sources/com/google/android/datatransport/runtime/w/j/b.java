package com.google.android.datatransport.runtime.w.j;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_PersistedEvent.java */
/* loaded from: classes2.dex */
public final class b extends i {
    private final long a;
    private final com.google.android.datatransport.runtime.m b;
    private final com.google.android.datatransport.runtime.h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j2, com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar) {
        this.a = j2;
        Objects.requireNonNull(mVar, "Null transportContext");
        this.b = mVar;
        Objects.requireNonNull(hVar, "Null event");
        this.c = hVar;
    }

    @Override // com.google.android.datatransport.runtime.w.j.i
    public com.google.android.datatransport.runtime.h b() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.w.j.i
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.w.j.i
    public com.google.android.datatransport.runtime.m d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.a == iVar.c() && this.b.equals(iVar.d()) && this.c.equals(iVar.b());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        return this.c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}
