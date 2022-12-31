package com.pinguo.camera360.test;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.ads.AdError;
import com.pinguo.lib.HardwareInfo;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import us.pinguo.androidsdk.PGRendererMethod;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.performance.manager.PerformanceLevelManager;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CameraInfoActivity extends BaseActivity {
    private static String a = "\n";
    @BindView
    TextView mCameraInfo;

    /* loaded from: classes3.dex */
    class a extends AsyncTask<Integer, Integer, String> {
        public a(TextView textView) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            String t0 = CameraInfoActivity.this.t0();
            CameraInfoActivity.this.v0(t0, "camera.info");
            return t0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            CameraInfoActivity.this.mCameraInfo.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPreExecute() {
            CameraInfoActivity.this.mCameraInfo.setText("开始获取相机信息");
        }
    }

    /* loaded from: classes3.dex */
    class b extends AsyncTask<Integer, Integer, String> {
        public b(TextView textView) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            String u0 = CameraInfoActivity.this.u0();
            CameraInfoActivity.this.v0(u0, "sys.info");
            return u0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            CameraInfoActivity.this.mCameraInfo.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPreExecute() {
            CameraInfoActivity.this.mCameraInfo.setText("开始获取手机信息");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t0() {
        PackageManager packageManager = getPackageManager();
        if (!(packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front") || Build.VERSION.SDK_INT > 9 || Camera.getNumberOfCameras() > 0)) {
            return new String("No Camera Here!");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int i3 = cameraInfo.facing;
            if (i3 == 1) {
                stringBuffer.append("---------------CameraId:" + i2 + "    Front Camera---------------" + a);
            } else if (i3 == 0) {
                stringBuffer.append("---------------CameraId:" + i2 + "    Back Camera----------------" + a);
            }
            Camera open = Camera.open(i2);
            String[] split = open.getParameters().flatten().split(";");
            Arrays.sort(split);
            for (String str : split) {
                stringBuffer.append(str);
                stringBuffer.append(a);
            }
            stringBuffer.append(a);
            stringBuffer.append(a);
            open.release();
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u0() {
        PerformanceLevelManager performanceLevelManager;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            if (Class.forName("com.pinguo.lib.image.PGExifInfo") != null) {
                z = false;
            }
        } catch (Exception unused) {
        }
        Integer g2 = PerformanceLevelManager.a.g();
        String str = g2 == null ? AdError.UNDEFINED_DOMAIN : "" + g2;
        sb.append(com.pinguo.camera360.d.a ? "GDPR开" : "GDPR关");
        sb.append('\n');
        sb.append(z ? "代码已混淆" : "代码未混淆");
        sb.append("\n");
        sb.append("渠道：");
        sb.append(us.pinguo.foundation.utils.i.a());
        sb.append('\n');
        sb.append(PGRendererMethod.sSupportHighFloat == null ? "还未获取到，请进入取景获取改值" : "GPU是否支持高精度:" + PGRendererMethod.sSupportHighFloat);
        sb.append("\n");
        sb.append("架构:" + us.pinguo.foundation.n.b.a() + "\n");
        sb.append("----------");
        sb.append("\n");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        sb.append("Score:");
        sb.append(HardwareInfo.get().getScore());
        sb.append("  / 2K supported:");
        sb.append(HardwareInfo.get().support2KPreview());
        sb.append("\n");
        sb.append("Level:");
        sb.append(HardwareInfo.get().getLevel());
        sb.append("\n");
        sb.append("Screen Dp:");
        sb.append((int) ((i2 / f2) + 0.5f));
        sb.append('x');
        sb.append((int) ((i3 / f2) + 0.5f));
        sb.append('\n');
        Locale a2 = us.pinguo.foundation.utils.v.a();
        sb.append("Language:");
        sb.append(a2.getLanguage());
        sb.append(PGTransHeader.CONNECTOR);
        sb.append(a2.getCountry());
        sb.append('\n');
        sb.append("-------------------");
        sb.append("\n");
        sb.append(HardwareInfo.get().getInfoString());
        sb.append("\n");
        sb.append("GPU:" + performanceLevelManager.f() + ",gpu Centurion Mark:" + str);
        sb.append("\n");
        sb.append("Android_ID:");
        sb.append(us.pinguo.bigdata.f.a.f(this));
        sb.append("\n");
        sb.append("aid:");
        sb.append(us.pinguo.bigdata.f.a.e(this));
        sb.append("\n");
        sb.append("-------------------");
        sb.append("\n");
        sb.append("Build.MODEL:");
        sb.append(Build.MODEL);
        sb.append("\n");
        sb.append("Build.BOARD:");
        sb.append(Build.BOARD);
        sb.append("\n");
        sb.append("Build.BOOTLOADER:");
        sb.append(Build.BOOTLOADER);
        sb.append("\n");
        sb.append("Build.VERSION.SDK_INT:");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("\n");
        sb.append("Build.BRAND:");
        sb.append(Build.BRAND);
        sb.append("\n");
        sb.append("Build.DEVICE:");
        sb.append(Build.DEVICE);
        sb.append("\n");
        sb.append("Build.FINGERPRINT:");
        sb.append(Build.FINGERPRINT);
        sb.append("\n");
        sb.append("Build.PRODUCT:");
        sb.append(Build.PRODUCT);
        sb.append("\n");
        sb.append("Build.HARDWARE:");
        sb.append(Build.HARDWARE);
        sb.append("\n");
        sb.append("Build.SERIAL:");
        sb.append(Build.SERIAL);
        sb.append("\n");
        sb.append("Build.CPU:");
        sb.append(Build.CPU_ABI + '/' + Build.CPU_ABI2);
        sb.append("\n");
        if (us.pinguo.util.c.f12472f) {
            String[] strArr = Build.SUPPORTED_ABIS;
            sb.append("Build.CPU_NEW_ALL:");
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append('/');
            }
            sb.append("\n");
            String[] strArr2 = Build.SUPPORTED_32_BIT_ABIS;
            sb.append("Build.CPU_NEW_32bit:");
            for (String str3 : strArr2) {
                sb.append(str3);
                sb.append('/');
            }
            sb.append("\n");
            String[] strArr3 = Build.SUPPORTED_64_BIT_ABIS;
            sb.append("Build.CPU_NEW_64bit:");
            for (String str4 : strArr3) {
                sb.append(str4);
                sb.append('/');
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str, String str2) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/camera360/" + str2);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            us.pinguo.util.k.l(file, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_camera_info);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("获取信息");
        if (us.pinguo.foundation.d.f10987f || us.pinguo.foundation.d.f10985d) {
            if ("sysinfo".equals(getIntent().getStringExtra("type"))) {
                new b(this.mCameraInfo).execute(new Integer[0]);
            } else {
                new a(this.mCameraInfo).execute(new Integer[0]);
            }
        }
    }
}
