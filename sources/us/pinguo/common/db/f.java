package us.pinguo.common.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DbTableDefinition.java */
/* loaded from: classes4.dex */
public class f {
    public String a;
    public List<c> b;
    public List<c> c;

    /* renamed from: d  reason: collision with root package name */
    public c f9784d;

    /* renamed from: e  reason: collision with root package name */
    public List<c> f9785e;

    /* compiled from: DbTableDefinition.java */
    /* loaded from: classes4.dex */
    public static class b {
        private String a;

        /* renamed from: d  reason: collision with root package name */
        private c f9786d;
        private List<c> b = new ArrayList();
        private List<c> c = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private List<c> f9787e = new ArrayList();

        private b g(String str, String str2, String str3) {
            c cVar = new c(str, str2, str3);
            this.b.add(cVar);
            this.f9787e.add(cVar);
            return this;
        }

        private b h(String str, String str2, String str3) {
            c cVar = new c(str, str2, str3);
            this.b.add(cVar);
            this.f9787e.add(cVar);
            this.c.add(cVar);
            return this;
        }

        private b i(String str, String str2, String str3) {
            c cVar = new c(str, str2, str3);
            this.b.add(cVar);
            this.f9786d = cVar;
            this.c.add(cVar);
            return this;
        }

        public f f() {
            return new f(this);
        }

        public b j(String str) {
            g(str, "INTEGER", str);
            return this;
        }

        public b k(String str, String str2) {
            g(str, "INTEGER", str2);
            return this;
        }

        public b l(String str, int i2) {
            g(str, "INTEGER DEFAULT (" + i2 + ")", str);
            return this;
        }

        public b m(String str, String str2, String str3) {
            g(str, "INTEGER DEFAULT (" + str2 + ")", str3);
            return this;
        }

        public b n(String str) {
            l(str, 0);
            return this;
        }

        public b o(String str) {
            g(str, "INTEGER NOT NULL", str);
            return this;
        }

        public b p(String str) {
            i(str, "INTEGER PRIMARY KEY AUTOINCREMENT", str);
            return this;
        }

        public b q(String str, String str2) {
            i(str, "INTEGER PRIMARY KEY AUTOINCREMENT", str2);
            return this;
        }

        public b r(String str) {
            g(str, "REAL", str);
            return this;
        }

        public b s(String str) {
            g(str, "VARCHAR (300)", str);
            return this;
        }

        public b t(String str, int i2) {
            g(str, "VARCHAR (" + i2 + ")", str);
            return this;
        }

        public b u(String str, int i2, String str2) {
            g(str, "VARCHAR (" + i2 + ")", str2);
            return this;
        }

        public b v(String str, String str2) {
            h(str, "VARCHAR (300) PRIMARY KEY", str2);
            return this;
        }

        public b w(String str) {
            this.a = str;
            return this;
        }
    }

    /* compiled from: DbTableDefinition.java */
    /* loaded from: classes4.dex */
    public static class c {
        public String a;
        public String b;
        public String c;

        public c(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(this.a);
        sb.append('(');
        boolean z = true;
        for (c cVar : this.b) {
            if (!z) {
                sb.append(',');
            }
            z = false;
            sb.append(cVar.a);
            sb.append(' ');
            sb.append(cVar.b);
        }
        sb.append(')');
        return sb.toString();
    }

    public String b() {
        return "DROP TABLE IF EXISTS " + this.a;
    }

    public List<c> c(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (str.equals(next.a)) {
                arrayList.add(next);
                break;
            }
        }
        return arrayList;
    }

    private f(b bVar) {
        this.a = bVar.a;
        this.c = bVar.c;
        this.f9784d = bVar.f9786d;
        this.f9785e = bVar.f9787e;
        this.b = bVar.b;
    }
}
