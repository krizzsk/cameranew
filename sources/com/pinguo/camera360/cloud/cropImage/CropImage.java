package com.pinguo.camera360.cloud.cropImage;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.media.ExifInterface;
import android.media.FaceDetector;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.cloud.cropImage.BitmapManager;
import com.pinguo.camera360.cloud.cropImage.MonitoredActivity;
import com.pinguo.camera360.ui.view.CropImageView;
import com.pinguo.camera360.ui.view.HighlightView;
import com.pinguo.camera360.ui.view.TitleView;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CropImage extends MonitoredActivity implements TitleView.d {

    /* renamed from: d  reason: collision with root package name */
    private int f6263d;

    /* renamed from: e  reason: collision with root package name */
    private int f6264e;

    /* renamed from: i  reason: collision with root package name */
    private int f6268i;

    /* renamed from: j  reason: collision with root package name */
    private int f6269j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6270k;
    public boolean m;
    public boolean n;
    private CropImageView o;
    private ContentResolver p;
    private Bitmap q;
    private com.pinguo.camera360.cloud.cropImage.c r;
    public HighlightView t;
    private Bitmap.CompressFormat b = Bitmap.CompressFormat.JPEG;
    private Uri c = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6265f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6266g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f6267h = new Handler();

    /* renamed from: l  reason: collision with root package name */
    private boolean f6271l = true;
    private final BitmapManager.b s = new BitmapManager.b();
    Runnable u = new d();

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            CropImage.this.D0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ CountDownLatch b;

            a(Bitmap bitmap, CountDownLatch countDownLatch) {
                this.a = bitmap;
                this.b = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a != CropImage.this.q && this.a != null) {
                    CropImage.this.o.setImageBitmapResetBase(this.a, true);
                    CropImage.this.q.recycle();
                    CropImage.this.q = this.a;
                }
                if (CropImage.this.o.d() == 1.0f) {
                    CropImage.this.o.a(true, true);
                }
                this.b.countDown();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            CropImage.this.f6267h.post(new a(CropImage.this.q, countDownLatch));
            try {
                countDownLatch.await();
                CropImage.this.u.run();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        final /* synthetic */ Bitmap a;

        c(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImage.this.E0(this.a);
        }
    }

    /* loaded from: classes3.dex */
    class d implements Runnable {
        Matrix b;

        /* renamed from: d  reason: collision with root package name */
        int f6272d;
        float a = 1.0f;
        FaceDetector.Face[] c = new FaceDetector.Face[3];

        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                CropImage cropImage = CropImage.this;
                int i2 = dVar.f6272d;
                cropImage.m = i2 > 1;
                if (i2 > 0) {
                    int i3 = 0;
                    while (true) {
                        d dVar2 = d.this;
                        if (i3 >= dVar2.f6272d) {
                            break;
                        }
                        dVar2.c(dVar2.c[i3]);
                        i3++;
                    }
                } else {
                    dVar.d();
                }
                CropImage.this.o.invalidate();
                if (CropImage.this.o.f7028l.size() == 1) {
                    CropImage cropImage2 = CropImage.this;
                    cropImage2.t = cropImage2.o.f7028l.get(0);
                    CropImage.this.t.k(true);
                }
                d dVar3 = d.this;
                if (dVar3.f6272d > 1) {
                    Toast makeText = Toast.makeText(CropImage.this, (int) R.string.multiface_crop_help, 0);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                }
            }
        }

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(FaceDetector.Face face) {
            PointF pointF = new PointF();
            face.getMidPoint(pointF);
            float f2 = pointF.x;
            float f3 = this.a;
            float f4 = f2 * f3;
            pointF.x = f4;
            float f5 = pointF.y * f3;
            pointF.y = f5;
            HighlightView highlightView = new HighlightView(CropImage.this.o);
            Rect rect = new Rect(0, 0, CropImage.this.q.getWidth(), CropImage.this.q.getHeight());
            float f6 = (int) f4;
            float f7 = (int) f5;
            RectF rectF = new RectF(f6, f7, f6, f7);
            float f8 = -(((int) (face.eyesDistance() * this.a)) * 2);
            rectF.inset(f8, f8);
            float f9 = rectF.left;
            if (f9 < 0.0f) {
                rectF.inset(-f9, -f9);
            }
            float f10 = rectF.top;
            if (f10 < 0.0f) {
                rectF.inset(-f10, -f10);
            }
            float f11 = rectF.right;
            int i2 = rect.right;
            if (f11 > i2) {
                rectF.inset(f11 - i2, f11 - i2);
            }
            float f12 = rectF.bottom;
            int i3 = rect.bottom;
            if (f12 > i3) {
                rectF.inset(f12 - i3, f12 - i3);
            }
            highlightView.n(this.b, rect, rectF, CropImage.this.f6266g, (CropImage.this.f6263d == 0 || CropImage.this.f6264e == 0) ? false : true);
            CropImage.this.o.o(highlightView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            int i2;
            HighlightView highlightView = new HighlightView(CropImage.this.o);
            int width = CropImage.this.q.getWidth();
            int height = CropImage.this.q.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int min = (Math.min(width, height) * 4) / 5;
            if (CropImage.this.f6263d == 0 || CropImage.this.f6264e == 0) {
                i2 = min;
            } else if (CropImage.this.f6263d > CropImage.this.f6264e) {
                i2 = (CropImage.this.f6264e * min) / CropImage.this.f6263d;
            } else {
                i2 = min;
                min = (CropImage.this.f6263d * min) / CropImage.this.f6264e;
            }
            int i3 = (width - min) / 2;
            int i4 = (height - i2) / 2;
            highlightView.n(this.b, rect, new RectF(i3, i4, i3 + min, i4 + i2), CropImage.this.f6266g, (CropImage.this.f6263d == 0 || CropImage.this.f6264e == 0) ? false : true);
            CropImage.this.o.o(highlightView);
        }

        private Bitmap e() {
            if (CropImage.this.q == null) {
                return null;
            }
            if (CropImage.this.q.getWidth() > 256) {
                this.a = 256.0f / CropImage.this.q.getWidth();
            }
            Matrix matrix = new Matrix();
            float f2 = this.a;
            matrix.setScale(f2, f2);
            return Bitmap.createBitmap(CropImage.this.q, 0, 0, CropImage.this.q.getWidth(), CropImage.this.q.getHeight(), matrix, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = CropImage.this.o.getImageMatrix();
            Bitmap e2 = e();
            this.a = 1.0f / this.a;
            if (e2 != null && CropImage.this.f6265f) {
                this.f6272d = new FaceDetector(e2.getWidth(), e2.getHeight(), this.c.length).findFaces(e2, this.c);
            }
            if (e2 != null && e2 != CropImage.this.q) {
                e2.recycle();
            }
            CropImage.this.f6267h.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e extends MonitoredActivity.a implements Runnable {
        private final MonitoredActivity a;
        private final ProgressDialog b;
        private final Runnable c;

        /* renamed from: d  reason: collision with root package name */
        private final Handler f6274d;

        /* renamed from: e  reason: collision with root package name */
        private final Runnable f6275e = new a();

        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.a.r0(e.this);
                if (e.this.b.getWindow() != null) {
                    e.this.b.dismiss();
                }
            }
        }

        public e(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.a = monitoredActivity;
            this.b = progressDialog;
            this.c = runnable;
            monitoredActivity.q0(this);
            this.f6274d = handler;
        }

        @Override // com.pinguo.camera360.cloud.cropImage.MonitoredActivity.b
        public void b(MonitoredActivity monitoredActivity) {
            this.f6275e.run();
            this.f6274d.removeCallbacks(this.f6275e);
        }

        @Override // com.pinguo.camera360.cloud.cropImage.MonitoredActivity.b
        public void c(MonitoredActivity monitoredActivity) {
            ProgressDialog progressDialog = this.b;
            progressDialog.show();
            VdsAgent.showDialog(progressDialog);
        }

        @Override // com.pinguo.camera360.cloud.cropImage.MonitoredActivity.b
        public void d(MonitoredActivity monitoredActivity) {
            this.b.hide();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } finally {
                this.f6274d.post(this.f6275e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.pinguo.camera360.cloud.cropImage.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.pinguo.camera360.cloud.cropImage.c C0(android.content.Context r9, android.net.Uri r10, int r11) {
        /*
            long r0 = android.content.ContentUris.parseId(r10)
            android.content.ContentResolver r9 = r9.getContentResolver()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "_id="
            r10.append(r2)
            java.lang.String r2 = java.lang.Long.toString(r0)
            r10.append(r2)
            java.lang.String r5 = r10.toString()
            r10 = 0
            if (r11 != 0) goto L23
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            goto L25
        L23:
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
        L25:
            r8 = r2
            if (r11 != 0) goto L2b
            java.lang.String[] r11 = com.pinguo.camera360.cloud.cropImage.a.a     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            goto L2d
        L2b:
            java.lang.String[] r11 = com.pinguo.camera360.cloud.cropImage.a.b     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
        L2d:
            r4 = r11
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r8
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            if (r11 == 0) goto L66
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            if (r2 == 0) goto L66
            com.pinguo.camera360.cloud.cropImage.c r2 = new com.pinguo.camera360.cloud.cropImage.c     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            r10.<init>()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            java.lang.String r3 = r8.toString()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            r10.append(r3)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            java.lang.String r3 = "/"
            r10.append(r3)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            com.pinguo.camera360.cloud.cropImage.a.b(r2, r9, r11, r10)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L5f
            r10 = r2
            goto L66
        L5d:
            r9 = move-exception
            goto L64
        L5f:
            r9 = move-exception
            r10 = r11
            goto L98
        L62:
            r9 = move-exception
            r2 = r10
        L64:
            r10 = r11
            goto L70
        L66:
            if (r11 == 0) goto L93
            r11.close()
            goto L93
        L6c:
            r9 = move-exception
            goto L98
        L6e:
            r9 = move-exception
            r2 = r10
        L70:
            java.lang.String r11 = "CropImage"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r4 = "createMediaItemFromUri exception="
            r3.append(r4)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L6c
            r3.append(r9)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> L6c
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6c
            us.pinguo.common.log.a.m(r11, r9, r3)     // Catch: java.lang.Throwable -> L6c
            if (r10 == 0) goto L92
            r10.close()
        L92:
            r10 = r2
        L93:
            if (r10 == 0) goto L97
            r10.a = r0
        L97:
            return r10
        L98:
            if (r10 == 0) goto L9d
            r10.close()
        L9d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.cloud.cropImage.CropImage.C0(android.content.Context, android.net.Uri, int):com.pinguo.camera360.cloud.cropImage.c");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        HighlightView highlightView;
        int i2;
        Bitmap createBitmap;
        if (this.n || (highlightView = this.t) == null) {
            return;
        }
        this.n = true;
        Rect c2 = highlightView.c();
        int width = c2.width();
        int height = c2.height();
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, this.f6266g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        new Canvas(createBitmap2).drawBitmap(this.q, c2, new Rect(0, 0, width, height), (Paint) null);
        if (this.f6266g) {
            Canvas canvas = new Canvas(createBitmap2);
            Path path = new Path();
            float f2 = width / 2.0f;
            path.addCircle(f2, height / 2.0f, f2, Path.Direction.CW);
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        int i3 = this.f6268i;
        if (i3 != 0 && (i2 = this.f6269j) != 0) {
            if (this.f6270k) {
                createBitmap = us.pinguo.util.e.x(new Matrix(), createBitmap2, this.f6268i, this.f6269j, this.f6271l);
                if (createBitmap2 != createBitmap) {
                    createBitmap2.recycle();
                }
            } else {
                createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.RGB_565);
                Canvas canvas2 = new Canvas(createBitmap);
                Rect c3 = this.t.c();
                Rect rect = new Rect(0, 0, this.f6268i, this.f6269j);
                int width2 = (c3.width() - rect.width()) / 2;
                int height2 = (c3.height() - rect.height()) / 2;
                c3.inset(Math.max(0, width2), Math.max(0, height2));
                rect.inset(Math.max(0, -width2), Math.max(0, -height2));
                canvas2.drawBitmap(this.q, c3, rect, (Paint) null);
                createBitmap2.recycle();
            }
            createBitmap2 = createBitmap;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && (extras.getParcelable("data") != null || extras.getBoolean("return-data"))) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", createBitmap2);
            setResult(-1, new Intent().setAction("inline-data").putExtras(bundle));
            finish();
            return;
        }
        F0(this, null, getResources().getString(R.string.saving_image_res_0x7f110504), new c(createBitmap2), this.f6267h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UseValueOf"})
    public void E0(Bitmap bitmap) {
        OutputStream outputStream;
        Double d2;
        Double d3;
        Uri uri = this.c;
        int i2 = 0;
        if (uri != null) {
            try {
                outputStream = this.p.openOutputStream(uri);
                if (outputStream != null) {
                    try {
                        try {
                            try {
                                bitmap.compress(this.b, 75, outputStream);
                            } catch (IOException unused) {
                                us.pinguo.common.log.a.g("CropImage", "Cannot open file: " + this.c, new Object[0]);
                                n0.a(outputStream);
                                setResult(-1, new Intent(this.c.toString()).putExtras(new Bundle()));
                                bitmap.recycle();
                                finish();
                            }
                        } catch (IOException unused2) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        n0.a(outputStream);
                        throw th;
                    }
                }
            } catch (IOException unused3) {
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                n0.a(outputStream);
                throw th;
            }
            n0.a(outputStream);
            setResult(-1, new Intent(this.c.toString()).putExtras(new Bundle()));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("rect", this.t.c().toString());
            if (this.r != null) {
                File file = new File(this.r.m);
                File file2 = new File(file.getParent());
                String name = file.getName();
                String substring = name.substring(0, name.lastIndexOf("."));
                while (true) {
                    i2++;
                    if (!new File(file2.toString() + "/" + substring + PGTransHeader.CONNECTOR + i2 + ".jpg").exists()) {
                        break;
                    }
                }
                com.pinguo.camera360.cloud.cropImage.c cVar = this.r;
                String str = substring + PGTransHeader.CONNECTOR + i2;
                String str2 = str + ".jpg";
                int[] iArr = new int[1];
                if (cVar.b()) {
                    d2 = new Double(cVar.f6278f);
                    d3 = new Double(cVar.f6279g);
                } else {
                    d2 = null;
                    d3 = null;
                }
                Uri a2 = ImageManager.a(this.p, str, cVar.f6282j, cVar.f6280h, d2, d3, file2.toString(), str2, bitmap, null, iArr);
                if (a2 != null) {
                    setResult(-1, new Intent().setAction(a2.toString()).putExtras(bundle));
                } else {
                    setResult(-1, new Intent().setAction(null));
                }
            }
        }
        bitmap.recycle();
        finish();
    }

    public static void F0(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new e(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }

    private void G0() {
        if (isFinishing()) {
            return;
        }
        this.o.setImageBitmapResetBase(this.q, true);
        F0(this, null, getResources().getString(R.string.running_face_detection), new b(), this.f6267h);
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void W() {
        setResult(0);
        finish();
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void f() {
        setResult(0);
        finish();
    }

    @Override // com.pinguo.camera360.cloud.cropImage.MonitoredActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        com.pinguo.camera360.cloud.cropImage.c cVar;
        String string;
        super.onCreate(bundle);
        this.p = getContentResolver();
        requestWindowFeature(1);
        setContentView(R.layout.cropimage);
        TitleView titleView = (TitleView) findViewById(R.id.advanceModifyPicTitle);
        titleView.setTiTleText(R.string.crop_image);
        titleView.setOnTitleViewClickListener(this);
        this.o = (CropImageView) findViewById(R.id.image);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        us.pinguo.common.log.a.m("CropImage", "CropImage intent=" + intent.toString(), new Object[0]);
        us.pinguo.common.log.a.m("CropImage", "CropImage extras=" + extras, new Object[0]);
        if (extras != null) {
            if (extras.getString("circleCrop") != null) {
                this.f6266g = true;
                this.f6263d = 1;
                this.f6264e = 1;
            }
            Uri uri = (Uri) extras.getParcelable("output");
            this.c = uri;
            if (uri != null && (string = extras.getString("outputFormat")) != null) {
                this.b = Bitmap.CompressFormat.valueOf(string);
            }
            this.q = (Bitmap) extras.getParcelable("data");
            this.f6263d = extras.getInt("aspectX");
            this.f6264e = extras.getInt("aspectY");
            this.f6268i = extras.getInt("outputX");
            this.f6269j = extras.getInt("outputY");
            this.f6270k = extras.getBoolean("scale", true);
            this.f6271l = extras.getBoolean("scaleUpIfNeeded", true);
            this.f6265f = (extras.containsKey("noFaceDetection") && extras.getBoolean("noFaceDetection")) ? false : true;
        }
        if (this.q == null) {
            Uri data = intent.getData();
            us.pinguo.common.log.a.m("CropImage", "target=" + data, new Object[0]);
            String scheme = data.getScheme();
            if (scheme.equals(FirebaseAnalytics.Param.CONTENT)) {
                try {
                    this.r = C0(this, data, 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            try {
                cVar = this.r;
            } catch (IOException | URISyntaxException unused) {
            }
            if (cVar != null) {
                i2 = (int) cVar.f6284l;
                try {
                    this.q = f.d(this, cVar.c, 1024, 1024, 0L, null);
                } catch (IOException | URISyntaxException unused2) {
                }
            } else {
                this.q = f.d(this, data.toString(), 1024, 1024, 0L, null);
                if (scheme.equals("file")) {
                    i2 = (int) com.pinguo.camera360.cloud.cropImage.d.a(new ExifInterface(data.getPath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                }
                i2 = 0;
            }
            Bitmap bitmap = this.q;
            if (bitmap != null && i2 != 0.0f) {
                this.q = us.pinguo.util.e.s(bitmap, i2);
            }
        }
        if (this.q == null) {
            us.pinguo.common.log.a.g("CropImage", "Cannot load bitmap, exiting.", new Object[0]);
            finish();
            return;
        }
        getWindow().addFlags(1024);
        ImageView imageView = (ImageView) findViewById(R.id.title_right_img_btn);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.crop_image_save);
        imageView.setOnClickListener(new a());
        G0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BitmapManager.d().a(this.s);
    }
}
