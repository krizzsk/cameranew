package us.pinguo.common.filter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.manager.FilterRedPointManager;
/* compiled from: FilterTabAdapter.kt */
/* loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter<a> {
    private final ArrayList<CategoryItem> a = new ArrayList<>();
    private int b = Color.parseColor("#999999");
    private int c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f9816d = Color.parseColor("#999999");

    /* renamed from: e  reason: collision with root package name */
    private int f9817e = Color.parseColor("#2d2d2d");

    /* renamed from: f  reason: collision with root package name */
    private int f9818f = 1;

    /* renamed from: g  reason: collision with root package name */
    private p<? super Integer, ? super CategoryItem, u> f9819g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9820h;

    /* compiled from: FilterTabAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.redPoint);
            s.g(textView, "itemView.redPoint");
            this.a = textView;
            TextView textView2 = (TextView) itemView.findViewById(R.id.text);
            s.g(textView2, "itemView.text");
            this.b = textView2;
        }

        public final TextView a() {
            return this.b;
        }

        public final TextView b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(b this$0, int i2, CategoryItem category, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(category, "$category");
        p<? super Integer, ? super CategoryItem, u> pVar = this$0.f9819g;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), category);
    }

    public final ArrayList<CategoryItem> e() {
        return this.a;
    }

    public final int f(CategoryItem categoryItem) {
        s.h(categoryItem, "categoryItem");
        return this.a.indexOf(categoryItem);
    }

    public final int g() {
        return this.f9818f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(a holder, final int i2) {
        s.h(holder, "holder");
        CategoryItem categoryItem = this.a.get(i2);
        s.g(categoryItem, "categoryTabsList[position]");
        final CategoryItem categoryItem2 = categoryItem;
        TextView b = holder.b();
        int i3 = FilterRedPointManager.a.h(categoryItem2.getCategoryId()) ? 0 : 8;
        b.setVisibility(i3);
        VdsAgent.onSetViewVisibility(b, i3);
        holder.a().setText(categoryItem2.getName());
        if (i2 == this.f9818f) {
            if (this.f9820h) {
                holder.a().setTextColor(this.f9817e);
            } else {
                holder.a().setTextColor(this.c);
            }
            holder.a().setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            if (this.f9820h) {
                holder.a().setTextColor(this.f9816d);
            } else {
                holder.a().setTextColor(this.b);
            }
            holder.a().setTypeface(Typeface.DEFAULT);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.j(b.this, i2, categoryItem2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_panel_tab_item_layout, parent, false);
        s.g(itemView, "itemView");
        return new a(itemView);
    }

    public final void l(boolean z) {
        if (z != this.f9820h) {
            this.f9820h = z;
            notifyDataSetChanged();
        }
    }

    public final void m(p<? super Integer, ? super CategoryItem, u> pVar) {
        this.f9819g = pVar;
    }

    public final void n(int i2) {
        this.f9818f = i2;
    }

    public final void o(List<CategoryItem> dataList) {
        s.h(dataList, "dataList");
        this.a.clear();
        this.a.addAll(dataList);
    }
}
