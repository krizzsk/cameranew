package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzqs implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbrd = ((Long) zzwr.zzqr().zzd(zzabp.zzcqr)).longValue();
    private final Context zzaad;
    private final PowerManager zzaae;
    private final KeyguardManager zzaaf;
    private WeakReference<ViewTreeObserver> zzaah;
    private final WindowManager zzbre;
    @Nullable
    private BroadcastReceiver zzbrf;
    private WeakReference<View> zzbrg;
    private zzqz zzbrh;
    private final Rect zzbrl;
    private final DisplayMetrics zzwz;
    private Application zzyd;
    private com.google.android.gms.ads.internal.util.zzbp zzbri = new com.google.android.gms.ads.internal.util.zzbp(zzbrd);
    private boolean zzbrj = false;
    private int zzaal = -1;
    private final HashSet<zzqw> zzbrk = new HashSet<>();

    public zzqs(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.zzaad = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzbre = windowManager;
        this.zzaae = (PowerManager) applicationContext.getSystemService("power");
        this.zzaaf = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.zzyd = (Application) applicationContext;
            this.zzbrh = new zzqz((Application) applicationContext, this);
        }
        this.zzwz = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzbrl = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbrg;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbrg = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzr.zzkt().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0133 A[LOOP:0: B:65:0x012d->B:67:0x0133, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzbr(int r32) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzbr(int):void");
    }

    private final int zzbs(int i2) {
        return (int) (i2 / this.zzwz.density);
    }

    private final void zzct() {
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzqv
            private final zzqs zzbrt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbrt = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzbrt.zzlu();
            }
        });
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaah = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbrf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbrf = new zzqu(this);
            com.google.android.gms.ads.internal.zzr.zzlm().zza(this.zzaad, this.zzbrf, intentFilter);
        }
        Application application = this.zzyd;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbrh);
            } catch (Exception e2) {
                zzazk.zzc("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    private final void zzg(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.zzaah;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaah = null;
            }
        } catch (Exception e2) {
            zzazk.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            zzazk.zzc("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.zzbrf != null) {
            try {
                com.google.android.gms.ads.internal.zzr.zzlm().zza(this.zzaad, this.zzbrf);
            } catch (IllegalStateException e4) {
                zzazk.zzc("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbrf = null;
        }
        Application application = this.zzyd;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbrh);
            } catch (Exception e6) {
                zzazk.zzc("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzbr(3);
        zzct();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbr(2);
        zzct();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbr(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaal = -1;
        zzf(view);
        zzbr(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaal = -1;
        zzbr(3);
        zzct();
        zzg(view);
    }

    public final void zza(zzqw zzqwVar) {
        this.zzbrk.add(zzqwVar);
        zzbr(3);
    }

    public final void zzb(zzqw zzqwVar) {
        this.zzbrk.remove(zzqwVar);
    }

    public final void zzen(long j2) {
        this.zzbri.zzfb(j2);
    }

    public final void zzlt() {
        this.zzbri.zzfb(zzbrd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzlu() {
        zzbr(3);
    }

    private final void zza(Activity activity, int i2) {
        Window window;
        if (this.zzbrg == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzbrg.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzaal = i2;
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbs(rect.left), zzbs(rect.top), zzbs(rect.right), zzbs(rect.bottom));
    }
}
