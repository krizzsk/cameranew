package com.pinguo.camera360.ui.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.pinguo.camera360.cloud.cropImage.CropImage;
import com.pinguo.camera360.ui.view.HighlightView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CropImageView extends ImageViewTouchBase {

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<HighlightView> f7028l;
    public HighlightView m;
    float n;
    float o;
    int p;

    @TargetApi(11)
    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7028l = new ArrayList<>();
        this.m = null;
        if (Build.VERSION.SDK_INT > 11) {
            setLayerType(1, null);
        }
    }

    private void p(HighlightView highlightView) {
        Rect rect = highlightView.f7030e;
        float max = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * d());
        if (Math.abs(max - d()) / max > 0.1d) {
            float[] fArr = {highlightView.f7032g.centerX(), highlightView.f7032g.centerY()};
            getImageMatrix().mapPoints(fArr);
            n(max, fArr[0], fArr[1], 300.0f);
        }
        q(highlightView);
    }

    private void q(HighlightView highlightView) {
        Rect rect = highlightView.f7030e;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max == 0 && max2 == 0) {
            return;
        }
        i(max, max2);
    }

    private void r(MotionEvent motionEvent) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7028l.size(); i3++) {
            HighlightView highlightView = this.f7028l.get(i3);
            highlightView.k(false);
            highlightView.i();
        }
        while (true) {
            if (i2 >= this.f7028l.size()) {
                break;
            }
            HighlightView highlightView2 = this.f7028l.get(i2);
            if (highlightView2.d(motionEvent.getX(), motionEvent.getY()) == 1) {
                i2++;
            } else if (!highlightView2.g()) {
                highlightView2.k(true);
                highlightView2.i();
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase
    public void j(float f2, float f3) {
        super.j(f2, f3);
        for (int i2 = 0; i2 < this.f7028l.size(); i2++) {
            HighlightView highlightView = this.f7028l.get(i2);
            highlightView.f7033h.postTranslate(f2, f3);
            highlightView.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase
    public void m(float f2, float f3, float f4) {
        super.m(f2, f3, f4);
        Iterator<HighlightView> it = this.f7028l.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.f7033h.set(getImageMatrix());
            next.i();
        }
    }

    public void o(HighlightView highlightView) {
        this.f7028l.add(highlightView);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"NewApi"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.f7028l.size(); i2++) {
            this.f7028l.get(i2).b(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f7048e.a() != null) {
            Iterator<HighlightView> it = this.f7028l.iterator();
            while (it.hasNext()) {
                HighlightView next = it.next();
                next.f7033h.set(getImageMatrix());
                next.i();
                if (next.b) {
                    p(next);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CropImage cropImage = (CropImage) getContext();
        int i2 = 0;
        if (cropImage.n) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (cropImage.m) {
                    for (int i3 = 0; i3 < this.f7028l.size(); i3++) {
                        HighlightView highlightView = this.f7028l.get(i3);
                        if (highlightView.g()) {
                            cropImage.t = highlightView;
                            for (int i4 = 0; i4 < this.f7028l.size(); i4++) {
                                if (i4 != i3) {
                                    this.f7028l.get(i4).l(true);
                                }
                            }
                            p(highlightView);
                            ((CropImage) getContext()).m = false;
                            return true;
                        }
                    }
                } else {
                    HighlightView highlightView2 = this.m;
                    if (highlightView2 != null) {
                        p(highlightView2);
                        this.m.m(HighlightView.ModifyMode.None);
                    }
                }
                this.m = null;
            } else if (action == 2) {
                if (cropImage.m) {
                    r(motionEvent);
                } else {
                    HighlightView highlightView3 = this.m;
                    if (highlightView3 != null) {
                        highlightView3.f(this.p, motionEvent.getX() - this.n, motionEvent.getY() - this.o);
                        this.n = motionEvent.getX();
                        this.o = motionEvent.getY();
                        q(this.m);
                    }
                }
            }
        } else if (cropImage.m) {
            r(motionEvent);
        } else {
            while (true) {
                if (i2 >= this.f7028l.size()) {
                    break;
                }
                HighlightView highlightView4 = this.f7028l.get(i2);
                int d2 = highlightView4.d(motionEvent.getX(), motionEvent.getY());
                if (d2 != 1) {
                    this.p = d2;
                    this.m = highlightView4;
                    this.n = motionEvent.getX();
                    this.o = motionEvent.getY();
                    this.m.m(d2 == 32 ? HighlightView.ModifyMode.Move : HighlightView.ModifyMode.Grow);
                } else {
                    i2++;
                }
            }
        }
        int action2 = motionEvent.getAction();
        if (action2 != 1) {
            if (action2 == 2 && d() == 1.0f) {
                a(true, true);
            }
        } else {
            a(true, true);
        }
        return true;
    }

    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    @Override // com.pinguo.camera360.ui.view.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(b bVar, boolean z) {
        super.setImageRotateBitmapResetBase(bVar, z);
    }
}
