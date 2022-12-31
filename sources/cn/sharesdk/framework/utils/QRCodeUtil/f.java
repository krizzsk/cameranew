package cn.sharesdk.framework.utils.QRCodeUtil;
/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    

    /* renamed from: e  reason: collision with root package name */
    private static final f[] f178e;

    /* renamed from: f  reason: collision with root package name */
    private final int f180f;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f178e = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i2) {
        this.f180f = i2;
    }

    public int a() {
        return this.f180f;
    }
}
