package us.pinguo.inspire.module.contact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.volley.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.contact.entry.AddressBook;
import us.pinguo.inspire.module.contact.entry.AddressBookFriend;
import us.pinguo.inspire.module.contact.entry.HotUserEntry;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.contact.entry.ThirdSiteFriend;
import us.pinguo.inspire.module.contact.entry.ThirdSiteInfo;
import us.pinguo.inspire.module.contact.entry.ThirdSiteRedDot;
/* loaded from: classes9.dex */
public class ContactLoader {
    private static final String ADDRESS_RED_COUNT_URL = "/user/addrBook/fCount";
    private static final String ADD_BOOK_FRIEND_URL = "/user/addrBook/friends";
    private static final String ADD_BOOK_URL = "/user/addrBook/report";
    private static final String HOT_USER_URL = "/rec/hotUsers";
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    private static final int PHONES_NUMBER_INDEX = 1;
    private static final String[] PHONES_PROJECTION = {"display_name", "data1", "photo_id", "contact_id"};
    private static final String THIRD_SITE_BIND_URL = "/user/third/complexBind";
    private static final String THIRD_SITE_FRIEND_COUNT_URL = "/user/third/fCount";
    private static final String THIRD_SITE_FRIEND_LIST_URL = "/user/third/friends";
    private static final String USER_RECOMMEND = "/rec/users";

    /* loaded from: classes9.dex */
    public static class AddBookResp {
        public List<AddressBookFriend> list;
    }

    /* loaded from: classes9.dex */
    public static class AddressRedCount {
        int count;
    }

    /* loaded from: classes9.dex */
    public static class RecommendResp {
        public List<Recommend> list;
        public BigDecimal sp;
    }

    /* loaded from: classes9.dex */
    public static class ThirdFriendResp {
        public List<ThirdSiteFriend> list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List a(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AddressBook addressBook = (AddressBook) list.get(i2);
            if (PhoneUtils.isValid(addressBook.phoneNumber)) {
                arrayList.add(addressBook);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String b(List list) {
        Iterator it;
        String str = "";
        if (list != null) {
            while (list.iterator().hasNext()) {
                str = str + ((AddressBook) it.next()).toString() + "||";
            }
        }
        us.pinguo.common.log.a.m("ContactLoader", "params:" + str, new Object[0]);
        try {
            str = Des3Utils.encryptAndBase64(str, Des3Utils.DES_KEY);
            us.pinguo.common.log.a.m("ContactLoader", "secret params:" + str, new Object[0]);
            return str;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ AddBookResp d(String str) {
        Response c = us.pinguo.foundation.m.f.c(new Inspire.d<BaseResponse<AddBookResp>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.2
        }.url(ADD_BOOK_URL).put("addrBook", str).build());
        if (c.isSuccess()) {
            return (AddBookResp) ((BaseResponse) c.result).data;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List e(AddBookResp addBookResp) {
        if (addBookResp != null) {
            return addBookResp.list;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(ContentResolver contentResolver, Subscriber subscriber) {
        ArrayList arrayList = new ArrayList();
        Cursor query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(1);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new AddressBook(query.getString(0), string));
                }
            }
            query.close();
        }
        Cursor query2 = contentResolver.query(Uri.parse("content://icc/adn"), PHONES_PROJECTION, null, null, null);
        if (query2 != null) {
            while (query2.moveToNext()) {
                String string2 = query2.getString(1);
                if (!TextUtils.isEmpty(string2)) {
                    arrayList.add(new AddressBook(query2.getString(0), string2));
                }
            }
            query2.close();
        }
        subscriber.onNext(arrayList);
        subscriber.onCompleted();
    }

    public Observable<List<AddressBookFriend>> addBook(ContentResolver contentResolver) {
        return getPhoneContacts(contentResolver).map(o.a).map(i.a).map(new Func1() { // from class: us.pinguo.inspire.module.contact.j
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return ContactLoader.this.d((String) obj);
            }
        }).map(h.a).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }

    public Observable<ThirdSiteInfo> bindThirdSite(String str, String str2, String str3, long j2, String str4) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ThirdSiteInfo>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.6
        }.url(THIRD_SITE_BIND_URL).put("siteCode", str3).put("thirdId", str).put("accessToken", str2).put("expirationDate", j2).put("tokenSecret", str4).put("syncFriends", 1).put("syncThirdUserInfo", 1).build()).map(new Payload());
    }

    public Observable<List<AddressBookFriend>> fetchAddressBookFriends() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<AddBookResp>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.3
        }.url(ADD_BOOK_FRIEND_URL).build()).map(new Payload()).map(m.a);
    }

    public Observable<HotUserEntry> fetchHotUsers() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<HotUserEntry>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.1
        }.url(HOT_USER_URL).build()).map(new Payload());
    }

    public Observable<RecommendResp> fetchRecommendList(BigDecimal bigDecimal, int i2) {
        f.a<BaseResponse<RecommendResp>> put = new Inspire.d<BaseResponse<RecommendResp>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.8
        }.url(USER_RECOMMEND).put("sp", bigDecimal.toPlainString());
        return us.pinguo.foundation.m.f.f(put.put("num", i2 + "").build()).map(new Payload());
    }

    public Observable<Integer> fetchRedDotCount() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<AddressRedCount>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.4
        }.url(ADDRESS_RED_COUNT_URL).build()).map(new Payload()).map(l.a);
    }

    public Observable<List<ThirdSiteFriend>> fetchThirdFirendList(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ThirdFriendResp>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.7
        }.url(THIRD_SITE_FRIEND_LIST_URL).put("siteCode", str).build()).map(new Payload()).map(k.a);
    }

    public Observable<ThirdSiteRedDot> fetchThirdFriendCount() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ThirdSiteRedDot>>() { // from class: us.pinguo.inspire.module.contact.ContactLoader.5
        }.url(THIRD_SITE_FRIEND_COUNT_URL).build()).map(new Payload());
    }

    public Observable<List<AddressBook>> getPhoneContacts(final ContentResolver contentResolver) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.contact.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactLoader.i(contentResolver, (Subscriber) obj);
            }
        });
    }
}
