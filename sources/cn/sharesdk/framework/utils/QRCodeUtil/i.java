package cn.sharesdk.framework.utils.QRCodeUtil;
/* compiled from: Mode.java */
/* loaded from: classes.dex */
public enum i {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: k  reason: collision with root package name */
    private final int[] f197k;

    /* renamed from: l  reason: collision with root package name */
    private final int f198l;

    i(int[] iArr, int i2) {
        this.f197k = iArr;
        this.f198l = i2;
    }

    public int a(n nVar) {
        int a = nVar.a();
        return this.f197k[a <= 9 ? (char) 0 : a <= 26 ? (char) 1 : (char) 2];
    }

    public int a() {
        return this.f198l;
    }
}
