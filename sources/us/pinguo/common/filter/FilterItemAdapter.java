package us.pinguo.common.filter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.guide.BubbleTextView;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterItemAdapter.kt */
/* loaded from: classes4.dex */
public final class FilterItemAdapter extends RecyclerView.Adapter<a> {
    private final ArrayList<FilterItem> a = new ArrayList<>();
    private final ArrayList<FilterItem> b = new ArrayList<>();
    private int c = -1;

    /* renamed from: d  reason: collision with root package name */
    private p<? super Integer, ? super FilterItem, u> f9797d;

    /* renamed from: e  reason: collision with root package name */
    private p<? super Boolean, ? super FilterItem, u> f9798e;

    /* renamed from: f  reason: collision with root package name */
    private int f9799f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9800g;

    /* compiled from: FilterItemAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        private final BubbleTextView a;
        private final AppCompatImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
            BubbleTextView bubbleTextView = (BubbleTextView) itemView.findViewById(R.id.filterItem);
            s.g(bubbleTextView, "itemView.filterItem");
            this.a = bubbleTextView;
            s.g((AppCompatImageView) itemView.findViewById(R.id.vipIcon), "itemView.vipIcon");
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.collectIcon);
            s.g(appCompatImageView, "itemView.collectIcon");
            this.b = appCompatImageView;
        }

        public final AppCompatImageView a() {
            return this.b;
        }

        public final BubbleTextView b() {
            return this.a;
        }
    }

    public final ArrayList<FilterItem> e() {
        return this.a;
    }

    public final p<Boolean, FilterItem, u> f() {
        return this.f9798e;
    }

    public final p<Integer, FilterItem, u> g() {
        return this.f9797d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.f9799f == 0 ? this.a : this.b).size();
    }

    public final int h(FilterItem filterItem) {
        s.h(filterItem, "filterItem");
        if (this.f9799f == 0) {
            int i2 = 0;
            for (FilterItem filterItem2 : this.a) {
                if (s.c(filterItem.getFilterId(), filterItem2.getFilterId())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return this.b.indexOf(filterItem);
    }

    public final int i() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(a holder, int i2) {
        s.h(holder, "holder");
        FilterItem filterItem = (this.f9799f == 0 ? this.a : this.b).get(i2);
        s.g(filterItem, "if (currentModel == Filt…lse collectList[position]");
        holder.b().setText(String.valueOf(this.a.indexOf(filterItem) + 1));
        holder.b().setCollected(filterItem.isCollect());
        holder.b().setSelectCurrentItem(i2 == this.c);
        AppCompatImageView a2 = holder.a();
        int i3 = this.f9799f == 0 ? filterItem.isCollect() : false ? 0 : 8;
        a2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(a2, i3);
        if (i2 == this.c) {
            if (this.f9800g) {
                holder.b().setBackgroundResource(R.drawable.filter_item_white_selected);
                holder.b().setTextColor(-1);
            } else {
                holder.b().setBackgroundResource(R.drawable.filter_item_white_unselect);
                holder.b().setTextColor(Color.parseColor("#2d2d2d"));
            }
        } else if (this.f9800g) {
            holder.b().setBackgroundResource(R.drawable.filter_item_white_unselect);
            holder.b().setTextColor(Color.parseColor("#2d2d2d"));
        } else {
            holder.b().setBackgroundResource(R.drawable.filter_item_white_unselected_transparent);
            holder.b().setTextColor(-1);
        }
        holder.b().setOnClickCallback(new FilterItemAdapter$onBindViewHolder$1(this, i2, filterItem));
        holder.b().setDoCollectionCallback(new FilterItemAdapter$onBindViewHolder$2(this, filterItem));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_child_item_layout, parent, false);
        s.g(itemView, "itemView");
        return new a(itemView);
    }

    public final void l(boolean z) {
        if (z != this.f9800g) {
            this.f9800g = z;
            notifyDataSetChanged();
        }
    }

    public final void m(int i2) {
        this.f9799f = i2;
        if (i2 == 1) {
            this.b.clear();
            ArrayList<FilterItem> arrayList = this.b;
            ArrayList<FilterItem> arrayList2 = this.a;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((FilterItem) obj).isCollect()) {
                    arrayList3.add(obj);
                }
            }
            arrayList.addAll(arrayList3);
        }
    }

    public final void n(p<? super Boolean, ? super FilterItem, u> pVar) {
        this.f9798e = pVar;
    }

    public final void o(p<? super Integer, ? super FilterItem, u> pVar) {
        this.f9797d = pVar;
    }

    public final void p(int i2) {
        this.c = i2;
    }

    public final void q(List<FilterItem> dataList) {
        s.h(dataList, "dataList");
        this.a.clear();
        this.a.addAll(dataList);
    }
}
