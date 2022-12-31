package us.pinguo.inspire.widget.photopager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.c;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.ArrayList;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* compiled from: AnimTouchImageAdapter.java */
/* loaded from: classes9.dex */
public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private f a;
    private ArrayList<FullScreenPhoto> b;
    private ImageLoader c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f11407d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<ImageView> f11408e;

    /* renamed from: f  reason: collision with root package name */
    private Context f11409f;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f11411h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11412i;

    /* renamed from: k  reason: collision with root package name */
    private com.nostra13.universalimageloader.core.c f11414k;

    /* renamed from: l  reason: collision with root package name */
    private com.nostra13.universalimageloader.core.c f11415l;
    private View.OnClickListener m;
    private ViewPager.OnPageChangeListener n;

    /* renamed from: g  reason: collision with root package name */
    private int f11410g = us.pinguo.foundation.t.b.a.j(Inspire.a());

    /* renamed from: j  reason: collision with root package name */
    private boolean f11413j = true;

    /* compiled from: AnimTouchImageAdapter.java */
    /* renamed from: us.pinguo.inspire.widget.photopager.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class View$OnClickListenerC0410a implements View.OnClickListener {
        View$OnClickListenerC0410a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBar supportActionBar;
            if (a.this.f11411h != null) {
                a.this.f11411h.dismiss();
            } else if (!(a.this.f11409f instanceof AppCompatActivity) || (supportActionBar = ((AppCompatActivity) a.this.f11409f).getSupportActionBar()) == null) {
            } else {
                if (supportActionBar.isShowing()) {
                    supportActionBar.hide();
                } else {
                    supportActionBar.show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public class b implements com.nostra13.universalimageloader.core.k.a {
        final /* synthetic */ boolean a;
        final /* synthetic */ ProgressWheel b;

        b(a aVar, boolean z, ProgressWheel progressWheel) {
            this.a = z;
            this.b = progressWheel;
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingCancelled(String str, View view) {
            this.b.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.b.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.b.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingStarted(String str, View view) {
            if (this.a) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public class c extends com.nostra13.universalimageloader.core.k.c {
        final /* synthetic */ ProgressWheel a;

        c(a aVar, ProgressWheel progressWheel) {
            this.a = progressWheel;
        }

        @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
        public void onLoadingCancelled(String str, View view) {
            super.onLoadingCancelled(str, view);
            this.a.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            super.onLoadingComplete(str, view, bitmap);
            this.a.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            super.onLoadingFailed(str, view, failReason);
            this.a.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FullScreenImageView a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ Rect c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Rect f11416d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TouchImageView f11417e;

        d(FullScreenImageView fullScreenImageView, ViewGroup viewGroup, Rect rect, Rect rect2, TouchImageView touchImageView) {
            this.a = fullScreenImageView;
            this.b = viewGroup;
            this.c = rect;
            this.f11416d = rect2;
            this.f11417e = touchImageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.this.a != null) {
                a.this.a.onAnimUpdate(floatValue, this.a);
            }
            int[] iArr = new int[2];
            this.b.getLocationInWindow(iArr);
            this.b.setBackgroundColor(Color.argb((int) (255.0f * floatValue), 0, 0, 0));
            int f2 = a.f(this.c.left, this.f11416d.left, floatValue);
            int f3 = a.f(this.c.top - iArr[1], this.f11416d.top, floatValue);
            int f4 = a.f(this.c.right, this.f11416d.right, floatValue);
            int f5 = a.f(this.c.bottom - iArr[1], this.f11416d.bottom, floatValue);
            this.a.setLayoutRect(f2, f3, f4, f5);
            this.a.layout(f2, f3, f4, f5);
            if (a.this.a != null) {
                a.this.a.onAnimUpdate(floatValue, this.f11417e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public class e implements Animator.AnimatorListener {
        final /* synthetic */ FullScreenImageView a;
        final /* synthetic */ TouchImageView b;

        e(a aVar, FullScreenImageView fullScreenImageView, TouchImageView touchImageView) {
            this.a = fullScreenImageView;
            this.b = touchImageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setVisibility(0);
        }
    }

    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public interface f {
        void onAnimUpdate(float f2, ImageView imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimTouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public static class g extends com.nostra13.universalimageloader.core.j.b {
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f11419d;

        public g(ImageView imageView) {
            super(imageView);
        }

        @Override // com.nostra13.universalimageloader.core.j.b, com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
        public int getHeight() {
            ImageView wrappedView = getWrappedView();
            int i2 = this.f11419d;
            if (i2 != 0) {
                return i2;
            }
            if (wrappedView == null) {
                return 0;
            }
            if (wrappedView.getMeasuredHeight() > 0) {
                return wrappedView.getMeasuredHeight();
            }
            int height = super.getHeight();
            return height > 0 ? height : us.pinguo.foundation.t.b.a.j(wrappedView.getContext());
        }

        @Override // com.nostra13.universalimageloader.core.j.b, com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
        public int getWidth() {
            ImageView wrappedView = getWrappedView();
            int i2 = this.c;
            if (i2 != 0) {
                return i2;
            }
            if (wrappedView == null) {
                return 0;
            }
            if (wrappedView.getMeasuredWidth() > 0) {
                return wrappedView.getMeasuredWidth();
            }
            int width = super.getWidth();
            return width > 0 ? width : us.pinguo.foundation.t.b.a.j(wrappedView.getContext());
        }
    }

    public a(Context context, LinearLayout linearLayout) {
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        a.C0453a c0453a = new a.C0453a();
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new us.pinguo.foundation.t.a.f(0));
        this.f11414k = bVar.t();
        c.b bVar2 = new c.b();
        bVar2.u(true);
        bVar2.v(false);
        a.C0453a c0453a2 = new a.C0453a();
        c0453a2.d(false);
        c0453a2.e(true);
        bVar2.z(c0453a2);
        bVar2.y(new us.pinguo.foundation.t.a.f(0));
        this.f11415l = bVar2.t();
        this.m = new View$OnClickListenerC0410a();
        this.f11409f = context;
        this.f11407d = linearLayout;
        this.c = ImageLoader.getInstance();
    }

    private void d(ViewGroup viewGroup, FullScreenPhoto fullScreenPhoto, TouchImageView touchImageView, int i2) {
        FullScreenImageView fullScreenImageView = (FullScreenImageView) ((View) touchImageView.getParent()).findViewById(R.id.tiv_anim_view_adapter);
        touchImageView.setVisibility(8);
        m(fullScreenImageView, i2);
        Rect rect = fullScreenPhoto.rect;
        String str = fullScreenPhoto.photo.url;
        if (str.startsWith("http")) {
            this.c.j(str, new g(fullScreenImageView), this.f11414k);
        } else {
            if (!str.startsWith(InspirePublishFragment.FILE_HEADER)) {
                str = InspirePublishFragment.FILE_HEADER + str;
            }
            this.c.j(str, new g(fullScreenImageView), this.f11415l);
        }
        Rect e2 = e(viewGroup.getContext(), fullScreenPhoto);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new d(fullScreenImageView, viewGroup, rect, e2, touchImageView));
        ofFloat.addListener(new e(this, fullScreenImageView, touchImageView));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public static Rect e(Context context, FullScreenPhoto fullScreenPhoto) {
        int j2 = us.pinguo.foundation.t.b.a.j(context);
        int h2 = us.pinguo.foundation.t.b.a.h(context);
        InspireFeedPhoto inspireFeedPhoto = fullScreenPhoto.photo;
        int i2 = inspireFeedPhoto.width;
        int i3 = inspireFeedPhoto.height;
        float f2 = j2;
        float f3 = h2;
        if (i2 / i3 > f2 / f3) {
            int i4 = h2 / 2;
            int i5 = ((int) (f2 * (i3 / i2))) / 2;
            int i6 = fullScreenPhoto.topOffset;
            return new Rect(0, (i4 - i5) + (i6 / 2), j2, i4 + i5 + (i6 / 2));
        }
        int i7 = j2 / 2;
        int i8 = ((int) (f3 * (i2 / i3))) / 2;
        return new Rect(i7 - i8, 0, i7 + i8, h2);
    }

    public static int f(int i2, int i3, float f2) {
        return (int) (i2 + ((i3 - i2) * f2));
    }

    private void g() {
        ArrayList<FullScreenPhoto> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 1) {
            this.f11407d.setVisibility(0);
            this.f11407d.removeAllViews();
            this.f11408e = new ArrayList<>();
            int a = us.pinguo.foundation.t.b.a.a(this.f11407d.getContext(), 8.0f);
            int i2 = a / 2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
            layoutParams.setMargins(i2, i2, i2, i2);
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                ImageView imageView = new ImageView(this.f11409f);
                imageView.setLayoutParams(layoutParams);
                this.f11408e.add(imageView);
                imageView.setTag(Integer.valueOf(i3));
                if (i3 == 0) {
                    imageView.setBackgroundResource(R.drawable.dotc);
                } else {
                    imageView.setBackgroundResource(R.drawable.dotn);
                }
                this.f11407d.addView(imageView);
            }
            return;
        }
        this.f11407d.setVisibility(8);
    }

    private void m(ImageView imageView, int i2) {
        Bitmap[] bitmapArr;
        Bitmap bitmap;
        if (this.f11411h == null || (bitmapArr = PictureViewPagerDialogFragment.sBitmaps) == null || bitmapArr.length <= i2 || (bitmap = bitmapArr[i2]) == null) {
            return;
        }
        imageView.setImageDrawable(new us.pinguo.foundation.t.a.g(bitmap, 0, 0));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj != null) {
            TouchImageView touchImageView = (TouchImageView) ((View) obj).findViewById(R.id.tiv_touch_view_adapter);
            touchImageView.setImageBitmap(null);
            touchImageView.cancelTask();
        }
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<FullScreenPhoto> arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: h */
    public View instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_touch_image, (ViewGroup) null);
        inflate.setTag(String.valueOf(i2));
        viewGroup.addView(inflate, -1, -1);
        TouchImageView touchImageView = (TouchImageView) inflate.findViewById(R.id.tiv_touch_view_adapter);
        ProgressWheel progressWheel = (ProgressWheel) inflate.findViewById(R.id.pb_touch_view_adapter);
        FullScreenPhoto fullScreenPhoto = this.b.get(i2);
        String str = fullScreenPhoto.photo.url;
        touchImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        inflate.setOnClickListener(this.m);
        touchImageView.setOnClickListener(this.m);
        if (str.startsWith("http")) {
            int j2 = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
            Bitmap[] bitmapArr = PictureViewPagerDialogFragment.sBitmaps;
            boolean z = true;
            if (bitmapArr != null && bitmapArr.length - 1 >= i2 && bitmapArr[i2] != null && bitmapArr[i2].getWidth() >= j2 * 0.7f) {
                z = false;
            }
            m(touchImageView, i2);
            this.c.k(PhotoImageView.addQiNiuSuffix(str, this.f11410g, false), new g(touchImageView), this.f11414k, new b(this, z, progressWheel));
        } else {
            if (!str.startsWith(InspirePublishFragment.FILE_HEADER)) {
                str = InspirePublishFragment.FILE_HEADER + str;
            }
            m(touchImageView, i2);
            this.c.k(str, new g(touchImageView), this.f11415l, new c(this, progressWheel));
        }
        if (this.f11413j) {
            this.f11413j = false;
            d(viewGroup, fullScreenPhoto, touchImageView, i2);
        }
        return inflate;
    }

    public void i(ArrayList<FullScreenPhoto> arrayList) {
        this.b = arrayList;
        g();
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(f fVar) {
        this.a = fVar;
    }

    public void k(Dialog dialog) {
        this.f11411h = dialog;
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.n = onPageChangeListener;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.f11411h == null) {
            Context context = this.f11409f;
            if (context instanceof AppCompatActivity) {
                if (!this.f11412i) {
                    ((AppCompatActivity) context).getSupportActionBar().hide();
                } else {
                    this.f11412i = false;
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.n;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        ArrayList<FullScreenPhoto> arrayList = this.b;
        if (arrayList == null || arrayList.size() <= 1) {
            return;
        }
        this.f11408e.get(i2).setBackgroundResource(R.drawable.dotc);
        int size = this.f11408e.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i2 != i3) {
                this.f11408e.get(i3).setBackgroundResource(R.drawable.dotn);
            }
        }
    }
}
