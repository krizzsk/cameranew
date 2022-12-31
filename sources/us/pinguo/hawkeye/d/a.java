package us.pinguo.hawkeye.d;

import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.t;
/* compiled from: DeviceInfo.kt */
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: k  reason: collision with root package name */
    public static final C0398a f11146k = new C0398a(null);
    private final String a;
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11147d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11148e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11149f;

    /* renamed from: g  reason: collision with root package name */
    private final float f11150g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11151h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11152i;

    /* renamed from: j  reason: collision with root package name */
    private final String[] f11153j;

    /* compiled from: DeviceInfo.kt */
    /* renamed from: us.pinguo.hawkeye.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0398a {
        private C0398a() {
        }

        public final a a() {
            us.pinguo.hawkeye.util.a aVar = us.pinguo.hawkeye.util.a.a;
            return new a(aVar.c(), aVar.d(), aVar.e(), aVar.i(), aVar.h(), aVar.g(), aVar.f(), aVar.b(), aVar.a(), aVar.j());
        }

        public /* synthetic */ C0398a(o oVar) {
            this();
        }
    }

    public a(String manufacturer, String model, String systemVersion, int i2, int i3, int i4, float f2, String language, String country, String[] abis) {
        s.i(manufacturer, "manufacturer");
        s.i(model, "model");
        s.i(systemVersion, "systemVersion");
        s.i(language, "language");
        s.i(country, "country");
        s.i(abis, "abis");
        this.a = manufacturer;
        this.b = model;
        this.c = systemVersion;
        this.f11147d = i2;
        this.f11148e = i3;
        this.f11149f = i4;
        this.f11150g = f2;
        this.f11151h = language;
        this.f11152i = country;
        this.f11153j = abis;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (s.c(this.a, aVar.a) && s.c(this.b, aVar.b) && s.c(this.c, aVar.c)) {
                    if (this.f11147d == aVar.f11147d) {
                        if (this.f11148e == aVar.f11148e) {
                            if (!(this.f11149f == aVar.f11149f) || Float.compare(this.f11150g, aVar.f11150g) != 0 || !s.c(this.f11151h, aVar.f11151h) || !s.c(this.f11152i, aVar.f11152i) || !s.c(this.f11153j, aVar.f11153j)) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((((((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f11147d) * 31) + this.f11148e) * 31) + this.f11149f) * 31) + Float.floatToIntBits(this.f11150g)) * 31;
        String str4 = this.f11151h;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f11152i;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String[] strArr = this.f11153j;
        return hashCode5 + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        boolean m;
        String str = "(";
        for (String str2 : this.f11153j) {
            str = str + str2 + ", ";
        }
        m = t.m(str, ", ", false, 2, null);
        if (m) {
            int length = str.length() - 2;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(0, length);
            s.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return "<Device> " + this.a + '_' + this.b + "_Android" + this.c + '_' + this.f11147d + 'x' + this.f11148e + '_' + this.f11149f + "dpi_" + this.f11151h + '_' + this.f11152i + '_' + (str + ")");
    }
}
