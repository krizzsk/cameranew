package us.pinguo.inspire.module.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.foundation.t.a.f;
import us.pinguo.foundation.t.a.g;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.Inspire;
import us.pinguo.ui.uilview.PhotoImageView;
/* loaded from: classes9.dex */
public class TaskCoverImageView extends PhotoImageView {
    public TaskCoverImageView(Context context) {
        super(context);
    }

    public Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        if (drawable instanceof g) {
            return ((g) drawable).a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        setDisplayer(new f(a.a(Inspire.a(), 2.0f), 0, 400, true, true, false));
    }

    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView, com.nostra13.universalimageloader.core.k.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        super.onLoadingComplete(str, view, bitmap);
        view.setBackgroundColor(getResources().getColor(17170445));
    }

    public TaskCoverImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskCoverImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
