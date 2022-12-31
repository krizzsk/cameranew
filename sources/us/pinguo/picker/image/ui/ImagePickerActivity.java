package us.pinguo.picker.image.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tencent.matrix.report.Issue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.u;
import kotlin.h;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.utils.k0;
import us.pinguo.foundation.utils.y;
import us.pinguo.inspire.PermissionInfo;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.picker.image.PhotoPickData;
import us.pinguo.picker.image.PickItem;
import us.pinguo.picker.image.R;
import us.pinguo.picker.image.adapter.PickPhotoItemAdapter;
import us.pinguo.picker.image.adapter.PickPhotoSetAdapter;
import us.pinguo.picker.image.g;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.picker.image.view.PinchImageView;
import us.pinguo.ui.widget.RotateImageView;
import us.pinguo.util.v;
/* compiled from: ImagePickerActivity.kt */
/* loaded from: classes5.dex */
public final class ImagePickerActivity extends BaseActivity implements us.pinguo.picker.image.d {
    private PhotoPickData b;
    private RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f11722d;

    /* renamed from: e  reason: collision with root package name */
    private ImagePickerConfigModel f11723e;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f11724f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11726h;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11730l;
    private final kotlin.f m;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<PickItem> f11725g = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private d f11727i = new d();

    /* renamed from: j  reason: collision with root package name */
    private PickPhotoSetAdapter f11728j = new e();

    /* renamed from: k  reason: collision with root package name */
    private a f11729k = new a(this);

    /* compiled from: ImagePickerActivity.kt */
    /* loaded from: classes5.dex */
    public final class a extends PagerAdapter {
        private final ArrayList<PinchImageView> a;
        final /* synthetic */ ImagePickerActivity b;

        public a(ImagePickerActivity this$0) {
            s.h(this$0, "this$0");
            this.b = this$0;
            this.a = new ArrayList<>(0);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i2, Object object) {
            s.h(container, "container");
            s.h(object, "object");
            PinchImageView pinchImageView = (PinchImageView) object;
            pinchImageView.setImageBitmap(null);
            pinchImageView.H();
            container.removeView(pinchImageView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.f11727i.getItemCount();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            s.h(object, "object");
            int i2 = 0;
            for (m mVar : this.b.f11727i.i()) {
                if (s.c(((PinchImageView) object).getTag(), mVar.f())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i2) {
            Object obj;
            boolean z;
            s.h(container, "container");
            Iterator<T> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((PinchImageView) obj).getParent() == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            PinchImageView pinchImageView = (PinchImageView) obj;
            if (pinchImageView == null) {
                pinchImageView = new PinchImageView(this.b);
                this.a.add(pinchImageView);
                pinchImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                pinchImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            String f2 = this.b.f11727i.i().get(i2).f();
            pinchImageView.setImageURI(s.q(InspirePublishFragment.FILE_HEADER, f2));
            pinchImageView.setTag(f2);
            container.addView(pinchImageView);
            return pinchImageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            s.h(view, "view");
            s.h(obj, "obj");
            return s.c(view, obj);
        }
    }

    /* compiled from: ImagePickerActivity.kt */
    /* loaded from: classes5.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RecyclerView recyclerView = ImagePickerActivity.this.f11722d;
            if (recyclerView == null) {
                s.z("photoSetView");
                throw null;
            }
            recyclerView.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView, 4);
        }
    }

    /* compiled from: ImagePickerActivity.kt */
    /* loaded from: classes5.dex */
    public static final class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    /* compiled from: ImagePickerActivity.kt */
    /* loaded from: classes5.dex */
    public static final class d extends PickPhotoItemAdapter {
        d() {
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public boolean k(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
            s.h(holder, "holder");
            s.h(mediaItem, "mediaItem");
            if (ImagePickerActivity.this.f11725g.size() >= 6) {
                k0 k0Var = k0.a;
                String string = ImagePickerActivity.this.getResources().getString(R.string.pick_max_waring, 6);
                s.g(string, "resources.getString(R.st…waring, PICK_PHOTO_COUNT)");
                k0Var.d(string);
                return false;
            }
            return super.k(holder, mediaItem, i2);
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public boolean l(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
            s.h(holder, "holder");
            s.h(mediaItem, "mediaItem");
            ImagePickerActivity imagePickerActivity = ImagePickerActivity.this;
            String f2 = mediaItem.f();
            s.g(f2, "mediaItem.filePath");
            return imagePickerActivity.G0(f2);
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void s(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
            s.h(holder, "holder");
            s.h(mediaItem, "mediaItem");
            ImagePickerActivity imagePickerActivity = ImagePickerActivity.this;
            String f2 = mediaItem.f();
            s.g(f2, "mediaItem.filePath");
            imagePickerActivity.N0(f2);
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void t(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
            s.h(holder, "holder");
            s.h(mediaItem, "mediaItem");
            ImagePickerConfigModel imagePickerConfigModel = ImagePickerActivity.this.f11723e;
            if (imagePickerConfigModel == null) {
                s.z("pickerConfigModel");
                throw null;
            } else if (imagePickerConfigModel.f()) {
                ImagePickerActivity.this.Q0(mediaItem, i2);
            } else {
                ImagePickerActivity imagePickerActivity = ImagePickerActivity.this;
                String f2 = mediaItem.f();
                s.g(f2, "mediaItem.filePath");
                imagePickerActivity.P0(f2, mediaItem.h());
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra(ImagePickerConfigModel.RESULT_DATA, ImagePickerActivity.this.f11725g);
                ImagePickerActivity.this.setResult(-1, intent);
                ImagePickerActivity.this.finish();
            }
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void u(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
            s.h(holder, "holder");
            s.h(mediaItem, "mediaItem");
            ImagePickerActivity imagePickerActivity = ImagePickerActivity.this;
            String f2 = mediaItem.f();
            s.g(f2, "mediaItem.filePath");
            imagePickerActivity.P0(f2, mediaItem.h());
        }
    }

    /* compiled from: ImagePickerActivity.kt */
    /* loaded from: classes5.dex */
    public static final class e extends PickPhotoSetAdapter {
        e() {
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoSetAdapter
        public void m(us.pinguo.picker.image.c mediaSetInfo) {
            s.h(mediaSetInfo, "mediaSetInfo");
            ImagePickerActivity.this.z0(mediaSetInfo);
        }
    }

    public ImagePickerActivity() {
        kotlin.f b2;
        b2 = h.b(new ImagePickerActivity$emptyView$2(this));
        this.m = b2;
    }

    private final View A0() {
        return (View) this.m.getValue();
    }

    private final void B0() {
        U0(true);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.vp_big_pic);
        viewPager.setVisibility(8);
        VdsAgent.onSetViewVisibility(viewPager, 8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.fl_title);
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_list);
        recyclerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView, 0);
        this.f11727i.notifyDataSetChanged();
    }

    private final void C0() {
        int height = ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).getHeight();
        if (height == 0) {
            return;
        }
        AnimatorSet animatorSet = this.f11724f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        RecyclerView recyclerView = this.f11722d;
        if (recyclerView == null) {
            s.z("photoSetView");
            throw null;
        }
        float[] fArr = new float[2];
        if (recyclerView != null) {
            fArr[0] = recyclerView.getTranslationY();
            fArr[1] = -height;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, "translationY", fArr);
            ValueAnimator ofInt = ValueAnimator.ofInt(((RotateImageView) _$_findCachedViewById(R.id.splice_arrow)).a(), BaseBlurEffect.ROTATION_360);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.picker.image.ui.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ImagePickerActivity.D0(ImagePickerActivity.this, valueAnimator);
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(300L);
            animatorSet2.play(ofFloat).with(ofInt);
            animatorSet2.start();
            animatorSet2.addListener(new b());
            this.f11724f = animatorSet2;
            return;
        }
        s.z("photoSetView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ImagePickerActivity this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((RotateImageView) this$0._$_findCachedViewById(R.id.splice_arrow)).setDegree(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(ImagePickerActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        ViewPager vp_big_pic = (ViewPager) this$0._$_findCachedViewById(R.id.vp_big_pic);
        s.g(vp_big_pic, "vp_big_pic");
        if (vp_big_pic.getVisibility() == 0) {
            this$0.B0();
        } else {
            this$0.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(ImagePickerActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        RecyclerView recyclerView = this$0.f11722d;
        if (recyclerView == null) {
            s.z("photoSetView");
            throw null;
        } else if (recyclerView.getVisibility() == 0) {
            this$0.C0();
        } else {
            this$0.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G0(String str) {
        Object obj;
        Iterator<T> it = this.f11725g.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (s.c(((PickItem) obj).path, str)) {
                break;
            }
        }
        return obj != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        startActivity(us.pinguo.foundation.b.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(final String str) {
        y.e(this.f11725g, new y.a() { // from class: us.pinguo.picker.image.ui.c
            @Override // us.pinguo.foundation.utils.y.a
            public final boolean test(Object obj) {
                boolean O0;
                O0 = ImagePickerActivity.O0(str, (PickItem) obj);
                return O0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(String path, PickItem pickItem) {
        s.h(path, "$path");
        return s.c(pickItem.path, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(String str, int i2) {
        Object obj;
        Iterator<T> it = this.f11725g.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (s.c(((PickItem) obj).path, str)) {
                break;
            }
        }
        if (obj == null) {
            this.f11725g.add(new PickItem(i2, str));
        }
    }

    private final void R0() {
        this.f11730l = true;
        TextView tvTip = (TextView) _$_findCachedViewById(R.id.tvTip);
        s.g(tvTip, "tvTip");
        tvTip.setVisibility(8);
        VdsAgent.onSetViewVisibility(tvTip, 8);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
        layoutParams.topToBottom = R.id.spacer;
        int i2 = R.id.gl_root;
        layoutParams.bottomToBottom = i2;
        ((ConstraintLayout) _$_findCachedViewById(i2)).addView(A0(), layoutParams);
    }

    private final void S0() {
        int height = ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).getHeight();
        if (height == 0) {
            return;
        }
        RecyclerView recyclerView = this.f11722d;
        if (recyclerView != null) {
            if (recyclerView.getVisibility() != 0) {
                RecyclerView recyclerView2 = this.f11722d;
                if (recyclerView2 == null) {
                    s.z("photoSetView");
                    throw null;
                }
                recyclerView2.setTranslationY(-height);
            }
            AnimatorSet animatorSet = this.f11724f;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(((RotateImageView) _$_findCachedViewById(R.id.splice_arrow)).a(), BaseBlurEffect.ROTATION_180);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.picker.image.ui.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ImagePickerActivity.T0(ImagePickerActivity.this, valueAnimator);
                }
            });
            RecyclerView recyclerView3 = this.f11722d;
            if (recyclerView3 == null) {
                s.z("photoSetView");
                throw null;
            }
            float[] fArr = new float[2];
            if (recyclerView3 != null) {
                fArr[0] = recyclerView3.getTranslationY();
                fArr[1] = 0.0f;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView3, "translationY", fArr);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(300L);
                animatorSet2.play(ofFloat).with(ofInt);
                animatorSet2.start();
                this.f11724f = animatorSet2;
                RecyclerView recyclerView4 = this.f11722d;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(0);
                    VdsAgent.onSetViewVisibility(recyclerView4, 0);
                    int g2 = this.f11728j.g();
                    if (g2 >= 0) {
                        RecyclerView recyclerView5 = this.f11722d;
                        if (recyclerView5 == null) {
                            s.z("photoSetView");
                            throw null;
                        }
                        RecyclerView.LayoutManager layoutManager = recyclerView5.getLayoutManager();
                        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(g2, 0);
                        return;
                    }
                    return;
                }
                s.z("photoSetView");
                throw null;
            }
            s.z("photoSetView");
            throw null;
        }
        s.z("photoSetView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ImagePickerActivity this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((RotateImageView) this$0._$_findCachedViewById(R.id.splice_arrow)).setDegree(((Integer) animatedValue).intValue());
    }

    private final void U0(boolean z) {
        if (z) {
            int i2 = R.id.tvTip;
            TextView tvTip = (TextView) _$_findCachedViewById(i2);
            s.g(tvTip, "tvTip");
            if (tvTip.getVisibility() == 0) {
                return;
            }
            TextView tvTip2 = (TextView) _$_findCachedViewById(i2);
            s.g(tvTip2, "tvTip");
            tvTip2.setVisibility(0);
            VdsAgent.onSetViewVisibility(tvTip2, 0);
            return;
        }
        int i3 = R.id.tvTip;
        TextView tvTip3 = (TextView) _$_findCachedViewById(i3);
        s.g(tvTip3, "tvTip");
        if (tvTip3.getVisibility() == 0) {
            TextView tvTip4 = (TextView) _$_findCachedViewById(i3);
            s.g(tvTip4, "tvTip");
            tvTip4.setVisibility(8);
            VdsAgent.onSetViewVisibility(tvTip4, 8);
        }
    }

    private final void initViews() {
        ((ImageView) _$_findCachedViewById(R.id.iv_back)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePickerActivity.E0(ImagePickerActivity.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.fl_title)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePickerActivity.F0(ImagePickerActivity.this, view);
            }
        });
        ImagePickerConfigModel imagePickerConfigModel = this.f11723e;
        if (imagePickerConfigModel != null) {
            if (imagePickerConfigModel.a() != null) {
                int i2 = R.id.tvTip;
                TextView tvTip = (TextView) _$_findCachedViewById(i2);
                s.g(tvTip, "tvTip");
                tvTip.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvTip, 0);
                TextView textView = (TextView) _$_findCachedViewById(i2);
                ImagePickerConfigModel imagePickerConfigModel2 = this.f11723e;
                if (imagePickerConfigModel2 == null) {
                    s.z("pickerConfigModel");
                    throw null;
                }
                textView.setText(imagePickerConfigModel2.a());
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.image_picker_item_space);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            RecyclerView rv_pic_list = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_list);
            s.g(rv_pic_list, "rv_pic_list");
            this.c = rv_pic_list;
            if (rv_pic_list != null) {
                rv_pic_list.setLayoutManager(gridLayoutManager);
                RecyclerView recyclerView = this.c;
                if (recyclerView == null) {
                    s.z("photoItemView");
                    throw null;
                }
                ImagePickerConfigModel imagePickerConfigModel3 = this.f11723e;
                if (imagePickerConfigModel3 != null) {
                    recyclerView.addItemDecoration(new us.pinguo.picker.image.h(dimensionPixelSize, imagePickerConfigModel3.b()));
                    RecyclerView recyclerView2 = this.c;
                    if (recyclerView2 != null) {
                        recyclerView2.setAdapter(this.f11727i);
                        RecyclerView rv_pic_set = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_set);
                        s.g(rv_pic_set, "rv_pic_set");
                        this.f11722d = rv_pic_set;
                        if (rv_pic_set != null) {
                            rv_pic_set.setLayoutManager(new LinearLayoutManager(this, 1, false));
                            RecyclerView recyclerView3 = this.f11722d;
                            if (recyclerView3 != null) {
                                recyclerView3.setAdapter(this.f11728j);
                                ((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).addOnPageChangeListener(new c());
                                return;
                            }
                            s.z("photoSetView");
                            throw null;
                        }
                        s.z("photoSetView");
                        throw null;
                    }
                    s.z("photoItemView");
                    throw null;
                }
                s.z("pickerConfigModel");
                throw null;
            }
            s.z("photoItemView");
            throw null;
        }
        s.z("pickerConfigModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(us.pinguo.picker.image.c cVar) {
        C0();
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.i(Integer.valueOf(cVar.c()));
        } else {
            s.z("photoPickData");
            throw null;
        }
    }

    @Override // us.pinguo.picker.image.d
    public void O(int i2, us.pinguo.picker.image.f pickInfo) {
        s.h(pickInfo, "pickInfo");
        this.f11728j.q(i2);
        int i3 = R.id.vp_big_pic;
        if (((ViewPager) _$_findCachedViewById(i3)).getVisibility() == 0) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.fl_title);
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.fl_title);
            constraintLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout2, 0);
        }
        ((TextView) _$_findCachedViewById(R.id.title_text_title)).setText(pickInfo.d().i());
        if (pickInfo.c().isEmpty()) {
            R0();
            return;
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_list);
        recyclerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView, 0);
        this.f11727i.x(pickInfo.c());
        ((ViewPager) _$_findCachedViewById(i3)).setOffscreenPageLimit(1);
        int currentItem = ((ViewPager) _$_findCachedViewById(i3)).getCurrentItem();
        ((ViewPager) _$_findCachedViewById(i3)).setAdapter(this.f11729k);
        ((ViewPager) _$_findCachedViewById(i3)).setCurrentItem(currentItem, false);
        if (this.f11730l) {
            this.f11730l = false;
            View emptyView = A0();
            s.g(emptyView, "emptyView");
            emptyView.setVisibility(8);
            VdsAgent.onSetViewVisibility(emptyView, 8);
        }
    }

    public final void Q0(m mediaItem, int i2) {
        s.h(mediaItem, "mediaItem");
        U0(false);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.fl_title);
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_list);
        recyclerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(recyclerView, 8);
        Iterator<PickItem> it = this.f11725g.iterator();
        while (it.hasNext() && !s.c(it.next().path, mediaItem.f())) {
        }
        int i3 = R.id.vp_big_pic;
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(i3);
        viewPager.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewPager, 0);
        ((ViewPager) _$_findCachedViewById(i3)).setCurrentItem(i2, false);
    }

    @Override // us.pinguo.picker.image.d
    public void T() {
        List<? extends m> h2;
        d dVar = this.f11727i;
        h2 = u.h();
        dVar.x(h2);
        this.f11729k.notifyDataSetChanged();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.picker.image.d
    public void h() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View decorView = getWindow().getDecorView();
        s.g(decorView, "this.window.decorView");
        int b2 = us.pinguo.util.h.b(decorView);
        if (b2 > 0) {
            View haircut = _$_findCachedViewById(R.id.haircut);
            s.g(haircut, "haircut");
            ViewGroup.LayoutParams layoutParams = haircut.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = b2;
            haircut.setLayoutParams(layoutParams2);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).getVisibility() == 0) {
            B0();
            return;
        }
        RecyclerView recyclerView = this.f11722d;
        if (recyclerView == null) {
            s.z("photoSetView");
            throw null;
        } else if (recyclerView.getVisibility() == 0) {
            C0();
        } else {
            us.pinguo.foundation.statistics.h.a.F("back_btn");
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        this.f11725g.clear();
        setContentView(R.layout.activity_image_picker);
        Parcelable parcelableExtra = getIntent().getParcelableExtra(ImagePickerConfigModel.EXTRA_DATA);
        s.e(parcelableExtra);
        s.g(parcelableExtra, "intent.getParcelableExtr…ConfigModel.EXTRA_DATA)!!");
        ImagePickerConfigModel imagePickerConfigModel = (ImagePickerConfigModel) parcelableExtra;
        this.f11723e = imagePickerConfigModel;
        d dVar = this.f11727i;
        if (imagePickerConfigModel != null) {
            dVar.w(imagePickerConfigModel);
            PhotoPickData photoPickData = new PhotoPickData();
            this.b = photoPickData;
            if (photoPickData != null) {
                photoPickData.s(this);
                PhotoPickData photoPickData2 = this.b;
                if (photoPickData2 != null) {
                    photoPickData2.j();
                    initViews();
                    this.f11727i.v(false);
                    this.f11728j.p(false);
                    g.a.g(false);
                    this.f11726h = false;
                    return;
                }
                s.z("photoPickData");
                throw null;
            }
            s.z("photoPickData");
            throw null;
        }
        s.z("pickerConfigModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g.a.g(true);
        this.f11727i.v(true);
        this.f11728j.p(true);
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.s(null);
            super.onDestroy();
            PhotoPickData photoPickData2 = this.b;
            if (photoPickData2 != null) {
                photoPickData2.k();
                return;
            } else {
                s.z("photoPickData");
                throw null;
            }
        }
        s.z("photoPickData");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.i(null);
            this.f11725g.clear();
            this.f11727i.notifyDataSetChanged();
            return;
        }
        s.z("photoPickData");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.q();
        } else {
            s.z("photoPickData");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ArrayList<? extends Parcelable> f2;
        super.onResume();
        if (v.j()) {
            PhotoPickData photoPickData = this.b;
            if (photoPickData == null) {
                s.z("photoPickData");
                throw null;
            }
            photoPickData.r();
        }
        requestCheckIsFullDisplay(-1);
        if (this.f11726h || v.j()) {
            return;
        }
        this.f11726h = true;
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "us.pinguo.inspire.PermissionBufferActivity");
        f2 = u.f(new PermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", true));
        intent.putParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE, f2);
        intent.putExtra("finishSelf", true);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        s.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Issue.ISSUE_REPORT_TAG, this.f11725g);
    }

    @Override // us.pinguo.picker.image.d
    public void p(List<us.pinguo.picker.image.c> mediaSetList) {
        s.h(mediaSetList, "mediaSetList");
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.fl_title);
        constraintLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout, 4);
        PickPhotoSetAdapter pickPhotoSetAdapter = this.f11728j;
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            pickPhotoSetAdapter.o(mediaSetList, photoPickData.m());
        } else {
            s.z("photoPickData");
            throw null;
        }
    }

    @Override // us.pinguo.picker.image.d
    public void u(us.pinguo.picker.image.c mediaSetInfo, int i2, int i3) {
        s.h(mediaSetInfo, "mediaSetInfo");
        this.f11728j.l(mediaSetInfo, i2, i3);
    }

    @Override // us.pinguo.picker.image.d
    public void w() {
    }
}
