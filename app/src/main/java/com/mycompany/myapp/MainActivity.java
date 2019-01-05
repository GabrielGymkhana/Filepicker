package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import com.java.library.Library.Filepicker.model.DialogProperties;
import com.java.library.Library.Filepicker.model.DialogConfigs;
import com.java.library.Library.Filepicker.view.FilePickerDialog;
import com.java.library.Library.Filepicker.controller.DialogSelectionListener;
import android.widget.*;
import com.mycompany.myapp.R;
import android.view.*;

public class MainActivity extends Activity 
{
	TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		txt = (TextView)findViewById(R.id.txt);
		txt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DialogProperties properties = new DialogProperties();
				properties.selection_mode = DialogConfigs.SINGLE_MODE;
				properties.selection_type = DialogConfigs.FILE_SELECT;
				properties.root = new java.io.File(DialogConfigs.DEFAULT_DIR);
				properties.error_dir = new java.io.File(DialogConfigs.DEFAULT_DIR);
				properties.offset = new java.io.File(DialogConfigs.DEFAULT_DIR);
				properties.extensions = null;
				final FilePickerDialog dialog = new FilePickerDialog(MainActivity.this,properties);
				dialog.setTitle("Select a File");
				dialog.setDialogSelectionListener(new DialogSelectionListener() {
						@Override
						public void onSelectedFilePaths(String[] files) {
							//files is the array of the paths of files selected by the Application User.
							Toast.makeText(getApplicationContext(),(files[0]), Toast.LENGTH_SHORT).show();
						}
					});
				dialog.show();
			}
		});
    }
}
