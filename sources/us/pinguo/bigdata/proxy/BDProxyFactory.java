package us.pinguo.bigdata.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public abstract class BDProxyFactory<T extends RR:Ljava/lang/Object> implements InvocationHandler {
    protected T mOrigin;

    protected abstract Object exec(Object obj, Method method, Object[] objArr) throws Throwable;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return exec(obj, method, objArr);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [R, java.lang.Object] */
    /* JADX WARN: Unknown type variable: R in type: R */
    public R proxy(T t) {
        this.mOrigin = t;
        return Proxy.newProxyInstance(t.getClass().getClassLoader(), this.mOrigin.getClass().getInterfaces(), this);
    }
}
