package us.pinguo.widet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import us.pinguo.foundation.t.b.a;
import us.pinguo.ui.uilview.CircleImageView;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public abstract class HatImageView extends CircleImageView {

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f12504j;

    public HatImageView(Context context) {
        super(context);
    }

    private void d(Canvas canvas) {
        if (e()) {
            if (this.f12504j == null) {
                if (getWidth() < a.a(getContext(), 40.0f)) {
                    this.f12504j = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.hat_small);
                } else {
                    this.f12504j = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.hat_big);
                }
            }
            Rect rect = new Rect();
            rect.left = (int) (getWidth() * 0.45d);
            rect.right = (int) (getWidth() * 1.1d);
            double width = ((getWidth() * 0.65d) * 76.0d) / 116.0d;
            rect.top = (int) ((-width) * 0.45d);
            rect.bottom = (int) (width * 0.55d);
            ViewGroup viewGroup = (ViewGroup) getParent();
            viewGroup.setClipChildren(false);
            if (viewGroup.getParent() != null) {
                ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            }
            canvas.drawBitmap(this.f12504j, (Rect) null, rect, (Paint) null);
        }
    }

    public abstract boolean e();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.CircleImageView, us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    public HatImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
