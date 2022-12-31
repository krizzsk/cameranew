package us.pinguo.ui.widget.GaussianBlur.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.foundation.e;
import us.pinguo.foundation.t.a.f;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.GaussianBlur.GaussianBlurImageView;
import us.pinguo.ui.widget.StickyImageView;
/* loaded from: classes6.dex */
public class GuideGaussianBlurImageView extends GaussianBlurImageView {

    /* loaded from: classes6.dex */
    class a implements com.nostra13.universalimageloader.core.l.a {
        a() {
        }

        @Override // com.nostra13.universalimageloader.core.l.a
        public Bitmap a(Bitmap bitmap) {
            Bitmap bitmap2;
            try {
                bitmap2 = new c(bitmap, 1.0f).a((int) (us.pinguo.foundation.t.b.a.a(GuideGaussianBlurImageView.this.getContext(), 50.0f) * 1.0f));
            } catch (OutOfMemoryError e2) {
                e.e(e2);
                bitmap2 = null;
            }
            return bitmap2 == null ? bitmap : bitmap2;
        }
    }

    public GuideGaussianBlurImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.widget.GaussianBlur.GaussianBlurImageView, us.pinguo.ui.widget.StickyImageView, us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(false);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new f(0, 0, 400, true, false, false));
        bVar.D(true);
        bVar.B(new a());
        bVar.C(new StickyImageView.a());
        this.mDisplayImageOptions = bVar.t();
        setImageViewAware(new PhotoImageView.a(this));
    }

    public GuideGaussianBlurImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideGaussianBlurImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
