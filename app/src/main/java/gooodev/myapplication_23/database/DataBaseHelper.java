package gooodev.myapplication_23.database;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "contact.db";
    public static final int DATABASE_VERSION = 1;
    Context context;

    static
    {
        if (!DataBaseHelper.class.desiredAssertionStatus());
        for (boolean bool = true; ; bool = false)
        {
            $assertionsDisabled = bool;
            return;
        }
    }

    public DataBaseHelper(Context paramContext)
    {
        super(paramContext, "contact.db", null, 1);
        this.context = paramContext;
    }

    private void createCatgeoryType(SQLiteDatabase paramSQLiteDatabase)
    {
        String[] arrayOfString = this.context.getResources().getStringArray(2131558401);
        int i = arrayOfString.length;
        for (int j = 0; ; j++)
        {
            if (j >= i)
                return;
            String str = arrayOfString[j];
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("category_type", str);
            paramSQLiteDatabase.insert("category_type", null, localContentValues);
        }
    }

    private void createDefaults(SQLiteDatabase paramSQLiteDatabase)
    {
        String[] arrayOfString = this.context.getResources().getStringArray(2131558400);
        int i = arrayOfString.length;
        for (int j = 0; ; j++)
        {
            if (j >= i)
                return;
            String str = arrayOfString[j];
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("country_name", str);
            paramSQLiteDatabase.insert("country", null, localContentValues);
        }
    }

    // ERROR //
    public long insert(Context paramContext, String paramString, ContentValues paramContentValues)
    {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 5
        //   6: ldc2_w 74
        //   9: lstore 6
        //   11: new 2	mobilemerit/com/contactmanagement/database/DataBaseHelper
        //   14: dup
        //   15: aload_1
        //   16: invokespecial 77	mobilemerit/com/contactmanagement/database/DataBaseHelper:<init>	(Landroid/content/Context;)V
        //   19: astore 8
        //   21: aload 8
        //   23: invokevirtual 81	mobilemerit/com/contactmanagement/database/DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   26: astore 5
        //   28: aload 5
        //   30: ifnull +18 -> 48
        //   33: aload 5
        //   35: aload_2
        //   36: aconst_null
        //   37: aload_3
        //   38: iconst_2
        //   39: invokevirtual 85	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
        //   42: lstore 11
        //   44: lload 11
        //   46: lstore 6
        //   48: aload 8
        //   50: ifnull +8 -> 58
        //   53: aload 8
        //   55: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   58: aload 5
        //   60: ifnull +8 -> 68
        //   63: aload 5
        //   65: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   68: lload 6
        //   70: lreturn
        //   71: astore 9
        //   73: aload 9
        //   75: invokevirtual 92	java/lang/Exception:printStackTrace	()V
        //   78: aload 4
        //   80: ifnull +8 -> 88
        //   83: aload 4
        //   85: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   88: aload 5
        //   90: ifnull +8 -> 98
        //   93: aload 5
        //   95: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   98: aload 4
        //   100: ifnull +8 -> 108
        //   103: aload 4
        //   105: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   108: aload 5
        //   110: ifnull -42 -> 68
        //   113: aload 5
        //   115: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   118: lload 6
        //   120: lreturn
        //   121: astore 10
        //   123: aload 4
        //   125: ifnull +8 -> 133
        //   128: aload 4
        //   130: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   133: aload 5
        //   135: ifnull +8 -> 143
        //   138: aload 5
        //   140: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   143: aload 10
        //   145: athrow
        //   146: astore 10
        //   148: aload 8
        //   150: astore 4
        //   152: goto -29 -> 123
        //   155: astore 9
        //   157: aload 8
        //   159: astore 4
        //   161: goto -88 -> 73
        //
        // Exception table:
        //   from	to	target	type
        //   11	21	71	java/lang/Exception
        //   11	21	121	finally
        //   73	78	121	finally
        //   83	88	121	finally
        //   93	98	121	finally
        //   21	28	146	finally
        //   33	44	146	finally
        //   21	28	155	java/lang/Exception
        //   33	44	155	java/lang/Exception
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
        paramSQLiteDatabase.execSQL(" CREATE TABLE contact_details(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, photo_url TEXT, mobile TEXT, landline TEXT, address TEXT, state TEXT, country TEXT, city TEXT, company_name TEXT, category_type TEXT, website TEXT )");
        paramSQLiteDatabase.execSQL(" CREATE TABLE country(country_id INTEGER PRIMARY KEY AUTOINCREMENT, country_name TEXT )");
        paramSQLiteDatabase.execSQL(" CREATE TABLE state(state_id INTEGER PRIMARY KEY AUTOINCREMENT, country_id TEXT, state_name TEXT )");
        paramSQLiteDatabase.execSQL(" CREATE TABLE city(city_id INTEGER PRIMARY KEY AUTOINCREMENT, country_id TEXT, state_id TEXT, city_name TEXT )");
        paramSQLiteDatabase.execSQL(" CREATE TABLE category_type(cat_id INTEGER PRIMARY KEY AUTOINCREMENT, category_type TEXT )");
        createDefaults(paramSQLiteDatabase);
        createCatgeoryType(paramSQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }

    // ERROR //
    public long update(Context paramContext, String paramString1, ContentValues paramContentValues, String paramString2)
    {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore 6
        //   6: lconst_0
        //   7: lstore 7
        //   9: new 2	mobilemerit/com/contactmanagement/database/DataBaseHelper
        //   12: dup
        //   13: aload_1
        //   14: invokespecial 77	mobilemerit/com/contactmanagement/database/DataBaseHelper:<init>	(Landroid/content/Context;)V
        //   17: astore 9
        //   19: aload 9
        //   21: invokevirtual 81	mobilemerit/com/contactmanagement/database/DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   24: astore 6
        //   26: aload 6
        //   28: aload_2
        //   29: aload_3
        //   30: new 117	java/lang/StringBuilder
        //   33: dup
        //   34: ldc 119
        //   36: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   39: aload 4
        //   41: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   44: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   47: aconst_null
        //   48: invokevirtual 132	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   51: istore 13
        //   53: iload 13
        //   55: i2l
        //   56: lstore 7
        //   58: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   61: ifne +190 -> 251
        //   64: aload 9
        //   66: ifnonnull +185 -> 251
        //   69: new 134	java/lang/AssertionError
        //   72: dup
        //   73: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   76: athrow
        //   77: astore 10
        //   79: aload 10
        //   81: invokevirtual 92	java/lang/Exception:printStackTrace	()V
        //   84: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   87: ifne +37 -> 124
        //   90: aload 5
        //   92: ifnonnull +32 -> 124
        //   95: new 134	java/lang/AssertionError
        //   98: dup
        //   99: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   102: athrow
        //   103: astore 11
        //   105: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   108: ifne +111 -> 219
        //   111: aload 5
        //   113: ifnonnull +106 -> 219
        //   116: new 134	java/lang/AssertionError
        //   119: dup
        //   120: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   123: athrow
        //   124: aload 5
        //   126: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   129: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   132: ifne +16 -> 148
        //   135: aload 6
        //   137: ifnonnull +11 -> 148
        //   140: new 134	java/lang/AssertionError
        //   143: dup
        //   144: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   147: athrow
        //   148: aload 6
        //   150: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   153: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   156: ifne +16 -> 172
        //   159: aload 5
        //   161: ifnonnull +11 -> 172
        //   164: new 134	java/lang/AssertionError
        //   167: dup
        //   168: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   171: athrow
        //   172: aload 5
        //   174: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   177: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   180: ifne +16 -> 196
        //   183: aload 6
        //   185: ifnonnull +11 -> 196
        //   188: new 134	java/lang/AssertionError
        //   191: dup
        //   192: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   195: athrow
        //   196: aload 6
        //   198: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   201: lload 7
        //   203: lconst_0
        //   204: lcmp
        //   205: ifle +11 -> 216
        //   208: ldc 137
        //   210: ldc 139
        //   212: invokestatic 145	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   215: pop
        //   216: lload 7
        //   218: lreturn
        //   219: aload 5
        //   221: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   224: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   227: ifne +16 -> 243
        //   230: aload 6
        //   232: ifnonnull +11 -> 243
        //   235: new 134	java/lang/AssertionError
        //   238: dup
        //   239: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   242: athrow
        //   243: aload 6
        //   245: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   248: aload 11
        //   250: athrow
        //   251: aload 9
        //   253: invokevirtual 88	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   256: getstatic 26	mobilemerit/com/contactmanagement/database/DataBaseHelper:$assertionsDisabled	Z
        //   259: ifne +16 -> 275
        //   262: aload 6
        //   264: ifnonnull +11 -> 275
        //   267: new 134	java/lang/AssertionError
        //   270: dup
        //   271: invokespecial 135	java/lang/AssertionError:<init>	()V
        //   274: athrow
        //   275: aload 6
        //   277: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
        //   280: goto -79 -> 201
        //   283: astore 11
        //   285: aload 9
        //   287: astore 5
        //   289: goto -184 -> 105
        //   292: astore 10
        //   294: aload 9
        //   296: astore 5
        //   298: goto -219 -> 79
        //
        // Exception table:
        //   from	to	target	type
        //   9	19	77	java/lang/Exception
        //   9	19	103	finally
        //   79	90	103	finally
        //   95	103	103	finally
        //   124	135	103	finally
        //   140	148	103	finally
        //   148	153	103	finally
        //   19	53	283	finally
        //   19	53	292	java/lang/Exception
    }
}