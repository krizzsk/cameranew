package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class TopicImageLoaderView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private Context f9757i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f9758j;

    public TopicImageLoaderView(Context context) {
        super(context);
        this.f9757i = getContext();
        this.f9758j = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, ViewCompat.MEASURED_SIZE_MASK});
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9758j.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f9758j.setBounds(0, (int) ((measuredHeight * 0.66d) + 0.5d), measuredWidth, measuredHeight);
    }

    public void setDefaultImage(int i2) {
        e().B(i2);
    }

    public void setImageUrl(String str) {
        setImageURI(str);
    }

    public TopicImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9757i = getContext();
        this.f9758j = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, ViewCompat.MEASURED_SIZE_MASK});
    }

    public TopicImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9757i = getContext();
        this.f9758j = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, ViewCompat.MEASURED_SIZE_MASK});
    }
}
