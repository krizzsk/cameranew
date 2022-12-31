package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import us.pinguo.inspire.widget.GravityImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeatureRoundImageView extends GravityImageView {
    private Path mPath;
    private int mRadius;

    public FeatureRoundImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mPath == null) {
            this.mRadius = getResources().getDimensionPixelSize(R.dimen.feeds_feature_radius);
            Path path = new Path();
            this.mPath = path;
            int i2 = this.mRadius;
            path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{0.0f, 0.0f, i2, i2, i2, i2, 0.0f, 0.0f}, Path.Direction.CW);
        }
        canvas.save();
        canvas.clipPath(this.mPath);
        super.onDraw(canvas);
        canvas.restore();
    }

    public FeatureRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeatureRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
