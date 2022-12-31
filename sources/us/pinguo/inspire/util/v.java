package us.pinguo.inspire.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: SoftKeyboardDetector.java */
/* loaded from: classes9.dex */
public class v implements ViewTreeObserver.OnGlobalLayoutListener {
    private Activity a;
    private View b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11299d;

    /* renamed from: e  reason: collision with root package name */
    private int f11300e;

    /* renamed from: f  reason: collision with root package name */
    private int f11301f;

    /* renamed from: g  reason: collision with root package name */
    private int f11302g;

    /* renamed from: h  reason: collision with root package name */
    private b f11303h;

    /* renamed from: i  reason: collision with root package name */
    private int f11304i;

    /* renamed from: j  reason: collision with root package name */
    private int f11305j;

    /* compiled from: SoftKeyboardDetector.java */
    /* loaded from: classes9.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = this.a.getRootView().getHeight() - this.a.getHeight();
            if (height <= v.this.f11300e || v.this.f11299d) {
                if (v.this.f11299d && height < v.this.f11300e) {
                    v.this.f11299d = false;
                }
            } else {
                v.this.f11299d = true;
                v.this.h();
            }
            if (v.this.f11303h != null) {
                v.this.f11303h.onKeyboardChange(v.this.f11299d);
            }
        }
    }

    /* compiled from: SoftKeyboardDetector.java */
    /* loaded from: classes9.dex */
    public interface b {
        void onKeyboardChange(boolean z);
    }

    public v(Activity activity, View view) {
        this(activity, view, 16908290);
    }

    private static int g(Context context) {
        return us.pinguo.foundation.t.b.a.a(context, context.getSharedPreferences("Keyboard", 0).getInt("soft_input_height_dp", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f11302g != 0) {
            return;
        }
        int[] iArr = new int[2];
        this.b.getLocationInWindow(iArr);
        int height = (this.f11301f - iArr[1]) - this.b.getHeight();
        this.f11302g = height;
        if (height != this.f11304i) {
            this.f11304i = height;
            this.b.getContext().getSharedPreferences("Keyboard", 0).edit().putInt("soft_input_height_dp", us.pinguo.foundation.t.b.a.n(this.a, this.f11304i)).apply();
        }
    }

    public int f() {
        return this.f11304i;
    }

    public void i(b bVar) {
        this.f11303h = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View findViewById;
        View view = this.c;
        if (view != null) {
            findViewById = view.findViewById(this.f11305j);
        } else {
            findViewById = this.a.findViewById(this.f11305j);
        }
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new a(findViewById));
    }

    public v(Activity activity, View view, int i2) {
        this.a = activity;
        this.b = view;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f11300e = (int) ((displayMetrics.density * 200.0f) + 0.5f);
        this.f11301f = displayMetrics.heightPixels;
        this.f11304i = g(this.b.getContext());
        this.f11305j = i2;
    }
}
