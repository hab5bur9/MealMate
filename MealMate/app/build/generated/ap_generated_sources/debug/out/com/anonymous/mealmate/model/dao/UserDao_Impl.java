package com.anonymous.mealmate.model.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.anonymous.mealmate.model.entity.User;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user` (`id`,`User_name`,`User_gender`,`User_height`,`User_weight`,`User_activityRatio`,`User_purpose`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getGender());
        stmt.bindLong(4, value.getHeight());
        stmt.bindLong(5, value.getWeight());
        stmt.bindLong(6, value.getActivityRatio());
        stmt.bindLong(7, value.getPurpose());
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user` SET `id` = ?,`User_name` = ?,`User_gender` = ?,`User_height` = ?,`User_weight` = ?,`User_activityRatio` = ?,`User_purpose` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getGender());
        stmt.bindLong(4, value.getHeight());
        stmt.bindLong(5, value.getWeight());
        stmt.bindLong(6, value.getActivityRatio());
        stmt.bindLong(7, value.getPurpose());
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insertUser(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<User> getUserByName(final String userName) {
    final String _sql = "SELECT * FROM user WHERE user_name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"user"}, false, new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "User_name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "User_gender");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "User_height");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "User_weight");
          final int _cursorIndexOfActivityRatio = CursorUtil.getColumnIndexOrThrow(_cursor, "User_activityRatio");
          final int _cursorIndexOfPurpose = CursorUtil.getColumnIndexOrThrow(_cursor, "User_purpose");
          final User _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpGender;
            _tmpGender = _cursor.getInt(_cursorIndexOfGender);
            final int _tmpHeight;
            _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
            final int _tmpWeight;
            _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            final int _tmpActivityRatio;
            _tmpActivityRatio = _cursor.getInt(_cursorIndexOfActivityRatio);
            final int _tmpPurpose;
            _tmpPurpose = _cursor.getInt(_cursorIndexOfPurpose);
            _result = new User(_tmpName,_tmpGender,_tmpHeight,_tmpWeight,_tmpActivityRatio,_tmpPurpose);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
