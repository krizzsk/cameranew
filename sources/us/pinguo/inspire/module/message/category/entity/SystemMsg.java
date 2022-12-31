package us.pinguo.inspire.module.message.category.entity;
/* loaded from: classes9.dex */
public class SystemMsg {
    public static final String TYPE_AWARD = "ranking";
    public double createTime;
    public String endTime;
    public SystemMsgData msg;
    public String startTime;
    public String type;
    public String typeShow;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SystemMsg systemMsg = (SystemMsg) obj;
        if (Double.compare(systemMsg.createTime, this.createTime) != 0) {
            return false;
        }
        String str = this.startTime;
        if (str == null ? systemMsg.startTime == null : str.equals(systemMsg.startTime)) {
            String str2 = this.endTime;
            if (str2 == null ? systemMsg.endTime == null : str2.equals(systemMsg.endTime)) {
                String str3 = this.type;
                if (str3 == null ? systemMsg.type == null : str3.equals(systemMsg.type)) {
                    SystemMsgData systemMsgData = this.msg;
                    SystemMsgData systemMsgData2 = systemMsg.msg;
                    return systemMsgData != null ? systemMsgData.equals(systemMsgData2) : systemMsgData2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.startTime;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.endTime;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = hashCode2 + (str3 != null ? str3.hashCode() : 0);
        long doubleToLongBits = Double.doubleToLongBits(this.createTime);
        int i2 = ((hashCode3 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        SystemMsgData systemMsgData = this.msg;
        return i2 + (systemMsgData != null ? systemMsgData.hashCode() : 0);
    }

    public boolean isAward() {
        return "ranking".equals(this.type);
    }
}
