package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes9.dex */
public class FlingDownViewPager extends FixbugViewPager {
    private GestureDetector mGestureDetector;
    private OnFlingDownListener mOnFlingDownListener;

    /* loaded from: classes9.dex */
    public interface OnFlingDownListener {
        void onFlingDown();
    }

    public FlingDownViewPager(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: us.pinguo.inspire.module.comment.widget.FlingDownViewPager.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (f3 <= 0.0f || Math.abs(f3) <= Math.abs(f2) || FlingDownViewPager.this.mOnFlingDownListener == null) {
                    return false;
                }
                FlingDownViewPager.this.mOnFlingDownListener.onFlingDown();
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public void setOnFlingDownListener(OnFlingDownListener onFlingDownListener) {
        this.mOnFlingDownListener = onFlingDownListener;
    }

    public FlingDownViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
