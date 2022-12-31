package us.pinguo.foundation.m;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import us.pinguo.foundation.m.e;
/* compiled from: CountingOutputStream.java */
/* loaded from: classes4.dex */
public class b extends FilterOutputStream {
    private final e.a a;
    private long b;

    public b(OutputStream outputStream, e.a aVar) {
        super(outputStream);
        this.a = aVar;
        this.b = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        long j2 = i3;
        long j3 = this.b + j2;
        this.b = j3;
        e.a aVar = this.a;
        if (aVar != null) {
            aVar.transferred(j3, j2);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        long j2 = this.b + 1;
        this.b = j2;
        e.a aVar = this.a;
        if (aVar != null) {
            aVar.transferred(j2, 1L);
        }
    }
}
