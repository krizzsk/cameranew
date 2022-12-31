package us.pinguo.payssion;

import android.content.Intent;
import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: PayssionManager.kt */
/* loaded from: classes5.dex */
public final class PayssionManager {
    public static final PayssionManager INSTANCE = new PayssionManager();
    private static String currentPmId;

    /* compiled from: PayssionManager.kt */
    /* loaded from: classes5.dex */
    public static final class Data {
        private final int trade_status;

        public Data(int i2) {
            this.trade_status = i2;
        }

        public static /* synthetic */ Data copy$default(Data data, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = data.trade_status;
            }
            return data.copy(i2);
        }

        public final int component1() {
            return this.trade_status;
        }

        public final Data copy(int i2) {
            return new Data(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && this.trade_status == ((Data) obj).trade_status;
        }

        public final int getTrade_status() {
            return this.trade_status;
        }

        public int hashCode() {
            return this.trade_status;
        }

        public String toString() {
            return "Data(trade_status=" + this.trade_status + ')';
        }
    }

    /* compiled from: PayssionManager.kt */
    /* loaded from: classes5.dex */
    public static final class Response {
        private final Data data;

        public Response(Data data) {
            s.h(data, "data");
            this.data = data;
        }

        public static /* synthetic */ Response copy$default(Response response, Data data, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                data = response.data;
            }
            return response.copy(data);
        }

        public final Data component1() {
            return this.data;
        }

        public final Response copy(Data data) {
            s.h(data, "data");
            return new Response(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Response) && s.c(this.data, ((Response) obj).data);
        }

        public final Data getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "Response(data=" + this.data + ')';
        }
    }

    private PayssionManager() {
    }

    public final String getCurrentPmId() {
        return currentPmId;
    }

    public final List<PayssionPayway> getLocalPaywayByPayssion() {
        return null;
    }

    public final void handleActitvityResult(int i2, int i3, Intent intent) {
    }

    public final void setCurrentPmId(String str) {
        currentPmId = str;
    }
}
