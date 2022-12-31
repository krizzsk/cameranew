package us.pinguo.edit2020.controller;

import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.repository2020.BeautyDataRepository;
import us.pinguo.repository2020.entity.MaterialColor;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.Topic;
import us.pinguo.ui.widget.AutofitTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController$show$1 extends Lambda implements kotlin.jvm.b.l<Integer, kotlin.u> {
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeupController$show$1(MakeupController makeupController) {
        super(1);
        this.this$0 = makeupController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
        invoke(num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2) {
        SelfDefMakeup[] selfDefMakeupArr;
        MaterialColor[] materialColorArr;
        boolean z;
        int F;
        SelfDefMakeup[] selfDefMakeupArr2;
        SelfDefMakeup selfDefMakeup;
        String pid;
        Topic topic;
        String tag;
        this.this$0.a.o0(this.this$0.a.v());
        this.this$0.a.i0(i2);
        if (this.this$0.a.E() != this.this$0.a.v() && this.this$0.a.E() != -1) {
            if (this.this$0.a.E() != this.this$0.a.S(this.this$0.a.D()) || this.this$0.a.R(this.this$0.a.D())) {
                Long[] D = this.this$0.a.D();
                MakeupController makeupController = this.this$0;
                if (D != null) {
                    if (!(D.length == 0)) {
                        z = false;
                        if (!z && D.length > (F = makeupController.a.F())) {
                            D[F] = Long.valueOf(System.currentTimeMillis());
                        }
                    }
                }
                z = true;
                if (!z) {
                    D[F] = Long.valueOf(System.currentTimeMillis());
                }
            } else {
                Long[] D2 = this.this$0.a.D();
                if (D2 != null) {
                    int length = D2.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        D2[i3] = 0L;
                    }
                }
            }
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            HashMap<String, String> a = BeautyDataRepository.D.a();
            List<Topic> O = this.this$0.a.O();
            String str = "DEFAULT";
            if (O != null && (topic = (Topic) kotlin.collections.s.D(O, this.this$0.a.o())) != null && (tag = topic.getTag()) != null) {
                str = tag;
            }
            String str2 = a.get(str);
            SelfDefMakeup[][] x = this.this$0.a.x();
            String str3 = "";
            if (x != null && (selfDefMakeupArr2 = (SelfDefMakeup[]) kotlin.collections.j.t(x, this.this$0.a.o())) != null && (selfDefMakeup = (SelfDefMakeup) kotlin.collections.j.t(selfDefMakeupArr2, this.this$0.a.C())) != null && (pid = selfDefMakeup.getPid()) != null) {
                str3 = pid;
            }
            iVar.g(str2, str3, "facechange");
        }
        if (i2 != -1) {
            AutofitTextView autofitTextView = (AutofitTextView) ((PaintEraserAdjustLayout) this.this$0.b.findViewById(R.id.adjustLayout)).a(R.id.tvSelectFaceHint);
            kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.adjustLayout.tvSelectFaceHint");
            autofitTextView.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView, 8);
            this.this$0.m0(true);
            this.this$0.E();
            MakeupController makeupController2 = this.this$0;
            StyleMakeup[] Q = makeupController2.a.Q();
            MaterialColor materialColor = null;
            makeupController2.c0(Q == null ? null : (StyleMakeup) kotlin.collections.j.t(Q, i2), false);
            MakeupController makeupController3 = this.this$0;
            int o = makeupController3.a.o();
            int F2 = this.this$0.a.F();
            SelfDefMakeup[][] x2 = this.this$0.a.x();
            makeupController3.d0(o, i2, F2, null, (x2 == null || (selfDefMakeupArr = (SelfDefMakeup[]) kotlin.collections.j.t(x2, this.this$0.a.o())) == null) ? null : (SelfDefMakeup) kotlin.collections.j.t(selfDefMakeupArr, i2));
            if (this.this$0.a.U(this.this$0.a.o())) {
                MakeupController makeupController4 = this.this$0;
                int o2 = makeupController4.a.o();
                int F3 = this.this$0.a.F();
                MaterialColor[][] w = this.this$0.a.w();
                if (w != null && (materialColorArr = (MaterialColor[]) kotlin.collections.j.t(w, this.this$0.a.o())) != null) {
                    materialColor = (MaterialColor) kotlin.collections.j.t(materialColorArr, i2);
                }
                makeupController4.d0(o2, i2, F3, null, materialColor);
            }
            this.this$0.u0();
        }
    }
}
