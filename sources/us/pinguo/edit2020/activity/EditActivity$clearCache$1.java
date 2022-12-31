package us.pinguo.edit2020.activity;

import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.util.FileUtils;
/* compiled from: EditActivity.kt */
@DebugMetadata(c = "us.pinguo.edit2020.activity.EditActivity$clearCache$1", f = "EditActivity.kt", i = {0}, l = {211}, m = "invokeSuspend", n = {"childNames"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class EditActivity$clearCache$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $editRootPath;
    int I$0;
    int I$1;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditActivity$clearCache$1(String str, Continuation<? super EditActivity$clearCache$1> continuation) {
        super(2, continuation);
        this.$editRootPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditActivity$clearCache$1(this.$editRootPath, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditActivity$clearCache$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i2;
        int length;
        String[] strArr;
        EditActivity$clearCache$1 editActivity$clearCache$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            j.b(obj);
            String[] list = new File(this.$editRootPath).list();
            if (list == null) {
                return u.a;
            }
            i2 = 0;
            length = list.length;
            strArr = list;
            editActivity$clearCache$1 = this;
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i4 = this.I$1;
            int i5 = this.I$0;
            strArr = (String[]) this.L$0;
            j.b(obj);
            editActivity$clearCache$1 = this;
            length = i4;
            i2 = i5;
        }
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            String str2 = editActivity$clearCache$1.$editRootPath + ((Object) File.separator) + ((Object) str);
            editActivity$clearCache$1.L$0 = strArr;
            editActivity$clearCache$1.I$0 = i2;
            editActivity$clearCache$1.I$1 = length;
            editActivity$clearCache$1.label = 1;
            if (FileUtils.l(str2, editActivity$clearCache$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return u.a;
    }
}
