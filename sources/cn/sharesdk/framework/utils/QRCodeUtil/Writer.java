package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Map;
/* loaded from: classes.dex */
public interface Writer {
    c encode(String str, a aVar, int i2, int i3) throws WriterException;

    c encode(String str, a aVar, int i2, int i3, Map<e, ?> map) throws WriterException;
}
