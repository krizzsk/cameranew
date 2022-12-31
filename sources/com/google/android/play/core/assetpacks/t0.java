package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class t0 extends FilterInputStream {
    private final l2 a;
    private byte[] b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4803d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4804e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(InputStream inputStream) {
        super(inputStream);
        this.a = new l2();
        this.b = new byte[4096];
        this.f4803d = false;
        this.f4804e = false;
    }

    private final int a(byte[] bArr, int i2, int i3) throws IOException {
        return Math.max(0, super.read(bArr, i2, i3));
    }

    private final boolean j(int i2) throws IOException {
        int a = a(this.b, 0, i2);
        if (a != i2) {
            int i3 = i2 - a;
            if (a(this.b, a, i3) != i3) {
                this.a.b(this.b, 0, a);
                return false;
            }
        }
        this.a.b(this.b, 0, i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f4803d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f3 d() throws IOException {
        byte[] bArr;
        if (this.c <= 0) {
            if (this.f4803d) {
            }
            return new f3(null, -1L, -1, false, false, null);
        }
        do {
            bArr = this.b;
        } while (read(bArr, 0, bArr.length) != -1);
        if (!this.f4803d || this.f4804e) {
            return new f3(null, -1L, -1, false, false, null);
        }
        if (!j(30)) {
            this.f4803d = true;
            return this.a.c();
        }
        f3 c = this.a.c();
        if (c.h()) {
            this.f4804e = true;
            return c;
        } else if (c.e() != 4294967295L) {
            int d2 = this.a.d() - 30;
            long j2 = d2;
            int length = this.b.length;
            if (j2 > length) {
                do {
                    length += length;
                } while (length < j2);
                this.b = Arrays.copyOf(this.b, length);
            }
            if (!j(d2)) {
                this.f4803d = true;
                return this.a.c();
            }
            f3 c2 = this.a.c();
            this.c = c2.e();
            return c2;
        } else {
            throw new bv("Files bigger than 4GiB are not supported.");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.c;
        if (j2 <= 0 || this.f4803d) {
            return -1;
        }
        int a = a(bArr, i2, (int) Math.min(j2, i3));
        this.c -= a;
        if (a == 0) {
            this.f4803d = true;
            return 0;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        return this.f4804e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long v() {
        return this.c;
    }
}
