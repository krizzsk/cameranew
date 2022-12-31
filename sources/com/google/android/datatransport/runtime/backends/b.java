package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_BackendResponse.java */
/* loaded from: classes2.dex */
public final class b extends BackendResponse {
    private final BackendResponse.Status a;
    private final long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BackendResponse.Status status, long j2) {
        Objects.requireNonNull(status, "Null status");
        this.a = status;
        this.b = j2;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BackendResponse) {
            BackendResponse backendResponse = (BackendResponse) obj;
            return this.a.equals(backendResponse.c()) && this.b == backendResponse.b();
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.b + "}";
    }
}
