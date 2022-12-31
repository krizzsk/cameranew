package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaro a;

    private final void a() {
        zzaro zzaroVar = this.a;
        if (zzaroVar != null) {
            try {
                zzaroVar.zzdp();
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i2, int i3, Intent intent) {
        try {
            this.a.onActivityResult(i2, i3, intent);
        } catch (Exception e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean z = true;
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                z = zzaroVar.zzvw();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        if (z) {
            super.onBackPressed();
            try {
                this.a.onBackPressed();
            } catch (RemoteException e3) {
                zzazk.zze("#007 Could not call remote method.", e3);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.a.zzad(d.z0(configuration));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzaro zzb = zzwr.zzqo().zzb(this);
        this.a = zzb;
        if (zzb == null) {
            zzazk.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onDestroy();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onPause();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onRestart();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onResume();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onStart();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            zzaro zzaroVar = this.a;
            if (zzaroVar != null) {
                zzaroVar.onStop();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            this.a.onUserLeaveHint();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i2) {
        super.setContentView(i2);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
