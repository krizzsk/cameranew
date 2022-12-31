package us.pinguo.edit2020.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.w;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.controller.f3;
import us.pinguo.edit2020.manager.AutoPlayDetector;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.util.h;
/* compiled from: CommonVideoTutorialActivity.kt */
/* loaded from: classes4.dex */
public final class CommonVideoTutorialActivity extends BaseActivity {

    /* renamed from: d  reason: collision with root package name */
    public static final a f10109d = new a(null);
    public Map<Integer, View> a = new LinkedHashMap();
    private AutoPlayDetector b;
    private w c;

    /* compiled from: CommonVideoTutorialActivity.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final void a(Context context, String type) {
            s.h(context, "context");
            s.h(type, "type");
            Intent intent = new Intent(context, CommonVideoTutorialActivity.class);
            intent.putExtra("KEY_MESSAGE_TYPE", type);
            context.startActivity(intent);
        }
    }

    private final void initView() {
        String stringExtra = getIntent().getStringExtra("KEY_MESSAGE_TYPE");
        if (stringExtra == null) {
            stringExtra = TutorialModel.VIDEO_TYPE_BODY_SHAPING;
        }
        TutorialModel[] k2 = TutorialModel.Companion.k(stringExtra);
        int i2 = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i2);
        s.g(recyclerView, "recyclerView");
        this.b = new AutoPlayDetector(this, recyclerView);
        ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(new LinearLayoutManager(this, 1, false));
        AutoPlayDetector autoPlayDetector = this.b;
        if (autoPlayDetector != null) {
            this.c = new w(k2, autoPlayDetector);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i2);
            w wVar = this.c;
            if (wVar != null) {
                recyclerView2.setAdapter(wVar);
                return;
            } else {
                s.z("adapter");
                throw null;
            }
        }
        s.z("playDetector");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(CommonVideoTutorialActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.finish();
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEnableBaseNotch = false;
        setContentView(R.layout.activity_body_shaping_tutorial);
        h.o(this);
        initView();
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tvClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.activity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonVideoTutorialActivity.r0(CommonVideoTutorialActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f3.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        requestCheckIsFullDisplay(-1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            h.o(this);
        }
    }
}
