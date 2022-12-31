package us.pinguo.camera2020.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.camera2020.R;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: InfiniteRecyclerViewAdapter.kt */
/* loaded from: classes3.dex */
public final class p extends RecyclerView.ViewHolder {
    private final TextView a;
    private final SimpleDraweeView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        AutofitTextView autofitTextView = (AutofitTextView) itemView.findViewById(R.id.txtDescription);
        kotlin.jvm.internal.s.g(autofitTextView, "itemView.txtDescription");
        this.a = autofitTextView;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.imgContent);
        kotlin.jvm.internal.s.g(simpleDraweeView, "itemView.imgContent");
        this.b = simpleDraweeView;
    }

    public final SimpleDraweeView a() {
        return this.b;
    }

    public final TextView b() {
        return this.a;
    }
}
