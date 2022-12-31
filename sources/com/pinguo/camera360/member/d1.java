package com.pinguo.camera360.member;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.member.d1;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import vStudio.Android.Camera360.R;
/* compiled from: RechargeListAdapter.kt */
/* loaded from: classes3.dex */
public final class d1 extends RecyclerView.Adapter<a> {
    private final List<RechargeGoodsDiscountInfo> a;
    private int b;
    private RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    private RechargeGoodsDiscountInfo f6922d;

    /* renamed from: e  reason: collision with root package name */
    private RechargeGoodsDiscountInfo f6923e;

    /* compiled from: RechargeListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
        }
    }

    public d1(List<RechargeGoodsDiscountInfo> goodsInfo) {
        Object next;
        kotlin.jvm.internal.s.h(goodsInfo, "goodsInfo");
        this.a = goodsInfo;
        Iterator<T> it = goodsInfo.iterator();
        Object obj = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = ((RechargeGoodsDiscountInfo) next).getTitle().length();
                do {
                    Object next2 = it.next();
                    int length2 = ((RechargeGoodsDiscountInfo) next2).getTitle().length();
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        this.f6922d = (RechargeGoodsDiscountInfo) next;
        Iterator<T> it2 = this.a.iterator();
        if (it2.hasNext()) {
            obj = it2.next();
            if (it2.hasNext()) {
                int length3 = ((RechargeGoodsDiscountInfo) obj).getPrice().length();
                do {
                    Object next3 = it2.next();
                    int length4 = ((RechargeGoodsDiscountInfo) next3).getPrice().length();
                    if (length3 < length4) {
                        obj = next3;
                        length3 = length4;
                    }
                } while (it2.hasNext());
            }
        }
        this.f6923e = (RechargeGoodsDiscountInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a holder, d1 this$0, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (holder.itemView.isSelected()) {
            return;
        }
        int i3 = this$0.b;
        if (i3 != -1) {
            RecyclerView recyclerView = this$0.c;
            RecyclerView.ViewHolder viewHolder = null;
            View childAt = recyclerView == null ? null : recyclerView.getChildAt(i3);
            RecyclerView recyclerView2 = this$0.c;
            if (recyclerView2 != null) {
                kotlin.jvm.internal.s.e(childAt);
                viewHolder = recyclerView2.getChildViewHolder(childAt);
            }
            Objects.requireNonNull(viewHolder, "null cannot be cast to non-null type com.pinguo.camera360.member.RechargeListAdapter.ViewHolder");
            a aVar = (a) viewHolder;
            aVar.itemView.setSelected(false);
            ((ImageView) aVar.itemView.findViewById(R.id.select_img)).setVisibility(8);
            this$0.b = i2;
        }
        holder.itemView.setSelected(true);
        ((ImageView) holder.itemView.findViewById(R.id.select_img)).setVisibility(0);
    }

    public final RechargeGoodsDiscountInfo e() {
        if (!this.a.isEmpty()) {
            return this.a.get(this.b);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        holder.itemView.setSelected(this.b == i2);
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = this.a.get(i2);
        MemberPriceItemTextView memberPriceItemTextView = (MemberPriceItemTextView) holder.itemView.findViewById(R.id.price_item);
        Objects.requireNonNull(memberPriceItemTextView, "null cannot be cast to non-null type com.pinguo.camera360.member.MemberPriceItemTextView");
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo2 = this.f6922d;
        String title = rechargeGoodsDiscountInfo2 == null ? null : rechargeGoodsDiscountInfo2.getTitle();
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo3 = this.f6923e;
        memberPriceItemTextView.b(title, rechargeGoodsDiscountInfo3 != null ? rechargeGoodsDiscountInfo3.getPrice() : null);
        memberPriceItemTextView.c(rechargeGoodsDiscountInfo.getTitle(), rechargeGoodsDiscountInfo.getPrice(), rechargeGoodsDiscountInfo.getOriginalPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d1.h(d1.a.this, this, i2, view);
            }
        });
        if (holder.itemView.isSelected()) {
            ((ImageView) holder.itemView.findViewById(R.id.select_img)).setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recharge, parent, false);
        kotlin.jvm.internal.s.g(view, "view");
        return new a(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.c = recyclerView;
    }
}
