package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes3.dex */
public class ObservableScrollView extends ScrollView {
    private a a;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ObservableScrollView observableScrollView, int i2, int i3, int i4, int i5);

        void b();
    }

    public ObservableScrollView(Context context) {
        super(context);
        this.a = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 1 && (aVar = this.a) != null) {
            aVar.b();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollViewListener(a aVar) {
        this.a = aVar;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }
}
