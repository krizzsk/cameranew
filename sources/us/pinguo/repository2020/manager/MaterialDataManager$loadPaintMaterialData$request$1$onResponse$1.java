package us.pinguo.repository2020.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* compiled from: MaterialDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1", f = "MaterialDataManager.kt", i = {0}, l = {149, 150}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $cachePath;
    final /* synthetic */ HttpBaseResponse<? extends MaterialResponse<? extends PaintMaterial>> $httpBaseResponse;
    final /* synthetic */ us.pinguo.repository2020.u<? extends MaterialResponse<? extends PaintMaterial>> $material;
    final /* synthetic */ String $response;
    final /* synthetic */ String $url;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1(HttpBaseResponse<? extends MaterialResponse<? extends PaintMaterial>> httpBaseResponse, String str, us.pinguo.repository2020.u<? extends MaterialResponse<? extends PaintMaterial>> uVar, String str2, String str3, Continuation<? super MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$httpBaseResponse = httpBaseResponse;
        this.$url = str;
        this.$material = uVar;
        this.$cachePath = str2;
        this.$response = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1(this.$httpBaseResponse, this.$url, this.$material, this.$cachePath, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((MaterialDataManager$loadPaintMaterialData$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        File file;
        Integer interval;
        String pid;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            ArrayList arrayList = new ArrayList();
            List<? extends PaintMaterial> packages = this.$httpBaseResponse.getData().getPackages();
            int i3 = 0;
            if (packages != null) {
                for (PaintMaterial paintMaterial : packages) {
                    MaterialDataManager materialDataManager = MaterialDataManager.a;
                    PaintMaterial paintMaterial2 = materialDataManager.e().get(paintMaterial.getPid());
                    if (materialDataManager.e().containsKey(paintMaterial.getPid())) {
                        if ((paintMaterial2 != null && paintMaterial2.isInstalled()) && !s.c(paintMaterial.getDown_url(), paintMaterial2.getDown_url()) && (pid = paintMaterial.getPid()) != null) {
                            Boxing.boxBoolean(arrayList.add(pid));
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                us.pinguo.repository2020.database.a.a().B().a(arrayList);
            }
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            String str = this.$url;
            MaterialResponse<? extends PaintMaterial> value = this.$material.getValue();
            if (value != null && (interval = value.getInterval()) != null) {
                i3 = interval.intValue();
            }
            requestIntervalPref.d(str, i3 * 1000, null);
            file = new File(this.$cachePath);
            file.delete();
            this.L$0 = file;
            this.label = 1;
            if (FileUtils.g(file, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            file = (File) this.L$0;
            kotlin.j.b(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        }
        String str2 = this.$response;
        this.L$0 = null;
        this.label = 2;
        if (FileIOUtils.o(file, str2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
