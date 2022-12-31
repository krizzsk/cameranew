package com.pinguo.camera360.test;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.paylibcenter.bean.PayResult;
import vStudio.Android.Camera360.R;
/* compiled from: ExifTestActivity.kt */
/* loaded from: classes3.dex */
public final class ExifTestActivity extends AppCompatActivity implements View.OnClickListener {
    public Map<Integer, View> a = new LinkedHashMap();
    private File[] b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6965d;

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
            return a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b1, code lost:
        r2 = kotlin.text.s.j(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00dc, code lost:
        r2 = kotlin.text.s.j(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0107, code lost:
        r2 = kotlin.text.s.j(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String m0(androidx.exifinterface.media.ExifInterface r7) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.test.ExifTestActivity.m0(androidx.exifinterface.media.ExifInterface):java.lang.String");
    }

    private final String n0() {
        String string = getSharedPreferences("develop_mode", 0).getString("develop_last_exif_dir", us.pinguo.foundation.j.e().k("pref_camera_save_path_key", us.pinguo.image.saver.c.c));
        kotlin.jvm.internal.s.e(string);
        kotlin.jvm.internal.s.g(string, "sp.getString(DEVELOP_LAS…age.DEFAULT_DIRECTORY))!!");
        return string;
    }

    private final void o0(String str) {
        this.c = 0;
        File file = new File(str);
        File[] listFiles = file.listFiles(s.a);
        this.b = listFiles;
        if (listFiles != null && listFiles.length > 1) {
            kotlin.collections.m.k(listFiles, new a());
        }
        File[] fileArr = this.b;
        if (fileArr == null) {
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.infoText)).setText(file + " has " + fileArr.length + " images");
        if (!(fileArr.length == 0)) {
            u0(this, fileArr[this.c], false, false, 6, null);
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.fileNameText)).setText("");
        ((TextView) _$_findCachedViewById(R.id.indexIndicatorText)).setText("[0/0]");
        ((ImageView) _$_findCachedViewById(R.id.currentImage)).setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0(File it) {
        String b;
        String b2;
        String b3;
        String b4;
        StringBuilder sb = new StringBuilder();
        sb.append("check ");
        sb.append((Object) it.getName());
        sb.append(": ");
        kotlin.jvm.internal.s.g(it, "it");
        b = kotlin.io.i.b(it);
        sb.append(b);
        sb.append(", ");
        b2 = kotlin.io.i.b(it);
        sb.append(kotlin.jvm.internal.s.c(b2, "jpg"));
        Log.d("check file", sb.toString());
        b3 = kotlin.io.i.b(it);
        Locale US = Locale.US;
        kotlin.jvm.internal.s.g(US, "US");
        String lowerCase = b3.toLowerCase(US);
        kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (!kotlin.jvm.internal.s.c(lowerCase, "jpg")) {
            b4 = kotlin.io.i.b(it);
            kotlin.jvm.internal.s.g(US, "US");
            String lowerCase2 = b4.toLowerCase(US);
            kotlin.jvm.internal.s.g(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (!kotlin.jvm.internal.s.c(lowerCase2, Emoticon.TYPE_PNG)) {
                return false;
            }
        }
        return true;
    }

    private final void r0(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 <= i3) {
            i2 = i3;
        }
        if (i2 > 2000) {
            options.inSampleSize = (i2 / 2000) * 2;
        }
        Log.d("loadBitmap", kotlin.jvm.internal.s.q("inSampleSize=", Integer.valueOf(options.inSampleSize)));
        options.inJustDecodeBounds = false;
        ((ImageView) _$_findCachedViewById(R.id.currentImage)).setImageBitmap(BitmapFactory.decodeFile(str, options));
    }

    private final void s0(String str) {
        ((TextView) _$_findCachedViewById(R.id.infoText)).setText(m0(new ExifInterface(str)));
    }

    private final void t0(File file, boolean z, boolean z2) {
        ((TextView) _$_findCachedViewById(R.id.fileNameText)).setText(file.getName());
        ((TextView) _$_findCachedViewById(R.id.fileLastModifiedText)).setText("文件上次修改时间:" + file.lastModified() + '\n' + x0(file.lastModified()));
        if (z) {
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.s.g(absolutePath, "file.absolutePath");
            r0(absolutePath);
        }
        if (z2) {
            String absolutePath2 = file.getAbsolutePath();
            kotlin.jvm.internal.s.g(absolutePath2, "file.absolutePath");
            s0(absolutePath2);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.indexIndicatorText);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.c + 1);
        sb.append('/');
        File[] fileArr = this.b;
        sb.append(fileArr == null ? 0 : fileArr.length);
        sb.append(']');
        textView.setText(sb.toString());
    }

    static /* synthetic */ void u0(ExifTestActivity exifTestActivity, File file, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        exifTestActivity.t0(file, z, z2);
    }

    private final void v0(String str) {
        getSharedPreferences("develop_mode", 0).edit().putString("develop_last_exif_dir", str).apply();
    }

    private final void w0(boolean z) {
        File[] fileArr = this.b;
        if (fileArr != null && fileArr.length > 1) {
            if (z) {
                int i2 = this.c;
                if (i2 < fileArr.length - 1) {
                    this.c = i2 + 1;
                } else {
                    this.c = 0;
                }
            } else {
                int i3 = this.c;
                if (i3 > 0) {
                    this.c = i3 - 1;
                } else {
                    this.c = fileArr.length - 1;
                }
            }
            boolean z2 = ((ImageView) _$_findCachedViewById(R.id.currentImage)).getVisibility() == 0;
            t0(fileArr[this.c], z2, true);
            this.f6965d = !z2;
        }
    }

    private final String x0(long j2) {
        LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j2), ZoneId.systemDefault());
        StringBuilder sb = new StringBuilder();
        sb.append(ofInstant.getYear());
        sb.append('-');
        sb.append(ofInstant.getMonthValue());
        sb.append('-');
        sb.append(ofInstant.getDayOfMonth());
        sb.append('-');
        sb.append(ofInstant.getHour());
        sb.append(':');
        sb.append(ofInstant.getMinute());
        sb.append(':');
        sb.append(ofInstant.getSecond());
        return sb.toString();
    }

    private final String y0(String str) {
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

    private final String z0(double[] dArr) {
        if (dArr.length >= 2) {
            return dArr[0] + ", " + dArr[1];
        }
        return "";
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
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

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        String dirPath;
        VdsAgent.onClick(this, view);
        if (kotlin.jvm.internal.s.c(view, (Button) _$_findCachedViewById(R.id.hideImageBtn))) {
            int i2 = R.id.currentImage;
            if (((ImageView) _$_findCachedViewById(i2)).getVisibility() == 0) {
                ((ImageView) _$_findCachedViewById(i2)).setVisibility(4);
                return;
            }
            ((ImageView) _$_findCachedViewById(i2)).setVisibility(0);
            File[] fileArr = this.b;
            if (fileArr != null && this.f6965d) {
                if (!(fileArr.length == 0)) {
                    this.f6965d = false;
                    Log.d("ExifTestActivity", "reload image");
                    t0(fileArr[this.c], true, false);
                }
            }
        } else if (kotlin.jvm.internal.s.c(view, (Button) _$_findCachedViewById(R.id.prevBtn))) {
            w0(false);
        } else if (kotlin.jvm.internal.s.c(view, (Button) _$_findCachedViewById(R.id.nextBtn))) {
            w0(true);
        } else if (kotlin.jvm.internal.s.c(view, (Button) _$_findCachedViewById(R.id.changeDirBtn))) {
            File file = new File(((EditText) _$_findCachedViewById(R.id.filePathEditText)).getText().toString());
            if (file.exists()) {
                if (file.isDirectory()) {
                    dirPath = file.getAbsolutePath();
                } else {
                    File parentFile = file.getParentFile();
                    kotlin.jvm.internal.s.e(parentFile);
                    dirPath = parentFile.getAbsolutePath();
                }
                kotlin.jvm.internal.s.g(dirPath, "dirPath");
                o0(dirPath);
                v0(dirPath);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_exif_activity);
        ((Button) _$_findCachedViewById(R.id.changeDirBtn)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.hideImageBtn)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.prevBtn)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.nextBtn)).setOnClickListener(this);
        String n0 = n0();
        ((EditText) _$_findCachedViewById(R.id.filePathEditText)).setText(n0);
        o0(n0);
    }
}
