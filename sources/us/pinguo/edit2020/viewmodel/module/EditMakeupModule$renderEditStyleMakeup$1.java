package us.pinguo.edit2020.viewmodel.module;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.StyleMakeupParam;
import us.pinguo.repository2020.manager.BeautyInstallManager;
import us.pinguo.u3dengine.api.MakeupMaterial;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditMakeupModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditStyleMakeup$1", f = "EditMakeupModule.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditMakeupModule$renderEditStyleMakeup$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ String $styleMakeupDir;
    int label;
    final /* synthetic */ EditMakeupModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMakeupModule$renderEditStyleMakeup$1(String str, StyleMakeup styleMakeup, EditMakeupModule editMakeupModule, Continuation<? super EditMakeupModule$renderEditStyleMakeup$1> continuation) {
        super(2, continuation);
        this.$styleMakeupDir = str;
        this.$styleMakeup = styleMakeup;
        this.this$0 = editMakeupModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditMakeupModule$renderEditStyleMakeup$1(this.$styleMakeupDir, this.$styleMakeup, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditMakeupModule$renderEditStyleMakeup$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object f2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            BeautyInstallManager beautyInstallManager = BeautyInstallManager.a;
            String str = this.$styleMakeupDir;
            this.label = 1;
            f2 = beautyInstallManager.f(str, this);
            if (f2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
            f2 = obj;
        }
        StyleMakeupParam styleMakeupParam = (StyleMakeupParam) f2;
        if (styleMakeupParam != null) {
            StyleMakeup styleMakeup = this.$styleMakeup;
            String str2 = this.$styleMakeupDir;
            EditMakeupModule editMakeupModule = this.this$0;
            Map<String, String>[] items = styleMakeupParam.getItems();
            if (items == null) {
                return u.a;
            }
            int length = items.length;
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(new MakeupMaterial(s.q(str2, items[i3].get(TJAdUnitConstants.String.BUNDLE)), MakeupMaterial.DEFAULT_COLOR, Float.parseFloat(String.valueOf(items[i3].get(FirebaseAnalytics.Param.VALUE))), null, 8, null));
            }
            if (styleMakeup != null) {
                Float makeupDefaultValue = styleMakeupParam.getMakeupDefaultValue();
                float f3 = 100;
                styleMakeup.setMakeupDefaultValue(Boxing.boxInt((int) ((makeupDefaultValue == null ? 0.8f : makeupDefaultValue.floatValue()) * f3)));
                Float filterDefaultValue = styleMakeupParam.getFilterDefaultValue();
                styleMakeup.setFilterDefaultValue(Boxing.boxInt((int) ((filterDefaultValue == null ? 0.5f : filterDefaultValue.floatValue()) * f3)));
                Float skinWhiteDefaultValue = styleMakeupParam.getSkinWhiteDefaultValue();
                styleMakeup.setSkinWhiteDefaultValue(Boxing.boxInt((int) ((skinWhiteDefaultValue == null ? 0.0f : skinWhiteDefaultValue.floatValue()) * f3)));
                styleMakeup.setFilterLayer(styleMakeupParam.getFilterLayer());
                styleMakeup.setRenderFilter(styleMakeupParam.isRenderFilter());
                editMakeupModule.t0(editMakeupModule.v(), arrayList, styleMakeup, str2);
            }
        }
        return u.a;
    }
}
