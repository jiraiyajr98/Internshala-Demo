package com.example.interntest.utils;

import android.content.Context;
import android.database.Cursor;

import com.example.interntest.database.AllWorkshop;
import com.example.interntest.database.UsersWorkshop;
import com.example.interntest.lists.AllWorkshopListObject;
import com.example.interntest.lists.MyWorkshopListObject;

import java.util.ArrayList;

public class TableUtils {

    public static void workshopDataInsertion(Context context, String name, String details)
    {

        AllWorkshop shortCutTable = new AllWorkshop(context);

        shortCutTable.addsqlData(name,details);

    }



    public static ArrayList<AllWorkshopListObject> getWorkshopTableData(Context context){

        Cursor update_cursor;
        ArrayList<AllWorkshopListObject> list = new ArrayList<>();
        AllWorkshop shortcutTables = new AllWorkshop(context);
        shortcutTables.getReadableDatabase();


        if (!shortcutTables.isEmpty())
        {
            update_cursor = shortcutTables.getAllData();
            if (update_cursor != null) {

                update_cursor.moveToFirst();
                do {

                    list.add(new AllWorkshopListObject(update_cursor.getString(1),update_cursor.getString(2)));
                }
                while (update_cursor.moveToNext());
                update_cursor.close();
            }
        }

        return list;

    }

    public static void myWorkshopDataInsertion(Context context, String name)
    {

        UsersWorkshop usersWorkshop = new UsersWorkshop(context);

        usersWorkshop.addsqlData(name);

    }



    public static ArrayList<MyWorkshopListObject> getMyWorkshopTableData(Context context){

        Cursor update_cursor;
        ArrayList<MyWorkshopListObject> list = new ArrayList<>();
        UsersWorkshop shortcutTables = new UsersWorkshop(context);
        shortcutTables.getReadableDatabase();


        if (!shortcutTables.isEmpty())
        {
            update_cursor = shortcutTables.getAllData();
            if (update_cursor != null) {

                update_cursor.moveToFirst();
                do {

                    list.add(new MyWorkshopListObject(update_cursor.getString(1)));
                }
                while (update_cursor.moveToNext());
                update_cursor.close();
            }
        }

        return list;

    }

    public static void deleteTableShortcut(Context context)
    {
        UsersWorkshop workshopTables = new UsersWorkshop(context);

        workshopTables.del_table();
    }

}
