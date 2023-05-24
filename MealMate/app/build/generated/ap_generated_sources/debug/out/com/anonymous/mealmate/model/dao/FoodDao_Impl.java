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
import com.anonymous.mealmate.model.entity.Food;
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
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Food> __insertionAdapterOfFood;

  private final EntityDeletionOrUpdateAdapter<Food> __deletionAdapterOfFood;

  private final EntityDeletionOrUpdateAdapter<Food> __updateAdapterOfFood;

  public FoodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFood = new EntityInsertionAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `food` (`foodIndex`,`foodName`,`foodKcal`,`foodCarbohydrates`,`foodProtein`,`foodFat`,`foodLike`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getFoodIndex());
        if (value.getFoodName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFoodName());
        }
        stmt.bindDouble(3, value.getFoodKcal());
        stmt.bindDouble(4, value.getFoodCarbohydrates());
        stmt.bindDouble(5, value.getFoodProtein());
        stmt.bindDouble(6, value.getFoodFat());
        stmt.bindLong(7, value.getFoodLike());
      }
    };
    this.__deletionAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `food` WHERE `foodIndex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getFoodIndex());
      }
    };
    this.__updateAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `food` SET `foodIndex` = ?,`foodName` = ?,`foodKcal` = ?,`foodCarbohydrates` = ?,`foodProtein` = ?,`foodFat` = ?,`foodLike` = ? WHERE `foodIndex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getFoodIndex());
        if (value.getFoodName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFoodName());
        }
        stmt.bindDouble(3, value.getFoodKcal());
        stmt.bindDouble(4, value.getFoodCarbohydrates());
        stmt.bindDouble(5, value.getFoodProtein());
        stmt.bindDouble(6, value.getFoodFat());
        stmt.bindLong(7, value.getFoodLike());
        stmt.bindLong(8, value.getFoodIndex());
      }
    };
  }

  @Override
  public void insertFood(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFood.insert(food);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFood(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFood.handle(food);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateFood(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFood.handle(food);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Food>> getAllFoods() {
    final String _sql = "SELECT * FROM food";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"food"}, false, new Callable<List<Food>>() {
      @Override
      public List<Food> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "foodName");
          final int _cursorIndexOfFoodKcal = CursorUtil.getColumnIndexOrThrow(_cursor, "foodKcal");
          final int _cursorIndexOfFoodCarbohydrates = CursorUtil.getColumnIndexOrThrow(_cursor, "foodCarbohydrates");
          final int _cursorIndexOfFoodProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "foodProtein");
          final int _cursorIndexOfFoodFat = CursorUtil.getColumnIndexOrThrow(_cursor, "foodFat");
          final int _cursorIndexOfFoodLike = CursorUtil.getColumnIndexOrThrow(_cursor, "foodLike");
          final List<Food> _result = new ArrayList<Food>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Food _item;
            final String _tmpFoodName;
            if (_cursor.isNull(_cursorIndexOfFoodName)) {
              _tmpFoodName = null;
            } else {
              _tmpFoodName = _cursor.getString(_cursorIndexOfFoodName);
            }
            final float _tmpFoodKcal;
            _tmpFoodKcal = _cursor.getFloat(_cursorIndexOfFoodKcal);
            final float _tmpFoodCarbohydrates;
            _tmpFoodCarbohydrates = _cursor.getFloat(_cursorIndexOfFoodCarbohydrates);
            final float _tmpFoodProtein;
            _tmpFoodProtein = _cursor.getFloat(_cursorIndexOfFoodProtein);
            final float _tmpFoodFat;
            _tmpFoodFat = _cursor.getFloat(_cursorIndexOfFoodFat);
            final int _tmpFoodLike;
            _tmpFoodLike = _cursor.getInt(_cursorIndexOfFoodLike);
            _item = new Food(_tmpFoodName,_tmpFoodKcal,_tmpFoodCarbohydrates,_tmpFoodProtein,_tmpFoodFat,_tmpFoodLike);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            _item.setFoodIndex(_tmpFoodIndex);
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
  public LiveData<List<Food>> getLikedFoods() {
    final String _sql = "SELECT * FROM food WHERE foodLike = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"food"}, false, new Callable<List<Food>>() {
      @Override
      public List<Food> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "foodName");
          final int _cursorIndexOfFoodKcal = CursorUtil.getColumnIndexOrThrow(_cursor, "foodKcal");
          final int _cursorIndexOfFoodCarbohydrates = CursorUtil.getColumnIndexOrThrow(_cursor, "foodCarbohydrates");
          final int _cursorIndexOfFoodProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "foodProtein");
          final int _cursorIndexOfFoodFat = CursorUtil.getColumnIndexOrThrow(_cursor, "foodFat");
          final int _cursorIndexOfFoodLike = CursorUtil.getColumnIndexOrThrow(_cursor, "foodLike");
          final List<Food> _result = new ArrayList<Food>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Food _item;
            final String _tmpFoodName;
            if (_cursor.isNull(_cursorIndexOfFoodName)) {
              _tmpFoodName = null;
            } else {
              _tmpFoodName = _cursor.getString(_cursorIndexOfFoodName);
            }
            final float _tmpFoodKcal;
            _tmpFoodKcal = _cursor.getFloat(_cursorIndexOfFoodKcal);
            final float _tmpFoodCarbohydrates;
            _tmpFoodCarbohydrates = _cursor.getFloat(_cursorIndexOfFoodCarbohydrates);
            final float _tmpFoodProtein;
            _tmpFoodProtein = _cursor.getFloat(_cursorIndexOfFoodProtein);
            final float _tmpFoodFat;
            _tmpFoodFat = _cursor.getFloat(_cursorIndexOfFoodFat);
            final int _tmpFoodLike;
            _tmpFoodLike = _cursor.getInt(_cursorIndexOfFoodLike);
            _item = new Food(_tmpFoodName,_tmpFoodKcal,_tmpFoodCarbohydrates,_tmpFoodProtein,_tmpFoodFat,_tmpFoodLike);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            _item.setFoodIndex(_tmpFoodIndex);
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
  public LiveData<List<Food>> getFoodByName(final String foodName) {
    final String _sql = "SELECT * FROM food WHERE foodName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (foodName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, foodName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"food"}, false, new Callable<List<Food>>() {
      @Override
      public List<Food> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFoodIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "foodIndex");
          final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "foodName");
          final int _cursorIndexOfFoodKcal = CursorUtil.getColumnIndexOrThrow(_cursor, "foodKcal");
          final int _cursorIndexOfFoodCarbohydrates = CursorUtil.getColumnIndexOrThrow(_cursor, "foodCarbohydrates");
          final int _cursorIndexOfFoodProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "foodProtein");
          final int _cursorIndexOfFoodFat = CursorUtil.getColumnIndexOrThrow(_cursor, "foodFat");
          final int _cursorIndexOfFoodLike = CursorUtil.getColumnIndexOrThrow(_cursor, "foodLike");
          final List<Food> _result = new ArrayList<Food>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Food _item;
            final String _tmpFoodName;
            if (_cursor.isNull(_cursorIndexOfFoodName)) {
              _tmpFoodName = null;
            } else {
              _tmpFoodName = _cursor.getString(_cursorIndexOfFoodName);
            }
            final float _tmpFoodKcal;
            _tmpFoodKcal = _cursor.getFloat(_cursorIndexOfFoodKcal);
            final float _tmpFoodCarbohydrates;
            _tmpFoodCarbohydrates = _cursor.getFloat(_cursorIndexOfFoodCarbohydrates);
            final float _tmpFoodProtein;
            _tmpFoodProtein = _cursor.getFloat(_cursorIndexOfFoodProtein);
            final float _tmpFoodFat;
            _tmpFoodFat = _cursor.getFloat(_cursorIndexOfFoodFat);
            final int _tmpFoodLike;
            _tmpFoodLike = _cursor.getInt(_cursorIndexOfFoodLike);
            _item = new Food(_tmpFoodName,_tmpFoodKcal,_tmpFoodCarbohydrates,_tmpFoodProtein,_tmpFoodFat,_tmpFoodLike);
            final int _tmpFoodIndex;
            _tmpFoodIndex = _cursor.getInt(_cursorIndexOfFoodIndex);
            _item.setFoodIndex(_tmpFoodIndex);
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
