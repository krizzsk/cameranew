package us.pinguo.push;

import java.util.Date;
import java.util.Random;
/* compiled from: PushControl.java */
/* loaded from: classes6.dex */
public abstract class c<T> {

    /* renamed from: d  reason: collision with root package name */
    protected int f11771d;

    /* renamed from: h  reason: collision with root package name */
    protected T f11775h;
    protected String a = null;
    protected String b = null;
    protected int c = -1;

    /* renamed from: e  reason: collision with root package name */
    protected Date f11772e = null;

    /* renamed from: f  reason: collision with root package name */
    protected Date f11773f = null;

    /* renamed from: g  reason: collision with root package name */
    protected h f11774g = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public Date a() {
        return this.f11772e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h d() {
        return this.f11774g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        return new Random().nextInt(2030043135);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            String str = this.b;
            if (str == null) {
                if (cVar.b != null) {
                    return false;
                }
            } else if (!str.equals(cVar.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Date g() {
        return this.f11773f;
    }

    public void h(int i2, String str) {
    }

    public int hashCode() {
        String str = this.b;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public abstract T i(String str);

    public abstract PushResult j();
}
