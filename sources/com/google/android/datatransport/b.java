package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
/* compiled from: Encoding.java */
/* loaded from: classes.dex */
public final class b {
    private final String a;

    private b(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public static b b(@NonNull String str) {
        return new b(str);
    }

    public String a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.a + "\"}";
    }
}
