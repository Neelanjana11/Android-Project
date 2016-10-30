package com.neelanjana.registration;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbOthers;
    private TextView tvMandatory;
    private Button btnSubmit;

    public void register(View view){
            String first = etFname.getText().toString().trim();
            String last = etLname.getText().toString().trim();
            String address = etAddress.getText().toString();
            String email = etEmail.getText().toString().trim();
            String pswd = etPswd.getText().toString();
//            double pswd = Double.parseDouble(etPswd.getText().toString());
            String repswd = etRePswd.getText().toString();
  //          double repswd =  Double.parseDouble(etRePswd.getText().toString());
            String phone = etPhone.getText().toString();
    //        double phone = Double.parseDouble(etPhone.getText().toString());
            String date1 = etDate.getText().toString();
            String month1 = etMonth.getText().toString();
             String year1 = etYear.getText().toString();
        int dateI =0;
        int monthI =0;
        int yearI=0;

        try {
            dateI = Integer.parseInt(etDate.getText().toString());

            monthI = Integer.parseInt(etMonth.getText().toString());

            yearI = Integer.parseInt(etYear.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

            Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.shake);

             Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int date = c.get(Calendar.DAY_OF_YEAR);
            int month = c.get(Calendar.DAY_OF_MONTH);
            int year = c.get(Calendar.YEAR);

            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            String name = "[a-z]";

             rgButton = (RadioGroup) findViewById(R.id.rgButton);
             int selectedId = rgButton.getCheckedRadioButtonId();
        try{
            if(first.length()==0){
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
            else if(phone.length()==0){
                Toast.makeText(getBaseContext(), "Mobile Number must be of 10 digits" ,Toast.LENGTH_SHORT).show();
                etPhone.startAnimation(animation);
            }
            else if(email.length()==0 || (email.matches(emailPattern)!=true)){
                Toast.makeText(getApplicationContext(), "Enter a valid email id", Toast.LENGTH_SHORT).show();
                etEmail.startAnimation(animation);
            }
            else if(pswd.length() < 6){
                Toast.makeText(getBaseContext(), "Password must be at least 6 characters" ,Toast.LENGTH_SHORT).show();
                etPswd.startAnimation(animation);
            }
     /*       else if(repswd.equals(pswd)){
                Toast.makeText(getBaseContext(), "Re enter the password correcty" , Toast.LENGTH_SHORT).show();
                etPswd.startAnimation(animation);
                etRePswd.startAnimation(animation);
            }*/
            else if(repswd.length() < 0){
                Toast.makeText(getBaseContext(), "Please Re enter the password" , Toast.LENGTH_SHORT).show();
                etRePswd.startAnimation(animation);
            }
            else if(selectedId == -1){
                Toast.makeText(getBaseContext(), "Please select a gender" ,Toast.LENGTH_SHORT).show();
                rgButton.startAnimation(animation);
            }
            else if((first.length()==0)&&(last.length()==0)&&(date1.length() == 0)&&(month1.length() == 0)&&(year1.length() == 0)
                        &&(address.length()==0)&&(phone.length()==0)&&(email.length()==0)&&(pswd.length()==0)&&(repswd.length()==0)&&(selectedId == -1)){
                Toast.makeText(getBaseContext(), "All the fields are mandatory" ,Toast.LENGTH_SHORT).show();
                tvMandatory.startAnimation(animation);
            }
            else{
                Toast.makeText(getBaseContext(), "Registration is successful" ,Toast.LENGTH_SHORT).show();
                sendEmail();
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        catch (Exception e){
            Toast.makeText(getBaseContext(), "All the fields are mandatory...Please enter the valid Data" ,Toast.LENGTH_SHORT).show();
        }
    }

    public void sendEmail() {
        try {
            String to = etEmail.getText().toString();
            String subject = "Successful Registration";
            String message = "Registration is Successful. Welcome to our Webpage";
            SendMailActivity sm = new SendMailActivity(this, to, subject, message);
            sm.execute();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Email sending failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_layout);

        etFname = (EditText) findViewById(R.id.etFname);
        etLname = (EditText) findViewById(R.id.etLname);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPswd = (EditText) findViewById(R.id.etPswd);
        etRePswd = (EditText) findViewById(R.id.etRePswd);
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

    }
}
