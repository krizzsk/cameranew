package us.pinguo.foundation.t.a;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
/* compiled from: CenterCropRoundedBitmapDisplayer.java */
/* loaded from: classes4.dex */
public class f extends us.pinguo.foundation.t.a.a {
    protected final int cornerRadius;
    private int mLoadingColor;
    protected final int margin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CenterCropRoundedBitmapDisplayer.java */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            View view = this.a;
            if ((view instanceof ImageView) && ((ImageView) view).getDrawable() != null) {
                ((ImageView) this.a).getDrawable().setAlpha(intValue);
            } else {
                this.a.setAlpha(intValue / 255.0f);
            }
        }
    }

    public f(int i2) {
        this(i2, 0, 0, false, false, false);
    }

    public static void animate(View view, int i2) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.addUpdateListener(new a(view));
        ofInt.setDuration(i2);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    @Override // us.pinguo.foundation.t.a.a, com.nostra13.universalimageloader.core.i.a
    public void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
        if (aVar instanceof com.nostra13.universalimageloader.core.j.b) {
            aVar.setImageDrawable(new g(bitmap, this.cornerRadius, this.margin, this.mLoadingColor));
            if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
                animate(aVar.getWrappedView(), this.durationMillis);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public f(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        super(i4, z, z2, z3);
        this.cornerRadius = i2;
        this.margin = i3;
    }
}
