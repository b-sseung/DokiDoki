package com.dokidoki;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class Cherry_Database_Update {

    static HashMap<Integer, Cherry2_Collection_Item> items1 = new HashMap<>();
    static HashMap<Integer, Cherry3_Episode_Item> items2 = new HashMap<>();

    public static void updateTable1(){
        loadTable1();

        Log.d("1818", "items1 : " + items1.size());

        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        int mid = 6;
        for (int i = 1; i < mid; i++){
            if (items1.get(i).getImageId() != R.drawable.cherry002_collection_lock_image) continue;

            String num = (i < 10) ? "00" + i : (i < 100) ? "0" + i : "" + i;
            int backgroundId = UseAll.mainContext.getResources().getIdentifier("adachi_collection" + num + "_background", "drawable", UseAll.mainContext.getPackageName());
            int textId = UseAll.mainContext.getResources().getIdentifier("adachi_collection" + num + "_text", "drawable", UseAll.mainContext.getPackageName());

            Log.d("1818", "id : " + backgroundId + ", " + textId);

            String sql = "UPDATE " + Cherry_Database.table1 + " SET "
                    + " background = " + backgroundId + ", "
                    + " text = " + textId  + " "
                    + " WHERE charactor = 'adachi' " + " and number = " + i;

            database.execSQL(sql);
        }

        for (int i = items1.size() + 1; i < 10; i++){

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
    }


    public static void updateAdachiTable2(){
        loadTable2("adachi");

        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        for (int i = 1; i < 4; i++){

            if (items2.get(i).getBackground() != R.drawable.cherry003_adachi_episode_comingsoon) continue;

            int backgroundId = UseAll.mainContext.getResources().getIdentifier("adachi" + "_episode" + i + "_background", "drawable", UseAll.mainContext.getPackageName());
            int thumnailId = UseAll.mainContext.getResources().getIdentifier("adachi" + "_episode" + i + "_thumnail", "drawable", UseAll.mainContext.getPackageName());
            int textId = UseAll.mainContext.getResources().getIdentifier("adachi" + "_episode" + i + "_text", "drawable", UseAll.mainContext.getPackageName());
            int storyId = UseAll.mainContext.getResources().getIdentifier("adachi" + "_episode" + i + "_text_story", "drawable", UseAll.mainContext.getPackageName());

            Log.d("tlqkf", backgroundId + ", " + thumnailId + ", " + textId + ", " + storyId);

            String sql = "UPDATE " + Cherry_Database.table2 + " SET "
                + " background = " + backgroundId + ", "
                + " thumnail = " + thumnailId + ", "
                + " text = " + textId  + ", "
                + " story = " + storyId + " "
                + " WHERE charactor = 'adachi' " + " and number = " + i;

            database.execSQL(sql);
        }
    }

    public static void loadTable1(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        Log.d("1818", "call");
        String sql = "select _id " + " , charactor " + " , number " + " , isLock " + " , background " + " , text "
                + "from " + Cherry_Database.table1 + " " + " WHERE charactor = '" + "adachi" + "' "
                + "order by number asc";

        Log.d("database", sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0){
            Cherry_Database.addTable1Data(UseAll.mainContext);
        }

        for (int i = 0; i < recordCound; i++){
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String charactor = cursor.getString(1);
            int number = cursor.getInt(2);
            String isLock = cursor.getString(3);
            int background = cursor.getInt(4);
            int text = cursor.getInt(5);

            Log.d("1818", id + ", " + charactor + ", " + number + ", " + isLock + ", " + background + ", " + text);

            items1.put(number, new Cherry2_Collection_Item(id, charactor, number, isLock, background, text));
        }
    }

    public static void loadTable2(String name){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "select _id " + " , charactor " + " , number " + " , isLock " + " , background " + " , thumnail " + " , text " + " , story "
                + "from " + Cherry_Database.table2 + " WHERE charactor = '" + name + "' "
                + "order by number asc";

        Log.d("database", sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0){
            Cherry_Database.addEpisode(UseAll.mainContext, name);
        }

        for (int i = 0; i < recordCound; i++){
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String charactor = cursor.getString(1);
            int number = cursor.getInt(2);
            String isLock = cursor.getString(3);
            int background = cursor.getInt(4);
            int thumnail = cursor.getInt(5);
            int text = cursor.getInt(6);
            int story = cursor.getInt(7);

            Log.d("tlqkf", "episode : " + isLock + ", " + background + ", " + thumnail + ", " + text + ", " + story);

            items2.put(number, new Cherry3_Episode_Item(id, charactor, number, isLock, background, thumnail, text, story));
        }
    }
}
