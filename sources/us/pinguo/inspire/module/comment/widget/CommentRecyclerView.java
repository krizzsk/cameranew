package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import us.pinguo.user.recycler.FocusChildRecyclerView;
/* loaded from: classes9.dex */
public class CommentRecyclerView extends FocusChildRecyclerView {
    private int mMaxHeight;
    private OnZoomOutListener mOnZoomOutListener;

    /* loaded from: classes9.dex */
    public interface OnZoomOutListener {
        void onZoomOut();
    }

    public CommentRecyclerView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = this.mMaxHeight;
        if (i6 == 0) {
            this.mMaxHeight = i5 - i3;
            return;
        }
        int i7 = i5 - i3;
        if (i7 >= i6) {
            this.mMaxHeight = i7;
            return;
        }
        OnZoomOutListener onZoomOutListener = this.mOnZoomOutListener;
        if (onZoomOutListener != null) {
            onZoomOutListener.onZoomOut();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setOnZoomOutListener(OnZoomOutListener onZoomOutListener) {
        this.mOnZoomOutListener = onZoomOutListener;
    }

    public CommentRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
