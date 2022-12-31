package com.bytedance.sdk.openadsdk.h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* compiled from: RandomAccessFileWrapper.java */
/* loaded from: classes.dex */
class h {
    private final RandomAccessFile a;

    /* compiled from: RandomAccessFileWrapper.java */
    /* loaded from: classes.dex */
    static class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(File file, String str) throws a {
        try {
            this.a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e2) {
            throw new a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j2) throws a {
        try {
            this.a.seek(j2);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i2, int i3) throws a {
        try {
            this.a.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(byte[] bArr) throws a {
        try {
            return this.a.read(bArr);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        com.bytedance.sdk.openadsdk.h.g.d.a(this.a);
    }
}
