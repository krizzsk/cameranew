package com.google.android.play.core.splitcompat;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r {
    private final File a;
    private final String b;

    r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(File file, String str) {
        this();
        Objects.requireNonNull(file, "Null splitFile");
        this.a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public File a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a.equals(rVar.a()) && this.b.equals(rVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.a);
        String str = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
