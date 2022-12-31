package okio;

import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes3.dex */
public final class h {
    final byte[] a;
    int b;
    int c;

    /* renamed from: d  reason: collision with root package name */
    boolean f8941d;

    /* renamed from: e  reason: collision with root package name */
    boolean f8942e;

    /* renamed from: f  reason: collision with root package name */
    h f8943f;

    /* renamed from: g  reason: collision with root package name */
    h f8944g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h() {
        this.a = new byte[8192];
        this.f8942e = true;
        this.f8941d = false;
    }

    public final void a() {
        h hVar = this.f8944g;
        if (hVar != this) {
            if (hVar.f8942e) {
                int i2 = this.c - this.b;
                if (i2 > (8192 - hVar.c) + (hVar.f8941d ? 0 : hVar.b)) {
                    return;
                }
                f(hVar, i2);
                b();
                i.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    public final h b() {
        h hVar = this.f8943f;
        h hVar2 = hVar != this ? hVar : null;
        h hVar3 = this.f8944g;
        hVar3.f8943f = hVar;
        this.f8943f.f8944g = hVar3;
        this.f8943f = null;
        this.f8944g = null;
        return hVar2;
    }

    public final h c(h hVar) {
        hVar.f8944g = this;
        hVar.f8943f = this.f8943f;
        this.f8943f.f8944g = hVar;
        this.f8943f = hVar;
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h d() {
        this.f8941d = true;
        return new h(this.a, this.b, this.c, true, false);
    }

    public final h e(int i2) {
        h b;
        if (i2 > 0 && i2 <= this.c - this.b) {
            if (i2 >= 1024) {
                b = d();
            } else {
                b = i.b();
                System.arraycopy(this.a, this.b, b.a, 0, i2);
            }
            b.c = b.b + i2;
            this.b += i2;
            this.f8944g.c(b);
            return b;
        }
        throw new IllegalArgumentException();
    }

    public final void f(h hVar, int i2) {
        if (hVar.f8942e) {
            int i3 = hVar.c;
            if (i3 + i2 > 8192) {
                if (!hVar.f8941d) {
                    int i4 = hVar.b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = hVar.a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        hVar.c -= hVar.b;
                        hVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, hVar.a, hVar.c, i2);
            hVar.c += i2;
            this.b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.f8941d = z;
        this.f8942e = z2;
    }
}
