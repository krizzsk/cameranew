package us.pinguo.inspire.module.discovery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: ClickGrayFrameLayout.kt */
/* loaded from: classes9.dex */
public final class ClickGrayFrameLayout extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private View grayView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickGrayFrameLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    private final void hideGray() {
        View view = this.grayView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void showGray() {
        if (this.grayView == null) {
            this.grayView = findViewById(R.id.grayView);
        }
        View view = this.grayView;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                showGray();
            } else if (action == 1 || action == 3) {
                hideGray();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickGrayFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickGrayFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }
}
