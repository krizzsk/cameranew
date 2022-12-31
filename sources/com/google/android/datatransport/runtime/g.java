package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: EncodedPayload.java */
/* loaded from: classes2.dex */
public final class g {
    private final com.google.android.datatransport.b a;
    private final byte[] b;

    public g(@NonNull com.google.android.datatransport.b bVar, @NonNull byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = bVar;
        this.b = bArr;
    }

    public byte[] a() {
        return this.b;
    }

    public com.google.android.datatransport.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.a)) {
                return Arrays.equals(this.b, gVar.b);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
