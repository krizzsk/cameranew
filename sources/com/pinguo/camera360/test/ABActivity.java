package com.pinguo.camera360.test;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.test.ABActivity;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.abtest.ABTestManager;
import vStudio.Android.Camera360.R;
/* compiled from: ABActivity.kt */
/* loaded from: classes3.dex */
public final class ABActivity extends BaseActivity {
    public Map<Integer, View> a = new LinkedHashMap();
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private List<? extends Pair<Pair<String, String>, ? extends List<String>>> f6957d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f6958e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f6959f;

    /* compiled from: ABActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends com.pinguo.camera360.f.a.a<Pair<? extends Pair<? extends String, ? extends String>, ? extends List<? extends String>>, RecyclerView.ViewHolder> {
        private final Map<String, String> b;

        /* compiled from: ABActivity.kt */
        /* renamed from: com.pinguo.camera360.test.ABActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0248a extends us.pinguo.foundation.ui.g {
            final /* synthetic */ String b;

            C0248a(String str) {
                this.b = str;
            }

            @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                CharSequence H0;
                boolean p;
                kotlin.jvm.internal.s.h(s, "s");
                H0 = StringsKt__StringsKt.H0(s.toString());
                String obj = H0.toString();
                p = kotlin.text.t.p(obj);
                if (!p && obj.length() > 2) {
                    a.this.f().put(this.b, obj);
                } else {
                    a.this.f().remove(this.b);
                }
            }
        }

        public a(Map<String, String> modify) {
            kotlin.jvm.internal.s.h(modify, "modify");
            this.b = modify;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(a this$0, b abHolder, View view, boolean z) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(abHolder, "$abHolder");
            if (z) {
                abHolder.a().showDropDown();
            }
        }

        public final Map<String, String> f() {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i2) {
            kotlin.jvm.internal.s.h(holder, "holder");
            final b bVar = (b) holder;
            Pair pair = (Pair) this.a.get(i2);
            String str = (String) ((Pair) pair.getFirst()).getFirst();
            TextView c = bVar.c();
            c.setText(str + ':' + ((String) ((Pair) pair.getFirst()).getSecond()));
            TextView b = bVar.b();
            StringBuilder sb = new StringBuilder();
            sb.append("online:");
            ABTestManager aBTestManager = ABTestManager.a;
            sb.append((Object) aBTestManager.o(str));
            sb.append("\ncached:");
            sb.append(aBTestManager.q(str, ""));
            b.setText(sb.toString());
            bVar.a().setText("");
            bVar.a().setAdapter(new ArrayAdapter(bVar.itemView.getContext(), (int) R.layout.test_ab_auto_item, (List) pair.getSecond()));
            bVar.a().addTextChangedListener(new C0248a(str));
            bVar.a().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pinguo.camera360.test.a
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ABActivity.a.h(ABActivity.a.this, bVar, view, z);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
            kotlin.jvm.internal.s.h(parent, "parent");
            View banner = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_ab_item, parent, false);
            kotlin.jvm.internal.s.g(banner, "banner");
            return new b(banner);
        }
    }

    /* compiled from: ABActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;
        private final AutoCompleteTextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
            this.a = (TextView) itemView.findViewById(R.id.tv_title);
            this.b = (TextView) itemView.findViewById(R.id.tv_plan);
            this.c = (AutoCompleteTextView) itemView.findViewById(R.id.auto_view);
        }

        public final AutoCompleteTextView a() {
            return this.c;
        }

        public final TextView b() {
            return this.b;
        }

        public final TextView c() {
            return this.a;
        }
    }

    public ABActivity() {
        List<? extends Pair<Pair<String, String>, ? extends List<String>>> h2;
        File externalFilesDir = us.pinguo.foundation.e.b().getExternalFilesDir(null);
        this.b = kotlin.jvm.internal.s.q(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null, "/Camera360/.filter/.testab");
        this.c = kotlin.jvm.internal.s.q(BaseApplication.d().getFilesDir().getAbsolutePath(), "/test/ab.json");
        h2 = kotlin.collections.u.h();
        this.f6957d = h2;
        this.f6958e = new HashMap<>();
        SharedPreferences sharedPreferences = BaseApplication.d().getSharedPreferences("c360_ab", 0);
        kotlin.jvm.internal.s.g(sharedPreferences, "getAppContext().getShare…b\", Context.MODE_PRIVATE)");
        this.f6959f = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(ABActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new ABActivity$onCreate$3$1(this$0, null), 3, null);
        this$0.B0();
    }

    private final void B0() {
        us.pinguo.foundation.utils.w.l(this, "退出重启生效，对部分设置【例如：新增类AB】，需要清除缓存生效", "了解了", null, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.test.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ABActivity.C0(ABActivity.this, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ABActivity this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        dialogInterface.dismiss();
        DevelopModeActivity.w0(this$0, "请重启app");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
        r5 = kotlin.collections.c0.y(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f3, code lost:
        r5 = kotlin.sequences.SequencesKt___SequencesKt.l(r5, com.pinguo.camera360.test.ABActivity$buildAbPlanOnline$plans$1.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fc, code lost:
        r5 = kotlin.sequences.SequencesKt___SequencesKt.j(r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v0(kotlin.coroutines.Continuation<? super java.util.List<? extends kotlin.Pair<kotlin.Pair<java.lang.String, java.lang.String>, ? extends java.util.List<java.lang.String>>>> r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.test.ABActivity.v0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ABActivity this$0, View view) {
        float f2;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Properties properties = new Properties();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this$0.b));
            properties.load(bufferedInputStream);
            kotlin.u uVar = kotlin.u.a;
            kotlin.io.b.a(bufferedInputStream, null);
        } catch (Exception unused) {
        }
        try {
            f2 = Float.parseFloat(((EditText) this$0._$_findCachedViewById(R.id.inner_ab)).getText().toString());
        } catch (Exception unused2) {
            f2 = -1.0f;
        }
        boolean z = false;
        if (0.0f <= f2 && f2 <= 1.0f) {
            z = true;
        }
        if (z) {
            this$0.f6959f.edit().putFloat("key_inner_ab_random", f2).apply();
        } else {
            this$0.f6959f.edit().putFloat("key_inner_ab_random", -1.0f).apply();
        }
        try {
            if (!this$0.f6958e.isEmpty()) {
                for (Map.Entry<String, String> entry : this$0.f6958e.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this$0.b));
                properties.store(bufferedOutputStream, "");
                kotlin.u uVar2 = kotlin.u.a;
                kotlin.io.b.a(bufferedOutputStream, null);
                this$0.f6958e.clear();
            }
        } catch (Exception unused3) {
        }
        this$0.B0();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (us.pinguo.foundation.d.f10985d || us.pinguo.foundation.d.f10987f) {
            this.f6958e.clear();
            setContentView(R.layout.test_ab);
            ((EditText) _$_findCachedViewById(R.id.inner_ab)).setText(String.valueOf(this.f6959f.getFloat("key_inner_ab_random", -1.0f)));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle("AB测试信息");
            }
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new ABActivity$onCreate$1(this, null), 3, null);
            ((Button) _$_findCachedViewById(R.id.btn_ab_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ABActivity.z0(ABActivity.this, view);
                }
            });
            int i2 = R.id.btn_ab_del;
            ((Button) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ABActivity.A0(ABActivity.this, view);
                }
            });
            ((Button) _$_findCachedViewById(i2)).setEnabled(new File(this.b).exists());
            return;
        }
        throw new RuntimeException("Only Test!");
    }
}
