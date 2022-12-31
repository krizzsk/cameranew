package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.m;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: AutoValue_TransportContext.java */
/* loaded from: classes2.dex */
final class c extends m {
    private final String a;
    private final byte[] b;
    private final Priority c;

    /* compiled from: AutoValue_TransportContext.java */
    /* loaded from: classes2.dex */
    static final class b extends m.a {
        private String a;
        private byte[] b;
        private Priority c;

        @Override // com.google.android.datatransport.runtime.m.a
        public m a() {
            String str = "";
            if (this.a == null) {
                str = " backendName";
            }
            if (this.c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.m.a
        public m.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.m.a
        public m.a c(@Nullable byte[] bArr) {
            this.b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.m.a
        public m.a d(Priority priority) {
            Objects.requireNonNull(priority, "Null priority");
            this.c = priority;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.m
    public String b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.m
    @Nullable
    public byte[] c() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.m
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a.equals(mVar.b())) {
                if (Arrays.equals(this.b, mVar instanceof c ? ((c) mVar).b : mVar.c()) && this.c.equals(mVar.d())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }

    private c(String str, @Nullable byte[] bArr, Priority priority) {
        this.a = str;
        this.b = bArr;
        this.c = priority;
    }
}
