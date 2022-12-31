package us.pinguo.common.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: DbDefinition.java */
/* loaded from: classes4.dex */
public class c {
    public int a;
    public String b;
    boolean c;

    /* renamed from: d  reason: collision with root package name */
    public List<f> f9777d;

    /* renamed from: e  reason: collision with root package name */
    Map<Integer, i> f9778e;

    /* compiled from: DbDefinition.java */
    /* loaded from: classes4.dex */
    public static class b {
        private int a;
        private String b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private List<f> f9779d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private Map<Integer, i> f9780e = new HashMap();

        public c f() {
            return new c(this);
        }

        public b g(String str) {
            this.b = str;
            return this;
        }

        public b h(f fVar) {
            this.f9779d.add(fVar);
            return this;
        }

        public b i(i iVar) {
            int i2 = iVar.b;
            int i3 = iVar.a;
            if (i2 - i3 == 1) {
                if (this.f9780e.get(Integer.valueOf(i3)) == null) {
                    this.f9780e.put(Integer.valueOf(iVar.a), iVar);
                    return this;
                }
                throw new IllegalArgumentException("already define fromVersion" + iVar.a);
            }
            throw new IllegalArgumentException("upgrade should like from n to n+1");
        }

        public b j(int i2) {
            this.a = i2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.f9777d) {
            arrayList.add(fVar.a());
        }
        return arrayList;
    }

    List<String> b() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.f9777d) {
            arrayList.add(fVar.b());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> c(int i2) {
        ArrayList arrayList = new ArrayList();
        if (this.c) {
            arrayList.addAll(b());
            arrayList.addAll(a());
        } else {
            while (i2 < this.a) {
                arrayList.addAll(this.f9778e.get(Integer.valueOf(i2)).c);
                i2++;
            }
        }
        return arrayList;
    }

    private c(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f9777d = bVar.f9779d;
        boolean z = bVar.c;
        this.c = z;
        if (!z) {
            this.f9778e = bVar.f9780e;
        } else {
            this.f9778e = new HashMap();
        }
    }
}
