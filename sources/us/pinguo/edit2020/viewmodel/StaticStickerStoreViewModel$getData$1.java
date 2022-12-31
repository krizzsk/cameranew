package us.pinguo.edit2020.viewmodel;

import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.utils.k;
import us.pinguo.repository2020.database.staticsticker.ShopCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerStoreViewModel.kt */
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel$getData$1 extends Lambda implements l<Exception, u> {
    final /* synthetic */ StaticStickerStoreViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerStoreViewModel.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$getData$1$2", f = "StaticStickerStoreViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$getData$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Map<ShopCategory, ArrayList<StaticStickerCategory>> $categoryResultMap;
        int label;
        final /* synthetic */ StaticStickerStoreViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StaticStickerStoreViewModel staticStickerStoreViewModel, Map<ShopCategory, ArrayList<StaticStickerCategory>> map, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerStoreViewModel;
            this.$categoryResultMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$categoryResultMap, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            e eVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                eVar = this.this$0.a;
                k c = k.a.c(new us.pinguo.edit2020.model.f.b(this.$categoryResultMap));
                this.label = 1;
                if (eVar.D(c, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                j.b(obj);
            }
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerStoreViewModel$getData$1(StaticStickerStoreViewModel staticStickerStoreViewModel) {
        super(1);
        this.this$0 = staticStickerStoreViewModel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Exception exc) {
        invoke2(exc);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        StaticStickerManager staticStickerManager = StaticStickerManager.a;
        List<ShopCategory> v = staticStickerManager.v();
        if (v != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, StaticStickerCategory> x = staticStickerManager.x();
            long currentTimeMillis = System.currentTimeMillis();
            for (ShopCategory shopCategory : v) {
                ArrayList arrayList = new ArrayList();
                String[] pids = shopCategory.getPids();
                if (pids != null) {
                    for (String str : pids) {
                        StaticStickerCategory staticStickerCategory = x.get(str);
                        if (staticStickerCategory != null && staticStickerCategory.isValid(currentTimeMillis)) {
                            arrayList.add(staticStickerCategory);
                        }
                    }
                }
                linkedHashMap.put(shopCategory, arrayList);
            }
            kotlinx.coroutines.l.d(ViewModelKt.getViewModelScope(this.this$0), z0.c(), null, new AnonymousClass2(this.this$0, linkedHashMap, null), 2, null);
        }
    }
}
