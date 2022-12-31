package us.pinguo.repository2020;
/* compiled from: CameraConfigRepository.kt */
/* loaded from: classes6.dex */
public final class o {
    private int a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f11930d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f11931e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11932f;

    public o(int i2, String str, String str2, String str3, Integer num, boolean z) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.f11930d = str3;
        this.f11931e = num;
        this.f11932f = z;
    }

    public final Integer a() {
        return this.f11931e;
    }

    public final boolean b() {
        return this.f11932f;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.f11930d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return this.a == oVar.a && kotlin.jvm.internal.s.c(this.b, oVar.b) && kotlin.jvm.internal.s.c(this.c, oVar.c) && kotlin.jvm.internal.s.c(this.f11930d, oVar.f11930d) && kotlin.jvm.internal.s.c(this.f11931e, oVar.f11931e) && this.f11932f == oVar.f11932f;
        }
        return false;
    }

    public final int f() {
        return this.a;
    }

    public final void g(Integer num) {
        this.f11931e = num;
    }

    public final void h(boolean z) {
        this.f11932f = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i2 = this.a * 31;
        String str = this.b;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11930d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f11931e;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z = this.f11932f;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public final void i(String str) {
        this.b = str;
    }

    public final void j(String str) {
        this.c = str;
    }

    public final void k(String str) {
        this.f11930d = str;
    }

    public final void l(int i2) {
        this.a = i2;
    }

    public String toString() {
        return "EffectPanelInfo(type=" + this.a + ", idFirst=" + ((Object) this.b) + ", idSecond=" + ((Object) this.c) + ", idThird=" + ((Object) this.f11930d) + ", beautyType=" + this.f11931e + ", filterCanceled=" + this.f11932f + ')';
    }

    public /* synthetic */ o(int i2, String str, String str2, String str3, Integer num, boolean z, int i3, kotlin.jvm.internal.o oVar) {
        this(i2, str, str2, str3, num, (i3 & 32) != 0 ? false : z);
    }
}
