package com.growingio.android.sdk.heatmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.growingio.android.sdk.models.HeatMapData;
import com.growingio.android.sdk.models.ViewNode;
/* loaded from: classes2.dex */
public class HeatMapNode {
    public int clickCount;
    public double clickPercent;
    public ImageView heatMapNodeView;
    public int idx;
    public View targetView;

    public HeatMapNode(ViewNode viewNode, HeatMapData.ItemBean itemBean) {
        this.idx = itemBean.getIdx();
        this.clickCount = itemBean.getCnt();
        this.clickPercent = itemBean.getPercent();
        this.targetView = viewNode.mView;
    }

    @TargetApi(11)
    public boolean canDraw() {
        View rootView;
        return (this.targetView.getVisibility() != 0 || this.targetView.getAlpha() == 0.0f || (rootView = this.targetView.getRootView()) == null || rootView.getParent() == null) ? false : true;
    }

    public void initHeatMapNodeView(Context context, Bitmap bitmap) {
        ImageView imageView = new ImageView(context);
        this.heatMapNodeView = imageView;
        imageView.setImageBitmap(bitmap);
        this.heatMapNodeView.setLayoutParams(new FrameLayout.LayoutParams(this.targetView.getWidth(), this.targetView.getHeight()));
        this.heatMapNodeView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void reset() {
    }

    public void updatePosition(int[] iArr) {
        if (this.heatMapNodeView == null) {
            return;
        }
        int width = this.targetView.getWidth();
        int height = this.targetView.getHeight();
        int[] iArr2 = new int[2];
        this.targetView.getLocationOnScreen(iArr2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heatMapNodeView.getLayoutParams();
        if (layoutParams != null && layoutParams.width == width && layoutParams.height == height && layoutParams.leftMargin == iArr2[0] && layoutParams.topMargin == iArr2[1]) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, height);
        layoutParams2.leftMargin = iArr2[0] - iArr[0];
        layoutParams2.topMargin = iArr2[1] - iArr[1];
        this.heatMapNodeView.setLayoutParams(layoutParams2);
    }
}
