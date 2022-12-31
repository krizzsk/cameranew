package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.f;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: AutoValue_BackendRequest.java */
/* loaded from: classes2.dex */
final class a extends f {
    private final Iterable<com.google.android.datatransport.runtime.h> a;
    private final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_BackendRequest.java */
    /* loaded from: classes2.dex */
    public static final class b extends f.a {
        private Iterable<com.google.android.datatransport.runtime.h> a;
        private byte[] b;

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f a() {
            String str = "";
            if (this.a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a b(Iterable<com.google.android.datatransport.runtime.h> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.f.a
        public f.a c(@Nullable byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public Iterable<com.google.android.datatransport.runtime.h> b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    @Nullable
    public byte[] c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.b())) {
                if (Arrays.equals(this.b, fVar instanceof a ? ((a) fVar).b : fVar.c())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.b) + "}";
    }

    private a(Iterable<com.google.android.datatransport.runtime.h> iterable, @Nullable byte[] bArr) {
        this.a = iterable;
        this.b = bArr;
    }
}
