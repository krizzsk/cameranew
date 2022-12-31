package us.pinguo.edit2020.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
/* compiled from: NumberTipView.kt */
/* loaded from: classes4.dex */
public final class NumberTipView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final Handler b;
    private final Runnable c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberTipView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new Handler();
        this.c = new Runnable() { // from class: us.pinguo.edit2020.view.t
            @Override // java.lang.Runnable
            public final void run() {
                NumberTipView.j(NumberTipView.this);
            }
        };
        View.inflate(getContext(), R.layout.layout_number_tip_view, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final NumberTipView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.view.u
            @Override // java.lang.Runnable
            public final void run() {
                NumberTipView.k(NumberTipView.this);
            }
        }).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(NumberTipView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void a() {
        this.b.postDelayed(this.c, 1000L);
    }

    public final void i(String name, int i2) {
        kotlin.jvm.internal.s.h(name, "name");
        this.b.removeCallbacks(this.c);
        animate().cancel();
        setAlpha(1.0f);
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ((TextView) _$_findCachedViewById(R.id.txtAutoBeautifyName)).setText(name);
        ((TextView) _$_findCachedViewById(R.id.txtAutoBeautifyValue)).setText(String.valueOf(i2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberTipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.b = new Handler();
        this.c = new Runnable() { // from class: us.pinguo.edit2020.view.t
            @Override // java.lang.Runnable
            public final void run() {
                NumberTipView.j(NumberTipView.this);
            }
        };
        View.inflate(getContext(), R.layout.layout_number_tip_view, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberTipView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.b = new Handler();
        this.c = new Runnable() { // from class: us.pinguo.edit2020.view.t
            @Override // java.lang.Runnable
            public final void run() {
                NumberTipView.j(NumberTipView.this);
            }
        };
        View.inflate(getContext(), R.layout.layout_number_tip_view, this);
    }
}
