package com.cs60333.scho2.lab2_scho2;

import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by samcholo on 3/21/17.
 */

public class FloatingContextualMenu extends AppCompatActivity {
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMenuInflater = getMenuInflater();
        contextMenuInflater.inflate(R.menu.floating_contextual_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.womens) {
            // to be implemented later
        }

        else if (item_id == R.id.mens) {
            // Snackbar with Try Again action
        }

        else if (item_id == R.id.onCampus) {
            // Floating Contextual Menu with options
        }

        else if (item_id == R.id.offCampus) {
            // Floating Contextual Menu with options
        }
        return false;
    }
}