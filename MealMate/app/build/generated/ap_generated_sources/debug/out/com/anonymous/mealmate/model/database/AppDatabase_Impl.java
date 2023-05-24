package com.anonymous.mealmate.model.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.anonymous.mealmate.model.dao.FoodDao;
import com.anonymous.mealmate.model.dao.FoodDao_Impl;
import com.anonymous.mealmate.model.dao.MealDao;
import com.anonymous.mealmate.model.dao.MealDao_Impl;
import com.anonymous.mealmate.model.dao.UserDao;
import com.anonymous.mealmate.model.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile MealDao _mealDao;

  private volatile FoodDao _foodDao;

  private volatile UserDao _userDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `meal` (`mealIndex` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mealDate` TEXT, `mealCnt` INTEGER NOT NULL, `mealFoodAmount` INTEGER NOT NULL, `foodIndex` INTEGER NOT NULL, `checked` INTEGER NOT NULL, FOREIGN KEY(`foodIndex`) REFERENCES `food`(`foodIndex`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `food` (`foodIndex` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `foodName` TEXT, `foodKcal` REAL NOT NULL, `foodCarbohydrates` REAL NOT NULL, `foodProtein` REAL NOT NULL, `foodFat` REAL NOT NULL, `foodLike` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` INTEGER NOT NULL, `User_name` TEXT, `User_gender` INTEGER NOT NULL, `User_height` INTEGER NOT NULL, `User_weight` INTEGER NOT NULL, `User_activityRatio` INTEGER NOT NULL, `User_purpose` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '78d434280a2274d5dd7bef9714a26949')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `meal`");
        _db.execSQL("DROP TABLE IF EXISTS `food`");
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMeal = new HashMap<String, TableInfo.Column>(6);
        _columnsMeal.put("mealIndex", new TableInfo.Column("mealIndex", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("mealDate", new TableInfo.Column("mealDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("mealCnt", new TableInfo.Column("mealCnt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("mealFoodAmount", new TableInfo.Column("mealFoodAmount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("foodIndex", new TableInfo.Column("foodIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("checked", new TableInfo.Column("checked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeal = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMeal.add(new TableInfo.ForeignKey("food", "NO ACTION", "NO ACTION",Arrays.asList("foodIndex"), Arrays.asList("foodIndex")));
        final HashSet<TableInfo.Index> _indicesMeal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeal = new TableInfo("meal", _columnsMeal, _foreignKeysMeal, _indicesMeal);
        final TableInfo _existingMeal = TableInfo.read(_db, "meal");
        if (! _infoMeal.equals(_existingMeal)) {
          return new RoomOpenHelper.ValidationResult(false, "meal(com.anonymous.mealmate.model.entity.Meal).\n"
                  + " Expected:\n" + _infoMeal + "\n"
                  + " Found:\n" + _existingMeal);
        }
        final HashMap<String, TableInfo.Column> _columnsFood = new HashMap<String, TableInfo.Column>(7);
        _columnsFood.put("foodIndex", new TableInfo.Column("foodIndex", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodName", new TableInfo.Column("foodName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodKcal", new TableInfo.Column("foodKcal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodCarbohydrates", new TableInfo.Column("foodCarbohydrates", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodProtein", new TableInfo.Column("foodProtein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodFat", new TableInfo.Column("foodFat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("foodLike", new TableInfo.Column("foodLike", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFood = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFood = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFood = new TableInfo("food", _columnsFood, _foreignKeysFood, _indicesFood);
        final TableInfo _existingFood = TableInfo.read(_db, "food");
        if (! _infoFood.equals(_existingFood)) {
          return new RoomOpenHelper.ValidationResult(false, "food(com.anonymous.mealmate.model.entity.Food).\n"
                  + " Expected:\n" + _infoFood + "\n"
                  + " Found:\n" + _existingFood);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(7);
        _columnsUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_name", new TableInfo.Column("User_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_gender", new TableInfo.Column("User_gender", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_height", new TableInfo.Column("User_height", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_weight", new TableInfo.Column("User_weight", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_activityRatio", new TableInfo.Column("User_activityRatio", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("User_purpose", new TableInfo.Column("User_purpose", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.anonymous.mealmate.model.entity.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "78d434280a2274d5dd7bef9714a26949", "27b1593f39c22baa612ff4bedf5d10d2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "meal","food","user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `meal`");
      _db.execSQL("DELETE FROM `food`");
      _db.execSQL("DELETE FROM `user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MealDao.class, MealDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FoodDao.class, FoodDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MealDao mealDao() {
    if (_mealDao != null) {
      return _mealDao;
    } else {
      synchronized(this) {
        if(_mealDao == null) {
          _mealDao = new MealDao_Impl(this);
        }
        return _mealDao;
      }
    }
  }

  @Override
  public FoodDao foodDao() {
    if (_foodDao != null) {
      return _foodDao;
    } else {
      synchronized(this) {
        if(_foodDao == null) {
          _foodDao = new FoodDao_Impl(this);
        }
        return _foodDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
