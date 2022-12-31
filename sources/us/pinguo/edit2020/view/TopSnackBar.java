package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Objects;
/* compiled from: TopSnackBar.kt */
/* loaded from: classes4.dex */
public final class TopSnackBar extends FrameLayout {
    private final TextView a;
    private kotlin.jvm.b.a<kotlin.u> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSnackBar(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new TextView(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TopSnackBar this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        TextView textView = this$0.a;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public final void a() {
        if (this.a.getVisibility() == 0) {
            kotlin.jvm.b.a<kotlin.u> aVar = this.b;
            if (aVar != null) {
                aVar.invoke();
            }
            this.a.animate().translationY(-this.a.getLayoutParams().height).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.view.b0
                @Override // java.lang.Runnable
                public final void run() {
                    TopSnackBar.b(TopSnackBar.this);
                }
            }).start();
        }
    }

    public final void d(int i2) {
        this.a.animate().cancel();
        this.a.setText(i2);
        if (this.a.getVisibility() == 0) {
            if (this.a.getTranslationY() == 0.0f) {
                return;
            }
        }
        TextView textView = this.a;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        this.a.animate().translationY(0.0f).setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a.getParent() != null) {
            return;
        }
        addView(this.a);
        TextView textView = this.a;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        this.a.setBackgroundColor(Color.parseColor("#2d2d2d"));
        this.a.setTextSize(1, 15.0f);
        this.a.setTextColor(Color.parseColor("#ffffff"));
        this.a.setGravity(81);
        TextView textView2 = this.a;
        Context context = getContext();
        kotlin.jvm.internal.s.g(context, "context");
        textView2.setPadding(0, 0, 0, us.pinguo.util.g.a(context, 14.5f));
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        float b = us.pinguo.util.g.b(context2, 44.0f) + us.pinguo.foundation.j.e().i("hairCut", 0);
        TextView textView3 = this.a;
        ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) b;
        layoutParams2.width = -1;
        layoutParams2.gravity = 48;
        textView3.setLayoutParams(layoutParams2);
        this.a.setTranslationY(-b);
    }

    public final void setDismissListener(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.b = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSnackBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new TextView(getContext());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSnackBar(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new TextView(getContext());
    }
}
