package us.pinguo.inspire.module.contact;

import android.os.Bundle;
import us.pinguo.foundation.base.BaseSplitActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AddressBookActivity extends BaseSplitActivity {
    public static final int FLAG_ADDRESS_BOOK = 0;
    public static final String FLAG_KEY = "FLAG_KEY";
    public static final int FLAG_THIRD_SITE = 1;
    private boolean isAddressBook;

    public boolean getIsAddressBook() {
        return this.isAddressBook;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.d(this.isAddressBook));
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.address_book_layout);
        this.isAddressBook = getIntent().getIntExtra(FLAG_KEY, 0) == 0;
        getSupportFragmentManager().beginTransaction().add(R.id.address_book_container, new AddressBookFragment()).commit();
    }
}
