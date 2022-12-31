package us.pinguo.edit2020.controller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.widget.common.guide.GuideHandler;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$initBackgroundBlur$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$initBackgroundBlur$1(BackgroundBlurController backgroundBlurController) {
        super(1);
        this.this$0 = backgroundBlurController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m77invoke$lambda2(boolean z, final BackgroundBlurController this$0) {
        GuideHandler guideHandler;
        ViewGroup viewGroup;
        int i2;
        us.pinguo.edit2020.model.editgoto.b bVar;
        View view;
        View view2;
        GuideHandler guideHandler2;
        ViewGroup viewGroup2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (z) {
            guideHandler2 = this$0.p;
            viewGroup2 = this$0.b;
            guideHandler2.x((ImageView) ((PaintEraserAdjustLayout) viewGroup2.findViewById(R.id.adjustLayout)).a(R.id.ivAdjustFace));
        } else {
            guideHandler = this$0.o;
            viewGroup = this$0.b;
            guideHandler.x((ImageView) ((PaintEraserAdjustLayout) viewGroup.findViewById(R.id.adjustLayout)).a(R.id.ivAdjustFace));
        }
        List<BackgroundBlur> C = this$0.c.C();
        if (C != null) {
            i2 = 0;
            for (BackgroundBlur backgroundBlur : C) {
                bVar = this$0.s;
                if (kotlin.jvm.internal.s.c(bVar == null ? null : bVar.d(), backgroundBlur.getPid())) {
                    break;
                }
                i2++;
            }
        }
        i2 = -1;
        final int i3 = i2 != -1 ? i2 : 0;
        view = this$0.f10278h;
        final RecyclerView rvBackgroundBlur = (RecyclerView) view.findViewById(R.id.rvBackgroundBlur);
        view2 = this$0.f10278h;
        int i4 = (us.pinguo.foundation.utils.n0.i() / 2) - (view2.getContext().getResources().getDimensionPixelSize(R.dimen.background_blur_lens_rv_item_width) / 2);
        RecyclerView.LayoutManager layoutManager = rvBackgroundBlur.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i4);
        kotlin.jvm.internal.s.g(rvBackgroundBlur, "rvBackgroundBlur");
        us.pinguo.foundation.ui.c.b(rvBackgroundBlur, new Runnable() { // from class: us.pinguo.edit2020.controller.l
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundBlurController$initBackgroundBlur$1.m78invoke$lambda2$lambda1(RecyclerView.this, i3, this$0);
            }
        });
        this$0.n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m78invoke$lambda2$lambda1(RecyclerView recyclerView, int i2, BackgroundBlurController this$0) {
        View view;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i2);
        if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            view.performClick();
        }
        this$0.c.y(true);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(final boolean z) {
        final BackgroundBlurController backgroundBlurController = this.this$0;
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.m
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundBlurController$initBackgroundBlur$1.m77invoke$lambda2(z, backgroundBlurController);
            }
        });
    }
}
