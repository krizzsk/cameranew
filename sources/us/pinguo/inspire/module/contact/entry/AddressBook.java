package us.pinguo.inspire.module.contact.entry;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.contact.PhoneUtils;
/* loaded from: classes9.dex */
public class AddressBook {
    public String name;
    public String phoneNumber;

    public AddressBook() {
    }

    public String toString() {
        String str = this.name;
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Inspire.f(e2);
        }
        return str + "," + PhoneUtils.phoneFormat(this.phoneNumber);
    }

    public AddressBook(String str, String str2) {
        this.name = str;
        this.phoneNumber = str2;
    }
}
