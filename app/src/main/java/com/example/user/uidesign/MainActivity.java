package com.example.user.uidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.MenuSheetView;

public class MainActivity extends AppCompatActivity {
    protected BottomSheetLayout bottomSheetLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheetLayout.setPeekOnDismiss(true);
        findViewById(R.id.list_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenuSheet(MenuSheetView.MenuType.LIST);
            }
        });

        findViewById(R.id.grid_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenuSheet(MenuSheetView.MenuType.GRID);
            }
        });
    }






    private void showMenuSheet(final MenuSheetView.MenuType menuType) {
        MenuSheetView menuSheetView =
                new MenuSheetView(MainActivity.this, menuType, "Create...", new MenuSheetView.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        if (bottomSheetLayout.isSheetShowing()) {
                            bottomSheetLayout.dismissSheet();
                        }
//                        if (item.getItemId() == R.id.reopen) {
//                            showMenuSheet(menuType == MenuSheetView.MenuType.LIST ? MenuSheetView.MenuType.GRID : MenuSheetView.MenuType.LIST);
//                        }
                        return true;
                    }
                });
        menuSheetView.inflateMenu(R.menu.create);
        bottomSheetLayout.showWithSheetView(menuSheetView);
    }
}
