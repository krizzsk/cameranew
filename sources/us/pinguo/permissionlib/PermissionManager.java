package us.pinguo.permissionlib;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes5.dex */
public class PermissionManager {
    private Object a;
    private us.pinguo.permissionlib.c.a b;

    /* renamed from: d  reason: collision with root package name */
    private Handler f11618d;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f11620f;
    private HashMap<String, Result> c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private String[] f11619e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum Result {
        Denied,
        Granted,
        NONE,
        NeverAsk
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : PermissionManager.this.c.entrySet()) {
                if (entry.getValue() == Result.Granted) {
                    arrayList.add(entry.getKey());
                } else {
                    arrayList2.add(entry.getKey());
                }
            }
            us.pinguo.permissionlib.c.a aVar = PermissionManager.this.b;
            if (aVar != null) {
                aVar.a((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]));
            }
            PermissionManager.this.c.clear();
            PermissionManager.this.b = null;
        }
    }

    public PermissionManager(Object obj, boolean z) {
        this.a = obj;
        if (obj instanceof Fragment) {
            this.f11620f = ((Fragment) obj).getContext().getSharedPreferences("name_permission_pref", 0);
        } else if (obj instanceof Activity) {
            this.f11620f = ((Activity) obj).getSharedPreferences("name_permission_pref", 0);
        } else {
            throw new RuntimeException("error object:" + obj.getClass().getName());
        }
        this.f11618d = new Handler();
    }

    private void e(Activity activity, String... strArr) {
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(strArr[0])) {
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 6802);
            x(strArr);
        } else if ("android.permission.WRITE_SETTINGS".equals(strArr[0])) {
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS", Uri.parse("package:" + activity.getPackageName())), 6804);
            x(strArr);
        } else if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(strArr[0])) {
            activity.startActivityForResult(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"), 6808);
            x(strArr);
        } else {
            this.f11619e = strArr;
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Toast makeText = Toast.makeText(activity, "Please go to settings to enable permissions", 1);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }
    }

    private void f(Fragment fragment, String... strArr) {
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(strArr[0])) {
            fragment.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + fragment.getContext().getPackageName())), 6802);
        } else if ("android.permission.WRITE_SETTINGS".equals(strArr[0])) {
            fragment.startActivityForResult(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS", Uri.parse("package:" + fragment.getContext().getPackageName())), 6804);
        } else if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(strArr[0])) {
            fragment.startActivityForResult(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"), 6808);
        } else {
            this.f11619e = strArr;
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                intent.setData(Uri.parse("package:" + fragment.getContext().getPackageName()));
                fragment.startActivity(intent);
            } catch (Exception unused) {
                Toast makeText = Toast.makeText(fragment.getActivity(), "Please go to settings to enable permissions", 1);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
        }
    }

    private boolean g() {
        if (i()) {
            if (this.b == null) {
                return true;
            }
            this.f11618d.post(new a());
            return true;
        }
        return false;
    }

    private HashMap<String, Result> h(String... strArr) {
        HashMap<String, Result> hashMap = new HashMap<>();
        for (String str : strArr) {
            if (p(str)) {
                hashMap.put(str, Result.Granted);
            } else if (q(str)) {
                hashMap.put(str, Result.NeverAsk);
            } else if (j(str)) {
                hashMap.put(str, Result.NONE);
            } else if (n(str)) {
                hashMap.put(str, Result.NONE);
            } else {
                hashMap.put(str, Result.NeverAsk);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean i() {
        /*
            r3 = this;
            java.util.HashMap<java.lang.String, us.pinguo.permissionlib.PermissionManager$Result> r0 = r3.c
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L20
            java.lang.Object r1 = r0.next()
            us.pinguo.permissionlib.PermissionManager$Result r1 = (us.pinguo.permissionlib.PermissionManager.Result) r1
            us.pinguo.permissionlib.PermissionManager$Result r2 = us.pinguo.permissionlib.PermissionManager.Result.NONE
            if (r1 == r2) goto L1e
            us.pinguo.permissionlib.PermissionManager$Result r2 = us.pinguo.permissionlib.PermissionManager.Result.NeverAsk
            if (r1 != r2) goto La
        L1e:
            r0 = 0
            return r0
        L20:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.permissionlib.PermissionManager.i():boolean");
    }

    private boolean l() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private void x(String... strArr) {
        SharedPreferences.Editor editor = null;
        for (String str : strArr) {
            if (j(str)) {
                if (editor == null) {
                    editor = this.f11620f.edit();
                }
                editor.putBoolean(str, false);
            }
        }
        if (editor != null) {
            editor.apply();
        }
    }

    public void d() {
        this.b = null;
        this.c.clear();
        this.f11618d.removeCallbacksAndMessages(null);
        this.f11619e = null;
    }

    public boolean j(String str) {
        return this.f11620f.getBoolean(str, true);
    }

    public boolean k(String str) {
        SharedPreferences sharedPreferences = this.f11620f;
        return sharedPreferences.getBoolean(str + "_dialog", true);
    }

    public boolean n(@NonNull String str) {
        Object obj = this.a;
        if (obj instanceof Fragment) {
            return ((Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        if (obj instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) obj, str);
        }
        return false;
    }

    public boolean o(String str) {
        return (j(str) || n(str)) ? false : true;
    }

    public boolean p(String str) {
        Context context;
        Object obj = this.a;
        if (obj instanceof Fragment) {
            context = ((Fragment) obj).getActivity();
        } else {
            context = obj instanceof Activity ? (Activity) obj : null;
        }
        if (context == null) {
            return false;
        }
        if (l()) {
            if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
                return Settings.canDrawOverlays(context);
            }
            if ("android.permission.WRITE_SETTINGS".equals(str)) {
                return Settings.System.canWrite(context);
            }
            if (!"android.permission.ACCESS_NOTIFICATION_POLICY".equals(str)) {
                return ContextCompat.checkSelfPermission(context, str) == 0;
            } else if (m()) {
                return ((NotificationManager) context.getSystemService("notification")).isNotificationPolicyAccessGranted();
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean q(String str) {
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.WRITE_SETTINGS".equals(str)) {
            return true;
        }
        if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(str)) {
            return m();
        }
        return false;
    }

    public void r(int i2, int i3, Intent intent) {
        int i4 = 0;
        String str = null;
        int i5 = 1;
        if (6808 == i2) {
            str = "android.permission.ACCESS_NOTIFICATION_POLICY";
        } else if (6804 == i2) {
            str = "android.permission.WRITE_SETTINGS";
        } else if (6802 == i2) {
            str = "android.permission.SYSTEM_ALERT_WINDOW";
        } else if (6816 == i2) {
            String[] strArr = this.f11619e;
            if (strArr != null) {
                int length = strArr.length;
                int i6 = 0;
                while (i4 < length) {
                    String str2 = strArr[i4];
                    if (this.c.get(str2) != null) {
                        this.c.put(str2, p(str2) ? Result.Granted : Result.Denied);
                        i6 = 1;
                    }
                    i4++;
                }
                i4 = i6;
            }
            this.f11619e = null;
        }
        if (str == null || this.c.get(str) == null) {
            i5 = i4;
        } else {
            this.c.put(str, p(str) ? Result.Granted : Result.Denied);
        }
        if (i5 != 0) {
            g();
        }
    }

    public void s(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (6801 == i2) {
            x(strArr);
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                int i4 = iArr[i3];
                if (this.c.get(str) != null) {
                    this.c.put(str, i4 == 0 ? Result.Granted : Result.Denied);
                }
            }
            if (g()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Result> entry : this.c.entrySet()) {
                if (entry.getValue() == Result.NONE || entry.getValue() == Result.NeverAsk) {
                    arrayList.add(entry.getKey());
                }
            }
            Object obj = this.a;
            if (obj instanceof Fragment) {
                f((Fragment) obj, (String[]) arrayList.toArray(new String[0]));
            } else if (obj instanceof Activity) {
                e((Activity) obj, (String[]) arrayList.toArray(new String[0]));
            }
        }
    }

    public void t(us.pinguo.permissionlib.c.a aVar, boolean z, @NonNull String... strArr) {
        this.b = aVar;
        this.c = h(strArr);
        if (!z) {
            HashMap<String, Result> hashMap = new HashMap<>();
            for (Map.Entry<String, Result> entry : this.c.entrySet()) {
                if (entry.getValue() == Result.NONE) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.c = hashMap;
        }
        if (!g() && l()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Result> entry2 : this.c.entrySet()) {
                if (entry2.getValue() == Result.NONE) {
                    arrayList.add(entry2.getKey());
                }
            }
            if (arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, Result> entry3 : this.c.entrySet()) {
                    if (entry3.getValue() == Result.NONE || entry3.getValue() == Result.NeverAsk) {
                        arrayList2.add(entry3.getKey());
                    }
                }
                Object obj = this.a;
                if (obj instanceof Fragment) {
                    f((Fragment) obj, (String[]) arrayList2.toArray(new String[0]));
                    return;
                } else if (obj instanceof Activity) {
                    e((Activity) obj, (String[]) arrayList2.toArray(new String[0]));
                    return;
                } else {
                    return;
                }
            }
            String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
            Object obj2 = this.a;
            if (obj2 instanceof Fragment) {
                ((Fragment) obj2).requestPermissions(strArr2, 6801);
            } else if (obj2 instanceof Activity) {
                ((Activity) obj2).requestPermissions(strArr2, 6801);
            }
        }
    }

    public void u(us.pinguo.permissionlib.c.a aVar, @NonNull String... strArr) {
        t(aVar, true, strArr);
    }

    public void v() {
        String[] strArr = this.f11619e;
        int i2 = 0;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                if (this.c.get(str) != null) {
                    if (p(str)) {
                        this.c.put(str, Result.Granted);
                    }
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
        }
        if (i2 == 0 || !g()) {
            return;
        }
        this.f11619e = null;
    }

    public void w(String... strArr) {
        SharedPreferences.Editor editor = null;
        for (String str : strArr) {
            if (k(str)) {
                if (editor == null) {
                    editor = this.f11620f.edit();
                }
                editor.putBoolean(str + "_dialog", false);
            }
        }
        if (editor != null) {
            editor.apply();
        }
    }
}
