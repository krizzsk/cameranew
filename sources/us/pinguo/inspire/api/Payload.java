package us.pinguo.inspire.api;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.R;
import us.pinguo.user.s0;
/* loaded from: classes4.dex */
public class Payload<V> implements Func1<BaseResponse<V>, V> {
    public static SparseArray<Integer> CLIENT_FAULT_CODES = null;
    public static final int CODE_ACCOUNT_REPORTED = 11403;
    public static final int CODE_GAME_EXSIT = 11101;
    public static final int CODE_GARBIGE_NOT_PASS = 19001;
    public static final int CODE_TOPIC_NOT_FOUND = 11002;
    public static final int CODE_WORK_NOT_FOUND = 11001;
    public static List<Integer> FAULT_CODES = null;
    public static final int SERVER_ERROR_CODE_1001 = 1001;
    public static final int SERVER_ERROR_CODE_1002 = 1002;
    public static final int SERVER_ERROR_CODE_1003 = 1003;
    public static final int SERVER_ERROR_CODE_10501 = 10501;
    public static final int SERVER_ERROR_CODE_10512 = 10512;
    public static final int SERVER_ERROR_CODE_10513 = 10513;
    private static final int SERVER_ERROR_CODE_10524 = 10524;
    public static final int SERVER_ERROR_CODE_11001 = 11001;
    public static final int SERVER_ERROR_CODE_11002 = 11002;
    public static final int SERVER_ERROR_CODE_11003 = 11003;
    public static final int SERVER_ERROR_CODE_11021 = 11021;
    public static final int SERVER_ERROR_CODE_11403 = 11403;
    public static final int SERVER_ERROR_CODE_16001 = 16001;
    public static final int SERVER_ERROR_CODE_16002 = 16002;
    public static final int SERVER_ERROR_CODE_16003 = 16003;
    public static final int SERVER_ERROR_CODE_18001 = 18001;
    public static final int SERVER_ERROR_CODE_18002 = 18002;
    public static final int SERVER_ERROR_CODE_18003 = 18003;
    public static final int SERVER_ERROR_CODE_18004 = 18004;
    public static final int SERVER_ERROR_CODE_18005 = 18005;
    public static final int SERVER_ERROR_CODE_18006 = 18006;
    public static final int SERVER_ERROR_CODE_19001 = 19001;
    public static final int SERVER_ERROR_CODE_401 = 401;

    static {
        ArrayList arrayList = new ArrayList();
        FAULT_CODES = arrayList;
        arrayList.add(11001);
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_11003));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_11021));
        FAULT_CODES.add(11002);
        FAULT_CODES.add(19001);
        FAULT_CODES.add(11403);
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_16001));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_16002));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_16003));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18001));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18002));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18003));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18004));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18005));
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_18006));
        FAULT_CODES.add(1001);
        FAULT_CODES.add(1002);
        FAULT_CODES.add(1003);
        FAULT_CODES.add(Integer.valueOf((int) SERVER_ERROR_CODE_10501));
        SparseArray<Integer> sparseArray = new SparseArray<>();
        CLIENT_FAULT_CODES = sparseArray;
        sparseArray.put(401, Integer.valueOf(R.string.empty));
        CLIENT_FAULT_CODES.put(SERVER_ERROR_CODE_10512, Integer.valueOf(R.string.status_errorcode10011));
        CLIENT_FAULT_CODES.put(SERVER_ERROR_CODE_10513, Integer.valueOf(R.string.personal_infomation_nickname_exist));
        CLIENT_FAULT_CODES.put(SERVER_ERROR_CODE_10524, Integer.valueOf(R.string.forbidden_words));
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((BaseResponse) ((BaseResponse) obj));
    }

    public V call(BaseResponse<V> baseResponse) {
        String str;
        int i2 = baseResponse.status;
        if (i2 == 200) {
            return baseResponse.data;
        }
        if (i2 == 420) {
            s0.getInstance().k();
        }
        if (TextUtils.isEmpty(baseResponse.url)) {
            str = baseResponse.message;
        } else {
            str = baseResponse.url + ";" + baseResponse.message;
        }
        throw new Fault(baseResponse.status, str);
    }
}
