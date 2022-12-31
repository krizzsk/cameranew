package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
/* compiled from: BeautyTabLayout.kt */
/* loaded from: classes3.dex */
public final class BeautyTabLayout extends ConstraintLayout implements View.OnClickListener {
    public Map<Integer, View> a;
    private a b;
    private TextView c;

    /* compiled from: BeautyTabLayout.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void e();

        void g();

        void j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautyTabLayout(Context context) {
        this(context, null);
        kotlin.jvm.internal.s.h(context, "context");
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

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i2 = R.id.tvStyleMakeup;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (kotlin.jvm.internal.s.c(this.c, (TextView) _$_findCachedViewById(i2))) {
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.j();
            }
            this.c = (TextView) _$_findCachedViewById(i2);
            return;
        }
        int i3 = R.id.tvSelfDefMakeup;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (kotlin.jvm.internal.s.c(this.c, (TextView) _$_findCachedViewById(i3))) {
                return;
            }
            a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.g();
            }
            this.c = (TextView) _$_findCachedViewById(i3);
            return;
        }
        int i4 = R.id.tvBeauty;
        if (valueOf == null || valueOf.intValue() != i4 || kotlin.jvm.internal.s.c(this.c, (TextView) _$_findCachedViewById(i4))) {
            return;
        }
        a aVar3 = this.b;
        if (aVar3 != null) {
            aVar3.e();
        }
        this.c = (TextView) _$_findCachedViewById(i4);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((TextView) _$_findCachedViewById(R.id.tvStyleMakeup)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.tvSelfDefMakeup)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.tvBeauty)).setOnClickListener(this);
    }

    public final void setOnBeautyTabClickListener(a onBeautyTabClickListener) {
        kotlin.jvm.internal.s.h(onBeautyTabClickListener, "onBeautyTabClickListener");
        this.b = onBeautyTabClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautyTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
