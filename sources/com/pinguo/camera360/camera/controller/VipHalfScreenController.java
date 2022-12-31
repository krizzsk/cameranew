package com.pinguo.camera360.camera.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.member.t0;
import com.pinguo.camera360.vip.VipManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.camera2020.view.InfiniteRecyclerView;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.repository2020.abtest.ABTestManager;
import us.pinguo.repository2020.abtest.HWPriceTestManager;
import us.pinguo.repository2020.abtest.PriceAbTestManager;
import vStudio.Android.Camera360.R;
/* compiled from: VipHalfScreenController.kt */
/* loaded from: classes3.dex */
public final class VipHalfScreenController implements LifecycleObserver, NoProguard {
    public static final String AB_TEST_GROUP_A = "vip_cta_pop_pic";
    public static final String AB_TEST_GROUP_B = "vip_cta_pop_text";
    public static final String AB_TEST_GROUP_DEFAULT = "vip_cta_default";
    public static final String AB_TEST_GROUP_KEY = "an_vip_style_test";
    public static final a Companion = new a(null);
    public static final String URL_PRIVACY = "privacy";
    public static final String URL_SERVICE_PROTOCOL = "subscription_notice";
    private final CameraViewModel cameraViewModel;
    private boolean hasRegisterLifecycleObserver;
    private FrameLayout popupWindowLayout;
    private String productId;
    private String validGroupId;

    /* compiled from: VipHalfScreenController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    /* compiled from: VipHalfScreenController.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            Resources resources = view.getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vip_half_screen_banner_margin_edge);
            int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.vip_half_screen_banner_margin_inner);
            int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.vip_half_screen_banner_margin_horizontal);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.top = dimensionPixelOffset3;
            outRect.bottom = dimensionPixelOffset3;
            if (childAdapterPosition == 0) {
                outRect.left = dimensionPixelOffset;
                outRect.right = dimensionPixelOffset2;
            } else if (childAdapterPosition != 7) {
                outRect.left = dimensionPixelOffset2;
                outRect.right = dimensionPixelOffset2;
            } else {
                outRect.left = dimensionPixelOffset2;
                outRect.right = dimensionPixelOffset;
            }
        }
    }

    /* compiled from: VipHalfScreenController.kt */
    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ConstraintLayout a;

        c(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ConstraintLayout constraintLayout = this.a;
            constraintLayout.setTranslationY(constraintLayout.getHeight());
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    /* compiled from: VipHalfScreenController.kt */
    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ ImageView a;

        d(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setEnabled(true);
            this.a.setClickable(true);
        }
    }

    public VipHalfScreenController(CameraViewModel cameraViewModel) {
        kotlin.jvm.internal.s.h(cameraViewModel, "cameraViewModel");
        this.cameraViewModel = cameraViewModel;
        this.validGroupId = AB_TEST_GROUP_DEFAULT;
        this.productId = "yearly_vip_2399";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closePopupWindow() {
        LifecycleOwner findViewTreeLifecycleOwner;
        Lifecycle lifecycle;
        final FrameLayout frameLayout = this.popupWindowLayout;
        if (frameLayout == null) {
            return;
        }
        InfiniteRecyclerView infiniteRecyclerView = (InfiniteRecyclerView) frameLayout.findViewById(R.id.rvBanner);
        if (infiniteRecyclerView != null) {
            infiniteRecyclerView.f();
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) frameLayout.findViewById(R.id.clContent);
        constraintLayout.animate().translationY(constraintLayout.getHeight()).withEndAction(new Runnable() { // from class: com.pinguo.camera360.camera.controller.d
            @Override // java.lang.Runnable
            public final void run() {
                VipHalfScreenController.m21closePopupWindow$lambda13(frameLayout);
            }
        }).setDuration(300L).start();
        this.hasRegisterLifecycleObserver = false;
        FrameLayout frameLayout2 = this.popupWindowLayout;
        if (frameLayout2 != null && (findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(frameLayout2)) != null && (lifecycle = findViewTreeLifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        us.pinguo.foundation.statistics.h.b.C("exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: closePopupWindow$lambda-13  reason: not valid java name */
    public static final void m21closePopupWindow$lambda13(FrameLayout layout) {
        kotlin.jvm.internal.s.h(layout, "$layout");
        layout.setVisibility(4);
        VdsAgent.onSetViewVisibility(layout, 4);
        if (layout.getId() == R.id.flVipHalfScreenB) {
            ((TextView) layout.findViewById(R.id.txtMemberRights1)).setAlpha(0.0f);
            ((TextView) layout.findViewById(R.id.txtMemberRights2)).setAlpha(0.0f);
            ((TextView) layout.findViewById(R.id.txtMemberRights3)).setAlpha(0.0f);
            ((TextView) layout.findViewById(R.id.txtMemberRights4)).setAlpha(0.0f);
            ((TextView) layout.findViewById(R.id.txtMemberRights5)).setAlpha(0.0f);
            ((TextView) layout.findViewById(R.id.txtMemberRights6)).setAlpha(0.0f);
        }
    }

    private final void goToSalePage(Context context) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("camera_stat_attr_subscription", this.cameraViewModel.cameraAttrToSubscription());
        us.pinguo.camera2020.i.a.a.g(context, bundle);
    }

    private final FrameLayout inflateLayoutForGroupA(final Context context, ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.vip_half_screen_window_a_layout);
        View inflate = viewStub.inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        frameLayout.setOnTouchListener(n.a);
        InfiniteRecyclerView infiniteRecyclerView = (InfiniteRecyclerView) frameLayout.findViewById(R.id.rvBanner);
        TextView textView = (TextView) frameLayout.findViewById(R.id.txtProtocol);
        textView.setText(R.string.agreement_dialog_user_agreement);
        TextView textView2 = (TextView) frameLayout.findViewById(R.id.txtPrivacy);
        textView2.setText(R.string.agreement_dialog_privacy_policy);
        infiniteRecyclerView.addItemDecoration(new b());
        infiniteRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_no_ads, R.string.vip_half_screen_no_ads));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_facial_reshape, R.string.vip_half_screen_facial_reshape));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_blue, R.string.vip_half_screen_blue));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_remover, R.string.vip_half_screen_remover));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_makeup, R.string.vip_half_screen_makeup));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_sticker, R.string.vip_half_screen_sticker));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_skin, R.string.vip_half_screen_skin));
        arrayList.add(new us.pinguo.camera2020.view.adapter.w(R.drawable.ic_vip_half_screen_body_shape, R.string.vip_half_screen_body_shape));
        infiniteRecyclerView.setAdapter(new us.pinguo.camera2020.view.adapter.o(arrayList));
        ((ImageView) frameLayout.findViewById(R.id.imgClose)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m23inflateLayoutForGroupA$lambda2(VipHalfScreenController.this, view);
            }
        });
        ((TextView) frameLayout.findViewById(R.id.txtLearnMore)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m24inflateLayoutForGroupA$lambda3(VipHalfScreenController.this, view);
            }
        });
        ((TextView) frameLayout.findViewById(R.id.txtSubscribe)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m25inflateLayoutForGroupA$lambda4(VipHalfScreenController.this, context, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m26inflateLayoutForGroupA$lambda5(VipHalfScreenController.this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m27inflateLayoutForGroupA$lambda6(VipHalfScreenController.this, view);
            }
        });
        updateSubscriptionUI(frameLayout);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-1  reason: not valid java name */
    public static final boolean m22inflateLayoutForGroupA$lambda1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-2  reason: not valid java name */
    public static final void m23inflateLayoutForGroupA$lambda2(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.closePopupWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-3  reason: not valid java name */
    public static final void m24inflateLayoutForGroupA$lambda3(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.b.C("learn_more");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        this$0.goToSalePage(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-4  reason: not valid java name */
    public static final void m25inflateLayoutForGroupA$lambda4(VipHalfScreenController this$0, Context context, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(context, "$context");
        us.pinguo.foundation.statistics.h.b.C("sub_btn");
        Context context2 = view.getContext();
        kotlin.jvm.internal.s.g(context2, "it.context");
        VipHalfScreenSubscribePresenter vipHalfScreenSubscribePresenter = new VipHalfScreenSubscribePresenter(context2);
        vipHalfScreenSubscribePresenter.c(new VipHalfScreenController$inflateLayoutForGroupA$4$1(context, this$0));
        vipHalfScreenSubscribePresenter.i(this$0.productId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-5  reason: not valid java name */
    public static final void m26inflateLayoutForGroupA$lambda5(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        this$0.launchWebView(context, URL_SERVICE_PROTOCOL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupA$lambda-6  reason: not valid java name */
    public static final void m27inflateLayoutForGroupA$lambda6(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        this$0.launchWebView(context, URL_PRIVACY);
    }

    private final FrameLayout inflateLayoutForGroupB(final Context context, ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.vip_half_screen_window_b_layout);
        View inflate = viewStub.inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        TextView textView = (TextView) frameLayout.findViewById(R.id.txtMemberRights1);
        textView.setText(R.string.vip_fun_item_text1);
        TextView textView2 = (TextView) frameLayout.findViewById(R.id.txtMemberRights2);
        textView2.setText(R.string.vip_fun_item_text2);
        TextView textView3 = (TextView) frameLayout.findViewById(R.id.txtMemberRights3);
        textView3.setText(R.string.vip_fun_item_text3);
        TextView textView4 = (TextView) frameLayout.findViewById(R.id.txtMemberRights4);
        textView4.setText(R.string.vip_fun_item_text4);
        TextView textView5 = (TextView) frameLayout.findViewById(R.id.txtMemberRights5);
        textView5.setText(R.string.vip_fun_item_text5);
        TextView textView6 = (TextView) frameLayout.findViewById(R.id.txtMemberRights6);
        textView6.setText(R.string.vip_fun_item_text6);
        frameLayout.setOnTouchListener(f.a);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.imgClose);
        TextView textView7 = (TextView) frameLayout.findViewById(R.id.txtProtocol);
        textView7.setText(R.string.agreement_dialog_user_agreement);
        TextView textView8 = (TextView) frameLayout.findViewById(R.id.txtPrivacy);
        textView8.setText(R.string.agreement_dialog_privacy_policy);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m31inflateLayoutForGroupB$lambda8(VipHalfScreenController.this, view);
            }
        });
        imageView.setEnabled(false);
        imageView.setClickable(false);
        ((TextView) frameLayout.findViewById(R.id.txtSubscribe)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m32inflateLayoutForGroupB$lambda9(VipHalfScreenController.this, context, view);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m28inflateLayoutForGroupB$lambda10(VipHalfScreenController.this, view);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipHalfScreenController.m29inflateLayoutForGroupB$lambda11(VipHalfScreenController.this, view);
            }
        });
        textView.setAlpha(0.0f);
        textView2.setAlpha(0.0f);
        textView3.setAlpha(0.0f);
        textView4.setAlpha(0.0f);
        textView5.setAlpha(0.0f);
        textView6.setAlpha(0.0f);
        updateSubscriptionUI(frameLayout);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupB$lambda-10  reason: not valid java name */
    public static final void m28inflateLayoutForGroupB$lambda10(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        this$0.launchWebView(context, URL_SERVICE_PROTOCOL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupB$lambda-11  reason: not valid java name */
    public static final void m29inflateLayoutForGroupB$lambda11(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        this$0.launchWebView(context, URL_PRIVACY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupB$lambda-7  reason: not valid java name */
    public static final boolean m30inflateLayoutForGroupB$lambda7(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupB$lambda-8  reason: not valid java name */
    public static final void m31inflateLayoutForGroupB$lambda8(VipHalfScreenController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.closePopupWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: inflateLayoutForGroupB$lambda-9  reason: not valid java name */
    public static final void m32inflateLayoutForGroupB$lambda9(VipHalfScreenController this$0, Context context, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(context, "$context");
        us.pinguo.foundation.statistics.h.b.C("sub_btn");
        Context context2 = view.getContext();
        kotlin.jvm.internal.s.g(context2, "it.context");
        VipHalfScreenSubscribePresenter vipHalfScreenSubscribePresenter = new VipHalfScreenSubscribePresenter(context2);
        vipHalfScreenSubscribePresenter.c(new VipHalfScreenController$inflateLayoutForGroupB$3$1(context, this$0));
        vipHalfScreenSubscribePresenter.i(this$0.productId);
    }

    private final void launchWebView(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
        intent.putExtra("towhere", str);
        context.startActivity(intent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (us.pinguo.vip.proxy.b.a.f()) {
            closePopupWindow();
        }
    }

    private final void setTextPrice(FrameLayout frameLayout) {
        String format;
        TextView textView = (TextView) frameLayout.findViewById(R.id.txtPriceDescription);
        String str = this.productId;
        VipManager vipManager = VipManager.a;
        String x = vipManager.x();
        if (x != null) {
            this.productId = x;
        }
        if (us.pinguo.util.p.c() && us.pinguo.repository2020.abtest.j.a.c()) {
            String r = vipManager.r(str);
            String r2 = vipManager.r(this.productId);
            String a2 = com.pinguo.camera360.i.a.a(this.productId, r2);
            if (kotlin.jvm.internal.s.c(str, this.productId)) {
                if (kotlin.jvm.internal.s.c("$23.99", r2)) {
                    kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                    String string = frameLayout.getContext().getString(R.string.vip_gp_price);
                    kotlin.jvm.internal.s.g(string, "layout.context.getString…60.R.string.vip_gp_price)");
                    format = String.format(string, Arrays.copyOf(new Object[]{r2, a2}, 2));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                } else {
                    kotlin.jvm.internal.x xVar2 = kotlin.jvm.internal.x.a;
                    String string2 = frameLayout.getContext().getString(R.string.pay_wall_price_month_after);
                    kotlin.jvm.internal.s.g(string2, "layout.context.getString…y_wall_price_month_after)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{r2}, 1));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                }
                textView.setText(format);
                return;
            }
            kotlin.jvm.internal.x xVar3 = kotlin.jvm.internal.x.a;
            String string3 = frameLayout.getContext().getString(R.string.huawei_discount_price);
            kotlin.jvm.internal.s.g(string3, "layout.context.getString…ng.huawei_discount_price)");
            String format2 = String.format(string3, Arrays.copyOf(new Object[]{r, r2}, 2));
            kotlin.jvm.internal.s.g(format2, "format(format, *args)");
            int i2 = us.pinguo.user.util.n.i() ? 7 : 11;
            SpannableString spannableString = new SpannableString(format2);
            spannableString.setSpan(new StrikethroughSpan(), 0, i2, 33);
            textView.setText(spannableString);
            return;
        }
        String r3 = vipManager.r(str);
        String a3 = com.pinguo.camera360.i.a.a(str, r3);
        if (kotlin.jvm.internal.s.c(str, this.productId)) {
            kotlin.jvm.internal.x xVar4 = kotlin.jvm.internal.x.a;
            String string4 = frameLayout.getContext().getString(R.string.vip_gp_price);
            kotlin.jvm.internal.s.g(string4, "layout.context.getString(textRes)");
            String format3 = String.format(string4, Arrays.copyOf(new Object[]{r3, a3}, 2));
            kotlin.jvm.internal.s.g(format3, "format(format, *args)");
            textView.setText(format3);
            return;
        }
        String r4 = vipManager.r(this.productId);
        kotlin.jvm.internal.x xVar5 = kotlin.jvm.internal.x.a;
        String string5 = frameLayout.getContext().getString(R.string.huawei_discount_price);
        kotlin.jvm.internal.s.g(string5, "layout.context.getString…ng.huawei_discount_price)");
        String format4 = String.format(string5, Arrays.copyOf(new Object[]{r3, r4}, 2));
        kotlin.jvm.internal.s.g(format4, "format(format, *args)");
        int i3 = us.pinguo.user.util.n.i() ? 7 : 11;
        SpannableString spannableString2 = new SpannableString(format4);
        spannableString2.setSpan(new StrikethroughSpan(), 0, i3, 33);
        textView.setText(spannableString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHalfScreenPopup$lambda-0  reason: not valid java name */
    public static final void m33showHalfScreenPopup$lambda0(Ref$ObjectRef layout, VipHalfScreenController this$0) {
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (((FrameLayout) layout.element).getId() == R.id.flVipHalfScreenA) {
            ((InfiniteRecyclerView) ((FrameLayout) layout.element).findViewById(R.id.rvBanner)).e();
        } else if (((FrameLayout) layout.element).getId() == R.id.flVipHalfScreenB) {
            this$0.startMemberRightsAnimation((FrameLayout) layout.element);
        }
    }

    private final void startMemberRightsAnimation(FrameLayout frameLayout) {
        AnimatorSet animatorSet = new AnimatorSet();
        TextView textView = (TextView) frameLayout.findViewById(R.id.txtMemberRights6);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.imgClose);
        final TextView textView2 = (TextView) frameLayout.findViewById(R.id.txtSubscribe);
        textView2.setScaleX(1.0f);
        textView2.setScaleY(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) frameLayout.findViewById(R.id.txtMemberRights1), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) frameLayout.findViewById(R.id.txtMemberRights2), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((TextView) frameLayout.findViewById(R.id.txtMemberRights3), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((TextView) frameLayout.findViewById(R.id.txtMemberRights4), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((TextView) frameLayout.findViewById(R.id.txtMemberRights5), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat6 = textView.getVisibility() == 0 ? ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f) : null;
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(1.0f, 1.12f, 1.0f);
        ofFloat7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.camera.controller.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VipHalfScreenController.m34startMemberRightsAnimation$lambda12(textView2, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        ofFloat5.setDuration(200L);
        if (ofFloat6 != null) {
            ofFloat6.setDuration(200L);
        }
        ofFloat7.setDuration(600L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        arrayList.add(ofFloat5);
        if (ofFloat6 != null) {
            arrayList.add(ofFloat6);
        }
        arrayList.add(ofFloat7);
        animatorSet.playSequentially(arrayList);
        animatorSet.addListener(new d(imageView));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startMemberRightsAnimation$lambda-12  reason: not valid java name */
    public static final void m34startMemberRightsAnimation$lambda12(TextView textView, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        textView.setScaleX(((Float) animatedValue).floatValue());
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        textView.setScaleY(((Float) animatedValue2).floatValue());
    }

    private final void updateSubscriptionUI(FrameLayout frameLayout) {
        String a2;
        String str;
        CharSequence charSequence;
        Context context = frameLayout.getContext();
        TextView textView = (TextView) frameLayout.findViewById(R.id.txtPriceDescription);
        if (HuaweiAgent.isHuaweiSupport()) {
            VipManager vipManager = VipManager.a;
            String x = vipManager.x();
            if (x == null || x.length() == 0) {
                t0 t0Var = t0.a;
                if (t0Var.d()) {
                    RechargeGoodsDiscountInfo b2 = t0Var.b();
                    if (b2 == null) {
                        return;
                    }
                    this.productId = "yearly_vip_2399";
                    kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                    String string = context.getString(R.string.huawei_discount_price);
                    kotlin.jvm.internal.s.g(string, "context.getString(vStudi…ng.huawei_discount_price)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{b2.getOriginalPrice(), b2.getPrice()}, 2));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                    int i2 = us.pinguo.user.util.n.i() ? 7 : 11;
                    SpannableString spannableString = new SpannableString(format);
                    spannableString.setSpan(new StrikethroughSpan(), 0, i2, 33);
                    textView.setText(spannableString);
                    return;
                }
            }
            String a3 = HWPriceTestManager.a.a();
            String str2 = a3 != null ? a3 : "yearly_vip_2399";
            if (x == null || x.length() == 0) {
                x = str2;
            }
            this.productId = x;
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("hw product id==>", x), new Object[0]);
            String str3 = null;
            if (vipManager.v() != null) {
                str = null;
                for (PayHelp.l lVar : vipManager.v()) {
                    us.pinguo.common.log.a.k("hw price===>" + ((Object) lVar.b) + "====>" + ((Object) lVar.a), new Object[0]);
                    if (kotlin.jvm.internal.s.c(str2, lVar.a)) {
                        str = lVar.b;
                    }
                    if (kotlin.jvm.internal.s.c(this.productId, lVar.a)) {
                        str3 = lVar.b;
                    }
                }
            } else {
                str = null;
            }
            if (str3 == null || str3.length() == 0) {
                str3 = VipManager.a.w();
            }
            if (kotlin.jvm.internal.s.c(str2, this.productId)) {
                kotlin.jvm.internal.x xVar2 = kotlin.jvm.internal.x.a;
                String string2 = context.getString(R.string.vip_for_2399);
                kotlin.jvm.internal.s.g(string2, "context.getString(vStudi…60.R.string.vip_for_2399)");
                charSequence = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
                kotlin.jvm.internal.s.g(charSequence, "format(format, *args)");
            } else {
                kotlin.jvm.internal.x xVar3 = kotlin.jvm.internal.x.a;
                String string3 = context.getString(R.string.huawei_discount_price);
                kotlin.jvm.internal.s.g(string3, "context.getString(vStudi…ng.huawei_discount_price)");
                String format2 = String.format(string3, Arrays.copyOf(new Object[]{str, str3}, 2));
                kotlin.jvm.internal.s.g(format2, "format(format, *args)");
                int i3 = us.pinguo.user.util.n.i() ? 7 : 11;
                SpannableString spannableString2 = new SpannableString(format2);
                spannableString2.setSpan(new StrikethroughSpan(), 0, i3, 33);
                charSequence = spannableString2;
            }
            textView.setText(charSequence);
            return;
        }
        us.pinguo.repository2020.abtest.g g2 = PriceAbTestManager.a.g();
        String str4 = "yearly_vip_2399_3dayfree";
        if (us.pinguo.util.p.c()) {
            str4 = us.pinguo.repository2020.abtest.j.a.b();
        } else if (g2 != null && (a2 = g2.a()) != null) {
            str4 = a2;
        }
        this.productId = str4;
        setTextPrice(frameLayout);
    }

    public final boolean enabled() {
        String p = ABTestManager.a.p(AB_TEST_GROUP_KEY, AB_TEST_GROUP_DEFAULT);
        this.validGroupId = p;
        return !kotlin.jvm.internal.s.c(p, AB_TEST_GROUP_DEFAULT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.widget.FrameLayout] */
    public final void showHalfScreenPopup(Context context, ViewStub viewStub) {
        LifecycleOwner findViewTreeLifecycleOwner;
        Lifecycle lifecycle;
        T t;
        kotlin.jvm.internal.s.h(context, "context");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.popupWindowLayout;
        ref$ObjectRef.element = r1;
        if (r1 == 0 && viewStub != null) {
            String str = this.validGroupId;
            if (kotlin.jvm.internal.s.c(str, AB_TEST_GROUP_A)) {
                t = inflateLayoutForGroupA(context, viewStub);
            } else if (!kotlin.jvm.internal.s.c(str, AB_TEST_GROUP_B)) {
                return;
            } else {
                t = inflateLayoutForGroupB(context, viewStub);
            }
            ref$ObjectRef.element = t;
            this.popupWindowLayout = t;
            ConstraintLayout constraintLayout = (ConstraintLayout) ((FrameLayout) t).findViewById(R.id.clContent);
            constraintLayout.getViewTreeObserver().addOnPreDrawListener(new c(constraintLayout));
        }
        T t2 = ref$ObjectRef.element;
        if (t2 == 0) {
            return;
        }
        View view = (View) t2;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        ViewPropertyAnimator withEndAction = ((ConstraintLayout) ((FrameLayout) ref$ObjectRef.element).findViewById(R.id.clContent)).animate().translationY(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.pinguo.camera360.camera.controller.a
            @Override // java.lang.Runnable
            public final void run() {
                VipHalfScreenController.m33showHalfScreenPopup$lambda0(Ref$ObjectRef.this, this);
            }
        });
        if (withEndAction != null) {
            withEndAction.start();
        }
        if (!this.hasRegisterLifecycleObserver) {
            this.hasRegisterLifecycleObserver = true;
            FrameLayout frameLayout = this.popupWindowLayout;
            if (frameLayout != null && (findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(frameLayout)) != null && (lifecycle = findViewTreeLifecycleOwner.getLifecycle()) != null) {
                lifecycle.addObserver(this);
            }
        }
        us.pinguo.foundation.statistics.h.b.C("show");
    }
}
