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
import com.anonymous.mealmate.model.entity.Meal;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MealDao_Impl implements MealDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Meal> __insertionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter<Meal> __deletionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter<Meal> __updateAdapterOfMeal;

  public MealDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeal = new EntityInsertionAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `meal` (`mealIndex`,`mealDate`,`mealCnt`,`mealFoodAmount`,`foodIndex`,`checked`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.getMealIndex());
        if (value.getMealDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMealDate());
        }
        stmt.bindLong(3, value.getMealCnt());
        stmt.bindLong(4, value.getMealFoodAmount());
        stmt.bindLong(5, value.getFoodIndex());
        stmt.bindLong(6, value.getChecked());
      }
    };
    this.__deletionAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `meal` WHERE `mealIndex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.getMealIndex());
      }
    };
    this.__updateAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `meal` SET `mealIndex` = ?,`mealDate` = ?,`mealCnt` = ?,`mealFoodAmount` = ?,`foodIndex` = ?,`checked` = ? WHERE `mealIndex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.getMealIndex());
        if (value.getMealDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMealDate());
        }
        stmt.bindLong(3, value.getMealCnt());
        stmt.bindLong(4, value.getMealFoodAmount());
        stmt.bindLong(5, value.getFoodIndex());
        stmt.bindLong(6, value.getChecked());
        stmt.bindLong(7, value.getMealIndex());
      }
    };
  }

  @Override
  public void insertMeal(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeal.insert(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMeal(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMeal.handle(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMeal(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMeal.handle(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Meal>> getAllMeals() {
    final String _sql = "SELECT * FROM meal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"meal"}, false, new Callable<List<Meal>>() {
      @Override
      public List<Meal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMealIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "mealIndex");
          final int _cursorIndexOfMealDate = CursorUtil.getColumnIndexOrThrow(_cursor, "mealDate");
          final int _cursorIndexOfMealCnt = CursorUtil.getColumnIndexOrThrow(_cursor, "mealCnt");
          final int _cursorIndexOfMealFoodAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "mealFoodAmount");
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "checked");
          final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Meal _item;
            final String _tmpMealDate;
            if (_cursor.isNull(_cursorIndexOfMealDate)) {
              _tmpMealDate = null;
            } else {
              _tmpMealDate = _cursor.getString(_cursorIndexOfMealDate);
            }
            final int _tmpMealCnt;
            _tmpMealCnt = _cursor.getInt(_cursorIndexOfMealCnt);
            final int _tmpMealFoodAmount;
            _tmpMealFoodAmount = _cursor.getInt(_cursorIndexOfMealFoodAmount);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            final int _tmpChecked;
            _tmpChecked = _cursor.getInt(_cursorIndexOfChecked);
            _item = new Meal(_tmpMealDate,_tmpMealCnt,_tmpMealFoodAmount,_tmpFoodIndex,_tmpChecked);
            final int _tmpMealIndex;
            _tmpMealIndex = _cursor.getInt(_cursorIndexOfMealIndex);
            _item.setMealIndex(_tmpMealIndex);
            _result.add(_item);
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

  @Override
  public LiveData<List<Meal>> getMealsByDate(final String mealDate) {
    final String _sql = "SELECT * FROM meal WHERE mealDate = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (mealDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mealDate);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"meal"}, false, new Callable<List<Meal>>() {
      @Override
      public List<Meal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMealIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "mealIndex");
          final int _cursorIndexOfMealDate = CursorUtil.getColumnIndexOrThrow(_cursor, "mealDate");
          final int _cursorIndexOfMealCnt = CursorUtil.getColumnIndexOrThrow(_cursor, "mealCnt");
          final int _cursorIndexOfMealFoodAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "mealFoodAmount");
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "checked");
          final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Meal _item;
            final String _tmpMealDate;
            if (_cursor.isNull(_cursorIndexOfMealDate)) {
              _tmpMealDate = null;
            } else {
              _tmpMealDate = _cursor.getString(_cursorIndexOfMealDate);
            }
            final int _tmpMealCnt;
            _tmpMealCnt = _cursor.getInt(_cursorIndexOfMealCnt);
            final int _tmpMealFoodAmount;
            _tmpMealFoodAmount = _cursor.getInt(_cursorIndexOfMealFoodAmount);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            final int _tmpChecked;
            _tmpChecked = _cursor.getInt(_cursorIndexOfChecked);
            _item = new Meal(_tmpMealDate,_tmpMealCnt,_tmpMealFoodAmount,_tmpFoodIndex,_tmpChecked);
            final int _tmpMealIndex;
            _tmpMealIndex = _cursor.getInt(_cursorIndexOfMealIndex);
            _item.setMealIndex(_tmpMealIndex);
            _result.add(_item);
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

  @Override
  public LiveData<List<Meal>> getMealsByFoodIndex(final int foodIndex) {
    final String _sql = "SELECT * FROM meal WHERE foodIndex = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, foodIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"meal"}, false, new Callable<List<Meal>>() {
      @Override
      public List<Meal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMealIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "mealIndex");
          final int _cursorIndexOfMealDate = CursorUtil.getColumnIndexOrThrow(_cursor, "mealDate");
          final int _cursorIndexOfMealCnt = CursorUtil.getColumnIndexOrThrow(_cursor, "mealCnt");
          final int _cursorIndexOfMealFoodAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "mealFoodAmount");
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "checked");
          final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Meal _item;
            final String _tmpMealDate;
            if (_cursor.isNull(_cursorIndexOfMealDate)) {
              _tmpMealDate = null;
            } else {
              _tmpMealDate = _cursor.getString(_cursorIndexOfMealDate);
            }
            final int _tmpMealCnt;
            _tmpMealCnt = _cursor.getInt(_cursorIndexOfMealCnt);
            final int _tmpMealFoodAmount;
            _tmpMealFoodAmount = _cursor.getInt(_cursorIndexOfMealFoodAmount);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            final int _tmpChecked;
            _tmpChecked = _cursor.getInt(_cursorIndexOfChecked);
            _item = new Meal(_tmpMealDate,_tmpMealCnt,_tmpMealFoodAmount,_tmpFoodIndex,_tmpChecked);
            final int _tmpMealIndex;
            _tmpMealIndex = _cursor.getInt(_cursorIndexOfMealIndex);
            _item.setMealIndex(_tmpMealIndex);
            _result.add(_item);
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

  @Override
  public LiveData<List<Meal>> getCheckedMeals() {
    final String _sql = "SELECT * FROM meal WHERE checked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"meal"}, false, new Callable<List<Meal>>() {
      @Override
      public List<Meal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMealIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "mealIndex");
          final int _cursorIndexOfMealDate = CursorUtil.getColumnIndexOrThrow(_cursor, "mealDate");
          final int _cursorIndexOfMealCnt = CursorUtil.getColumnIndexOrThrow(_cursor, "mealCnt");
          final int _cursorIndexOfMealFoodAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "mealFoodAmount");
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "checked");
          final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Meal _item;
            final String _tmpMealDate;
            if (_cursor.isNull(_cursorIndexOfMealDate)) {
              _tmpMealDate = null;
            } else {
              _tmpMealDate = _cursor.getString(_cursorIndexOfMealDate);
            }
            final int _tmpMealCnt;
            _tmpMealCnt = _cursor.getInt(_cursorIndexOfMealCnt);
            final int _tmpMealFoodAmount;
            _tmpMealFoodAmount = _cursor.getInt(_cursorIndexOfMealFoodAmount);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            final int _tmpChecked;
            _tmpChecked = _cursor.getInt(_cursorIndexOfChecked);
            _item = new Meal(_tmpMealDate,_tmpMealCnt,_tmpMealFoodAmount,_tmpFoodIndex,_tmpChecked);
            final int _tmpMealIndex;
            _tmpMealIndex = _cursor.getInt(_cursorIndexOfMealIndex);
            _item.setMealIndex(_tmpMealIndex);
            _result.add(_item);
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
