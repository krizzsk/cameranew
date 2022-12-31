package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
/* compiled from: ProgressWheelViewLayout.kt */
/* loaded from: classes4.dex */
public final class ProgressWheelViewLayout extends FrameLayout implements View.OnClickListener, j0 {
    public Map<Integer, View> a;
    private DecimalFormat b;
    private j0 c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10717d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressWheelViewLayout(Context context) {
        this(context, null, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public static /* synthetic */ void setValue$default(ProgressWheelViewLayout progressWheelViewLayout, float f2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        progressWheelViewLayout.setValue(f2, z, z2);
    }

    @Override // us.pinguo.edit2020.view.j0
    public void a(float f2, float f3, boolean z) {
        j0 j0Var;
        String format = this.b.format(Float.valueOf(f3));
        if (kotlin.jvm.internal.s.c(format, "-0°")) {
            format = format.subSequence(1, format.length()).toString();
        }
        ((TextView) b(R.id.text_view)).setText(format);
        if (this.f10717d && (j0Var = this.c) != null) {
            j0Var.a(f2, f3, z);
        }
        if (z) {
            this.f10717d = true;
        }
    }

    public View b(int i2) {
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

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View v) {
        VdsAgent.onClick(this, v);
        kotlin.jvm.internal.s.h(v, "v");
        if (kotlin.jvm.internal.s.c(v, (ImageView) b(R.id.iv_reset))) {
            ((ProgressWheelView) b(R.id.wheel_view)).g();
        }
    }

    public final void setDefaultValue(float f2) {
        ProgressWheelView wheel_view = (ProgressWheelView) b(R.id.wheel_view);
        kotlin.jvm.internal.s.g(wheel_view, "wheel_view");
        ProgressWheelView.setValue$edit2020_release$default(wheel_view, f2, false, false, 4, null);
    }

    public final void setOnWheelChangedListener(j0 j0Var) {
        this.c = j0Var;
    }

    public final void setValue(float f2, boolean z, boolean z2) {
        this.f10717d = z;
        ProgressWheelView wheel_view = (ProgressWheelView) b(R.id.wheel_view);
        kotlin.jvm.internal.s.g(wheel_view, "wheel_view");
        ProgressWheelView.setValue$edit2020_release$default(wheel_view, f2, z2, false, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressWheelViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressWheelViewLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new DecimalFormat("#.#°");
        this.f10717d = true;
        View.inflate(context, R.layout.view_progress_layout, this);
        ((ImageView) b(R.id.iv_reset)).setOnClickListener(this);
        ((ProgressWheelView) b(R.id.wheel_view)).setOnWheelChangedListener$edit2020_release(this);
    }
}
