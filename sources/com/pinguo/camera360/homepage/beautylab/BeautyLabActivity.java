package com.pinguo.camera360.homepage.beautylab;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.sticker.view.CircleSelectorSelector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.o.c;
import us.pinguo.foundation.statistics.h;
import us.pinguo.interaction.h0;
import us.pinguo.widget.common.guide.GuideHandler;
import vStudio.Android.Camera360.R;
/* compiled from: BeautyLabActivity.kt */
/* loaded from: classes3.dex */
public final class BeautyLabActivity extends BaseActivity implements View.OnClickListener {
    public Map<Integer, View> a = new LinkedHashMap();
    private SharedPreferences b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6776d;

    /* compiled from: BeautyLabActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c.a {
        a() {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            int i2;
            try {
                try {
                    if (BeautyLabActivity.this.f6776d) {
                        b.a(BeautyLabActivity.this);
                    }
                    BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
                    i2 = R.id.splice_progress;
                    if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i2)).getVisibility() != 0) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BeautyLabActivity beautyLabActivity2 = BeautyLabActivity.this;
                    i2 = R.id.splice_progress;
                    if (((CircleSelectorSelector) beautyLabActivity2._$_findCachedViewById(i2)).getVisibility() != 0) {
                        return;
                    }
                }
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setVisibility(8);
            } catch (Throwable th) {
                BeautyLabActivity beautyLabActivity3 = BeautyLabActivity.this;
                int i3 = R.id.splice_progress;
                if (((CircleSelectorSelector) beautyLabActivity3._$_findCachedViewById(i3)).getVisibility() == 0) {
                    ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i3)).setVisibility(8);
                }
                throw th;
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void b() {
            BeautyLabActivity.this.f6776d = false;
            BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
            int i2 = R.id.splice_progress;
            if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i2)).getVisibility() == 0) {
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setProgress(0);
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setVisibility(8);
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void c() {
            if (BeautyLabActivity.this.f6776d) {
                BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
                int i2 = R.id.splice_progress;
                if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i2)).getVisibility() != 0) {
                    ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setVisibility(0);
                    ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setProgressWithoutAnimation(0);
                }
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void d() {
            BeautyLabActivity.this.f6776d = false;
            BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
            int i2 = R.id.splice_progress;
            if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i2)).getVisibility() == 0) {
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setProgress(0);
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setVisibility(8);
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void e() {
            c.a.C0395a.a(this);
        }

        @Override // us.pinguo.foundation.o.c.a
        public void f(int i2) {
            if (BeautyLabActivity.this.f6776d) {
                BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
                int i3 = R.id.splice_progress;
                if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i3)).getVisibility() == 0) {
                    ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i3)).setProgress(i2);
                }
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void g() {
            BeautyLabActivity.this.f6776d = false;
            BeautyLabActivity beautyLabActivity = BeautyLabActivity.this;
            int i2 = R.id.splice_progress;
            if (((CircleSelectorSelector) beautyLabActivity._$_findCachedViewById(i2)).getVisibility() == 0) {
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setProgress(0);
                ((CircleSelectorSelector) BeautyLabActivity.this._$_findCachedViewById(i2)).setVisibility(8);
            }
        }
    }

    private final void s0(String str) {
        c.a.a(str, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(BeautyLabActivity this$0, View view) {
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

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view == null) {
            return;
        }
        String str = null;
        switch (view.getId()) {
            case R.id.beauty_lab_item_2 /* 2131296467 */:
                h.a.H("april_btn", "click");
                str = "app://pinguo/april";
                break;
            case R.id.beauty_lab_splice /* 2131296468 */:
                this.f6776d = true;
                s0("c360_dynamic_feature_splice");
                h.a.H("splice_btn", "click");
                if (this.c) {
                    SharedPreferences sharedPreferences = this.b;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putBoolean("beauty_splice_red_guide", false).apply();
                        View _$_findCachedViewById = _$_findCachedViewById(R.id.splice_red);
                        _$_findCachedViewById.setVisibility(8);
                        VdsAgent.onSetViewVisibility(_$_findCachedViewById, 8);
                        this.c = false;
                        break;
                    } else {
                        s.z("guidePref");
                        throw null;
                    }
                }
                break;
        }
        if (str == null) {
            return;
        }
        AppGoto.getInstance().b(Uri.parse(str)).b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        setContentView(R.layout.activity_beauty_lab);
        ((TextView) _$_findCachedViewById(R.id.beauty_lab_title)).setText("- " + getString(R.string.beauty_lab_title) + " -");
        ((LinearLayout) _$_findCachedViewById(R.id.beauty_lab_splice)).setOnClickListener(this);
        int i2 = R.id.beauty_lab_item_2;
        ((LinearLayout) _$_findCachedViewById(i2)).setOnClickListener(this);
        if (h0.a.b()) {
            LinearLayout beauty_lab_item_2 = (LinearLayout) _$_findCachedViewById(i2);
            s.g(beauty_lab_item_2, "beauty_lab_item_2");
            beauty_lab_item_2.setVisibility(8);
            VdsAgent.onSetViewVisibility(beauty_lab_item_2, 8);
        }
        ((ImageView) _$_findCachedViewById(R.id.beauty_lab_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.beautylab.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeautyLabActivity.u0(BeautyLabActivity.this, view);
            }
        });
        us.pinguo.foundation.statistics.c cVar = h.a;
        cVar.H("splice_btn", "show");
        cVar.H("april_btn", "show");
        SharedPreferences o = GuideHandler.o(this);
        s.g(o, "getSharedPreferences(this)");
        this.b = o;
        if (o != null) {
            boolean z = o.getBoolean("beauty_splice_red_guide", true);
            this.c = z;
            if (z) {
                View _$_findCachedViewById = _$_findCachedViewById(R.id.splice_red);
                _$_findCachedViewById.setVisibility(0);
                VdsAgent.onSetViewVisibility(_$_findCachedViewById, 0);
                return;
            }
            return;
        }
        s.z("guidePref");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f6776d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        requestCheckIsFullDisplay(1);
    }
}
