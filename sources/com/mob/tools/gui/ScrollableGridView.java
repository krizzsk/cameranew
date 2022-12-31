package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.GridView;
import com.mob.tools.gui.Scrollable;
/* loaded from: classes2.dex */
public class ScrollableGridView extends GridView implements Scrollable {
    private Scrollable.OnScrollListener osListener;
    private boolean pullEnable;

    public ScrollableGridView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setCacheColorHint(0);
        setSelector(new ColorDrawable());
        this.pullEnable = true;
        this.osListener = new Scrollable.OnScrollListener() { // from class: com.mob.tools.gui.ScrollableGridView.1
            @Override // com.mob.tools.gui.Scrollable.OnScrollListener
            public void onScrollChanged(Scrollable scrollable, int i2, int i3, int i4, int i5) {
                ScrollableGridView.this.pullEnable = i3 <= 0 && i5 <= 0;
            }
        };
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected int computeVerticalScrollOffset() {
        int computeVerticalScrollOffset = super.computeVerticalScrollOffset();
        Scrollable.OnScrollListener onScrollListener = this.osListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollChanged(this, 0, computeVerticalScrollOffset, 0, 0);
        }
        return computeVerticalScrollOffset;
    }

    public boolean isReadyToPull() {
        return this.pullEnable;
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
