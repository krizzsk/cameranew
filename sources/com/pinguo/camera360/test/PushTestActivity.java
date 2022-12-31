package com.pinguo.camera360.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.push.PushParser;
import vStudio.Android.Camera360.R;
/* compiled from: PushTestActivity.kt */
/* loaded from: classes3.dex */
public final class PushTestActivity extends BaseActivity {
    public Map<Integer, View> a = new LinkedHashMap();
    private SharedPreferences b;

    /* compiled from: PushTestActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @Instrumented
        public void onCheckedChanged(CompoundButton buttonView, boolean z) {
            VdsAgent.onCheckedChanged(this, buttonView, z);
            kotlin.jvm.internal.s.h(buttonView, "buttonView");
            LinearLayout linearLayout = (LinearLayout) PushTestActivity.this._$_findCachedViewById(R.id.btn_config_layout);
            int i2 = z ? 0 : 4;
            linearLayout.setVisibility(i2);
            VdsAgent.onSetViewVisibility(linearLayout, i2);
        }
    }

    private final String q0(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 1);
            jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, UUID.randomUUID().toString());
            jSONObject.put("from", "20000101 00:01");
            jSONObject.put("to", "20991231 11:59");
            jSONObject.put("show", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", str);
            jSONObject2.put("msg", str2);
            jSONObject.put("notify", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("link", str3);
            if (z) {
                if (TextUtils.isEmpty(str6)) {
                    jSONObject3.put("buttonType", 1);
                } else {
                    jSONObject3.put("buttonType", 1);
                    jSONObject3.put("notifyType", 2);
                    jSONObject3.put("url", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject3.put("buttonColor", str5);
                }
                jSONObject3.put("buttonContent", str4);
            }
            jSONObject.put("data", jSONObject3);
            String jSONObject4 = jSONObject.toString();
            kotlin.jvm.internal.s.g(jSONObject4, "jo.toString()");
            return jSONObject4;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
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

    public final void actionPush(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        if (us.pinguo.foundation.d.f10985d || us.pinguo.foundation.d.f10987f) {
            String obj = ((EditText) _$_findCachedViewById(R.id.push_title)).getText().toString();
            String obj2 = ((EditText) _$_findCachedViewById(R.id.push_content)).getText().toString();
            String obj3 = ((EditText) _$_findCachedViewById(R.id.publish_goto)).getText().toString();
            String obj4 = ((EditText) _$_findCachedViewById(R.id.publish_text_content)).getText().toString();
            String obj5 = ((EditText) _$_findCachedViewById(R.id.publish_text_corlor)).getText().toString();
            int i2 = R.id.cb_add_btn;
            boolean isChecked = ((CheckBox) _$_findCachedViewById(i2)).isChecked();
            String obj6 = ((EditText) _$_findCachedViewById(R.id.publish_icon_url)).getText().toString();
            SharedPreferences sharedPreferences = this.b;
            SharedPreferences.Editor edit = sharedPreferences == null ? null : sharedPreferences.edit();
            if (edit != null) {
                edit.putString("title", obj);
            }
            if (edit != null) {
                edit.putString(FirebaseAnalytics.Param.CONTENT, obj2);
            }
            if (edit != null) {
                edit.putString("appGoto", obj3);
            }
            if (edit != null) {
                edit.putBoolean("btnChecked", isChecked);
            }
            if (edit != null) {
                edit.putString("btnContext", obj4);
            }
            if (edit != null) {
                edit.putString("btnCorlor", obj5);
            }
            if (edit != null) {
                edit.putString("iconUrl", obj6);
            }
            if (edit != null) {
                edit.apply();
            }
            if (TextUtils.isEmpty(obj)) {
                obj = "这是标题";
            }
            String str = obj;
            if (TextUtils.isEmpty(obj2)) {
                obj2 = "你好，这是内容!";
            }
            String str2 = obj2;
            if (TextUtils.isEmpty(obj3)) {
                obj3 = "app://camera360/cameraFilter?makeup=catmakeup";
            }
            String str3 = obj3;
            if (TextUtils.isEmpty(obj4)) {
                obj4 = getResources().getString(R.string.push_btn_str);
                kotlin.jvm.internal.s.g(obj4, "resources.getString(R.string.push_btn_str)");
            }
            PushParser.get().onHandleJson(q0(str, str2, str3, ((CheckBox) _$_findCachedViewById(i2)).isChecked(), obj4, obj5, obj6));
        }
    }

    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (us.pinguo.foundation.d.f10985d || us.pinguo.foundation.d.f10987f) {
            setContentView(R.layout.activity_push_test);
            int i2 = R.id.cb_add_btn;
            ((CheckBox) _$_findCachedViewById(i2)).setOnCheckedChangeListener(new a());
            ActionBar supportActionBar = getSupportActionBar();
            kotlin.jvm.internal.s.e(supportActionBar);
            supportActionBar.setTitle("推送测试");
            SharedPreferences sharedPreferences = getSharedPreferences("push_test_config", 0);
            this.b = sharedPreferences;
            String string = sharedPreferences == null ? null : sharedPreferences.getString("title", "");
            SharedPreferences sharedPreferences2 = this.b;
            String string2 = sharedPreferences2 == null ? null : sharedPreferences2.getString(FirebaseAnalytics.Param.CONTENT, "");
            SharedPreferences sharedPreferences3 = this.b;
            String string3 = sharedPreferences3 == null ? null : sharedPreferences3.getString("appGoto", "");
            SharedPreferences sharedPreferences4 = this.b;
            String string4 = sharedPreferences4 == null ? null : sharedPreferences4.getString("btnContext", "");
            SharedPreferences sharedPreferences5 = this.b;
            String string5 = sharedPreferences5 == null ? null : sharedPreferences5.getString("btnCorlor", "");
            SharedPreferences sharedPreferences6 = this.b;
            boolean z = sharedPreferences6 == null ? false : sharedPreferences6.getBoolean("btnChecked", false);
            SharedPreferences sharedPreferences7 = this.b;
            String string6 = sharedPreferences7 != null ? sharedPreferences7.getString("iconUrl", "") : null;
            ((EditText) _$_findCachedViewById(R.id.push_title)).setText(string);
            ((EditText) _$_findCachedViewById(R.id.push_content)).setText(string2);
            ((EditText) _$_findCachedViewById(R.id.publish_goto)).setText(string3);
            ((EditText) _$_findCachedViewById(R.id.publish_text_content)).setText(string4);
            ((EditText) _$_findCachedViewById(R.id.publish_text_corlor)).setText(string5);
            ((CheckBox) _$_findCachedViewById(i2)).setChecked(z);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.btn_config_layout);
            int i3 = z ? 0 : 4;
            linearLayout.setVisibility(i3);
            VdsAgent.onSetViewVisibility(linearLayout, i3);
            ((EditText) _$_findCachedViewById(R.id.publish_icon_url)).setText(string6);
            return;
        }
        throw new RuntimeException("Fuck U!");
    }
}
