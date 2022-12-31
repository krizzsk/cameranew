package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.module.comment.widget.CommentRecyclerView;
/* compiled from: FullScreenLayout.kt */
/* loaded from: classes9.dex */
public class FullScreenLayout extends FrameLayout {
    private int DP150;
    public Map<Integer, View> _$_findViewCache;
    private CommentRecyclerView.OnZoomOutListener onZoomOutListener;
    private int screenHeight;
    private int viewHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        init();
    }

    private final void init() {
        this.DP150 = us.pinguo.foundation.t.b.a.a(getContext(), 150.0f);
        this.screenHeight = us.pinguo.foundation.t.b.a.h(getContext());
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

    public final int getDP150() {
        return this.DP150;
    }

    public final CommentRecyclerView.OnZoomOutListener getOnZoomOutListener() {
        return this.onZoomOutListener;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        if (this.viewHeight == 0) {
            this.viewHeight = size;
        } else if (size > this.screenHeight - this.DP150) {
            this.viewHeight = size;
            CommentRecyclerView.OnZoomOutListener onZoomOutListener = this.onZoomOutListener;
            if (onZoomOutListener != null) {
                onZoomOutListener.onZoomOut();
            }
        }
        us.pinguo.common.log.a.k("height:" + size + " viewHeight:" + this.viewHeight, new Object[0]);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.viewHeight, 1073741824));
    }

    public final void setDP150(int i2) {
        this.DP150 = i2;
    }

    public final void setOnZoomOutListener(CommentRecyclerView.OnZoomOutListener onZoomOutListener) {
        this.onZoomOutListener = onZoomOutListener;
    }

    public final void setScreenHeight(int i2) {
        this.screenHeight = i2;
    }

    public final void setViewHeight(int i2) {
        this.viewHeight = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        init();
    }
}
