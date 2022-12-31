package com.facebook;

import android.os.Handler;
import com.facebook.i;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressOutputStream.java */
/* loaded from: classes.dex */
public class m extends FilterOutputStream implements n {
    private final Map<GraphRequest, o> a;
    private final i b;
    private final long c;

    /* renamed from: d  reason: collision with root package name */
    private long f3131d;

    /* renamed from: e  reason: collision with root package name */
    private long f3132e;

    /* renamed from: f  reason: collision with root package name */
    private long f3133f;

    /* renamed from: g  reason: collision with root package name */
    private o f3134g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressOutputStream.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ i.b a;

        a(i.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.b(m.this.b, m.this.f3131d, m.this.f3133f);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(OutputStream outputStream, i iVar, Map<GraphRequest, o> map, long j2) {
        super(outputStream);
        this.b = iVar;
        this.a = map;
        this.f3133f = j2;
        this.c = f.v();
    }

    private void i(long j2) {
        o oVar = this.f3134g;
        if (oVar != null) {
            oVar.a(j2);
        }
        long j3 = this.f3131d + j2;
        this.f3131d = j3;
        if (j3 >= this.f3132e + this.c || j3 >= this.f3133f) {
            t();
        }
    }

    private void t() {
        if (this.f3131d > this.f3132e) {
            for (i.a aVar : this.b.k()) {
                if (aVar instanceof i.b) {
                    Handler j2 = this.b.j();
                    i.b bVar = (i.b) aVar;
                    if (j2 == null) {
                        bVar.b(this.b, this.f3131d, this.f3133f);
                    } else {
                        j2.post(new a(bVar));
                    }
                }
            }
            this.f3132e = this.f3131d;
        }
    }

    @Override // com.facebook.n
    public void a(GraphRequest graphRequest) {
        this.f3134g = graphRequest != null ? this.a.get(graphRequest) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        for (o oVar : this.a.values()) {
            oVar.c();
        }
        t();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        ((FilterOutputStream) this).out.write(bArr);
        i(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        i(i3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        i(1L);
    }
}
