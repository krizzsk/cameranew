package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class CoverImageView extends PhotoImageView {
    public CoverImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(true);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.D(false);
        this.mDisplayImageOptions = bVar.t();
    }

    public CoverImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoverImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
