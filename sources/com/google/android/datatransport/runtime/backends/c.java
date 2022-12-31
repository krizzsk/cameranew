package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Objects;
/* compiled from: AutoValue_CreationContext.java */
/* loaded from: classes2.dex */
final class c extends g {
    private final Context a;
    private final com.google.android.datatransport.runtime.x.a b;
    private final com.google.android.datatransport.runtime.x.a c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3387d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f3387d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public Context b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    @NonNull
    public String c() {
        return this.f3387d;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public com.google.android.datatransport.runtime.x.a d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public com.google.android.datatransport.runtime.x.a e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a.equals(gVar.b()) && this.b.equals(gVar.e()) && this.c.equals(gVar.d()) && this.f3387d.equals(gVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.f3387d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.b + ", monotonicClock=" + this.c + ", backendName=" + this.f3387d + "}";
    }
}
