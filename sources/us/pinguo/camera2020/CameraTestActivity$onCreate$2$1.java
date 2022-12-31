package us.pinguo.camera2020;

import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: CameraTestActivity.kt */
/* loaded from: classes.dex */
final class CameraTestActivity$onCreate$2$1 extends Lambda implements l<byte[], u> {
    final /* synthetic */ CameraTestActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraTestActivity$onCreate$2$1(CameraTestActivity cameraTestActivity) {
        super(1);
        this.this$0 = cameraTestActivity;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(byte[] bArr) {
        invoke2(bArr);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] it) {
        s.h(it, "it");
        Toast makeText = Toast.makeText(this.this$0, "PictureTaken", 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }
}
