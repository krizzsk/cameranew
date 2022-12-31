package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzbai;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbz {
    private final View a;
    private Activity b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3483d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3484e;

    /* renamed from: f  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f3485f;

    public zzbz(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.b = activity;
        this.a = view;
        this.f3485f = onGlobalLayoutListener;
    }

    private static ViewTreeObserver a(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void b() {
        ViewTreeObserver a;
        if (this.c) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f3485f;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.b;
            if (activity != null && (a = a(activity)) != null) {
                a.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            com.google.android.gms.ads.internal.zzr.zzlo();
            zzbai.zza(this.a, this.f3485f);
        }
        this.c = true;
    }

    private final void c() {
        ViewTreeObserver a;
        Activity activity = this.b;
        if (activity != null && this.c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f3485f;
            if (onGlobalLayoutListener != null && (a = a(activity)) != null) {
                com.google.android.gms.ads.internal.zzr.zzkt();
                a.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.c = false;
        }
    }

    public final void onAttachedToWindow() {
        this.f3483d = true;
        if (this.f3484e) {
            b();
        }
    }

    public final void onDetachedFromWindow() {
        this.f3483d = false;
        c();
    }

    public final void zzj(Activity activity) {
        this.b = activity;
    }

    public final void zzzs() {
        this.f3484e = true;
        if (this.f3483d) {
            b();
        }
    }

    public final void zzzt() {
        this.f3484e = false;
        c();
    }
}
