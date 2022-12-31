package com.google.android.datatransport.cct.internal;
/* compiled from: AutoValue_LogResponse.java */
/* loaded from: classes.dex */
final class h extends m {
    private final long a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(long j2) {
        this.a = j2;
    }

    @Override // com.google.android.datatransport.cct.internal.m
    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof m) && this.a == ((m) obj).c();
    }

    public int hashCode() {
        long j2 = this.a;
        return 1000003 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
