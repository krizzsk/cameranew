package com.google.android.datatransport;

import androidx.annotation.Nullable;
import java.util.Objects;
/* compiled from: AutoValue_Event.java */
/* loaded from: classes.dex */
final class a<T> extends c<T> {
    private final Integer a;
    private final T b;
    private final Priority c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@Nullable Integer num, T t, Priority priority) {
        this.a = num;
        Objects.requireNonNull(t, "Null payload");
        this.b = t;
        Objects.requireNonNull(priority, "Null priority");
        this.c = priority;
    }

    @Override // com.google.android.datatransport.c
    @Nullable
    public Integer a() {
        return this.a;
    }

    @Override // com.google.android.datatransport.c
    public T b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.c
    public Priority c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                if (this.b.equals(cVar.b()) && this.c.equals(cVar.c())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + "}";
    }
}
