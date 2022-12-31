package us.pinguo.edit2020.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: WithFadingEdgeRecyclerView.kt */
/* loaded from: classes4.dex */
public final class WithFadingEdgeRecyclerView extends RecyclerView {
    private int a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WithFadingEdgeRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WithFadingEdgeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ WithFadingEdgeRecyclerView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.a == 3) {
            return 0.0f;
        }
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.a == 0) {
            return 0.0f;
        }
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.a == 1) {
            return 0.0f;
        }
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.a == 2) {
            return 0.0f;
        }
        return super.getTopFadingEdgeStrength();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithFadingEdgeRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WithFadingEdgeRecyclerView, i2, 0);
        kotlin.jvm.internal.s.g(obtainStyledAttributes, "context.obtainStyledAttr…ecyclerView, defStyle, 0)");
        this.a = obtainStyledAttributes.getInt(R.styleable.WithFadingEdgeRecyclerView_eliminateFadingDirection, 0);
        obtainStyledAttributes.recycle();
    }
}
