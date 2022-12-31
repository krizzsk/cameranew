package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: WaterfallLifeCycleHolder.java */
/* loaded from: classes2.dex */
public class i0 {

    /* renamed from: d  reason: collision with root package name */
    private LWSProgRvSmash f5565d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f5566e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5567f;
    ConcurrentHashMap<String, CopyOnWriteArrayList<LWSProgRvSmash>> a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";

    /* renamed from: g  reason: collision with root package name */
    private final Timer f5568g = new Timer();

    /* compiled from: WaterfallLifeCycleHolder.java */
    /* loaded from: classes2.dex */
    class a extends TimerTask {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.info("removing waterfall with id " + this.a + " from memory");
                i0.this.a.remove(this.a);
                ironLog.info("waterfall size is currently " + i0.this.a.size());
            } finally {
                cancel();
            }
        }
    }

    public i0(List<String> list, int i2) {
        this.f5566e = list;
        this.f5567f = i2;
    }

    public boolean a() {
        return this.a.size() > 5;
    }

    public CopyOnWriteArrayList<LWSProgRvSmash> b() {
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.a.size();
    }

    public LWSProgRvSmash e() {
        return this.f5565d;
    }

    public synchronized boolean f() {
        boolean z;
        LWSProgRvSmash lWSProgRvSmash = this.f5565d;
        if (lWSProgRvSmash != null) {
            z = lWSProgRvSmash.T().equals(this.c);
        }
        return z;
    }

    public synchronized void g(LWSProgRvSmash lWSProgRvSmash) {
        IronLog.INTERNAL.verbose("");
        this.f5565d = lWSProgRvSmash;
    }

    public synchronized boolean h(LWSProgRvSmash lWSProgRvSmash) {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        z = false;
        if (lWSProgRvSmash != null) {
            if (this.f5565d != null) {
                if (lWSProgRvSmash.W() == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK) {
                    if (this.f5565d.x().equals(lWSProgRvSmash.x())) {
                    }
                }
                if ((lWSProgRvSmash.W() == LoadWhileShowSupportState.NONE || this.f5566e.contains(lWSProgRvSmash.H())) && this.f5565d.H().equals(lWSProgRvSmash.H())) {
                }
            }
            if (z && lWSProgRvSmash != null) {
                ironLog.info(lWSProgRvSmash.x() + " does not support load while show and will not be added to the auction request");
            }
        }
        z = true;
        if (z) {
            ironLog.info(lWSProgRvSmash.x() + " does not support load while show and will not be added to the auction request");
        }
        return !z;
    }

    public void i(CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.info("updating new  waterfall with id " + str);
        this.a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.c)) {
            if (f()) {
                ironLog.info("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.c;
                this.c = str2;
            }
            this.f5568g.schedule(new a(this.c), this.f5567f);
        }
        this.c = this.b;
        this.b = str;
    }
}
