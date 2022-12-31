package cn.sharesdk.onekeyshare.themes.classic.land;

import android.graphics.Bitmap;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.EditPage;
import cn.sharesdk.onekeyshare.themes.classic.XView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.ResHelper;
/* loaded from: classes.dex */
public class EditPageLand extends EditPage implements View.OnClickListener, TextWatcher, Runnable {
    private static final int DESIGN_BOTTOM_HEIGHT = 75;
    private static final int DESIGN_LEFT_PADDING = 40;
    private static final int DESIGN_REMOVE_THUMB_HEIGHT_L = 60;
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_THUMB_HEIGHT_L = 280;
    private static final int DESIGN_TITLE_HEIGHT_L = 70;

    public EditPageLand(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    private void initBody(RelativeLayout relativeLayout, float f2) {
        ScrollView scrollView = new ScrollView(this.activity);
        this.svContent = scrollView;
        relativeLayout.addView(scrollView, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        this.svContent.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(this.activity);
        this.etContent = editText;
        int i2 = (int) (40.0f * f2);
        editText.setPadding(i2, i2, i2, i2);
        this.etContent.setBackgroundDrawable(null);
        this.etContent.setTextColor(-12895429);
        this.etContent.setTextSize(2, 21.0f);
        this.etContent.setText(this.sp.getText());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.etContent, layoutParams);
        this.etContent.addTextChangedListener(this);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.activity);
        this.rlThumb = relativeLayout2;
        relativeLayout2.setBackgroundColor(-13553359);
        int i3 = (int) (280.0f * f2);
        int i4 = (int) (60.0f * f2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.topMargin = i2;
        layoutParams2.bottomMargin = i2;
        layoutParams2.rightMargin = i2;
        linearLayout.addView(this.rlThumb, layoutParams2);
        AsyncImageView asyncImageView = new AsyncImageView(this.activity) { // from class: cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand.1
            @Override // com.mob.tools.gui.AsyncImageView, com.mob.tools.gui.BitmapProcessor.BitmapCallback
            public void onImageGot(String str, Bitmap bitmap) {
                ((EditPage) EditPageLand.this).thumb = bitmap;
                super.onImageGot(str, bitmap);
            }
        };
        this.aivThumb = asyncImageView;
        asyncImageView.setScaleToCropCenter(true);
        this.rlThumb.addView(this.aivThumb, new RelativeLayout.LayoutParams(i3, i3));
        this.aivThumb.setOnClickListener(this);
        initThumb(this.aivThumb);
        XView xView = new XView(this.activity);
        this.xvRemove = xView;
        xView.setRatio(f2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i4, i4);
        layoutParams3.addRule(10);
        layoutParams3.addRule(11);
        this.rlThumb.addView(this.xvRemove, layoutParams3);
        this.xvRemove.setOnClickListener(this);
    }

    private void initBottom(LinearLayout linearLayout, float f2) {
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        linearLayout2.setPadding(0, 0, 0, 5);
        linearLayout2.setBackgroundColor(-1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, (int) (75.0f * f2)));
        TextView textView = new TextView(this.activity);
        this.tvAt = textView;
        textView.setTextColor(-12895429);
        this.tvAt.setTextSize(2, 21.0f);
        this.tvAt.setGravity(80);
        this.tvAt.setText("@");
        int i2 = (int) (40.0f * f2);
        this.tvAt.setPadding(i2, 0, i2, 0);
        linearLayout2.addView(this.tvAt, new LinearLayout.LayoutParams(-2, -1));
        this.tvAt.setOnClickListener(this);
        if (isShowAtUserLayout(this.platform.getName())) {
            TextView textView2 = this.tvAt;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
        } else {
            TextView textView3 = this.tvAt;
            textView3.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView3, 4);
        }
        TextView textView4 = new TextView(this.activity);
        this.tvTextCouter = textView4;
        textView4.setTextColor(-12895429);
        this.tvTextCouter.setTextSize(2, 18.0f);
        this.tvTextCouter.setGravity(85);
        onTextChanged(this.etContent.getText(), 0, 0, 0);
        this.tvTextCouter.setPadding(i2, 0, i2, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout2.addView(this.tvTextCouter, layoutParams);
        View view = new View(this.activity);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, f2 > 1.0f ? (int) f2 : 1));
    }

    private void initShadow(LinearLayout linearLayout, float f2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f2 > 1.0f ? (int) f2 : 1);
        View view = new View(this.activity);
        view.setBackgroundColor(687865856);
        linearLayout.addView(view, layoutParams);
        View view2 = new View(this.activity);
        view2.setBackgroundColor(335544320);
        linearLayout.addView(view2, layoutParams);
        View view3 = new View(this.activity);
        view3.setBackgroundColor(117440512);
        linearLayout.addView(view3, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initThumb(com.mob.tools.gui.AsyncImageView r7) {
        /*
            r6 = this;
            cn.sharesdk.framework.Platform$ShareParams r0 = r6.sp
            java.lang.String r0 = r0.getImageUrl()
            cn.sharesdk.framework.Platform$ShareParams r1 = r6.sp
            java.lang.String r1 = r1.getImagePath()
            cn.sharesdk.framework.Platform$ShareParams r2 = r6.sp
            java.lang.String[] r2 = r2.getImageArray()
            android.widget.RelativeLayout r3 = r6.rlThumb
            r4 = 0
            r3.setVisibility(r4)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L35
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L35
            android.graphics.Bitmap r3 = com.mob.tools.utils.BitmapHelper.getBitmap(r1)     // Catch: java.lang.Throwable -> L31
            goto L36
        L31:
            r3 = move-exception
            r3.printStackTrace()
        L35:
            r3 = 0
        L36:
            if (r3 == 0) goto L3e
            r6.thumb = r3
            r7.setBitmap(r3)
            goto L61
        L3e:
            if (r2 == 0) goto L61
            int r5 = r2.length
            if (r5 <= 0) goto L61
            r5 = r2[r4]
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L61
            java.io.File r5 = new java.io.File
            r2 = r2[r4]
            r5.<init>(r2)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L61
            android.graphics.Bitmap r3 = com.mob.tools.utils.BitmapHelper.getBitmap(r1)     // Catch: java.lang.Throwable -> L5d
            goto L61
        L5d:
            r1 = move-exception
            r1.printStackTrace()
        L61:
            if (r3 == 0) goto L69
            r6.thumb = r3
            r7.setBitmap(r3)
            goto L7f
        L69:
            if (r3 != 0) goto L75
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L75
            r7.execute(r0, r4)
            goto L7f
        L75:
            android.widget.RelativeLayout r7 = r6.rlThumb
            r0 = 8
            r7.setVisibility(r0)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r7, r0)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand.initThumb(com.mob.tools.gui.AsyncImageView):void");
    }

    private void initTitle(RelativeLayout relativeLayout, float f2) {
        TextView textView = new TextView(this.activity);
        this.tvCancel = textView;
        textView.setTextColor(-12895429);
        this.tvCancel.setTextSize(2, 18.0f);
        this.tvCancel.setGravity(17);
        int stringRes = ResHelper.getStringRes(this.activity, "ssdk_oks_cancel");
        if (stringRes > 0) {
            this.tvCancel.setText(stringRes);
        }
        int i2 = (int) (f2 * 40.0f);
        this.tvCancel.setPadding(i2, 0, i2, 0);
        relativeLayout.addView(this.tvCancel, new RelativeLayout.LayoutParams(-2, -1));
        this.tvCancel.setOnClickListener(this);
        TextView textView2 = new TextView(this.activity);
        textView2.setTextColor(-12895429);
        textView2.setTextSize(2, 22.0f);
        textView2.setGravity(17);
        int stringRes2 = ResHelper.getStringRes(this.activity, "ssdk_oks_multi_share");
        if (stringRes2 > 0) {
            textView2.setText(stringRes2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(this.activity);
        this.tvShare = textView3;
        textView3.setTextColor(-37615);
        this.tvShare.setTextSize(2, 18.0f);
        this.tvShare.setGravity(17);
        int stringRes3 = ResHelper.getStringRes(this.activity, "ssdk_oks_share");
        if (stringRes3 > 0) {
            this.tvShare.setText(stringRes3);
        }
        this.tvShare.setPadding(i2, 0, i2, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.tvShare, layoutParams2);
        this.tvShare.setOnClickListener(this);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.EditPage, com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        float screenHeight = ResHelper.getScreenHeight(this.activity) / 720.0f;
        this.maxBodyHeight = 0;
        LinearLayout linearLayout = new LinearLayout(this.activity);
        this.llPage = linearLayout;
        linearLayout.setOrientation(1);
        this.activity.setContentView(this.llPage);
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        this.rlTitle = relativeLayout;
        relativeLayout.setBackgroundColor(-1644052);
        this.llPage.addView(this.rlTitle, new LinearLayout.LayoutParams(-1, (int) (70.0f * screenHeight)));
        initTitle(this.rlTitle, screenHeight);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.activity);
        relativeLayout2.setBackgroundColor(-1);
        this.llPage.addView(relativeLayout2, new LinearLayout.LayoutParams(-1, -2));
        initBody(relativeLayout2, screenHeight);
        LinearLayout linearLayout2 = new LinearLayout(this.activity);
        linearLayout2.setOrientation(1);
        relativeLayout2.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -2));
        initShadow(linearLayout2, screenHeight);
        LinearLayout linearLayout3 = new LinearLayout(this.activity);
        this.llBottom = linearLayout3;
        linearLayout3.setOrientation(1);
        this.llPage.addView(this.llBottom, new LinearLayout.LayoutParams(-1, -2));
        initBottom(this.llBottom, screenHeight);
    }
}
