package us.pinguo.hawkeye.debug;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: InternalDebugHelper.java */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, c> f11154j = new HashMap();
    private String a;
    private long b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private long f11155d;

    /* renamed from: e  reason: collision with root package name */
    private long f11156e;

    /* renamed from: f  reason: collision with root package name */
    private List<d> f11157f;

    /* renamed from: g  reason: collision with root package name */
    private int f11158g;

    /* renamed from: h  reason: collision with root package name */
    private int f11159h;

    /* renamed from: i  reason: collision with root package name */
    private String f11160i;

    public c() {
        this("");
    }

    public static c b(String str) {
        if (f11154j.get(str) == null) {
            c cVar = new c(str);
            cVar.f11160i = str;
            f11154j.put(str, cVar);
        }
        return f11154j.get(str);
    }

    private String c() {
        a[] d2;
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.f11160i + "]" + this.a + " Time Debuger [\n");
        for (a aVar : d()) {
            sb.append("TAG: ");
            sb.append(aVar.a);
            sb.append("\t INC: ");
            sb.append(aVar.b);
            sb.append("\t INCP: ");
            sb.append(aVar.c);
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    private a[] d() {
        a[] aVarArr = new a[this.f11157f.size()];
        List<d> list = this.f11157f;
        long j2 = list.get(list.size() - 1).b;
        int i2 = 0;
        for (d dVar : this.f11157f) {
            long j3 = dVar.b;
            aVarArr[i2] = new a(dVar.a, j3, j3 / (j2 * 1.0d));
            i2++;
        }
        return aVarArr;
    }

    private void e(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        this.f11159h = this.f11158g;
        this.f11158g = stackTraceElement.getLineNumber();
        this.b = this.c;
        long currentTimeMillis = System.currentTimeMillis();
        this.c = currentTimeMillis;
        this.f11157f.add(new d(str + " [" + this.f11159h + "-->" + this.f11158g + "] ", currentTimeMillis - this.b));
    }

    private void g() {
        us.pinguo.hawkeye.f.a.a(c());
    }

    public void a() {
        if (us.pinguo.hawkeye.b.f11145f.c().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f11156e = currentTimeMillis;
            this.f11157f.add(new d("total", currentTimeMillis - this.f11155d));
            g();
            if (f11154j.get(this.f11160i) != null) {
                f11154j.remove(this.f11160i);
            }
            f11154j.remove(this.f11160i);
        }
    }

    public void f(String str) {
        if (us.pinguo.hawkeye.b.f11145f.c().b()) {
            e(str);
            a();
        }
    }

    public c(String str) {
        this.b = 0L;
        this.c = 0L;
        this.f11155d = 0L;
        this.f11156e = 0L;
        this.f11157f = new LinkedList();
        this.f11158g = 0;
        this.f11159h = 0;
        this.f11160i = str;
    }
}
