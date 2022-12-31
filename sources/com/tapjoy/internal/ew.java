package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import java.util.List;
/* loaded from: classes3.dex */
public final class ew extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final List f7450d;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public List c = eo.a();

        public final ew b() {
            return new ew(this.c, super.a());
        }
    }

    public ew(List list, iu iuVar) {
        super(c, iuVar);
        this.f7450d = eo.a("events", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ew) {
            ew ewVar = (ew) obj;
            return a().equals(ewVar.a()) && this.f7450d.equals(ewVar.f7450d);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = (a().hashCode() * 37) + this.f7450d.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f7450d.isEmpty()) {
            sb.append(", events=");
            sb.append(this.f7450d);
        }
        StringBuilder replace = sb.replace(0, 2, "EventBatch{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, ew.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ew ewVar = (ew) obj;
            return ev.c.a().a(1, ewVar.f7450d) + ewVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ew ewVar = (ew) obj;
            ev.c.a().a(elVar, 1, ewVar.f7450d);
            elVar.a(ewVar.a());
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
                    aVar.c.add(ev.c.a(ekVar));
                }
            }
        }
    }
}
