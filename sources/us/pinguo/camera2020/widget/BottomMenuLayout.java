package us.pinguo.camera2020.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
/* compiled from: BottomMenuLayout.kt */
/* loaded from: classes3.dex */
public final class BottomMenuLayout extends ConstraintLayout {
    public Map<Integer, View> a;
    private View b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f9460d;

    /* renamed from: e  reason: collision with root package name */
    private View f9461e;

    /* renamed from: f  reason: collision with root package name */
    private View f9462f;

    /* renamed from: g  reason: collision with root package name */
    private final float f9463g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f9464h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomMenuLayout(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.f9463g = getResources().getDimension(R.dimen.shutter_size_normal) / getResources().getDimension(R.dimen.shutter_size_big);
        this.f9464h = new Rect();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (AfterCaptureCircleImageView) _$_findCachedViewById(R.id.imgAlbumMusicDiscard);
        this.c = (ImageView) _$_findCachedViewById(R.id.imgBeauty);
        this.f9460d = (ShutterButton) _$_findCachedViewById(R.id.imgShutterOrSave);
        this.f9461e = (ImageView) _$_findCachedViewById(R.id.imgStickerOrFilter);
        this.f9462f = (ImageView) _$_findCachedViewById(R.id.imgFilterOrShare);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clFuncArea);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ImageView imageView;
        int measuredHeight;
        s.h(event, "event");
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clFuncArea);
        if (constraintLayout != null && (imageView = this.f9460d) != null) {
            this.f9464h.set(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
            this.f9464h.offset(0, (int) imageView.getTranslationY());
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof ShutterButtonDrawable) {
                measuredHeight = (int) (imageView.getMeasuredHeight() * (1 - (((ShutterButtonDrawable) drawable).h().scaleRate * imageView.getScaleY())) * 0.5f);
            } else {
                measuredHeight = (int) (imageView.getMeasuredHeight() * (1 - (this.f9463g * imageView.getScaleY())) * 0.5f);
            }
            this.f9464h.inset(measuredHeight, measuredHeight);
            if ((imageView.getVisibility() == 0) && this.f9464h.contains((int) event.getX(), (int) event.getY())) {
                event.offsetLocation(0.0f, -imageView.getTranslationY());
                imageView.dispatchTouchEvent(event);
                return true;
            }
            View view = this.b;
            if (view == null) {
                return super.onTouchEvent(event);
            }
            view.getHitRect(this.f9464h);
            this.f9464h.offset(0, (int) constraintLayout.getTranslationY());
            if (view.isShown() && this.f9464h.contains((int) event.getX(), (int) event.getY())) {
                event.offsetLocation(0.0f, -constraintLayout.getTranslationY());
                view.dispatchTouchEvent(event);
                return true;
            }
            View view2 = this.c;
            if (view2 == null) {
                return super.onTouchEvent(event);
            }
            view2.getHitRect(this.f9464h);
            this.f9464h.offset(0, (int) constraintLayout.getTranslationY());
            if (view2.isShown() && this.f9464h.contains((int) event.getX(), (int) event.getY())) {
                event.offsetLocation(0.0f, -constraintLayout.getTranslationY());
                view2.dispatchTouchEvent(event);
                return true;
            }
            View view3 = this.f9461e;
            if (view3 == null) {
                return super.onTouchEvent(event);
            }
            view3.getHitRect(this.f9464h);
            this.f9464h.offset(0, (int) constraintLayout.getTranslationY());
            if (view3.isShown() && this.f9464h.contains((int) event.getX(), (int) event.getY())) {
                event.offsetLocation(0.0f, -constraintLayout.getTranslationY());
                view3.dispatchTouchEvent(event);
                return true;
            }
            View view4 = this.f9462f;
            if (view4 == null) {
                return super.onTouchEvent(event);
            }
            view4.getHitRect(this.f9464h);
            this.f9464h.offset(0, (int) constraintLayout.getTranslationY());
            if (view4.isShown() && this.f9464h.contains((int) event.getX(), (int) event.getY())) {
                event.offsetLocation(0.0f, -constraintLayout.getTranslationY());
                view4.dispatchTouchEvent(event);
                return true;
            }
            return false;
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f9463g = getResources().getDimension(R.dimen.shutter_size_normal) / getResources().getDimension(R.dimen.shutter_size_big);
        this.f9464h = new Rect();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomMenuLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f9463g = getResources().getDimension(R.dimen.shutter_size_normal) / getResources().getDimension(R.dimen.shutter_size_big);
        this.f9464h = new Rect();
    }
}
