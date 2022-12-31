package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class ImageActivity extends Activity {
    RelativeLayout a;
    private QQToken b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f8058d;

    /* renamed from: e  reason: collision with root package name */
    private com.tencent.connect.avatar.c f8059e;

    /* renamed from: f  reason: collision with root package name */
    private Button f8060f;

    /* renamed from: g  reason: collision with root package name */
    private Button f8061g;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.connect.avatar.b f8062h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f8063i;

    /* renamed from: j  reason: collision with root package name */
    private ProgressBar f8064j;
    private String r;
    private Bitmap s;

    /* renamed from: k  reason: collision with root package name */
    private int f8065k = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8066l = false;
    private long m = 0;
    private int n = 0;
    private final int o = VideoEdit2Activity.MIN_SCALED_SIZE;
    private final int p = VideoEdit2Activity.MIN_SCALED_SIZE;
    private Rect q = new Rect();
    private final View.OnClickListener t = new c();
    private final View.OnClickListener u = new d();
    private final IUiListener v = new f();
    private final IUiListener w = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable b2 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable b3 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable b2 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable b3 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ImageActivity.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ImageActivity imageActivity = ImageActivity.this;
            imageActivity.q = imageActivity.f8062h.a();
            ImageActivity.this.f8059e.a(ImageActivity.this.q);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class c implements View.OnClickListener {

        /* compiled from: ProGuard */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.c();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            ProgressBar progressBar = ImageActivity.this.f8064j;
            progressBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(progressBar, 0);
            ImageActivity.this.f8061g.setEnabled(false);
            ImageActivity.this.f8061g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f8060f.setEnabled(false);
            ImageActivity.this.f8060f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new a()).start();
            if (ImageActivity.this.f8066l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.m);
            if (ImageActivity.this.f8059e.b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        e(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.b(this.a, this.b);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class f extends DefaultUiListener {
        f() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f8061g.setEnabled(true);
            int i2 = -1;
            ImageActivity.this.f8061g.setTextColor(-1);
            ImageActivity.this.f8060f.setEnabled(true);
            ImageActivity.this.f8060f.setTextColor(-1);
            ProgressBar progressBar = ImageActivity.this.f8064j;
            progressBar.setVisibility(8);
            VdsAgent.onSetViewVisibility(progressBar, 8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i2 = jSONObject.getInt("ret");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 == 0) {
                ImageActivity.this.a("设置成功", 0);
                ImageActivity.this.a("10658", 0L);
                com.tencent.open.a.d.a().a(ImageActivity.this.b.getOpenId(), ImageActivity.this.b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.c != null && !"".equals(ImageActivity.this.c)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.c);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.a(0, jSONObject.toString(), null, null);
                ImageActivity.this.d();
                return;
            }
            ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
            com.tencent.open.a.d.a().a(ImageActivity.this.b.getOpenId(), ImageActivity.this.b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f8061g.setEnabled(true);
            ImageActivity.this.f8061g.setTextColor(-1);
            ImageActivity.this.f8060f.setEnabled(true);
            ImageActivity.this.f8060f.setTextColor(-1);
            ImageActivity.this.f8060f.setText("重试");
            ProgressBar progressBar = ImageActivity.this.f8064j;
            progressBar.setVisibility(8);
            VdsAgent.onSetViewVisibility(progressBar, 8);
            ImageActivity.this.f8066l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class g extends DefaultUiListener {

        /* compiled from: ProGuard */
        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.c(this.a);
            }
        }

        g() {
        }

        private void a(int i2) {
            if (ImageActivity.this.f8065k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i2 = -1;
            try {
                i2 = jSONObject.getInt("ret");
                if (i2 == 0) {
                    ImageActivity.this.f8058d.post(new a(jSONObject.getString("nickname")));
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                a(i2);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class h extends BaseApi {
        public h(ImageActivity imageActivity, QQToken qQToken) {
            super(qQToken);
        }

        public void d(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "user/set_user_face", a, "POST", tempRequestListener);
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f8058d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j2 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.b = qQToken;
        qQToken.setAccessToken(string2, ((j2 - System.currentTimeMillis()) / 1000) + "");
        this.b.setOpenId(string3);
        b();
        e();
        this.m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f8059e.setImageBitmap(null);
        Bitmap bitmap = this.s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Matrix imageMatrix = this.f8059e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = 640.0f / this.q.width();
        Rect rect = this.q;
        int i2 = (int) ((rect.left - f2) / f4);
        int i3 = i2 < 0 ? 0 : i2;
        int i4 = (int) ((rect.top - f3) / f4);
        int i5 = i4 < 0 ? 0 : i4;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i6 = (int) (650.0f / f4);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.s, i3, i5, Math.min(this.s.getWidth() - i3, i6), Math.min(this.s.getHeight() - i5, i6), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, (int) VideoEdit2Activity.MIN_SCALED_SIZE, (int) VideoEdit2Activity.MIN_SCALED_SIZE);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i2 = this.n;
        if (i2 != 0) {
            overridePendingTransition(0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f8065k++;
        new UserInfo(this, this.b).getUserInfo(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return l.a(str, this);
    }

    private void b() {
        Bitmap a2;
        try {
            a2 = a(this.r);
            this.s = a2;
        } catch (IOException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
        if (a2 != null) {
            this.f8059e.setImageBitmap(a2);
            this.f8060f.setOnClickListener(this.t);
            this.f8061g.setOnClickListener(this.u);
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new b());
            return;
        }
        throw new IOException("cannot read picture: '" + this.r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        openInputStream.close();
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        while (i3 * i4 > 4194304) {
            i3 /= 2;
            i4 /= 2;
            i2 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i2 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.a.addView(relativeLayout2);
        com.tencent.connect.avatar.c cVar = new com.tencent.connect.avatar.c(this);
        this.f8059e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f8059e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f8059e);
        this.f8062h = new com.tencent.connect.avatar.b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f8062h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f8062h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f8063i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f8063i.setLayoutParams(layoutParams6);
        this.f8063i.setEllipsize(TextUtils.TruncateAt.END);
        this.f8063i.setSingleLine();
        this.f8063i.setTextColor(-1);
        this.f8063i.setTextSize(24.0f);
        TextView textView = this.f8063i;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        linearLayout.addView(this.f8063i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a2 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a2, a2, a2, 0);
        this.a.addView(relativeLayout3);
        a aVar = new a(this);
        int a3 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a4 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f8061g = new Button(this);
        this.f8061g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f8061g.setText("取消");
        this.f8061g.setTextColor(-1);
        this.f8061g.setTextSize(18.0f);
        this.f8061g.setPadding(a3, a4, a3, a4);
        aVar.b(this.f8061g);
        relativeLayout3.addView(this.f8061g);
        this.f8060f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f8060f.setLayoutParams(layoutParams8);
        this.f8060f.setTextColor(-1);
        this.f8060f.setTextSize(18.0f);
        this.f8060f.setPadding(a3, a4, a3, a4);
        this.f8060f.setText("选取");
        aVar.a(this.f8060f);
        relativeLayout3.addView(this.f8060f);
        TextView textView2 = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView2.setLayoutParams(layoutParams9);
        textView2.setText("移动和缩放");
        textView2.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView2.setTextSize(18.0f);
        textView2.setTextColor(-1);
        relativeLayout3.addView(textView2);
        this.f8064j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f8064j.setLayoutParams(layoutParams10);
        ProgressBar progressBar = this.f8064j;
        progressBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(progressBar, 8);
        this.a.addView(this.f8064j);
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String d2 = d(str);
        if ("".equals(d2)) {
            return;
        }
        this.f8063i.setText(d2);
        TextView textView = this.f8063i;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    private void a(Bitmap bitmap) {
        new h(this, this.b).d(bitmap, this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        this.f8058d.post(new e(str, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i2);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j2) {
        l.a(this, str, j2, this.b.getAppId());
    }
}
