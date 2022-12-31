package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.i;
import cn.sharesdk.framework.utils.QRCodeUtil.n;
/* compiled from: QRCode.java */
/* loaded from: classes.dex */
public final class f {
    private i a;
    private cn.sharesdk.framework.utils.QRCodeUtil.f b;
    private n c;

    /* renamed from: d  reason: collision with root package name */
    private int f156d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f157e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.f157e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.f156d);
        if (this.f157e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f157e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(i iVar) {
        this.a = iVar;
    }

    public void a(cn.sharesdk.framework.utils.QRCodeUtil.f fVar) {
        this.b = fVar;
    }

    public void a(n nVar) {
        this.c = nVar;
    }

    public void a(int i2) {
        this.f156d = i2;
    }

    public void a(b bVar) {
        this.f157e = bVar;
    }
}
