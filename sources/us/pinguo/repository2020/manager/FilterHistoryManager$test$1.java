package us.pinguo.repository2020.manager;

import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.user.User;
/* compiled from: FilterHistoryManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterHistoryManager$test$1", f = "FilterHistoryManager.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilterHistoryManager$test$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    FilterHistoryManager$test$1(Continuation<? super FilterHistoryManager$test$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterHistoryManager$test$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterHistoryManager$test$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = "";
            for (us.pinguo.repository2020.database.b.c cVar : us.pinguo.repository2020.database.a.a().v().a()) {
                ref$ObjectRef.element = ((String) ref$ObjectRef.element) + ("id=" + cVar.a() + ",position=" + cVar.d() + ",num=" + cVar.b()) + '|';
            }
            Toast makeText = Toast.makeText(us.pinguo.foundation.e.b(), (CharSequence) ref$ObjectRef.element, 1);
            makeText.show();
            VdsAgent.showToast(makeText);
            this.label = 1;
            if (DelayKt.b(5000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        Object obj2 = SPUtils.get(us.pinguo.foundation.e.b(), "edit_first_time", Boxing.boxLong(0L));
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Long");
        long longValue = ((Long) obj2).longValue();
        Object obj3 = SPUtils.get(us.pinguo.foundation.e.b(), "edit_last_time", Boxing.boxLong(0L));
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Long");
        long longValue2 = ((Long) obj3).longValue();
        Object obj4 = SPUtils.get(us.pinguo.foundation.e.b(), "camera_first_time", Boxing.boxLong(0L));
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Long");
        long longValue3 = ((Long) obj4).longValue();
        Object obj5 = SPUtils.get(us.pinguo.foundation.e.b(), "camera_last_time", Boxing.boxLong(0L));
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Long");
        long longValue4 = ((Long) obj5).longValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_SEC_HYPHEN);
        Date date = new Date(longValue);
        Date date2 = new Date(longValue3);
        Date date3 = new Date(longValue2);
        Date date4 = new Date(longValue4);
        String format = simpleDateFormat.format(date);
        String format2 = simpleDateFormat.format(date2);
        String format3 = simpleDateFormat.format(Boxing.boxLong(User.d().g()));
        String format4 = simpleDateFormat.format(date3);
        String format5 = simpleDateFormat.format(date4);
        Toast makeText2 = Toast.makeText(us.pinguo.foundation.e.b(), "editFirst=" + ((Object) format) + ",cameraFirst=" + ((Object) format2) + ",timeEditLast=" + ((Object) format4) + ",timeCameraLast=" + ((Object) format5) + ",firstOpenAppTime=" + ((Object) format3), 1);
        makeText2.show();
        VdsAgent.showToast(makeText2);
        return u.a;
    }
}
