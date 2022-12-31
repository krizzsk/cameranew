package us.pinguo.edit2020.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: CollectAnimImageView.kt */
/* loaded from: classes4.dex */
public final class CollectAnimImageView extends AppCompatImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectAnimImageView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CollectAnimImageView this$0) {
        s.h(this$0, "this$0");
        this$0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CollectAnimImageView this$0) {
        s.h(this$0, "this$0");
        this$0.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(250L).start();
    }

    public final void a() {
        animate().alpha(0.0f).setDuration(500L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                CollectAnimImageView.b(CollectAnimImageView.this);
            }
        }).start();
    }

    public final void e() {
        setVisibility(0);
        setAlpha(1.0f);
        animate().scaleX(1.8f).scaleY(1.8f).setInterpolator(new AccelerateInterpolator()).setDuration(250L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                CollectAnimImageView.f(CollectAnimImageView.this);
            }
        }).start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectAnimImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectAnimImageView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
