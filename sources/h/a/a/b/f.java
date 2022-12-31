package h.a.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* compiled from: SignatureImpl.java */
/* loaded from: classes3.dex */
abstract class f implements org.aspectj.lang.b {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f8648h = true;
    int a;
    String b;
    String c;

    /* renamed from: d  reason: collision with root package name */
    Class f8649d;

    /* renamed from: e  reason: collision with root package name */
    a f8650e;

    /* renamed from: f  reason: collision with root package name */
    private String f8651f;

    /* renamed from: g  reason: collision with root package name */
    ClassLoader f8652g = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SignatureImpl.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, String str);

        String get(int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SignatureImpl.java */
    /* loaded from: classes3.dex */
    public static final class b implements a {
        private SoftReference a;

        public b() {
            c();
        }

        private String[] b() {
            return (String[]) this.a.get();
        }

        private String[] c() {
            String[] strArr = new String[3];
            this.a = new SoftReference(strArr);
            return strArr;
        }

        @Override // h.a.a.b.f.a
        public void a(int i2, String str) {
            String[] b = b();
            if (b == null) {
                b = c();
            }
            b[i2] = str;
        }

        @Override // h.a.a.b.f.a
        public String get(int i2) {
            String[] b = b();
            if (b == null) {
                return null;
            }
            return b[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i2, String str, Class cls) {
        this.a = -1;
        this.a = i2;
        this.b = str;
        this.f8649d = cls;
    }

    private ClassLoader h() {
        if (this.f8652g == null) {
            this.f8652g = getClass().getClassLoader();
        }
        return this.f8652g;
    }

    protected abstract String a(h hVar);

    int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    String c(int i2) {
        int indexOf = this.f8651f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = indexOf + 1;
            indexOf = this.f8651f.indexOf(45, i3);
            i2 = i4;
        }
        if (indexOf == -1) {
            indexOf = this.f8651f.length();
        }
        return this.f8651f.substring(i3, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class d(int i2) {
        return h.a.a.b.b.b(c(i2), h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] e(int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer(c(i2), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            clsArr[i3] = h.a.a.b.b.b(stringTokenizer.nextToken(), h());
        }
        return clsArr;
    }

    public Class f() {
        if (this.f8649d == null) {
            this.f8649d = d(2);
        }
        return this.f8649d;
    }

    public String g() {
        if (this.c == null) {
            this.c = f().getName();
        }
        return this.c;
    }

    public int i() {
        if (this.a == -1) {
            this.a = b(0);
        }
        return this.a;
    }

    public String j() {
        if (this.b == null) {
            this.b = c(1);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String k(h.a.a.b.h r3) {
        /*
            r2 = this;
            boolean r0 = h.a.a.b.f.f8648h
            if (r0 == 0) goto L1b
            h.a.a.b.f$a r0 = r2.f8650e
            if (r0 != 0) goto L14
            h.a.a.b.f$b r0 = new h.a.a.b.f$b     // Catch: java.lang.Throwable -> L10
            r0.<init>()     // Catch: java.lang.Throwable -> L10
            r2.f8650e = r0     // Catch: java.lang.Throwable -> L10
            goto L1b
        L10:
            r0 = 0
            h.a.a.b.f.f8648h = r0
            goto L1b
        L14:
            int r1 = r3.f8658f
            java.lang.String r0 = r0.get(r1)
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 != 0) goto L22
            java.lang.String r0 = r2.a(r3)
        L22:
            boolean r1 = h.a.a.b.f.f8648h
            if (r1 == 0) goto L2d
            h.a.a.b.f$a r1 = r2.f8650e
            int r3 = r3.f8658f
            r1.a(r3, r0)
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.b.f.k(h.a.a.b.h):java.lang.String");
    }

    public final String toString() {
        return k(h.f8654h);
    }
}
