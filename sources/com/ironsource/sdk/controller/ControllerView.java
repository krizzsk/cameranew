package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.handlers.BackButtonHandler;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes2.dex */
public class ControllerView extends FrameLayout implements d.e.d.n.g {
    private Context a;
    private WebController b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup i2 = ControllerView.this.i();
            if (i2 != null) {
                i2.addView(ControllerView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup i2 = ControllerView.this.i();
            if (i2 != null) {
                i2.removeView(ControllerView.this);
            }
        }
    }

    public ControllerView(Context context) {
        super(context);
        this.a = context;
        setClickable(true);
    }

    private void d() {
        ((Activity) this.a).runOnUiThread(new a());
    }

    private int e() {
        Activity activity = (Activity) this.a;
        try {
            if (Build.VERSION.SDK_INT > 9) {
                Rect rect = new Rect();
                activity.getWindow().getDecorView().getDrawingRect(rect);
                Rect rect2 = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (com.ironsource.environment.e.s(activity) == 1) {
                    int i2 = rect.bottom;
                    int i3 = rect2.bottom;
                    if (i2 - i3 > 0) {
                        return i2 - i3;
                    }
                    return 0;
                }
                int i4 = rect.right;
                int i5 = rect2.right;
                if (i4 - i5 > 0) {
                    return i4 - i5;
                }
                return 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private int g() {
        int identifier;
        try {
            Context context = this.a;
            if (context == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE)) <= 0) {
                return 0;
            }
            return this.a.getResources().getDimensionPixelSize(identifier);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int h() {
        int g2;
        if (!((((Activity) this.a).getWindow().getAttributes().flags & 1024) != 0) && (g2 = g()) > 0) {
            return g2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup i() {
        Activity activity = (Activity) this.a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    private void j() {
        ((Activity) this.a).runOnUiThread(new b());
    }

    private void k(int i2, int i3) {
        try {
            Context context = this.a;
            if (context != null) {
                int s = com.ironsource.environment.e.s(context);
                if (s == 1) {
                    setPadding(0, i2, 0, i3);
                } else if (s == 2) {
                    setPadding(0, i2, i3, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // d.e.d.n.g
    public boolean b() {
        return BackButtonHandler.getInstance().a((Activity) this.a);
    }

    @Override // d.e.d.n.g
    public void c() {
        j();
    }

    @Override // d.e.d.n.g
    public void f(String str, int i2) {
    }

    public void l(WebController webController) {
        this.b = webController;
        webController.setOnWebViewControllerChangeListener(this);
        this.b.requestFocus();
        this.a = this.b.r1();
        k(h(), e());
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.Y1();
        this.b.m2(true, "main");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.T1();
        this.b.m2(false, "main");
        WebController webController = this.b;
        if (webController != null) {
            webController.setState(WebController.State.Gone);
            this.b.U1();
            this.b.V1();
        }
        removeAllViews();
    }
}
