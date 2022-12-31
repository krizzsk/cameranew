package com.pinguo.camera360.camera.options;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsSavePath extends BaseActivity implements View.OnClickListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f6246i = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: j  reason: collision with root package name */
    static FileFilter f6247j = g0.a;

    /* renamed from: k  reason: collision with root package name */
    static Comparator<HashMap<String, Object>> f6248k = new a();
    private TextView a;
    private int b;
    private File c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f6249d;

    /* renamed from: e  reason: collision with root package name */
    private ListView f6250e;

    /* renamed from: f  reason: collision with root package name */
    private Button f6251f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6252g;

    /* renamed from: h  reason: collision with root package name */
    AdapterView.OnItemClickListener f6253h = new AdapterView.OnItemClickListener() { // from class: com.pinguo.camera360.camera.options.h0
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            OptionsSavePath.this.w0(adapterView, view, i2, j2);
        }
    };

    /* loaded from: classes3.dex */
    class a implements Comparator<HashMap<String, Object>> {
        a() {
        }

        public int a(String str, String str2) {
            char c;
            char c2;
            Locale locale = Locale.ENGLISH;
            char c3 = str.toLowerCase(locale).toCharArray()[0];
            char c4 = str2.toLowerCase(locale).toCharArray()[0];
            if (c4 < c3) {
                return 1;
            }
            if (c4 != c3 || (c2 = str2.toCharArray()[0]) < (c = str.toCharArray()[0])) {
                return -1;
            }
            if (c2 == c) {
                if (str.length() != 1 && str2.length() != 1) {
                    return a(str.substring(1), str2.substring(1));
                }
                if (str.length() < str2.length()) {
                    return -1;
                }
            }
            return 1;
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
            return a(hashMap.get("name").toString(), hashMap2.get("name").toString());
        }
    }

    private ListView A0(Context context, File file, boolean z) {
        File[] listFiles = file.listFiles(f6247j);
        ArrayList arrayList = new ArrayList();
        if (!z) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", "..");
            hashMap.put(PGEditResultActivity2.PATH, null);
            arrayList.add(hashMap);
        }
        for (int i2 = 0; listFiles != null && i2 < listFiles.length; i2++) {
            File file2 = listFiles[i2];
            HashMap hashMap2 = new HashMap();
            hashMap2.put("name", file2.getName());
            hashMap2.put(PGEditResultActivity2.PATH, file2);
            arrayList.add(hashMap2);
        }
        Collections.sort(arrayList, f6248k);
        ListView listView = new ListView(context);
        listView.setAdapter((ListAdapter) new com.pinguo.camera360.e.b(context, arrayList));
        listView.setOnItemClickListener(this.f6253h);
        listView.setDivider(getResources().getDrawable(R.drawable.bs_divider_dark));
        listView.setDividerHeight(2);
        listView.setBackgroundResource(17170445);
        listView.setCacheColorHint(0);
        listView.setTag(file);
        return listView;
    }

    private void B0(File file) {
        this.f6249d.removeAllViews();
        boolean u0 = u0(file);
        this.f6252g = u0;
        FrameLayout frameLayout = this.f6249d;
        ListView A0 = A0(this, file, u0);
        this.f6250e = A0;
        frameLayout.addView(A0);
        if (u0) {
            this.a.setText(file.getAbsolutePath());
        } else {
            this.a.setText(((File) this.f6250e.getTag()).getAbsolutePath().replaceFirst(f6246i, ""));
        }
        Button button = this.f6251f;
        int i2 = u0 ? 8 : 0;
        button.setVisibility(i2);
        VdsAgent.onSetViewVisibility(button, i2);
    }

    private void C0() {
        String r0 = r0();
        Bundle bundle = new Bundle();
        CameraBusinessSettingModel.v().Q(r0);
        bundle.putString("pic_save_path", r0);
        bundle.putInt("select_which", this.b);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(R.layout.options_save_path, intent);
        finish();
    }

    private void initView() {
        getSupportActionBar().setTitle(R.string.options_save_path);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.a = (TextView) findViewById(R.id.tv_options_save_path);
        this.f6249d = (FrameLayout) findViewById(R.id.lay_save_path_list_body);
        this.f6251f = (Button) findViewById(R.id.btn_save_path_select);
    }

    private String q0() {
        return getString(R.string.pic_save_dlg_notify_use_path) + r0();
    }

    private String r0() {
        String absolutePath = ((File) this.f6250e.getTag()).getAbsolutePath();
        String str = File.separator;
        if (absolutePath.endsWith(str)) {
            return absolutePath;
        }
        return absolutePath + str;
    }

    private void s0() {
        String str;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            str = extras.getString("select_root");
            this.b = extras.getInt("select_which", 1);
        } else {
            str = "";
        }
        this.c = new File(str);
    }

    private void t0() {
        this.f6251f.setOnClickListener(this);
    }

    private boolean u0(File file) {
        return file != null && file.getAbsolutePath().equalsIgnoreCase(this.c.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(AdapterView adapterView, View view, int i2, long j2) {
        VdsAgent.lambdaOnItemClick(adapterView, view, i2, j2);
        File file = (File) ((HashMap) adapterView.getItemAtPosition(i2)).get(PGEditResultActivity2.PATH);
        if (file == null) {
            B0(((File) adapterView.getTag()).getParentFile());
        } else {
            B0(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        C0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean z0(File file) {
        boolean isDirectory = file.isDirectory();
        String name = file.getName();
        return isDirectory && (name.startsWith(".") ^ true) && (name.equals("lost+found") ^ true);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() != R.id.btn_save_path_select) {
            return;
        }
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(this, null, q0(), getString(R.string.yes), null, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.options.i0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                OptionsSavePath.this.y0(dialogInterface, i2);
            }
        });
        h2.show();
        VdsAgent.showDialog(h2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.options_save_path);
        s0();
        initView();
        t0();
        B0(this.c);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && !this.f6252g) {
            this.f6250e.performItemClick(null, 0, 0L);
            return true;
        } else if (i2 == 82) {
            return true;
        } else {
            return super.onKeyDown(i2, keyEvent);
        }
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        if (menuItem.getItemId() != 16908332) {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
            return onOptionsItemSelected;
        }
        finish();
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
    }
}
