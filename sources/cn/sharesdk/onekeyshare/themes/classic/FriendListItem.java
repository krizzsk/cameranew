package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import cn.sharesdk.onekeyshare.themes.classic.FriendAdapter;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.ResHelper;
/* loaded from: classes.dex */
public class FriendListItem extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_ITEM_HEIGHT = 96;
    private static final int DESIGN_ITEM_PADDING = 20;
    private AsyncImageView aivIcon;
    private Bitmap bmChd;
    private Bitmap bmUnch;
    private ImageView ivCheck;
    private TextView tvName;

    public FriendListItem(Context context, float f2) {
        super(context);
        int i2 = (int) (20.0f * f2);
        setPadding(i2, 0, i2, 0);
        setMinimumHeight((int) (96.0f * f2));
        setBackgroundColor(-1);
        this.ivCheck = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.ivCheck, layoutParams);
        this.aivIcon = new AsyncImageView(context);
        int i3 = (int) (64.0f * f2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.gravity = 16;
        int i4 = (int) (f2 * 24.0f);
        layoutParams2.setMargins(i4, 0, i4, 0);
        addView(this.aivIcon, layoutParams2);
        TextView textView = new TextView(context);
        this.tvName = textView;
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.tvName.setTextSize(2, 18.0f);
        this.tvName.setSingleLine();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        addView(this.tvName, layoutParams3);
        int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_oks_classic_check_checked");
        if (bitmapRes > 0) {
            this.bmChd = BitmapFactory.decodeResource(context.getResources(), bitmapRes);
        }
        int bitmapRes2 = ResHelper.getBitmapRes(getContext(), "ssdk_oks_classic_check_default");
        if (bitmapRes2 > 0) {
            this.bmUnch = BitmapFactory.decodeResource(context.getResources(), bitmapRes2);
        }
    }

    public void update(FriendAdapter.Following following, boolean z) {
        this.tvName.setText(following.screenName);
        this.ivCheck.setImageBitmap(following.checked ? this.bmChd : this.bmUnch);
        AsyncImageView asyncImageView = this.aivIcon;
        if (asyncImageView != null) {
            if (z) {
                Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(following.icon);
                if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
                    this.aivIcon.setImageBitmap(bitmapFromCache);
                    return;
                } else {
                    this.aivIcon.execute((String) null, 0);
                    return;
                }
            }
            asyncImageView.execute(following.icon, 0);
        }
    }
}
