package com.unity3d.splash.services.ads.adunit;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.unity3d.splash.services.core.api.Intent;
import com.unity3d.splash.services.core.configuration.c;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import com.unity3d.splash.services.core.webview.WebViewEventCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class AdUnitActivity extends Activity {
    protected AdUnitRelativeLayout a;
    private String[] b;
    private int c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f8443d;

    /* renamed from: e  reason: collision with root package name */
    private int f8444e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f8445f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8446g;

    /* renamed from: h  reason: collision with root package name */
    private Map f8447h;

    /* renamed from: i  reason: collision with root package name */
    private int f8448i;

    private b b(String str) {
        Map c;
        if (WebViewApp.e() != null) {
            com.unity3d.splash.services.core.configuration.a d2 = WebViewApp.e().d();
            for (String str2 : d2.c()) {
                c b = d2.b(str2);
                if ((b instanceof com.unity3d.splash.services.b.c.a) && (c = ((com.unity3d.splash.services.b.c.a) b).c()) != null && c.containsKey(str)) {
                    try {
                        return (b) ((Class) c.get(str)).newInstance();
                    } catch (Exception unused) {
                        DeviceLog.f("Error creating view: " + str);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private boolean d(View view) {
        if (view == null) {
            finish();
            DeviceLog.f("Could not place view because it is null, finishing activity");
            return false;
        } else if (view.getParent() != null && view.getParent().equals(this.a)) {
            this.a.bringChildToFront(view);
            return true;
        } else {
            com.unity3d.splash.services.c.a.c.a(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            layoutParams.setMargins(0, 0, 0, 0);
            view.setPadding(0, 0, 0, 0);
            this.a.addView(view, layoutParams);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.a != null) {
            return;
        }
        AdUnitRelativeLayout adUnitRelativeLayout = new AdUnitRelativeLayout(this);
        this.a = adUnitRelativeLayout;
        adUnitRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.unity3d.splash.services.c.a.c.b(this.a, new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
    }

    public b c(String str) {
        Map map = this.f8447h;
        if (map == null || !map.containsKey(str)) {
            b b = b(str);
            if (b != null) {
                if (this.f8447h == null) {
                    this.f8447h = new HashMap();
                }
                this.f8447h.put(str, b);
            }
            return b;
        }
        return (b) this.f8447h.get(str);
    }

    public boolean e(boolean z) {
        this.f8446g = z;
        if (getWindow() == null) {
            return false;
        }
        if (z) {
            getWindow().addFlags(128);
            return true;
        }
        getWindow().clearFlags(128);
        return true;
    }

    public void f(int i2) {
        this.f8448i = i2;
        if (Build.VERSION.SDK_INT < 28 || getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            attributes.getClass().getField("layoutInDisplayCutoutMode").setInt(attributes, i2);
        } catch (IllegalAccessException e2) {
            DeviceLog.d("Error setting layoutInDisplayCutoutMode", e2);
        } catch (NoSuchFieldException e3) {
            DeviceLog.d("Error getting layoutInDisplayCutoutMode", e3);
        }
    }

    public void g(int i2) {
        this.c = i2;
        setRequestedOrientation(i2);
    }

    public boolean h(int i2) {
        this.f8443d = i2;
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                getWindow().getDecorView().setSystemUiVisibility(i2);
                return true;
            } catch (Exception e2) {
                DeviceLog.g("Error while setting SystemUIVisibility", e2);
            }
        }
        return false;
    }

    public void i(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (this.b == null) {
            this.b = new String[0];
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(this.b));
        arrayList2.removeAll(arrayList);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            c((String) it.next()).destroy();
        }
        this.b = strArr;
        for (String str : strArr) {
            if (str != null) {
                b c = c(str);
                c.g(this);
                if (!d(c.getView())) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AdUnitEvent adUnitEvent;
        super.onCreate(bundle);
        if (WebViewApp.e() == null) {
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onCreate");
            finish();
            return;
        }
        com.unity3d.splash.services.b.b.a.b(this);
        Intent.b(this);
        a();
        com.unity3d.splash.services.c.a.c.a(this.a);
        AdUnitRelativeLayout adUnitRelativeLayout = this.a;
        addContentView(adUnitRelativeLayout, adUnitRelativeLayout.getLayoutParams());
        if (bundle == null) {
            this.b = getIntent().getStringArrayExtra("views");
            this.f8445f = getIntent().getIntegerArrayListExtra("keyEvents");
            if (getIntent().hasExtra("orientation")) {
                this.c = getIntent().getIntExtra("orientation", -1);
            }
            if (getIntent().hasExtra("systemUiVisibility")) {
                this.f8443d = getIntent().getIntExtra("systemUiVisibility", 0);
            }
            if (getIntent().hasExtra("activityId")) {
                this.f8444e = getIntent().getIntExtra("activityId", -1);
            }
            if (getIntent().hasExtra("displayCutoutMode")) {
                this.f8448i = getIntent().getIntExtra("displayCutoutMode", 0);
            }
            adUnitEvent = AdUnitEvent.ON_CREATE;
        } else {
            this.b = bundle.getStringArray("views");
            this.c = bundle.getInt("orientation", -1);
            this.f8443d = bundle.getInt("systemUiVisibility", 0);
            this.f8445f = bundle.getIntegerArrayList("keyEvents");
            this.f8446g = bundle.getBoolean("keepScreenOn");
            this.f8444e = bundle.getInt("activityId", -1);
            this.f8448i = bundle.getInt("displayCutoutMode", 0);
            e(this.f8446g);
            adUnitEvent = AdUnitEvent.ON_RESTORE;
        }
        g(this.c);
        h(this.f8443d);
        f(this.f8448i);
        String[] strArr = this.b;
        if (strArr != null) {
            for (String str : strArr) {
                b c = c(str);
                if (c != null) {
                    c.c(this, bundle);
                }
            }
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, adUnitEvent, Integer.valueOf(this.f8444e));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (WebViewApp.e() == null) {
            if (isFinishing()) {
                return;
            }
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onDestroy");
            finish();
            return;
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_DESTROY, Boolean.valueOf(isFinishing()), Integer.valueOf(this.f8444e));
        Map map = this.f8447h;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((b) entry.getValue()).d(this);
                }
            }
        }
        if (com.unity3d.splash.services.b.b.a.a() == this.f8444e) {
            com.unity3d.splash.services.b.b.a.b(null);
        }
        Intent.a(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ArrayList arrayList = this.f8445f;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(i2))) {
            return false;
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.KEY_DOWN, Integer.valueOf(i2), Long.valueOf(keyEvent.getEventTime()), Long.valueOf(keyEvent.getDownTime()), Integer.valueOf(keyEvent.getRepeatCount()), Integer.valueOf(this.f8444e));
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (WebViewApp.e() == null) {
            if (isFinishing()) {
                return;
            }
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onPause");
            finish();
            return;
        }
        if (WebViewApp.e().f() == null) {
            DeviceLog.k("Unity Ads web view is null, from onPause");
        } else if (isFinishing()) {
            com.unity3d.splash.services.c.a.c.a(WebViewApp.e().f());
        }
        Map map = this.f8447h;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((b) entry.getValue()).b(this);
                }
            }
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_PAUSE, Boolean.valueOf(isFinishing()), Integer.valueOf(this.f8444e));
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (String str : strArr) {
                jSONArray.put(str);
            }
            for (int i3 : iArr) {
                jSONArray2.put(i3);
            }
            WebViewApp.e().k(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_RESULT, Integer.valueOf(i2), jSONArray, jSONArray2);
        } catch (Exception e2) {
            WebViewApp.e().k(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_ERROR, e2.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (WebViewApp.e() == null) {
            if (isFinishing()) {
                return;
            }
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onResume");
            finish();
            return;
        }
        i(this.b);
        Map map = this.f8447h;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((b) entry.getValue()).f(this);
                }
            }
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_RESUME, Integer.valueOf(this.f8444e));
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("orientation", this.c);
        bundle.putInt("systemUiVisibility", this.f8443d);
        bundle.putIntegerArrayList("keyEvents", this.f8445f);
        bundle.putBoolean("keepScreenOn", this.f8446g);
        bundle.putStringArray("views", this.b);
        bundle.putInt("activityId", this.f8444e);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (WebViewApp.e() == null) {
            if (isFinishing()) {
                return;
            }
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onStart");
            finish();
            return;
        }
        Map map = this.f8447h;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((b) entry.getValue()).e(this);
                }
            }
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_START, Integer.valueOf(this.f8444e));
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (WebViewApp.e() == null) {
            if (isFinishing()) {
                return;
            }
            DeviceLog.f("Unity Ads web app is null, closing Unity Ads activity from onStop");
            finish();
            return;
        }
        Map map = this.f8447h;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((b) entry.getValue()).a(this);
                }
            }
        }
        WebViewApp.e().k(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_STOP, Integer.valueOf(this.f8444e));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        WebViewApp e2 = WebViewApp.e();
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.ADUNIT;
        if (z) {
            e2.k(webViewEventCategory, AdUnitEvent.ON_FOCUS_GAINED, Integer.valueOf(this.f8444e));
        } else {
            e2.k(webViewEventCategory, AdUnitEvent.ON_FOCUS_LOST, Integer.valueOf(this.f8444e));
        }
        super.onWindowFocusChanged(z);
    }
}
