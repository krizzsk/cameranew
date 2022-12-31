package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: DailyCappingManager.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private String f5667d;

    /* renamed from: f  reason: collision with root package name */
    private c f5669f;

    /* renamed from: e  reason: collision with root package name */
    private Timer f5668e = null;
    private Map<String, Integer> a = new HashMap();
    private Map<String, Integer> b = new HashMap();
    private Map<String, String> c = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f5670g = com.ironsource.mediationsdk.logger.c.i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DailyCappingManager.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.this.m();
        }
    }

    public d(String str, c cVar) {
        this.f5667d = str;
        this.f5669f = cVar;
        o();
    }

    private int c(String str) {
        if (this.b.containsKey(str)) {
            return this.b.get(str).intValue();
        }
        int y = IronSourceUtils.y(ContextProvider.getInstance().a(), e(str), 0);
        this.b.put(str, Integer.valueOf(y));
        return y;
    }

    private String d(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        String M = IronSourceUtils.M(ContextProvider.getInstance().a(), f(str), g());
        this.c.put(str, M);
        return M;
    }

    private String e(String str) {
        return str + "_counter";
    }

    private String f(String str) {
        return str + "_day";
    }

    private String g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    private int h(String str) {
        if (!g().equalsIgnoreCase(d(str))) {
            q(str);
        }
        return c(str);
    }

    private String i(AbstractSmash abstractSmash) {
        return this.f5667d + "_" + abstractSmash.G() + "_" + abstractSmash.E();
    }

    private Date j() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        synchronized (this) {
            try {
                for (String str : this.a.keySet()) {
                    q(str);
                }
                this.f5669f.h();
                o();
            } catch (Exception e2) {
                this.f5670g.e(IronSourceLogger.IronSourceTag.INTERNAL, "onTimerTick", e2);
            }
        }
    }

    private void n(String str, int i2) {
        this.b.put(str, Integer.valueOf(i2));
        this.c.put(str, g());
        IronSourceUtils.f0(ContextProvider.getInstance().a(), e(str), i2);
        IronSourceUtils.i0(ContextProvider.getInstance().a(), f(str), g());
    }

    private void o() {
        Timer timer = this.f5668e;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.f5668e = timer2;
        timer2.schedule(new a(), j());
    }

    private void q(String str) {
        this.b.put(str, 0);
        this.c.put(str, g());
        IronSourceUtils.f0(ContextProvider.getInstance().a(), e(str), 0);
        IronSourceUtils.i0(ContextProvider.getInstance().a(), f(str), g());
    }

    public void b(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                if (abstractSmash.x() != 99) {
                    this.a.put(i(abstractSmash), Integer.valueOf(abstractSmash.x()));
                }
            } catch (Exception e2) {
                this.f5670g.e(IronSourceLogger.IronSourceTag.INTERNAL, "addSmash", e2);
            }
        }
    }

    public void k(AbstractSmash abstractSmash) {
        String i2;
        synchronized (this) {
            try {
                i2 = i(abstractSmash);
            } catch (Exception e2) {
                this.f5670g.e(IronSourceLogger.IronSourceTag.INTERNAL, "increaseShowCounter", e2);
            }
            if (this.a.containsKey(i2)) {
                n(i2, h(i2) + 1);
            }
        }
    }

    public boolean l(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                try {
                    String i2 = i(abstractSmash);
                    if (this.a.containsKey(i2)) {
                        return this.a.get(i2).intValue() <= h(i2);
                    }
                    return false;
                } catch (Exception e2) {
                    this.f5670g.e(IronSourceLogger.IronSourceTag.INTERNAL, "isCapped", e2);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean p(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                try {
                    String i2 = i(abstractSmash);
                    if (this.a.containsKey(i2)) {
                        if (g().equalsIgnoreCase(d(i2))) {
                            return false;
                        }
                        return this.a.get(i2).intValue() <= c(i2);
                    }
                    return false;
                } catch (Exception e2) {
                    this.f5670g.e(IronSourceLogger.IronSourceTag.INTERNAL, "shouldSendCapReleasedEvent", e2);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
