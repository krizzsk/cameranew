package com.bytedance.sdk.a.b;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class x implements e {
    final v a;
    final com.bytedance.sdk.a.b.a.c.j b;
    final y c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f1150d;

    /* renamed from: e  reason: collision with root package name */
    private p f1151e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1152f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealCall.java */
    /* loaded from: classes.dex */
    public final class a extends com.bytedance.sdk.a.b.a.b {
        final /* synthetic */ x a;
        private final f c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.a.c.a().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            IOException e2;
            aa f2;
            boolean z = true;
            try {
                try {
                    f2 = this.a.f();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.a.b.a()) {
                        this.c.a(this.a, new IOException("Canceled"));
                    } else {
                        this.c.a(this.a, f2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.a.f1151e.a(this.a, e2);
                        this.c.a(this.a, e2);
                    } else {
                        com.bytedance.sdk.a.b.a.g.e b = com.bytedance.sdk.a.b.a.g.e.b();
                        b.a(4, "Callback failure for " + this.a.d(), e2);
                    }
                }
            } finally {
                this.a.a.s().a(this);
            }
        }
    }

    private x(v vVar, y yVar, boolean z) {
        this.a = vVar;
        this.c = yVar;
        this.f1150d = z;
        this.b = new com.bytedance.sdk.a.b.a.c.j(vVar, z);
    }

    private void g() {
        this.b.a(com.bytedance.sdk.a.b.a.g.e.b().a("response.body().close()"));
    }

    public boolean b() {
        return this.b.a();
    }

    /* renamed from: c */
    public x clone() {
        return a(this.a, this.c, this.f1150d);
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.f1150d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    String e() {
        return this.c.a().m();
    }

    aa f() throws IOException {
        ArrayList arrayList = new ArrayList(this.a.v());
        arrayList.add(this.b);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.a.f()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.a.g()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.a));
        if (!this.f1150d) {
            arrayList.addAll(this.a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.f1150d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.c, this, this.f1151e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.f1151e = vVar.x().a(xVar);
        return xVar;
    }

    @Override // com.bytedance.sdk.a.b.e
    public aa a() throws IOException {
        synchronized (this) {
            if (!this.f1152f) {
                this.f1152f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        g();
        this.f1151e.a(this);
        try {
            try {
                this.a.s().a(this);
                aa f2 = f();
                if (f2 != null) {
                    return f2;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                this.f1151e.a(this, e2);
                throw e2;
            }
        } finally {
            this.a.s().b(this);
        }
    }
}
