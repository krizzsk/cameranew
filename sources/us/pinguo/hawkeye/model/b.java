package us.pinguo.hawkeye.model;

import us.pinguo.hawkeye.d.c;
/* compiled from: PageModel.kt */
/* loaded from: classes4.dex */
public final class b {
    private c a;
    private c b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private c f11163d;

    /* renamed from: e  reason: collision with root package name */
    private c f11164e;

    /* renamed from: f  reason: collision with root package name */
    private c f11165f;

    /* renamed from: g  reason: collision with root package name */
    private final us.pinguo.hawkeye.d.b f11166g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.hawkeye.d.b f11167h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11168i;

    public final int a(long j2) {
        return this.f11166g.a(j2);
    }

    public final boolean b() {
        c cVar = this.b;
        if (!(cVar != null ? cVar.b() : false)) {
            c cVar2 = this.f11163d;
            if (!(cVar2 != null ? cVar2.b() : false)) {
                return false;
            }
        }
        return true;
    }

    public final c c() {
        return this.b;
    }

    public final String d() {
        return this.f11168i;
    }

    public final c e() {
        return this.f11163d;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.f11167h != null) {
            str = ", glView:" + this.f11167h;
        } else {
            str = "";
        }
        if (this.a != null) {
            str2 = "create " + this.a;
        } else {
            str2 = "";
        }
        if (this.b != null) {
            str3 = ", draw " + this.b;
        } else {
            str3 = "";
        }
        if (this.c != null) {
            str4 = "create " + this.c;
        } else {
            str4 = "";
        }
        if (this.f11163d != null) {
            str5 = ", draw " + this.f11163d;
        } else {
            str5 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n[");
        sb.append(this.f11168i);
        sb.append("]\n");
        sb.append("first: ");
        sb.append(str2);
        sb.append(str3);
        sb.append('\n');
        sb.append("last: ");
        sb.append(str4);
        sb.append(str5);
        sb.append('\n');
        sb.append("firstPause: ");
        c cVar = this.f11164e;
        if (cVar == null) {
            cVar = "";
        }
        sb.append(cVar);
        sb.append('\n');
        sb.append("lastPause: ");
        Object obj = this.f11165f;
        sb.append(obj != null ? obj : "");
        sb.append('\n');
        sb.append(this.f11166g);
        sb.append(str);
        return sb.toString();
    }
}
