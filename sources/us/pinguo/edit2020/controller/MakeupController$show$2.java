package us.pinguo.edit2020.controller;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.manager.BeautyDataManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController$show$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ String $styleMakeupId;
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeupController$show$2(MakeupController makeupController, String str) {
        super(0);
        this.this$0 = makeupController;
        this.$styleMakeupId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m91invoke$lambda2(final MakeupController this$0, String str) {
        View view;
        View view2;
        View view3;
        List<StyleMakeup> suites;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        int i2 = 0;
        if (value != null && (suites = value.getSuites()) != null) {
            Iterator<StyleMakeup> it = suites.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (kotlin.jvm.internal.s.c(it.next().getPid(), str)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        final int i3 = i2 + 1;
        if (i3 >= 0) {
            view = this$0.f10396j;
            float i4 = (us.pinguo.foundation.utils.n0.i() / 2) - (view.getContext().getResources().getDimension(R.dimen.paint_material_rv_item_size) / 2);
            view2 = this$0.f10396j;
            int i5 = R.id.rvStyleMakeup;
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view2.findViewById(i5)).getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, (int) i4);
            view3 = this$0.f10396j;
            RecyclerView recyclerView = (RecyclerView) view3.findViewById(i5);
            kotlin.jvm.internal.s.g(recyclerView, "makeupView.rvStyleMakeup");
            us.pinguo.foundation.ui.c.b(recyclerView, new Runnable() { // from class: us.pinguo.edit2020.controller.f2
                @Override // java.lang.Runnable
                public final void run() {
                    MakeupController$show$2.m92invoke$lambda2$lambda1(MakeupController.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m92invoke$lambda2$lambda1(MakeupController this$0, int i2) {
        View view;
        View view2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        view = this$0.f10396j;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) view.findViewById(R.id.rvStyleMakeup)).findViewHolderForAdapterPosition(i2);
        if (findViewHolderForAdapterPosition == null || (view2 = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view2.performClick();
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View view;
        view = this.this$0.f10396j;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvStyleMakeup);
        kotlin.jvm.internal.s.g(recyclerView, "makeupView.rvStyleMakeup");
        final MakeupController makeupController = this.this$0;
        final String str = this.$styleMakeupId;
        us.pinguo.foundation.ui.c.b(recyclerView, new Runnable() { // from class: us.pinguo.edit2020.controller.g2
            @Override // java.lang.Runnable
            public final void run() {
                MakeupController$show$2.m91invoke$lambda2(MakeupController.this, str);
            }
        });
    }
}
