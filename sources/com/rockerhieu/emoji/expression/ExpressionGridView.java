package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.facebook.drawee.view.SimpleDraweeView;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.rockerhieu.emoji.R;
import com.rockerhieu.emoji.model.DelEmoticon;
import com.rockerhieu.emoji.model.Emoticon;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes9.dex */
public class ExpressionGridView extends GridView implements AdapterView.OnItemLongClickListener {
    private boolean a;
    private int b;
    private PopupWindow c;

    /* renamed from: d  reason: collision with root package name */
    private int f7100d;

    public ExpressionGridView(Context context) {
        super(context);
        this.b = -1;
        this.f7100d = -1;
        c(context);
    }

    private void a() {
        PopupWindow popupWindow = this.c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.c.dismiss();
    }

    private void b() {
        int i2 = this.f7100d;
        if (i2 != -1) {
            ((ImageView) getChildAt(i2)).setBackgroundDrawable(null);
        }
    }

    private void c(Context context) {
        setOnItemLongClickListener(this);
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.a) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition == this.b || pointToPosition < 0) {
                return true;
            }
            this.b = pointToPosition;
            f(pointToPosition);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void e(Emoticon emoticon, SimpleDraweeView simpleDraweeView) {
        if (emoticon == null || TextUtils.isEmpty(emoticon.pic)) {
            return;
        }
        com.facebook.drawee.backends.pipeline.e h2 = com.facebook.drawee.backends.pipeline.c.h();
        com.facebook.drawee.backends.pipeline.e a = h2.a(Uri.parse(InspirePublishFragment.FILE_HEADER + emoticon.pic));
        a.y(true);
        simpleDraweeView.setController(a.build());
    }

    private Emoticon f(int i2) {
        PopupWindow popupWindow = this.c;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.c.dismiss();
        }
        Emoticon emoticon = (Emoticon) getItemAtPosition(i2);
        if (emoticon instanceof DelEmoticon) {
            return emoticon;
        }
        if (emoticon.isSmall()) {
            g(i2, emoticon, 80, 1.64f);
        } else {
            g(i2, emoticon, BaseBlurEffect.ROTATION_180, 3.7f);
        }
        return emoticon;
    }

    private void g(int i2, Emoticon emoticon, int i3, float f2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_preview_expression, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        this.c = popupWindow;
        popupWindow.setTouchable(true);
        this.c.setOutsideTouchable(true);
        this.c.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        ImageView imageView = (ImageView) getChildAt(i2);
        b();
        imageView.setBackgroundResource(R.drawable.cornor_long_click);
        this.f7100d = i2;
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((ImageView) inflate.findViewById(R.id.iv_triangle_preview)).getLayoutParams();
        int b = a.b(getContext());
        float f3 = i3;
        int a = (int) (iArr[0] - ((a.a(getContext(), f3) - imageView.getWidth()) * 0.5d));
        float f4 = i3 + 16;
        if (a > b - a.a(getContext(), f4)) {
            a = b - a.a(getContext(), f4);
        }
        if (a < a.a(getContext(), 16.0f)) {
            a = a.a(getContext(), 16.0f);
        }
        layoutParams.setMargins(((iArr[0] - a) + (imageView.getWidth() / 2)) - a.a(getContext(), 8.5f), 0, 0, 0);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(R.id.piv_emoticon_preview);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) simpleDraweeView.getLayoutParams();
        layoutParams2.width = a.a(getContext(), f3);
        layoutParams2.height = a.a(getContext(), f3);
        layoutParams2.setMargins(0, 0, 0, a.a(getContext(), -f2) - 1);
        e(emoticon, simpleDraweeView);
        this.c.showAtLocation(this, 0, a, iArr[1] - a.a(getContext(), i3 + 10));
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (f(i2) instanceof DelEmoticon) {
            return true;
        }
        this.a = true;
        this.b = i2;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            a();
            getParent().requestDisallowInterceptTouchEvent(false);
            b();
            this.a = false;
            this.f7100d = -1;
        } else if (motionEvent.getAction() == 2) {
            return d(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public ExpressionGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.f7100d = -1;
        c(context);
    }

    public ExpressionGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = -1;
        this.f7100d = -1;
        c(context);
    }
}
