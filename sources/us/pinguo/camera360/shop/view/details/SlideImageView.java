package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.ScrollerCompat;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.gms.common.ConnectionResult;
import com.pinguo.camera360.lib.ui.FixedRateRelativeLayout;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class SlideImageView extends View implements GestureDetector.OnGestureListener {
    private static final String u = SlideImageView.class.getSimpleName();
    private boolean a;
    private int b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private GestureDetectorCompat f9748d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollerCompat f9749e;

    /* renamed from: f  reason: collision with root package name */
    private Context f9750f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f9751g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f9752h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f9753i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<ShowDetail.a> f9754j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayMap<String, Drawable> f9755k;

    /* renamed from: l  reason: collision with root package name */
    private int f9756l;
    private int m;
    private boolean n;
    private c o;
    private boolean p;
    private boolean q;
    private int r;
    private Rect s;
    private Handler t;

    /* loaded from: classes4.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                SlideImageView.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ String a;
        final /* synthetic */ com.facebook.datasource.b b;

        b(String str, com.facebook.datasource.b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            if (SlideImageView.this.f9754j.size() != 0) {
                SlideImageView slideImageView = SlideImageView.this;
                slideImageView.s(this.a, slideImageView.f9753i);
            }
            bVar.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            if (SlideImageView.this.f9754j.size() == 0) {
                return;
            }
            SlideImageView.this.s(this.a, new d(bitmap, SlideImageView.this.f9750f.getResources().getDimensionPixelSize(R.dimen.pkg_details_slide_image_radius), 15));
            this.b.close();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, ShowDetail.a aVar);
    }

    public SlideImageView(Context context) {
        super(context);
        this.a = true;
        this.b = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.f9754j = new ArrayList<>(9);
        this.f9755k = new ArrayMap<>(9);
        this.f9756l = 0;
        this.n = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = new Rect();
        this.t = new a();
        this.f9750f = getContext();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.c = getResources().getDisplayMetrics().density * 1000.0f;
        this.f9748d = new GestureDetectorCompat(this.f9750f, this);
        this.f9749e = ScrollerCompat.create(this.f9750f);
        this.f9753i = getResources().getDrawable(R.drawable.store_details_default_img);
        this.q = false;
    }

    private void e(boolean z) {
        int i2;
        if (z) {
            i2 = this.f9756l - 1;
            if (i2 < 0) {
                i2 = this.f9754j.size() - 1;
            }
        } else {
            i2 = this.f9756l + 1;
            if (i2 >= this.f9754j.size()) {
                i2 = 0;
            }
        }
        n(i2, this.f9754j.get(i2));
    }

    private void f(boolean z) {
        int i2;
        if (z) {
            i2 = this.f9756l - 1;
            if (i2 >= 0) {
                this.f9751g = this.f9752h;
            } else {
                i2 = this.f9754j.size() - 1;
                this.f9751g = j(this.f9754j.get(i2).b());
            }
            this.f9752h = null;
        } else {
            i2 = this.f9756l + 1;
            if (i2 < this.f9754j.size()) {
                this.f9751g = this.f9752h;
            } else {
                i2 = 0;
                this.f9751g = j(this.f9754j.get(0).b());
            }
            this.f9752h = null;
        }
        this.f9756l = i2;
    }

    private boolean g(boolean z) {
        return this.f9754j.size() < 2;
    }

    private void h(Canvas canvas) {
        int i2;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f9749e.computeScrollOffset()) {
            int i3 = this.r;
            if (i3 == 3) {
                i2 = this.f9749e.getCurrX();
            } else {
                if (i3 == 4) {
                    measuredWidth = this.f9749e.getCurrX();
                } else if (i3 == 1) {
                    measuredWidth = this.f9749e.getCurrX();
                } else if (i3 == 2) {
                    i2 = this.f9749e.getCurrX();
                }
                i2 = 0;
            }
            invalidate();
        } else {
            int i4 = this.r;
            if (i4 == 1 || i4 == 2) {
                f(i4 == 2);
            }
            int i5 = this.m;
            if (i5 < 0) {
                i2 = Math.abs(i5);
            } else {
                measuredWidth -= i5;
                i2 = 0;
            }
            m(this.a);
            this.r = 0;
        }
        Drawable drawable = this.f9752h;
        int width = getWidth();
        int height = getHeight();
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (width > intrinsicWidth) {
                intrinsicHeight = (int) (intrinsicHeight * (width / intrinsicWidth));
                intrinsicWidth = width;
            }
            int i6 = (width - intrinsicWidth) / 2;
            int i7 = (height - intrinsicHeight) / 2;
            drawable.setBounds(i6, i7, intrinsicWidth + i6, intrinsicHeight + i7);
            drawable.draw(canvas);
        } else {
            this.f9753i.draw(canvas);
        }
        Rect rect = new Rect(i2, 0, measuredWidth, measuredHeight);
        canvas.save();
        canvas.clipRect(rect);
        Drawable drawable2 = this.f9751g;
        if (drawable2 != null) {
            int intrinsicWidth2 = drawable2.getIntrinsicWidth();
            int intrinsicHeight2 = drawable2.getIntrinsicHeight();
            if (width > intrinsicWidth2) {
                intrinsicHeight2 = (int) (intrinsicHeight2 * (width / intrinsicWidth2));
                intrinsicWidth2 = width;
            }
            int i8 = (width - intrinsicWidth2) / 2;
            int i9 = (height - intrinsicHeight2) / 2;
            drawable2.setBounds(i8, i9, intrinsicWidth2 + i8, intrinsicHeight2 + i9);
            drawable2.draw(canvas);
        } else {
            this.f9753i.draw(canvas);
        }
        canvas.restore();
    }

    private Drawable j(String str) {
        String str2 = u;
        us.pinguo.common.log.a.m(str2, "getDrawable icon=" + str, new Object[0]);
        return this.f9755k.get(str);
    }

    private void k(String str) {
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b2 = com.facebook.drawee.backends.pipeline.c.a().b(ImageRequestBuilder.s(Uri.parse(str)).a(), this.f9750f);
        b2.d(new b(str, b2), UiThreadImmediateExecutorService.getInstance());
    }

    private void l() {
        invalidate();
        Iterator<ShowDetail.a> it = this.f9754j.iterator();
        while (it.hasNext()) {
            ShowDetail.a next = it.next();
            String str = u;
            us.pinguo.common.log.a.m(str, "loadImages imageInfo.getUrl()=" + next.b(), new Object[0]);
            k(next.b());
        }
    }

    private void m(boolean z) {
        boolean z2;
        if (z && this.a) {
            t();
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        x();
    }

    private void n(int i2, ShowDetail.a aVar) {
        c cVar = this.o;
        if (cVar != null) {
            cVar.a(i2, aVar);
        }
    }

    private void r(boolean z) {
        ArrayList<ShowDetail.a> arrayList;
        int i2 = this.f9756l;
        if (!z) {
            int i3 = i2 + 1;
            if (i3 >= this.f9754j.size()) {
                this.f9752h = j(this.f9754j.get(0).b());
                return;
            } else {
                this.f9752h = j(this.f9754j.get(i3).b());
                return;
            }
        }
        int i4 = i2 - 1;
        if (i4 < 0) {
            this.f9752h = j(this.f9754j.get(arrayList.size() - 1).b());
            return;
        }
        this.f9752h = j(this.f9754j.get(i4).b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, Drawable drawable) {
        int i2;
        if (drawable != null) {
            drawable.setBounds(this.s);
            this.f9755k.put(str, drawable);
        }
        if (this.f9751g == null) {
            for (int i3 = 0; i3 < this.f9754j.size(); i3++) {
                if (str.equals(this.f9754j.get(i3).b()) && i3 == (i2 = this.f9756l)) {
                    this.f9751g = j(this.f9754j.get(i2).b());
                }
            }
            int i4 = this.f9756l;
            n(i4, this.f9754j.get(i4));
            requestLayout();
        }
    }

    private void t() {
        this.t.removeMessages(100);
        this.t.sendEmptyMessageDelayed(100, this.b);
    }

    private void u() {
        us.pinguo.common.log.a.m(u, "startScroll()", new Object[0]);
        int measuredWidth = getMeasuredWidth();
        int i2 = this.m;
        if (i2 < 0) {
            this.r = 2;
            int abs = Math.abs(i2);
            this.f9749e.startScroll(abs, 0, measuredWidth - abs, 0, 400);
            if (this.f9752h == null) {
                r(true);
            }
        } else {
            this.r = 1;
            int i3 = measuredWidth - i2;
            this.f9749e.startScroll(i3, 0, -i3, 0, 400);
            if (this.f9752h == null) {
                r(false);
            }
        }
        this.m = 0;
        e(this.r == 2);
        invalidate();
    }

    private void v(float f2, MotionEvent motionEvent) {
        int i2;
        int measuredWidth = getMeasuredWidth();
        int x = (int) (motionEvent.getX() + 0.5d);
        if (f2 > 0.0f) {
            this.r = 2;
            i2 = measuredWidth - x;
            if (this.f9752h == null) {
                r(true);
            }
        } else {
            this.r = 1;
            if (this.f9752h == null) {
                r(false);
            }
            i2 = x;
            measuredWidth = 0;
        }
        float abs = Math.abs((i2 / f2) * 1000.0f);
        if (abs > 400.0f) {
            abs = 400.0f;
        } else if (abs < 50.0f) {
            abs = 50.0f;
        }
        this.f9749e.startScroll(x, 0, measuredWidth - x, 0, (int) (abs + 0.5d));
        this.m = 0;
        e(this.r == 2);
        invalidate();
    }

    private void w() {
        int i2;
        int measuredWidth = getMeasuredWidth();
        int i3 = this.m;
        if (i3 < 0) {
            this.r = 3;
            i2 = Math.abs(i3);
        } else {
            this.r = 4;
            i2 = measuredWidth - i3;
        }
        this.f9749e.startScroll(i2, 0, this.m, 0, 400);
        this.m = 0;
        invalidate();
    }

    private void x() {
        this.t.removeMessages(100);
    }

    public int i() {
        return this.f9754j.size();
    }

    public void o() {
        this.f9754j.clear();
        this.f9755k.clear();
        this.f9752h = null;
        this.f9751g = null;
        this.f9753i = null;
        this.o = null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        if (this.a) {
            t();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.t != null) {
            x();
            this.t = null;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.f9749e.isFinished()) {
            us.pinguo.common.log.a.m(u, "onDown mScroller.isFinished() true", new Object[0]);
            this.r = 0;
            return true;
        }
        us.pinguo.common.log.a.m(u, "onDown mScroller.isFinished() false", new Object[0]);
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        h(canvas);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        us.pinguo.common.log.a.m(u, MessageFormat.format("onFling velocityX={0},mFlingValidatedVelocity={1}", Float.valueOf(f2), Float.valueOf(this.c)), new Object[0]);
        this.t.removeMessages(100);
        if (Math.abs(f2) > this.c) {
            if (g(f2 > 0.0f)) {
                return true;
            }
            v(f2, motionEvent2);
            x();
        }
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.s.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f9753i.setBounds(this.s);
        if (!this.p) {
            this.p = true;
            l();
        }
        String str = u;
        us.pinguo.common.log.a.m(str, "onLayout mRect=" + this.s.toString(), new Object[0]);
        this.q = true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i2);
        Drawable drawable = this.f9751g;
        int i4 = (drawable == null || drawable.getIntrinsicWidth() == drawable.getIntrinsicHeight()) ? defaultSize : (int) (defaultSize / 0.75f);
        setMeasuredDimension(defaultSize, i4);
        ViewParent parent = getParent();
        if (parent instanceof FixedRateRelativeLayout) {
            ((FixedRateRelativeLayout) parent).setRate((defaultSize / i4) - 0.04f);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.n = true;
        if (Math.abs(f2) > Math.abs(f3)) {
            int i2 = this.m + ((int) f2);
            this.m = i2;
            if (g(i2 < 0)) {
                return true;
            }
            if (this.f9752h == null) {
                r(this.m < 0);
            }
            invalidate();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t.removeMessages(100);
        } else if (action == 1 || action == 3) {
            if (this.n) {
                int measuredWidth = getMeasuredWidth();
                if (g(this.m < 0)) {
                    this.m = 0;
                } else if (Math.abs(this.m) > measuredWidth / 2) {
                    u();
                } else {
                    w();
                }
                this.n = false;
            }
            t();
        }
        return this.f9748d.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        m(i2 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        m(i2 == 0);
    }

    public void p() {
        this.f9754j.clear();
        this.f9755k.clear();
        this.f9756l = 0;
        this.r = 0;
        this.m = 0;
        this.f9751g = null;
        this.f9752h = null;
        invalidate();
    }

    protected void q() {
        if (g(false)) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        this.r = 1;
        if (this.f9752h == null) {
            r(false);
        }
        this.f9749e.startScroll(measuredWidth, 0, 0 - measuredWidth, 0, 400);
        this.m = 0;
        e(this.r == 2);
        invalidate();
    }

    public void setAutoScroll(boolean z) {
        if (z != this.a) {
            this.a = z;
            if (z) {
                t();
            } else {
                x();
            }
        }
    }

    public void setAutoScrollTime(int i2) {
        this.b = i2;
    }

    public void setImageInfos(List<ShowDetail.a> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f9754j.clear();
        this.f9755k.clear();
        if (!TextUtils.isEmpty(str)) {
            this.f9754j.add(new ShowDetail.a(str, this.f9750f.getString(R.string.original_picture)));
        }
        this.f9754j.addAll(list);
        this.f9756l = 0;
        this.r = 0;
        this.m = 0;
        this.f9751g = null;
        this.f9752h = null;
        String str2 = u;
        us.pinguo.common.log.a.m(str2, "setImageInfos mIsOnlayouted=" + this.q, new Object[0]);
        if (this.q) {
            this.p = true;
            l();
            return;
        }
        this.p = false;
    }

    public void setOnSlideImageListener(c cVar) {
        this.o = cVar;
    }

    public void setImageInfos(List<ShowDetail.a> list) {
        setImageInfos(list, "");
    }

    public SlideImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.f9754j = new ArrayList<>(9);
        this.f9755k = new ArrayMap<>(9);
        this.f9756l = 0;
        this.n = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = new Rect();
        this.t = new a();
        this.f9750f = getContext();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.c = getResources().getDisplayMetrics().density * 1000.0f;
        this.f9748d = new GestureDetectorCompat(this.f9750f, this);
        this.f9749e = ScrollerCompat.create(this.f9750f);
        this.f9753i = getResources().getDrawable(R.drawable.store_details_default_img);
        this.q = false;
    }

    public SlideImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        this.b = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.f9754j = new ArrayList<>(9);
        this.f9755k = new ArrayMap<>(9);
        this.f9756l = 0;
        this.n = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = new Rect();
        this.t = new a();
        this.f9750f = getContext();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.c = getResources().getDisplayMetrics().density * 1000.0f;
        this.f9748d = new GestureDetectorCompat(this.f9750f, this);
        this.f9749e = ScrollerCompat.create(this.f9750f);
        this.f9753i = getResources().getDrawable(R.drawable.store_details_default_img);
        this.q = false;
    }
}
