package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.i;
import kotlin.u;
/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view, final l<? super View, u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            action.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    s.h(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    action.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    s.h(view2, "view");
                }
            });
        }
    }

    public static final void doOnDetach(final View view, final l<? super View, u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        if (!ViewCompat.isAttachedToWindow(view)) {
            action.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    s.h(view2, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    s.h(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    action.invoke(view2);
                }
            });
        }
    }

    public static final void doOnLayout(View view, final l<? super View, u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
            action.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    s.h(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    l.this.invoke(view2);
                }
            });
        }
    }

    public static final void doOnNextLayout(View view, final l<? super View, u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                s.h(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                action.invoke(view2);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final l<? super View, u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(view);
            }
        });
        s.g(add, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return add;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        s.h(view, "<this>");
        s.h(config, "config");
        if (ViewCompat.isLaidOut(view)) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            s.g(createBitmap, "createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-view.getScrollX(), -view.getScrollY());
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final kotlin.sequences.e<View> getAllViews(View view) {
        kotlin.sequences.e<View> b;
        s.h(view, "<this>");
        b = i.b(new ViewKt$allViews$1(view, null));
        return b;
    }

    public static final kotlin.sequences.e<ViewParent> getAncestors(View view) {
        kotlin.sequences.e<ViewParent> e2;
        s.h(view, "<this>");
        e2 = SequencesKt__SequencesKt.e(view.getParent(), ViewKt$ancestors$1.INSTANCE);
        return e2;
    }

    public static final int getMarginBottom(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.bottomMargin;
    }

    public static final int getMarginEnd(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.leftMargin;
    }

    public static final int getMarginRight(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.rightMargin;
    }

    public static final int getMarginStart(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        s.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.topMargin;
    }

    public static final boolean isGone(View view) {
        s.h(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        s.h(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        s.h(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j2, final kotlin.jvm.b.a<u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke();
            }
        };
        view.postDelayed(runnable, j2);
        return runnable;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j2, final kotlin.jvm.b.a<u> action) {
        s.h(view, "<this>");
        s.h(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke();
            }
        };
        view.postOnAnimationDelayed(runnable, j2);
        return runnable;
    }

    public static final void setGone(View view, boolean z) {
        s.h(view, "<this>");
        int i2 = z ? 8 : 0;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    public static final void setInvisible(View view, boolean z) {
        s.h(view, "<this>");
        int i2 = z ? 4 : 0;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    public static final void setPadding(View view, @Px int i2) {
        s.h(view, "<this>");
        view.setPadding(i2, i2, i2, i2);
    }

    public static final void setVisible(View view, boolean z) {
        s.h(view, "<this>");
        int i2 = z ? 0 : 8;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    public static final void updateLayoutParams(View view, l<? super ViewGroup.LayoutParams, u> block) {
        s.h(view, "<this>");
        s.h(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, l<? super T, u> block) {
        s.h(view, "<this>");
        s.h(block, "block");
        view.getLayoutParams();
        s.n(1, "T");
        throw null;
    }

    public static final void updatePadding(View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        s.h(view, "<this>");
        view.setPadding(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingRight();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        s.h(view, "<this>");
        view.setPadding(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        s.h(view, "<this>");
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingStart();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        s.h(view, "<this>");
        view.setPaddingRelative(i2, i3, i4, i5);
    }
}
