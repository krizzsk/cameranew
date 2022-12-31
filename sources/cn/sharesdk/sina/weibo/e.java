package cn.sharesdk.sina.weibo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import java.lang.reflect.Method;
/* compiled from: SinaWeiboSSOProcessor.java */
/* loaded from: classes.dex */
public class e extends cn.sharesdk.framework.authorize.e implements ServiceConnection {

    /* renamed from: d  reason: collision with root package name */
    private String f228d;

    /* renamed from: e  reason: collision with root package name */
    private String f229e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f230f;

    public e(cn.sharesdk.framework.authorize.d dVar) {
        super(dVar);
    }

    private boolean b(Intent intent) {
        ResolveInfo resolveActivity = this.a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature signature : this.a.getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if ("30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4".equals(signature.toCharsString())) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private void c(Intent intent) {
        if (this.c == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("error_type");
        }
        if (stringExtra == null) {
            this.c.onComplete(intent.getExtras());
        } else if (!stringExtra.equals("access_denied") && !stringExtra.equals("OAuthAccessDeniedException")) {
            String stringExtra2 = intent.getStringExtra("error_description");
            if (stringExtra2 != null) {
                stringExtra = stringExtra + ": " + stringExtra2;
            }
            this.c.onFailed(new Throwable(stringExtra));
        } else {
            this.c.onCancel();
        }
    }

    private void d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("error");
            int intExtra = intent.getIntExtra("error_code", -1);
            Throwable th = new Throwable(stringExtra + " (" + intExtra + ")");
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onFailed(th);
                return;
            }
            return;
        }
        SSOListener sSOListener2 = this.c;
        if (sSOListener2 != null) {
            sSOListener2.onCancel();
        }
    }

    public void a(String str, String str2, String[] strArr) {
        this.f228d = str;
        this.f229e = str2;
        this.f230f = strArr;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Class<?> cls = Class.forName("com.sina.sso.RemoteSSO$Stub");
            Method method = cls.getMethod("asInterface", IBinder.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, iBinder);
            Method method2 = cls.getMethod("getPackageName", new Class[0]);
            method2.setAccessible(true);
            String valueOf = String.valueOf(method2.invoke(invoke, new Object[0]));
            Method method3 = cls.getMethod("getActivityName", new Class[0]);
            method3.setAccessible(true);
            if (a(valueOf, String.valueOf(method3.invoke(invoke, new Object[0])))) {
                return;
            }
            this.a.finish();
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onFailed(new Throwable());
            }
        } catch (Throwable th) {
            this.a.finish();
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(th);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.finish();
        SSOListener sSOListener = this.c;
        if (sSOListener != null) {
            sSOListener.onFailed(new Throwable());
        }
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a() {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName("com.sina.weibo", "com.sina.weibo.business.RemoteSSOService");
        try {
            z = this.a.getContext().getApplicationContext().bindService(intent, this, 1);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            return;
        }
        this.a.finish();
        SSOListener sSOListener = this.c;
        if (sSOListener != null) {
            sSOListener.onFailed(new Throwable());
        }
    }

    private boolean a(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtra("appKey", this.f228d);
        intent.putExtra("redirectUri", this.f229e);
        String[] strArr = this.f230f;
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("scope", TextUtils.join(",", strArr));
        }
        boolean z = false;
        if (b(intent)) {
            try {
                this.a.startActivityForResult(intent, this.b);
                z = true;
            } catch (Throwable unused) {
            }
            this.a.getContext().getApplicationContext().unbindService(this);
            return z;
        }
        return false;
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a(int i2, int i3, Intent intent) {
        this.a.finish();
        if (i2 == this.b) {
            if (i3 == -1) {
                c(intent);
            } else if (i3 != 0) {
            } else {
                d(intent);
            }
        }
    }
}
