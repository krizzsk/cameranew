package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import java.util.List;
/* loaded from: classes3.dex */
public final class fg extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final List f7519d;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public List c = eo.a();

        public final fg b() {
            return new fg(this.c, super.a());
        }
    }

    public fg(List list) {
        this(list, iu.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fg) {
            fg fgVar = (fg) obj;
            return a().equals(fgVar.a()) && this.f7519d.equals(fgVar.f7519d);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = (a().hashCode() * 37) + this.f7519d.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7519d.isEmpty()) {
            sb.append(", elements=");
            sb.append(this.f7519d);
        }
        StringBuilder replace = sb.replace(0, 2, "StringList{");
        replace.append('}');
        return replace.toString();
    }

    public fg(List list, iu iuVar) {
        super(c, iuVar);
        this.f7519d = eo.a("elements", list);
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fg.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fg fgVar = (fg) obj;
            return ej.p.a().a(1, fgVar.f7519d) + fgVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fg fgVar = (fg) obj;
            ej.p.a().a(elVar, 1, fgVar.f7519d);
            elVar.a(fgVar.a());
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
                    aVar.c.add(ej.p.a(ekVar));
                }
            }
        }
    }
}
