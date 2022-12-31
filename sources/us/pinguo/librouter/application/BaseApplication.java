package us.pinguo.librouter.application;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.Objects;
import us.pinguo.common.log.a;
import us.pinguo.foundation.d;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.i0;
import us.pinguo.util.v;
/* loaded from: classes5.dex */
public abstract class BaseApplication extends Application {

    /* renamed from: e  reason: collision with root package name */
    private static BaseApplication f11533e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f11534f = true;
    private boolean a = false;
    private final i0 b = new i0("Application");
    protected int c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f11535d = 0;

    private boolean a(String str) {
        if (str == null) {
            str = "";
        }
        String f2 = f();
        return f2 == null || str.equals(f2);
    }

    private void b() {
        boolean z = d.f10985d;
    }

    public static Context d() {
        BaseApplication baseApplication = f11533e;
        Objects.requireNonNull(baseApplication, "App getInstance not create or be terminated");
        return baseApplication.getApplicationContext();
    }

    public static Application e() {
        BaseApplication baseApplication = f11533e;
        Objects.requireNonNull(baseApplication, "App getInstance not create or be terminated");
        return baseApplication;
    }

    private String f() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f11533e = this;
        this.a = a(context.getPackageName());
    }

    public void c(Runnable runnable) {
        this.b.a(runnable);
    }

    protected abstract void g(boolean z);

    protected abstract void h();

    protected abstract void i();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        e.f(this);
        v.k(this);
        g(this.a);
        h();
        if (this.a) {
            i();
            b();
        }
        a.c("Application onCreate, pid=" + Process.myPid(), new Object[0]);
        this.b.b();
    }
}
