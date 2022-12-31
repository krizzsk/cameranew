package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: IronSourceLoggerManager.java */
/* loaded from: classes2.dex */
public class c extends IronSourceLogger implements d {

    /* renamed from: d  reason: collision with root package name */
    private static c f5579d;
    private ArrayList<IronSourceLogger> c;

    private c(String str) {
        super(str);
        this.c = new ArrayList<>();
        k();
    }

    private IronSourceLogger h(String str) {
        Iterator<IronSourceLogger> it = this.c.iterator();
        while (it.hasNext()) {
            IronSourceLogger next = it.next();
            if (next.c().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static synchronized c i() {
        c cVar;
        synchronized (c.class) {
            if (f5579d == null) {
                f5579d = new c(c.class.getSimpleName());
            }
            cVar = f5579d;
        }
        return cVar;
    }

    public static synchronized c j(int i2) {
        c cVar;
        synchronized (c.class) {
            c cVar2 = f5579d;
            if (cVar2 == null) {
                f5579d = new c(c.class.getSimpleName());
            } else {
                cVar2.a = i2;
            }
            cVar = f5579d;
        }
        return cVar;
    }

    private void k() {
        this.c.add(new a(0));
    }

    @Override // com.ironsource.mediationsdk.logger.d
    public synchronized void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        d(ironSourceTag, str, i2);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void d(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        if (i2 < this.a) {
            return;
        }
        Iterator<IronSourceLogger> it = this.c.iterator();
        while (it.hasNext()) {
            IronSourceLogger next = it.next();
            if (next.b() <= i2) {
                next.d(ironSourceTag, str, i2);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void e(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().d(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.c.iterator();
            while (it2.hasNext()) {
                it2.next().e(ironSourceTag, str, th);
            }
        }
    }

    public void g(IronSourceLogger ironSourceLogger) {
        this.c.add(ironSourceLogger);
    }

    public void l(String str, int i2) {
        if (str == null) {
            return;
        }
        IronSourceLogger h2 = h(str);
        if (h2 == null) {
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            d(ironSourceTag, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i2 + ")", 0);
        } else if (i2 >= 0 && i2 <= 3) {
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
            d(ironSourceTag2, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i2 + ")", 0);
            h2.f(i2);
        } else {
            this.c.remove(h2);
        }
    }
}
