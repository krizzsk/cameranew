package cn.sharesdk.framework.utils.QRCodeUtil;
/* compiled from: GenericGF.java */
/* loaded from: classes.dex */
public final class g {
    public static final g a = new g(4201, 4096, 1);
    public static final g b = new g(1033, 1024, 1);
    public static final g c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f181d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f182e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f183f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f184g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f185h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f186i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f187j;

    /* renamed from: k  reason: collision with root package name */
    private final h f188k;

    /* renamed from: l  reason: collision with root package name */
    private final h f189l;
    private final int m;
    private final int n;
    private final int o;

    static {
        g gVar = new g(67, 64, 1);
        c = gVar;
        f181d = new g(19, 16, 1);
        f182e = new g(285, 256, 0);
        g gVar2 = new g(301, 256, 1);
        f183f = gVar2;
        f184g = gVar2;
        f185h = gVar;
    }

    public g(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.f186i = new int[i3];
        this.f187j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f186i[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f187j[this.f186i[i7]] = i7;
        }
        this.f188k = new h(this, new int[]{0});
        this.f189l = new h(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, int i3) {
        return i2 ^ i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a() {
        return this.f188k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2) {
        if (i2 != 0) {
            return this.f187j[i2];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        if (i2 != 0) {
            return this.f186i[(this.m - this.f187j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.f188k;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new h(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f186i;
        int[] iArr2 = this.f187j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        return this.f186i[i2];
    }
}
