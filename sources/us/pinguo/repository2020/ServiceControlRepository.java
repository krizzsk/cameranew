package us.pinguo.repository2020;

import android.content.Context;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.entity.GpuLadderResponse;
import us.pinguo.repository2020.entity.ServiceControlSwitch;
import us.pinguo.repository2020.network.ApiGpuLadder;
import us.pinguo.repository2020.network.ApiServiceControlSwitch;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.user.u0;
/* compiled from: ServiceControlRepository.kt */
/* loaded from: classes6.dex */
public final class ServiceControlRepository {
    public static final a a = new a(null);
    private static ServiceControlSwitch b;

    /* compiled from: ServiceControlRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final ServiceControlSwitch a() {
            return ServiceControlRepository.b;
        }

        public final void b(ServiceControlSwitch serviceControlSwitch) {
            ServiceControlRepository.b = serviceControlSwitch;
        }
    }

    /* compiled from: ServiceControlRepository.kt */
    /* loaded from: classes6.dex */
    public static final class b extends j.a.c.b.d<HttpBaseResponse<ServiceControlSwitch>> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(HttpBaseResponse<ServiceControlSwitch> serviceControlSwitchResponse) {
            Integer coupon_on;
            Long privacyUpdateDate;
            Long privacyUpdateDate2;
            Long serviceUpdateDate;
            Long privacyUpdateDate3;
            Long privacyUpdateDate4;
            kotlin.jvm.internal.s.h(serviceControlSwitchResponse, "serviceControlSwitchResponse");
            a aVar = ServiceControlRepository.a;
            aVar.b(serviceControlSwitchResponse.getData());
            us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
            ServiceControlSwitch data = serviceControlSwitchResponse.getData();
            e2.m("pref_vip_redeem_code_switch", (data == null || (coupon_on = data.getCoupon_on()) == null || coupon_on.intValue() != 1) ? false : true);
            long j2 = e2.j("pref_privacy_update_date", 0L);
            long j3 = e2.j("pref_service_update_date", 0L);
            if (j2 == 0) {
                ServiceControlSwitch data2 = serviceControlSwitchResponse.getData();
                e2.r("pref_privacy_update_date", (data2 == null || (privacyUpdateDate4 = data2.getPrivacyUpdateDate()) == null) ? 0L : privacyUpdateDate4.longValue());
            }
            ServiceControlSwitch data3 = serviceControlSwitchResponse.getData();
            if (((data3 == null || (privacyUpdateDate = data3.getPrivacyUpdateDate()) == null) ? 0L : privacyUpdateDate.longValue()) > 0) {
                ServiceControlSwitch data4 = serviceControlSwitchResponse.getData();
                e2.r("pref_privacy_cur_update_date", (data4 == null || (privacyUpdateDate3 = data4.getPrivacyUpdateDate()) == null) ? 0L : privacyUpdateDate3.longValue());
            }
            if (j3 == 0) {
                ServiceControlSwitch data5 = serviceControlSwitchResponse.getData();
                e2.r("pref_service_update_date", (data5 == null || (serviceUpdateDate = data5.getServiceUpdateDate()) == null) ? 0L : serviceUpdateDate.longValue());
            }
            if (aVar.a() != null) {
                ServiceControlSwitch a = aVar.a();
                j2 = (a == null || (privacyUpdateDate2 = a.getPrivacyUpdateDate()) == null) ? 0L : privacyUpdateDate2.longValue();
            }
            long j4 = e2.j("pref_privacy_update_date", 0L);
            if (j4 != 0 && j4 < j2) {
                e2.m("key_disable_data_collect", true);
                e2.m("key_is_need_privace_dialog_init_sdk", false);
                u0.o = true;
            }
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            us.pinguo.common.log.a.e(e2.toString(), new Object[0]);
        }
    }

    public final void c(Context ctx) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        new ApiServiceControlSwitch(ctx).get(new b());
        if (RequestIntervalPref.a.c("/v1/json-config-show?code=gpuLadder", 259200000L, null) == RequestIntervalPref.RefreshType.NONE_REFRESH) {
            return;
        }
        new ApiGpuLadder(ctx).get(new j.a.c.b.d<GpuLadderResponse>() { // from class: us.pinguo.repository2020.ServiceControlRepository$initServiceControlSwitch$2
            @Override // j.a.c.b.d
            /* renamed from: a */
            public void onSuccess(GpuLadderResponse gpuLadderResponse) {
                kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1(gpuLadderResponse, null), 3, null);
                RequestIntervalPref.a.d(r1, 259200000L, null);
            }

            @Override // j.a.c.b.d
            public void onError(Exception e2) {
                kotlin.jvm.internal.s.h(e2, "e");
                us.pinguo.common.log.a.e(e2.toString(), new Object[0]);
            }
        });
    }
}
