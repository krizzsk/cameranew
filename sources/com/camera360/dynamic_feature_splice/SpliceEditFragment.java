package com.camera360.dynamic_feature_splice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.picker.image.PhotoPickData;
import us.pinguo.picker.image.PickItem;
import us.pinguo.picker.image.PuzzleTask;
import us.pinguo.picker.image.adapter.PickPhotoSetAdapter;
import us.pinguo.ui.uilview.AlphaImageView;
import us.pinguo.ui.widget.RotateImageView;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: SpliceEditFragment.kt */
/* loaded from: classes8.dex */
public final class SpliceEditFragment extends Fragment implements p1, us.pinguo.picker.image.d {
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private SpliceScrollView f2154d;

    /* renamed from: e  reason: collision with root package name */
    private View f2155e;

    /* renamed from: f  reason: collision with root package name */
    private View f2156f;

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences f2157g;

    /* renamed from: h  reason: collision with root package name */
    private PhotoPickData f2158h;

    /* renamed from: i  reason: collision with root package name */
    private int f2159i;

    /* renamed from: j  reason: collision with root package name */
    private AnimatorSet f2160j;

    /* renamed from: l  reason: collision with root package name */
    private AnimatorSet f2162l;
    private o1 m;
    private RecyclerView n;
    private RecyclerView o;
    private e1 r;
    private k1 s;
    private boolean t;
    private List<? extends PickItem> v;
    private boolean w;
    private l1 x;
    public Map<Integer, View> a = new LinkedHashMap();
    private final ArrayList<PickItem> b = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private boolean f2161k = true;
    private b p = new b(this);
    private f q = new f();
    private SpliceScaleType u = SpliceScaleType.FULL;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public final class a extends o1 {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SpliceEditFragment f2163e;

        public a(SpliceEditFragment this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            this.f2163e = this$0;
        }

        @Override // com.camera360.dynamic_feature_splice.o1, com.camera360.dynamic_feature_splice.DragLinearLayout.f
        public void c(View view, int i2, View secondView, int i3) {
            kotlin.jvm.internal.s.h(secondView, "secondView");
            super.c(view, i2, secondView, i3);
            ArrayList arrayList = this.f2163e.b;
            int i4 = 0;
            Object[] array = arrayList.toArray(new PickItem[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            if (i2 >= 0 && i2 < array.length) {
                if (i3 >= 0 && i3 < array.length) {
                    Object obj = array[i2];
                    Object obj2 = array[i3];
                    array[i3] = obj;
                    array[i2] = obj2;
                    arrayList.clear();
                    int length = array.length;
                    while (i4 < length) {
                        Object obj3 = array[i4];
                        i4++;
                        arrayList.add(obj3);
                    }
                }
            }
            this.f2163e.t = true;
        }

        @Override // com.camera360.dynamic_feature_splice.o1
        public View l(SpliceScrollView parent, Context context, int i2) {
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(context, "context");
            CropZoomImageView cropZoomImageView = new CropZoomImageView(context);
            cropZoomImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            n1 g2 = g(i2);
            kotlin.jvm.internal.s.e(g2);
            cropZoomImageView.e(g2.a());
            j().add(cropZoomImageView);
            return cropZoomImageView;
        }

        @Override // com.camera360.dynamic_feature_splice.o1
        public boolean m() {
            return !this.f2163e.G();
        }

        @Override // com.camera360.dynamic_feature_splice.o1
        public void o(int i2) {
            this.f2163e.s1(i2, g(i2));
            CropZoomImageView i3 = i(i2);
            if (i3 != null) {
                SpliceScrollView spliceScrollView = this.f2163e.f2154d;
                if (spliceScrollView == null) {
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
                int top = i3.getTop();
                int height = i3.getHeight();
                SpliceScrollView spliceScrollView2 = this.f2163e.f2154d;
                if (spliceScrollView2 != null) {
                    spliceScrollView.smoothScrollTo(0, top + ((height - spliceScrollView2.getHeight()) / 2));
                } else {
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
            }
        }
    }

    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public final class b extends SplicePickPhotoItemAdapter {

        /* renamed from: i  reason: collision with root package name */
        private int f2164i;

        /* renamed from: j  reason: collision with root package name */
        private PickItem f2165j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ SpliceEditFragment f2166k;

        public b(SpliceEditFragment this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            this.f2166k = this$0;
            this.f2164i = -1;
        }

        private final void y(us.pinguo.picker.image.gallery.m mVar) {
            kotlin.z.d h2;
            e1 e1Var = this.f2166k.r;
            if (e1Var != null) {
                e1Var.c(true);
            }
            PickItem pickItem = new PickItem(mVar.h(), mVar.f());
            ArrayList arrayList = this.f2166k.b;
            int i2 = 0;
            Object[] array = arrayList.toArray(new PickItem[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            h2 = kotlin.z.j.h(0, arrayList.size());
            Iterator<Integer> it = h2.iterator();
            boolean z = false;
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.h0) it).nextInt();
                String str = ((PickItem) array[nextInt]).path;
                PickItem z2 = z();
                PickItem pickItem2 = kotlin.jvm.internal.s.c(str, z2 == null ? null : z2.path) ? pickItem : null;
                if (pickItem2 != null) {
                    array[nextInt] = pickItem2;
                    z = true;
                }
            }
            if (z) {
                arrayList.clear();
                int length = array.length;
                while (i2 < length) {
                    Object obj = array[i2];
                    i2++;
                    arrayList.add(obj);
                }
            }
            this.f2166k.J1(pickItem);
            B(pickItem);
        }

        public final int A() {
            return this.f2164i;
        }

        public final void B(PickItem pickItem) {
            int i2;
            if (kotlin.jvm.internal.s.c(this.f2165j, pickItem)) {
                return;
            }
            PickItem pickItem2 = this.f2165j;
            this.f2165j = pickItem;
            Iterator<us.pinguo.picker.image.gallery.m> it = i().iterator();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = -1;
                if (!it.hasNext()) {
                    i4 = -1;
                    break;
                }
                if (kotlin.jvm.internal.s.c(pickItem == null ? null : pickItem.path, it.next().f())) {
                    break;
                }
                i4++;
            }
            this.f2164i = i4;
            Iterator<us.pinguo.picker.image.gallery.m> it2 = i().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (kotlin.jvm.internal.s.c(pickItem2 == null ? null : pickItem2.path, it2.next().f())) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                notifyItemChanged(i2);
            }
            if (i4 >= 0) {
                notifyItemChanged(i4);
            }
        }

        @Override // com.camera360.dynamic_feature_splice.SplicePickPhotoItemAdapter
        public boolean k(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PickItem pickItem = this.f2165j;
            Object obj = null;
            if (kotlin.jvm.internal.s.c(pickItem == null ? null : pickItem.path, mediaItem.f())) {
                return true;
            }
            Iterator it = this.f2166k.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (kotlin.jvm.internal.s.c(((PickItem) next).path, mediaItem.f())) {
                    obj = next;
                    break;
                }
            }
            return obj == null;
        }

        @Override // com.camera360.dynamic_feature_splice.SplicePickPhotoItemAdapter
        public boolean l(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PickItem pickItem = this.f2165j;
            return kotlin.jvm.internal.s.c(pickItem == null ? null : pickItem.path, mediaItem.f());
        }

        @Override // com.camera360.dynamic_feature_splice.SplicePickPhotoItemAdapter
        public void t(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            y(mediaItem);
        }

        public final PickItem z() {
            return this.f2165j;
        }
    }

    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RecyclerView recyclerView = SpliceEditFragment.this.o;
            boolean z = false;
            if (recyclerView != null && recyclerView.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                recyclerView.setVisibility(4);
                recyclerView.setTranslationY(SpliceEditFragment.this.f2159i);
            }
            View view = SpliceEditFragment.this.f2156f;
            if (view != null) {
                view.setVisibility(4);
            } else {
                kotlin.jvm.internal.s.z("swapView");
                throw null;
            }
        }
    }

    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = SpliceEditFragment.this.f2156f;
            if (view != null) {
                view.setVisibility(0);
            } else {
                kotlin.jvm.internal.s.z("swapView");
                throw null;
            }
        }
    }

    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = SpliceEditFragment.this.c;
            if (view != null) {
                ((RecyclerView) view.findViewById(R.id.rv_swap_set)).setVisibility(4);
            } else {
                kotlin.jvm.internal.s.z("rootView");
                throw null;
            }
        }
    }

    /* compiled from: SpliceEditFragment.kt */
    /* loaded from: classes8.dex */
    public static final class f extends PickPhotoSetAdapter {
        f() {
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoSetAdapter
        public void m(us.pinguo.picker.image.c mediaSetInfo) {
            kotlin.jvm.internal.s.h(mediaSetInfo, "mediaSetInfo");
            SpliceEditFragment.this.F0(mediaSetInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.z1(((Float) animatedValue).floatValue());
    }

    private final void A1() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.e0("show");
        final k1 k1Var = new k1(activity);
        k1Var.d(new DialogInterface.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.p0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SpliceEditFragment.B1(k1.this, this, activity, dialogInterface, i2);
            }
        });
        k1Var.show();
        this.s = k1Var;
    }

    private final void B0() {
        View view;
        View view2 = this.c;
        if (view2 != null) {
            int i2 = R.id.guide_layout;
            if (((RelativeLayout) view2.findViewById(i2)).getVisibility() == 0) {
                View view3 = this.c;
                if (view3 == null) {
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                us.pinguo.foundation.utils.c.c((RelativeLayout) view3.findViewById(i2));
            }
            E0();
            AnimatorSet animatorSet = this.f2160j;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            View view4 = this.f2155e;
            if (view4 != null) {
                float height = (view4.getHeight() - this.f2159i) + getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_bottom_height);
                if (this.f2155e != null) {
                    float height2 = height / view.getHeight();
                    View view5 = this.f2155e;
                    if (view5 == null) {
                        kotlin.jvm.internal.s.z("spliceEditLayout");
                        throw null;
                    }
                    float scaleX = view5.getScaleX();
                    long j2 = ((scaleX - height2) / (1.0f - height2)) * ((float) 300);
                    if (j2 < 20) {
                        x1(height2);
                        View view6 = this.f2156f;
                        if (view6 != null) {
                            view6.setTranslationY(0.0f);
                            z1(1.0f);
                            return;
                        }
                        kotlin.jvm.internal.s.z("swapView");
                        throw null;
                    }
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.setDuration(j2);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(scaleX, height2);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.d0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SpliceEditFragment.C0(SpliceEditFragment.this, valueAnimator);
                        }
                    });
                    View view7 = this.f2156f;
                    if (view7 == null) {
                        kotlin.jvm.internal.s.z("swapView");
                        throw null;
                    }
                    float[] fArr = new float[2];
                    if (view7 != null) {
                        fArr[0] = view7.getTranslationY();
                        fArr[1] = 0.0f;
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view7, "translationY", fArr);
                        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(-1.0f, 1.0f);
                        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.n0
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                SpliceEditFragment.D0(SpliceEditFragment.this, valueAnimator);
                            }
                        });
                        animatorSet2.addListener(new d());
                        animatorSet2.play(ofFloat).with(ofFloat2).with(ofFloat3);
                        this.f2160j = animatorSet2;
                        animatorSet2.start();
                        return;
                    }
                    kotlin.jvm.internal.s.z("swapView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("spliceEditLayout");
                throw null;
            }
            kotlin.jvm.internal.s.z("spliceEditLayout");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(k1 dialog, SpliceEditFragment this$0, FragmentActivity act, DialogInterface dialogInterface, int i2) {
        kotlin.jvm.internal.s.h(dialog, "$dialog");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(act, "$act");
        if (dialog.b()) {
            SharedPreferences sharedPreferences = this$0.f2157g;
            if (sharedPreferences == null) {
                kotlin.jvm.internal.s.z("guidePref");
                throw null;
            }
            sharedPreferences.edit().putBoolean("cancel_guide_shown", false).apply();
        }
        if (i2 == -1) {
            act.setResult(-1, this$0.J0());
            act.finish();
            us.pinguo.foundation.statistics.h.a.e0("sure");
            return;
        }
        us.pinguo.foundation.statistics.h.a.e0("cancle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.x1(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        if (this.w) {
            SpliceScrollView spliceScrollView = this.f2154d;
            if (spliceScrollView != null) {
                spliceScrollView.setStartDetectingCallback(new SpliceEditFragment$showGuide$1(this));
                View view = this.c;
                if (view != null) {
                    us.pinguo.foundation.utils.c.b((RelativeLayout) view.findViewById(R.id.guide_layout));
                    View view2 = this.c;
                    if (view2 != null) {
                        view2.findViewById(R.id.btn_close_guide).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.r0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                SpliceEditFragment.D1(SpliceEditFragment.this, view3);
                            }
                        });
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("rootView");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("rootView");
                throw null;
            }
            kotlin.jvm.internal.s.z("scrollView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.z1(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.L0();
    }

    private final void E0() {
        o1 o1Var;
        List<n1> h2;
        if (this.r != null || (o1Var = this.m) == null || (h2 = o1Var.h()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n1 n1Var : h2) {
            arrayList.add(new PickItem(n1Var.b(), n1Var.c()));
        }
        this.r = new e1(arrayList, o1Var.b(), false, 4, null);
    }

    private final void E1(int i2) {
        View view = this.c;
        if (view != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.loading_layout);
            linearLayout.setOnClickListener(e0.a);
            View view2 = this.c;
            if (view2 != null) {
                ((TextView) view2.findViewById(R.id.loading_text)).setText(i2);
                linearLayout.setVisibility(0);
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(us.pinguo.picker.image.c cVar) {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        N0();
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            photoPickData.i(Integer.valueOf(cVar.c()));
            this.q.q(cVar.c());
            us.pinguo.picker.image.gallery.o d2 = cVar.d();
            View view = this.c;
            if (view != null) {
                ((TextView) view.findViewById(R.id.swap_set_name)).setText(d2.i());
                b bVar = this.p;
                h2 = kotlin.collections.u.h();
                bVar.x(h2);
                PuzzleTask.a.a(new SpliceEditFragment$changeSet$1(d2), new SpliceEditFragment$changeSet$2(this));
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoPickData");
        throw null;
    }

    static /* synthetic */ void F1(SpliceEditFragment spliceEditFragment, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = vStudio.Android.Camera360.R.string.feeds_share_wait_res_0x7e070000;
        }
        spliceEditFragment.E1(i2);
    }

    private final void G0(SpliceScaleType spliceScaleType) {
        ArrayList<CropZoomImageView> k2;
        SpliceScrollView spliceScrollView = this.f2154d;
        if (spliceScrollView != null) {
            final View f2 = spliceScrollView.f();
            o1 o1Var = this.m;
            if (o1Var != null && (k2 = o1Var.k()) != null) {
                for (CropZoomImageView cropZoomImageView : k2) {
                    cropZoomImageView.b(spliceScaleType);
                }
            }
            if (f2 != null) {
                SpliceScrollView spliceScrollView2 = this.f2154d;
                if (spliceScrollView2 != null) {
                    us.pinguo.foundation.ui.c.b(spliceScrollView2.g(), new Runnable() { // from class: com.camera360.dynamic_feature_splice.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            SpliceEditFragment.H0(SpliceEditFragment.this, f2);
                        }
                    });
                    return;
                } else {
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
            }
            return;
        }
        kotlin.jvm.internal.s.z("scrollView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f2161k) {
            return;
        }
        SpliceScrollView spliceScrollView = this$0.f2154d;
        if (spliceScrollView == null) {
            kotlin.jvm.internal.s.z("scrollView");
            throw null;
        }
        int top = view.getTop();
        int height = view.getHeight();
        SpliceScrollView spliceScrollView2 = this$0.f2154d;
        if (spliceScrollView2 != null) {
            spliceScrollView.setScrollY(top + ((height - spliceScrollView2.getHeight()) / 2));
        } else {
            kotlin.jvm.internal.s.z("scrollView");
            throw null;
        }
    }

    private final void H1() {
        RecyclerView recyclerView = this.o;
        if (recyclerView == null) {
            return;
        }
        AnimatorSet animatorSet = this.f2162l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        int[] iArr = new int[2];
        View view = this.c;
        if (view != null) {
            iArr[0] = ((RotateImageView) view.findViewById(R.id.splice_arrow)).a();
            iArr[1] = 180;
            ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.m0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SpliceEditFragment.I1(SpliceEditFragment.this, valueAnimator);
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, "translationY", recyclerView.getTranslationY(), 0.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(300L);
            animatorSet2.play(ofFloat).with(ofInt);
            animatorSet2.start();
            this.f2162l = animatorSet2;
            recyclerView.setVisibility(0);
            PhotoPickData photoPickData = this.f2158h;
            if (photoPickData != null) {
                v1(photoPickData.m());
                return;
            } else {
                kotlin.jvm.internal.s.z("photoPickData");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        View view = this$0.c;
        if (view != null) {
            ((RotateImageView) view.findViewById(R.id.splice_arrow)).setDegree(intValue);
        } else {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    private final Intent J0() {
        ArrayList<PickItem> arrayList = this.b;
        int size = arrayList.size();
        PickItem[] pickItemArr = new PickItem[size];
        for (int i2 = 0; i2 < size; i2++) {
            pickItemArr[i2] = arrayList.get(i2);
        }
        Intent intent = new Intent();
        intent.putExtra("splices", pickItemArr);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(PickItem pickItem) {
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new SpliceEditFragment$swapSpliceItem$1(pickItem, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0() {
        View view = this.c;
        if (view == null) {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        int i2 = R.id.guide_layout;
        if (((RelativeLayout) view.findViewById(i2)).getVisibility() == 0) {
            SpliceScrollView spliceScrollView = this.f2154d;
            if (spliceScrollView != null) {
                spliceScrollView.setStartDetectingCallback(SpliceEditFragment$hideGuide$1.INSTANCE);
                SharedPreferences sharedPreferences = this.f2157g;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("splice_guide_shown", false).apply();
                    View view2 = this.c;
                    if (view2 != null) {
                        us.pinguo.foundation.utils.c.c((RelativeLayout) view2.findViewById(i2));
                        this.w = false;
                        return;
                    }
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("guidePref");
                throw null;
            }
            kotlin.jvm.internal.s.z("scrollView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        View view = this.c;
        if (view != null) {
            ((LinearLayout) view.findViewById(R.id.loading_layout)).setVisibility(8);
        } else {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    private final void N0() {
        RecyclerView recyclerView = this.o;
        if (recyclerView == null) {
            return;
        }
        AnimatorSet animatorSet = this.f2162l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, "translationY", recyclerView.getTranslationY(), this.f2159i);
        ValueAnimator ofInt = ValueAnimator.ofInt(((RotateImageView) _$_findCachedViewById(R.id.splice_arrow)).a(), BaseBlurEffect.ROTATION_360);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.f0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpliceEditFragment.O0(SpliceEditFragment.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(300L);
        animatorSet2.play(ofFloat).with(ofInt);
        animatorSet2.start();
        animatorSet2.addListener(new e());
        this.f2162l = animatorSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        View view = this$0.c;
        if (view != null) {
            ((RotateImageView) view.findViewById(R.id.splice_arrow)).setDegree(intValue);
        } else {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    private final void P0() {
        if (this.n == null) {
            View view = this.c;
            if (view != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_swap_items);
                int dimensionPixelSize = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_item_space);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                recyclerView.addItemDecoration(new us.pinguo.picker.image.h(dimensionPixelSize, false, 2, null));
                recyclerView.setAdapter(this.p);
                this.n = recyclerView;
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    private final void Q0() {
        Context context = getContext();
        if (context != null && this.o == null) {
            View view = this.c;
            if (view != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_swap_set);
                Drawable drawable = ContextCompat.getDrawable(context, vStudio.Android.Camera360.R.drawable.pick_set_divider);
                if (drawable != null) {
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
                    dividerItemDecoration.setDrawable(drawable);
                    recyclerView.addItemDecoration(dividerItemDecoration);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
                recyclerView.setAdapter(this.q);
                recyclerView.addItemDecoration(new us.pinguo.picker.image.i(getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_set_space)));
                recyclerView.setTranslationY(this.f2159i);
                this.o = recyclerView;
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    private final void R0(int i2) {
        F1(this, 0, 1, null);
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new SpliceEditFragment$initSpliceData$1(this, i2, null), 3, null);
    }

    static /* synthetic */ void S0(SpliceEditFragment spliceEditFragment, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        spliceEditFragment.R0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.Y0() || this$0.isLoading()) {
            return;
        }
        if (this$0.G()) {
            e1 e1Var = this$0.r;
            if (e1Var == null) {
                this$0.y0();
                return;
            }
            this$0.b.clear();
            this$0.b.addAll(e1Var.a());
            this$0.R0(e1Var.b());
            return;
        }
        us.pinguo.foundation.statistics.h.a.r("close_btn");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        SharedPreferences sharedPreferences = this$0.f2157g;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.s.z("guidePref");
            throw null;
        } else if (sharedPreferences.getBoolean("cancel_guide_shown", true)) {
            this$0.A1();
        } else {
            activity.setResult(-1, this$0.J0());
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.Y0() || this$0.isLoading()) {
            return;
        }
        if (this$0.G()) {
            o1 o1Var = this$0.m;
            if (o1Var != null) {
                o1Var.q(-1);
            }
            this$0.y0();
            return;
        }
        this$0.q1();
        us.pinguo.foundation.statistics.h.a.r("save_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.Y0() || this$0.isLoading()) {
            return;
        }
        this$0.Q0();
        RecyclerView recyclerView = this$0.o;
        boolean z = false;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            this$0.N0();
        } else {
            this$0.H1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.G()) {
            RecyclerView recyclerView = this$0.o;
            boolean z = false;
            if (recyclerView != null && recyclerView.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                this$0.N0();
                return;
            }
            o1 o1Var = this$0.m;
            if (o1Var != null) {
                o1Var.q(-1);
            }
            this$0.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(SpliceEditFragment this$0, AlphaImageView alphaImageView, AlphaImageView alphaImageView2, AlphaImageView alphaImageView3, AlphaImageView alphaImageView4, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.Y0()) {
            return;
        }
        alphaImageView.setImageResource(vStudio.Android.Camera360.R.drawable.splice_full_normal);
        alphaImageView2.setImageResource(vStudio.Android.Camera360.R.drawable.splice_1x1_normal);
        alphaImageView3.setImageResource(vStudio.Android.Camera360.R.drawable.splice_3x4_normal);
        alphaImageView4.setImageResource(vStudio.Android.Camera360.R.drawable.splice_9x16_normal);
        if (kotlin.jvm.internal.s.c(view, alphaImageView)) {
            alphaImageView.setImageResource(vStudio.Android.Camera360.R.drawable.splice_full_selected);
            this$0.u = SpliceScaleType.FULL;
        } else if (kotlin.jvm.internal.s.c(view, alphaImageView2)) {
            alphaImageView2.setImageResource(vStudio.Android.Camera360.R.drawable.splice_1x1_selected);
            this$0.u = SpliceScaleType.S1x1;
        } else if (kotlin.jvm.internal.s.c(view, alphaImageView3)) {
            alphaImageView3.setImageResource(vStudio.Android.Camera360.R.drawable.splice_3x4_selected);
            this$0.u = SpliceScaleType.S3x4;
        } else if (kotlin.jvm.internal.s.c(view, alphaImageView4)) {
            alphaImageView4.setImageResource(vStudio.Android.Camera360.R.drawable.splice_9x16_selected);
            this$0.u = SpliceScaleType.S9x16;
        }
        this$0.G0(this$0.u);
        us.pinguo.foundation.statistics.h.a.r(this$0.u.getStr());
    }

    private final boolean Y0() {
        SpliceScrollView spliceScrollView = this.f2154d;
        if (spliceScrollView != null) {
            return spliceScrollView.i();
        }
        kotlin.jvm.internal.s.z("scrollView");
        throw null;
    }

    private final void initViews() {
        View view = this.c;
        if (view != null) {
            ((ImageView) view.findViewById(R.id.title_back_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SpliceEditFragment.T0(SpliceEditFragment.this, view2);
                }
            });
            View view2 = this.c;
            if (view2 != null) {
                ((TextView) view2.findViewById(R.id.title_right_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        SpliceEditFragment.U0(SpliceEditFragment.this, view3);
                    }
                });
                View view3 = this.c;
                if (view3 != null) {
                    ((LinearLayout) view3.findViewById(R.id.layout_swap_bottom)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.k0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            SpliceEditFragment.V0(SpliceEditFragment.this, view4);
                        }
                    });
                    View view4 = this.c;
                    if (view4 != null) {
                        ((RelativeLayout) view4.findViewById(R.id.edit_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.l0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view5) {
                                SpliceEditFragment.W0(SpliceEditFragment.this, view5);
                            }
                        });
                        View view5 = this.c;
                        if (view5 != null) {
                            FrameLayout frameLayout = (FrameLayout) view5.findViewById(R.id.splice_edit_layout);
                            kotlin.jvm.internal.s.g(frameLayout, "rootView.splice_edit_layout");
                            this.f2155e = frameLayout;
                            View view6 = this.c;
                            if (view6 == null) {
                                kotlin.jvm.internal.s.z("rootView");
                                throw null;
                            }
                            SpliceScrollView spliceScrollView = (SpliceScrollView) view6.findViewById(R.id.scroll_splice_view);
                            kotlin.jvm.internal.s.g(spliceScrollView, "rootView.scroll_splice_view");
                            this.f2154d = spliceScrollView;
                            if (spliceScrollView != null) {
                                spliceScrollView.setScrollableCallback(this);
                                View view7 = this.c;
                                if (view7 != null) {
                                    final AlphaImageView alphaImageView = (AlphaImageView) view7.findViewById(R.id.splice_full);
                                    View view8 = this.c;
                                    if (view8 != null) {
                                        final AlphaImageView alphaImageView2 = (AlphaImageView) view8.findViewById(R.id.splice_1x1);
                                        View view9 = this.c;
                                        if (view9 != null) {
                                            final AlphaImageView alphaImageView3 = (AlphaImageView) view9.findViewById(R.id.splice_3x4);
                                            View view10 = this.c;
                                            if (view10 != null) {
                                                final AlphaImageView alphaImageView4 = (AlphaImageView) view10.findViewById(R.id.splice_9x16);
                                                this.u = SpliceScaleType.FULL;
                                                alphaImageView.setImageResource(vStudio.Android.Camera360.R.drawable.splice_full_selected);
                                                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.h0
                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view11) {
                                                        SpliceEditFragment.X0(SpliceEditFragment.this, alphaImageView, alphaImageView2, alphaImageView3, alphaImageView4, view11);
                                                    }
                                                };
                                                alphaImageView.setOnClickListener(onClickListener);
                                                alphaImageView2.setOnClickListener(onClickListener);
                                                alphaImageView3.setOnClickListener(onClickListener);
                                                alphaImageView4.setOnClickListener(onClickListener);
                                                View view11 = this.c;
                                                if (view11 == null) {
                                                    kotlin.jvm.internal.s.z("rootView");
                                                    throw null;
                                                }
                                                RelativeLayout relativeLayout = (RelativeLayout) view11.findViewById(R.id.layout_swap);
                                                kotlin.jvm.internal.s.g(relativeLayout, "rootView.layout_swap");
                                                this.f2156f = relativeLayout;
                                                if (relativeLayout != null) {
                                                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                                                    View view12 = this.c;
                                                    if (view12 != null) {
                                                        int dimensionPixelSize = ((view12.getResources().getDisplayMetrics().widthPixels * 5) / 8) + getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_bottom_height);
                                                        this.f2159i = dimensionPixelSize;
                                                        layoutParams.height = dimensionPixelSize;
                                                        View view13 = this.f2156f;
                                                        if (view13 != null) {
                                                            view13.setLayoutParams(layoutParams);
                                                            View view14 = this.f2156f;
                                                            if (view14 != null) {
                                                                view14.setTranslationY(this.f2159i);
                                                                return;
                                                            } else {
                                                                kotlin.jvm.internal.s.z("swapView");
                                                                throw null;
                                                            }
                                                        }
                                                        kotlin.jvm.internal.s.z("swapView");
                                                        throw null;
                                                    }
                                                    kotlin.jvm.internal.s.z("rootView");
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.s.z("swapView");
                                                throw null;
                                            }
                                            kotlin.jvm.internal.s.z("rootView");
                                            throw null;
                                        }
                                        kotlin.jvm.internal.s.z("rootView");
                                        throw null;
                                    }
                                    kotlin.jvm.internal.s.z("rootView");
                                    throw null;
                                }
                                kotlin.jvm.internal.s.z("rootView");
                                throw null;
                            }
                            kotlin.jvm.internal.s.z("scrollView");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("rootView");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("rootView");
                throw null;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    private final boolean isLoading() {
        View view = this.c;
        if (view != null) {
            return ((LinearLayout) view.findViewById(R.id.loading_layout)).getVisibility() == 0;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    private final void q1() {
        List<n1> h2;
        kotlin.z.d h3;
        boolean z;
        View view = this.c;
        Object obj = null;
        if (view == null) {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        } else if (((LinearLayout) view.findViewById(R.id.loading_layout)).getVisibility() == 0) {
        } else {
            E1(vStudio.Android.Camera360.R.string.saving_image);
            ArrayList arrayList = new ArrayList();
            o1 o1Var = this.m;
            if (o1Var == null || (h2 = o1Var.h()) == null) {
                return;
            }
            h3 = kotlin.z.j.h(0, h2.size());
            Iterator<Integer> it = h3.iterator();
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.h0) it).nextInt();
                n1 n1Var = h2.get(nextInt);
                CropZoomImageView i2 = o1Var.i(nextInt);
                kotlin.jvm.internal.s.e(i2);
                arrayList.add(new m1(n1Var.c(), n1Var.b(), r1(i2.c())));
            }
            if (us.pinguo.foundation.d.f10987f) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (((m1) next).a() != 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        obj = next;
                        break;
                    }
                }
                if (obj != null) {
                    us.pinguo.foundation.utils.k0.a.e("需要用这个手机进行四个方向的放大，剪裁测试!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                }
            }
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new SpliceEditFragment$makeSpliceImage$3(this, arrayList, System.currentTimeMillis(), null), 3, null);
        }
    }

    private static final RectF r1(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float f2 = rectF.left;
        float f3 = rectF.right;
        if (f2 < f3) {
            float f4 = rectF.top;
            float f5 = rectF.bottom;
            if (f4 < f5 && f2 >= 0.0f && f3 >= 0.0f && f4 >= 0.0f && f5 >= 0.0f && f2 <= 1.0f && f3 <= 1.0f && f4 <= 1.0f && f5 <= 1.0f) {
                return rectF;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(int i2, n1 n1Var) {
        View view = this.c;
        if (view != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.swap_layout);
            View view2 = this.c;
            if (view2 != null) {
                TextView textView = (TextView) view2.findViewById(R.id.btn_swap);
                View view3 = this.c;
                if (view3 == null) {
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                ImageView imageView = (ImageView) view3.findViewById(R.id.btn_swap_cancel);
                if (i2 != -1) {
                    us.pinguo.foundation.utils.c.b(linearLayout);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.b0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            SpliceEditFragment.t1(SpliceEditFragment.this, view4);
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.j0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            SpliceEditFragment.u1(SpliceEditFragment.this, view4);
                        }
                    });
                    if (G()) {
                        us.pinguo.picker.image.gallery.m g2 = this.p.g(new SpliceEditFragment$positionChanged$mediaItem$1(n1Var));
                        if (g2 != null) {
                            this.p.B(new PickItem(g2.h(), g2.f()));
                            w1(this.p.A());
                            return;
                        }
                        PhotoPickData photoPickData = this.f2158h;
                        if (photoPickData != null) {
                            photoPickData.l(n1Var != null ? n1Var.c() : null);
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("photoPickData");
                            throw null;
                        }
                    }
                    return;
                }
                us.pinguo.foundation.statistics.h.a.r("un_select_pic");
                us.pinguo.foundation.utils.c.c(linearLayout);
                textView.setOnClickListener(null);
                imageView.setOnClickListener(null);
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.P0();
        this$0.B0();
        o1 o1Var = this$0.m;
        if (o1Var != null) {
            PhotoPickData photoPickData = this$0.f2158h;
            if (photoPickData == null) {
                kotlin.jvm.internal.s.z("photoPickData");
                throw null;
            } else {
                n1 g2 = o1Var.g(o1Var.b());
                photoPickData.l(g2 != null ? g2.c() : null);
            }
        }
        us.pinguo.foundation.statistics.h.a.r("replace_btn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(SpliceEditFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        o1 o1Var = this$0.m;
        if (o1Var == null) {
            return;
        }
        o1Var.q(-1);
    }

    private final void v1(Integer num) {
        RecyclerView recyclerView = this.o;
        if (recyclerView == null || num == null) {
            return;
        }
        this.q.q(num.intValue());
        int g2 = this.q.g();
        if (g2 >= 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(g2, 0);
        }
    }

    private final void w1(int i2) {
        if (i2 < 0) {
            return;
        }
        RecyclerView recyclerView = this.n;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) (recyclerView == null ? null : recyclerView.getLayoutManager());
        if (gridLayoutManager == null) {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri x0(ContentResolver contentResolver, String str, long j2, us.pinguo.librouter.b.c.f fVar, int i2, File file, us.pinguo.camerasdk.core.util.b bVar, String str2) {
        int U;
        String str3;
        String path = file.getPath();
        String filename = file.getName();
        long length = file.length();
        ContentValues contentValues = new ContentValues(9);
        kotlin.jvm.internal.s.g(filename, "filename");
        U = StringsKt__StringsKt.U(filename, '.', 0, false, 6, null);
        if (U > 0) {
            str3 = filename.substring(0, U);
            kotlin.jvm.internal.s.g(str3, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str3 = str;
        }
        contentValues.put("title", str3);
        contentValues.put("_display_name", filename);
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("orientation", Integer.valueOf(i2));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + '/' + str2 + '/');
        } else {
            contentValues.put("_data", path);
        }
        contentValues.put("_size", Long.valueOf(length));
        if (fVar != null) {
            contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(fVar.c()));
            contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(fVar.d()));
        }
        if (bVar != null && i3 >= 16 && us.pinguo.util.c.m) {
            contentValues.put("width", Integer.valueOf(bVar.c()));
            contentValues.put("height", Integer.valueOf(bVar.b()));
        }
        try {
            return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            BaseApplication.d().sendBroadcast(intent);
            CrashReport.postCatchedException(th);
            return null;
        }
    }

    private final void x1(float f2) {
        View view = this.f2155e;
        if (view != null) {
            view.setScaleX(f2);
            View view2 = this.f2155e;
            if (view2 != null) {
                view2.setScaleY(f2);
                View view3 = this.f2155e;
                if (view3 != null) {
                    view3.setPivotY(0.0f);
                    View view4 = this.f2155e;
                    if (view4 == null) {
                        kotlin.jvm.internal.s.z("spliceEditLayout");
                        throw null;
                    } else if (view4 != null) {
                        view4.setPivotX(view4.getWidth() / 2.0f);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("spliceEditLayout");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("spliceEditLayout");
                throw null;
            }
            kotlin.jvm.internal.s.z("spliceEditLayout");
            throw null;
        }
        kotlin.jvm.internal.s.z("spliceEditLayout");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        View view;
        C1();
        this.r = null;
        AnimatorSet animatorSet = this.f2160j;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        View view2 = this.f2155e;
        if (view2 != null) {
            float height = (view2.getHeight() - this.f2159i) + getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_bottom_height);
            if (this.f2155e != null) {
                float height2 = height / view.getHeight();
                View view3 = this.f2155e;
                if (view3 == null) {
                    kotlin.jvm.internal.s.z("spliceEditLayout");
                    throw null;
                }
                float scaleX = view3.getScaleX();
                long j2 = ((1.0f - scaleX) / (1 - height2)) * ((float) 300);
                if (j2 < 20) {
                    x1(1.0f);
                    z1(-1.0f);
                    View view4 = this.f2156f;
                    if (view4 != null) {
                        view4.setTranslationY(this.f2159i);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("swapView");
                        throw null;
                    }
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(j2);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(scaleX, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.c0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SpliceEditFragment.z0(SpliceEditFragment.this, valueAnimator);
                    }
                });
                View view5 = this.f2156f;
                if (view5 == null) {
                    kotlin.jvm.internal.s.z("swapView");
                    throw null;
                }
                float[] fArr = new float[2];
                if (view5 != null) {
                    fArr[0] = view5.getTranslationY();
                    fArr[1] = this.f2159i;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view5, "translationY", fArr);
                    ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, -1.0f);
                    ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.g0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SpliceEditFragment.A0(SpliceEditFragment.this, valueAnimator);
                        }
                    });
                    animatorSet2.addListener(new c());
                    animatorSet2.play(ofFloat).with(ofFloat2).with(ofFloat3);
                    this.f2160j = animatorSet2;
                    animatorSet2.start();
                    return;
                }
                kotlin.jvm.internal.s.z("swapView");
                throw null;
            }
            kotlin.jvm.internal.s.z("spliceEditLayout");
            throw null;
        }
        kotlin.jvm.internal.s.z("spliceEditLayout");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SpliceEditFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.x1(((Float) animatedValue).floatValue());
    }

    private final void z1(float f2) {
        View view = this.c;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.title_back_btn);
            View view2 = this.c;
            if (view2 != null) {
                TextView textView = (TextView) view2.findViewById(R.id.title_right_btn);
                View view3 = this.c;
                if (view3 == null) {
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                TextView textView2 = (TextView) view3.findViewById(R.id.title_text);
                if (f2 <= 0.0f) {
                    float f3 = -f2;
                    imageView.setAlpha(f3);
                    textView.setAlpha(f3);
                    textView2.setAlpha(f3);
                    imageView.setImageResource(vStudio.Android.Camera360.R.drawable.sticker_arrow_back);
                    textView.setText(vStudio.Android.Camera360.R.string.pg_sdk_edit_save);
                    textView2.setText(vStudio.Android.Camera360.R.string.title_splice);
                    return;
                }
                imageView.setAlpha(f2);
                textView.setAlpha(f2);
                textView2.setAlpha(f2);
                imageView.setImageResource(vStudio.Android.Camera360.R.drawable.webview_cancel);
                textView.setText(vStudio.Android.Camera360.R.string.complete);
                textView2.setText(vStudio.Android.Camera360.R.string.splice_swap);
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    @Override // com.camera360.dynamic_feature_splice.p1
    public boolean G() {
        View view = this.f2155e;
        if (view != null) {
            return view.getScaleX() <= 0.9999f;
        }
        kotlin.jvm.internal.s.z("spliceEditLayout");
        throw null;
    }

    public final String I0(long j2, String dir) {
        boolean m;
        kotlin.jvm.internal.s.h(dir, "dir");
        String d2 = us.pinguo.util.u.d(j2, "yyyy-MM-dd-HH-mm-ss-SSS");
        String separator = File.separator;
        kotlin.jvm.internal.s.g(separator, "separator");
        m = kotlin.text.t.m(dir, separator, false, 2, null);
        if (!m) {
            dir = kotlin.jvm.internal.s.q(dir, separator);
        }
        return dir + "C360_" + d2 + new Regex(" ").replace(".jpg", PGTransHeader.CONNECTOR);
    }

    public final l1 K0() {
        return this.x;
    }

    @Override // us.pinguo.picker.image.d
    public void O(int i2, us.pinguo.picker.image.f pickInfo) {
        kotlin.jvm.internal.s.h(pickInfo, "pickInfo");
        us.pinguo.picker.image.gallery.m b2 = pickInfo.b();
        if (b2 != null) {
            this.p.B(new PickItem(b2.h(), b2.f()));
            w1(pickInfo.e());
        }
        this.p.x(pickInfo.c());
        View view = this.c;
        if (view != null) {
            ((TextView) view.findViewById(R.id.swap_set_name)).setText(pickInfo.d().i());
        } else {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
    }

    @Override // us.pinguo.picker.image.d
    public void T() {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        b bVar = this.p;
        h2 = kotlin.collections.u.h();
        bVar.x(h2);
        this.p.B(null);
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.a;
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

    @Override // us.pinguo.picker.image.d
    public void h() {
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            v1(photoPickData.m());
        } else {
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    public final boolean onBackPressed() {
        RecyclerView recyclerView = this.o;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            N0();
            return true;
        } else if (G()) {
            o1 o1Var = this.m;
            if (o1Var != null) {
                o1Var.q(-1);
            }
            y0();
            return true;
        } else {
            SharedPreferences sharedPreferences = this.f2157g;
            if (sharedPreferences == null) {
                kotlin.jvm.internal.s.z("guidePref");
                throw null;
            } else if (sharedPreferences.getBoolean("cancel_guide_shown", true)) {
                A1();
                return true;
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setResult(-1, J0());
                }
                us.pinguo.foundation.statistics.h.a.r("back_btn");
                return false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        View inflate = inflater.inflate(vStudio.Android.Camera360.R.layout.fragment_splice_edit, viewGroup, false);
        kotlin.jvm.internal.s.g(inflate, "inflater.inflate(R.layou…e_edit, container, false)");
        this.c = inflate;
        SharedPreferences o = GuideHandler.o(getContext());
        kotlin.jvm.internal.s.g(o, "getSharedPreferences(context)");
        this.f2157g = o;
        if (o != null) {
            this.w = o.getBoolean("splice_guide_shown", true);
            initViews();
            View view = this.c;
            if (view != null) {
                return view;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("guidePref");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f2161k = true;
        this.q.p(true);
        this.p.w(true);
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            photoPickData.k();
            PhotoPickData photoPickData2 = this.f2158h;
            if (photoPickData2 != null) {
                photoPickData2.s(null);
                super.onDestroy();
                k1 k1Var = this.s;
                if (k1Var != null) {
                    k1Var.dismiss();
                }
                SpliceScrollView spliceScrollView = this.f2154d;
                if (spliceScrollView != null) {
                    spliceScrollView.setAdapter(null);
                    this.m = null;
                    SpliceScrollView spliceScrollView2 = this.f2154d;
                    if (spliceScrollView2 != null) {
                        spliceScrollView2.setScrollableCallback(null);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("scrollView");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("scrollView");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoPickData");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            photoPickData.q();
            k1 k1Var = this.s;
            if (k1Var == null) {
                return;
            }
            k1Var.dismiss();
            return;
        }
        kotlin.jvm.internal.s.z("photoPickData");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            photoPickData.r();
        } else {
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intent intent;
        Parcelable[] parcelableArrayExtra;
        ArrayList arrayList;
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        this.f2161k = false;
        this.q.p(false);
        this.p.w(false);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (parcelableArrayExtra = intent.getParcelableArrayExtra("splices")) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(parcelableArrayExtra.length);
            for (Parcelable parcelable : parcelableArrayExtra) {
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type us.pinguo.picker.image.PickItem");
                arrayList.add((PickItem) parcelable);
            }
        }
        kotlin.jvm.internal.s.e(arrayList);
        this.v = arrayList;
        this.b.clear();
        ArrayList<PickItem> arrayList2 = this.b;
        List<? extends PickItem> list = this.v;
        if (list != null) {
            arrayList2.addAll(list);
            PhotoPickData photoPickData = new PhotoPickData();
            this.f2158h = photoPickData;
            if (photoPickData != null) {
                photoPickData.s(this);
                PhotoPickData photoPickData2 = this.f2158h;
                if (photoPickData2 != null) {
                    photoPickData2.j();
                    S0(this, 0, 1, null);
                    return;
                }
                kotlin.jvm.internal.s.z("photoPickData");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
        kotlin.jvm.internal.s.z("argList");
        throw null;
    }

    @Override // us.pinguo.picker.image.d
    public void p(List<us.pinguo.picker.image.c> mediaSetList) {
        kotlin.jvm.internal.s.h(mediaSetList, "mediaSetList");
        f fVar = this.q;
        PhotoPickData photoPickData = this.f2158h;
        if (photoPickData != null) {
            fVar.o(mediaSetList, photoPickData.m());
        } else {
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    @Override // us.pinguo.picker.image.d
    public void u(us.pinguo.picker.image.c mediaSetInfo, int i2, int i3) {
        kotlin.jvm.internal.s.h(mediaSetInfo, "mediaSetInfo");
        this.q.l(mediaSetInfo, i2, i3);
    }

    @Override // us.pinguo.picker.image.d
    public void w() {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        b bVar = this.p;
        h2 = kotlin.collections.u.h();
        bVar.x(h2);
        this.p.B(null);
    }

    public final void y1(l1 l1Var) {
        this.x = l1Var;
    }
}
