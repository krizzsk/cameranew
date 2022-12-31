package us.pinguo.edit2020.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import us.pinguo.ad.RewardVipAdController;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.common.filter.ChangeStatus;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.manager.AdvDialogManager;
import us.pinguo.common.widget.FilterNameAnimView;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.SkyChangeGuideView;
import us.pinguo.common.widget.adv.AdRewardView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.AdjustController;
import us.pinguo.edit2020.controller.EditBottomTabBeautyController;
import us.pinguo.edit2020.controller.EditBottomTabBeautyControllerNew;
import us.pinguo.edit2020.controller.EditController;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.controller.EditTabType;
import us.pinguo.edit2020.controller.a3;
import us.pinguo.edit2020.controller.b3;
import us.pinguo.edit2020.controller.d3;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.fragment.EditFragment;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.utils.ScreenshotDetector;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.FacePointView;
import us.pinguo.edit2020.view.GestureView;
import us.pinguo.edit2020.view.ManualSkinFullScreenGuide;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.edit2020.widget.FaceCurveView;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.picker.image.PickItem;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.u3dengine.PGUnityEditFragment;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment extends PGUnityEditFragment implements PGEditBottomTabLayout.a, PGEditBottomTabLayout.b, us.pinguo.edit2020.view.p0 {
    private a3 A;
    private boolean B;
    private final ScreenshotDetector C;
    private RewardVipAdController D;
    private boolean E;
    private volatile boolean F;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f10510f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private d3 f10511g;

    /* renamed from: h  reason: collision with root package name */
    private AdjustController f10512h;

    /* renamed from: i  reason: collision with root package name */
    private EditController f10513i;

    /* renamed from: j  reason: collision with root package name */
    private b3 f10514j;

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.f f10515k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.edit2020.view.c0 f10516l;
    private final Handler m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private final MutableLiveData<Boolean> s;
    private final MutableLiveData<Boolean> t;
    private AdvDialogManager u;
    private boolean v;
    private boolean w;
    private EditFilterController x;
    private z2 y;
    private z2 z;

    /* compiled from: Runnable.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditFragment editFragment = EditFragment.this;
            int i2 = R.id.imgBoldTip;
            if (us.pinguo.edit2020.utils.d.e((BoldTipView) editFragment._$_findCachedViewById(i2))) {
                return;
            }
            ((BoldTipView) EditFragment.this._$_findCachedViewById(i2)).animate().alpha(0.0f).withEndAction(new d()).setDuration(200L).start();
        }
    }

    /* compiled from: EditFragment.kt */
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(EditFragment this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            ConstraintLayout clLottieForAreaProtect = (ConstraintLayout) this$0._$_findCachedViewById(R.id.clLottieForAreaProtect);
            kotlin.jvm.internal.s.g(clLottieForAreaProtect, "clLottieForAreaProtect");
            clLottieForAreaProtect.setVisibility(8);
            VdsAgent.onSetViewVisibility(clLottieForAreaProtect, 8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator duration = ((ConstraintLayout) EditFragment.this._$_findCachedViewById(R.id.clLottieForAreaProtect)).animate().alpha(0.0f).setDuration(200L);
            final EditFragment editFragment = EditFragment.this;
            duration.withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.k0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment.b.b(EditFragment.this);
                }
            }).start();
        }
    }

    /* compiled from: EditFragment.kt */
    /* loaded from: classes4.dex */
    public static final class c implements a3 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(EditFragment this$0, boolean z, boolean z2) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            a3 a3Var = this$0.A;
            if (a3Var == null) {
                return;
            }
            a3Var.n(z, z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(EditFragment this$0, String records) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(records, "$records");
            a3 a3Var = this$0.A;
            if (a3Var != null) {
                a3Var.i(records);
            }
            this$0.m1();
        }

        @Override // us.pinguo.edit2020.controller.a3
        public void i(final String records) {
            kotlin.jvm.internal.s.h(records, "records");
            final EditFragment editFragment = EditFragment.this;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.fragment.m0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment.c.f(EditFragment.this, records);
                }
            });
        }

        @Override // us.pinguo.edit2020.controller.a3
        public void n(final boolean z, final boolean z2) {
            final EditFragment editFragment = EditFragment.this;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.fragment.l0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment.c.d(EditFragment.this, z, z2);
                }
            });
        }
    }

    /* compiled from: EditFragment.kt */
    /* loaded from: classes4.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BoldTipView imgBoldTip = (BoldTipView) EditFragment.this._$_findCachedViewById(R.id.imgBoldTip);
            kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
            imgBoldTip.setVisibility(4);
            VdsAgent.onSetViewVisibility(imgBoldTip, 4);
        }
    }

    /* compiled from: EditFragment.kt */
    /* loaded from: classes4.dex */
    public static final class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LottieAnimationView onekeyBeautyAnim = (LottieAnimationView) EditFragment.this._$_findCachedViewById(R.id.onekeyBeautyAnim);
            kotlin.jvm.internal.s.g(onekeyBeautyAnim, "onekeyBeautyAnim");
            onekeyBeautyAnim.setVisibility(8);
            VdsAgent.onSetViewVisibility(onekeyBeautyAnim, 8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public EditFragment() {
        EditFragment$special$$inlined$viewModels$default$1 editFragment$special$$inlined$viewModels$default$1 = new EditFragment$special$$inlined$viewModels$default$1(this);
        this.f10515k = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(EditViewModel.class), new EditFragment$special$$inlined$viewModels$default$2(editFragment$special$$inlined$viewModels$default$1), new EditFragment$special$$inlined$viewModels$default$3(editFragment$special$$inlined$viewModels$default$1, this));
        this.m = new Handler();
        Boolean bool = Boolean.FALSE;
        this.s = new MutableLiveData<>(bool);
        this.t = new MutableLiveData<>(bool);
        this.w = true;
        this.C = new ScreenshotDetector();
    }

    private final void A1() {
        int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        if (i2 > 0) {
            int i3 = R.id.viewHairCut;
            View viewHairCut = _$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(viewHairCut, "viewHairCut");
            viewHairCut.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewHairCut, 0);
            View viewHairCut2 = _$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(viewHairCut2, "viewHairCut");
            ViewGroup.LayoutParams layoutParams = viewHairCut2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
            viewHairCut2.setLayoutParams(layoutParams2);
        }
        ((AppCompatImageView) _$_findCachedViewById(R.id.imgBack)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFragment.B1(EditFragment.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.txtSave)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditFragment.C1(EditFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A2(EditFragment editFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        editFragment.z2(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(EditFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.N2();
    }

    private final void B2(final kotlin.jvm.b.a<kotlin.u> aVar) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.b(activity);
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(activity, null, activity.getString(R.string.str_confirm_exit_body_shape), activity.getString(R.string.confirm), activity.getString(us.pinguo.user.R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.fragment.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                EditFragment.C2(FragmentActivity.this, aVar, dialogInterface, i2);
            }
        });
        h2.setCancelable(false);
        h2.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(EditFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        boolean z = false;
        if (!this$0.j1().t()) {
            us.pinguo.common.log.a.c("拦截Unity没有保存成功之前的保存事件", new Object[0]);
            return;
        }
        if ((this$0.j1().j().c() || this$0.p) && !us.pinguo.vip.proxy.b.b(us.pinguo.vip.proxy.b.a, false, 1, null) && us.pinguo.repository2020.abtest.i.a.b()) {
            this$0.y2();
            return;
        }
        if (this$0.j1().j().c() && !us.pinguo.vip.proxy.b.b(us.pinguo.vip.proxy.b.a, false, 1, null)) {
            z = true;
        }
        if (z) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this$0), kotlinx.coroutines.z0.b(), null, new EditFragment$initHeader$3$1(this$0, null), 2, null);
        } else {
            this$0.e1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(FragmentActivity act, kotlin.jvm.b.a callback, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(act, "$act");
        kotlin.jvm.internal.s.h(callback, "$callback");
        us.pinguo.foundation.utils.d0.a(act);
        if (i2 == -2) {
            if (dialogInterface == null) {
                return;
            }
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            callback.invoke();
        }
    }

    private final void D1() {
        j1().j().a().m();
        String g2 = j1().g();
        if (g2 == null) {
            g2 = "";
        }
        j1().j().a().n(new HistoryRecord(g2, null));
        j1().L();
    }

    private final void D2() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.b(activity);
        us.pinguo.foundation.utils.w.g(activity, -999, R.string.pg_sdk_edit_quit_edit, R.string.pg_sdk_edit_ok, R.string.pg_sdk_edit_quit, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.fragment.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                EditFragment.E2(EditFragment.this, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.fragment.p0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EditFragment.F2(FragmentActivity.this, dialogInterface);
            }
        });
    }

    private final void E1() {
        j1().R(new EditFragment$initMakeupRenderCompleteCallback$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(EditFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.h1();
        }
    }

    private final void F1() {
        j1().V(new EditFragment$initUnityPrepareCallback$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(FragmentActivity it, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(it, "$it");
        us.pinguo.foundation.utils.d0.a(it);
    }

    private final boolean G1(us.pinguo.edit2020.bean.x xVar) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        boolean b2 = us.pinguo.repository2020.utils.o.b(oVar, xVar.f(), true, null, 4, null);
        if (b2) {
            us.pinguo.repository2020.utils.o.n(oVar, xVar.f(), false, null, 4, null);
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2() {
        String itemId;
        String name;
        FilterNameAnimView.Direction direction;
        EditFilterModule i2 = j1().i();
        ChangeStatus n = i2.n();
        FilterEntry value = i2.y().getValue();
        if (value == null || (itemId = value.getItemId()) == null) {
            return;
        }
        if (kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_NONE_KEY)) {
            name = getResources().getString(R.string.filter_name_none);
        } else if (kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_AUTO_KEY)) {
            name = getResources().getString(R.string.filter_name_auto);
        } else {
            FilterItem z = i2.z(value.getPkgId(), itemId);
            name = z == null ? null : z.getName();
            if (name == null) {
                return;
            }
        }
        kotlin.jvm.internal.s.g(name, "when (val filterId = cur….name ?: return\n        }");
        int i3 = R.id.effectTipView;
        ((FilterNameAnimView) _$_findCachedViewById(i3)).setNameText(name);
        if (n != ChangeStatus.CLICK_RIGHT && n != ChangeStatus.SLIDE_RIGHT) {
            direction = FilterNameAnimView.Direction.LEFT_TO_RIGHT;
        } else {
            direction = FilterNameAnimView.Direction.RIGHT_TO_LEFT;
        }
        ((FilterNameAnimView) _$_findCachedViewById(i3)).setSubContentEnable(false);
        ((FilterNameAnimView) _$_findCachedViewById(i3)).b(direction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1() {
        ArrayList<us.pinguo.edit2020.bean.f> arrayList;
        ArrayList<us.pinguo.edit2020.bean.s0> arrayList2;
        ArrayList<us.pinguo.edit2020.bean.s> arrayList3;
        ArrayList<us.pinguo.edit2020.bean.r0> arrayList4;
        boolean z = true;
        try {
            Class.forName("us.pinguo.androidsdk.pgedit.PGEditResultActivity2");
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(activity, "us.pinguo.androidsdk.pgedit.PGEditResultActivity2");
            intent.putExtra("no_ads", this.E);
            HistoryRecord c2 = j1().j().a().c();
            ArrayList<us.pinguo.edit2020.bean.t0> arrayList5 = null;
            intent.putExtra(PGEditResultActivity2.PATH, c2 == null ? null : c2.getPicturePath());
            List<us.pinguo.edit2020.bean.x> b2 = j1().j().b();
            if ((b2 == null ? 0 : b2.size()) > 0) {
                HashMap hashMap = new HashMap();
                if (b2 == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj : b2) {
                        if (obj instanceof us.pinguo.edit2020.bean.f) {
                            arrayList.add(obj);
                        }
                    }
                }
                if (!(arrayList == null || arrayList.isEmpty())) {
                    ArrayList arrayList6 = new ArrayList();
                    for (us.pinguo.edit2020.bean.f fVar : arrayList) {
                        arrayList6.add(fVar.f());
                    }
                    arrayList6.add(PortalFollowFeeds.TYPE_ALL);
                    hashMap.put("background", arrayList6);
                }
                if (b2 == null) {
                    arrayList2 = null;
                } else {
                    arrayList2 = new ArrayList();
                    for (Object obj2 : b2) {
                        if (obj2 instanceof us.pinguo.edit2020.bean.s0) {
                            arrayList2.add(obj2);
                        }
                    }
                }
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    ArrayList arrayList7 = new ArrayList();
                    for (us.pinguo.edit2020.bean.s0 s0Var : arrayList2) {
                        arrayList7.add(s0Var.f());
                    }
                    arrayList7.add(PortalFollowFeeds.TYPE_ALL);
                    hashMap.put("makeup", arrayList7);
                }
                if (b2 == null) {
                    arrayList3 = null;
                } else {
                    arrayList3 = new ArrayList();
                    for (Object obj3 : b2) {
                        if (obj3 instanceof us.pinguo.edit2020.bean.s) {
                            arrayList3.add(obj3);
                        }
                    }
                }
                if (!(arrayList3 == null || arrayList3.isEmpty())) {
                    ArrayList arrayList8 = new ArrayList();
                    for (us.pinguo.edit2020.bean.s sVar : arrayList3) {
                        String o = FilterRepository.a.o(sVar.f());
                        if (!(o == null || o.length() == 0)) {
                            arrayList8.add(o);
                        }
                    }
                    arrayList8.add(PortalFollowFeeds.TYPE_ALL);
                    hashMap.put("filter", arrayList8);
                }
                if (b2 == null) {
                    arrayList4 = null;
                } else {
                    arrayList4 = new ArrayList();
                    for (Object obj4 : b2) {
                        if (obj4 instanceof us.pinguo.edit2020.bean.r0) {
                            arrayList4.add(obj4);
                        }
                    }
                }
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    ArrayList arrayList9 = new ArrayList();
                    for (us.pinguo.edit2020.bean.r0 r0Var : arrayList4) {
                        arrayList9.add(r0Var.f());
                    }
                    arrayList9.add(PortalFollowFeeds.TYPE_ALL);
                    hashMap.put("stickerPackage", arrayList9);
                }
                if (b2 != null) {
                    arrayList5 = new ArrayList();
                    for (Object obj5 : b2) {
                        if (obj5 instanceof us.pinguo.edit2020.bean.t0) {
                            arrayList5.add(obj5);
                        }
                    }
                }
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    ArrayList arrayList10 = new ArrayList();
                    for (us.pinguo.edit2020.bean.t0 t0Var : arrayList5) {
                        arrayList10.add(t0Var.f());
                    }
                    arrayList10.add(PortalFollowFeeds.TYPE_ALL);
                    hashMap.put("stickerTemplate", arrayList10);
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("edit_history", hashMap);
                intent.putExtras(bundle);
            }
            startActivityForResult(intent, 2, ActivityOptions.makeSceneTransitionAnimation(activity, (ImageView) _$_findCachedViewById(R.id.imageMask), "imageView").toBundle());
        } catch (ClassNotFoundException unused) {
            Toast makeText = Toast.makeText(us.pinguo.util.v.a(), "Edit error!", 1);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2() {
        int i2 = R.id.onekeyBeautyAnim;
        if (us.pinguo.edit2020.utils.d.e((LottieAnimationView) _$_findCachedViewById(i2))) {
            return;
        }
        LottieAnimationView onekeyBeautyAnim = (LottieAnimationView) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(onekeyBeautyAnim, "onekeyBeautyAnim");
        onekeyBeautyAnim.setVisibility(0);
        VdsAgent.onSetViewVisibility(onekeyBeautyAnim, 0);
        us.pinguo.edit2020.bean.u0 value = j1().w().getValue();
        if (value == null) {
            return;
        }
        float e2 = value.e();
        float d2 = value.d();
        ViewGroup.LayoutParams layoutParams = ((LottieAnimationView) _$_findCachedViewById(i2)).getLayoutParams();
        layoutParams.height = (int) d2;
        layoutParams.width = (int) e2;
        ((LottieAnimationView) _$_findCachedViewById(i2)).setLayoutParams(layoutParams);
        ((LottieAnimationView) _$_findCachedViewById(i2)).setAnimation("lottie/yjmy.json");
        ((LottieAnimationView) _$_findCachedViewById(i2)).d(new e());
        ((LottieAnimationView) _$_findCachedViewById(i2)).p();
    }

    private final void I2(boolean z) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2() {
        if (us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "isEditFirstSkyChange", true, null, 4, null)) {
            SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) _$_findCachedViewById(R.id.gvSkyChange);
            kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
            gvSkyChange.setVisibility(0);
            VdsAgent.onSetViewVisibility(gvSkyChange, 0);
            ConstraintLayout frameLayout = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
            kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
            us.pinguo.foundation.ui.c.b(frameLayout, new Runnable() { // from class: us.pinguo.edit2020.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment.K2(EditFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(final EditFragment this$0) {
        View t0;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        EditFilterController editFilterController = this$0.x;
        if (editFilterController == null || (t0 = editFilterController.t0()) == null) {
            return;
        }
        Rect rect = new Rect();
        t0.getGlobalVisibleRect(rect);
        int i2 = R.id.gvSkyChange;
        SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) this$0._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
        gvSkyChange.e(rect.left, rect.top, t0.getWidth(), t0.getHeight(), (r12 & 16) != 0 ? false : false);
        ((SkyChangeGuideView) this$0._$_findCachedViewById(i2)).c().setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.edit2020.fragment.n0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean L2;
                L2 = EditFragment.L2(EditFragment.this, view, motionEvent);
                return L2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L2(EditFragment this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.gvSkyChange;
        SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) this$0._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
        if (gvSkyChange.getVisibility() == 0) {
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new EditFragment$showSkyChangeGuide$1$1$1$1(null), 3, null);
            SkyChangeGuideView gvSkyChange2 = (SkyChangeGuideView) this$0._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(gvSkyChange2, "gvSkyChange");
            gvSkyChange2.setVisibility(8);
            VdsAgent.onSetViewVisibility(gvSkyChange2, 8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M2(us.pinguo.repository2020.entity.FilterEntry r9, kotlin.coroutines.Continuation<? super kotlin.u> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$1
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$1 r0 = (us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$1 r0 = new us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r9 = r0.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$1
            us.pinguo.repository2020.entity.FilterEntry r2 = (us.pinguo.repository2020.entity.FilterEntry) r2
            java.lang.Object r0 = r0.L$0
            us.pinguo.edit2020.fragment.EditFragment r0 = (us.pinguo.edit2020.fragment.EditFragment) r0
            kotlin.j.b(r10)
            r7 = r2
            r2 = r9
            r9 = r7
            goto L76
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            kotlin.j.b(r10)
            java.lang.String r10 = r9.getPkgId()
            if (r10 != 0) goto L50
            kotlin.u r9 = kotlin.u.a
            return r9
        L50:
            java.lang.String r2 = r9.getItemId()
            if (r2 != 0) goto L59
            kotlin.u r9 = kotlin.u.a
            return r9
        L59:
            kotlinx.coroutines.g2 r4 = kotlinx.coroutines.z0.c()
            us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$2 r5 = new us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$2
            r6 = 0
            r5.<init>(r8, r6)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.j.g(r4, r5, r0)
            if (r0 != r1) goto L74
            return r1
        L74:
            r0 = r8
            r1 = r10
        L76:
            us.pinguo.edit2020.viewmodel.EditViewModel r10 = r0.j1()
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r10 = r10.i()
            boolean r10 = r10.X()
            if (r10 == 0) goto L8f
            us.pinguo.edit2020.viewmodel.EditViewModel r10 = r0.j1()
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r10 = r10.i()
            r10.h()
        L8f:
            us.pinguo.edit2020.viewmodel.EditViewModel r10 = r0.j1()
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r10 = r10.i()
            us.pinguo.edit2020.viewmodel.EditViewModel r3 = r0.j1()
            java.lang.String r3 = r3.g()
            us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$3 r4 = new us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$3
            r4.<init>(r0, r1, r2, r9)
            r10.H(r3, r4)
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.fragment.EditFragment.M2(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void N2() {
        if (!j1().j().a().b() && !this.o) {
            h1();
        } else {
            D2();
        }
    }

    private final void X0(String str) {
        Bitmap w;
        if (str == null) {
            return;
        }
        int i2 = R.id.ivOriginalPicture;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(i2);
        if (kotlin.jvm.internal.s.c(appCompatImageView == null ? null : appCompatImageView.getTag(), str) || (w = us.pinguo.util.e.w(str, us.pinguo.foundation.utils.n0.h(), 1, true)) == null) {
            return;
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(i2);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setTag(str);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(i2);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setImageBitmap(w);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageMask);
        if (imageView == null) {
            return;
        }
        imageView.setImageBitmap(w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0() {
        if (this.f10512h == null) {
            PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout);
            kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
            FrameLayout flIrregularPanelContainer = (FrameLayout) _$_findCachedViewById(R.id.flIrregularPanelContainer);
            kotlin.jvm.internal.s.g(flIrregularPanelContainer, "flIrregularPanelContainer");
            FrameLayout flContainerSubItems = (FrameLayout) _$_findCachedViewById(R.id.flContainerSubItems);
            kotlin.jvm.internal.s.g(flContainerSubItems, "flContainerSubItems");
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.showOriginPicBt);
            NumberTipView numberTipView = (NumberTipView) _$_findCachedViewById(R.id.numberTipView);
            kotlin.jvm.internal.s.g(numberTipView, "numberTipView");
            us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
            if (c0Var != null) {
                AdjustController adjustController = new AdjustController(bottomTabLayout, flIrregularPanelContainer, flContainerSubItems, appCompatImageView, numberTipView, c0Var, j1().f());
                this.f10512h = adjustController;
                if (adjustController == null) {
                    return;
                }
                adjustController.M(new EditFragment$checkAdjustController$1(this));
                return;
            }
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        if (!this.B && this.u == null) {
            AdvDialogManager advDialogManager = new AdvDialogManager();
            this.u = advDialogManager;
            if (advDialogManager == null) {
                return;
            }
            AdvDialogManager.i(advDialogManager, "a1521af5338242258abb1a71876325cf", "", getActivity(), new EditFragment$checkEditAdvDialog$1(this), null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        if (this.f10513i == null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
            EditViewModel j1 = j1();
            us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
            if (c0Var != null) {
                ConstraintLayout frameLayout = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
                kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
                EditController editController = new EditController(viewLifecycleOwner, j1, c0Var, frameLayout, new EditFragment$checkEditController$1(this), new EditFragment$checkEditController$2(this), new EditFragment$checkEditController$3(this));
                this.f10513i = editController;
                if (editController == null) {
                    return;
                }
                editController.s(new EditFragment$checkEditController$4(this));
                return;
            }
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(final kotlin.jvm.b.a<kotlin.u> aVar) {
        if (kotlin.jvm.internal.s.c(this.s.getValue(), Boolean.TRUE)) {
            aVar.invoke();
        } else if (this.s.hasObservers()) {
        } else {
            if (!this.F) {
                Group loadingGroup = (Group) _$_findCachedViewById(R.id.loadingGroup);
                kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
                loadingGroup.setVisibility(0);
                VdsAgent.onSetViewVisibility(loadingGroup, 0);
                int i2 = R.id.loadingView;
                ((FragmentLoadingView) _$_findCachedViewById(i2)).g();
                ((FragmentLoadingView) _$_findCachedViewById(i2)).d(true);
            }
            this.s.observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.edit2020.fragment.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.c1(EditFragment.this, aVar, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(EditFragment this$0, kotlin.jvm.b.a afterPrepareAction, Boolean prepared) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(afterPrepareAction, "$afterPrepareAction");
        kotlin.jvm.internal.s.g(prepared, "prepared");
        if (prepared.booleanValue()) {
            if (!this$0.F) {
                this$0.n1();
            }
            this$0.s.removeObservers(this$0.getViewLifecycleOwner());
            afterPrepareAction.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        i1();
        us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
        if (c0Var != null) {
            c0Var.k();
            TextView textView = (TextView) _$_findCachedViewById(R.id.txtSave);
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            BoldTipView imgBoldTip = (BoldTipView) _$_findCachedViewById(R.id.imgBoldTip);
            kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
            imgBoldTip.setVisibility(4);
            VdsAgent.onSetViewVisibility(imgBoldTip, 4);
            x2();
            j1().clear();
            u2();
            return;
        }
        kotlin.jvm.internal.s.z("operationController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        A2(this, false, 1, null);
        j1().i().y0(j1().j().a().e().subList(0, j1().j().a().h() + 1));
        j1().Y("save");
        j1().e(new EditFragment$doSaveAction$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(Float f2, Float f3) {
        int dimensionPixelOffset;
        if (j1().A()) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height);
        }
        ((Guideline) _$_findCachedViewById(R.id.flexBottomTabGuideline)).setGuidelineEnd(dimensionPixelOffset);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clHeader);
        constraintLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout, 4);
        final ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageMask);
        ViewPropertyAnimator withEndAction = imageView == null ? null : imageView.animate().translationY(-getResources().getDimension(R.dimen.top_bar_height)).setDuration(250L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment.g1(imageView, this);
            }
        });
        if (f2 != null) {
            withEndAction = withEndAction == null ? null : withEndAction.scaleX(f2.floatValue());
        }
        if (f3 != null) {
            withEndAction = withEndAction == null ? null : withEndAction.scaleY(f3.floatValue());
        }
        if (withEndAction != null) {
            withEndAction.start();
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.showOriginPicBt);
        if (appCompatImageView != null) {
            appCompatImageView.animate().translationY(-appCompatImageView.getResources().getDimension(R.dimen.diff_icon_move_distance)).setDuration(250L).start();
        }
        b3 b3Var = this.f10514j;
        if (b3Var != null) {
            b3Var.s(new EditFragment$enterEditMode$4(this));
        } else {
            kotlin.jvm.internal.s.z("faceCurveController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(ImageView it, EditFragment this$0) {
        kotlin.jvm.internal.s.h(it, "$it");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        it.setVisibility(4);
        FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(R.id.unityContainer);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
    }

    private final void g2(final String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (kotlin.jvm.internal.s.c(appCompatImageView == null ? null : appCompatImageView.getTag(), str)) {
            return;
        }
        us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.edit2020.fragment.x
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment.h2(str, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        j1().Y("exited");
        if (!this.o && this.n == 3) {
            com.pinguo.camera360.j.a.c(activity, 0);
        }
        z2 z2Var = this.y;
        if ((z2Var == null ? null : z2Var.F()) == EditTabType.FILTER) {
            FilterRepository.a.L();
        }
        activity.finish();
        us.pinguo.foundation.statistics.h.a.h("back");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(final String str, final EditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        final Bitmap w = us.pinguo.util.e.w(str, us.pinguo.foundation.utils.n0.h(), 1, true);
        if (w == null) {
            return;
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.fragment.q0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment.i2(EditFragment.this, str, w);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        int dimensionPixelOffset;
        n1();
        Guideline guideline = (Guideline) _$_findCachedViewById(R.id.flexBottomTabGuideline);
        if (j1().A()) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation);
        }
        guideline.setGuidelineEnd(dimensionPixelOffset);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clHeader);
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        int i2 = R.id.imageMask;
        ImageView imageView = (ImageView) _$_findCachedViewById(i2);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.unityContainer);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(i2);
        if (imageView2 != null) {
            imageView2.animate().translationY(0.0f).setDuration(250L).start();
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.showOriginPicBt);
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.animate().translationY(0.0f).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(EditFragment this$0, String str, Bitmap bitmap) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(bitmap, "$bitmap");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        int i2 = R.id.ivOriginalPicture;
        AppCompatImageView appCompatImageView = (AppCompatImageView) this$0._$_findCachedViewById(i2);
        if (appCompatImageView != null) {
            appCompatImageView.setTag(str);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) this$0._$_findCachedViewById(i2);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageBitmap(bitmap);
        }
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.imageMask);
        if (imageView == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditViewModel j1() {
        return (EditViewModel) this.f10515k.getValue();
    }

    private final void j2() {
        j1().l().b1(new us.pinguo.edit2020.model.a() { // from class: us.pinguo.edit2020.fragment.EditFragment$observeFilterRenderStatus$1
            @Override // us.pinguo.edit2020.model.a
            public void a() {
                kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(EditFragment.this), kotlinx.coroutines.z0.c(), null, new EditFragment$observeFilterRenderStatus$1$renderFinish$1(EditFragment.this, null), 2, null);
            }

            @Override // us.pinguo.edit2020.model.a
            public void b(boolean z) {
                kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(EditFragment.this), kotlinx.coroutines.z0.c(), null, new EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1(z, EditFragment.this, null), 2, null);
            }

            @Override // us.pinguo.edit2020.model.a
            public void c() {
                kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(EditFragment.this), kotlinx.coroutines.z0.c(), null, new EditFragment$observeFilterRenderStatus$1$renderStart$1(EditFragment.this, null), 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(Uri uri) {
        us.pinguo.edit2020.model.editgoto.b a2;
        if (uri == null || (a2 = new us.pinguo.edit2020.model.editgoto.c().a(uri)) == null) {
            return;
        }
        this.B = true;
        b1(new EditFragment$handleGoto$1$1$1(this, a2));
    }

    private final void l1(Intent intent) {
        if (intent == null) {
            return;
        }
        j1().I(intent.getStringExtra("photo_path"));
        j1().l().F0(null);
        this.o = intent.getBooleanExtra("is_from_preview", false);
        this.p = intent.getBooleanExtra("bundle_key_used_vip_in_camera", false);
        c0(this.o);
        k1((Uri) intent.getParcelableExtra("bundle_key_goto"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(us.pinguo.edit2020.bean.u0 u0Var) {
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("scale:", Float.valueOf(u0Var.c())), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        z2 z2Var = this.y;
        if (z2Var != null) {
            if (z2Var == null) {
                return;
            }
            j1().W(z2Var.v());
            if (!z2Var.f() && !z2Var.R()) {
                us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
                if (c0Var != null) {
                    c0Var.k();
                    TextView textView = (TextView) _$_findCachedViewById(R.id.txtSave);
                    textView.setVisibility(0);
                    VdsAgent.onSetViewVisibility(textView, 0);
                    A2(this, false, 1, null);
                    j1().E(z2Var.F(), new EditFragment$handleWorkFlowComplete$2$1(z2Var, this));
                    return;
                }
                kotlin.jvm.internal.s.z("operationController");
                throw null;
            }
            z2Var.d();
            return;
        }
        EditViewModel j1 = j1();
        d3 d3Var = this.f10511g;
        if (d3Var != null) {
            j1.W(d3Var.v());
            d3 d3Var2 = this.f10511g;
            if (d3Var2 == null) {
                kotlin.jvm.internal.s.z("bottomTabBeautyController");
                throw null;
            } else if (d3Var2.f()) {
                d3 d3Var3 = this.f10511g;
                if (d3Var3 != null) {
                    d3Var3.d();
                    return;
                } else {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
            } else {
                us.pinguo.edit2020.view.c0 c0Var2 = this.f10516l;
                if (c0Var2 != null) {
                    c0Var2.k();
                    TextView textView2 = (TextView) _$_findCachedViewById(R.id.txtSave);
                    textView2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(textView2, 0);
                    j1().E(EditTabType.MAKEUP, new EditFragment$handleWorkFlowComplete$1(this));
                    return;
                }
                kotlin.jvm.internal.s.z("operationController");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("bottomTabBeautyController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(EditFragment this$0, ActivityResult it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        EditViewModel j1 = this$0.j1();
        kotlin.jvm.internal.s.g(it, "it");
        j1.F(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        if (j1().l().H().get() > 0) {
            return;
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.vBottomTabInterceptor);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, 4);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout);
        if (pGEditBottomTabLayout != null) {
            pGEditBottomTabLayout.setTabLayoutAndCompleteButtonEnabled(true);
        }
        int i2 = R.id.loadingView;
        if (us.pinguo.edit2020.utils.d.e((FragmentLoadingView) _$_findCachedViewById(i2))) {
            return;
        }
        int i3 = R.id.loadingGroup;
        if (us.pinguo.edit2020.utils.d.e((Group) _$_findCachedViewById(i3))) {
            return;
        }
        ((FragmentLoadingView) _$_findCachedViewById(i2)).b();
        Group loadingGroup = (Group) _$_findCachedViewById(i3);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        loadingGroup.setVisibility(8);
        VdsAgent.onSetViewVisibility(loadingGroup, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2(String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera360.shop.StoreActivity2");
        intent.putExtra("pre_selected", str);
        intent.putExtra("from_edit", true);
        startActivityForResult(intent, 1573);
    }

    private final void o1() {
        if (us.pinguo.repository2020.abtest.a.a.c()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
            ConstraintLayout frameLayout = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
            kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
            us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
            if (c0Var != null) {
                b3 b3Var = this.f10514j;
                if (b3Var != null) {
                    this.f10511g = new EditBottomTabBeautyController(viewLifecycleOwner, frameLayout, c0Var, b3Var, j1().h(), new EditFragment$initBeautyTab$1(this), new EditFragment$initBeautyTab$2(this));
                } else {
                    kotlin.jvm.internal.s.z("faceCurveController");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.s.z("operationController");
                throw null;
            }
        } else {
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
            ConstraintLayout frameLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
            kotlin.jvm.internal.s.g(frameLayout2, "frameLayout");
            us.pinguo.edit2020.view.c0 c0Var2 = this.f10516l;
            if (c0Var2 != null) {
                b3 b3Var2 = this.f10514j;
                if (b3Var2 != null) {
                    this.f10511g = new EditBottomTabBeautyControllerNew(viewLifecycleOwner2, frameLayout2, c0Var2, b3Var2, j1().h(), new EditFragment$initBeautyTab$3(this), new EditFragment$initBeautyTab$4(this));
                } else {
                    kotlin.jvm.internal.s.z("faceCurveController");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.s.z("operationController");
                throw null;
            }
        }
        d3 d3Var = this.f10511g;
        if (d3Var == null) {
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
        this.y = d3Var;
        if (d3Var != null) {
            d3Var.N(new EditFragment$initBeautyTab$5(this));
            us.pinguo.repository2020.u<FunctionType> t = j1().h().t();
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner3, "viewLifecycleOwner");
            t.observe(viewLifecycleOwner3, new Observer() { // from class: us.pinguo.edit2020.fragment.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.p1(EditFragment.this, (FunctionType) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("bottomTabBeautyController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(EditFragment this$0, String str) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.picker.image.picker.b a2 = us.pinguo.picker.image.picker.a.c.a(this$0).a();
        String string = us.pinguo.foundation.e.b().getString(R.string.reselect_image);
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(R.string.reselect_image)");
        a2.d(string);
        a2.b(false);
        a2.c(false);
        a2.a(120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(EditFragment this$0, FunctionType functionType) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (functionType == FunctionType.AutoBeauty) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this$0), kotlinx.coroutines.z0.c(), null, new EditFragment$initBeautyTab$6$1(this$0, null), 2, null);
        }
        this$0.j1().O(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void q1() {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        j1().N(((float) us.pinguo.util.h.g(activity)) / ((float) us.pinguo.util.h.i(activity)) > 1.7777778f);
        Guideline guideline = (Guideline) _$_findCachedViewById(R.id.fixedBottomTabGuideline);
        if (j1().A()) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.whole_bottom_height);
        }
        guideline.setGuidelineEnd(dimensionPixelOffset);
        Guideline guideline2 = (Guideline) _$_findCachedViewById(R.id.flexBottomTabGuideline);
        if (j1().A()) {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation) + getResources().getDimensionPixelSize(R.dimen.pg_sdk_edit_bottom_margin_height);
        } else {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.bottom_height_without_operation);
        }
        guideline2.setGuidelineEnd(dimensionPixelOffset2);
        if (j1().A()) {
            Resources resources = getResources();
            int i2 = R.dimen.pg_sdk_edit_bottom_margin_height;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, resources.getDimensionPixelSize(i2));
            layoutParams.bottomToBottom = 0;
            int i3 = R.id.frameLayout;
            ((ConstraintLayout) _$_findCachedViewById(i3)).findViewById(R.id.vBottom).setLayoutParams(layoutParams);
            ((ManualSkinFullScreenGuide) ((ConstraintLayout) _$_findCachedViewById(i3)).findViewById(R.id.manualSkinFullGuide)).setBottomPadding(getResources().getDimensionPixelSize(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void r1() {
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).setOnBottomTabListener(this);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).setOnBottomClickListener(this);
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).setPlan(us.pinguo.repository2020.abtest.a.a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(EditFragment this$0, us.pinguo.edit2020.bean.k kVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView imgBoldTip = (BoldTipView) this$0._$_findCachedViewById(R.id.imgBoldTip);
        kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
        imgBoldTip.setVisibility(4);
        VdsAgent.onSetViewVisibility(imgBoldTip, 4);
        if ((kVar instanceof us.pinguo.edit2020.bean.b) && this$0.G1(kVar)) {
            int i2 = R.id.lottieViewForAreaProtect;
            ((LottieAnimationView) this$0._$_findCachedViewById(i2)).setAnimation("lottie/tumo.json");
            ConstraintLayout clLottieForAreaProtect = (ConstraintLayout) this$0._$_findCachedViewById(R.id.clLottieForAreaProtect);
            kotlin.jvm.internal.s.g(clLottieForAreaProtect, "clLottieForAreaProtect");
            clLottieForAreaProtect.setVisibility(0);
            VdsAgent.onSetViewVisibility(clLottieForAreaProtect, 0);
            ((LottieAnimationView) this$0._$_findCachedViewById(i2)).p();
            ((LottieAnimationView) this$0._$_findCachedViewById(i2)).d(new b());
            return;
        }
        int i3 = R.id.clLottieForAreaProtect;
        ConstraintLayout clLottieForAreaProtect2 = (ConstraintLayout) this$0._$_findCachedViewById(i3);
        kotlin.jvm.internal.s.g(clLottieForAreaProtect2, "clLottieForAreaProtect");
        if (clLottieForAreaProtect2.getVisibility() == 0) {
            ((LottieAnimationView) this$0._$_findCachedViewById(R.id.lottieViewForAreaProtect)).f();
            ConstraintLayout clLottieForAreaProtect3 = (ConstraintLayout) this$0._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(clLottieForAreaProtect3, "clLottieForAreaProtect");
            clLottieForAreaProtect3.setVisibility(8);
            VdsAgent.onSetViewVisibility(clLottieForAreaProtect3, 8);
        }
    }

    private final void s1() {
        ((FacePointView) _$_findCachedViewById(R.id.facePointView)).setPointArr(j1().n());
        FaceCurveView faceCurveView = (FaceCurveView) _$_findCachedViewById(R.id.faceCurveView);
        kotlin.jvm.internal.s.g(faceCurveView, "faceCurveView");
        this.f10514j = new b3(faceCurveView);
        us.pinguo.repository2020.u<us.pinguo.facedetector.c> o = j1().o();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        o.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFragment.t1(EditFragment.this, (us.pinguo.facedetector.c) obj);
            }
        });
        us.pinguo.repository2020.u<us.pinguo.edit2020.bean.u0> w = j1().w();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
        w.observe(viewLifecycleOwner2, new Observer() { // from class: us.pinguo.edit2020.fragment.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditFragment.u1(EditFragment.this, (us.pinguo.edit2020.bean.u0) obj);
            }
        });
        b3 b3Var = this.f10514j;
        if (b3Var != null) {
            b3Var.t(new EditFragment$initFaceCurve$3(this));
        } else {
            kotlin.jvm.internal.s.z("faceCurveController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(EditFragment this$0, Runnable fadeOut, us.pinguo.edit2020.viewmodel.module.c cVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(fadeOut, "$fadeOut");
        int i2 = R.id.clLottieForAreaProtect;
        ConstraintLayout clLottieForAreaProtect = (ConstraintLayout) this$0._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(clLottieForAreaProtect, "clLottieForAreaProtect");
        if (clLottieForAreaProtect.getVisibility() == 0) {
            ((LottieAnimationView) this$0._$_findCachedViewById(R.id.lottieViewForAreaProtect)).f();
            ConstraintLayout clLottieForAreaProtect2 = (ConstraintLayout) this$0._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(clLottieForAreaProtect2, "clLottieForAreaProtect");
            clLottieForAreaProtect2.setVisibility(8);
            VdsAgent.onSetViewVisibility(clLottieForAreaProtect2, 8);
        }
        if (cVar == null) {
            this$0.m.removeCallbacks(fadeOut);
            int i3 = R.id.imgBoldTip;
            ((BoldTipView) this$0._$_findCachedViewById(i3)).animate().cancel();
            ((BoldTipView) this$0._$_findCachedViewById(i3)).setAlpha(1.0f);
            BoldTipView imgBoldTip = (BoldTipView) this$0._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
            imgBoldTip.setVisibility(4);
            VdsAgent.onSetViewVisibility(imgBoldTip, 4);
            return;
        }
        this$0.m.removeCallbacks(fadeOut);
        int i4 = R.id.imgBoldTip;
        ((BoldTipView) this$0._$_findCachedViewById(i4)).animate().cancel();
        us.pinguo.edit2020.bean.k value = this$0.j1().h().n().d().getValue();
        if (value != null) {
            ((BoldTipView) this$0._$_findCachedViewById(i4)).setStrokeWidth(value.p());
        }
        ((BoldTipView) this$0._$_findCachedViewById(i4)).setAlpha(1.0f);
        BoldTipView imgBoldTip2 = (BoldTipView) this$0._$_findCachedViewById(i4);
        kotlin.jvm.internal.s.g(imgBoldTip2, "imgBoldTip");
        imgBoldTip2.setVisibility(0);
        VdsAgent.onSetViewVisibility(imgBoldTip2, 0);
        ((BoldTipView) this$0._$_findCachedViewById(i4)).setSize(cVar.b() * cVar.c());
        if (cVar.d()) {
            BoldTipView imgBoldTip3 = (BoldTipView) this$0._$_findCachedViewById(i4);
            kotlin.jvm.internal.s.g(imgBoldTip3, "imgBoldTip");
            if (imgBoldTip3.getVisibility() == 0) {
                this$0.m.postDelayed(fadeOut, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(EditFragment this$0, us.pinguo.facedetector.c cVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        b3 b3Var = this$0.f10514j;
        if (b3Var != null) {
            b3Var.g(cVar);
            d3 d3Var = this$0.f10511g;
            if (d3Var == null) {
                kotlin.jvm.internal.s.z("bottomTabBeautyController");
                throw null;
            }
            d3Var.K(cVar);
            if (cVar == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.j(cVar.c() > 0 ? "yes" : "no", String.valueOf(cVar.c()));
            return;
        }
        kotlin.jvm.internal.s.z("faceCurveController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(EditFragment this$0, us.pinguo.edit2020.bean.u0 it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        b3 b3Var = this$0.f10514j;
        if (b3Var != null) {
            kotlin.jvm.internal.s.g(it, "it");
            b3Var.n(it);
            d3 d3Var = this$0.f10511g;
            if (d3Var != null) {
                d3Var.e(it);
                EditController editController = this$0.f10513i;
                if (editController != null) {
                    editController.e(it);
                }
                EditFilterController editFilterController = this$0.x;
                if (editFilterController == null) {
                    return;
                }
                editFilterController.e(it);
                return;
            }
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
        kotlin.jvm.internal.s.z("faceCurveController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2() {
        boolean b2 = j1().j().a().b();
        boolean a2 = j1().j().a().a();
        us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
        if (c0Var != null) {
            c0Var.t(b2, a2);
        } else {
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
    }

    private final void v1() {
        j2();
        j1().i().f0("edit_page");
        ConstraintLayout frameLayout = (ConstraintLayout) _$_findCachedViewById(R.id.frameLayout);
        kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
        EditFilterModule i2 = j1().i();
        us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
        if (c0Var != null) {
            final EditFilterController editFilterController = new EditFilterController(frameLayout, i2, c0Var);
            this.x = editFilterController;
            editFilterController.o1(new EditFragment$initFilter$1(this));
            editFilterController.c2(new EditFragment$initFilter$2(this));
            editFilterController.h(false);
            editFilterController.l0(false);
            editFilterController.y1();
            FilterController.d1(editFilterController, false, 1, null);
            us.pinguo.repository2020.u<FilterEntry> y = j1().i().y();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
            y.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.fragment.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.w1(EditFragment.this, editFilterController, (FilterEntry) obj);
                }
            });
            us.pinguo.repository2020.u<Integer> s = j1().i().s();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
            s.observe(viewLifecycleOwner2, new Observer() { // from class: us.pinguo.edit2020.fragment.b0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.x1(EditFragment.this, (Integer) obj);
                }
            });
            us.pinguo.repository2020.u<Integer> v = j1().i().v();
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner3, "viewLifecycleOwner");
            v.observe(viewLifecycleOwner3, new Observer() { // from class: us.pinguo.edit2020.fragment.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.y1(EditFragment.this, (Integer) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("operationController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ac A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v2(us.pinguo.repository2020.entity.FilterEntry r22, kotlin.coroutines.Continuation<? super kotlin.u> r23) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.fragment.EditFragment.v2(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(EditFragment this$0, EditFilterController controller, FilterEntry filterEntry) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(controller, "$controller");
        if (!this$0.w) {
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new EditFragment$initFilter$3$1(this$0, filterEntry, controller, null), 3, null);
        } else {
            this$0.w = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(boolean z) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        ViewPropertyAnimator duration;
        if (z) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageMask);
            if (imageView == null || (animate = imageView.animate()) == null || (scaleX = animate.scaleX(1.0f)) == null || (scaleY = scaleX.scaleY(1.0f)) == null || (duration = scaleY.setDuration(250L)) == null) {
                return;
            }
            duration.start();
            return;
        }
        int i2 = R.id.imageMask;
        ImageView imageView2 = (ImageView) _$_findCachedViewById(i2);
        if (imageView2 != null) {
            imageView2.setScaleX(1.0f);
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(i2);
        if (imageView3 == null) {
            return;
        }
        imageView3.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(EditFragment this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.j1().l().z0(num.intValue() / 100.0f);
        this$0.j1().i().d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2() {
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).j();
        b3 b3Var = this.f10514j;
        if (b3Var != null) {
            b3Var.u(-1);
            j1().h().q().setValue(0);
            us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
            if (c0Var != null) {
                c0Var.H(true);
                b3 b3Var2 = this.f10514j;
                if (b3Var2 != null) {
                    b3Var2.l();
                    us.pinguo.edit2020.view.c0 c0Var2 = this.f10516l;
                    if (c0Var2 != null) {
                        c0Var2.D(this);
                        j1().O(false);
                        z2 z2Var = this.y;
                        if ((z2Var == null ? null : z2Var.F()) != EditTabType.FILTER) {
                            z2 z2Var2 = this.y;
                            if ((z2Var2 == null ? null : z2Var2.F()) != EditTabType.ADJUST && this.y != null) {
                                return;
                            }
                        }
                        z2 z2Var3 = this.z;
                        if (z2Var3 == null) {
                            return;
                        }
                        if (z2Var3.F() == EditTabType.BEAUTY) {
                            PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) _$_findCachedViewById(i2);
                            kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
                            PGEditBottomTabLayout.A(bottomTabLayout, R.id.pg_edit_first_menu_beauty, false, 2, null);
                        }
                        if (z2Var3.F() == EditTabType.EDIT) {
                            PGEditBottomTabLayout bottomTabLayout2 = (PGEditBottomTabLayout) _$_findCachedViewById(i2);
                            kotlin.jvm.internal.s.g(bottomTabLayout2, "bottomTabLayout");
                            PGEditBottomTabLayout.A(bottomTabLayout2, R.id.pg_edit_first_menu_edit, false, 2, null);
                        }
                        this.y = z2Var3;
                        return;
                    }
                    kotlin.jvm.internal.s.z("operationController");
                    throw null;
                }
                kotlin.jvm.internal.s.z("faceCurveController");
                throw null;
            }
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
        kotlin.jvm.internal.s.z("faceCurveController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(EditFragment this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.j1().i().x0(num.intValue() / 100.0f);
        this$0.j1().i().u0();
    }

    private final void y2() {
        if (this.D == null) {
            AdRewardView rewardView = (AdRewardView) _$_findCachedViewById(R.id.rewardView);
            kotlin.jvm.internal.s.g(rewardView, "rewardView");
            RewardVipAdController rewardVipAdController = new RewardVipAdController(rewardView, getActivity(), true);
            this.D = rewardVipAdController;
            if (rewardVipAdController != null) {
                rewardVipAdController.g(new EditFragment$showAdFreeDialog$1(this));
            }
        }
        RewardVipAdController rewardVipAdController2 = this.D;
        if (rewardVipAdController2 == null) {
            return;
        }
        rewardVipAdController2.h();
    }

    private final void z1() {
        ((GestureView) _$_findCachedViewById(R.id.gestureView)).setOnEvent(new EditFragment$initGesture$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(boolean z) {
        Group loadingGroup = (Group) _$_findCachedViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        loadingGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(loadingGroup, 0);
        int i2 = R.id.loadingView;
        ((FragmentLoadingView) _$_findCachedViewById(i2)).g();
        ((FragmentLoadingView) _$_findCachedViewById(i2)).f(false);
        ((FragmentLoadingView) _$_findCachedViewById(i2)).e(false);
        if (z) {
            View vBottomTabInterceptor = _$_findCachedViewById(R.id.vBottomTabInterceptor);
            kotlin.jvm.internal.s.g(vBottomTabInterceptor, "vBottomTabInterceptor");
            vBottomTabInterceptor.setVisibility(0);
            VdsAgent.onSetViewVisibility(vBottomTabInterceptor, 0);
            return;
        }
        ((PGEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(false);
        FrameLayout bgEventInterceptor = (FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(bgEventInterceptor, "bgEventInterceptor");
        bgEventInterceptor.setVisibility(0);
        VdsAgent.onSetViewVisibility(bgEventInterceptor, 0);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.b
    public void I(PGEditTabLayout.f fVar) {
        this.z = this.y;
        this.y = null;
        d3 d3Var = this.f10511g;
        if (d3Var == null) {
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
        this.A = d3Var;
        if (d3Var != null) {
            if (d3Var instanceof EditBottomTabBeautyControllerNew) {
                if (d3Var != null) {
                    ((EditBottomTabBeautyControllerNew) d3Var).j0(null);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
            }
            return;
        }
        kotlin.jvm.internal.s.z("bottomTabBeautyController");
        throw null;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        EditViewModel j1 = j1();
        ImageView imageMask = (ImageView) _$_findCachedViewById(R.id.imageMask);
        kotlin.jvm.internal.s.g(imageMask, "imageMask");
        j1.D(imageMask);
        u2();
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.b
    public void Y(PGEditTabLayout.f fVar) {
        b1(new EditFragment$onFilterTabSelected$1(this, fVar));
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.b
    public void Z(PGEditTabLayout.f fVar) {
        b1(new EditFragment$onAdjustTabSelected$1(this));
    }

    @Override // us.pinguo.u3dengine.PGUnityEditFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f10510f.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f10510f;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void a() {
        if (this.v) {
            return;
        }
        this.B = false;
        BoldTipView imgBoldTip = (BoldTipView) _$_findCachedViewById(R.id.imgBoldTip);
        kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
        imgBoldTip.setVisibility(4);
        VdsAgent.onSetViewVisibility(imgBoldTip, 4);
        z2 z2Var = this.y;
        if ((z2Var == null ? null : z2Var.F()) != EditTabType.BEAUTY || j1().h().t().getValue() != FunctionType.BodyShaping) {
            z2 z2Var2 = this.y;
            EditTabType F = z2Var2 == null ? null : z2Var2.F();
            EditTabType editTabType = EditTabType.EDIT;
            if (F != editTabType || j1().k().i().getValue() != FunctionType.MOSAIC) {
                z2 z2Var3 = this.y;
                if ((z2Var3 == null ? null : z2Var3.F()) != editTabType || j1().k().i().getValue() != FunctionType.GRAFFITI) {
                    z2 z2Var4 = this.y;
                    if ((z2Var4 != null ? z2Var4.F() : null) != editTabType || j1().k().i().getValue() != FunctionType.ELIMINATION) {
                        m1();
                        return;
                    }
                }
            }
        }
        UnityEditCaller.Brush.tryGetRecordedVIPStatus();
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public ViewGroup b0() {
        return (FrameLayout) _$_findCachedViewById(R.id.unityContainer);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void c() {
        SkyChangeGuideView skyChangeGuideView = (SkyChangeGuideView) ((ConstraintLayout) _$_findCachedViewById(R.id.frameLayout)).findViewById(R.id.gvSkyChange);
        kotlin.jvm.internal.s.g(skyChangeGuideView, "frameLayout.gvSkyChange");
        if (skyChangeGuideView.getVisibility() == 0) {
            return;
        }
        this.B = false;
        z2 z2Var = this.y;
        if ((z2Var == null || z2Var.f()) ? false : true) {
            z2 z2Var2 = this.y;
            EditTabType F = z2Var2 == null ? null : z2Var2.F();
            if (EditTabType.BEAUTY == F || EditTabType.EDIT == F) {
                z2 z2Var3 = this.y;
                if (z2Var3 != null && z2Var3.S()) {
                    B2(new EditFragment$onEditWorkFlowCancelClick$1(this));
                    return;
                }
            }
            i1();
            us.pinguo.edit2020.view.c0 c0Var = this.f10516l;
            if (c0Var != null) {
                c0Var.k();
                TextView textView = (TextView) _$_findCachedViewById(R.id.txtSave);
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
                BoldTipView imgBoldTip = (BoldTipView) _$_findCachedViewById(R.id.imgBoldTip);
                kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
                imgBoldTip.setVisibility(4);
                VdsAgent.onSetViewVisibility(imgBoldTip, 4);
                z2 z2Var4 = this.y;
                if (z2Var4 != null) {
                    z2Var4.g();
                }
                x2();
                j1().clear();
                u2();
                Z0();
            } else {
                kotlin.jvm.internal.s.z("operationController");
                throw null;
            }
        } else {
            z2 z2Var5 = this.y;
            if (z2Var5 != null) {
                z2Var5.g();
            }
        }
        if (this.y == null) {
            d3 d3Var = this.f10511g;
            if (d3Var == null) {
                kotlin.jvm.internal.s.z("bottomTabBeautyController");
                throw null;
            } else if (d3Var.f()) {
                d3 d3Var2 = this.f10511g;
                if (d3Var2 != null) {
                    d3Var2.g();
                } else {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
            } else if (j1().h().Y()) {
                B2(new EditFragment$onEditWorkFlowCancelClick$2(this));
            } else {
                i1();
                d3 d3Var3 = this.f10511g;
                if (d3Var3 != null) {
                    d3Var3.g();
                    d1();
                    return;
                }
                kotlin.jvm.internal.s.z("bottomTabBeautyController");
                throw null;
            }
        }
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        p0.a.a(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        AppCompatImageView appCompatImageView;
        if (j1().B()) {
            if (j1().j().a().b() && (appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivOriginalPicture)) != null) {
                appCompatImageView.setVisibility(z ? 0 : 4);
            }
        } else {
            j1().X(z);
        }
        d3 d3Var = this.f10511g;
        if (d3Var != null) {
            d3Var.B(z);
        } else {
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
    }

    public final void k2() {
        FragmentActivity activity = getActivity();
        if (activity != null && us.pinguo.foundation.j.e().i("hairCut", -1) == -1) {
            View decorView = activity.getWindow().getDecorView();
            kotlin.jvm.internal.s.g(decorView, "act.window.decorView");
            int b2 = us.pinguo.util.h.b(decorView);
            us.pinguo.foundation.j.e().q("hairCut", b2);
            int i2 = R.id.viewHairCut;
            View viewHairCut = _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(viewHairCut, "viewHairCut");
            viewHairCut.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewHairCut, 0);
            View viewHairCut2 = _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(viewHairCut2, "viewHairCut");
            ViewGroup.LayoutParams layoutParams = viewHairCut2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = b2;
            viewHairCut2.setLayoutParams(layoutParams2);
        }
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        EditViewModel j1 = j1();
        ImageView imageMask = (ImageView) _$_findCachedViewById(R.id.imageMask);
        kotlin.jvm.internal.s.g(imageMask, "imageMask");
        j1.Z(imageMask);
        u2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        PickItem pickItem;
        EditFilterController editFilterController;
        this.n = i3;
        if (i2 == 1573 && (editFilterController = this.x) != null) {
            editFilterController.b1(i3, intent);
        }
        if (i2 == 120 && i3 == -1) {
            String str = null;
            ArrayList parcelableArrayListExtra = intent == null ? null : intent.getParcelableArrayListExtra(ImagePickerConfigModel.RESULT_DATA);
            if (parcelableArrayListExtra != null && (pickItem = (PickItem) parcelableArrayListExtra.get(0)) != null) {
                str = pickItem.path;
            }
            if (str == null) {
                return;
            }
            j1().H(str);
        }
    }

    public final boolean onBackPressed() {
        z2 z2Var = this.y;
        if (z2Var != null && z2Var.onBackPressed()) {
            return true;
        }
        Group loadingGroup = (Group) _$_findCachedViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
        if (loadingGroup.getVisibility() == 0) {
            return true;
        }
        ManualSkinFullScreenGuide manualSkinFullGuide = (ManualSkinFullScreenGuide) _$_findCachedViewById(R.id.manualSkinFullGuide);
        kotlin.jvm.internal.s.g(manualSkinFullGuide, "manualSkinFullGuide");
        if (manualSkinFullGuide.getVisibility() == 0) {
            return true;
        }
        if (((PGEditBottomTabLayout) _$_findCachedViewById(R.id.bottomTabLayout)).q()) {
            c();
        } else {
            N2();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getLifecycle().addObserver(j1());
        j1().M(new EditFragment$onCreate$1(this));
        j1().l().L().observe(this, u.a);
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.K("edit_panel_filter", null, "show");
        iVar.K("edit_panel_adjustment", null, "show");
        j1().T(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: us.pinguo.edit2020.fragment.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                EditFragment.m2(EditFragment.this, (ActivityResult) obj);
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_edit, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.util.d.f(null);
        us.pinguo.util.d.e(-1);
    }

    @Override // us.pinguo.u3dengine.PGUnityEditFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        us.pinguo.common.log.a.c("onDestroyView", new Object[0]);
        j1().d();
        super.onDestroyView();
        this.m.removeCallbacksAndMessages(null);
        us.pinguo.vip.proxy.c.a.a();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.u3dengine.PGUnityEditFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.C.c(activity);
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.C.b(activity, new EditFragment$onResume$1$1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        I2(false);
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        F1();
        E1();
        super.onViewCreated(view, bundle);
        us.pinguo.common.log.a.c("onViewCreated", new Object[0]);
        ((FrameLayout) _$_findCachedViewById(R.id.bgEventInterceptor)).setOnClickListener(k.a);
        _$_findCachedViewById(R.id.vBottomTabInterceptor).setOnClickListener(j.a);
        l1(activity.getIntent());
        g2(j1().g());
        j1().initRender();
        EditRender l2 = j1().l();
        l2.P0(new EditFragment$onViewCreated$3$1(this));
        l2.O0(new EditFragment$onViewCreated$3$2(this));
        l2.c1(new EditFragment$onViewCreated$3$3(this));
        l2.E0(new EditFragment$onViewCreated$3$4(this));
        l2.X0(new EditFragment$onViewCreated$3$5(this));
        D1();
        FrameLayout operationLayout = (FrameLayout) _$_findCachedViewById(R.id.operationLayout);
        kotlin.jvm.internal.s.g(operationLayout, "operationLayout");
        AppCompatImageView iconUndo = (AppCompatImageView) _$_findCachedViewById(R.id.iconUndo);
        kotlin.jvm.internal.s.g(iconUndo, "iconUndo");
        AppCompatImageView iconRedo = (AppCompatImageView) _$_findCachedViewById(R.id.iconRedo);
        kotlin.jvm.internal.s.g(iconRedo, "iconRedo");
        AppCompatImageView showOriginPicBt = (AppCompatImageView) _$_findCachedViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(showOriginPicBt, "showOriginPicBt");
        ImageView editInnerUndo = (ImageView) _$_findCachedViewById(R.id.editInnerUndo);
        kotlin.jvm.internal.s.g(editInnerUndo, "editInnerUndo");
        ImageView editInnerRedo = (ImageView) _$_findCachedViewById(R.id.editInnerRedo);
        kotlin.jvm.internal.s.g(editInnerRedo, "editInnerRedo");
        us.pinguo.edit2020.view.c0 c0Var = new us.pinguo.edit2020.view.c0(operationLayout, iconUndo, iconRedo, showOriginPicBt, editInnerUndo, editInnerRedo);
        this.f10516l = c0Var;
        if (c0Var != null) {
            c0Var.D(this);
            EditViewModel j1 = j1();
            TextureView texViewHint = (TextureView) _$_findCachedViewById(R.id.texViewHint);
            kotlin.jvm.internal.s.g(texViewHint, "texViewHint");
            j1.P(texViewHint);
            EditViewModel j12 = j1();
            TextureView magnifierTextureView = (TextureView) _$_findCachedViewById(R.id.magnifierTextureView);
            kotlin.jvm.internal.s.g(magnifierTextureView, "magnifierTextureView");
            j12.Q(magnifierTextureView, new EditFragment$onViewCreated$4(this));
            s1();
            o1();
            A1();
            z1();
            r1();
            v1();
            q1();
            final a aVar = new a();
            us.pinguo.repository2020.u<us.pinguo.edit2020.bean.k> d2 = j1().h().n().d();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
            d2.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.fragment.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.r2(EditFragment.this, (us.pinguo.edit2020.bean.k) obj);
                }
            });
            us.pinguo.repository2020.u<us.pinguo.edit2020.viewmodel.module.c> c2 = j1().h().n().c();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
            c2.observe(viewLifecycleOwner2, new Observer() { // from class: us.pinguo.edit2020.fragment.o0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.s2(EditFragment.this, aVar, (us.pinguo.edit2020.viewmodel.module.c) obj);
                }
            });
            j1().S(new EditFragment$onViewCreated$7(this));
            u2();
            j1().l().D0(new c());
            j1().s().observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.edit2020.fragment.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EditFragment.o2(EditFragment.this, (String) obj);
                }
            });
            Z0();
            return;
        }
        kotlin.jvm.internal.s.z("operationController");
        throw null;
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.b
    public void q(PGEditTabLayout.f fVar) {
        d3 d3Var = this.f10511g;
        if (d3Var != null) {
            this.A = d3Var;
            if (this.B) {
                if (d3Var == null) {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
                d3Var.Q();
            }
            d3 d3Var2 = this.f10511g;
            if (d3Var2 != null) {
                d3Var2.show();
                d3 d3Var3 = this.f10511g;
                if (d3Var3 != null) {
                    this.y = d3Var3;
                    return;
                } else {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
            }
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
        kotlin.jvm.internal.s.z("bottomTabBeautyController");
        throw null;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    public final void t2(Intent intent) {
        this.q = false;
        this.r = false;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivOriginalPicture);
        if (appCompatImageView != null) {
            appCompatImageView.setTag(null);
        }
        l1(intent);
        g2(j1().g());
        String g2 = j1().g();
        if (g2 != null) {
            X0(g2);
            I2(true);
            D1();
        }
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) _$_findCachedViewById(i2)).G();
        u2();
        PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
        PGEditBottomTabLayout.A(bottomTabLayout, R.id.pg_edit_first_menu_beauty, false, 2, null);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.b
    public void x(PGEditTabLayout.f fVar) {
        EditController editController;
        a1();
        if (this.B && (editController = this.f10513i) != null) {
            editController.Q();
        }
        EditController editController2 = this.f10513i;
        this.y = editController2;
        this.A = editController2;
        if (editController2 == null) {
            return;
        }
        editController2.show();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }
}
