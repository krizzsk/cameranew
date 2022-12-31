package com.facebook.binaryresource;

import com.facebook.common.internal.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
/* compiled from: FileBinaryResource.java */
/* loaded from: classes.dex */
public class b implements a {
    private final File a;

    private b(File file) {
        h.g(file);
        this.a = file;
    }

    public static b b(File file) {
        return new b(file);
    }

    @Nullable
    public static b c(File file) {
        if (file != null) {
            return new b(file);
        }
        return null;
    }

    @Override // com.facebook.binaryresource.a
    public InputStream a() throws IOException {
        return new FileInputStream(this.a);
    }

    public File d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return this.a.equals(((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.facebook.binaryresource.a
    public long size() {
        return this.a.length();
    }
}
