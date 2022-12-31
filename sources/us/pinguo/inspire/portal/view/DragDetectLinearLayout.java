package us.pinguo.inspire.portal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes9.dex */
public class DragDetectLinearLayout extends LinearLayout implements GestureDetector.OnGestureListener {
    private GestureDetector a;
    private GestureDetector.SimpleOnGestureListener b;

    public DragDetectLinearLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.a = new GestureDetector(getContext(), this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            return simpleOnGestureListener.onDown(motionEvent);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            simpleOnGestureListener.onFling(motionEvent, motionEvent2, f2, f3);
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            simpleOnGestureListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            return simpleOnGestureListener.onScroll(motionEvent, motionEvent2, f2, f3);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            simpleOnGestureListener.onShowPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = this.b;
        if (simpleOnGestureListener != null) {
            return simpleOnGestureListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    public void setSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.b = simpleOnGestureListener;
    }

    public DragDetectLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DragDetectLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
