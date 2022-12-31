package d.e.a;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
/* compiled from: EventsConfiguration.java */
/* loaded from: classes2.dex */
public final class a {
    private String a;
    private boolean b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private d f8518d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8519e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Pair<String, String>> f8520f;

    /* compiled from: EventsConfiguration.java */
    /* renamed from: d.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0295a {
        private String a;

        /* renamed from: d  reason: collision with root package name */
        private d f8521d;
        private boolean b = false;
        private String c = "POST";

        /* renamed from: e  reason: collision with root package name */
        private boolean f8522e = false;

        /* renamed from: f  reason: collision with root package name */
        private ArrayList<Pair<String, String>> f8523f = new ArrayList<>();

        public C0295a(String str) {
            this.a = "";
            if (str == null || str.isEmpty()) {
                return;
            }
            this.a = str;
        }

        public C0295a g(List<Pair<String, String>> list) {
            this.f8523f.addAll(list);
            return this;
        }

        public a h() {
            return new a(this);
        }

        public C0295a i(boolean z) {
            this.f8522e = z;
            return this;
        }

        public C0295a j(boolean z) {
            this.b = z;
            return this;
        }

        public C0295a k(d dVar) {
            this.f8521d = dVar;
            return this;
        }

        public C0295a l() {
            this.c = "GET";
            return this;
        }
    }

    a(C0295a c0295a) {
        this.f8519e = false;
        this.a = c0295a.a;
        this.b = c0295a.b;
        this.c = c0295a.c;
        this.f8518d = c0295a.f8521d;
        this.f8519e = c0295a.f8522e;
        if (c0295a.f8523f != null) {
            this.f8520f = new ArrayList<>(c0295a.f8523f);
        }
    }

    public boolean a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public d c() {
        return this.f8518d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f8520f);
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.f8519e;
    }
}
