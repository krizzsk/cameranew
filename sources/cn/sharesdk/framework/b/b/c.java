package cn.sharesdk.framework.b.b;

import com.mob.MobSDK;
/* compiled from: BaseEvent.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: e  reason: collision with root package name */
    public long f88e;

    /* renamed from: f  reason: collision with root package name */
    public String f89f;

    /* renamed from: g  reason: collision with root package name */
    public String f90g;

    /* renamed from: h  reason: collision with root package name */
    public int f91h;

    /* renamed from: i  reason: collision with root package name */
    public String f92i;

    /* renamed from: j  reason: collision with root package name */
    public int f93j;

    /* renamed from: k  reason: collision with root package name */
    public String f94k;

    /* renamed from: l  reason: collision with root package name */
    public String f95l;

    protected abstract String a();

    protected abstract void a(long j2);

    protected abstract int b();

    protected abstract int c();

    protected abstract long d();

    protected abstract long e();

    protected abstract void f();

    public boolean g() {
        int b = b();
        int c = c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - e() < b) {
            return d() < ((long) c);
        }
        a(currentTimeMillis);
        return true;
    }

    public void h() {
        f();
    }

    public String toString() {
        return a() + ':' + this.f88e + '|' + this.f89f + '|' + MobSDK.getAppkey() + '|' + this.f90g + '|' + this.f91h + '|' + this.f92i + '|' + this.f93j + '|' + this.f94k;
    }
}
