package com.tapjoy.internal;

import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class fb extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final fa f7483d;

    /* renamed from: e  reason: collision with root package name */
    public final eu f7484e;

    /* renamed from: f  reason: collision with root package name */
    public final fh f7485f;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public fa c;

        /* renamed from: d  reason: collision with root package name */
        public eu f7486d;

        /* renamed from: e  reason: collision with root package name */
        public fh f7487e;

        public final fb b() {
            return new fb(this.c, this.f7486d, this.f7487e, super.a());
        }
    }

    public fb(fa faVar, eu euVar, fh fhVar) {
        this(faVar, euVar, fhVar, iu.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fb) {
            fb fbVar = (fb) obj;
            return a().equals(fbVar.a()) && eo.a(this.f7483d, fbVar.f7483d) && eo.a(this.f7484e, fbVar.f7484e) && eo.a(this.f7485f, fbVar.f7485f);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            fa faVar = this.f7483d;
            int hashCode2 = (hashCode + (faVar != null ? faVar.hashCode() : 0)) * 37;
            eu euVar = this.f7484e;
            int hashCode3 = (hashCode2 + (euVar != null ? euVar.hashCode() : 0)) * 37;
            fh fhVar = this.f7485f;
            int hashCode4 = hashCode3 + (fhVar != null ? fhVar.hashCode() : 0);
            this.b = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7483d != null) {
            sb.append(", info=");
            sb.append(this.f7483d);
        }
        if (this.f7484e != null) {
            sb.append(", app=");
            sb.append(this.f7484e);
        }
        if (this.f7485f != null) {
            sb.append(", user=");
            sb.append(this.f7485f);
        }
        StringBuilder replace = sb.replace(0, 2, "InfoSet{");
        replace.append('}');
        return replace.toString();
    }

    public fb(fa faVar, eu euVar, fh fhVar, iu iuVar) {
        super(c, iuVar);
        this.f7483d = faVar;
        this.f7484e = euVar;
        this.f7485f = fhVar;
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fb.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fb fbVar = (fb) obj;
            fa faVar = fbVar.f7483d;
            int a = faVar != null ? fa.c.a(1, faVar) : 0;
            eu euVar = fbVar.f7484e;
            int a2 = a + (euVar != null ? eu.c.a(2, euVar) : 0);
            fh fhVar = fbVar.f7485f;
            return a2 + (fhVar != null ? fh.c.a(3, fhVar) : 0) + fbVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fb fbVar = (fb) obj;
            fa faVar = fbVar.f7483d;
            if (faVar != null) {
                fa.c.a(elVar, 1, faVar);
            }
            eu euVar = fbVar.f7484e;
            if (euVar != null) {
                eu.c.a(elVar, 2, euVar);
            }
            fh fhVar = fbVar.f7485f;
            if (fhVar != null) {
                fh.c.a(elVar, 3, fhVar);
            }
            elVar.a(fbVar.a());
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
                } else if (b == 1) {
                    aVar.c = (fa) fa.c.a(ekVar);
                } else if (b == 2) {
                    aVar.f7486d = (eu) eu.c.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7487e = (fh) fh.c.a(ekVar);
                }
            }
        }
    }
}
