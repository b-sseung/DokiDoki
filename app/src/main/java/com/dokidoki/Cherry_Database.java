package com.dokidoki;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Cherry_Database {
    private static final String tag = "CherryDatabase";

    private static Cherry_Database database;
    public static String table1 = "COLLECTION";
    public static String table2 = "PLAY";
    public static String table3 = "LEVEL";
    public static String table4 = "IDPW";
    public static String table5 = "LOGIN";

    public static int database_version = 1;

    public static DatabaseHelper dbHelper;
    public static SQLiteDatabase db;
    public static Context context;

    private Cherry_Database(Context context){
        this.context = context;
    }

    public static void print(String text){
        Log.d(tag, text);
    }

    public static Cherry_Database getInstance(Context context){
        if (database == null){
            print("database null");
            database = new Cherry_Database(context);
        }

        return database;
    }

    public void create(){
        dbHelper.onCreate(db);
    }

    public static boolean open(){
        print("opening database [" + UseAll.dbName + "].");

        dbHelper = new DatabaseHelper(context, database_version);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    public void close(){
        print("closing database [" + UseAll.dbName + "].");

        db.close();
        database = null;
    }

    public Cursor rawQuery(String SQL){
        print("\nexecuteQuery called.\n");

        Cursor cursor = null;

        try{
            cursor = db.rawQuery(SQL, null);
            print("cursor count : " + cursor.getCount());
        } catch (Exception e){
            print("Exception in executeQuery : " + e);
        }

        return cursor;
    }

    public boolean execSQL(String SQL){
        print("\nexecute called.\n");

        try{
            print("SQL : " + SQL);
            db.execSQL(SQL);
        } catch (Exception e){
            print("Exception in executeQuery : " + e);
            return false;
        }

        return true;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {


        public DatabaseHelper(Context context, int version){
            super(context, UseAll.dbName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            print("creating database [" + UseAll.dbName + "].");

            print("creating table [" + table1 + "].");

            String DROP_SQL1 = "drop table if exists " + table1;

            try{
                db.execSQL(DROP_SQL1);
            } catch (Exception e) {print("Exception in DROP_SQL1 : " + e);}

            String CREATE_SQL1 = "create table " + table1 + "("
                    + " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + " charactor TEXT DEFAULT '', "
                    + " number INTEGER DEFAULT '', "
                    + " isLock TEXT DEFAULT '', "
                    + " background INTEGER DEFAULT '', "
                    + " text INTEGER DEFAULT '' "
                    + ")";

            try {
                db.execSQL(CREATE_SQL1);
            } catch (Exception e){print("Exception in CREATE_SQL1 : " + e);}

            String CREATE_INDEX_SQL1 = "create index " + table1 + "_IDX ON " + table1 + "("
                    + "CREATE_DATE" + ")";

            try {
                db.execSQL(CREATE_INDEX_SQL1);
            } catch (Exception e) {
                print("Exception in CREATE_INDEX_SQL1 : " + e);
            }


            print("creating table [" + table2 + "].");

            String DROP_SQL2 = "drop table if exists " + table2;

            try{
                db.execSQL(DROP_SQL2);
            } catch (Exception e) {print("Exception in DROP_SQL2 : " + e);}

            String CREATE_SQL2 = "create table " + table2 + "("
                    + " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + " charactor TEXT DEFAULT '', "
                    + " number INTEGER DEFAULT '', "
                    + " isLock TEXT DEFAULT '', "
                    + " background INTEGER DEFAULT -1, "  //백그라운드
                    + " thumnail INTEGER DEFAULT -1, "  //썸네일
                    + " text INTEGER DEFAULT -1, "  //에피소드1, 2.... 이미지
                    + " story INTEGER DEFAULT -1 "  //에피소드 설명
                    + ")";

            try {
                db.execSQL(CREATE_SQL2);
            } catch (Exception e){ print("Exception in CREATE_SQL2 : " + e); }

            String CREATE_INDEX_SQL2 = "create index " + table2 + "_IDX ON " + table2 + "("
                    + "CREATE_DATE" + ")";

            try {
                db.execSQL(CREATE_INDEX_SQL2);
            } catch (Exception e) { print("Exception in CREATE_INDEX_SQL2 : " + e); }


            print("creating table [" + table3 + "].");

            String DROP_SQL3 = "drop table if exists " + table3;

            try{
                db.execSQL(DROP_SQL3);
            } catch (Exception e) {print("Exception in DROP_SQL3 : " + e);}

            String CREATE_SQL3 = "create table " + table3 + "("
                    + " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + " charactor TEXT DEFAULT '', "
                    + " level INTEGER DEFAULT '' "
                    + ")";

            try {
                db.execSQL(CREATE_SQL3);
            } catch (Exception e){print("Exception in CREATE_SQL3 : " + e);}

            String CREATE_INDEX_SQL3 = "create index " + table3 + "_IDX ON " + table3 + "("
                    + "CREATE_DATE" + ")";

            try {
                db.execSQL(CREATE_INDEX_SQL3);
            } catch (Exception e) {
                print("Exception in CREATE_INDEX_SQL3 : " + e);
            }


            print("creating table [" + table4 + "].");

            String DROP_SQL4 = "drop table if exists " + table4;

            try{
                db.execSQL(DROP_SQL4);
            } catch (Exception e) {print("Exception in DROP_SQL4 : " + e);}

            String CREATE_SQL4 = "create table " + table4 + "("
                    + " _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + " login_id TEXT DEFAULT '', "
                    + " login_password TEXT DEFAULT '' "
                    + ")";

            try {
                db.execSQL(CREATE_SQL4);
            } catch (Exception e){print("Exception in CREATE_SQL4 : " + e);}

            String CREATE_INDEX_SQL4 = "create index " + table4 + "_IDX ON " + table4 + "("
                    + "CREATE_DATE" + ")";

            try {
                db.execSQL(CREATE_INDEX_SQL4);
            } catch (Exception e) {
                print("Exception in CREATE_INDEX_SQL4 : " + e);
            }


            print("creating table [" + table5 + "].");

            String DROP_SQL5 = "drop table if exists " + table5;

            try{
                db.execSQL(DROP_SQL5);
            } catch (Exception e) {print("Exception in DROP_SQL5 : " + e);}

            String CREATE_SQL5 = "create table " + table5 + "("
                    + " number INTEGER DEFAULT '', "
                    + " login_id TEXT DEFAULT '', "
                    + " login_password TEXT DEFAULT '' "
                    + ")";

            try {
                db.execSQL(CREATE_SQL5);
            } catch (Exception e){print("Exception in CREATE_SQL5 : " + e);}

            String CREATE_INDEX_SQL5 = "create index " + table5 + "_IDX ON " + table5 + "("
                    + "CREATE_DATE" + ")";

            try {
                db.execSQL(CREATE_INDEX_SQL5);
            } catch (Exception e) {
                print("Exception in CREATE_INDEX_SQL5 : " + e);
            }
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);

            print("opened database [" + UseAll.dbName + "].");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            print("upgrade database from version " + oldVersion + " to " + newVersion + ".");
            UseAll.oldVersion = oldVersion;
        }
    }

    public static void addTable1Data(Context context){

        Cherry_Database database = Cherry_Database.getInstance(context);

        int mid = 6;
        for (int i = 1; i < mid; i++){
            String num = (i < 10) ? "00" + i : (i < 100) ? "0" + i : "" + i;
            int backgroundId = context.getResources().getIdentifier("adachi_collection" + num + "_background", "drawable", context.getPackageName());
            int textId = context.getResources().getIdentifier("adachi_collection" + num + "_text", "drawable", context.getPackageName());

            Log.d("1818", "id : " + backgroundId + ", " + textId);

            String sql = "insert into " + Cherry_Database.table1 +
                    "(charactor, number, isLock, background, text) values (" +
                    "'" + "adachi" + "', " +
                    "'" + i + "', " +
                    "'" + "true" + "', " +
                    "'" + backgroundId + "', " +
                    "'" + textId + "')";

            database.execSQL(sql);
        }

        for (int i = mid; i < 6; i++){

            int image = R.drawable.cherry002_collection_lock_image;

            String sql = "insert into " + Cherry_Database.table1 +
                    "(charactor, number, isLock, background, text) values (" +
                    "'" + "adachi" + "', " +
                    "'" + i + "', " +
                    "'" + "true" + "', " +
                    "'" + image + "', " +
                    "'" + image + "')";

            database.execSQL(sql);
        }

        int[] comingsoon_collection_image = new int[]{R.drawable.cherry002_comingsoon_c, R.drawable.cherry002_comingsoon_o,
                R.drawable.cherry002_comingsoon_m, R.drawable.cherry002_comingsoon_i,
                R.drawable.cherry002_comingsoon_n, R.drawable.cherry002_comingsoon_g,
                R.drawable.cherry002_comingsoon_s, R.drawable.cherry002_comingsoon_o,
                R.drawable.cherry002_comingsoon_o, R.drawable.cherry002_comingsoon_n,
                R.drawable.cherry002_comingsoon_last};

        for (int j = 0; j < 2; j++){

            String name = (j == 0) ? "kurosawa" : "chuge";

            for (int i = 0; i < comingsoon_collection_image.length; i++){
                String sql = "insert into " + Cherry_Database.table1 +
                        "(charactor, number, isLock, background, text) values (" +
                        "'" + name + "', " +
                        "'" + i + "', " +
                        "'" + "false" + "', " +
                        "'" + comingsoon_collection_image[i] + "', " +
                        "'" + comingsoon_collection_image[i] + "')";

                database.execSQL(sql);
            }
        }
    }

    public static void addEpisode(Context context, String name){
        Cherry_Database database = Cherry_Database.getInstance(context);

        int mid = (name.equals("adachi")) ? 4 : (name.equals("kurosawa")) ? 2 : 2;
        int end = (name.equals("adachi")) ? 24 : (name.equals("kurosawa")) ? 2 : 2;

        Log.d("tlqkf", name);

        for (int i = 1; i < mid; i++){
            int backgroundId = context.getResources().getIdentifier(name + "_episode" + i + "_background", "drawable", context.getPackageName());
            int thumnailId = context.getResources().getIdentifier(name + "_episode" + i + "_thumnail", "drawable", context.getPackageName());
            int textId = context.getResources().getIdentifier(name + "_episode" + i + "_text", "drawable", context.getPackageName());
            int storyId = context.getResources().getIdentifier(name + "_episode" + i + "_text_story", "drawable", context.getPackageName());

            Log.d("tlqkf", backgroundId + ", " + thumnailId + ", " + textId + ", " + storyId);

            String value = (i == 1) ? "false" : "true";

            String sql = "insert into " + Cherry_Database.table2 +
                    "(charactor, number, isLock, background, thumnail, text, story) values (" +
                    "'" + name + "', " +
                    "'" + i + "', " +
                    "'" + value + "', " +
                    "'" + backgroundId + "', " +
                    "'" + thumnailId + "', " +
                    "'" + textId + "', " +
                    "'" + storyId + "')";

            database.execSQL(sql);
        }

        for (int i = mid; i < end; i++){

            int image = R.drawable.cherry003_adachi_episode_comingsoon;

            String sql = "insert into " + Cherry_Database.table2 +
                    "(charactor, number, isLock, background, thumnail, text, story) values (" +
                    "'" + name + "', " +
                    "'" + i + "', " +
                    "'" + "true" + "', " +
                    "'', " +
                    "'" + image + "', " +
                    "'', " +
                    "'')";

            database.execSQL(sql);
        }
    }

    public static void addLevel(Context context, String name){
        Cherry_Database database = Cherry_Database.getInstance(context);

        String sql = "insert into " + Cherry_Database.table3 +
                "(charactor, level) values (" +
                "'" + name + "', " +
                "'" + 0 + "')";

        database.execSQL(sql);
    }

    public static void addIdPassWord(Context context){
        Cherry_Database database = Cherry_Database.getInstance(context);

        String[] id = new String[]{"user", "@Mul_look", "@buzzi_cherry", "chingnu_ch", "@zr_jung", "@cherrys1005",
                "@cherrysub13","@kuroada1028","@GD_chmh","@RIBI_0113","@Oo_z0ne",
                "@Mlight_Cherry","@chancecherry_","@KURODACHIQ","@cherry_oh2","@649758i",
                "@ui_cherry66","@hoshino_cherry","@MX_MHWIFE","@machi_peach","@cchhii97",
                "@_momem","@dmsgo5217","@shy_cm","@natzunouta","@momento_tiff",
                "@5_raena","@pimang_M","@yul_cherry_S2","@crycryicry","@cherry_m_col",
                "@jjerrymagic","@kkimikk_","@cherry_crazy_","@redo_red","@realpkboss",
                "@죧커뽑기","@125_suu","@gurbi_cherry","@A.drenaline","@kimandj4",
                "@yesjustaplant","@droolovercherry","@___low_deep","@rowdedow","@kua_cherry",
                "@rippanamon","@tonia455","@cherryS2rider","@luv_optimusH","@CHERRY__PUNCH_",
                "@drnyong","@banzoruuga","@cherry_goro","@aks_saranghae","@_cherri_maho",
                "@geniusyo11","@chouchou1124","@KJH_22_","@softsilken_tofu","@JHS631526",
                "@yomyom_good_","@cube_hm","@puke111","@CHERRYSJ8","@lucynoemma",
                "@jkjmrj","@cherry_maho__","@milktea_mcak","@1638OMO","@Rebecc4choi",
                "@CR_MG_","@rmfdktnf","@0704_machidaaa","@jjerry_bear","@chez_machi",
                "@snnaxxna","@OZZ_679","@d3oiiiii","@machida_sukida","@hory_maho",
                "@Endis_liens","@jenni_malec","@nku87","@bdkdltmzmfla","@accountfordrama",
                "@RksEkQldiro","@hanako69666","@Y_tomytomy","@fullm00n_cherry","@_morealbeat",
                "@3minramen","@wing_779_","@seeingseven7","@bani0617","@BJ29JB",
                "@We06162544","@nku87","@K_cherry_A","@cafemaho","@sb06130",
                "@organic1997","@syoubi1205"

        };
        String[] pw = new String[]{"1", "ysh0817###", "0214", "machikaso", "1562", "kasosalanghae",
                "828494","kuda1028","1223","0113","0603",
                "90947431","1009","0922","5252","0000",
                "uiuicherry66","qwertyuiop","5","1103","123002",
                "memmem","1234","shy","tit","0000",
                "0214","1212","0105","0301","0524",
                "0329","zxzx1234","1234","Cherry","2919",
                "죧커뽑기!","wltjsl90","1028","qwert1126","공주공주",
                "777","4750","112203","쿠로아다","0748",
                "cherrymaho","0735","체리마호","6889","1007",
                "7410","얌마","1205","0000","1002",
                "0000","ac1313","0613","softsilkentofu77","0000",
                "920915cu!!","cbcb","25809","0823","체리마호",
                "selki8824","1234","171926","1028","1",
                "0000","asdf123**","0704","0000","900704",
                "죽","679679","체리체리","맛치스키","1234",
                "0000","8109","wjddbs12","1212","azako",
                "0441","sin2ran","122838","전지원","1213",
                "0915","yeoning0119","772017161","sksekdp84","0000",
                "1005","wjddbs12","222222","0003","4804","knyou74","1111"
        };

        for (int i = 0; i < id.length; i++){
            String sql = "insert into " + Cherry_Database.table4 +
                    "(login_id, login_password) values (" +
                    "'" + id[i] + "', " +
                    "'" + pw[i] + "')";

            database.execSQL(sql);
        }
    }
}
