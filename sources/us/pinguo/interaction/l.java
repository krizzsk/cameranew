package us.pinguo.interaction;

import android.net.Uri;
import androidx.databinding.ObservableBoolean;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.manager.FilterRepository;
/* compiled from: DestinationCameraFilter.java */
/* loaded from: classes4.dex */
public class l extends us.pinguo.foundation.interaction.b {
    private static boolean i(String str) {
        try {
            ObservableBoolean observableBoolean = new ObservableBoolean(false);
            FilterRepository filterRepository = FilterRepository.a;
            for (PackageItem packageItem : filterRepository.x(filterRepository.e(observableBoolean, false, true), observableBoolean, false, false)) {
                if (us.pinguo.foundation.utils.y.a(packageItem.getPackageId(), str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(1:3)|4|(2:5|6)|(13:13|14|15|16|(1:70)|24|25|26|27|(1:29)|31|32|(3:34|(1:36)|(4:45|(1:47)|48|49)(3:40|(1:42)|43))(2:50|(8:56|(1:58)|59|(1:61)|62|(1:64)|(1:66)|67)(2:54|55)))|74|14|15|16|(1:18)|70|24|25|26|27|(0)|31|32|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
        r13.printStackTrace();
        r8 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
        r0.printStackTrace();
        r9 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080 A[Catch: Exception -> 0x0086, TRY_LEAVE, TryCatch #1 {Exception -> 0x0086, blocks: (B:31:0x0074, B:33:0x0080), top: B:75:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc  */
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent a(android.net.Uri r12, android.os.Bundle r13, android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.interaction.l.a(android.net.Uri, android.os.Bundle, android.content.Context):android.content.Intent");
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().contains("app://camera360/cameraFilter");
    }
}
