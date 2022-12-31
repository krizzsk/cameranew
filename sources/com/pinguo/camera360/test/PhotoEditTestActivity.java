package com.pinguo.camera360.test;

import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.File;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PhotoEditTestActivity extends BaseActivity implements View.OnClickListener, u0 {
    private PowerManager.WakeLock b;
    private t0 c;
    private String a = null;

    /* renamed from: d  reason: collision with root package name */
    private EditText f6972d = null;

    /* renamed from: e  reason: collision with root package name */
    private TextView f6973e = null;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f6974f = null;

    /* renamed from: g  reason: collision with root package name */
    private Button f6975g = null;

    /* renamed from: h  reason: collision with root package name */
    private File[] f6976h = null;

    private String q0() {
        int h2 = us.pinguo.foundation.j.e().h();
        long b = us.pinguo.util.i.b(com.pinguo.camera360.m.a.d());
        String k2 = us.pinguo.foundation.j.e().k("key_front_image_crc32", "");
        return "Engin:" + Math.max(h2, 97) + " |CRC32_PREF:" + k2 + "  |CRC32_DATA:" + Long.toHexString(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean r0(File file) {
        return file.isFile() && file.getName().endsWith(".jpg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(String str) {
        TextView textView = this.f6973e;
        textView.append("Failed    " + str + '\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0() {
        this.f6973e.append("--------Over---------\n");
        this.f6975g.setEnabled(true);
        this.f6972d.setEnabled(true);
        this.f6974f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(String str) {
        TextView textView = this.f6973e;
        textView.append("Success   " + str + '\n');
    }

    @Override // com.pinguo.camera360.test.u0
    public void e0() {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.h0
            @Override // java.lang.Runnable
            public final void run() {
                PhotoEditTestActivity.this.v0();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (!this.c.d() && view.getId() == R.id.btn_test_edit) {
            try {
                int intValue = Integer.valueOf(this.f6972d.getText().toString()).intValue();
                if (intValue >= 0 && (intValue <= 100 || intValue == 999)) {
                    this.f6975g.setEnabled(false);
                    this.f6972d.setEnabled(false);
                    this.f6974f.setEnabled(false);
                    TextView textView = this.f6973e;
                    textView.setText(q0() + " |磨皮:" + intValue + "\n开始测试......\n");
                    this.c.f(this.f6976h, intValue, this.f6974f.isChecked());
                    return;
                }
                Toast makeText = Toast.makeText(this, "磨皮范围需要在[1,100]范围内, 999关闭磨皮", 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            } catch (Exception unused) {
                Toast makeText2 = Toast.makeText(this, "磨皮范围需要在[1,100]范围内, 999关闭磨皮", 0);
                makeText2.show();
                VdsAgent.showToast(makeText2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_photoedit);
        getSupportActionBar().setTitle("特效测试");
        this.f6973e = (TextView) findViewById(R.id.tv_test_edit);
        Button button = (Button) findViewById(R.id.btn_test_edit);
        this.f6975g = button;
        button.setOnClickListener(this);
        this.f6972d = (EditText) findViewById(R.id.et_skin_param);
        this.f6974f = (CheckBox) findViewById(R.id.check_box);
        PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(6, "cn");
        this.b = newWakeLock;
        newWakeLock.acquire();
        this.a = us.pinguo.foundation.utils.c0.c();
        String str = this.a + "/test_data";
        us.pinguo.util.l.f(str);
        File[] listFiles = new File(str).listFiles(i0.a);
        this.f6976h = listFiles;
        if (listFiles.length >= 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(q0() + "\n");
            sb.append("-----------需要测试的图片-------------\n");
            for (File file : this.f6976h) {
                sb.append(file.getAbsolutePath());
                sb.append("\n");
            }
            sb.append("------------------------\n");
            this.f6973e.setText(sb.toString());
        } else {
            this.f6973e.setText(q0() + "\n找不到测试照片,需要在【sdcard/test_data/】至少放一张.jpg照片\n-----------------------------\n");
        }
        t0 t0Var = new t0(us.pinguo.camera360.shop.data.i.e().l(FilterType.Effect));
        this.c = t0Var;
        t0Var.e(this);
        us.pinguo.repository2020.utils.k.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        us.pinguo.common.log.a.p();
        this.c.b();
        super.onPause();
        this.b.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        us.pinguo.common.log.a.o(this.a + "/test_data", "c360_edit");
        super.onResume();
        this.b.acquire();
    }

    @Override // com.pinguo.camera360.test.u0
    public void s(final String str) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.g0
            @Override // java.lang.Runnable
            public final void run() {
                PhotoEditTestActivity.this.t0(str);
            }
        });
    }

    @Override // com.pinguo.camera360.test.u0
    public void t(final String str) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.f0
            @Override // java.lang.Runnable
            public final void run() {
                PhotoEditTestActivity.this.x0(str);
            }
        });
    }
}
