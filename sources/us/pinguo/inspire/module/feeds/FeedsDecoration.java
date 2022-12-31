package us.pinguo.inspire.module.feeds;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.inspire.module.feeds.cell.FeedsFeatureCell;
import us.pinguo.inspire.module.feeds.cell.FeedsFollowTitleCell;
import us.pinguo.inspire.module.feeds.model.FeedsTopManager;
import us.pinguo.user.R;
/* loaded from: classes9.dex */
public class FeedsDecoration extends RecyclerView.ItemDecoration {
    private Drawable mBottomShadowDrawable;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mFeedsDividerColor;
    private boolean mIsHot;
    private int mShadowHeight;
    private Drawable mTopShadowDrawable;

    public FeedsDecoration(Context context) {
        this.mShadowHeight = us.pinguo.foundation.t.b.a.a(context, 5.0f);
        this.mDividerHeight = context.getResources().getDimensionPixelSize(R.dimen.feeds_divider_height);
        this.mFeedsDividerColor = context.getResources().getColor(R.color.portal_page_bg);
        this.mDivider = new ColorDrawable(this.mFeedsDividerColor);
        try {
            this.mTopShadowDrawable = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_top);
            this.mBottomShadowDrawable = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_bottom);
        } catch (OutOfMemoryError unused) {
        }
    }

    private void drawBottomDivider(int i2, int i3, RecyclerView recyclerView, int i4, Canvas canvas) {
        int i5;
        View childAt = recyclerView.getChildAt(i4);
        int childCount = recyclerView.getChildCount();
        int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin + Math.round(ViewCompat.getTranslationY(childAt));
        int i6 = bottom + this.mDividerHeight;
        this.mDivider.setBounds(i2, bottom, i3, i6);
        this.mDivider.draw(canvas);
        if (childAt.getId() == vStudio.Android.Camera360.R.id.feeds_feature_layout) {
            drawShdow(canvas, i2, bottom, i3, i6, true, true);
            return;
        }
        int id = childAt.getId();
        int i7 = R.id.recycler_load_more_layout;
        if (id != i7 && ((i5 = i4 + 1) >= childCount || recyclerView.getChildAt(i5).getId() != i7)) {
            drawShdow(canvas, i2, bottom, i3, i6, true, true);
        } else {
            drawShdow(canvas, i2, bottom, i3, i6, false, false);
        }
    }

    private void drawShdow(Canvas canvas, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Drawable drawable = this.mTopShadowDrawable;
        if (drawable == null || this.mBottomShadowDrawable == null) {
            return;
        }
        if (z) {
            drawable.setBounds(i2, i3, i4, this.mShadowHeight + i3);
            this.mTopShadowDrawable.draw(canvas);
        }
        if (z2) {
            this.mBottomShadowDrawable.setBounds(i2, i5 - this.mShadowHeight, i3, i5);
            this.mBottomShadowDrawable.draw(canvas);
        }
    }

    private void drawTopDivider(int i2, int i3, RecyclerView recyclerView, int i4, Canvas canvas) {
        int i5;
        View childAt = recyclerView.getChildAt(i4);
        int childCount = recyclerView.getChildCount();
        int top = (childAt.getTop() - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).topMargin) + Math.round(ViewCompat.getTranslationY(childAt));
        int i6 = top - this.mDividerHeight;
        this.mDivider.setBounds(i2, i6, i3, top);
        this.mDivider.draw(canvas);
        if (childAt.getId() == vStudio.Android.Camera360.R.id.feeds_feature_layout) {
            drawShdow(canvas, i2, i6, i3, top, true, true);
            return;
        }
        int id = childAt.getId();
        int i7 = R.id.recycler_load_more_layout;
        if (id != i7 && ((i5 = i4 + 1) >= childCount || recyclerView.getChildAt(i5).getId() != i7)) {
            drawShdow(canvas, i2, i6, i3, top, true, true);
        } else {
            drawShdow(canvas, i2, i6, i3, top, false, false);
        }
    }

    private void getItemOffsetsFollow(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i2;
        int i3;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < 0) {
            return;
        }
        if (childAdapterPosition == 0) {
            if (!shouldDrawTop(recyclerView, childAdapterPosition)) {
                rect.set(0, 0, 0, 0);
                return;
            }
            int i4 = this.mDividerHeight;
            rect.set(0, i4, 0, i4);
            int itemViewType = recyclerView.getAdapter().getItemViewType(childAdapterPosition);
            rect.set(0, 0, 0, this.mDividerHeight);
            if (childAdapterPosition < 0 || itemViewType != 14 || (i3 = childAdapterPosition + 1) >= recyclerView.getAdapter().getItemCount() || recyclerView.getAdapter().getItemViewType(i3) != 14) {
                return;
            }
            rect.set(0, this.mDividerHeight, 0, 0);
            return;
        }
        int itemViewType2 = recyclerView.getAdapter().getItemViewType(childAdapterPosition);
        rect.set(0, 0, 0, this.mDividerHeight);
        if (childAdapterPosition >= 0 && itemViewType2 == 14 && (i2 = childAdapterPosition + 1) < recyclerView.getAdapter().getItemCount() && recyclerView.getAdapter().getItemViewType(i2) == 14) {
            rect.set(0, 0, 0, 0);
        }
        noDividerForNoMore(rect, view, recyclerView);
    }

    private void getItemOffsetsHot(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) >= (recyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a ? FeedsTopManager.getInsertIndex(((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getCells(), FeedsFeatureCell.class) : 0)) {
            rect.set(0, 0, 0, this.mDividerHeight);
        } else {
            rect.set(0, 0, 0, 0);
        }
        noDividerForNoMore(rect, view, recyclerView);
    }

    private void noDividerForNoMore(Rect rect, View view, RecyclerView recyclerView) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if ((childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1 || childAdapterPosition == recyclerView.getAdapter().getItemCount() - 2) && childAdapterPosition >= 0) {
            if (recyclerView.getAdapter().getItemViewType(childAdapterPosition) == 2147483643 || (childAdapterPosition < recyclerView.getAdapter().getItemCount() - 1 && recyclerView.getAdapter().getItemViewType(childAdapterPosition + 1) == 2147483643)) {
                rect.set(0, 0, 0, 0);
            }
        }
    }

    private boolean shouldDrawTop(RecyclerView recyclerView, int i2) {
        if (i2 != 0) {
            return false;
        }
        return !(((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getItem(0) instanceof FeedsFollowTitleCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mIsHot) {
            getItemOffsetsHot(rect, view, recyclerView, state);
        } else {
            getItemOffsetsFollow(rect, view, recyclerView, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            drawBottomDivider(paddingLeft, width, recyclerView, i2, canvas);
            if (shouldDrawTop(recyclerView, i2)) {
                drawTopDivider(paddingLeft, width, recyclerView, i2, canvas);
            }
        }
    }

    public void setIsHot(boolean z) {
        this.mIsHot = z;
    }
}
