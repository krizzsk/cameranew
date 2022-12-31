package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DragDetectLayout extends FrameLayout {
    private GestureDetector a;
    private GestureDetector.SimpleOnGestureListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements GestureDetector.OnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (DragDetectLayout.this.b != null) {
                return DragDetectLayout.this.b.onDown(motionEvent);
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (DragDetectLayout.this.b != null) {
                DragDetectLayout.this.b.onFling(motionEvent, motionEvent2, f2, f3);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (DragDetectLayout.this.b != null) {
                DragDetectLayout.this.b.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (DragDetectLayout.this.b != null) {
                return DragDetectLayout.this.b.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (DragDetectLayout.this.b != null) {
                DragDetectLayout.this.b.onShowPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (DragDetectLayout.this.b != null) {
                return DragDetectLayout.this.b.onSingleTapUp(motionEvent);
            }
            return false;
        }
    }

    public DragDetectLayout(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.a = new GestureDetector(getContext(), new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.b = simpleOnGestureListener;
    }

    public DragDetectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public DragDetectLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
