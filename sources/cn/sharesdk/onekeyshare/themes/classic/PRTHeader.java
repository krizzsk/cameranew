package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.utils.ResHelper;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* loaded from: classes.dex */
public class PRTHeader extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private RotateImageView ivArrow;
    private ProgressBar pbRefreshing;
    private TextView tvHeader;

    public PRTHeader(Context context) {
        super(context);
        int[] screenSize = ResHelper.getScreenSize(context);
        float f2 = (screenSize[0] < screenSize[1] ? screenSize[0] : screenSize[1]) / 720.0f;
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(linearLayout, layoutParams);
        this.ivArrow = new RotateImageView(context);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_oks_ptr_ptr");
        if (bitmapRes > 0) {
            this.ivArrow.setImageResource(bitmapRes);
        }
        int i2 = (int) (64.0f * f2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams2.gravity = 16;
        int i3 = (int) (f2 * 24.0f);
        layoutParams2.bottomMargin = i3;
        layoutParams2.topMargin = i3;
        linearLayout.addView(this.ivArrow, layoutParams2);
        this.pbRefreshing = new ProgressBar(context);
        this.pbRefreshing.setIndeterminateDrawable(context.getResources().getDrawable(ResHelper.getBitmapRes(context, "ssdk_oks_classic_progressbar")));
        linearLayout.addView(this.pbRefreshing, layoutParams2);
        ProgressBar progressBar = this.pbRefreshing;
        progressBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(progressBar, 8);
        TextView textView = new TextView(getContext());
        this.tvHeader = textView;
        textView.setTextSize(2, 18.0f);
        this.tvHeader.setPadding(i3, 0, i3, 0);
        this.tvHeader.setTextColor(-16139513);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        linearLayout.addView(this.tvHeader, layoutParams3);
    }

    public void onPullDown(int i2) {
        if (i2 > 100) {
            int i3 = BaseBlurEffect.ROTATION_180;
            int i4 = ((i2 - 100) * BaseBlurEffect.ROTATION_180) / 20;
            if (i4 <= 180) {
                i3 = i4;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            this.ivArrow.setRotation(i3);
        } else {
            this.ivArrow.setRotation(0.0f);
        }
        if (i2 < 100) {
            int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_pull_to_refresh");
            if (stringRes > 0) {
                this.tvHeader.setText(stringRes);
                return;
            }
            return;
        }
        int stringRes2 = ResHelper.getStringRes(getContext(), "ssdk_oks_release_to_refresh");
        if (stringRes2 > 0) {
            this.tvHeader.setText(stringRes2);
        }
    }

    public void onRequest() {
        this.ivArrow.setVisibility(8);
        ProgressBar progressBar = this.pbRefreshing;
        progressBar.setVisibility(0);
        VdsAgent.onSetViewVisibility(progressBar, 0);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_oks_refreshing");
        if (stringRes > 0) {
            this.tvHeader.setText(stringRes);
        }
    }

    public void reverse() {
        ProgressBar progressBar = this.pbRefreshing;
        progressBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(progressBar, 8);
        this.ivArrow.setRotation(180.0f);
        this.ivArrow.setVisibility(0);
    }
}
