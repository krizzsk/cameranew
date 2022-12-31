package us.pinguo.edit2020.model.f;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.view.f0;
import us.pinguo.u3dengine.api.PGEditBlendMode;
/* compiled from: BlendTypeModel.kt */
/* loaded from: classes4.dex */
public final class a implements f0 {
    public static final C0390a c = new C0390a(null);
    private String a;
    private final PGEditBlendMode b;

    /* compiled from: BlendTypeModel.kt */
    /* renamed from: us.pinguo.edit2020.model.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0390a {
        private C0390a() {
        }

        public /* synthetic */ C0390a(o oVar) {
            this();
        }

        public final PGEditBlendMode a(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 10) {
                        if (i2 != 11) {
                            if (i2 != 16) {
                                switch (i2) {
                                    case 3:
                                        return PGEditBlendMode.Overlay;
                                    case 4:
                                        return PGEditBlendMode.HardLight;
                                    case 5:
                                        return PGEditBlendMode.LinearLight;
                                    case 6:
                                        return PGEditBlendMode.Darken;
                                    case 7:
                                        return PGEditBlendMode.VividLight;
                                    case 8:
                                        return PGEditBlendMode.SoftLight;
                                    default:
                                        return null;
                                }
                            }
                            return PGEditBlendMode.ColorDodge;
                        }
                        return PGEditBlendMode.DarkerColor;
                    }
                    return PGEditBlendMode.Lighten;
                }
                return PGEditBlendMode.Screen;
            }
            return PGEditBlendMode.Normal;
        }
    }

    public a(String name, PGEditBlendMode mode) {
        s.h(name, "name");
        s.h(mode, "mode");
        this.a = name;
        this.b = mode;
    }

    @Override // us.pinguo.edit2020.view.f0
    public String a() {
        return this.a;
    }

    public final PGEditBlendMode b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return s.c(this.a, aVar.a) && this.b == aVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "BlendTypeModel(name=" + this.a + ", mode=" + this.b + ')';
    }
}
