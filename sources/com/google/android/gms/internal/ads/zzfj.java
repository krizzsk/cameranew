package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfj implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzaac = new Handler(Looper.getMainLooper());
    private final Context zzaad;
    @Nullable
    private final PowerManager zzaae;
    @Nullable
    private final KeyguardManager zzaaf;
    private BroadcastReceiver zzaag;
    private WeakReference<ViewTreeObserver> zzaah;
    @Nullable
    private WeakReference<View> zzaai;
    private zzel zzaaj;
    private byte zzaak = -1;
    private int zzaal = -1;
    private long zzaam = -3;
    private Application zzyd;
    private final zzfa zzyp;

    public zzfj(Context context, zzfa zzfaVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzaad = applicationContext;
        this.zzyp = zzfaVar;
        this.zzaae = (PowerManager) applicationContext.getSystemService("power");
        this.zzaaf = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.zzyd = (Application) applicationContext;
            this.zzaaj = new zzel((Application) applicationContext, this);
        }
        zze(null);
    }

    @Nullable
    private final View getCurrentView() {
        WeakReference<View> weakReference = this.zzaai;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final void zza(Activity activity, int i2) {
        Window window;
        if (this.zzaai == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View currentView = getCurrentView();
        if (currentView == null || peekDecorView == null || currentView.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzaal = i2;
    }

    private final void zzct() {
        zzaac.post(new zzfm(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
        if (r7 == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzcv() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzaai
            if (r0 != 0) goto L5
            return
        L5:
            android.view.View r0 = r9.getCurrentView()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L13
            r9.zzaam = r2
            r9.zzaak = r1
            return
        L13:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L1d
            r4 = 1
            goto L1e
        L1d:
            r4 = 0
        L1e:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L27
            r4 = r4 | 2
            byte r4 = (byte) r4
        L27:
            android.os.PowerManager r7 = r9.zzaae
            if (r7 == 0) goto L34
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L34
            r4 = r4 | 4
            byte r4 = (byte) r4
        L34:
            com.google.android.gms.internal.ads.zzfa r7 = r9.zzyp
            boolean r7 = r7.zzcf()
            if (r7 != 0) goto L68
            android.app.KeyguardManager r7 = r9.zzaaf
            if (r7 == 0) goto L67
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L67
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzfh.zzd(r0)
            if (r7 == 0) goto L63
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L54
            r7 = 0
            goto L58
        L54:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L58:
            if (r7 == 0) goto L63
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L63
            r7 = 1
            goto L64
        L63:
            r7 = 0
        L64:
            if (r7 == 0) goto L67
            goto L68
        L67:
            r5 = 0
        L68:
            if (r5 != 0) goto L6d
            r4 = r4 | 8
            byte r4 = (byte) r4
        L6d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L7b
            r4 = r4 | 16
            byte r4 = (byte) r4
        L7b:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L89
            r4 = r4 | 32
            byte r4 = (byte) r4
        L89:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.zzaal
            if (r5 == r1) goto L92
            r0 = r5
        L92:
            if (r0 == 0) goto L97
            r0 = r4 | 64
            byte r4 = (byte) r0
        L97:
            byte r0 = r9.zzaak
            if (r0 == r4) goto La9
            r9.zzaak = r4
            if (r4 != 0) goto La4
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto La7
        La4:
            long r0 = (long) r4
            long r0 = r2 - r0
        La7:
            r9.zzaam = r0
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.zzcv():void");
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaah = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzaag == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzfl zzflVar = new zzfl(this);
            this.zzaag = zzflVar;
            this.zzaad.registerReceiver(zzflVar, intentFilter);
        }
        Application application = this.zzyd;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzaaj);
            } catch (Exception unused) {
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
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzaag;
        if (broadcastReceiver != null) {
            try {
                this.zzaad.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzaag = null;
        }
        Application application = this.zzyd;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzaaj);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzcv();
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzcv();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzcv();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzcv();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaal = -1;
        zzf(view);
        zzcv();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaal = -1;
        zzcv();
        zzct();
        zzg(view);
    }

    public final long zzcu() {
        if (this.zzaam <= -2 && getCurrentView() == null) {
            this.zzaam = -3L;
        }
        return this.zzaam;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(View view) {
        View currentView = getCurrentView();
        if (currentView != null) {
            currentView.removeOnAttachStateChangeListener(this);
            zzg(currentView);
        }
        this.zzaai = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.zzaam = -2L;
            return;
        }
        this.zzaam = -3L;
    }
}
