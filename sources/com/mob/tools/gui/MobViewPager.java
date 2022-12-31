package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public class MobViewPager extends ViewGroup {
    private static final int DECELERATION = 10;
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private int flingVelocity;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private int pageWidth;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private boolean skipScreen;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, null);
    }

    private void adjustScroller() {
        this.skipScreen = true;
        if (this.currentPage != null) {
            View focusedChild = getFocusedChild();
            View view = this.currentPage;
            if (focusedChild == view) {
                view.clearFocus();
            }
        }
        int width = (this.currentScreen * getWidth()) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            this.scroller.startScroll(getScrollX(), 0, width, 0, 0);
        }
        invalidate();
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int abs = (int) Math.abs(x - this.lastMotionX);
        if (((int) Math.abs(y - this.lastMotionY)) >= abs || abs <= this.touchSlop) {
            return;
        }
        this.touchState = 1;
        this.lastMotionX = x;
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int right;
        if (this.adapter == null) {
            return;
        }
        float x = motionEvent.getX();
        int i2 = (int) (this.lastMotionX - x);
        this.lastMotionX = x;
        if (i2 < 0) {
            if (getScrollX() > 0) {
                scrollBy(Math.max(-getScrollX(), i2), 0);
            }
        } else if (i2 <= 0 || getChildCount() == 0 || (right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth()) <= 0) {
        } else {
            scrollBy(Math.min(right, i2), 0);
        }
    }

    private void init(Context context) {
        this.scroller = new Scroller(context, new Interpolator() { // from class: com.mob.tools.gui.MobViewPager.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return (2.0f - f2) * f2;
            }
        });
        this.touchState = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i2) {
        if (this.adapter != null) {
            if (this.skipScreen && Math.abs(i2 - this.currentScreen) > 2) {
                removeAllViews();
                int i3 = this.currentScreen;
                if (i3 > 0) {
                    View view = this.adapter.getView(i3 - 1, this.previousPage, this);
                    this.previousPage = view;
                    addView(view);
                }
                View view2 = this.adapter.getView(this.currentScreen, this.currentPage, this);
                this.currentPage = view2;
                addView(view2);
                int i4 = this.currentScreen;
                if (i4 < this.screenCount - 1) {
                    View view3 = this.adapter.getView(i4 + 1, this.nextPage, this);
                    this.nextPage = view3;
                    addView(view3);
                }
            } else if (this.currentScreen > i2) {
                for (int i5 = 0; i5 < this.currentScreen - i2; i5++) {
                    int i6 = i2 + i5 + 1;
                    View view4 = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(0);
                    }
                    if (i6 < this.screenCount - 1) {
                        View view5 = this.adapter.getView(i6 + 1, view4, this);
                        this.nextPage = view5;
                        addView(view5);
                    } else {
                        this.nextPage = view4;
                    }
                }
            } else {
                for (int i7 = 0; i7 < i2 - this.currentScreen; i7++) {
                    int i8 = (i2 - i7) - 1;
                    View view6 = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i8 > 0) {
                        View view7 = this.adapter.getView(i8 - 1, view6, this);
                        this.previousPage = view7;
                        addView(view7, 0);
                    } else {
                        this.previousPage = view6;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToScreenOnUIThread(int i2, boolean z) {
        int i3;
        this.skipScreen = z;
        if (this.currentPage != null) {
            View focusedChild = getFocusedChild();
            View view = this.currentPage;
            if (focusedChild == view) {
                view.clearFocus();
            }
        }
        int width = (i2 * getWidth()) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            int i4 = 0;
            if (z) {
                i3 = 0;
            } else {
                int abs = Math.abs(width) / 2;
                int i5 = this.flingVelocity;
                if (i5 != 0) {
                    int abs2 = Math.abs(i5);
                    i4 = (int) (((abs2 - Math.sqrt((abs2 * abs2) - (Math.abs(width) * 20))) * 1000.0d) / 10.0d);
                }
                i3 = (i4 == 0 || i4 > abs) ? abs : i4;
            }
            this.scroller.startScroll(getScrollX(), 0, width, 0, i3);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
        } else {
            int i2 = this.currentScreen;
            int currX = this.scroller.getCurrX();
            int width = getWidth();
            int i3 = currX / width;
            if (currX % width > width / 2) {
                i3++;
            }
            int max = Math.max(0, Math.min(i3, this.screenCount - 1));
            this.currentScreen = max;
            if (i2 != max) {
                onScreenChange(i2);
            }
        }
        if (this.adapter != null) {
            this.adapter.onScreenChanging(getScrollX() / getWidth());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.currentScreen > 0) {
            drawChild(canvas, this.previousPage, drawingTime);
        }
        drawChild(canvas, this.currentPage, drawingTime);
        if (this.currentScreen < this.screenCount - 1) {
            drawChild(canvas, this.nextPage, drawingTime);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i2) {
        int i3;
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i2);
        }
        if (i2 == 17) {
            int i4 = this.currentScreen;
            if (i4 > 0) {
                scrollToScreenOnUIThread(i4 - 1, false);
                return true;
            }
        } else if (i2 == 66 && (i3 = this.currentScreen) < this.screenCount - 1) {
            scrollToScreenOnUIThread(i3 + 1, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i2);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Ld
            int r3 = r4.touchState
            if (r3 == 0) goto Ld
            return r2
        Ld:
            android.view.VelocityTracker r3 = r4.velocityTracker
            if (r3 != 0) goto L17
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r4.velocityTracker = r3
        L17:
            android.view.VelocityTracker r3 = r4.velocityTracker
            r3.addMovement(r5)
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L2b
            if (r0 == r1) goto L27
            r5 = 3
            if (r0 == r5) goto L2b
            goto L4d
        L27:
            r4.handleInterceptMove(r5)
            goto L4d
        L2b:
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 == 0) goto L35
            r5.recycle()
            r5 = 0
            r4.velocityTracker = r5
        L35:
            r4.touchState = r3
            goto L4d
        L38:
            float r0 = r5.getX()
            float r5 = r5.getY()
            r4.lastMotionX = r0
            r4.lastMotionY = r5
            android.widget.Scroller r5 = r4.scroller
            boolean r5 = r5.isFinished()
            r5 = r5 ^ r2
            r4.touchState = r5
        L4d:
            int r5 = r4.touchState
            if (r5 == 0) goto L52
            goto L53
        L52:
            r2 = 0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = this.currentScreen;
        int i9 = i8 * i6;
        if (i8 > 0) {
            this.previousPage.layout(i9 - i6, 0, i9, i7);
        }
        int i10 = i9 + i6;
        this.currentPage.layout(i9, 0, i10, i7);
        if (this.currentScreen < this.screenCount - 1) {
            this.nextPage.layout(i10, 0, i6 + i10, i7);
        }
        if (this.pageWidth != getWidth()) {
            int i11 = this.pageWidth;
            this.pageWidth = getWidth();
            if (i11 != 0) {
                adjustScroller();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        if (this.adapter == null) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (action != 0) {
            if (action == 1) {
                if (this.touchState == 1) {
                    this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
                    int xVelocity = (int) this.velocityTracker.getXVelocity();
                    this.flingVelocity = xVelocity;
                    if (xVelocity > 500 && (i3 = this.currentScreen) > 0) {
                        scrollToScreenOnUIThread(i3 - 1, false);
                    } else if (xVelocity < -500 && (i2 = this.currentScreen) < this.screenCount - 1) {
                        scrollToScreenOnUIThread(i2 + 1, false);
                    } else {
                        int width = getWidth();
                        scrollToScreenOnUIThread((getScrollX() + (width / 2)) / width, false);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
            } else if (action != 2) {
                if (action == 3) {
                    this.touchState = 0;
                }
            } else if (this.touchState == 1) {
                handleScrollMove(motionEvent);
            } else if (onInterceptTouchEvent(motionEvent) && this.touchState == 1) {
                handleScrollMove(motionEvent);
            }
        } else if (this.touchState != 0) {
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            this.lastMotionX = x;
        }
        return true;
    }

    public void scrollLeft(boolean z) {
        int i2 = this.currentScreen;
        if (i2 > 0) {
            scrollToScreen(i2 - 1, z);
        }
    }

    public void scrollRight(boolean z) {
        int i2 = this.currentScreen;
        if (i2 < this.screenCount - 1) {
            scrollToScreen(i2 + 1, z);
        }
    }

    public void scrollToScreen(final int i2, final boolean z) {
        post(new Runnable() { // from class: com.mob.tools.gui.MobViewPager.2
            @Override // java.lang.Runnable
            public void run() {
                MobViewPager.this.scrollToScreenOnUIThread(i2, z);
            }
        });
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        int count = viewPagerAdapter.getCount();
        this.screenCount = count;
        if (count <= 0) {
            this.currentScreen = 0;
            removeAllViews();
        } else if (count <= this.currentScreen) {
            scrollToScreenOnUIThread(count - 1, true);
        } else {
            removeAllViews();
            int i2 = this.currentScreen;
            if (i2 > 0) {
                View view = viewPagerAdapter.getView(i2 - 1, this.previousPage, this);
                this.previousPage = view;
                addView(view);
            }
            View view2 = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
            this.currentPage = view2;
            addView(view2);
            int i3 = this.currentScreen;
            if (i3 < this.screenCount - 1) {
                View view3 = viewPagerAdapter.getView(i3 + 1, this.nextPage, this);
                this.nextPage = view3;
                addView(view3);
            }
        }
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void scrollToScreen(int i2, boolean z, boolean z2) {
        scrollToScreen(i2, z);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
