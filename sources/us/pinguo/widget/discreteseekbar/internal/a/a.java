package us.pinguo.widget.discreteseekbar.internal.a;

import android.os.Build;
/* compiled from: AnimatorCompat.java */
/* loaded from: classes6.dex */
public abstract class a {

    /* compiled from: AnimatorCompat.java */
    /* renamed from: us.pinguo.widget.discreteseekbar.internal.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0467a {
        void a(float f2);
    }

    /* compiled from: AnimatorCompat.java */
    /* loaded from: classes6.dex */
    private static class b extends a {
        private final InterfaceC0467a a;
        private final float b;

        public b(float f2, float f3, InterfaceC0467a interfaceC0467a) {
            this.a = interfaceC0467a;
            this.b = f3;
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a
        public void a() {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a
        public boolean c() {
            return false;
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a
        public void d(int i2) {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a
        public void e() {
            this.a.a(this.b);
        }
    }

    public static final a b(float f2, float f3, InterfaceC0467a interfaceC0467a) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new us.pinguo.widget.discreteseekbar.internal.a.b(f2, f3, interfaceC0467a);
        }
        return new b(f2, f3, interfaceC0467a);
    }

    public abstract void a();

    public abstract boolean c();

    public abstract void d(int i2);

    public abstract void e();
}
