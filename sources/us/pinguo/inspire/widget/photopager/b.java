package us.pinguo.inspire.widget.photopager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.collection.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.c;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.ArrayList;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* compiled from: TouchImageAdapter.java */
/* loaded from: classes9.dex */
public class b extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ArrayList<String> a;
    private ImageLoader b;
    private LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<ImageView> f11420d;

    /* renamed from: e  reason: collision with root package name */
    private Context f11421e;

    /* renamed from: f  reason: collision with root package name */
    private int f11422f = us.pinguo.foundation.t.b.a.j(Inspire.a());

    /* renamed from: g  reason: collision with root package name */
    private Dialog f11423g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11424h;

    /* renamed from: i  reason: collision with root package name */
    private com.nostra13.universalimageloader.core.c f11425i;

    /* renamed from: j  reason: collision with root package name */
    private com.nostra13.universalimageloader.core.c f11426j;

    /* renamed from: k  reason: collision with root package name */
    private View.OnClickListener f11427k;

    /* renamed from: l  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f11428l;

    /* compiled from: TouchImageAdapter.java */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBar supportActionBar;
            if (b.this.f11423g != null) {
                b.this.f11423g.dismiss();
            } else if (!(b.this.f11421e instanceof AppCompatActivity) || (supportActionBar = ((AppCompatActivity) b.this.f11421e).getSupportActionBar()) == null) {
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
    /* compiled from: TouchImageAdapter.java */
    /* renamed from: us.pinguo.inspire.widget.photopager.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0411b implements com.nostra13.universalimageloader.core.k.a {
        final /* synthetic */ boolean a;
        final /* synthetic */ ProgressWheel b;

        C0411b(b bVar, boolean z, ProgressWheel progressWheel) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TouchImageAdapter.java */
    /* loaded from: classes9.dex */
    public static class c extends com.nostra13.universalimageloader.core.j.b {
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f11429d;

        public c(ImageView imageView) {
            super(imageView);
        }

        @Override // com.nostra13.universalimageloader.core.j.b, com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
        public int getHeight() {
            ImageView wrappedView = getWrappedView();
            int i2 = this.f11429d;
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

    public b(Context context, LinearLayout linearLayout) {
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        a.C0453a c0453a = new a.C0453a();
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        this.f11425i = bVar.t();
        c.b bVar2 = new c.b();
        bVar2.u(true);
        bVar2.v(false);
        a.C0453a c0453a2 = new a.C0453a();
        c0453a2.d(false);
        c0453a2.e(true);
        bVar2.z(c0453a2);
        this.f11426j = bVar2.t();
        this.f11427k = new a();
        this.f11421e = context;
        this.c = linearLayout;
        this.b = ImageLoader.getInstance();
    }

    private void d(int i2) {
        ArrayList<String> arrayList = this.a;
        if (arrayList != null && arrayList.size() > 1) {
            this.c.setVisibility(0);
            this.c.removeAllViews();
            this.f11420d = new ArrayList<>();
            int a2 = us.pinguo.foundation.t.b.a.a(this.c.getContext(), 8.0f);
            int i3 = a2 / 2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
            layoutParams.setMargins(i3, i3, i3, i3);
            for (int i4 = 0; i4 < this.a.size(); i4++) {
                ImageView imageView = new ImageView(this.f11421e);
                imageView.setLayoutParams(layoutParams);
                this.f11420d.add(imageView);
                imageView.setTag(Integer.valueOf(i4));
                if (i4 == i2) {
                    imageView.setBackgroundResource(R.drawable.dotc);
                } else {
                    imageView.setBackgroundResource(R.drawable.dotn);
                }
                this.c.addView(imageView);
            }
            return;
        }
        this.c.setVisibility(8);
    }

    private void i(TouchImageView touchImageView, int i2) {
        Bitmap[] bitmapArr;
        Bitmap bitmap;
        if (this.f11423g == null || (bitmapArr = PictureViewPagerDialogFragment.sBitmaps) == null || bitmapArr.length <= i2 || (bitmap = bitmapArr[i2]) == null) {
            return;
        }
        touchImageView.setImageBitmap(bitmap);
    }

    public void c() {
        this.f11424h = true;
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
    /* renamed from: e */
    public View instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_touch_image, (ViewGroup) null);
        viewGroup.addView(inflate, -1, -1);
        TouchImageView touchImageView = (TouchImageView) inflate.findViewById(R.id.tiv_touch_view_adapter);
        ProgressWheel progressWheel = (ProgressWheel) inflate.findViewById(R.id.pb_touch_view_adapter);
        String str = this.a.get(i2);
        touchImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        inflate.setOnClickListener(this.f11427k);
        touchImageView.setOnClickListener(this.f11427k);
        if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX)) {
            int j2 = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
            Bitmap[] bitmapArr = PictureViewPagerDialogFragment.sBitmaps;
            boolean z = true;
            if (bitmapArr != null && bitmapArr.length - 1 >= i2 && bitmapArr[i2] != null && bitmapArr[i2].getWidth() >= j2 * 0.7f) {
                z = false;
            }
            i(touchImageView, i2);
            this.b.k(PhotoImageView.addQiNiuSuffix(str, this.f11422f, false), new c(touchImageView), this.f11425i, new C0411b(this, z, progressWheel));
        } else {
            if (!str.startsWith(InspirePublishFragment.FILE_HEADER)) {
                str = InspirePublishFragment.FILE_HEADER + str;
            }
            this.b.j(str, new c(touchImageView), this.f11426j);
            progressWheel.setVisibility(8);
        }
        return inflate;
    }

    public void f(ArrayList<String> arrayList) {
        g(arrayList, 0);
    }

    public void g(ArrayList<String> arrayList, int i2) {
        this.a = arrayList;
        d(i2);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<String> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void h(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f11428l = onPageChangeListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.f11423g == null) {
            Context context = this.f11421e;
            if (context instanceof AppCompatActivity) {
                if (!this.f11424h) {
                    ((AppCompatActivity) context).getSupportActionBar().hide();
                } else {
                    this.f11424h = false;
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f11428l;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        ArrayList<String> arrayList = this.a;
        if (arrayList == null || arrayList.size() <= 1) {
            return;
        }
        this.f11420d.get(i2).setBackgroundResource(R.drawable.dotc);
        int size = this.f11420d.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i2 != i3) {
                this.f11420d.get(i3).setBackgroundResource(R.drawable.dotn);
            }
        }
    }
}
