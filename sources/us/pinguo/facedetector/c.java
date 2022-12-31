package us.pinguo.facedetector;

import kotlin.jvm.internal.s;
/* compiled from: FaceResult.kt */
/* loaded from: classes4.dex */
public final class c {
    private final boolean a;
    private int b;
    private final b[] c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10972d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10973e;

    public c(b[] faces, int i2, int i3) {
        s.i(faces, "faces");
        this.c = faces;
        this.f10972d = i2;
        this.f10973e = i3;
        this.a = !(faces.length == 0);
        this.b = -1;
    }

    public static /* synthetic */ void b(c cVar, int i2, boolean z, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = cVar.f10972d;
        }
        if ((i5 & 8) != 0) {
            i4 = cVar.f10973e;
        }
        cVar.a(i2, z, i3, i4);
    }

    public final void a(int i2, boolean z, int i3, int i4) {
        if (this.a) {
            for (b bVar : this.c) {
                a.a.a(bVar, i3, i4, i2, z);
            }
        }
    }

    public final int c() {
        return this.c.length;
    }

    public final b[] d() {
        return this.c;
    }

    public final int e() {
        return this.f10973e;
    }

    public final int f() {
        return this.f10972d;
    }

    public final b g() {
        if (this.a) {
            b[] bVarArr = this.c;
            int i2 = 0;
            if (bVarArr.length == 1) {
                return bVarArr[0];
            }
            int i3 = this.b;
            if (i3 != -1) {
                return bVarArr[i3];
            }
            float f2 = 0.0f;
            int length = bVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i2 < length) {
                b bVar = bVarArr[i2];
                int i6 = i5 + 1;
                float l2 = bVar.l(74);
                float m = bVar.m(74);
                float l3 = l2 - bVar.l(77);
                float m2 = m - bVar.m(77);
                float f3 = (l3 * l3) + (m2 * m2);
                if (f3 > f2) {
                    i4 = i5;
                    f2 = f3;
                }
                i2++;
                i5 = i6;
            }
            this.b = i4;
            return this.c[i4];
        }
        return null;
    }

    public final boolean h() {
        return this.a;
    }

    public final void i() {
        b[] bVarArr;
        if (this.a) {
            for (b bVar : this.c) {
                a aVar = a.a;
                aVar.d(bVar.f());
                aVar.c(bVar.c());
            }
        }
    }
}
