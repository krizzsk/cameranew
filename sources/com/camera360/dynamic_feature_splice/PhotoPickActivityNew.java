package com.camera360.dynamic_feature_splice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.foundation.utils.y;
import us.pinguo.inspire.PermissionInfo;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.picker.image.PhotoPickData;
import us.pinguo.picker.image.PickItem;
import us.pinguo.picker.image.PickManager;
import us.pinguo.picker.image.adapter.PickPhotoItemAdapter;
import us.pinguo.picker.image.adapter.PickPhotoSetAdapter;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.picker.image.view.PinchImageView;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.RotateImageView;
/* compiled from: PhotoPickActivityNew.kt */
/* loaded from: classes8.dex */
public final class PhotoPickActivityNew extends BaseSplitActivity implements us.pinguo.foundation.statistics.e, us.pinguo.picker.image.d {
    private PhotoPickData b;
    private RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f2142d;

    /* renamed from: e  reason: collision with root package name */
    private AnimatorSet f2143e;

    /* renamed from: g  reason: collision with root package name */
    private PermissionManager f2145g;

    /* renamed from: h  reason: collision with root package name */
    private PickedPhotoPreviewAdapter f2146h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2147i;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<PickItem> f2144f = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private d f2148j = new d();

    /* renamed from: k  reason: collision with root package name */
    private PickPhotoSetAdapter f2149k = new e();

    /* renamed from: l  reason: collision with root package name */
    private a f2150l = new a(this);

    /* compiled from: PhotoPickActivityNew.kt */
    /* loaded from: classes8.dex */
    public final class a extends PagerAdapter {
        private final ArrayList<PinchImageView> a;
        final /* synthetic */ PhotoPickActivityNew b;

        public a(PhotoPickActivityNew this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            this.b = this$0;
            this.a = new ArrayList<>(0);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i2, Object object) {
            kotlin.jvm.internal.s.h(container, "container");
            kotlin.jvm.internal.s.h(object, "object");
            PinchImageView pinchImageView = (PinchImageView) object;
            pinchImageView.setImageBitmap(null);
            pinchImageView.H();
            container.removeView(pinchImageView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.f2148j.getItemCount();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            kotlin.jvm.internal.s.h(object, "object");
            int i2 = 0;
            for (us.pinguo.picker.image.gallery.m mVar : this.b.f2148j.i()) {
                if (kotlin.jvm.internal.s.c(((PinchImageView) object).getTag(), mVar.f())) {
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
            kotlin.jvm.internal.s.h(container, "container");
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
            String f2 = this.b.f2148j.i().get(i2).f();
            pinchImageView.setImageURI(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, f2));
            pinchImageView.setTag(f2);
            container.addView(pinchImageView);
            return pinchImageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(obj, "obj");
            return kotlin.jvm.internal.s.c(view, obj);
        }
    }

    /* compiled from: PhotoPickActivityNew.kt */
    /* loaded from: classes8.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RecyclerView recyclerView = PhotoPickActivityNew.this.f2142d;
            if (recyclerView != null) {
                recyclerView.setVisibility(4);
            } else {
                kotlin.jvm.internal.s.z("photoSetView");
                throw null;
            }
        }
    }

    /* compiled from: PhotoPickActivityNew.kt */
    /* loaded from: classes8.dex */
    public static final class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                ArrayList arrayList = PhotoPickActivityNew.this.f2144f;
                PhotoPickActivityNew photoPickActivityNew = PhotoPickActivityNew.this;
                int i3 = 0;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    } else if (kotlin.jvm.internal.s.c(photoPickActivityNew.f2148j.i().get(((ViewPager) photoPickActivityNew._$_findCachedViewById(R.id.vp_big_pic)).getCurrentItem()).f(), ((PickItem) it.next()).path)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 > -1) {
                    ((ImageView) PhotoPickActivityNew.this._$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.splice_check_selected);
                } else {
                    ((ImageView) PhotoPickActivityNew.this._$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.ic_splice_select_label_gray);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    /* compiled from: PhotoPickActivityNew.kt */
    /* loaded from: classes8.dex */
    public static final class d extends PickPhotoItemAdapter {
        d() {
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public boolean k(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            if (PhotoPickActivityNew.this.f2144f.size() >= 6) {
                us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
                String string = PhotoPickActivityNew.this.getResources().getString(vStudio.Android.Camera360.R.string.pick_max_waring, 6);
                kotlin.jvm.internal.s.g(string, "resources.getString(R.st…waring, PICK_PHOTO_COUNT)");
                k0Var.d(string);
                return false;
            }
            return super.k(holder, mediaItem, i2);
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public boolean l(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PhotoPickActivityNew photoPickActivityNew = PhotoPickActivityNew.this;
            String f2 = mediaItem.f();
            kotlin.jvm.internal.s.g(f2, "mediaItem.filePath");
            return photoPickActivityNew.O0(f2);
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void s(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PhotoPickActivityNew photoPickActivityNew = PhotoPickActivityNew.this;
            String f2 = mediaItem.f();
            kotlin.jvm.internal.s.g(f2, "mediaItem.filePath");
            photoPickActivityNew.b1(f2);
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = PhotoPickActivityNew.this.f2146h;
            if (pickedPhotoPreviewAdapter != null) {
                String f3 = mediaItem.f();
                kotlin.jvm.internal.s.g(f3, "mediaItem.filePath");
                pickedPhotoPreviewAdapter.h(f3);
                ((TextView) PhotoPickActivityNew.this._$_findCachedViewById(R.id.txt_pick_num)).setText(String.valueOf(pickedPhotoPreviewAdapter.getItemCount()));
                if (pickedPhotoPreviewAdapter.getItemCount() == 0) {
                    PhotoPickActivityNew.this.B0();
                }
                us.pinguo.foundation.statistics.h.a.F("un_select_pic");
                return;
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void t(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PhotoPickActivityNew.this.e1(mediaItem, i2);
            us.pinguo.foundation.statistics.h.a.F("preview_pic");
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoItemAdapter
        public void u(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
            PhotoPickActivityNew photoPickActivityNew = PhotoPickActivityNew.this;
            String f2 = mediaItem.f();
            kotlin.jvm.internal.s.g(f2, "mediaItem.filePath");
            photoPickActivityNew.d1(f2, mediaItem.h());
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = PhotoPickActivityNew.this.f2146h;
            if (pickedPhotoPreviewAdapter != null) {
                if (pickedPhotoPreviewAdapter.getItemCount() == 0) {
                    PhotoPickActivityNew.this.C0();
                }
                Object obj = PhotoPickActivityNew.this.f2144f.get(PhotoPickActivityNew.this.f2144f.size() - 1);
                kotlin.jvm.internal.s.g(obj, "selectedItems[selectedItems.size - 1]");
                pickedPhotoPreviewAdapter.f((PickItem) obj);
                ((RecyclerView) PhotoPickActivityNew.this._$_findCachedViewById(R.id.rv_pick_preview)).scrollToPosition(pickedPhotoPreviewAdapter.getItemCount() - 1);
                ((TextView) PhotoPickActivityNew.this._$_findCachedViewById(R.id.txt_pick_num)).setText(String.valueOf(pickedPhotoPreviewAdapter.getItemCount()));
                return;
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }
    }

    /* compiled from: PhotoPickActivityNew.kt */
    /* loaded from: classes8.dex */
    public static final class e extends PickPhotoSetAdapter {
        e() {
        }

        @Override // us.pinguo.picker.image.adapter.PickPhotoSetAdapter
        public void m(us.pinguo.picker.image.c mediaSetInfo) {
            kotlin.jvm.internal.s.h(mediaSetInfo, "mediaSetInfo");
            PhotoPickActivityNew.this.A0(mediaSetInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(us.pinguo.picker.image.c cVar) {
        H0();
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.i(Integer.valueOf(cVar.c()));
        } else {
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        ((RelativeLayout) _$_findCachedViewById(R.id.rl_pick_bottom_preview_tips)).setBackgroundColor(Color.parseColor("#EEEEEE"));
        int i2 = R.id.rl_toggle_splice;
        ((RelativeLayout) _$_findCachedViewById(i2)).setBackgroundResource(vStudio.Android.Camera360.R.drawable.radius19_gray_bg);
        ((AutofitTextView) _$_findCachedViewById(R.id.txt_pick_tips)).setTextColor(Color.parseColor("#999999"));
        ((TextView) _$_findCachedViewById(R.id.txt_pick_num)).setTextColor(Color.parseColor("#999999"));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pick_preview)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.txt_no_picked_tips)).setVisibility(0);
        ((RelativeLayout) _$_findCachedViewById(i2)).setOnClickListener(null);
        int i3 = R.id.title_right_btn;
        ((TextView) _$_findCachedViewById(i3)).setEnabled(false);
        ((TextView) _$_findCachedViewById(i3)).setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        ((RelativeLayout) _$_findCachedViewById(R.id.rl_pick_bottom_preview_tips)).setBackgroundColor(Color.parseColor("#FFF5CF"));
        int i2 = R.id.rl_toggle_splice;
        ((RelativeLayout) _$_findCachedViewById(i2)).setBackgroundResource(vStudio.Android.Camera360.R.drawable.radius19_sunyellow_bg);
        ((AutofitTextView) _$_findCachedViewById(R.id.txt_pick_tips)).setTextColor(Color.parseColor("#C28624"));
        ((TextView) _$_findCachedViewById(R.id.txt_pick_num)).setTextColor(Color.parseColor("#F5A623"));
        ((TextView) _$_findCachedViewById(R.id.txt_no_picked_tips)).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pick_preview)).setVisibility(0);
        ((RelativeLayout) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.D0(PhotoPickActivityNew.this, view);
            }
        });
        int i3 = R.id.title_right_btn;
        ((TextView) _$_findCachedViewById(i3)).setEnabled(true);
        ((TextView) _$_findCachedViewById(i3)).setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.F0();
    }

    private final void E0() {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "us.pinguo.inspire.PermissionBufferActivity");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(new PermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", true));
        intent.putParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE, arrayList);
        intent.putExtra("finishSelf", true);
        startActivity(intent);
    }

    private final void F0() {
        us.pinguo.foundation.statistics.h.a.F("splice_btn");
        ArrayList<PickItem> arrayList = this.f2144f;
        int size = arrayList.size();
        PickItem[] pickItemArr = new PickItem[size];
        for (int i2 = 0; i2 < size; i2++) {
            pickItemArr[i2] = arrayList.get(i2);
        }
        Intent intent = new Intent(this, SpliceActivity.class);
        intent.putExtra("splices", pickItemArr);
        startActivityForResult(intent, 1001);
    }

    private final void G0() {
        ((ImageView) _$_findCachedViewById(R.id.title_right_btn_select_label)).setVisibility(8);
        ((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.title_right_btn)).setVisibility(0);
        ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).setVisibility(0);
        this.f2148j.notifyDataSetChanged();
    }

    private final void H0() {
        int height = ((FrameLayout) _$_findCachedViewById(R.id.layout_pick)).getHeight();
        if (height == 0) {
            return;
        }
        AnimatorSet animatorSet = this.f2143e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        RecyclerView recyclerView = this.f2142d;
        if (recyclerView == null) {
            kotlin.jvm.internal.s.z("photoSetView");
            throw null;
        }
        float[] fArr = new float[2];
        if (recyclerView != null) {
            fArr[0] = recyclerView.getTranslationY();
            fArr[1] = -height;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, "translationY", fArr);
            ValueAnimator ofInt = ValueAnimator.ofInt(((RotateImageView) _$_findCachedViewById(R.id.splice_arrow)).a(), BaseBlurEffect.ROTATION_360);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PhotoPickActivityNew.I0(PhotoPickActivityNew.this, valueAnimator);
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(300L);
            animatorSet2.play(ofFloat).with(ofInt);
            animatorSet2.start();
            animatorSet2.addListener(new b());
            this.f2143e = animatorSet2;
            return;
        }
        kotlin.jvm.internal.s.z("photoSetView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(PhotoPickActivityNew this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((RotateImageView) this$0._$_findCachedViewById(R.id.splice_arrow)).setDegree(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.picker.image.gallery.m mVar = this$0.f2148j.i().get(((ViewPager) this$0._$_findCachedViewById(R.id.vp_big_pic)).getCurrentItem());
        PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this$0.f2146h;
        if (pickedPhotoPreviewAdapter != null) {
            String f2 = mVar.f();
            kotlin.jvm.internal.s.g(f2, "mediaItem.filePath");
            if (this$0.O0(f2)) {
                String f3 = mVar.f();
                kotlin.jvm.internal.s.g(f3, "mediaItem.filePath");
                this$0.b1(f3);
                ((ImageView) this$0._$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.ic_splice_select_label_gray);
                String f4 = mVar.f();
                kotlin.jvm.internal.s.g(f4, "mediaItem.filePath");
                pickedPhotoPreviewAdapter.h(f4);
                if (pickedPhotoPreviewAdapter.getItemCount() == 0) {
                    this$0.B0();
                }
            } else if (this$0.f2144f.size() >= 6) {
                us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
                String string = this$0.getResources().getString(vStudio.Android.Camera360.R.string.pick_max_waring, 6);
                kotlin.jvm.internal.s.g(string, "resources.getString(R.st…waring, PICK_PHOTO_COUNT)");
                k0Var.d(string);
                return;
            } else {
                int g2 = mVar.g();
                int j2 = mVar.j();
                if (g2 == 0 && j2 == 0) {
                    String f5 = mVar.f();
                    kotlin.jvm.internal.s.g(f5, "mediaItem.filePath");
                    Point m = us.pinguo.util.e.m(f5);
                    j2 = m.x;
                    g2 = m.y;
                }
                PickManager pickManager = PickManager.a;
                String f6 = mVar.f();
                kotlin.jvm.internal.s.g(f6, "mediaItem.filePath");
                if (kotlin.jvm.internal.s.c(pickManager.e(j2, g2, f6), Boolean.FALSE)) {
                    us.pinguo.foundation.utils.k0 k0Var2 = us.pinguo.foundation.utils.k0.a;
                    String string2 = this$0.getResources().getString(vStudio.Android.Camera360.R.string.pick_small_waring);
                    kotlin.jvm.internal.s.g(string2, "resources.getString(R.string.pick_small_waring)");
                    k0Var2.d(string2);
                    return;
                }
                String f7 = mVar.f();
                kotlin.jvm.internal.s.g(f7, "mediaItem.filePath");
                this$0.d1(f7, mVar.h());
                ((ImageView) this$0._$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.splice_check_selected);
                if (pickedPhotoPreviewAdapter.getItemCount() == 0) {
                    this$0.C0();
                }
                ArrayList<PickItem> arrayList = this$0.f2144f;
                PickItem pickItem = arrayList.get(arrayList.size() - 1);
                kotlin.jvm.internal.s.g(pickItem, "selectedItems[selectedItems.size - 1]");
                pickedPhotoPreviewAdapter.f(pickItem);
                ((RecyclerView) this$0._$_findCachedViewById(R.id.rv_pick_preview)).scrollToPosition(pickedPhotoPreviewAdapter.getItemCount() - 1);
            }
            ((TextView) this$0._$_findCachedViewById(R.id.txt_pick_num)).setText(String.valueOf(pickedPhotoPreviewAdapter.getItemCount()));
            return;
        }
        kotlin.jvm.internal.s.z("previewAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (((ViewPager) this$0._$_findCachedViewById(R.id.vp_big_pic)).getVisibility() == 0) {
            this$0.G0();
        } else {
            this$0.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f2144f.isEmpty()) {
            return;
        }
        PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this$0.f2146h;
        if (pickedPhotoPreviewAdapter == null) {
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        } else if (pickedPhotoPreviewAdapter.getItemCount() != 0) {
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter2 = this$0.f2146h;
            if (pickedPhotoPreviewAdapter2 != null) {
                pickedPhotoPreviewAdapter2.g();
                ArrayList<PickItem> arrayList = this$0.f2144f;
                ArrayList<Number> arrayList2 = new ArrayList();
                int i2 = 0;
                for (Object obj : this$0.f2148j.i()) {
                    int i3 = i2 + 1;
                    if (i2 >= 0) {
                        String f2 = ((us.pinguo.picker.image.gallery.m) obj).f();
                        Iterator<PickItem> it = arrayList.iterator();
                        int i4 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i4 = -1;
                                break;
                            } else if (kotlin.jvm.internal.s.c(it.next().path, f2)) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 > -1) {
                            arrayList2.add(Integer.valueOf(i2));
                        }
                        i2 = i3;
                    } else {
                        kotlin.collections.s.n();
                        throw null;
                    }
                }
                arrayList.clear();
                for (Number number : arrayList2) {
                    this$0.f2148j.notifyItemChanged(number.intValue());
                }
                this$0.B0();
                TextView textView = (TextView) this$0._$_findCachedViewById(R.id.txt_pick_num);
                PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter3 = this$0.f2146h;
                if (pickedPhotoPreviewAdapter3 != null) {
                    textView.setText(String.valueOf(pickedPhotoPreviewAdapter3.getItemCount()));
                    us.pinguo.foundation.statistics.h.a.F("clear_btn");
                    return;
                }
                kotlin.jvm.internal.s.z("previewAdapter");
                throw null;
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        RecyclerView recyclerView = this$0.f2142d;
        if (recyclerView == null) {
            kotlin.jvm.internal.s.z("photoSetView");
            throw null;
        } else if (recyclerView.getVisibility() == 0) {
            this$0.H0();
        } else {
            this$0.h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O0(String str) {
        Object obj;
        Iterator<T> it = this.f2144f.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.s.c(((PickItem) obj).path, str)) {
                break;
            }
        }
        return obj != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(PhotoPickActivityNew this$0, String[] strArr, String[] strArr2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.util.v.j()) {
            PhotoPickData photoPickData = this$0.b;
            if (photoPickData != null) {
                photoPickData.r();
                return;
            } else {
                kotlin.jvm.internal.s.z("photoPickData");
                throw null;
            }
        }
        this$0.E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(final String str) {
        us.pinguo.foundation.utils.y.e(this.f2144f, new y.a() { // from class: com.camera360.dynamic_feature_splice.l
            @Override // us.pinguo.foundation.utils.y.a
            public final boolean test(Object obj) {
                boolean c1;
                c1 = PhotoPickActivityNew.c1(str, (PickItem) obj);
                return c1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c1(String path, PickItem pickItem) {
        kotlin.jvm.internal.s.h(path, "$path");
        return kotlin.jvm.internal.s.c(pickItem.path, path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(String str, int i2) {
        Object obj;
        Iterator<T> it = this.f2144f.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.s.c(((PickItem) obj).path, str)) {
                break;
            }
        }
        if (obj == null) {
            this.f2144f.add(new PickItem(i2, str));
        }
    }

    private final void f1() {
        int i2 = R.id.title_right_btn;
        ((TextView) _$_findCachedViewById(i2)).setEnabled(false);
        ((TextView) _$_findCachedViewById(i2)).setClickable(false);
        int i3 = R.id.layout_no_photo;
        ((FrameLayout) _$_findCachedViewById(i3)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).setVisibility(4);
        ((FrameLayout) _$_findCachedViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.g1(PhotoPickActivityNew.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(PhotoPickActivityNew this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setAction("destroy");
        this$0.sendBroadcast(intent);
        Intent intent2 = new Intent();
        intent2.setClassName(this$0, "us.pinguo.camera2020.activity.Camera2020Activity");
        intent2.setFlags(603979776);
        intent2.putExtra("bundle_key_mode", "c205e3582b514d6fb5c21a953e1e901e");
    }

    private final void h1() {
        int height = ((FrameLayout) _$_findCachedViewById(R.id.layout_pick)).getHeight();
        if (height == 0) {
            return;
        }
        RecyclerView recyclerView = this.f2142d;
        if (recyclerView != null) {
            if (recyclerView.getVisibility() != 0) {
                RecyclerView recyclerView2 = this.f2142d;
                if (recyclerView2 == null) {
                    kotlin.jvm.internal.s.z("photoSetView");
                    throw null;
                }
                recyclerView2.setTranslationY(-height);
            }
            AnimatorSet animatorSet = this.f2143e;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(((RotateImageView) _$_findCachedViewById(R.id.splice_arrow)).a(), BaseBlurEffect.ROTATION_180);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PhotoPickActivityNew.i1(PhotoPickActivityNew.this, valueAnimator);
                }
            });
            RecyclerView recyclerView3 = this.f2142d;
            if (recyclerView3 == null) {
                kotlin.jvm.internal.s.z("photoSetView");
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
                this.f2143e = animatorSet2;
                RecyclerView recyclerView4 = this.f2142d;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(0);
                    int g2 = this.f2149k.g();
                    if (g2 >= 0) {
                        RecyclerView recyclerView5 = this.f2142d;
                        if (recyclerView5 == null) {
                            kotlin.jvm.internal.s.z("photoSetView");
                            throw null;
                        }
                        RecyclerView.LayoutManager layoutManager = recyclerView5.getLayoutManager();
                        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(g2, 0);
                        return;
                    }
                    return;
                }
                kotlin.jvm.internal.s.z("photoSetView");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoSetView");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoSetView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(PhotoPickActivityNew this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((RotateImageView) this$0._$_findCachedViewById(R.id.splice_arrow)).setDegree(((Integer) animatedValue).intValue());
    }

    private final void initViews() {
        ((ImageView) _$_findCachedViewById(R.id.title_right_btn_select_label)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.J0(PhotoPickActivityNew.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.title_back_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.K0(PhotoPickActivityNew.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.title_right_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.L0(PhotoPickActivityNew.this, view);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPickActivityNew.M0(PhotoPickActivityNew.this, view);
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.image_picker_item_space);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        RecyclerView rv_pic_list = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_list);
        kotlin.jvm.internal.s.g(rv_pic_list, "rv_pic_list");
        this.c = rv_pic_list;
        if (rv_pic_list != null) {
            rv_pic_list.setLayoutManager(gridLayoutManager);
            RecyclerView recyclerView = this.c;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(new us.pinguo.picker.image.h(dimensionPixelSize, false, 2, null));
                RecyclerView recyclerView2 = this.c;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(this.f2148j);
                    RecyclerView rv_pic_set = (RecyclerView) _$_findCachedViewById(R.id.rv_pic_set);
                    kotlin.jvm.internal.s.g(rv_pic_set, "rv_pic_set");
                    this.f2142d = rv_pic_set;
                    Drawable drawable = ContextCompat.getDrawable(this, vStudio.Android.Camera360.R.drawable.pick_set_divider);
                    if (drawable != null) {
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
                        dividerItemDecoration.setDrawable(drawable);
                        RecyclerView recyclerView3 = this.f2142d;
                        if (recyclerView3 == null) {
                            kotlin.jvm.internal.s.z("photoSetView");
                            throw null;
                        }
                        recyclerView3.addItemDecoration(dividerItemDecoration);
                    }
                    RecyclerView recyclerView4 = this.f2142d;
                    if (recyclerView4 != null) {
                        recyclerView4.setLayoutManager(new LinearLayoutManager(this, 1, false));
                        RecyclerView recyclerView5 = this.f2142d;
                        if (recyclerView5 != null) {
                            recyclerView5.setAdapter(this.f2149k);
                            RecyclerView recyclerView6 = this.f2142d;
                            if (recyclerView6 != null) {
                                recyclerView6.addItemDecoration(new us.pinguo.picker.image.i(getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_set_space)));
                                RecyclerView recyclerView7 = this.f2142d;
                                if (recyclerView7 != null) {
                                    recyclerView7.setOnClickListener(p.a);
                                    this.f2146h = new PickedPhotoPreviewAdapter();
                                    int i2 = R.id.rv_pick_preview;
                                    RecyclerView recyclerView8 = (RecyclerView) _$_findCachedViewById(i2);
                                    PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
                                    if (pickedPhotoPreviewAdapter != null) {
                                        recyclerView8.setAdapter(pickedPhotoPreviewAdapter);
                                        ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(new LinearLayoutManager(this, 0, false));
                                        ((RecyclerView) _$_findCachedViewById(i2)).addItemDecoration(new h1());
                                        ((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).addOnPageChangeListener(new c());
                                        return;
                                    }
                                    kotlin.jvm.internal.s.z("previewAdapter");
                                    throw null;
                                }
                                kotlin.jvm.internal.s.z("photoSetView");
                                throw null;
                            }
                            kotlin.jvm.internal.s.z("photoSetView");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("photoSetView");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("photoSetView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("photoItemView");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoItemView");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoItemView");
        throw null;
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "splice_select_pic_page";
    }

    @Override // us.pinguo.picker.image.d
    public void O(int i2, us.pinguo.picker.image.f pickInfo) {
        kotlin.jvm.internal.s.h(pickInfo, "pickInfo");
        this.f2149k.q(i2);
        int i3 = R.id.vp_big_pic;
        if (((ViewPager) _$_findCachedViewById(i3)).getVisibility() == 0) {
            ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setVisibility(8);
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setVisibility(0);
        }
        ((TextView) _$_findCachedViewById(R.id.title_text_title)).setText(pickInfo.d().i());
        if (pickInfo.c().isEmpty()) {
            f1();
            return;
        }
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).setVisibility(0);
        this.f2148j.x(pickInfo.c());
        PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
        if (pickedPhotoPreviewAdapter != null) {
            pickedPhotoPreviewAdapter.p(this.f2144f);
            if (pickedPhotoPreviewAdapter.getItemCount() > 0) {
                C0();
            } else {
                B0();
            }
            ((ViewPager) _$_findCachedViewById(i3)).setOffscreenPageLimit(1);
            int currentItem = ((ViewPager) _$_findCachedViewById(i3)).getCurrentItem();
            ((ViewPager) _$_findCachedViewById(i3)).setAdapter(this.f2150l);
            ((ViewPager) _$_findCachedViewById(i3)).setCurrentItem(currentItem, false);
            ((FrameLayout) _$_findCachedViewById(R.id.layout_no_photo)).setVisibility(4);
            return;
        }
        kotlin.jvm.internal.s.z("previewAdapter");
        throw null;
    }

    @Override // us.pinguo.picker.image.d
    public void T() {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        d dVar = this.f2148j;
        h2 = kotlin.collections.u.h();
        dVar.x(h2);
        this.f2150l.notifyDataSetChanged();
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

    public final void e1(us.pinguo.picker.image.gallery.m mediaItem, int i2) {
        kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
        ((TextView) _$_findCachedViewById(R.id.title_right_btn)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.title_right_btn_select_label)).setVisibility(0);
        ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pic_list)).setVisibility(8);
        Iterator<PickItem> it = this.f2144f.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (kotlin.jvm.internal.s.c(it.next().path, mediaItem.f())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 > -1) {
            ((ImageView) _$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.splice_check_selected);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.ic_splice_select_label_gray);
        }
        int i4 = R.id.vp_big_pic;
        ((ViewPager) _$_findCachedViewById(i4)).setVisibility(0);
        ((ViewPager) _$_findCachedViewById(i4)).setCurrentItem(i2, false);
    }

    @Override // us.pinguo.picker.image.d
    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Parcelable[] parcelableArrayExtra;
        ArrayList arrayList;
        PermissionManager permissionManager = this.f2145g;
        if (permissionManager != null) {
            permissionManager.r(i2, i3, intent);
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1001) {
                if (((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).getVisibility() == 0) {
                    G0();
                }
                if (i3 == -1) {
                    if (intent == null || (parcelableArrayExtra = intent.getParcelableArrayExtra("splices")) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(parcelableArrayExtra.length);
                        for (Parcelable parcelable : parcelableArrayExtra) {
                            Objects.requireNonNull(parcelable, "null cannot be cast to non-null type us.pinguo.picker.image.PickItem");
                            arrayList.add((PickItem) parcelable);
                        }
                    }
                    if (arrayList != null && (!arrayList.isEmpty())) {
                        this.f2144f.clear();
                        this.f2144f.addAll(arrayList);
                        this.f2148j.notifyDataSetChanged();
                        PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
                        if (pickedPhotoPreviewAdapter == null) {
                            kotlin.jvm.internal.s.z("previewAdapter");
                            throw null;
                        }
                        pickedPhotoPreviewAdapter.p(this.f2144f);
                    }
                }
            }
            if (i2 == 120 && i3 == -1 && intent != null) {
                intent.getParcelableArrayListExtra(ImagePickerConfigModel.RESULT_DATA);
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((ViewPager) _$_findCachedViewById(R.id.vp_big_pic)).getVisibility() == 0) {
            G0();
            return;
        }
        RecyclerView recyclerView = this.f2142d;
        if (recyclerView == null) {
            kotlin.jvm.internal.s.z("photoSetView");
            throw null;
        } else if (recyclerView.getVisibility() == 0) {
            H0();
        } else {
            us.pinguo.foundation.statistics.h.a.F("back_btn");
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2144f.clear();
        ArrayList parcelableArrayList = bundle == null ? null : bundle.getParcelableArrayList("splices");
        if (parcelableArrayList != null) {
            this.f2144f.addAll(parcelableArrayList);
        }
        setContentView(vStudio.Android.Camera360.R.layout.activity_photo_pick_new);
        PhotoPickData photoPickData = new PhotoPickData();
        this.b = photoPickData;
        if (photoPickData != null) {
            photoPickData.s(this);
            PhotoPickData photoPickData2 = this.b;
            if (photoPickData2 != null) {
                photoPickData2.j();
                initViews();
                PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
                if (pickedPhotoPreviewAdapter != null) {
                    pickedPhotoPreviewAdapter.q(false);
                    this.f2148j.v(false);
                    this.f2149k.p(false);
                    us.pinguo.picker.image.g.a.g(false);
                    PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter2 = this.f2146h;
                    if (pickedPhotoPreviewAdapter2 != null) {
                        pickedPhotoPreviewAdapter2.r(new PhotoPickActivityNew$onCreate$1(this));
                        this.f2147i = false;
                        PermissionManager permissionManager = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
                        this.f2145g = permissionManager;
                        if (permissionManager != null) {
                            permissionManager.w("android.permission.WRITE_EXTERNAL_STORAGE");
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("permissionManager");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.s.z("previewAdapter");
                    throw null;
                }
                kotlin.jvm.internal.s.z("previewAdapter");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoPickData");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.picker.image.g.a.g(true);
        PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
        if (pickedPhotoPreviewAdapter != null) {
            pickedPhotoPreviewAdapter.q(true);
            this.f2148j.v(true);
            this.f2149k.p(true);
            PhotoPickData photoPickData = this.b;
            if (photoPickData != null) {
                photoPickData.s(null);
                PermissionManager permissionManager = this.f2145g;
                if (permissionManager != null) {
                    permissionManager.d();
                    super.onDestroy();
                    PhotoPickData photoPickData2 = this.b;
                    if (photoPickData2 != null) {
                        photoPickData2.k();
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("photoPickData");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("permissionManager");
                throw null;
            }
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
        kotlin.jvm.internal.s.z("previewAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            photoPickData.i(null);
            this.f2144f.clear();
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
            if (pickedPhotoPreviewAdapter != null) {
                pickedPhotoPreviewAdapter.p(this.f2144f);
                this.f2148j.notifyDataSetChanged();
                return;
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }
        kotlin.jvm.internal.s.z("photoPickData");
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
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        PermissionManager permissionManager = this.f2145g;
        if (permissionManager != null) {
            permissionManager.s(i2, permissions, grantResults);
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PermissionManager permissionManager = this.f2145g;
        if (permissionManager != null) {
            permissionManager.v();
            if (us.pinguo.util.v.j()) {
                PhotoPickData photoPickData = this.b;
                if (photoPickData == null) {
                    kotlin.jvm.internal.s.z("photoPickData");
                    throw null;
                }
                photoPickData.r();
            }
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.f2146h;
            if (pickedPhotoPreviewAdapter != null) {
                if (pickedPhotoPreviewAdapter.getItemCount() > 0 && this.f2144f.isEmpty()) {
                    pickedPhotoPreviewAdapter.g();
                    B0();
                    ((TextView) _$_findCachedViewById(R.id.txt_pick_num)).setText(String.valueOf(pickedPhotoPreviewAdapter.getItemCount()));
                }
                if (!this.f2147i) {
                    PermissionManager permissionManager2 = this.f2145g;
                    if (permissionManager2 == null) {
                        kotlin.jvm.internal.s.z("permissionManager");
                        throw null;
                    } else if (!permissionManager2.p("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        PermissionManager permissionManager3 = this.f2145g;
                        if (permissionManager3 == null) {
                            kotlin.jvm.internal.s.z("permissionManager");
                            throw null;
                        } else if (!permissionManager3.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            this.f2147i = true;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                            if (arrayList.size() > 0) {
                                PermissionManager permissionManager4 = this.f2145g;
                                if (permissionManager4 == null) {
                                    kotlin.jvm.internal.s.z("permissionManager");
                                    throw null;
                                }
                                us.pinguo.permissionlib.c.a aVar = new us.pinguo.permissionlib.c.a() { // from class: com.camera360.dynamic_feature_splice.q
                                    @Override // us.pinguo.permissionlib.c.a
                                    public final void a(String[] strArr, String[] strArr2) {
                                        PhotoPickActivityNew.a1(PhotoPickActivityNew.this, strArr, strArr2);
                                    }
                                };
                                Object[] array = arrayList.toArray(new String[0]);
                                kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                String[] strArr = (String[]) array;
                                permissionManager4.t(aVar, true, (String[]) Arrays.copyOf(strArr, strArr.length));
                                return;
                            }
                            return;
                        }
                    }
                }
                if (this.f2147i) {
                    return;
                }
                PermissionManager permissionManager5 = this.f2145g;
                if (permissionManager5 == null) {
                    kotlin.jvm.internal.s.z("permissionManager");
                    throw null;
                } else if (permissionManager5.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    this.f2147i = true;
                    E0();
                    return;
                } else {
                    return;
                }
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.s.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("splices", this.f2144f);
    }

    @Override // us.pinguo.picker.image.d
    public void p(List<us.pinguo.picker.image.c> mediaSetList) {
        kotlin.jvm.internal.s.h(mediaSetList, "mediaSetList");
        ((LinearLayout) _$_findCachedViewById(R.id.title_layout)).setVisibility(4);
        PickPhotoSetAdapter pickPhotoSetAdapter = this.f2149k;
        PhotoPickData photoPickData = this.b;
        if (photoPickData != null) {
            pickPhotoSetAdapter.o(mediaSetList, photoPickData.m());
        } else {
            kotlin.jvm.internal.s.z("photoPickData");
            throw null;
        }
    }

    @Override // us.pinguo.picker.image.d
    public void u(us.pinguo.picker.image.c mediaSetInfo, int i2, int i3) {
        kotlin.jvm.internal.s.h(mediaSetInfo, "mediaSetInfo");
        this.f2149k.l(mediaSetInfo, i2, i3);
    }

    @Override // us.pinguo.picker.image.d
    public void w() {
        f1();
    }
}
