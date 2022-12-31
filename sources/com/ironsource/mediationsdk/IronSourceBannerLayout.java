package com.ironsource.mediationsdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
/* loaded from: classes2.dex */
public class IronSourceBannerLayout extends FrameLayout {
    private View a;
    private r b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f5409d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5410e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5411f;

    /* renamed from: g  reason: collision with root package name */
    private com.ironsource.mediationsdk.n0.a f5412g;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        a(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IronSourceBannerLayout.this.f5411f) {
                IronSourceBannerLayout.this.f5412g.b(this.a);
                return;
            }
            try {
                if (IronSourceBannerLayout.this.a != null) {
                    IronSourceBannerLayout ironSourceBannerLayout = IronSourceBannerLayout.this;
                    ironSourceBannerLayout.removeView(ironSourceBannerLayout.a);
                    IronSourceBannerLayout.this.a = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (IronSourceBannerLayout.this.f5412g != null) {
                IronSourceBannerLayout.this.f5412g.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout.LayoutParams b;

        b(View view, FrameLayout.LayoutParams layoutParams) {
            this.a = view;
            this.b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronSourceBannerLayout.this.removeAllViews();
            ViewParent parent = this.a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.a);
            }
            IronSourceBannerLayout.this.a = this.a;
            IronSourceBannerLayout.this.addView(this.a, 0, this.b);
        }
    }

    public IronSourceBannerLayout(Activity activity, r rVar) {
        super(activity);
        this.f5410e = false;
        this.f5411f = false;
        this.f5409d = activity;
        this.b = rVar == null ? r.f5645d : rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, FrameLayout.LayoutParams layoutParams) {
        new Handler(Looper.getMainLooper()).post(new b(view, layoutParams));
    }

    public Activity f() {
        return this.f5409d;
    }

    public r g() {
        return this.b;
    }

    public boolean h() {
        return this.f5410e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IronSourceBannerLayout i() {
        IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(this.f5409d, this.b);
        ironSourceBannerLayout.setBannerListener(this.f5412g);
        ironSourceBannerLayout.setPlacementName(this.c);
        return ironSourceBannerLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (this.f5412g != null) {
            IronLog.CALLBACK.info("");
            this.f5412g.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        IronLog ironLog = IronLog.CALLBACK;
        ironLog.info("error=" + bVar);
        new Handler(Looper.getMainLooper()).post(new a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + str);
        if (this.f5412g != null && !this.f5411f) {
            IronLog.CALLBACK.info("");
            this.f5412g.o();
        }
        this.f5411f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (this.f5412g != null) {
            IronLog.CALLBACK.info("");
            this.f5412g.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (this.f5412g != null) {
            IronLog.CALLBACK.info("");
            this.f5412g.n();
        }
    }

    public void setBannerListener(com.ironsource.mediationsdk.n0.a aVar) {
        IronLog.API.info("");
        this.f5412g = aVar;
    }

    public void setPlacementName(String str) {
        this.c = str;
    }
}
