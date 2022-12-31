package us.pinguo.repository2020.database.filter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: FilterParamsDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface e {
    @Query("SELECT * FROM effect")
    List<FilterParamsTable> a();

    @Insert(onConflict = 1)
    void b(List<FilterParamsTable> list);

    @Delete
    void c(List<FilterParamsTable> list);

    @Query("SELECT * FROM effect WHERE packageId=:packageId")
    List<FilterParamsTable> d(String str);
}
