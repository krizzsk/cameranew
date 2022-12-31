package us.pinguo.edit2020.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.CheckMarkCircleView;
/* compiled from: GraffitiColorAdapter.kt */
/* loaded from: classes4.dex */
public final class f0 extends RecyclerView.ViewHolder {
    private final CheckMarkCircleView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        CheckMarkCircleView checkMarkCircleView = (CheckMarkCircleView) itemView.findViewById(R.id.imgCircleColor);
        kotlin.jvm.internal.s.g(checkMarkCircleView, "itemView.imgCircleColor");
        this.a = checkMarkCircleView;
    }

    public final CheckMarkCircleView a() {
        return this.a;
    }
}
