package us.pinguo.edit2020.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.CircleColorItemView;
/* compiled from: CircleColorAdapter.kt */
/* loaded from: classes4.dex */
public final class z extends RecyclerView.ViewHolder {
    private final CircleColorItemView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        CircleColorItemView circleColorItemView = (CircleColorItemView) itemView.findViewById(R.id.imgCircleColor);
        kotlin.jvm.internal.s.g(circleColorItemView, "itemView.imgCircleColor");
        this.a = circleColorItemView;
    }

    public final CircleColorItemView a() {
        return this.a;
    }
}
