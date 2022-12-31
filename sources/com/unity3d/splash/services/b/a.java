package com.unity3d.splash.services.b;

import android.app.Activity;
import com.unity3d.splash.UnityAds;
import com.unity3d.splash.services.UnityServices;
import com.unity3d.splash.services.core.log.DeviceLog;
/* loaded from: classes3.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unity3d.splash.services.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0287a implements com.unity3d.splash.services.a {
        final /* synthetic */ com.unity3d.splash.a a;

        C0287a(com.unity3d.splash.a aVar) {
            this.a = aVar;
        }

        @Override // com.unity3d.splash.services.a
        public final void a(UnityServices.UnityServicesError unityServicesError, String str) {
            if (unityServicesError == UnityServices.UnityServicesError.INIT_SANITY_CHECK_FAIL) {
                this.a.a(UnityAds.UnityAdsError.INIT_SANITY_CHECK_FAIL, str);
            } else if (unityServicesError == UnityServices.UnityServicesError.INVALID_ARGUMENT) {
                this.a.a(UnityAds.UnityAdsError.INVALID_ARGUMENT, str);
            }
        }
    }

    public static void a(com.unity3d.splash.a aVar) {
        com.unity3d.splash.services.b.d.a.a(aVar);
    }

    public static void b(Activity activity, String str, com.unity3d.splash.a aVar, boolean z, boolean z2) {
        DeviceLog.e();
        a(aVar);
        UnityServices.a(activity, str, new C0287a(aVar), z, z2);
    }
}
