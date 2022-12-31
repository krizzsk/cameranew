package us.pinguo.edit2020.viewmodel;

import android.graphics.Point;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.f;
import us.pinguo.image.saver.Saver2020;
import us.pinguo.util.v;
/* compiled from: EditViewModel.kt */
/* loaded from: classes4.dex */
final class EditViewModel$finalSave$1 extends Lambda implements l<String, u> {
    final /* synthetic */ l<String, u> $saveResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditViewModel$finalSave$1(l<? super String, u> lVar) {
        super(1);
        this.$saveResult = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m105invoke$lambda0(String str) {
        Toast makeText = Toast.makeText(v.a(), s.q("图片保存成功:", str), 1);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(String str) {
        invoke2(str);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final String str) {
        us.pinguo.common.log.a.e(s.q("picture saved: ", str), new Object[0]);
        l<String, u> lVar = this.$saveResult;
        if (lVar != null) {
            lVar.invoke(str);
        }
        if (us.pinguo.foundation.d.f10987f) {
            f.c(new Runnable() { // from class: us.pinguo.edit2020.viewmodel.b
                @Override // java.lang.Runnable
                public final void run() {
                    EditViewModel$finalSave$1.m105invoke$lambda0(str);
                }
            });
        }
        Point b = Saver2020.a.b();
        if (b == null) {
            return;
        }
        h.b.V(String.valueOf(b.y), String.valueOf(b.x), String.valueOf(b.x * b.y), "export");
    }
}
