package us.pinguo.edit2020.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.edit2020.R;
/* compiled from: ScrollableTextListView.kt */
/* loaded from: classes4.dex */
public final class l0 extends RecyclerView.Adapter<a> {
    private final List<f0> a;
    private int b;
    private kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> c;

    /* compiled from: ScrollableTextListView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        private final TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
            View findViewWithTag = view.findViewWithTag("tv");
            kotlin.jvm.internal.s.g(findViewWithTag, "view.findViewWithTag(\"tv\")");
            this.a = (TextView) findViewWithTag;
        }

        public final TextView a() {
            return this.a;
        }
    }

    public l0(List<f0> dataList) {
        kotlin.jvm.internal.s.h(dataList, "dataList");
        this.a = dataList;
    }

    private final FrameLayout f(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTag("tv");
        textView.setGravity(17);
        textView.setTextSize(1, 12.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(textView, layoutParams);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(l0 this$0, a holder, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        int adapterPosition = holder.getAdapterPosition();
        this$0.b = adapterPosition;
        kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> pVar = this$0.c;
        if (pVar != null) {
            pVar.invoke(this$0.a.get(adapterPosition), Integer.valueOf(this$0.b));
        }
        this$0.l();
    }

    public final void e(List<? extends f0> list) {
        kotlin.jvm.internal.s.h(list, "list");
        this.a.clear();
        this.a.addAll(list);
        l();
    }

    public final List<f0> g() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(final a holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 == this.b) {
            TextView a2 = holder.a();
            a2.setTextColor(-1);
            a2.setBackgroundResource(R.drawable.black_12_radius_bg);
        } else {
            TextView a3 = holder.a();
            Context context = holder.itemView.getContext();
            kotlin.jvm.internal.s.g(context, "holder.itemView.context");
            a3.setTextColor(us.pinguo.edit2020.utils.d.c(context, R.color.primary_gray_color));
            a3.setBackgroundResource(0);
        }
        holder.a().setText(this.a.get(i2).a());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l0.j(l0.this, holder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        return new a(f(parent));
    }

    public final void l() {
        notifyItemChanged(this.b);
        notifyItemRangeChanged(0, getItemCount());
    }

    public final void m(kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> pVar) {
        this.c = pVar;
    }

    public final void n(int i2) {
        this.b = i2;
    }
}
