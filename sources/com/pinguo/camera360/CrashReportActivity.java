package com.pinguo.camera360;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.File;
import us.pinguo.androidsdk.pgedit.PGEditTools;
import us.pinguo.foundation.utils.n0;
import us.pinguo.util.k;
import us.pinguo.util.l;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CrashReportActivity extends Activity {
    @BindView
    TextView mContentTv;

    /* loaded from: classes3.dex */
    class a extends Thread {
        final /* synthetic */ Throwable a;
        final /* synthetic */ String b;

        a(Throwable th, String str) {
            this.a = th;
            this.b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            CrashReportActivity crashReportActivity = CrashReportActivity.this;
            crashReportActivity.g(currentTimeMillis + ".err", CrashReportActivity.this.c(this.a));
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            CrashReportActivity crashReportActivity2 = CrashReportActivity.this;
            crashReportActivity2.g(currentTimeMillis + "_OOM_LEAK.txt", this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Throwable th) {
        PackageInfo packageInfo;
        String str;
        try {
            packageInfo = n0.f(this);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        String str2 = "";
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
            str = String.valueOf(packageInfo.versionCode);
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION_NAME=");
        sb.append(str2);
        sb.append('\n');
        sb.append("VERSION_CODE=");
        sb.append(str);
        sb.append('\n');
        sb.append("Build.MODEL=");
        sb.append(Build.MODEL);
        sb.append('\n');
        sb.append("Build.BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("Build.BOARD=");
        sb.append(Build.HARDWARE);
        sb.append('\n');
        sb.append("Build.VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        sb.append("Build.VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("======================STACK_TRACE=================\n");
        sb.append(th == null ? "null" : Log.getStackTraceString(th));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(View view) {
        VdsAgent.lambdaOnClick(view);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2) {
        File externalFilesDir;
        if (TextUtils.isEmpty(str2) || (externalFilesDir = getApplicationContext().getExternalFilesDir(null)) == null) {
            return;
        }
        l.k(externalFilesDir.listFiles(b.a));
        l.e(externalFilesDir);
        try {
            k.l(new File(externalFilesDir, str), str2);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.layout_bug_report);
        ButterKnife.bind(this);
        if (!PGEditTools.hasSD()) {
            this.mContentTv.setText(getResources().getString(R.string.tips_forcequit_storage_available));
        }
        Button button = (Button) findViewById(R.id.bug_btn_feed_back);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CrashReportActivity.this.e(view);
                }
            });
        }
        new a((Throwable) getIntent().getExtras().get("Stacktrace"), getIntent().getExtras().getString("LeakInfo")).start();
    }
}
