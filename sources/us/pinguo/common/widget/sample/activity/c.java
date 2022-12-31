package us.pinguo.common.widget.sample.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.R;
/* compiled from: TestRecyclerAdapter.kt */
/* loaded from: classes4.dex */
public final class c extends RecyclerView.ViewHolder {
    private final ImageView a;
    private final TextView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View itemView) {
        super(itemView);
        s.h(itemView, "itemView");
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgMain);
        Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.widget.ImageView");
        this.a = imageView;
        TextView textView = (TextView) itemView.findViewById(R.id.txtName);
        Objects.requireNonNull(textView, "null cannot be cast to non-null type android.widget.TextView");
        this.b = textView;
    }

    public final ImageView a() {
        return this.a;
    }

    public final TextView b() {
        return this.b;
    }
}
