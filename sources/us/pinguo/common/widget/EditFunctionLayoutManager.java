package us.pinguo.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.s;
/* compiled from: EditFunctionLayoutManager.kt */
/* loaded from: classes4.dex */
public class EditFunctionLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFunctionLayoutManager(Context context) {
        super(context);
        s.h(context, "context");
    }

    public final int a(Context context, int i2) {
        s.h(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.function_item_width);
        return (i2 != 5 || us.pinguo.util.h.i(context) >= dimensionPixelSize * 5) ? dimensionPixelSize : context.getResources().getDimensionPixelSize(R.dimen.function_item_min_width);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChild(View child, int i2, int i3) {
        s.h(child, "child");
        if (getItemCount() == 5) {
            Context context = child.getContext();
            s.g(context, "child.context");
            if (us.pinguo.util.h.i(context) < child.getResources().getDimensionPixelSize(R.dimen.function_item_width) * 5) {
                child.getLayoutParams().width = child.getResources().getDimensionPixelSize(R.dimen.function_item_min_width);
            }
        }
        super.measureChild(child, i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View child, int i2, int i3) {
        s.h(child, "child");
        if (getItemCount() == 5) {
            Context context = child.getContext();
            s.g(context, "child.context");
            if (us.pinguo.util.h.i(context) < child.getResources().getDimensionPixelSize(R.dimen.function_item_width) * 5) {
                child.getLayoutParams().width = child.getResources().getDimensionPixelSize(R.dimen.function_item_min_width);
            }
        }
        super.measureChildWithMargins(child, i2, i3);
    }

    public EditFunctionLayoutManager(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public EditFunctionLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
