package us.pinguo.inspire.model;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InspireMsgCountResp {
    public static InspireMsgCountResp NullMsgCount;
    public ArrayList<FansInfo> fansList;
    public MsgCount msgCount;

    static {
        InspireMsgCountResp inspireMsgCountResp = new InspireMsgCountResp();
        NullMsgCount = inspireMsgCountResp;
        inspireMsgCountResp.msgCount = new MsgCount();
    }

    public int hashCode() {
        MsgCount msgCount = this.msgCount;
        int hashCode = (msgCount != null ? msgCount.hashCode() : 0) * 31;
        ArrayList<FansInfo> arrayList = this.fansList;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }
}
