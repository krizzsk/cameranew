package us.pinguo.inspire.widget.photopager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import us.pinguo.inspire.widget.photopager.a;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PictureViewPagerDialogFragment extends DialogFragment {
    static final int ANIM_TIME = 300;
    public static final String EXTRA_CURRENT_ITEM = "EXTRA_CURRENT_ITEM";
    public static final String EXTRA_IMAGE_URLS = "EXTRA_IMAGE_URLS";
    public static Bitmap[] sBitmaps;
    private us.pinguo.inspire.widget.photopager.a adapter;
    private int currentPosition;
    protected ExtendedViewPager evp_apvp;
    private LinearLayout ll_apvp;
    private a.f mAnimUpdateListener;
    private c mGetRect;
    protected View mLayout;
    private ViewPager.OnPageChangeListener onPageChangeListener = new a();
    private ArrayList<FullScreenPhoto> photos;

    /* loaded from: classes9.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PictureViewPagerDialogFragment.this.currentPosition = i2;
        }
    }

    /* loaded from: classes9.dex */
    class b extends Dialog {
        private boolean a;

        /* loaded from: classes9.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ Rect a;
            final /* synthetic */ Rect b;
            final /* synthetic */ FullScreenImageView c;

            a(Rect rect, Rect rect2, FullScreenImageView fullScreenImageView) {
                this.a = rect;
                this.b = rect2;
                this.c = fullScreenImageView;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PictureViewPagerDialogFragment.this.evp_apvp.setBackgroundColor(Color.argb((int) (255.0f * floatValue), 0, 0, 0));
                int[] iArr = new int[2];
                PictureViewPagerDialogFragment.this.evp_apvp.getLocationInWindow(iArr);
                int f2 = us.pinguo.inspire.widget.photopager.a.f(this.a.left, this.b.left, floatValue);
                int f3 = us.pinguo.inspire.widget.photopager.a.f(this.a.top - iArr[1], this.b.top, floatValue);
                int f4 = us.pinguo.inspire.widget.photopager.a.f(this.a.right, this.b.right, floatValue);
                int f5 = us.pinguo.inspire.widget.photopager.a.f(this.a.bottom - iArr[1], this.b.bottom, floatValue);
                this.c.setLayoutRect(f2, f3, f4, f5);
                this.c.layout(f2, f3, f4, f5);
                if (PictureViewPagerDialogFragment.this.mAnimUpdateListener != null) {
                    PictureViewPagerDialogFragment.this.mAnimUpdateListener.onAnimUpdate(floatValue, this.c);
                }
            }
        }

        /* renamed from: us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class C0409b implements Animator.AnimatorListener {
            C0409b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.a();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        b(Context context, int i2) {
            super(context, i2);
            this.a = false;
        }

        public void a() {
            if (isShowing()) {
                try {
                    super.dismiss();
                } catch (Exception e2) {
                    us.pinguo.common.log.a.f(e2);
                }
            }
            PictureViewPagerDialogFragment.sBitmaps = null;
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            Rect rect;
            if (this.a) {
                return;
            }
            this.a = true;
            int currentItem = PictureViewPagerDialogFragment.this.evp_apvp.getCurrentItem();
            if (currentItem < 0 || PictureViewPagerDialogFragment.this.photos == null || PictureViewPagerDialogFragment.this.photos.isEmpty() || currentItem >= PictureViewPagerDialogFragment.this.photos.size()) {
                return;
            }
            FullScreenPhoto fullScreenPhoto = (FullScreenPhoto) PictureViewPagerDialogFragment.this.photos.get(currentItem);
            View view = null;
            for (int i2 = 0; i2 < PictureViewPagerDialogFragment.this.evp_apvp.getChildCount(); i2++) {
                View childAt = PictureViewPagerDialogFragment.this.evp_apvp.getChildAt(i2);
                if (String.valueOf(currentItem).equals(childAt.getTag())) {
                    view = childAt;
                }
            }
            if (view != null) {
                if (PictureViewPagerDialogFragment.this.mGetRect != null) {
                    rect = PictureViewPagerDialogFragment.this.mGetRect.getPicRect(currentItem);
                } else {
                    rect = fullScreenPhoto.rect;
                }
                TouchImageView touchImageView = (TouchImageView) view.findViewById(R.id.tiv_touch_view_adapter);
                Rect e2 = us.pinguo.inspire.widget.photopager.a.e(PictureViewPagerDialogFragment.this.getActivity(), fullScreenPhoto);
                FullScreenImageView fullScreenImageView = (FullScreenImageView) view.findViewById(R.id.tiv_anim_view_adapter);
                fullScreenImageView.setImageDrawable(touchImageView.getDrawable());
                ViewGroup.LayoutParams layoutParams = fullScreenImageView.getLayoutParams();
                layoutParams.width = e2.width();
                layoutParams.height = e2.height();
                fullScreenImageView.setLayoutParams(layoutParams);
                fullScreenImageView.setVisibility(0);
                touchImageView.setVisibility(8);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addUpdateListener(new a(rect, e2, fullScreenImageView));
                ofFloat.addListener(new C0409b());
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                return;
            }
            a();
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        Rect getPicRect(int i2);
    }

    public static void showFullScreenPics(FragmentManager fragmentManager, Bitmap[] bitmapArr, ArrayList<FullScreenPhoto> arrayList, int i2, c cVar) {
        sBitmaps = bitmapArr;
        PictureViewPagerDialogFragment pictureViewPagerDialogFragment = new PictureViewPagerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_CURRENT_ITEM, i2);
        bundle.putParcelableArrayList(EXTRA_IMAGE_URLS, arrayList);
        pictureViewPagerDialogFragment.setGetRect(cVar);
        pictureViewPagerDialogFragment.setArguments(bundle);
        pictureViewPagerDialogFragment.show(fragmentManager, PictureViewPagerDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(View view) {
        ExtendedViewPager extendedViewPager = (ExtendedViewPager) view.findViewById(R.id.evp_apvp);
        this.evp_apvp = extendedViewPager;
        extendedViewPager.setBackgroundColor(0);
        this.ll_apvp = (LinearLayout) view.findViewById(R.id.ll_apvp);
        us.pinguo.inspire.widget.photopager.a aVar = new us.pinguo.inspire.widget.photopager.a(getActivity(), this.ll_apvp);
        this.adapter = aVar;
        aVar.k(getDialog());
        this.adapter.l(this.onPageChangeListener);
        this.photos = getArguments().getParcelableArrayList(EXTRA_IMAGE_URLS);
        this.evp_apvp.setAdapter(this.adapter);
        this.adapter.i(this.photos);
        this.evp_apvp.setOnPageChangeListener(this.adapter);
        int i2 = getArguments().getInt(EXTRA_CURRENT_ITEM, 0);
        this.currentPosition = i2;
        this.evp_apvp.setCurrentItem(i2);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        b bVar = new b(getActivity(), 16973831);
        bVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_picture_view_pager, (ViewGroup) null);
        this.mLayout = inflate;
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (sBitmaps != null) {
            sBitmaps = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        init(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAnimFirstUpdateListener(a.f fVar) {
        this.mAnimUpdateListener = fVar;
        us.pinguo.inspire.widget.photopager.a aVar = this.adapter;
        if (aVar != null) {
            aVar.j(fVar);
        }
    }

    public void setGetRect(c cVar) {
        this.mGetRect = cVar;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return 0;
        }
    }
}
