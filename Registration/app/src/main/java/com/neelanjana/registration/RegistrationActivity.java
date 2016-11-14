    package com.neelanjana.registration;

    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.content.pm.PackageInstaller;
    import android.graphics.drawable.Drawable;
    import android.net.Uri;
    import android.os.AsyncTask;
    import android.os.Handler;
    import android.preference.PreferenceManager;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
    import android.widget.Button;
    import android.widget.DatePicker;
    import android.widget.EditText;
    import android.widget.LinearLayout;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Random;
    import java.util.jar.Attributes;

    public class RegistrationActivity extends AppCompatActivity {

        private EditText etFname;
        private EditText etLname;
        private EditText etDate;
        private EditText etMonth;
        private EditText etYear;
        private EditText etAddress;
        private EditText etEmail;
        private EditText etPswd;
        private EditText etRePswd;
        private EditText etPhone;
        private RadioGroup rgButton;
        private TextView tvMandatory;
        private Button btnClick;
        private Button btnSubmit;
        private LinearLayout llReg;
        private RadioButton rbMale;
        private RadioButton rbFemale;
        private RadioButton rbOthers;
        public static final String FName = "FNAME";
        public static final String LName = "LNAME";
        public static final String Email = "EMAIL";
        public static final String Date = "DATE";
        public static final String Month = "MONTH";
        public static final String Year = "YEAR";
        public static final String Address = "ADDRESS";
        public static final String Mobile = "MOBILE";
        public static final String Password = "PSWD";
        public static final String Male = "Male";
        public static final String Female = "Female";
        public static final String Others = "Others";



        String first;
        String last;
        String address;
        String email;
        String phone;
        String date1;
        String month1;
        String year1;
        int dateI =0;
        int monthI =0;
        int yearI=0;
        int phoneI = 0;
        public SharedPreferences sharedPreferences;
        SessionManager session;
        LoginActivity log = new LoginActivity();

        private String randomString;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration_layout);

            session = new SessionManager(getApplicationContext());


            etFname = (EditText) findViewById(R.id.etFname);
            etLname = (EditText) findViewById(R.id.etLname);
            etEmail = (EditText) findViewById(R.id.etEmail);
            //        etPswd = (EditText) findViewById(R.id.etPswd);
            //        etRePswd = (EditText) findViewById(R.id.etRePswd);
            etPhone = (EditText) findViewById(R.id.etPhone);
            rgButton = (RadioGroup) findViewById(R.id.rgButton);
            rbMale = (RadioButton) findViewById(R.id.rbMale);
            rbFemale = (RadioButton) findViewById(R.id.rbFemale);
            rbOthers = (RadioButton) findViewById(R.id.rbOthers);
            btnSubmit = (Button) findViewById(R.id.btnSubmit);
            etDate = (EditText) findViewById(R.id.etDate);
            etMonth = (EditText) findViewById(R.id.etMonth);
            etYear = (EditText) findViewById(R.id.etYear);
            etAddress = (EditText) findViewById(R.id.etAddress);
            tvMandatory = (TextView) findViewById(R.id.tvMandatory);
            llReg = (LinearLayout) findViewById(R.id.llReg);
            llReg.setBackgroundResource(R.drawable.background);
            btnClick = (Button) findViewById(R.id.btnClick);

            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            sharedPreferences = getSharedPreferences("Reg",MODE_PRIVATE);

            load();

            /*tvClick.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });*/
        }

        public void register(View view){
            first = etFname.getText().toString().trim();
            last = etLname.getText().toString().trim();
            address = etAddress.getText().toString();
            email = etEmail.getText().toString().trim();
            //        String pswd = etPswd.getText().toString();
            //        String repswd = etRePswd.getText().toString();
            phone = etPhone.getText().toString();
            date1 = etDate.getText().toString();
            month1 = etMonth.getText().toString();
            year1 = etYear.getText().toString();


            try {
                dateI = Integer.parseInt(etDate.getText().toString());

                monthI = Integer.parseInt(etMonth.getText().toString());

                yearI = Integer.parseInt(etYear.getText().toString());

                phoneI = Integer.parseInt(etPhone.getText().toString());
    //            pswdI = Double.parseDouble(etPswd.getText().toString());
    //            repswdI =  Double.parseDouble(etRePswd.getText().toString());
            }catch (NumberFormatException e){
                e.printStackTrace();
            }


            Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);

                 Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                int date = c.get(Calendar.DAY_OF_YEAR);
                int month = c.get(Calendar.DAY_OF_MONTH);
                int year = c.get(Calendar.YEAR);

                 rgButton = (RadioGroup) findViewById(R.id.rgButton);
                 int selectedId = rgButton.getCheckedRadioButtonId();
            try{
                if((first.length()==0)&&(last.length()==0)&&(date1.length() == 0)&&(month1.length() == 0)&&(year1.length() == 0)
                        &&(address.length()==0)&&(phone.length()==0)&&(email.length()==0)&&(selectedId == -1)){
                    Toast.makeText(getBaseContext(), "All the fields are mandatory" ,Toast.LENGTH_SHORT).show();
                    tvMandatory.startAnimation(animation);
                }
                else if(first.length()==0){
                    Toast.makeText(getApplicationContext(), "Enter the first name ", Toast.LENGTH_SHORT).show();
                    etFname.startAnimation(animation);
                }

                else if (last.length()==0){
                    Toast.makeText(getApplicationContext(), "Enter the last name ", Toast.LENGTH_SHORT).show();
                    etLname.startAnimation(animation);
                }

                else if(date1.length() == 0){
                    Toast.makeText(getBaseContext(), "Enter your date of birth" ,Toast.LENGTH_SHORT).show();
                    etDate.startAnimation(animation);
                }
                else if(month1.length() == 0){
                    Toast.makeText(getBaseContext(), "Enter your month" ,Toast.LENGTH_SHORT).show();
                    etMonth.startAnimation(animation);
                }
                else if(year1.length() == 0){
                    Toast.makeText(getBaseContext(), "Enter your YEAR" ,Toast.LENGTH_SHORT).show();
                    etYear.startAnimation(animation);
                }
                else if((year - yearI) < 16 ){
                    Toast.makeText(getBaseContext(), "Age should be greater than 16" ,Toast.LENGTH_SHORT).show();
                    etYear.startAnimation(animation);
                }
                else if(monthI > 12 || monthI <1){
                    Toast.makeText(getBaseContext(), "Enter a valid date of birth" ,Toast.LENGTH_SHORT).show();
                    etMonth.startAnimation(animation);
                }
                else if(dateI > 31 || dateI <1){
                    Toast.makeText(getBaseContext(), "Enter a valid date of birth" ,Toast.LENGTH_SHORT).show();
                    etDate.startAnimation(animation);
                }
                else if((monthI == 02 && (yearI%4==0||yearI%400 == 0) && dateI>29)||(monthI == 02 && dateI>28)){
                    Toast.makeText(getBaseContext(), "Enter a valid date of birth" ,Toast.LENGTH_SHORT).show();
                    etDate.startAnimation(animation);
                }
                else if (yearI>year){
                    Toast.makeText(getBaseContext(), "Enter a valid year" ,Toast.LENGTH_SHORT).show();
                    etYear.startAnimation(animation);
                }
                else if((date1.length()==1)||(month1.length()==1)||(year1.length()==1)||(year1.length()==2)||(year1.length()==3)){
                    Toast.makeText(getBaseContext(), "Enter the date in the correct format" ,Toast.LENGTH_SHORT).show();
                    etDate.startAnimation(animation);
                    etMonth.startAnimation(animation);
                    etYear.startAnimation(animation);
                }

                else if(address.length()==0){
                    Toast.makeText(getBaseContext(), "Enter your address" ,Toast.LENGTH_SHORT).show();
                    etAddress.startAnimation(animation);
                }
                else if(phone.length()==0 || phone.length()>10){
                    Toast.makeText(getBaseContext(), "Mobile Number must be of 10 digits" ,Toast.LENGTH_SHORT).show();
                    etPhone.startAnimation(animation);
                }
                else if(email.length()==0){
                    Toast.makeText(getApplicationContext(), "Enter a valid email id", Toast.LENGTH_SHORT).show();
                    etEmail.startAnimation(animation);
                }
                else if(isEmailValid(etEmail.getText().toString()) == false){
                //    Toast.makeText(getApplicationContext(), "Enter a valid email id", Toast.LENGTH_SHORT).show();
                    etEmail.setError("Enter a valid email id");
                    etEmail.startAnimation(animation);
                }
    /*            else if(pswd.length() < 6){
                    Toast.makeText(getBaseContext(), "Password must be at least 6 characters" ,Toast.LENGTH_SHORT).show();
                    etPswd.startAnimation(animation);
                }
                else if(repswdI!=pswdI){
                    Toast.makeText(getBaseContext(), "Re enter the password correcty" , Toast.LENGTH_SHORT).show();
                    etPswd.startAnimation(animation);
                    etRePswd.startAnimation(animation);
                }
                else if(repswd.length() < 0){
                    Toast.makeText(getBaseContext(), "Please Re enter the password" , Toast.LENGTH_SHORT).show();
                    etRePswd.startAnimation(animation);
                }*/
                else if(selectedId == -1){
                    Toast.makeText(getBaseContext(), "Please select a gender" ,Toast.LENGTH_SHORT).show();
                    rgButton.startAnimation(animation);
                }
                else{
                    if (session.isLoggedIn() == false) {

                        Toast.makeText(getBaseContext(), "Registration is successful", Toast.LENGTH_SHORT).show();
                        shared();
                        sendEmail();

                        Intent i = new Intent(getApplicationContext(), EmailSplashActivity.class);
                        startActivity(i);
                    }else if((email).equals(log.uEmail)==false){
                    //    Toast.makeText(getBaseContext(),log.uEmail, Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(getBaseContext(), email, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getBaseContext(), "You have changed your Email-id", Toast.LENGTH_SHORT).show();
                        shared();
                        sendEmail();

                        Intent i = new Intent(getApplicationContext(), EmailSplashActivity.class);
                        startActivity(i);
                        Toast.makeText(getBaseContext(), "Please Log in", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(FName,etFname.getText().toString());
                        editor.putString(LName,etLname.getText().toString());
                        editor.putString(Email,etEmail.getText().toString());
                        editor.putString(Mobile,etPhone.getText().toString());
                        editor.putString(Date,etDate.getText().toString());
                        editor.putString(Month,etMonth.getText().toString());
                        editor.putString(Year,etYear.getText().toString());
                        editor.putString(Address,etAddress.getText().toString());
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            catch (Exception e){
                Toast.makeText(getBaseContext(), "All the fields are mandatory...Please enter the valid Data" ,Toast.LENGTH_SHORT).show();
            }
        }

        boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        public void sendEmail() {
            Random generator = new Random();
            randomString = new String();
            char tempChar;
            for (int i = 0; i < 7; i++){
                tempChar = (char) (generator.nextInt(96) + 32);
                randomString = randomString + "" + tempChar;
            }

            try {
                String to = etEmail.getText().toString();
                String subject = "Successful Registration";
                String message = "Registration is Successful. Welcome to our Webpage" + "\n Your password is : " + randomString;
                SendMailActivity sm = new SendMailActivity(this, to, subject, message);
                sm.execute();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Email sending failed", Toast.LENGTH_SHORT).show();
            }
        }

        public void shared(){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(FName,etFname.getText().toString());
            editor.putString(LName,etLname.getText().toString());
            editor.putString(Email,etEmail.getText().toString());
            editor.putString(Mobile,etPhone.getText().toString());
            editor.putString(Date,etDate.getText().toString());
            editor.putString(Month,etMonth.getText().toString());
            editor.putString(Year,etYear.getText().toString());
            editor.putString(Address,etAddress.getText().toString());
            editor.putBoolean(Male,rbMale.isChecked());
            editor.putBoolean(Female,rbFemale.isChecked());
            editor.putBoolean(Others,rbOthers.isChecked());
            editor.putString(Password,randomString);
            editor.commit();
        }

        public void load(){

            etFname.setText(sharedPreferences.getString(FName,etFname.getText().toString()));
            etLname.setText(sharedPreferences.getString(LName,etLname.getText().toString()));
            etDate.setText(sharedPreferences.getString(Date,etDate.getText().toString()));
            etMonth.setText(sharedPreferences.getString(Month,etMonth.getText().toString()));
            etYear.setText(sharedPreferences.getString(Year,etYear.getText().toString()));
            etAddress.setText(sharedPreferences.getString(Address,etAddress.getText().toString()));
            etPhone.setText(sharedPreferences.getString(Mobile,etPhone.getText().toString()));
            etEmail.setText(sharedPreferences.getString(Email,etEmail.getText().toString()));
            rbMale.setChecked(sharedPreferences.getBoolean("Male", false));
            rbFemale.setChecked(sharedPreferences.getBoolean("Female", false));
            rbOthers.setChecked(sharedPreferences.getBoolean("Others", false));

        }

        @Override
        protected void onStart() {
            super.onStart();
            load();
        }

        @Override
        protected void onPause() {
            super.onPause();
            shared();
        }

        @Override
        protected void onStop() {
            super.onStop();
            shared();
        }

        @Override
        protected void onResume() {
            super.onResume();
            load();
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            load();
        }

        
    }
