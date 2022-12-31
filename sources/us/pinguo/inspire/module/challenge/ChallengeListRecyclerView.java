package us.pinguo.inspire.module.challenge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.user.recycler.FocusChildRecyclerView;
import vStudio.Android.Camera360.R;
/* compiled from: ChallengeListRecyclerView.kt */
/* loaded from: classes9.dex */
public final class ChallengeListRecyclerView extends FocusChildRecyclerView {
    public Map<Integer, View> _$_findViewCache;

    public ChallengeListRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this._$_findViewCache = new LinkedHashMap();
    }

    private final boolean checkInBounds(float f2, float f3, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return f2 >= ((float) iArr[0]) && f2 <= ((float) (iArr[0] + view.getWidth())) && f3 >= ((float) iArr[1]) && f3 <= ((float) (iArr[1] + view.getHeight()));
    }

    private final boolean checkTouchAreaInChildRecyclerView(MotionEvent motionEvent) {
        View findViewById;
        if (getChildCount() <= 0) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            int i3 = i2 + 1;
            View child = getChildAt(i2);
            s.g(child, "child");
            if (checkInBounds(rawX, rawY, child) && (findViewById = child.findViewById(R.id.rv_discovery_square_hor_video)) != null) {
                return checkInBounds(rawX, rawY, findViewById);
            }
            i2 = i3;
        }
        return false;
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
    public boolean dispatchTouchEvent(MotionEvent ev) {
        s.h(ev, "ev");
        if (ev.getAction() == 0 && checkTouchAreaInChildRecyclerView(ev)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    public ChallengeListRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChallengeListRecyclerView(Context context) {
        this(context, null);
    }
}
