package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
final class e1 extends OutputStream {
    private final l2 a = new l2();
    private final File b;
    private final z2 c;

    /* renamed from: d  reason: collision with root package name */
    private long f4724d;

    /* renamed from: e  reason: collision with root package name */
    private long f4725e;

    /* renamed from: f  reason: collision with root package name */
    private FileOutputStream f4726f;

    /* renamed from: g  reason: collision with root package name */
    private f3 f4727g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(File file, z2 z2Var) {
        this.b = file;
        this.c = z2Var;
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        int min;
        while (i3 > 0) {
            if (this.f4724d == 0 && this.f4725e == 0) {
                int b = this.a.b(bArr, i2, i3);
                if (b == -1) {
                    return;
                }
                i2 += b;
                i3 -= b;
                f3 c = this.a.c();
                this.f4727g = c;
                if (c.h()) {
                    this.f4724d = 0L;
                    this.c.k(this.f4727g.i(), this.f4727g.i().length);
                    this.f4725e = this.f4727g.i().length;
                } else if (!this.f4727g.c() || this.f4727g.b()) {
                    byte[] i4 = this.f4727g.i();
                    this.c.k(i4, i4.length);
                    this.f4724d = this.f4727g.e();
                } else {
                    this.c.f(this.f4727g.i());
                    File file = new File(this.b, this.f4727g.d());
                    file.getParentFile().mkdirs();
                    this.f4724d = this.f4727g.e();
                    this.f4726f = new FileOutputStream(file);
                }
            }
            if (!this.f4727g.b()) {
                if (this.f4727g.h()) {
                    this.c.c(this.f4725e, bArr, i2, i3);
                    this.f4725e += i3;
                    min = i3;
                } else if (this.f4727g.c()) {
                    min = (int) Math.min(i3, this.f4724d);
                    this.f4726f.write(bArr, i2, min);
                    long j2 = this.f4724d - min;
                    this.f4724d = j2;
                    if (j2 == 0) {
                        this.f4726f.close();
                    }
                } else {
                    min = (int) Math.min(i3, this.f4724d);
                    this.c.c((this.f4727g.i().length + this.f4727g.e()) - this.f4724d, bArr, i2, min);
                    this.f4724d -= min;
                }
                i2 += min;
                i3 -= min;
            }
        }
    }
}
