package com.neelanjana.benchmarkalgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;import android.app.Activity;
    import android.content.Intent;
    import android.database.Cursor;
    import android.net.Uri;
    import android.os.Bundle;
    import android.provider.ContactsContract;
    import android.provider.Contacts.People;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.TextView;

    public class ContactPickerActivity extends AppCompatActivity implements OnClickListener{
        private Button btnRetrive;
        private final int PICK = 1;
        private TextView tvContact;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact_picker_layout);

            btnRetrive = (Button) findViewById(R.id.btnRetrive);
            btnRetrive.setOnClickListener(this);
            tvContact=(TextView)findViewById(R.id.tvContact);
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            // Opening Contacts Window as a Window
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);

            startActivityForResult(intent, PICK);
        }

        @Override
        public void onActivityResult(int reqCode, int resultCode, Intent data) {
            super.onActivityResult(reqCode, resultCode, data);
            switch (reqCode) {
                case (PICK):
                    if (resultCode == Activity.RESULT_OK) {
                        Uri contactData = data.getData();
                        Cursor c = managedQuery(contactData, null, null, null, null);
                        if (c.moveToFirst()) {
                            c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            tvContact.setText(""+c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                        }
                    }
                    break;
            }
        }
    }
