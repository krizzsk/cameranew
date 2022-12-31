package us.pinguo.bigdata.task.basic;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import us.pinguo.bigdata.proxy.BDProxyFactory;
import us.pinguo.bigdata.task.b;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: BDTaskProxyFactory.java */
/* loaded from: classes3.dex */
public class a<T extends IBDTask> extends BDProxyFactory<T, IBDTask> {
    private ExecutorService a;
    private Runnable b;
    private Future<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BDTaskProxyFactory.java */
    /* renamed from: us.pinguo.bigdata.task.basic.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0361a implements Runnable {
        final /* synthetic */ IBDTask a;

        RunnableC0361a(a aVar, IBDTask iBDTask) {
            this.a = iBDTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.execute();
        }
    }

    private a() {
    }

    public static <T extends IBDTask> a<T> a() {
        return new a<>();
    }

    @Override // us.pinguo.bigdata.proxy.BDProxyFactory
    /* renamed from: b */
    public IBDTask proxy(T t) {
        if (t instanceof b) {
            this.a = Executors.newSingleThreadExecutor();
        } else {
            this.a = Executors.newCachedThreadPool();
        }
        this.b = new RunnableC0361a(this, t);
        return (IBDTask) super.proxy(t);
    }

    @Override // us.pinguo.bigdata.proxy.BDProxyFactory
    protected Object exec(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals("execute")) {
            this.c = this.a.submit(this.b);
            return null;
        } else if (method.getName().equals("destroy")) {
            ((IBDTask) this.mOrigin).destroy();
            Future<?> future = this.c;
            if (future != null) {
                future.cancel(true);
                return null;
            }
            return null;
        } else if (method.getName().equals("getOrigin")) {
            return this.mOrigin;
        } else {
            return null;
        }
    }
}
