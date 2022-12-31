package com.pinguo.camera360.gallery.ui;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.request.ApiGetLocationFromLatlong;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Result;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.foundation.utils.p0;
import us.pinguo.paylibcenter.bean.PayResult;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPageBottomController.kt */
/* loaded from: classes3.dex */
public final class PhotoPageBottomController implements View.OnClickListener {
    private static final Pattern m;
    private static final SimpleDateFormat n;
    private static final DateFormat o;
    private static final SimpleDateFormat p;
    private final ViewGroup a;
    private final CoordinatorLayout b;
    private final View c;

    /* renamed from: d  reason: collision with root package name */
    private final View f6459d;

    /* renamed from: e  reason: collision with root package name */
    private final BottomSheetBehavior<View> f6460e;

    /* renamed from: f  reason: collision with root package name */
    private final View f6461f;

    /* renamed from: g  reason: collision with root package name */
    private final View f6462g;

    /* renamed from: h  reason: collision with root package name */
    private final View f6463h;

    /* renamed from: i  reason: collision with root package name */
    private final c f6464i;

    /* renamed from: j  reason: collision with root package name */
    private final c f6465j;

    /* renamed from: k  reason: collision with root package name */
    private final c f6466k;

    /* renamed from: l  reason: collision with root package name */
    private b f6467l;

    /* compiled from: PhotoPageBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class a extends BottomSheetBehavior.g {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View bottomSheet, float f2) {
            kotlin.jvm.internal.s.h(bottomSheet, "bottomSheet");
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onSlide,slideOffset=", Float.valueOf(f2)), new Object[0]);
            float f3 = f2 > 0.0f ? f2 <= 0.1f ? 10 * f2 : 1.0f : 0.0f;
            PhotoPageBottomController.this.c.setAlpha(f3);
            PhotoPageBottomController.this.f6459d.setAlpha(f3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View bottomSheet, int i2) {
            kotlin.jvm.internal.s.h(bottomSheet, "bottomSheet");
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onStateChanged:", Integer.valueOf(i2)), new Object[0]);
        }
    }

    /* compiled from: PhotoPageBottomController.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void t(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoPageBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        private final ImageView a;
        private final TextView b;
        private final TextView c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f6468d;

        public c(View sheetInfoView) {
            kotlin.jvm.internal.s.h(sheetInfoView, "sheetInfoView");
            View findViewById = sheetInfoView.findViewById(R.id.imageIndicator);
            kotlin.jvm.internal.s.g(findViewById, "sheetInfoView.findViewById(R.id.imageIndicator)");
            this.a = (ImageView) findViewById;
            View findViewById2 = sheetInfoView.findViewById(R.id.h1Info);
            kotlin.jvm.internal.s.g(findViewById2, "sheetInfoView.findViewById(R.id.h1Info)");
            this.b = (TextView) findViewById2;
            View findViewById3 = sheetInfoView.findViewById(R.id.h2Info);
            kotlin.jvm.internal.s.g(findViewById3, "sheetInfoView.findViewById(R.id.h2Info)");
            this.c = (TextView) findViewById3;
            View findViewById4 = sheetInfoView.findViewById(R.id.h3Info);
            kotlin.jvm.internal.s.g(findViewById4, "sheetInfoView.findViewById(R.id.h3Info)");
            this.f6468d = (TextView) findViewById4;
        }

        public final TextView a() {
            return this.b;
        }

        public final TextView b() {
            return this.c;
        }

        public final TextView c() {
            return this.f6468d;
        }

        public final ImageView d() {
            return this.a;
        }
    }

    /* compiled from: PhotoPageBottomController.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PhotoPageBottomController.this.b.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    static {
        Pattern compile = Pattern.compile(".*[1-9].*");
        kotlin.jvm.internal.s.g(compile, "compile(\".*[1-9].*\")");
        m = compile;
        n = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.getDefault());
        o = DateFormat.getDateInstance(1, Locale.getDefault());
        p = new SimpleDateFormat("E HH:mm:ss", Locale.getDefault());
    }

    public PhotoPageBottomController(ViewGroup parent) {
        kotlin.jvm.internal.s.h(parent, "parent");
        this.a = parent;
        View inflate = View.inflate(parent.getContext(), R.layout.layout_photo_bottom_sheet, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        this.b = coordinatorLayout;
        View findViewById = coordinatorLayout.findViewById(R.id.sheet_drag_title);
        this.c = findViewById;
        View findViewById2 = coordinatorLayout.findViewById(R.id.info_indicator);
        this.f6459d = findViewById2;
        BottomSheetBehavior<View> y = BottomSheetBehavior.y(coordinatorLayout.getChildAt(0));
        kotlin.jvm.internal.s.g(y, "from(sheetRoot.getChildAt(0))");
        this.f6460e = y;
        View findViewById3 = coordinatorLayout.findViewById(R.id.share_button);
        this.f6461f = findViewById3;
        View findViewById4 = coordinatorLayout.findViewById(R.id.delete_button);
        this.f6462g = findViewById4;
        View findViewById5 = coordinatorLayout.findViewById(R.id.edit_button);
        this.f6463h = findViewById5;
        View findViewById6 = coordinatorLayout.findViewById(R.id.date_info);
        kotlin.jvm.internal.s.g(findViewById6, "sheetRoot.findViewById<View>(R.id.date_info)");
        this.f6464i = new c(findViewById6);
        View findViewById7 = coordinatorLayout.findViewById(R.id.file_info);
        kotlin.jvm.internal.s.g(findViewById7, "sheetRoot.findViewById<View>(R.id.file_info)");
        this.f6465j = new c(findViewById7);
        View findViewById8 = coordinatorLayout.findViewById(R.id.shot_info);
        kotlin.jvm.internal.s.g(findViewById8, "sheetRoot.findViewById<View>(R.id.shot_info)");
        this.f6466k = new c(findViewById8);
        parent.addView(coordinatorLayout, -1, -1);
        findViewById.setAlpha(0.0f);
        findViewById2.setAlpha(0.0f);
        p();
        findViewById3.setOnClickListener(this);
        findViewById4.setOnClickListener(this);
        findViewById5.setOnClickListener(this);
        y.o(new a());
    }

    private final void h(Date date) {
        try {
            String format = o.format(date);
            String format2 = p.format(date);
            this.f6464i.a().setText(format);
            this.f6464i.b().setText(format2);
            TextView b2 = this.f6464i.b();
            b2.setVisibility(0);
            VdsAgent.onSetViewVisibility(b2, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void i(String str, int i2, int i3) {
        String str2;
        File file = new File(str);
        this.f6465j.a().setText(file.getName());
        this.f6465j.b().setText(file.getParent());
        TextView b2 = this.f6465j.b();
        b2.setVisibility(0);
        VdsAgent.onSetViewVisibility(b2, 0);
        if (i2 <= 0 || i3 <= 0) {
            str2 = "";
        } else {
            str2 = kotlin.jvm.internal.s.q(new DecimalFormat("#.#").format((i2 * i3) / 1000000.0f), "MP") + "  " + (i2 + " x " + i3) + "  ";
        }
        this.f6465j.c().setText(kotlin.jvm.internal.s.q(str2, m(new File(str).length())));
        TextView c2 = this.f6465j.c();
        c2.setVisibility(0);
        VdsAgent.onSetViewVisibility(c2, 0);
    }

    private final void j(ExifInterface exifInterface, long j2, String str, int i2, int i3) {
        Date s = s(exifInterface);
        if (s == null) {
            s = new Date(j2);
        }
        int rotationDegrees = exifInterface.getRotationDegrees();
        h(s);
        if (rotationDegrees != 90 && rotationDegrees != 270) {
            i(str, i3, i2);
        } else {
            i(str, i2, i3);
        }
        l(exifInterface);
    }

    private final void k(double[] dArr) {
        if (dArr != null && dArr.length == 2) {
            new ApiGetLocationFromLatlong(String.valueOf(dArr[0]), String.valueOf(dArr[1])).executeSuccess(new PhotoPageBottomController$fillLocation$1(this));
            return;
        }
        TextView c2 = this.f6464i.c();
        c2.setVisibility(8);
        VdsAgent.onSetViewVisibility(c2, 8);
    }

    private final void l(ExifInterface exifInterface) {
        String attribute = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
        String attribute2 = exifInterface.getAttribute(ExifInterface.TAG_F_NUMBER);
        String attribute3 = exifInterface.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
        String x = attribute3 == null ? null : x(attribute3);
        String attribute4 = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM);
        String attribute5 = exifInterface.getAttribute(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (attribute != null) {
            this.f6466k.a().setText(attribute);
        } else {
            this.f6466k.a().setText(R.string.unknown_camera);
        }
        StringBuilder sb = new StringBuilder();
        if (attribute2 != null) {
            sb.append("f/" + ((Object) attribute2) + "  ");
        }
        if (x != null) {
            sb.append(kotlin.jvm.internal.s.q(x, "  "));
        }
        if (attribute4 != null) {
            sb.append(kotlin.jvm.internal.s.q(attribute4, "mm  "));
        }
        if (attribute5 != null) {
            sb.append(ExifInterface.TAG_RW2_ISO + ((Object) attribute5) + "  ");
        }
        if (sb.length() > 0) {
            this.f6466k.b().setText(sb);
            TextView b2 = this.f6466k.b();
            b2.setVisibility(0);
            VdsAgent.onSetViewVisibility(b2, 0);
            return;
        }
        TextView b3 = this.f6466k.b();
        b3.setVisibility(8);
        VdsAgent.onSetViewVisibility(b3, 8);
    }

    private final String m(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j2 < 1024) {
            return kotlin.jvm.internal.s.q(decimalFormat.format(j2), "B");
        }
        if (j2 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return kotlin.jvm.internal.s.q(decimalFormat.format(j2 / 1024), "K");
        }
        if (j2 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return kotlin.jvm.internal.s.q(decimalFormat.format(j2 / 1048576), "M");
        }
        return kotlin.jvm.internal.s.q(decimalFormat.format(j2 / 1073741824), "G");
    }

    private final void p() {
        this.f6464i.d().setImageResource(R.drawable.ic_photo_info_date);
        this.f6465j.d().setImageResource(R.drawable.ic_photo_info_file);
        this.f6466k.d().setImageResource(R.drawable.ic_photo_info_shot);
    }

    @RequiresApi(29)
    private final boolean q() {
        return ContextCompat.checkSelfPermission(us.pinguo.foundation.e.b(), "android.permission.ACCESS_MEDIA_LOCATION") == 0;
    }

    private final Date s(ExifInterface exifInterface) {
        Date t = t(exifInterface.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (t != null) {
            return t;
        }
        Date t2 = t(exifInterface.getAttribute(ExifInterface.TAG_DATETIME_DIGITIZED));
        return t2 != null ? t2 : t(exifInterface.getAttribute(ExifInterface.TAG_DATETIME));
    }

    private final Date t(String str) {
        if (str == null || !m.matcher(str).matches()) {
            return null;
        }
        try {
            return n.parse(str, new ParsePosition(0));
        } catch (Exception unused) {
            return null;
        }
    }

    private final String x(String str) {
        Double f2;
        double d2;
        double d3;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        f2 = kotlin.text.r.f(str);
        if (f2 == null) {
            return "0";
        }
        int floor = (int) Math.floor(f2.doubleValue());
        double doubleValue = f2.doubleValue() - floor;
        int i3 = 1;
        int i4 = 1;
        int i5 = floor;
        int i6 = 0;
        while (true) {
            double d4 = 1.0d / doubleValue;
            double floor2 = Math.floor(d4);
            d2 = i5;
            int i7 = (int) ((floor2 * d2) + i4);
            d3 = i3;
            int i8 = (int) ((floor2 * d3) + i6);
            i2 = PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
            if (i7 > 8000 || i8 > 8000) {
                break;
            }
            doubleValue = d4 - floor2;
            i6 = i3;
            i3 = i8;
            i4 = i5;
            i5 = i7;
        }
        Double valueOf = Double.valueOf(d2 / d3);
        double doubleValue2 = valueOf.doubleValue();
        double d5 = (double) PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
        if (doubleValue2 > d5) {
            i3 = 1;
        } else if (valueOf.doubleValue() < 1.0d / d5) {
            i2 = 1;
            i3 = PayResult.PAY_RESULT_ALIPAY_CHECK_IN;
        } else {
            i2 = i5;
        }
        Log.d("toFraction", kotlin.jvm.internal.s.q("consume:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('/');
        sb.append(i3);
        return sb.toString();
    }

    public final void e() {
        this.a.removeView(this.b);
    }

    public final void f() {
        this.f6460e.V(4);
    }

    public final void g() {
        this.f6460e.V(3);
    }

    public final b n() {
        return this.f6467l;
    }

    public final void o() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f6460e.B());
        translateAnimation.setDuration(125L);
        translateAnimation.setAnimationListener(new d());
        this.b.startAnimation(translateAnimation);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        b n2;
        VdsAgent.onClick(this, view);
        if (view == null || (n2 = n()) == null) {
            return;
        }
        n2.t(view);
    }

    public final boolean r() {
        return this.f6460e.C() != 4;
    }

    public final void u(b bVar) {
        this.f6467l = bVar;
    }

    public final void v(com.pinguo.camera360.gallery.data.w mediaItem, int i2, int i3) {
        Object m41constructorimpl;
        Object m41constructorimpl2;
        kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
        String filePath = mediaItem.o();
        File file = new File(filePath);
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(Boolean.valueOf(file.canRead()));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        if (file.exists() && Result.m48isSuccessimpl(m41constructorimpl)) {
            long n2 = mediaItem.n();
            if (!(mediaItem instanceof com.pinguo.camera360.gallery.data.h) && p0.a(this) && q()) {
                Uri withAppendedId = ContentUris.withAppendedId(mediaItem.y() ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaItem.r());
                kotlin.jvm.internal.s.g(withAppendedId, "withAppendedId(resourceUri, mediaItem.id)");
                Uri requireOriginal = MediaStore.setRequireOriginal(withAppendedId);
                kotlin.jvm.internal.s.g(requireOriginal, "setRequireOriginal(contentUri)");
                try {
                    Result.a aVar3 = Result.Companion;
                    m41constructorimpl2 = Result.m41constructorimpl(us.pinguo.foundation.e.b().getContentResolver().openInputStream(requireOriginal));
                } catch (Throwable th2) {
                    Result.a aVar4 = Result.Companion;
                    m41constructorimpl2 = Result.m41constructorimpl(kotlin.j.a(th2));
                }
                if (Result.m48isSuccessimpl(m41constructorimpl2)) {
                    if (Result.m47isFailureimpl(m41constructorimpl2)) {
                        m41constructorimpl2 = null;
                    }
                    InputStream inputStream = (InputStream) m41constructorimpl2;
                    if (inputStream == null) {
                        return;
                    }
                    try {
                        ExifInterface exifInterface = new ExifInterface(inputStream);
                        k(exifInterface.getLatLong());
                        kotlin.jvm.internal.s.g(filePath, "filePath");
                        j(exifInterface, n2, filePath, i3, i2);
                        kotlin.u uVar = kotlin.u.a;
                        kotlin.io.b.a(inputStream, null);
                        return;
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            kotlin.io.b.a(inputStream, th3);
                            throw th4;
                        }
                    }
                }
                Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(m41constructorimpl2);
                us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("文件打开失败==>", m44exceptionOrNullimpl != null ? m44exceptionOrNullimpl.getMessage() : null), new Object[0]);
                return;
            }
            ExifInterface exifInterface2 = new ExifInterface(mediaItem.o());
            kotlin.jvm.internal.s.g(filePath, "filePath");
            j(exifInterface2, n2, filePath, i3, i2);
            k(exifInterface2.getLatLong());
        }
    }

    public final void w() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f6460e.B(), 0.0f);
        translateAnimation.setDuration(125L);
        this.b.setVisibility(0);
        this.b.startAnimation(translateAnimation);
    }
}
