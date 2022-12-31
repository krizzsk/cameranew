package us.pinguo.androidsdk.pgedit;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.adv.InterstitialManager;
import com.pinguo.camera360.gallery.photopick.PhotoPickLauncher;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.admobvista.StaticsAdv.GIOStatisticManager;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.androidsdk.pgedit.PGFullScreenPicActivity;
import us.pinguo.edit2020.activity.EditActivity;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.n0;
import us.pinguo.foundation.utils.x;
import us.pinguo.share.util.InspireShareUtils;
import us.pinguo.user.util.j;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: PGEditResultActivity2.kt */
/* loaded from: classes3.dex */
public final class PGEditResultActivity2 extends BaseActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ADV_CURR_PRIORITY = "advCurrentPriority";
    public static final String PATH = "path";
    public static final int SELECT_PIC_REQUEST_CODE = 2;
    public TextView continueEdit;
    private String mAdType;
    private AdvItem mAdvItem;
    private List<? extends AdvItem> mAdvItems;
    public ImageView mBackView;
    private com.pinguo.camera360.gallery.h0.a mEditModel;
    private String mImagePath;
    public ImageView mImageView;
    private String mPicSize;
    public LinearLayout mScrollContentLayout;
    private boolean noInterstitialAds;
    public View printPhoto;
    public TextView printPhotoText;
    private String printPhotoUrl;
    private ViewGroup root;
    public TextView topToast;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Float currentPriority = Float.valueOf(0.0f);

    /* compiled from: PGEditResultActivity2.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    private final void addAttrAdv() {
        this.root = (ViewGroup) findViewById(R.id.pg_edit_result_ad_layout);
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return;
        }
        if (!s.c(AdvConstants.ADV_TYPE_ATTRIBUTE, advItem == null ? null : advItem.advType)) {
            AdvItem advItem2 = this.mAdvItem;
            if (!s.c(AdvConstants.ADV_TYPE_OPERATION, advItem2 != null ? advItem2.advType : null)) {
                return;
            }
        }
        new com.pinguo.camera360.adv.e.g.a(this, this.mAdvItem, (ViewGroup) findViewById(R.id.pg_edit_result_ad_layout)).a();
    }

    private final void addBrandAdv() {
        this.root = (ViewGroup) findViewById(R.id.pg_edit_result_ad_layout);
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return;
        }
        if (!s.c(AdvConstants.ADV_TYPE_BRAND, advItem == null ? null : advItem.advType)) {
            AdvItem advItem2 = this.mAdvItem;
            if (!s.c(AdvConstants.ADV_TYPE_SOCIALOPERATION, advItem2 != null ? advItem2.advType : null)) {
                return;
            }
        }
        new com.pinguo.camera360.adv.e.g.b(this, this.mAdvItem, (ViewGroup) findViewById(R.id.pg_edit_result_ad_layout)).a();
    }

    private final void addPGAdv() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pg_edit_result_ad_layout);
        this.root = viewGroup;
        new com.pinguo.camera360.adv.e.a(this, IADStatisticBase.UNIT_ID_RESULT_BANNER, viewGroup).g(this);
    }

    private final void back() {
        finish();
    }

    private final void continueEdit() {
        PhotoPickLauncher.c(this, 2);
    }

    private final int getAdvHeight() {
        ViewGroup viewGroup = this.root;
        s.e(viewGroup);
        viewGroup.measure(0, 0);
        ViewGroup viewGroup2 = this.root;
        s.e(viewGroup2);
        return (int) (viewGroup2.getMeasuredHeight() + (us.pinguo.foundation.t.b.a.j(this) / 1.5d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFormatFileSize(BitmapFactory.Options options, int i2) {
        if (i2 != 0 && i2 != 180) {
            StringBuilder sb = new StringBuilder();
            s.e(options);
            sb.append(options.outHeight);
            sb.append(" x ");
            sb.append(options.outWidth);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        s.e(options);
        sb2.append(options.outWidth);
        sb2.append(" x ");
        sb2.append(options.outHeight);
        return sb2.toString();
    }

    private final void gotoHome() {
        vStudio.Android.Camera360.activity.g.a(this);
    }

    private final void gotoPhotoPrint() {
        us.pinguo.foundation.statistics.h.a.a0("in", "click_entry");
        Intent intent = new Intent("camera360.webview");
        intent.putExtra("web_view_referer", "https://printshop.in66.com");
        intent.putExtra("web_view_url", this.printPhotoUrl);
        startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initAdvItem() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.androidsdk.pgedit.PGEditResultActivity2.initAdvItem():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initAdvItem$lambda-10  reason: not valid java name */
    public static final int m55initAdvItem$lambda10(AdvItem advItem, AdvItem advItem2) {
        return (int) (advItem2.priority - advItem.priority);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean initAttrAdv() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.androidsdk.pgedit.PGEditResultActivity2.initAttrAdv():boolean");
    }

    private final void initIntentData() {
        this.mImagePath = getIntent().getStringExtra(PATH);
        this.noInterstitialAds = getIntent().getBooleanExtra("no_ads", false);
    }

    private final boolean isAttrType() {
        return s.c(AdvConstants.ADV_TYPE_ATTRIBUTE, this.mAdType) || s.c(AdvConstants.ADV_TYPE_OPERATION, this.mAdType);
    }

    private final boolean isBrandType() {
        return s.c(AdvConstants.ADV_TYPE_BRAND, this.mAdType);
    }

    private final void loadImg() {
        if (this.mImagePath != null) {
            new AsyncTask<Void, Void, Object[]>() { // from class: us.pinguo.androidsdk.pgedit.PGEditResultActivity2$loadImg$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // us.pinguo.foundation.utils.AsyncTask
                public Object[] doInBackground(Void... params) {
                    String str;
                    String str2;
                    String str3;
                    s.h(params, "params");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    str = PGEditResultActivity2.this.mImagePath;
                    BitmapFactory.decodeFile(str, options);
                    str2 = PGEditResultActivity2.this.mImagePath;
                    int c = n0.c(200);
                    str3 = PGEditResultActivity2.this.mImagePath;
                    return new Object[]{options, Integer.valueOf(PGEditTools.getRotatedDegree(str2)), us.pinguo.util.e.w(str3, c, 1, true)};
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // us.pinguo.foundation.utils.AsyncTask
                public void onPostExecute(Object[] resultArray) {
                    String formatFileSize;
                    s.h(resultArray, "resultArray");
                    if (resultArray[2] != null) {
                        PGEditResultActivity2.this.getMImageView().setImageBitmap((Bitmap) resultArray[2]);
                    }
                    PGEditResultActivity2 pGEditResultActivity2 = PGEditResultActivity2.this;
                    Object obj = resultArray[1];
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    formatFileSize = pGEditResultActivity2.getFormatFileSize((BitmapFactory.Options) resultArray[0], ((Integer) obj).intValue());
                    pGEditResultActivity2.mPicSize = formatFileSize;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResult$lambda-20  reason: not valid java name */
    public static final void m56onActivityResult$lambda20(PGEditResultActivity2 this$0) {
        s.h(this$0, "this$0");
        this$0.share2World();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setAdvToBottom$lambda-19  reason: not valid java name */
    public static final void m57setAdvToBottom$lambda19(int i2, PGEditResultActivity2 this$0, int i3) {
        s.h(this$0, "this$0");
        int a = (us.pinguo.foundation.t.b.a.f().y - i2) - x.a.a(this$0);
        if (i3 < a) {
            ViewGroup viewGroup = this$0.root;
            s.e(viewGroup);
            viewGroup.setPadding(0, a - i3, 0, 0);
        }
    }

    private final void share2World() {
        j.a.b(this, new Runnable() { // from class: us.pinguo.androidsdk.pgedit.e
            @Override // java.lang.Runnable
            public final void run() {
                PGEditResultActivity2.m58share2World$lambda16(PGEditResultActivity2.this);
            }
        }, d.a, c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: share2World$lambda-16  reason: not valid java name */
    public static final void m58share2World$lambda16(PGEditResultActivity2 this$0) {
        s.h(this$0, "this$0");
        l.b("EDIT_RESULT_POST_CLICK", F$key.edit);
        InspireShareUtils.showShareDialogToSNS(this$0, this$0.mImagePath, false, true, "edit_result_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: share2World$lambda-17  reason: not valid java name */
    public static final void m59share2World$lambda17() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: share2World$lambda-18  reason: not valid java name */
    public static final void m60share2World$lambda18() {
    }

    private final void startTopToast() {
        us.pinguo.foundation.utils.f.d(new Runnable() { // from class: us.pinguo.androidsdk.pgedit.h
            @Override // java.lang.Runnable
            public final void run() {
                PGEditResultActivity2.m61startTopToast$lambda14(PGEditResultActivity2.this);
            }
        }, getResources().getInteger(17694722));
        us.pinguo.foundation.utils.f.d(new Runnable() { // from class: us.pinguo.androidsdk.pgedit.g
            @Override // java.lang.Runnable
            public final void run() {
                PGEditResultActivity2.m62startTopToast$lambda15(PGEditResultActivity2.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTopToast$lambda-14  reason: not valid java name */
    public static final void m61startTopToast$lambda14(PGEditResultActivity2 this$0) {
        s.h(this$0, "this$0");
        TextView topToast = this$0.getTopToast();
        topToast.setVisibility(0);
        VdsAgent.onSetViewVisibility(topToast, 0);
        ViewCompat.setTranslationY(this$0.getTopToast(), -this$0.getTopToast().getHeight());
        ViewCompat.animate(this$0.getTopToast()).translationY(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTopToast$lambda-15  reason: not valid java name */
    public static final void m62startTopToast$lambda15(PGEditResultActivity2 this$0) {
        s.h(this$0, "this$0");
        ViewCompat.animate(this$0.getTopToast()).translationY(-this$0.getTopToast().getHeight()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(250L).start();
    }

    private final void toFullViewPic() {
        Intent intent = new Intent(this, PGFullScreenPicActivity.class);
        PGFullScreenPicActivity.Companion companion = PGFullScreenPicActivity.Companion;
        intent.putExtra(companion.getPATH(), this.mImagePath);
        intent.putExtra(companion.getSIZE(), this.mPicSize);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, getMImageView(), "imageView").toBundle());
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

    @Override // android.app.Activity
    public void finish() {
        setResult(3);
        super.finish();
    }

    public final TextView getContinueEdit() {
        TextView textView = this.continueEdit;
        if (textView != null) {
            return textView;
        }
        s.z("continueEdit");
        throw null;
    }

    public final ImageView getMBackView() {
        ImageView imageView = this.mBackView;
        if (imageView != null) {
            return imageView;
        }
        s.z("mBackView");
        throw null;
    }

    public final ImageView getMImageView() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            return imageView;
        }
        s.z("mImageView");
        throw null;
    }

    public final LinearLayout getMScrollContentLayout() {
        LinearLayout linearLayout = this.mScrollContentLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        s.z("mScrollContentLayout");
        throw null;
    }

    @Override // us.pinguo.foundation.base.BaseActivity
    protected String getPageId() {
        return "edit_result_page";
    }

    public final View getPrintPhoto() {
        View view = this.printPhoto;
        if (view != null) {
            return view;
        }
        s.z("printPhoto");
        throw null;
    }

    public final TextView getPrintPhotoText() {
        TextView textView = this.printPhotoText;
        if (textView != null) {
            return textView;
        }
        s.z("printPhotoText");
        throw null;
    }

    public final TextView getTopToast() {
        TextView textView = this.topToast;
        if (textView != null) {
            return textView;
        }
        s.z("topToast");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 2 || i3 != -1) {
            if ((i2 == 205 || i2 == 1005) && i3 == -1) {
                getWindow().getDecorView().post(new Runnable() { // from class: us.pinguo.androidsdk.pgedit.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        PGEditResultActivity2.m56onActivityResult$lambda20(PGEditResultActivity2.this);
                    }
                });
                return;
            }
            return;
        }
        String stringExtra = intent == null ? null : intent.getStringExtra("photo_path");
        if (stringExtra == null) {
            return;
        }
        EditActivity.Companion.c(EditActivity.a, this, stringExtra, false, null, false, 16, null);
        com.pinguo.camera360.gallery.h0.a aVar = this.mEditModel;
        s.e(aVar);
        aVar.d(stringExtra, null);
        finish();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View v) {
        VdsAgent.onClick(this, v);
        s.h(v, "v");
        switch (v.getId()) {
            case R.id.header_bar_back /* 2131297032 */:
                back();
                return;
            case R.id.header_bar_photo_to_home /* 2131297033 */:
                gotoHome();
                return;
            case R.id.layout_print_photo /* 2131297368 */:
                gotoPhotoPrint();
                return;
            case R.id.result_image /* 2131297783 */:
                toFullViewPic();
                return;
            case R.id.share_2_sns /* 2131297914 */:
                share2World();
                return;
            case R.id.txt_continue_editing /* 2131298612 */:
                continueEdit();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.currentPriority = Float.valueOf(us.pinguo.repository2020.utils.o.d(us.pinguo.repository2020.utils.o.a, KEY_ADV_CURR_PRIORITY, 0.0f, null, 4, null));
        this.mAdvItems = AdvConfigManager.getInstance().getItems(InspireStaticeConfig.EDIT_RESULT_GUID);
        if (!initAttrAdv()) {
            initAdvItem();
        }
        AdvItem advItem = this.mAdvItem;
        this.mAdType = advItem == null ? null : advItem.advType;
        this.mEditModel = new com.pinguo.camera360.gallery.h0.a(this);
        Window window = getWindow();
        window.requestFeature(12);
        window.requestFeature(13);
        Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.image_transition);
        window.setEnterTransition(inflateTransition);
        window.setExitTransition(inflateTransition);
        if (isBrandType()) {
            setContentView(R.layout.pg_sdk_edit_result_single_picture);
        } else {
            setContentView(R.layout.pg_sdk_edit_result2);
        }
        us.pinguo.util.h.o(this);
        WindowManager.LayoutParams lp = window.getAttributes();
        s.g(lp, "lp");
        us.pinguo.util.h.a(lp);
        window.setAttributes(lp);
        ViewGroup.LayoutParams layoutParams = findViewById(R.id.top_res_0x7f090796).getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = us.pinguo.foundation.j.e().i("hairCut", 0);
        View findViewById = findViewById(R.id.header_bar_photo_to_home);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        TextView textView = (TextView) findViewById(R.id.share_2_sns);
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.result_image);
        s.g(findViewById2, "findViewById(R.id.result_image)");
        setMImageView((ImageView) findViewById2);
        View findViewById3 = findViewById(R.id.content_scroll_layout);
        s.g(findViewById3, "findViewById(R.id.content_scroll_layout)");
        setMScrollContentLayout((LinearLayout) findViewById3);
        View findViewById4 = findViewById(R.id.header_bar_back);
        s.g(findViewById4, "findViewById(R.id.header_bar_back)");
        setMBackView((ImageView) findViewById4);
        View findViewById5 = findViewById(R.id.txt_continue_editing);
        s.g(findViewById5, "findViewById(R.id.txt_continue_editing)");
        setContinueEdit((TextView) findViewById5);
        View findViewById6 = findViewById(R.id.layout_print_photo);
        s.g(findViewById6, "findViewById(R.id.layout_print_photo)");
        setPrintPhoto(findViewById6);
        View findViewById7 = findViewById(R.id.print_photo);
        s.g(findViewById7, "findViewById(R.id.print_photo)");
        setPrintPhotoText((TextView) findViewById7);
        View findViewById8 = findViewById(R.id.topToast);
        s.g(findViewById8, "findViewById(R.id.topToast)");
        setTopToast((TextView) findViewById8);
        getMImageView().setOnClickListener(this);
        getMBackView().setOnClickListener(this);
        getContinueEdit().setOnClickListener(this);
        getPrintPhoto().setOnClickListener(this);
        initIntentData();
        loadImg();
        if (!this.noInterstitialAds) {
            InterstitialManager.getInstance().g(this, IADStatisticBase.UNIT_ID_INTERSTITIAL_RESULT);
        }
        if (!Conditions.d() && !Conditions.e() && !Conditions.c()) {
            AdvItem itemHightPrioritys = AdvConfigManager.getInstance().getItemHightPrioritys("0a327a824aa144778b6a26aaeb39124b");
            if (itemHightPrioritys != null) {
                this.printPhotoUrl = itemHightPrioritys.interactionUri;
            }
            if (TextUtils.isEmpty(this.printPhotoUrl)) {
                View printPhoto = getPrintPhoto();
                printPhoto.setVisibility(8);
                VdsAgent.onSetViewVisibility(printPhoto, 8);
            } else {
                s.e(itemHightPrioritys);
                if (!TextUtils.isEmpty(itemHightPrioritys.name)) {
                    getPrintPhotoText().setText(itemHightPrioritys.name);
                }
                View printPhoto2 = getPrintPhoto();
                printPhoto2.setVisibility(0);
                VdsAgent.onSetViewVisibility(printPhoto2, 0);
                us.pinguo.foundation.statistics.h.a.a0("in", "show_entry");
            }
        } else {
            View printPhoto3 = getPrintPhoto();
            printPhoto3.setVisibility(8);
            VdsAgent.onSetViewVisibility(printPhoto3, 8);
        }
        startTopToast();
        this.mEnableBaseNotch = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent event) {
        s.h(event, "event");
        if (i2 == 4) {
            back();
            return true;
        }
        return super.onKeyDown(i2, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity
    public void onPageStart() {
        us.pinguo.foundation.statistics.g.f(getPageId());
        String pageId = getPageId();
        F$key f$key = F$key.edit;
        l.onEvent(pageId, f$key);
        l.b("edit_result_page", f$key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (us.pinguo.foundation.utils.i.c()) {
            return;
        }
        us.pinguo.bigdata.a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isBrandType()) {
            addBrandAdv();
        } else if (isAttrType()) {
            addAttrAdv();
        } else {
            addPGAdv();
            GIOStatisticManager.onEvent(GIOStatisticManager.KEY_ADV_RESULT_PV);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            us.pinguo.util.h.o(this);
        }
    }

    public final void setAdvToBottom() {
        getMScrollContentLayout().measure(0, 0);
        final int measuredHeight = getMScrollContentLayout().getMeasuredHeight() + getAdvHeight();
        final int dimension = (int) getResources().getDimension(R.dimen.album_header_bar_height);
        us.pinguo.foundation.ui.c.b(getMScrollContentLayout(), new Runnable() { // from class: us.pinguo.androidsdk.pgedit.f
            @Override // java.lang.Runnable
            public final void run() {
                PGEditResultActivity2.m57setAdvToBottom$lambda19(dimension, this, measuredHeight);
            }
        });
    }

    public final void setContinueEdit(TextView textView) {
        s.h(textView, "<set-?>");
        this.continueEdit = textView;
    }

    public final void setMBackView(ImageView imageView) {
        s.h(imageView, "<set-?>");
        this.mBackView = imageView;
    }

    public final void setMImageView(ImageView imageView) {
        s.h(imageView, "<set-?>");
        this.mImageView = imageView;
    }

    public final void setMScrollContentLayout(LinearLayout linearLayout) {
        s.h(linearLayout, "<set-?>");
        this.mScrollContentLayout = linearLayout;
    }

    public final void setPrintPhoto(View view) {
        s.h(view, "<set-?>");
        this.printPhoto = view;
    }

    public final void setPrintPhotoText(TextView textView) {
        s.h(textView, "<set-?>");
        this.printPhotoText = textView;
    }

    public final void setTopToast(TextView textView) {
        s.h(textView, "<set-?>");
        this.topToast = textView;
    }
}
