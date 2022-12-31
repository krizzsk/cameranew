package com.tapjoy;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
/* loaded from: classes3.dex */
public class TJCloseButton extends ImageButton {
    private static final String a = TJCloseButton.class.getSimpleName();
    private ClosePosition b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7215d;

    /* loaded from: classes3.dex */
    public enum ClosePosition {
        TOP_LEFT(new int[]{10, 9}),
        TOP_CENTER(new int[]{10, 14}),
        TOP_RIGHT(new int[]{10, 11}),
        CENTER(new int[]{13}),
        BOTTOM_LEFT(new int[]{12, 9}),
        BOTTOM_CENTER(new int[]{12, 14}),
        BOTTOM_RIGHT(new int[]{12, 11});
        
        final RelativeLayout.LayoutParams a = new RelativeLayout.LayoutParams(-2, -2);

        ClosePosition(int[] iArr) {
            for (int i2 : iArr) {
                this.a.addRule(i2);
            }
            int deviceScreenDensityScale = (int) (TapjoyConnectCore.getDeviceScreenDensityScale() * (-10.0f));
            this.a.setMargins(0, deviceScreenDensityScale, deviceScreenDensityScale, 0);
        }
    }

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    protected void onAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 12) {
            setAlpha(0.0f);
            setVisibility(0);
            this.f7215d = true;
            setClickable(false);
            new Handler().postDelayed(new Runnable() { // from class: com.tapjoy.TJCloseButton.1
                @Override // java.lang.Runnable
                @SuppressLint({"NewApi"})
                public final void run() {
                    TJCloseButton.this.animate().alpha(1.0f).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.tapjoy.TJCloseButton.1.1
                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator) {
                            TJCloseButton tJCloseButton = TJCloseButton.this;
                            tJCloseButton.setClickable(tJCloseButton.c);
                            TJCloseButton.this.f7215d = false;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            TJCloseButton tJCloseButton = TJCloseButton.this;
                            tJCloseButton.setClickable(tJCloseButton.c);
                            TJCloseButton.this.f7215d = false;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                        }
                    });
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClickableRequested(boolean z) {
        this.c = z;
        if (this.f7215d) {
            return;
        }
        setClickable(z);
    }

    public TJCloseButton(Context context, ClosePosition closePosition) {
        super(context);
        this.c = true;
        this.b = closePosition;
        Bitmap loadBitmapFromJar = TapjoyUtil.loadBitmapFromJar("tj_close_button.png", context);
        if (loadBitmapFromJar == null) {
            try {
                loadBitmapFromJar = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("tj_close_button", "drawable", context.getPackageName()));
            } catch (Exception unused) {
                TapjoyLog.w(a, "Could not find close button asset");
            }
        }
        setImageBitmap(loadBitmapFromJar);
        setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        setLayoutParams(this.b.a);
    }
}
