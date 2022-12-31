package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.StyleMakeupDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
/* loaded from: classes6.dex */
public final class BeautyDataManager$downloadAndInstallStyleMakeup$1 extends Lambda implements q<StyleMakeupDetail[], Boolean, String, u> {
    final /* synthetic */ q<Boolean, MaterialDetail, String, u> $downloadAction;
    final /* synthetic */ String $styleMakeupId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BeautyDataManager$downloadAndInstallStyleMakeup$1(String str, q<? super Boolean, ? super MaterialDetail, ? super String, u> qVar) {
        super(3);
        this.$styleMakeupId = str;
        this.$downloadAction = qVar;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ u invoke(StyleMakeupDetail[] styleMakeupDetailArr, Boolean bool, String str) {
        invoke(styleMakeupDetailArr, bool.booleanValue(), str);
        return u.a;
    }

    public final void invoke(StyleMakeupDetail[] styleMakeupDetailArr, boolean z, String message) {
        ObservableField<MaterialInstallState> installState;
        s.h(message, "message");
        if (!z) {
            StyleMakeup styleMakeup = BeautyDataManager.a.q().get(this.$styleMakeupId);
            if (styleMakeup != null && (installState = styleMakeup.getInstallState()) != null) {
                installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
            }
            this.$downloadAction.invoke(Boolean.FALSE, null, message);
        } else if (styleMakeupDetailArr == null) {
        } else {
            String str = this.$styleMakeupId;
            q<Boolean, MaterialDetail, String, u> qVar = this.$downloadAction;
            int length = styleMakeupDetailArr.length;
            int i2 = 0;
            while (i2 < length) {
                StyleMakeupDetail styleMakeupDetail = styleMakeupDetailArr[i2];
                i2++;
                us.pinguo.common.log.a.e(s.q("BeautyDataManager.downloadAndInstallStyleMakeup.", str), new Object[0]);
                BeautyDownloadManager.a.b(styleMakeupDetail, new BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1(qVar, styleMakeupDetail, message));
            }
        }
    }
}
