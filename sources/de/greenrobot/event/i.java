package de.greenrobot.event;

import com.growingio.android.sdk.collection.Constants;
import java.lang.reflect.Method;
/* compiled from: SubscriberMethod.java */
/* loaded from: classes3.dex */
final class i {
    final Method a;
    final ThreadMode b;
    final Class<?> c;

    /* renamed from: d  reason: collision with root package name */
    String f8627d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.f8627d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append(Constants.ID_PREFIX);
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f8627d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            a();
            return this.f8627d.equals(((i) obj).f8627d);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
