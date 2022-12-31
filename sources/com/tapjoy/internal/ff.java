package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import java.util.List;
/* loaded from: classes3.dex */
public final class ff extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final List f7518d;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public List c = eo.a();

        public final ff b() {
            return new ff(this.c, super.a());
        }
    }

    public ff(List list) {
        this(list, iu.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ff) {
            ff ffVar = (ff) obj;
            return a().equals(ffVar.a()) && this.f7518d.equals(ffVar.f7518d);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = (a().hashCode() * 37) + this.f7518d.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7518d.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.f7518d);
        }
        StringBuilder replace = sb.replace(0, 2, "PushList{");
        replace.append('}');
        return replace.toString();
    }

    public ff(List list, iu iuVar) {
        super(c, iuVar);
        this.f7518d = eo.a("pushes", list);
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, ff.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ff ffVar = (ff) obj;
            return fe.c.a().a(1, ffVar.f7518d) + ffVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ff ffVar = (ff) obj;
            fe.c.a().a(elVar, 1, ffVar.f7518d);
            elVar.a(ffVar.a());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b == -1) {
                    ekVar.a(a);
                    return aVar.b();
                } else if (b != 1) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.c.add(fe.c.a(ekVar));
                }
            }
        }
    }
}
