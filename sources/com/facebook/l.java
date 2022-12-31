package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressNoopOutputStream.java */
/* loaded from: classes.dex */
public class l extends OutputStream implements n {
    private final Map<GraphRequest, o> a = new HashMap();
    private final Handler b;
    private GraphRequest c;

    /* renamed from: d  reason: collision with root package name */
    private o f3100d;

    /* renamed from: e  reason: collision with root package name */
    private int f3101e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Handler handler) {
        this.b = handler;
    }

    @Override // com.facebook.n
    public void a(GraphRequest graphRequest) {
        this.c = graphRequest;
        this.f3100d = graphRequest != null ? this.a.get(graphRequest) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j2) {
        if (this.f3100d == null) {
            o oVar = new o(this.b, this.c);
            this.f3100d = oVar;
            this.a.put(this.c, oVar);
        }
        this.f3100d.b(j2);
        this.f3101e = (int) (this.f3101e + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t() {
        return this.f3101e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<GraphRequest, o> v() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        i(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        i(i3);
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        i(1L);
    }
}
